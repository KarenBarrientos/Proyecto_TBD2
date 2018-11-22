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
    private ArrayList<Productos> listProductoss ;
    private int unid;
    

    public Pedido() {
    }

    public Pedido(ArrayList<Productos> listProductoss, int unid) {
        this.listProductoss = listProductoss;
        this.unid = unid;
    }

    public ArrayList<Productos> getListProductoss() {
        return listProductoss;
    }

    public void setListProductoss(ArrayList<Productos> listProductoss) {
        this.listProductoss = listProductoss;
    }

    public int getUnid() {
        return unid;
    }

    public void setUnid(int unid) {
        this.unid = unid;
    }

    @Override
    public String toString() {
        return "Pedido{" + "listProductos= " + listProductoss + ", unid= " + unid + '}';
    }

    
}
