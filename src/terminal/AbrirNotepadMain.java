package terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbrirNotepadMain {

    public static void main(String[] args) {
        //Esta herramienta ejecuta operaciones en el sistema operativo o en el terminal
        ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
        //Ejecutar comandos en el siguiente orden
        //la c es para indicar que los siguientes parametros son los que se ejecutan


        try{
            Process proceso = processBuilder.start();
            System.out.println("Blog de notas abierto");
            int estadoSalida = proceso.waitFor();
            System.out.println("El proceso terminó con el código: " + estadoSalida);
            //Esperar a que un proceso termine y así obtener el estado de salida
            } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e);
        }

    }
}
