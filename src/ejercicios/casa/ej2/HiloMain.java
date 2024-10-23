package ejercicios.casa.ej2;

import java.util.LinkedList;

public class HiloMain {

    public static void main(String[] args) {

        Puente puente = new Puente();

        LinkedList<Carro> norte = new LinkedList<>();
        LinkedList<Carro> sur = new LinkedList<>();

        Thread carroN1 = new Thread(()->{
            try {
                puente.cruzarAlSur(norte, sur);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error:" + e);
            }
        });

        Thread carroN2 = new Thread(()->{
            try {
                puente.cruzarAlSur(norte, sur);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error:" + e);
            }
        });
        Thread carroS1 = new Thread(()->{
            try {
                puente.cruzarAlNorte(norte, sur);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error:" + e);
            }
        });

        Thread carroS2 = new Thread(()->{
            try {
                puente.cruzarAlNorte(norte, sur);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error:" + e);
            }
        });

        carroN1.start();
        carroN2.start();
        carroS1.start();
        carroS2.start();
    }
}
