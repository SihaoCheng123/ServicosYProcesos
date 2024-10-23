package SegundoEjemplo;

public class HiloMain {

    public static void main(String[] args) {
        MiRunable miRunable = new MiRunable();
        Thread hilo = new Thread(miRunable);
        hilo.start();
    }
}
