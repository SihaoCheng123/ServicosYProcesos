package ejercicios.casa.ej2;

public class Carro extends Thread{
    public final String NORTE = "norte";
    private String direccion;
    public final String SUR = "sur";
    private String nombre;
    public Carro(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return nombre + " con dirección " + direccion;
    }

    public void cruzar(boolean ocupado) throws InterruptedException {
        synchronized (this){
                while(ocupado){
                    wait();
                }
                sleep(2000);
                if (this.direccion.equals(NORTE)){
                    System.out.println(toString() + " cruzando");
                    sleep(2000);
                    ocupado = true;
                    notify();
                    ocupado = false;
                    System.out.println("Cruzado con éxito");
                    this.direccion = SUR;
                }else if (this.direccion.equals(SUR)){
                    System.out.println(toString() + " cruzando");
                    sleep(2000);
                    ocupado = true;
                    notify();
                    ocupado = false;
                    System.out.println("Cruzado con éxito");
                    this.direccion = NORTE;
                }
            }
    }
}
