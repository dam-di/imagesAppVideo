package org.dam.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static org.dam.controllers.MainFrameController.*;

public class MainFrame extends JFrame implements InterfaceView {

    private JPanel mainPanel;
    private JButton bt_init;
    private JButton bt_form;
    private JButton button3;
    private JButton bt_exit;
    private JPanel contenedorPaneles;
    private CardLayout navegador;
    private InitPanel initPanel;
    private FormPanel formPanel;

    public MainFrame(){
        initWindow();
    }

    @Override
    public void initWindow() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setCommands();
        addPanels();
    }

    public FormPanel getFormPanel(){
        return formPanel;
    }

    private void addPanels(){
        // Obtener el navegador (CardLayout)
        navegador = (CardLayout) contenedorPaneles.getLayout();

        // Instanciar paneles
        initPanel = new InitPanel();
        initPanel.setBackgroundImage("/gato.jpg");
        formPanel = new FormPanel();

        // Añadir el primer panel (inicio)
        contenedorPaneles.add(initPanel, "InitPanel");
        // Añadir el segundo panel (formulario)
        contenedorPaneles.add(formPanel, "FormPanel");
    }

    public void navegar(String nombrePanel){
        navegador.show(contenedorPaneles, nombrePanel);
    }

    @Override
    public void showWindow() {
        this.setVisible(true);
    }

    @Override
    public void closeWindow() {
        this.dispose();
    }

    @Override
    public void setCommands() {
        bt_exit.setActionCommand(CLOSE_APP);
        bt_init.setActionCommand(NAVIGATE_TO_INIT);
        bt_form.setActionCommand(NAVIGATE_TO_FORM);
    }

    @Override
    public void addListener(ActionListener listener) {
        bt_exit.addActionListener(listener);
        bt_form.addActionListener(listener);
        bt_init.addActionListener(listener);

    }

    @Override
    public void initComponents() {

    }
}
