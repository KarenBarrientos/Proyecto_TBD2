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
public class Prod_Infantil extends Productos{
    private String tipo;
    
    public Prod_Infantil() {
    }

    public Prod_Infantil(String tipo, String identificación, String nombre, String fabricante, double precioCosto, double precioVenta, int unidades, boolean estaProtegido) {
        super(identificación, nombre, fabricante, precioCosto, precioVenta, unidades, estaProtegido);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }

    
}
