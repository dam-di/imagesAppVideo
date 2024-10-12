package org.dam.views;

import javax.swing.*;

import java.awt.event.ActionListener;

import static org.dam.controllers.FormPanelController.CREATE_PRODUCT;


public class FormPanel extends JPanel {
    private JPanel mainPanel;
    private JPanel imagePreviewPanel;
    private JButton bt_save;

    private ImagePanel imagePanel;

    public FormPanel(){
        add(mainPanel);
        setImagePanel();
        setCommands();
    }

    private void setImagePanel(){
        imagePanel = new ImagePanel();
        imagePreviewPanel.add(imagePanel);
    }

    public ImagePanel getImagePanel(){
        return imagePanel;
    }

    private void setCommands(){
        bt_save.setActionCommand(CREATE_PRODUCT);
    }

    public void addListeners(ActionListener listener){
        bt_save.addActionListener(listener);
    }

}
