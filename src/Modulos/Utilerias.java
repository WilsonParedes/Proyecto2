package Modulos;

public interface Utilerias {


    default String getNombreClase(){
        return this.getClass().getSimpleName();
    }

}

