import static utils.Funciones.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Service {


    public void obtenerJovenMayor() throws IOException{
        Hashtable <Integer, String[]> empleados = new Hashtable<Integer, String[]>();
        int aux;
        empleados = tratarArchivo(); //Tratamos el archivo
        Enumeration<Integer> claves = empleados.keys();

        // Traer como arreglo
        // Listar ordenado por N y A
        
        List<String[]> listArray = new ArrayList<String[]>();

        String minimo[] = {"0","0","0","0","0"};
        String maximo[] = {"0","0","0","0","0"};

        int diaMay = 0;
        int mesMay = 0;
        int añoMay = 0;

        int diaMin = 99999;
        int mesMin = 99999;
        int añoMin = 99999;

        
        while(claves.hasMoreElements()){
            Period fecha;
            aux = claves.nextElement();
            fecha = obtenerCantAños(empleados.get(aux)[2]); 
            
            if( añoMin > fecha.getYears()  ){
                diaMin = fecha.getDays();
                añoMin = fecha.getYears();
                mesMin = fecha.getMonths();

                minimo[0] = Integer.toString(aux);
                minimo[1] =  empleados.get(aux)[0];
                minimo[2] =  empleados.get(aux)[1];
                minimo[3] =  empleados.get(aux)[2];
                minimo[4] =  empleados.get(aux)[3];


            }else if( añoMin == fecha.getYears() && mesMin > fecha.getMonths() ){
                diaMin = fecha.getDays();
                añoMin = fecha.getYears();
                mesMin = fecha.getMonths();

                minimo[0] = Integer.toString(aux);
                minimo[1] =  empleados.get(aux)[0];
                minimo[2] =  empleados.get(aux)[1];
                minimo[3] =  empleados.get(aux)[2];
                minimo[4] =  empleados.get(aux)[3];



            }else if( añoMin == fecha.getYears() && mesMin == fecha.getMonths()  && 
                    diaMin > fecha.getDays() ){
                diaMin = fecha.getDays();
                añoMin = fecha.getYears();
                mesMin = fecha.getMonths();

                minimo[0] = Integer.toString(aux);
                minimo[1] =  empleados.get(aux)[0];
                minimo[2] =  empleados.get(aux)[1];
                minimo[3] =  empleados.get(aux)[2];
                minimo[4] =  empleados.get(aux)[3];

            }

            if( añoMay < fecha.getYears()  ){
                diaMay = fecha.getDays();
                añoMay = fecha.getYears();
                mesMay = fecha.getMonths();

                maximo[0] = Integer.toString(aux);
                maximo[1] =  empleados.get(aux)[0];
                maximo[2] =  empleados.get(aux)[1];
                maximo[3] =  empleados.get(aux)[2];
                maximo[4] =  empleados.get(aux)[3];


            }else if( añoMay == fecha.getYears() && mesMay < fecha.getMonths() ){
                diaMay = fecha.getDays();
                añoMay = fecha.getYears();
                mesMay = fecha.getMonths();

                maximo[0] = Integer.toString(aux);
                maximo[1] =  empleados.get(aux)[0];
                maximo[2] =  empleados.get(aux)[1];
                maximo[3] =  empleados.get(aux)[2];
                maximo[4] =  empleados.get(aux)[3];



            }else if( añoMay == fecha.getYears() && mesMay == fecha.getMonths()  && 
                    diaMay < fecha.getDays() ){
                diaMay = fecha.getDays();
                añoMay = fecha.getYears();
                mesMay = fecha.getMonths();

                maximo[0] = Integer.toString(aux);
                maximo[1] =  empleados.get(aux)[0];
                maximo[2] =  empleados.get(aux)[1];
                maximo[3] =  empleados.get(aux)[2];
                maximo[4] =  empleados.get(aux)[3];

            }

            

        }
        System.out.println(" ");
        System.out.println("Empleado mas joven");
        System.out.println("Años : "+añoMin +" Mes : "+mesMin+" Dias : "+diaMin);
        System.out.println("Codigo empleado : " + minimo[0]);
        System.out.println("Apellido : " + minimo[1]);
        System.out.println("Nombre : " + minimo[2]);
        System.out.println("Fecha de nacimiento :" + minimo[3]);
        System.out.println("Salario : " + minimo[4]);

        System.out.println(" ");
        System.out.println("Empleado mas viejo");
        System.out.println("Años : "+añoMay +" Mes : "+mesMay+" Dias : "+diaMay);
        System.out.println("Codigo empleado : " + maximo[0]);
        System.out.println("Apellido : " + maximo[1]);
        System.out.println("Nombre : " + maximo[2]);
        System.out.println("Fecha de nacimiento :" + maximo[3]);
        System.out.println("Salario : " + maximo[4]);


    }

    public void ordenarPorNA() throws IOException{

        /*
            1. Paso la lista a un arreglo que tenga
               id, nombre, apellido, fecha de nacimiento, saldo    
            
            
        */
            Hashtable <Integer, String[]> empleados = new Hashtable<Integer, String[]>();
            int aux;
            empleados = tratarArchivo(); //Tratamos el archivo
            Enumeration<Integer> claves = empleados.keys();
    
            // Traer como arreglo
            // Listar ordenado por N y A
            
            List<String[]> listArray = new ArrayList<String[]>();
            while(claves.hasMoreElements()){
                String[] arreglo = {"","","","",""}; 
                aux = claves.nextElement();
    
                arreglo[0] = String.valueOf(aux);//id
                arreglo[1] = empleados.get(aux)[0]; //nombre
                arreglo[2] = empleados.get(aux)[1]; //apellido
                arreglo[3] = empleados.get(aux)[2]; //fecha
                arreglo[4] = empleados.get(aux)[3]; //sueldo
    
                listArray.add(arreglo);
                
              
            }
    
            Boolean flag = false;
            int contA = -1;
            int contB = -1;
            
            String S1;
            String S2;
    
            for(int i = 0; i < listArray.size(); i++){
                contA = contA + 1;
                contB = 0; 
                S1 = listArray.get(i)[1]; 
                S2 = listArray.get(i)[2];
                flag = false; 
                String aux1;
                String aux2;
                while(contB < contA && flag == false){
                    
    
                    if((S1.compareToIgnoreCase(listArray.get(contB)[1]) < 0) && 
                       (S2.compareToIgnoreCase(listArray.get(contB)[2]) < 0)){
                        aux1 = listArray.get(contB)[1];
                        aux2 = listArray.get(contB)[2];
    
                        listArray.get(contB)[1] = S1;
                        listArray.get(contB)[2] = S2;
    
                        listArray.get(contA)[1] = aux1;
                        listArray.get(contA)[2] = aux2;
    
                        flag = true; 
                       }
                    contB = contB + 1;
                }
    
            }
            
            for(int i = 0; i < listArray.size(); i++){
    
                System.out.println(listArray.get(i)[1] + " " + listArray.get(i)[2]);
    
            }
        }

    public void devolverConLetra(char letra) throws IOException{
        Hashtable <Integer, String[]> empleados = new Hashtable<Integer, String[]>();
        int aux;
        empleados = tratarArchivo(); //Tratamos el archivo
        Enumeration<Integer> claves = empleados.keys();

        System.out.println(" ");
        System.out.println("Lista de empleados con apellido que empiece con : " + letra);
        System.out.println("Codigo empleado - Nombre - Apellido - Fecha - Salario   ");
        String apellido;
        char caracter;
        while(claves.hasMoreElements()){
            
            aux = claves.nextElement();
            apellido = empleados.get(aux)[1]; //Recuperamos apellido
            caracter = apellido.charAt(0);   // Recuperamos la primer letra de apellido

            //Comparacion y emision.
            if(caracter == letra){ 
            System.out.println(aux + " " +empleados.get(aux)[0] +  " " + empleados.get(aux)[1] + 
                                " " +empleados.get(aux)[2] +
                                " " + empleados.get(aux)[3]);
            System.out.println(" ");
            }
        }


    }


    public void listadoPorSalario() throws IOException{
        Hashtable <Integer, String[]> empleados = new Hashtable<Integer, String[]>();

        String minimo[] = {"0","0","0","0","0"};
        String maximo[] = {"0","0","0","0","0"};

        int aux;
        empleados = tratarArchivo(); //Tratamos el archivo
        Enumeration<Integer> claves = empleados.keys();

        
        double salario;
        double min =  Double.parseDouble(empleados.get(1)[3]);


        double max =  Double.parseDouble(empleados.get(1)[3]);

        while(claves.hasMoreElements()){
            
            aux = claves.nextElement();
            salario = Double.parseDouble(empleados.get(aux)[3]);

            if(min > salario){
            
                min = Double.parseDouble(empleados.get(aux)[3]);
                minimo[0] = Integer.toString(aux);
                minimo[1] =  empleados.get(aux)[0];
                minimo[2] =  empleados.get(aux)[1];
                minimo[3] =  empleados.get(aux)[2];
                minimo[4] =  empleados.get(aux)[3];

            }
            if(max < salario){
                
                max = Double.parseDouble(empleados.get(aux)[3]);
                maximo[0] = Integer.toString(aux);
                maximo[1] =  empleados.get(aux)[0];
                maximo[2] =  empleados.get(aux)[1];
                maximo[3] =  empleados.get(aux)[2];
                maximo[4] =  empleados.get(aux)[3];

            }

        }
        System.out.println(" ");
        System.out.println("Empleado con mayor salario : " + max);
        System.out.println("Codigo empleado : " + maximo[0]);
        System.out.println("Apellido : " + maximo[1]);
        System.out.println("Nombre : " + maximo[2]);
        System.out.println("Fecha de nacimiento :" + maximo[3]);
        System.out.println("Salario : " + maximo[4]);

        System.out.println(" ");
        System.out.println("Empleado con menor salario : " + min);
        System.out.println("Codigo empleado : " + minimo[0]);
        System.out.println("Apellido : " + minimo[1]);
        System.out.println("Nombre : " + minimo[2]);
        System.out.println("Fecha de nacimiento :" + minimo[3]);
        System.out.println("Salario : " + minimo[4]);



    }
    
}
