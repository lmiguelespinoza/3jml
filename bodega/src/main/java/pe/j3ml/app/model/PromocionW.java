/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package pe.j3ml.app.model;

/**
 *
 * @author pepe
 */
public class PromocionW {
    private int codprod;
    private double cantidad;
    private double cantidadAdd;
    private double precioCobrar;

    public PromocionW() {
    }

    public PromocionW(int codigoProducto, double cantidad) {
        this.codprod = codigoProducto;
        this.cantidadAdd = cantidad;
        this.cantidad = 0;
        this.precioCobrar = 0.0;
    }

    /**
     * @return the codprod
     */
    public int getCodprod() {
        return codprod;
    }

    /**
     * @param codprod the codprod to set
     */
    public void setCodprod(int codprod) {
        this.codprod = codprod;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the cantidadAdd
     */
    public double getCantidadAdd() {
        return cantidadAdd;
    }

    /**
     * @param cantidadAdd the cantidadAdd to set
     */
    public void setCantidadAdd(double cantidadAdd) {
        this.cantidadAdd = cantidadAdd;
    }

    /**
     * @return the precioCobrar
     */
    public double getPrecioCobrar() {
        return precioCobrar;
    }

    /**
     * @param precioCobrar the precioCobrar to set
     */
    public void setPrecioCobrar(double precioCobrar) {
        this.precioCobrar = precioCobrar;
    }
}
