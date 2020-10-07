package Modulos.DataSistema;

import Modulos.Herramientas.Utilerias;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//CLASE ENCARGADA DE AGREGAR PRODUCTOS AL SISTEMA
public class Productos implements Utilerias {
    public int id;
    private static int sigIdProducto=2000;
    public String categoria;
    public String producto;
    public String marca;
    public int precio;

    //CONSTRUCTOR VACIO ENCARGADO DE LLEVAR EL CORRELATIVO DE CADA PRODUCTO INGRESADO
    public Productos(){
        this.id= sigIdProducto++;
    }

    //CONSTRUCTOR PRINCIPAL QUE MANDA A LLAMAR AL CONSTRUCTOR VACIO
    public Productos(String categoria, String producto, String marca, int precio) {
        this();
        this.categoria = categoria;
        this.producto = producto;
        this.marca = marca;
        this.precio = precio;
    }

    //METODOS GET
    public int getId() {
        return id;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getProducto() {
        return producto;
    }
    public String getMarca() {
        return marca;
    }
    public int getPrecio() {
        return precio;
    }

    //METODOS SETT
    public void setNombreProducto(String producto){this.producto = producto; }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    //TO STRING QUE MUESTRA EN CONSOLA LOS DATOS RESPECTIVOS DE LA CLASE
    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\nID: "+id+"\tCategoria: "+categoria+"\tProducto: "+producto+"\tMarca: "
                +marca+"\tPrecio: Q"+precio;
    }

}


