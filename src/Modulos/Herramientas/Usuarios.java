package Modulos.Herramientas;

public class Usuarios {
    private static int correlativo = 1;
    public int corr;
    public String usuario;
    public String contrasenia;

    public Usuarios() {

    }

    public Usuarios(String usuario, String contrasenia) {
        this.corr = correlativo++;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }



    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "corr=" + corr +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contrasenia + '\'' +
                '}';
    }
}
