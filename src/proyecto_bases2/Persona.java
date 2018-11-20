/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_bases2;

/**
 *
 * @author Karen Medina
 */
public class Persona {
    private String nombrePerson;
    private String DNI;

    public Persona() {
    }

    public Persona(String nombrePerson, String DNI) {
        this.nombrePerson = nombrePerson;
        this.DNI = DNI;
    }

    public String getNombrePerson() {
        return nombrePerson;
    }

    public void setNombrePerson(String nombrePerson) {
        this.nombrePerson = nombrePerson;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombrePerson=" + nombrePerson + ", DNI=" + DNI + '}';
    }


    
}
