package org.dam.views;

import javax.swing.*;


public class FormPanel extends JPanel {
    private JPanel mainPanel;
    private JPanel imagePreviewPanel;

    private ImagePanel imagePanel;

    public FormPanel(){
        add(mainPanel);
        setImagePanel();
    }

    private void setImagePanel(){
        imagePanel = new ImagePanel();
        imagePreviewPanel.add(imagePanel);
    }

    public ImagePanel getImagePanel(){
        return imagePanel;
    }

}
