package com.br.types;

import com.br.builders.JTextFieldBuilder;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class JTextFieldGrid extends JTextField
{
    private DimensionGrid dimensions;

    public JTextFieldGrid(DimensionGrid dimensions) {
        this.dimensions = dimensions;
    }

    public JTextFieldGrid(String text, DimensionGrid dimensions) {
        super(text);
        this.dimensions = dimensions;
    }

    public JTextFieldGrid(int columns, DimensionGrid dimensions) {
        super(columns);
        this.dimensions = dimensions;
    }

    public JTextFieldGrid(String text, int columns, DimensionGrid dimensions) {
        super(text, columns);
        this.dimensions = dimensions;
    }

    public JTextFieldGrid(Document doc, String text, int columns, DimensionGrid dimensions) {
        super(doc, text, columns);
        this.dimensions = dimensions;
    }


    public JTextFieldGrid(JTextFieldBuilder builder) {
        this.dimensions = builder.getDimensionGrid();
        this.setText(builder.getText());
        //this.setDocument(builder.getDoc());
        this.setColumns(builder.getColumns());
        if (builder.getWidth()!=null || builder.getHeight()!=null) {
            this.setSize(builder.getWidth(),builder.getHeight());
        }
    }


    public DimensionGrid getDimensions() {
        return dimensions;
    }
    public void setDimensions(DimensionGrid dimensions) {
        this.dimensions = dimensions;
    }


}
