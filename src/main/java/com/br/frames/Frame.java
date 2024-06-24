package com.br.frames;

import com.br.builders.JLabelBuilder;
import com.br.builders.JTextFieldBuilder;
import com.br.types.DimensionGrid;
import com.br.types.JLabelGrid;
import com.br.types.JTextFieldGrid;
import com.br.types.Tipos;
import com.br.utils.CreatorName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Frame extends JFrame {

    private JTextFieldGrid inputPathFile;
    private JComboBox<String> comboBox;
    private JTextFieldGrid inputScriptNewName;
    private JButton createButton;
    private JButton clearButton;

    private final String  TITLE =  "Formatador de Script";
    private final String LABEL_UPLOAD = "Arquivo SQL:";
    private final String NOME_SCRIPT = "Nome da Tabela/Trigger/View:";
    private final String BOTAO_UPLOAD = "Upload";
    private final String ACAO_SCRIPT = "Qual ação do SCRIPT ?";


    public Frame() {

        URL iconURL = getClass().getClassLoader().getResource("imgs/img.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());


        inicializeLayoutFrame();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;


       JLabelGrid fileLabel = new JLabelBuilder()
                .setTextLabel(LABEL_UPLOAD)
                .setDimensionGrid(new DimensionGrid(0,0))
                .setHorizontalAlignment(0)
                .build();
        gbc.gridx = fileLabel.getDimensions().getX();
        gbc.gridy = fileLabel.getDimensions().getY();
        add(fileLabel, gbc);

    inputPathFile = new JTextFieldBuilder()
                .setColumns(20)
                .setDimensionGrid(new DimensionGrid(1,0))
                .build();
        gbc.gridx = inputPathFile.getDimensions().getX();
        gbc.gridy = inputPathFile.getDimensions().getY();
        add(inputPathFile, gbc);

        JButton uploadButton = getUploadButton();
        gbc.gridx = 3;
        gbc.gridy = 0;
        add(uploadButton, gbc);
//////////////////////////////////////////////////////////////////////


        JLabelGrid scriptLabel = new JLabelBuilder()
                .setTextLabel(NOME_SCRIPT)
                .setDimensionGrid(new DimensionGrid(0,1))
                .setHorizontalAlignment(0)
                .build();
        gbc.gridx = scriptLabel.getDimensions().getX();
        gbc.gridy = scriptLabel.getDimensions().getY();
        add(scriptLabel, gbc);


        this.inputScriptNewName = new JTextFieldBuilder()
                .setSize(200,50)
                .setColumns(20)
                .setDimensionGrid(new DimensionGrid(1,1))
                .build();
        gbc.gridx = inputScriptNewName.getDimensions().getX();
        gbc.gridy = inputScriptNewName.getDimensions().getY();
        add(inputScriptNewName, gbc);

    //////////////////////////////////////////////////////////

        JLabelGrid comboLabel = new JLabelBuilder()
                .setDimensionGrid(new DimensionGrid(0,2))
                .setText(ACAO_SCRIPT)
                .setHorizontalAlignment(0)
                .build();
        gbc.gridx = comboLabel.getDimensions().getX();
        gbc.gridy = comboLabel.getDimensions().getY();
        add(comboLabel, gbc);

        comboBox = new JComboBox<>();
        for (Tipos tipos : Tipos.values()) {
            comboBox.addItem(tipos.toString());
        }
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(comboBox,gbc);


        createButton = new JButton("Criar");
        CreatorName creatorName = new CreatorName();
        createButton.addActionListener(e -> {
            String filePath = inputPathFile.getText();
            String selectedElement = (String) comboBox.getSelectedItem();
            String inputText = inputScriptNewName.getText();
            Path originalPath = Paths.get(inputPathFile.getText());
            String newName = creatorName.createNameFile(Tipos.valueOf((((String) comboBox.getSelectedItem()).toUpperCase())),inputText);
            Path newPath = originalPath.getParent().resolve(newName);
            try {
                Files.copy(originalPath, newPath);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(null, "Arquivo: " + filePath + "\nTipo: " + selectedElement + "\nNovo Nome: " + newName);
        });

      gbc.gridx = 0;
        gbc.gridy = 3;
        add(createButton, gbc);

      clearButton = getClearButton();
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(clearButton, gbc);

    }

    private JButton getUploadButton() {
        JButton uploadButton = new JButton(BOTAO_UPLOAD);
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    inputPathFile.setText(selectedFile.getAbsolutePath());
                }
            }
        });
        return uploadButton;
    }
    private JButton getClearButton() {
        JButton clearButton = new JButton("Limpar");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputPathFile.setText("");
                comboBox.setSelectedIndex(0);
                inputScriptNewName.setText("");
            }
        });
        return clearButton;
    }

    public void inicializeLayoutFrame(){
        setTitle(TITLE);
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
    }
}
