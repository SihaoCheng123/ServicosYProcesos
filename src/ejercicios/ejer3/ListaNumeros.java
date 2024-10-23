package ejercicios.ejer3;

import java.util.LinkedList;

public class ListaNumeros {

    private LinkedList<Integer> listaNum = new LinkedList<>();
    private int num = 0;

    public void pares() throws InterruptedException{
        synchronized (this){
            while(isPar()){
                wait();
            }
            num++;
            this.listaNum.add(num);
            System.out.println("Nº par añadido: " + num);
            notify();
        }
    }

    public void impares() throws InterruptedException{
        synchronized (this){
            while(!isPar()){
                wait();
            }
            num++;
            this.listaNum.add(num);
            System.out.println("Nº impar añadido: " + num);
            notify();
        }
    }

    public boolean isPar(){
        return this.num % 2 == 0;
    }
}
