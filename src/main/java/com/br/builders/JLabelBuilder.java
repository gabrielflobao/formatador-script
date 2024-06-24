package com.br.builders;

import com.br.types.DimensionGrid;
import com.br.types.JLabelGrid;

import javax.swing.*;

public  class JLabelBuilder {

    private String text;
    private Icon icon;
    private Integer HorizontalAlignment;
    private DimensionGrid dimensionGrid;

    public  JLabelBuilder setTextLabel(String text) {
        this.text = text;
        return this;
    }

    public  JLabelBuilder setIcon(Icon icon) {
        this.icon = icon;
        return this;
    }

    public JLabelBuilder setHorizontalAlignment(Integer HorizontalAlignment) {
        this.HorizontalAlignment = HorizontalAlignment;
        return this;
    }

    public JLabelBuilder setDimensionGrid(DimensionGrid dimensionGrid) {
        this.dimensionGrid = dimensionGrid;
        return this;
    }


    public JLabelBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public JLabelBuilder(){
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public Integer getHorizontalAlignment() {
        return HorizontalAlignment;
    }

    public DimensionGrid getDimensionGrid() {
        return dimensionGrid;
    }

    public JLabelGrid build(){
     return new JLabelGrid(this);
    }

}
