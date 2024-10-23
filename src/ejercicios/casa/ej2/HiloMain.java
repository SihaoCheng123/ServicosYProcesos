package ejercicios.casa.ej2;

public class HiloMain {

    public static void main(String[] args) {

        Puente puente = new Puente();

        Thread cN1 = new Thread(()->{
            Carro carroN1 = new Carro();
            try{
                while(true){
                    carroN1.cruzar(puente);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                System.out.println("Error: " + e);
            }
        });
        Thread cN2 = new Thread(()->{
            Carro carroN2 = new Carro();
            try{
                while(true){
                    carroN2.cruzar(puente);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                System.out.println("Error: " + e);
            }
        });
        Thread cS1 = new Thread(()->{
            Carro carroS1 = new Carro();
            try{
                while(true){
                    carroS1.cruzar(puente);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                System.out.println("Error: " + e);
            }
        });
        Thread cS2 = new Thread(()->{
            Carro carroS2 = new Carro();
            try{
                while(true){
                    carroS2.cruzar(puente);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                System.out.println("Error: " + e);
            }
        });

        cN1.start();
        cN2.start();
        cS2.start();
        cS2.start();
    }
}
