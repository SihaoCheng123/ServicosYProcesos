package ejercicios.ejer2;

class Contador{
    private int contador = 0;
    public synchronized void incrementar(){
        this.contador ++;
        System.out.println(this.contador);
    }
    public synchronized void decrementar(){
        this.contador --;
        System.out.println(this.contador);
    }
}

public class Ejer2 {
    public static void main(String[] args) {

        Contador contador = new Contador();

        Thread hilo1 = new Thread(()->{
            for (int i = 0; i < 10 ; i++) {
                System.out.println("Hilo 1:");
                contador.incrementar();
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }
        });

        Thread hilo2 = new Thread(()->{
            for (int i = 0; i < 10 ; i++) {
                System.out.println("Hilo 2");
                contador.decrementar();;
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }
        });

        hilo1.start();
        hilo2.start();
    }
}
