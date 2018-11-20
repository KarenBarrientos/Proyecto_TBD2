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
public class Productos {
    
    private String identificación; 
    private String nombre;
    private String fabricante;
    private double precioCosto;
    private double precioVenta;
    private int unidades;
    private boolean estaProtegido;

    public Productos() {
    }

    public Productos(String identificación, String nombre, String fabricante, double precioCosto, double precioVenta, int unidades, boolean estaProtegido) {
        this.identificación = identificación;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.unidades = unidades;
        this.estaProtegido = estaProtegido;
    }

    public String getIdentificación() {
        return identificación;
    }

    public void setIdentificación(String identificación) {
        this.identificación = identificación;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public boolean isEstaProtegido() {
        return estaProtegido;
    }

    public void setEstaProtegido(boolean estaProtegido) {
        this.estaProtegido = estaProtegido;
    }

    @Override
    public String toString() {
        return "Productos{" + "identificaci\u00f3n=" + identificación + ", nombre=" + nombre + ", fabricante=" + fabricante + ", precioCosto=" + precioCosto + ", precioVenta=" + precioVenta + ", unidades=" + unidades + ", estaProtegido=" + estaProtegido + '}';
    }

    
}
