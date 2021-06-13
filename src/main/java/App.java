import static utils.Funciones.*;

import java.io.IOException;
import java.util.Scanner;

import entities.Empleados;



public class App {



    public static void main(String[] args) throws Exception {
        
        Service func = new Service();

        //Comienza el programa
        menu(func);
        


    }

    public static void menu(Service func) throws IOException{
        Scanner scan = new Scanner(System.in);
        String rta = "1";
        

        while(Integer.parseInt(rta) != 0){
            System.out.println(" ");
            System.out.println("Ingrese porfavor que desea realizar :");
            System.out.println("1. Listar Empleados");
            System.out.println("2. Listar Empleados en orden (Version de prueba)");
            System.out.println("3. Mostrar empleado mas viejo y mas nuevo");
            System.out.println("4. Mostrar empleados a partir de una letra");
            System.out.println("5. Mostrar empleado con mayor salario y menor salario");

            System.out.println(" ");
            System.out.println("0. Salir");

            rta = scan.nextLine();

            if(Integer.parseInt(rta) == 1){

                mostrarEmpleados();

            }else if(Integer.parseInt(rta) == 2){
                
                func.ordenarPorNA();
            
            }else if(Integer.parseInt(rta) == 3){
                
                func.obtenerJovenMayor();

            }else if(Integer.parseInt(rta) == 4){
                
                System.out.println(" ");
                System.out.println("Ingrese una letra");
                String letra = scan.nextLine();

                
                func.devolverConLetra(Character.toUpperCase(letra.charAt(0)));
            }else if(Integer.parseInt(rta) == 5){
                func.listadoPorSalario();
            }
        }
        scan.close();
        System.out.println(" ");
        System.out.println("Hasta luego!");


    }

   



    
}

