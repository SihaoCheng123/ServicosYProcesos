package PrimerEjemplo;

public class MiHilo extends Thread{

//    run(), función que va a ejecutar lo del hilo, se llama con start()
//    sleep(), hacer una pausa y si hay error,
//    se vuelve a ejecutar -> pasarle el tiempo en ms (1000 -> 1s)

    public void run(){
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("Hilo " + i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        }


    }


}
