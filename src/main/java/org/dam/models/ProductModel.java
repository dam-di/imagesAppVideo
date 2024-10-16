package org.dam.models;

public class ProductModel {
    private String codigo;
    private String descripcion;
    private double precio;
    private String imagePath;

    public ProductModel(String codigo, String descripcion, double precio, String imagePath) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagePath = imagePath;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
