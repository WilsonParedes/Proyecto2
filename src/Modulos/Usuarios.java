package Modulos;

import java.util.ArrayList;

public class Usuarios {
    private static int correlativo = 1;
    public int corr;
    public String usuario;
    public String contraseña;

    public Usuarios() {

    }

    public Usuarios(String Nombre, String Apellido, String usuario, String contraseña) {
        this.corr = correlativo++;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getCorrelativo() {return correlativo;}

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "corr=" + corr +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
