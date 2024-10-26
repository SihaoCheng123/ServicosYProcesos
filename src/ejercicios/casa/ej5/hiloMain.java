package ejercicios.casa.ej5;

import java.util.ArrayList;

class Corredor{
    private boolean barreraAlcanzada;
    private String nombre;

    public Corredor(String nombre) {
        this.nombre = nombre;
        this.barreraAlcanzada = false;
    }

    public boolean isBarreraAlcanzada() {
        return barreraAlcanzada;
    }

    public void setBarreraAlcanzada(boolean barreraAlcanzada) {
        this.barreraAlcanzada = barreraAlcanzada;
    }
    @Override
    public String toString() {
        return nombre;
    }
}

class Barrera{
    private boolean barreraLevantada = false;
    private ArrayList<Corredor> listaCorredores = new ArrayList<>();

    public ArrayList<Corredor> getListaCorredores() {
        return listaCorredores;
    }

    public synchronized void esperarBarrera(Corredor corredor) throws InterruptedException{
        while(!this.barreraLevantada){
            System.out.println(corredor + " está esperando a que se levante la barrera");
            corredor.setBarreraAlcanzada(true);
            wait();
        }
        System.out.println(corredor + " sigue avanzando");
        notify();
    }

    public synchronized void levantarBarrera() throws InterruptedException {

        while(!this.barreraLevantada) {
            boolean todos = false;
            for (Corredor corredor : listaCorredores) {
                todos = corredor.isBarreraAlcanzada();
            }
            this.barreraLevantada = todos;
        }
        System.out.println("Barrera levantada.");
        Thread.sleep(2000);
        notifyAll();
    }

    public synchronized void iniciar(Corredor corredor) throws InterruptedException{
        System.out.println(corredor + " ha empezado a correr");
        notify();
    }
}
public class hiloMain {
    public static void main(String[] args) throws InterruptedException {
        Barrera barrera = new Barrera();

        Runnable c1 = () ->{
            Corredor corredor1 = new Corredor("Luis");
            barrera.getListaCorredores().add(corredor1);
            try{
                barrera.iniciar(corredor1);
                Thread.sleep(1000);
                barrera.esperarBarrera(corredor1);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        };
        Runnable c2 = () ->{
            Corredor corredor2 = new Corredor("Marta");
            barrera.getListaCorredores().add(corredor2);
            try{
                barrera.iniciar(corredor2);
                Thread.sleep(3000);
                barrera.esperarBarrera(corredor2);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        };
        Runnable c3 = () ->{
            Corredor corredor3 = new Corredor("Gabriel");
            barrera.getListaCorredores().add(corredor3);
            try{
                barrera.iniciar(corredor3);
                Thread.sleep(4000);
                barrera.esperarBarrera(corredor3);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        };

       Thread c1hilo = new Thread(c1);
       Thread c2hilo = new Thread(c2);
       Thread c3hilo = new Thread(c3);

       c1hilo.start();
       c2hilo.start();
       c3hilo.start();

       Thread bar = new Thread(() ->{
           try{
               Thread.sleep(6000);
               barrera.levantarBarrera();
           } catch (Exception e) {
               System.out.println("Error: " + e);
           }
       });

       bar.start();
    }


}
