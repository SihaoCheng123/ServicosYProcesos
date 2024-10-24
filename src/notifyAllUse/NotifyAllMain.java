package notifyAllUse;
/*Imagina una carrera en la que los corredores (hilos) deben esperar hasta que el juez dé la señal de inicio(hilo principal).
Los corredores solo pueden empezar cuando el juez los despierte utilizando notifyAll()
 */

class Carrera{
    private boolean carreraIniciada = false;

    public synchronized void esperarInicio(String corredor) throws InterruptedException{
        while(!this.carreraIniciada){
            System.out.println(corredor + " está esperando al inicio de la carrera");
            wait();
        }
        System.out.println(corredor + " ha comenzado a correr");
    }

    public synchronized void iniciarCarrera(){
        this.carreraIniciada = true;
        System.out.println("El juez ha dado la señal. Carrera iniciada");
        notifyAll();
    }
}

public class NotifyAllMain {

    public static void main(String[] args) {
        Carrera carrera = new Carrera();

        Runnable corredor = () ->{
            String nombre = Thread.currentThread().getName();
            try{
                carrera.esperarInicio(nombre);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        };

        Thread corredor1 = new Thread(corredor, "corredor 1");
        Thread corredor2 = new Thread(corredor, "corredor 2");
        Thread corredor3 = new Thread(corredor, "corredor 3");

        corredor1.start();
        corredor2.start();
        corredor3.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }

        carrera.iniciarCarrera();
    }
}
