package ejercicios.ejer1;

public class Ejer1 {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hilo 1: " + i);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }
        });
        Thread hilo2 = new Thread(()->{
            for (int i = 5; i <= 10; i++) {
                System.out.println("Hilo 2: " + i);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }
        });
        hilo1.start();
        hilo2.start();
    }
}
