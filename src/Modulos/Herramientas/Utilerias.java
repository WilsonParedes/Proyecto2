package Modulos.Herramientas;

public interface Utilerias {

    //METODO GENERAL ENCARGADO DE RETORNAR EL NOMBRE DE LA CLASE DONDE SE ESTA UTILIZANDO
    default String getNombreClase(){
        return this.getClass().getSimpleName();
    }

}

