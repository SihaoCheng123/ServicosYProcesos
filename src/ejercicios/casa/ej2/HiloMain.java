package ejercicios.casa.ej2;


public class HiloMain {

    public static void main(String[] args) throws InterruptedException {
        Puente puente = new Puente(false);

        Carro carroN1 = new Carro("Carro 1","norte");
        Carro carroN2 = new Carro("Carro 2","norte");
        Carro carroS1 = new Carro("Carro 3","sur");
        Carro carroS2 = new Carro("Carro 4","sur");

        while(true){
            carroN1.cruzar(puente.isOcupado());
            carroS1.cruzar(puente.isOcupado());
            carroN2.cruzar(puente.isOcupado());
            carroS2.cruzar(puente.isOcupado());
        }

    }
}
