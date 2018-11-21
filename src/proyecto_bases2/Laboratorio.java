/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_bases2;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Karen Medina
 */
public class Laboratorio {
    private ArrayList<Productos>listaProd = new ArrayList();
    private Date plazoEntrega;
    private double precioDiferente;

    public Laboratorio() {
    }

    public Laboratorio(ArrayList<Productos> listaProd, Date plazoEntrega, double precioDiferente) {
        this.listaProd = listaProd;
        this.plazoEntrega = plazoEntrega;
        this.precioDiferente = precioDiferente;
    }

    public ArrayList<Productos> getListaProd() {
        return listaProd;
    }

    public void setListaProd(ArrayList<Productos> listaProd) {
        this.listaProd = listaProd;
    }

    public Date getPlazoEntrega() {
        return plazoEntrega;
    }

    public void setPlazoEntrega(Date plazoEntrega) {
        this.plazoEntrega = plazoEntrega;
    }

    public double getPrecioDiferente() {
        return precioDiferente;
    }

    public void setPrecioDiferente(double precioDiferente) {
        this.precioDiferente = precioDiferente;
    }

    @Override
    public String toString() {
        return "Laboratorio{" + "listaProd=" + listaProd + ", plazoEntrega=" + plazoEntrega + ", precioDiferente=" + precioDiferente + '}';
    }
    
    
}
