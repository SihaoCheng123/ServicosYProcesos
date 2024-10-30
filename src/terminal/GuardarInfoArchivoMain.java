package terminal;

import java.io.File;
import java.io.IOException;

public class GuardarInfoArchivoMain {

    public static void main(String[] args) {
        //Esta herramienta ejecuta operaciones en el sistema operativo o en el terminal
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "tasklist");
        //Ejecutar comandos en el siguiente orden
        //la c es para indicar que los siguientes parametros son los que se ejecutan
        File file = new File("C:\\Users\\ALUMNO\\Desktop\\tasklist.txt");


        try{
            if (!file.exists()){
                file.createNewFile();
            }
            processBuilder.redirectOutput(file);

            Process proceso = processBuilder.start();

            int estadoSalida = proceso.waitFor();
            System.out.println("El proceso terminó con el código: " + estadoSalida);
            //Esperar a que un proceso termine y así obtener el estado de salida
            } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e);
        }

    }
}
