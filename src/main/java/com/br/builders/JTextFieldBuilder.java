package com.br.builders;

import com.br.types.DimensionGrid;
import com.br.types.JLabelGrid;
import com.br.types.JTextFieldGrid;

import javax.swing.*;
import javax.swing.text.Document;

public class JTextFieldBuilder {

    private String text;
    private Integer columns;
    private DimensionGrid dimensionGrid;
    private Document doc;
    private Integer width;
    private Integer height;

    public JTextFieldGrid build() {
        return new JTextFieldGrid(this);
    }
    public JTextFieldBuilder() {
    }
    public JTextFieldBuilder setTextField(String text) {
        this.text = text;
        return this;
    }


    public JTextFieldBuilder setDimensionGrid(DimensionGrid dimensionGrid) {
        this.dimensionGrid = dimensionGrid;
        return this;
    }


    public JTextFieldBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public JTextFieldBuilder setColumns(Integer columns) {
        this.columns = columns;
        return this;
    }
    public JTextFieldBuilder setSize(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public JTextFieldBuilder setDoc(Document doc) {
        this.doc = doc;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getText() {
        return text;
    }

    public Integer getColumns() {
        return columns;
    }

    public DimensionGrid getDimensionGrid() {
        return dimensionGrid;
    }

    public Document getDoc() {
        return doc;
    }
}






