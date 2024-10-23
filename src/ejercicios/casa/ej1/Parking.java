package ejercicios.casa.ej1;

import java.util.LinkedList;

public class Parking {
    LinkedList<Vehiculo> parking = new LinkedList<>();
    private final int CAPACIDAD = 5;

    public void entrar(Vehiculo vehiculo) throws InterruptedException{
        synchronized (this){
            while (this.parking.size() == CAPACIDAD){
                wait();
            }
            this.parking.add(vehiculo);
            System.out.println("Coche entrando al parking");
            notify();
        }
    }

    public void salir() throws InterruptedException{
        synchronized (this){
            while(this.parking.isEmpty()){
                wait();
            }
            while (this.parking.size() == CAPACIDAD){
                this.parking.removeFirst();
                System.out.println("Coche saliendo del parking");
            }
            notify();
        }
    }

    public void addVehiculo(Vehiculo vehiculo){
        this.parking.add(vehiculo);
    }
}
