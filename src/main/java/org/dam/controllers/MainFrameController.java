package org.dam.controllers;

import org.dam.views.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController implements ActionListener {
    public final static String CLOSE_APP = "CLOSE_APP";
    public final static String NAVIGATE_TO_INIT = "NAVIGATE_TO_INIT";
    public final static String NAVIGATE_TO_FORM = "NAVIGATE_TO_FORM";

    private final MainFrame mainFrame;

    public MainFrameController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    private void handleCloseApp(){
        mainFrame.closeWindow();
    }

    private void handleNavigate(String nombrePanel){
        mainFrame.navegar(nombrePanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case CLOSE_APP:
                handleCloseApp();
                break;
            case NAVIGATE_TO_INIT:
                handleNavigate("InitPanel");
                break;
            case NAVIGATE_TO_FORM:
                handleNavigate("FormPanel");
                break;
        }
    }
}
