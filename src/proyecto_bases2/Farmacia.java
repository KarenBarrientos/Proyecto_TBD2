/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_bases2;

import java.util.ArrayList;

/**
 *
 * @author Karen Medina
 */
public class Farmacia {
    private String numIdentificacion;
    private String direccion;
    private ArrayList<Persona_Propietario> listPropietario= new ArrayList();
    private ArrayList<Persona_Farmaceutico> listFarmaceutico= new ArrayList();

    public Farmacia() {
    }

    public Farmacia(String numIdentificacion, String direccion, ArrayList<Persona_Propietario> listPropietario, ArrayList<Persona_Farmaceutico> listFarmaceutico) {
        this.numIdentificacion = numIdentificacion;
        this.direccion = direccion;
        this.listPropietario = listPropietario;
        this.listFarmaceutico = listFarmaceutico;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Persona_Propietario> getListPropietario() {
        return listPropietario;
    }

    public void setListPropietario(ArrayList<Persona_Propietario> listPropietario) {
        this.listPropietario = listPropietario;
    }

    public ArrayList<Persona_Farmaceutico> getListFarmaceutico() {
        return listFarmaceutico;
    }

    public void setListFarmaceutico(ArrayList<Persona_Farmaceutico> listFarmaceutico) {
        this.listFarmaceutico = listFarmaceutico;
    }

    @Override
    public String toString() {
        return "Farmacia{" + "numIdentificacion=" + numIdentificacion + ", direccion=" + direccion + ", PROPIETARIOS= " + listPropietario + ", FARMACEUTICOS= " + listFarmaceutico + '}';
    }
    
    
}
