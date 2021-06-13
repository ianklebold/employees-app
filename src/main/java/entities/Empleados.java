package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Empleados {
    private String nombre;
    private String apellido;
    private String fechaNac;
    private Double salario;

    public void mostrarDatos(){

        System.out.println(" ");
        System.out.println("Datos de empleado");
        System.out.println("Apellido : " + getApellido());
        System.out.println("Nombre : " + getNombre());
        System.out.println("Fecha de nacimiento :" + getFechaNac());
        System.out.println("Salario : " + getSalario());


    }
    
    public Empleados(String nombre, String apellido, String fechaNac, Double salario) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setFechaNac(fechaNac);
        this.setSalario(salario);
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(fechaNac, formatter);
        String fechaF;
        fechaF = String.valueOf(localDateTime.getDayOfMonth())+ 
                 "-"+ String.valueOf(localDateTime.getMonthValue())+"-"+ 
                 String.valueOf(localDateTime.getYear());

        this.fechaNac = fechaF;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 


    
    
}
