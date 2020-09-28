package Modulos;

public class Usuarios {
    private int correlativo;
    public String usuario;
    public String contraseña;

    public Usuarios() {
        this.correlativo = correlativo++;
    }

    public Usuarios(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }


}
