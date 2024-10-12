package org.dam.controllers;

import org.dam.models.ProductModel;
import org.dam.utils.FileUtils;
import org.dam.views.FormPanel;
import org.dam.xml.XMLManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanelController implements ActionListener {
    public final static String CREATE_PRODUCT = "CREATE_PRODUCT";
    private final FormPanel formPanel;

    public FormPanelController(FormPanel formPanel) {
        this.formPanel = formPanel;
    }

    private void handleCreateProduct(){
        ProductModel p;
        try {
             p = XMLManager.getProductByCode("5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(p != null){
            JOptionPane.showMessageDialog(null,"El produco ya existe");
            return;
        }

        String imagePath = FileUtils.guardarImagen(formPanel.getImagePanel().getImagePath());
        if (imagePath == null){
            return;
        }
        ProductModel product = new ProductModel("5","Descripcion del producto", 3124, imagePath);
        if(XMLManager.createProduct(product)){
            JOptionPane.showMessageDialog(null,"Producto creado con éxito");
        }else{
            JOptionPane.showMessageDialog(null,"No se pudo crear el producto");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case CREATE_PRODUCT:
                handleCreateProduct();
                break;
            default:
                break;
        }
    }
}
