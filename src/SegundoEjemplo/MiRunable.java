package SegundoEjemplo;

public class MiRunable implements Runnable{

    public void run() {
        for (int i = 1; i <=5 ; i++) {
            System.out.println("Runnable hilo: " + i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        }

    }
}
