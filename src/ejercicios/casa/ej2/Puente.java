package ejercicios.casa.ej2;

import java.util.LinkedList;

class Carro{
    
}

public class Puente {
    
    LinkedList<Carro> puente = new LinkedList<>();
    private final int CAPACITY = 1;
    
    public void cruzarAlNorte (LinkedList<Carro> norte, LinkedList<Carro> sur) throws InterruptedException{
        synchronized(this){
            while (!puente.isEmpty()) {
                wait();
            }  
            System.out.println("Cruzando puente");
            this.puente.add(norte.getFirst());
            norte.removeFirst();
            sur.add(this.puente.getFirst());
            this.puente.removeFirst();
            System.out.println("Cruzado");
            notify();
        }
        
    }

    public void cruzarAlSur(LinkedList<Carro> norte, LinkedList<Carro> sur) throws InterruptedException{
        synchronized(this){
            while (!puente.isEmpty()) {
                wait();
            }
            System.out.println("Cruzando puente");
            this.puente.add(sur.getFirst());
            sur.removeFirst();
            norte.add(this.puente.getFirst());
            this.puente.removeFirst();
            System.out.println("Cruzado");
            notify();
        }

      
    }
}

