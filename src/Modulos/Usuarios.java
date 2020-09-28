package Modulos;

import java.util.ArrayList;

public class Usuarios {
    private static int correlativo = 1;
    public int corr;
    public String Nombre;
    public String Apellido;
    public String usuario;
    public String contraseña;

    public Usuarios() {

    }

    public Usuarios(String Nombre, String Apellido, String usuario, String contraseña) {
        this.corr = correlativo++;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "correlativo=" + corr +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
