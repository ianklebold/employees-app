package utils;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class test {

    public static void main(String[] args) {
     
        // 01/01/2000
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaNac = LocalDate.parse("10-08-1999", fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        System.out.printf("Tu edad es: %s años, %s meses y %s días",
                            periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }
}
/*
BLACK BOX TESTING

INPUT --> SOFTWARE CODE --> OUT

Ingresamos datos, el software lo prueba y nos da un resultado.

UNIT TEST : Se hace el codigo y luego el test. Si no pasa los test unitarios no podemos ir
            A algo mas complicado. 

Test unitarios: Para hacerlo aplicamos un TDD (Desarrollo orientado a puebas)
                1. Escrbir un test que falle 
                2. Hacer que el codigo funciones y luego 
                3. Eliminar la redundancia






*/ 

/*

        Boolean flag = false;
        contA = -1;
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







*/