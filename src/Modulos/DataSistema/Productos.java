package Modulos.DataSistema;

import Modulos.Herramientas.Utilerias;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Productos implements Utilerias {
    public IntegerProperty id;
    private static int sigIdProducto=2000;
    public StringProperty categoria;
    public StringProperty producto;
    public StringProperty marca;
    public IntegerProperty precio;


    public Productos(){
        this.id= new SimpleIntegerProperty(sigIdProducto++);
    }

    public Productos(String categoria, String producto, String marca, int precio) {
        this();
        this.categoria = new SimpleStringProperty(categoria);
        this.producto = new SimpleStringProperty(producto);
        this.marca = new SimpleStringProperty(marca);
        this.precio = new SimpleIntegerProperty(precio);
    }

    public int getId() {
        return id.get();
    }

    public String getCategoria() {
        return categoria.get();
    }

    public String getProducto() {
        return producto.get();
    }

    public String getMarca() {
        return marca.get();
    }

    public int getPrecio() {
        return precio.get();
    }

    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\nID: "+id+"\tCategoria: "+categoria+"\tProducto: "+producto+"\tMarca: "
                +marca+"\tPrecio: Q"+precio;
    }

}


