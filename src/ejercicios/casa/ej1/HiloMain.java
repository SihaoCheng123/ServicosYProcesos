package ejercicios.casa.ej1;

public class HiloMain {

    public static void main(String[] args) {
        Parking parking = new Parking();
        //Ya hay 3 vehiculos
        parking.addVehiculo(new Vehiculo());
        parking.addVehiculo(new Vehiculo());
        parking.addVehiculo(new Vehiculo());

        Thread sale = new Thread(()->{
            try {
                while (true) {
                    parking.salir();
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                System.out.println("Error: " + e);
            }
        });

        Thread entra = new Thread(()->{
            try {
                while(true){
                    Vehiculo vehiculo = new Vehiculo();
                    parking.entrar(vehiculo);
                    Thread.sleep(1000);
                }

            }catch (InterruptedException e){
                System.out.println("Error: " + e);
            }
        });

        entra.start();
        sale.start();


    }
}
