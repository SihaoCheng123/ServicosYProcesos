package ejercicios.casa.ej2;


public class HiloMain {

    public static void main(String[] args) throws InterruptedException {
        Puente puente = new Puente(false);

        Carro carroN1 = new Carro("norte");
        Carro carroN2 = new Carro("norte");
        Carro carroS1 = new Carro("sur");
        Carro carroS2 = new Carro("sur");

        carroN1.cruzar(puente.isOcupado());
        carroS1.cruzar(puente.isOcupado());
        carroN2.cruzar(puente.isOcupado());
        carroS2.cruzar(puente.isOcupado());



    }
}
