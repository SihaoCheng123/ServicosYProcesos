package ejercicios.casa.ej5;

class Hilos{
    private boolean barreraAlcanzada = false;

    public synchronized void esperarBarrera(String nombreHilo) throws InterruptedException{
        while(!this.barreraAlcanzada){
            System.out.println(nombreHilo + " está esperando a que se levante la barrera");
            wait();
        }
        System.out.println(nombreHilo + " sigue avanzando");
        notify();
    }

    public synchronized void levantarBarrera(String nombreHilo) throws InterruptedException{
        if (iniciar(nombreHilo)){
            this.barreraAlcanzada = true;
        }

        System.out.println("Barrera levantada.");
        notifyAll();
    }

    public synchronized boolean iniciar(String nombreHilo) throws InterruptedException{
        System.out.println(nombreHilo + " ha empezado a correr");
        notify();
        return true;
    }
}


public class Barrera {
    public static void main(String[] args) {
        Hilos hilos = new Hilos();

        Runnable corredor = () ->{
            String nombre = Thread.currentThread().getName();
            try {
                hilos.iniciar(nombre);
                hilos.esperarBarrera(nombre);
                hilos.levantarBarrera(nombre);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        };

        Runnable barrera = () ->{
            Thread h1 = new Thread(corredor, "Corredor 1");
            Thread h2 = new Thread(corredor, "Corredor 2");
            Thread h3 = new Thread(corredor, "Corredor 3");
            try{
                hilos.levantarBarrera(corredor);
            }catch (InterruptedException e){
                System.out.println("Error: " + e);
            }
            h1.start();
            h2.start();
            h3.start();
        }




    }


}
