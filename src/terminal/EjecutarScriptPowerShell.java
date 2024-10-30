package terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutarScriptPowerShell {

    public static void main(String[] args) {
        //Esta herramienta ejecuta operaciones en el sistema operativo o en el terminal
        String ruta = "C:\\Users\\ALUMNO\\Desktop\\script.ps1";
        //Ejecutar el powershell. de manera segura, parametro necesario, bypass(nuetro u otro parametro), tipo de archivo, ruta
        ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe","-ExecutionPolicy", "Bypass" ,"-File", ruta);
        //Ejecutar comandos en el siguiente orden
        //la c es para indicar que los siguientes parametros son los que se ejecutan


        try{
            Process proceso = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while((linea = reader.readLine()) != null){
                System.out.println(linea);
            }
            //Esperar a que un proceso termine y así obtener el estado de salida
            int estadoSalida = proceso.waitFor();
            System.out.println("El proceso terminó con el código: " + estadoSalida);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e);
        }

    }
}
