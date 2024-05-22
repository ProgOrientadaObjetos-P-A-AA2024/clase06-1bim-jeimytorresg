/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import paquete4.Empresa;

public class ArchivoLectura {

    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<Empresa> lista;

    public ArchivoLectura(String n) {
        nombreArchivo = n;

        rutaArchivo = String.format("data/%s", nombreArchivo);

        try {
            entrada = new Scanner(new File(rutaArchivo));
        } // fin de try
        catch (FileNotFoundException e) {
            System.err.println("Error al leer del archivo: " + e);

        } // fin de catch

    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt",
                obtenerNombreArchivo());
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    // establecer valores de cada línea
    // en la lista de tipo Profesor
    public void establecerLista() {
        lista = new ArrayList<>();
        File f = new File(rutaArchivo);

        if (f.exists()) {

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                // %s;%s
                
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";")));
                // ["Computación", "10,00", "Tara Hernandez|contratado"]
                //       0             1                2
                
                String nombre = linea_partes.get(0);

                String ciudad = linea_partes.get(1);
                
                Empresa emp = new Empresa(nombre, ciudad);
                lista.add(emp);

            } // fin de while
        }
    }

    public ArrayList<Empresa> obtenerLista() {

        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } // cierra el archivo

    }

    @Override
    public String toString() {
        String cadena = "Lista Empresa\n";

        for (int i = 0; i < obtenerLista().size(); i++) {
            cadena = String.format("%s%s - %s\n", cadena,
                    obtenerLista().get(i).obtenerNombre(),
                    obtenerLista().get(i).obtenerCiudad());
        }

        return cadena;
    }
}
