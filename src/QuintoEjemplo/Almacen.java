package QuintoEjemplo;

import java.util.LinkedList;

public class Almacen {

    private LinkedList<Integer> lista = new LinkedList<>();
    private final int CAPACIDAD = 5;

    public void setElementosLista(LinkedList<Integer> listaProv){
        this.lista = listaProv;
    }

    public void producir(int valor) throws InterruptedException{
        synchronized (this){
            while(this.lista.size() == CAPACIDAD){
                wait();
            }

            this.lista.add(valor);
            System.out.println("Producido: " + valor);
            notify();
        }
    }

    public void consumir() throws InterruptedException{
        synchronized (this){
            while(this.lista.isEmpty()){
                wait();
            }
            int valor = this.lista.removeFirst();
            System.out.println("Producto consumido: " + valor);
            notify();
        }
    }
}
