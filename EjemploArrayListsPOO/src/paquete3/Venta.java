/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete3;

import java.util.ArrayList;

/**
 *
 * @author reroes
 */
public class Venta {

    private double valorVenta;
    private ArrayList<Computador> computadoras;

    public Venta(ArrayList<Computador> c) {
        computadoras = c;
    }

    public void establecerComputadoras(ArrayList<Computador> n) {
        computadoras = n;
    }

    public void establecerValorVenta() {
        double suma = 0;
        for (int i = 0; i < computadoras.size(); i++) {
            suma = suma + computadoras.get(i).obtenerCostoComputador();
        }
        valorVenta = suma;
    }

    public double obtenerValorVenta() {
        return valorVenta;
    }

    public ArrayList<Computador> obtenerComputadoras() {
        return computadoras;
    }

    @Override
    public String toString() {
        String cadena = "Venta de Computadoras\n";
        for (int i = 0; i < computadoras.size(); i++) {
            cadena = String.format("%sMarca: %s\n"
                    + "Nombre del Procesador: %s\n"
                    + "Costo del Procesador: %.2f\n"
                    + "Nombre de la Memoria: %s\n"
                    + "Costo de la Memoria: %.2f\n"
                    + "Valor del Computador: %.2f\n", cadena,
                     obtenerComputadoras().get(i).obtenerMarca(),
                    obtenerComputadoras().get(i).obtenerProcesador().obtenerMarca()
                    ,obtenerComputadoras().get(i).obtenerProcesador().obtenerCosto(),
                    obtenerComputadoras().get(i).obtenerMemoria().obtenerMarca(),
                    obtenerComputadoras().get(i).obtenerMemoria().obtenerCosto(),
                    obtenerComputadoras().get(i).obtenerCostoComputador());
        }
        cadena = String.format("%sValor de la Venta: %.2f\n",cadena
                , obtenerValorVenta());
        return cadena;
    }

}
