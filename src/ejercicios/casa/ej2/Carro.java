package ejercicios.casa.ej2;

import java.util.LinkedList;

public class Carro {

    public Carro() {
    }

    LinkedList<Carro> sinCruzar = new LinkedList<>();
    LinkedList<Carro> cruzados = new LinkedList<>();


    public void cruzar(Puente puente) throws InterruptedException{

        synchronized (this){
            while (puente.isBusy()){
                wait();
            }
            System.out.println(this.sinCruzar.getFirst() + " cruzando puente");
            this.cruzados.add(this.sinCruzar.getFirst());
            puente.setBusy(true);
            this.sinCruzar.removeFirst();

            notify();
        }
    }
}
