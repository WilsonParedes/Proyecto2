package Modulos;

public class Productos implements Utilerias{
    public int id;
    private static int sigIdProducto=2000;
    public String categoria;
    public String producto;
    public String marca;
    public int precio;


    public Productos(){
        id= sigIdProducto++;
    }

    public Productos(String categoria, String producto, String marca, int precio) {
        this();
        this.categoria = categoria;
        this.producto = producto;
        this.marca = marca;
        this.precio = precio;
    }

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

    @Override
    public String toString(){
        return "["+getNombreClase()+"]"+"\nID: "+id+"\tCategoria: "+categoria+"\tProducto: "+producto+"\tMarca: "
                +marca+"\tPrecio: Q"+precio;
    }

}


