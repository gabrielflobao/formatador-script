package com.br;

import com.br.frames.Frame;
import com.br.types.Tipos;
import com.br.utils.CreatorName;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /*String nameFile = "T_PRODUCT";
        CreatorName creator = new CreatorName();

        String name = creator.createNameFile(Tipos.CREATE,nameFile);
        System.out.println(name);*/
       /* JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame().setVisible(true);
            }
        });

    }
}