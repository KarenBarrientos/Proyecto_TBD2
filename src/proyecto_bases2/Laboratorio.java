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

    private ArrayList<Productos> listaProd = new ArrayList();
    private ArrayList<Farmacia> listFarma = new ArrayList();
    private Date plazoEntrega;
    private double precioDiferente;
    private String id;
    private String PlazoEntrega;

    public Laboratorio() {
    }

    public Laboratorio(ArrayList<Productos> listaProd, ArrayList<Farmacia> listFarma, Date plazoEntrega, double precioDiferente) {
        this.listaProd = listaProd;
        this.listFarma = listFarma;
        this.plazoEntrega = plazoEntrega;
        this.precioDiferente = precioDiferente;
    }

    public Laboratorio(String id, String plazo_entrega, ArrayList<Productos> prod) {
        this.id = id;
        this.PlazoEntrega = plazo_entrega;
        for (int i = 0; i < 10; i++) {
            listaProd.add(prod.get(i));
        }
    }

    public ArrayList<Productos> getListaProd() {
        return listaProd;
    }

    public void setListaProd(ArrayList<Productos> listaProd) {
        this.listaProd = listaProd;
    }

    public ArrayList<Farmacia> getListFarma() {
        return listFarma;
    }

    public void setListFarma(ArrayList<Farmacia> listFarma) {
        this.listFarma = listFarma;
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
