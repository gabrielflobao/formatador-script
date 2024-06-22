package com.br.frames;

import com.br.types.Tipos;
import com.br.utils.CreatorName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Frame extends JFrame {

    private JTextField filePathField;
    private JComboBox<String> comboBox;
    private JTextField inputField;
    private JButton createButton;
    private JButton clearButton;
    private final String  TITLE =  "Formatador de Script";

    public Frame() {
        setTitle(TITLE);
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label e TextField para upload de arquivo
        JLabel fileLabel = new JLabel("Arquivo SQL:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(fileLabel, gbc);

        filePathField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(filePathField, gbc);

        JButton uploadButton = new JButton("Upload");
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePathField.setText(selectedFile.getAbsolutePath());
                }
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(uploadButton, gbc);

        // Lista suspensa (ComboBox)
        JLabel comboLabel = new JLabel("Qual ação do SCRIPT ?");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(comboLabel, gbc);

        comboBox = new JComboBox<>();
        for (Tipos tipos : Tipos.values()) {
            comboBox.addItem(tipos.toString());
        }
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(comboBox, gbc);

        // Label e Input Field
        JLabel inputLabel = new JLabel("Nome novo Script:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(inputLabel, gbc);

        inputField = new JTextField(20);
        inputField.setSize(200,50);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(inputField, gbc);

        // Botões
        createButton = new JButton("Criar");
        CreatorName creatorName = new CreatorName();
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = filePathField.getText();
                String selectedElement = (String) comboBox.getSelectedItem();
                String inputText = inputField.getText();

                Path originalPath = Paths.get(filePathField.getText());
                String newName = creatorName.createNameFile(Tipos.valueOf((((String) comboBox.getSelectedItem()).toUpperCase())),inputText);
                Path newPath = originalPath.getParent().resolve(newName);
                try {
                    Files.copy(originalPath, newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                // Adicione sua lógica aqui
                JOptionPane.showMessageDialog(null, "Arquivo: " + filePath + "\nTipo: " + selectedElement + "\nNovo Nome: " + newName);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(createButton, gbc);

        clearButton = new JButton("Limpar");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filePathField.setText("");
                comboBox.setSelectedIndex(0);
                inputField.setText("");
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(clearButton, gbc);
    }

}
