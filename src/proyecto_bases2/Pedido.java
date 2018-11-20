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
public class Pedido {
    public ArrayList<Prod_FarmaciaCasa> listProduFCasa;
    private int unidFC;
    public ArrayList<Prod_Cosmetica> listProduCosmetic;
    private int unidPC;
    public ArrayList<Prod_Infantil> listProdInfantil;
    private int unidI;
    public ArrayList<Prod_Higiene> listProdHigiene;
    private int unidH;

    public Pedido() {
    }

    public Pedido(ArrayList<Prod_FarmaciaCasa> listProduFCasa, int unidFC, ArrayList<Prod_Cosmetica> listProduCosmetic, int unidPC, ArrayList<Prod_Infantil> listProdInfantil, int unidI, ArrayList<Prod_Higiene> listProdHigiene, int unidH) {
        this.listProduFCasa = listProduFCasa;
        this.unidFC = unidFC;
        this.listProduCosmetic = listProduCosmetic;
        this.unidPC = unidPC;
        this.listProdInfantil = listProdInfantil;
        this.unidI = unidI;
        this.listProdHigiene = listProdHigiene;
        this.unidH = unidH;
    }

    public ArrayList<Prod_FarmaciaCasa> getListProduFCasa() {
        return listProduFCasa;
    }

    public void setListProduFCasa(ArrayList<Prod_FarmaciaCasa> listProduFCasa) {
        this.listProduFCasa = listProduFCasa;
    }

    public int getUnidFC() {
        return unidFC;
    }

    public void setUnidFC(int unidFC) {
        this.unidFC = unidFC;
    }

    public ArrayList<Prod_Cosmetica> getListProduCosmetic() {
        return listProduCosmetic;
    }

    public void setListProduCosmetic(ArrayList<Prod_Cosmetica> listProduCosmetic) {
        this.listProduCosmetic = listProduCosmetic;
    }

    public int getUnidPC() {
        return unidPC;
    }

    public void setUnidPC(int unidPC) {
        this.unidPC = unidPC;
    }

    public ArrayList<Prod_Infantil> getListProdInfantil() {
        return listProdInfantil;
    }

    public void setListProdInfantil(ArrayList<Prod_Infantil> listProdInfantil) {
        this.listProdInfantil = listProdInfantil;
    }

    public int getUnidI() {
        return unidI;
    }

    public void setUnidI(int unidI) {
        this.unidI = unidI;
    }

    public ArrayList<Prod_Higiene> getListProdHigiene() {
        return listProdHigiene;
    }

    public void setListProdHigiene(ArrayList<Prod_Higiene> listProdHigiene) {
        this.listProdHigiene = listProdHigiene;
    }

    public int getUnidH() {
        return unidH;
    }

    public void setUnidH(int unidH) {
        this.unidH = unidH;
    }

    @Override
    public String toString() {
        return "Pedido{" + "listProduFCasa=" + listProduFCasa + ", unidFC=" + unidFC + ", listProduCosmetic=" + listProduCosmetic + ", unidPC=" + unidPC + ", listProdInfantil=" + listProdInfantil + ", unidI=" + unidI + ", listProdHigiene=" + listProdHigiene + ", unidH=" + unidH + '}';
    }

    
}
