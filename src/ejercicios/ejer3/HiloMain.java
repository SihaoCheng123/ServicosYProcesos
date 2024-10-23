package ejercicios.ejer3;

public class HiloMain {
    public static void main(String[] args) {
        ListaNumeros lista = new ListaNumeros();

        Thread par = new Thread(()->{
            try{
                while(true){
                    lista.pares();
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        });
        Thread impar = new Thread(()->{
            try{
                while(true){
                    lista.impares();
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        });

        par.start();
        impar.start();

    }

}
