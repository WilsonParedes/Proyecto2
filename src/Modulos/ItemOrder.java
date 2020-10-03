package Modulos;

import java.util.Scanner;

public class ItemOrder extends DataSistema implements Utilerias {

        public int noLinea;//correlativo de la orden
        public int cantidad;
        public int pIdProducto;
        public int total;
        Productos producto= new Productos();
        Scanner leer=new Scanner(System.in);



        public ItemOrder(){}

        public ItemOrder(int noLinea, int cantidad, int pIdProducto){
            this.noLinea=noLinea;
            this.cantidad=cantidad;
            this.pIdProducto=pIdProducto;
        }

        public void getTotalItem(int pIdProducto) {

            if(!ListaProductos.isEmpty()){
                for(Productos forpr: ListaProductos){
                    if(ListaProductos.get(pIdProducto).equals(verProducto(pIdProducto))){
                        System.out.println(verprecio(pIdProducto));
                        System.out.println("Ingrese la cantidad de producto deseado: ");
                        cantidad=leer.nextInt();
                        total= verprecio(pIdProducto)*cantidad;
                        System.out.println("EL precio total es de: Q"+total);
                        break;
                    }
                }//fin del for
            }//fin del if
        }//fin del metodo

        @Override
        public String toString(){
            return "["+getNombreClase()+"]"+"\t#Orden de Compra: "+noLinea+"\tCantidad Ordenada: "+cantidad
                    +"\tCodigo Producto"+pIdProducto;
        }





    }

