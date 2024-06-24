package com.br.types;

import com.br.builders.JLabelBuilder;

import javax.swing.*;

public class JLabelGrid extends JLabel {
    private DimensionGrid dimensions;

    public JLabelGrid(String text, Icon icon, int horizontalAlignment, DimensionGrid dimensions) {
        super(text, icon, horizontalAlignment);
        this.dimensions = dimensions;
    }

    public JLabelGrid(String text, int horizontalAlignment, DimensionGrid dimensions) {
        super(text, horizontalAlignment);
        this.dimensions = dimensions;
    }

    public JLabelGrid(String text, DimensionGrid dimensions) {
        super(text);
        this.dimensions = dimensions;
    }

    public JLabelGrid(Icon image, int horizontalAlignment, DimensionGrid dimensions) {
        super(image, horizontalAlignment);
        this.dimensions = dimensions;
    }

    public JLabelGrid(Icon image, DimensionGrid dimensions) {
        super(image);
        this.dimensions = dimensions;
    }

    public JLabelGrid(DimensionGrid dimensions) {
        this.dimensions = dimensions;
    }


    public JLabelGrid(JLabelBuilder builder) {
        this.dimensions = builder.getDimensionGrid();
        this.setIcon(builder.getIcon());
        this.setText(builder.getText());
        this.setHorizontalAlignment(builder.getHorizontalAlignment());
    }


    public DimensionGrid getDimensions() {
        return dimensions;
    }
    public void setDimensions(DimensionGrid dimensions) {
        this.dimensions = dimensions;
    }


}
