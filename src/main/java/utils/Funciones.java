package utils;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Funciones {

    public static Hashtable tratarArchivo() throws IOException{
        /*Este metodo devuelve un table con los datos de los empleados*/
        
        Hashtable <Integer, String[]> empleados = new Hashtable<Integer, String[]>();
        /*Aqui tenemos un table con su codigo por empleado y un string que contiene sus datos*/

        String path = "/home/administrador/Facultad/cursoJava/ejerc_extra_empleados/src/main/resources/Empleados.txt";
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String[] cadena;
            int cont = 0;
            String line = br.readLine();


            while(line != null){
                cont = cont + 1;
                cadena = line.split(",");
                empleados.put(cont, cadena);
                line = br.readLine(); //Lee la siguiente linea
                
            }

        }
        return empleados;
    
    
    }

    public static char entradaLetrada(){

        Scanner scan = new Scanner(System.in);
        String entrada;
        char letra; 
        System.out.println("Indique la letra : ");
        entrada = scan.nextLine();
       
        scan.close();
        
        letra = Character.toUpperCase(entrada.charAt(0)); //Convertimos toda entrada a mayuscula
        return letra;
    }
    

    public static void mostrarEmpleados() throws IOException{
        Hashtable <Integer, String[]> empleados = new Hashtable<Integer, String[]>();
        int aux;
        empleados = tratarArchivo(); //Tratamos el archivo
        Enumeration<Integer> claves = empleados.keys();

        System.out.println(" ");
        System.out.println("Lista de empleados");
        System.out.println("Codigo empleado - Nombre - Apellido - Fecha - Salario   ");
        while(claves.hasMoreElements()){
            
            aux = claves.nextElement();
            
            System.out.println(aux + " " +empleados.get(aux)[0] +  " " + empleados.get(aux)[1] + 
                                " " +empleados.get(aux)[2] +
                                " " + empleados.get(aux)[3]);
            System.out.println(" ");
        }


    }

    public static Period obtenerCantAños(String fecha){
        
        LocalDate tiempoAhora = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        LocalDate fechaNac = LocalDate.parse(fecha, fmt);
            

        Period periodo = Period.between(fechaNac, tiempoAhora);
       
        return periodo; //Devolvemos objeto fecha
    }

    




        
}




