package ejercicios.casa.ej6;

class Fabrica{
    private boolean tareaCompletada = false;

    public synchronized void empezarTrabajar(String trabajador) throws InterruptedException{
        while(!this.tareaCompletada){
            System.out.println(trabajador + " está esperando");
            wait();
        }
        System.out.println(trabajador + " ya se ha puesto a trabajar");
    }

    public synchronized void completarTarea(){
        this.tareaCompletada = true;
        System.out.println("Se ha completado la tarea inicial");
        notifyAll();
    }
}
public class hiloMain {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();

        Runnable trabajador = () ->{
          String nombre = Thread.currentThread().getName();
            try{
                fabrica.empezarTrabajar(nombre);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        };

        Thread trabajador1 = new Thread(trabajador, "Luis");
        Thread trabajador2 = new Thread(trabajador, "Marta");
        Thread trabajador3 = new Thread(trabajador, "Gabriel");

        trabajador1.start();
        trabajador2.start();
        trabajador3.start();

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
        fabrica.completarTarea();
    }
}
