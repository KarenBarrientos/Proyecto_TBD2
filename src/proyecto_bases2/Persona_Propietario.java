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
public class Persona_Propietario extends Persona{
    
    private boolean esPropietario;

    public Persona_Propietario() {
    }

    public Persona_Propietario(boolean esPropietario, String nombrePerson, String DNI) {
        super(nombrePerson, DNI);
        this.esPropietario = esPropietario;
    }

    public boolean isEsPropietario() {
        return esPropietario;
    }

    public void setEsPropietario(boolean esPropietario) {
        this.esPropietario = esPropietario;
    }

    @Override
    public String toString() {
        return " es Propietario= " + esPropietario;
    }

    
}
