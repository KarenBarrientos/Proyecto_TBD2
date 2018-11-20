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
public class Persona_Farmaceutico extends Persona{
    private boolean esResponsable;

    public Persona_Farmaceutico() {
    }

    public Persona_Farmaceutico(boolean esResponsable, String nombrePerson, String DNI) {
        super(nombrePerson, DNI);
        this.esResponsable = esResponsable;
    }

    public boolean isEsResponsable() {
        return esResponsable;
    }

    public void setEsResponsable(boolean esResponsable) {
        this.esResponsable = esResponsable;
    }

    @Override
    public String toString() {
        return " es Responsable= " + esResponsable;
    }
    
    
    
}
