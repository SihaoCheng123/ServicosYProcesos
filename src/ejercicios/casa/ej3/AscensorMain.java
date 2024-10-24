package ejercicios.casa.ej3;

class Ascensor{
    private int capacidad;
    public Ascensor(int capacidad) {
        this.capacidad = capacidad;
    }
    int cantidadPersonas = 0;

    public synchronized void entrarAscensor(String persona) throws InterruptedException{

        while(cantidadPersonas == this.capacidad){
            System.out.println(persona + " esperando");
            wait();
        }
        Thread.sleep(1000);
        cantidadPersonas++;
        System.out.println(persona + " ha entrado al ascensor. Cantidad de personas " + cantidadPersonas);
        notify();
    }

    public synchronized void salirAscensor(String persona) throws InterruptedException{
        while(cantidadPersonas == 0){
            wait();
        }
        Thread.sleep(1000);
        cantidadPersonas--;
        System.out.println(persona + " ha salido del ascensor Cantidad de personas " + cantidadPersonas);
        notify();
    }


}

public class AscensorMain {

    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor(3);

        Thread persona1 = new Thread(()->{
            try{
                ascensor.entrarAscensor("Persona 1");
                Thread.sleep(1000);
                ascensor.salirAscensor("Persona 1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread persona2 = new Thread(()->{
            try{
                ascensor.entrarAscensor("Persona 2");
                Thread.sleep(2000);
                ascensor.salirAscensor("Persona 2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread persona3 = new Thread(()->{
            try{
                ascensor.entrarAscensor("Persona 3");
                Thread.sleep(3000);
                ascensor.salirAscensor("Persona 3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread persona4 = new Thread(()->{
            try{
                ascensor.entrarAscensor("Persona 4");
                Thread.sleep(4000);
                ascensor.salirAscensor("Persona 4");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        persona1.start();
        persona2.start();
        persona3.start();
        persona4.start();
    }
}
