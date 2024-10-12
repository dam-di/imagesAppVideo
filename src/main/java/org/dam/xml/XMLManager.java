package org.dam.xml;

import org.dam.models.ProductModel;
import org.dam.services.XMLService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.dam.services.XMLService.ROOT_NODE;

public class XMLManager {

    public static boolean createProduct(ProductModel product){
        Document document = XMLService.loadOrCreateXML();
        if(document != null){
            try{
                Element newProduct = document.createElement("producto");
                newProduct.setAttribute("codigo", product.getCodigo());
                newProduct.setAttribute("descripcion", product.getDescripcion());
                newProduct.setAttribute("precio",String.valueOf(product.getPrecio()));
                newProduct.setAttribute("imagePath", product.getImagePath());

                NodeList nodeList = document.getElementsByTagName(ROOT_NODE);
                if(nodeList.getLength() >0){
                    Element rootElement = (Element) nodeList.item(0);
                    rootElement.appendChild(newProduct);
                    return XMLService.saveXML(document);
                }

            }catch (Exception e){
                System.out.println("Error al agregar nodo");
            }
        }
        return false;
    }
    public static ProductModel getProductByCode(String code) throws Exception {
        Document document =XMLService.loadOrCreateXML();
        if(document != null){
            try{
                NodeList nodeList = document.getElementsByTagName("producto");
                for(int i = 0; i < nodeList.getLength(); i++){
                    Element element = (Element) nodeList.item(i);
                    String codigo = element.getAttribute("codigo");
                    if(code.equals(codigo)){
                        return new ProductModel(codigo, element.getAttribute("descripcion"),
                                Double.parseDouble(element.getAttribute("precio")),element.getAttribute("imagePath"));
                    }
                }
            }catch (Exception e){
                System.out.println("Error al obtener el producto");
                throw new Exception("1, Error al obtener el producto");
            }
        }else {
            throw new Exception("2, Error al obtener el documento xml");
        }
        return null;
    }





}
