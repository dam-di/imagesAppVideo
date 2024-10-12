package org.dam;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import org.dam.controllers.FormPanelController;
import org.dam.controllers.ImagePanelController;
import org.dam.controllers.MainFrameController;
import org.dam.models.ProductModel;
import org.dam.views.MainFrame;
import org.dam.xml.XMLManager;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//        ProductModel product = new ProductModel("1", "Una descripcion para el video", 234, "/ruta/imagen");
//        if(XMLManager.createProduct(product)){
//            JOptionPane.showMessageDialog(null,"Producto creado con éxito");
//        }else{
//            JOptionPane.showMessageDialog(null,"Error al crear producto");
//        }

        // Establecer tema
        FlatIntelliJLaf.setup();

        MainFrame mainFrame = new MainFrame();

        // Controladores
        MainFrameController mainFrameController = new MainFrameController(mainFrame);
        ImagePanelController imagePanelController = new ImagePanelController(mainFrame.getFormPanel().getImagePanel());
        FormPanelController formPanelController = new FormPanelController(mainFrame.getFormPanel());

        // Listeners
        mainFrame.addListener(mainFrameController);
        mainFrame.getFormPanel().getImagePanel().addListeners(imagePanelController);
        mainFrame.getFormPanel().addListeners(formPanelController);

        mainFrame.showWindow();
    }
}
