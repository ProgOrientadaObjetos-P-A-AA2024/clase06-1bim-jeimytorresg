/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author utpl
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String marcaComputador;
        String marcaMemoria;
        double costoMemoria;
        String marcaProcesador;
        double costoProcesador;
        Procesador procesador;
        Memoria memoria;
        ArrayList<Computador> computadores = new ArrayList<>();
        int numeroComputadoras;

        // Ingreso de valores por teclado
        
        System.out.println("Ingrese el número de computadoras");
        numeroComputadoras = entrada.nextInt();

        entrada.nextLine();
        for (int i = 0; i < numeroComputadoras; i++) {
            System.out.printf("Ingrese la marca del computador %d\n", i+1);
            marcaComputador = entrada.nextLine();
            System.out.printf("Ingrese marca de memoria %d\n", i + 1);
            marcaMemoria = entrada.nextLine();
            System.out.printf("Ingrese costo de memoria %d\n", i + 1);
            costoMemoria = entrada.nextDouble();
            entrada.nextLine();

            memoria = new Memoria(marcaMemoria, costoMemoria);

            System.out.printf("Ingrese marca de procesador %d\n", i + 1);
            marcaProcesador = entrada.nextLine();
            System.out.printf("Ingrese costo de procesador %d\n", i + 1);
            costoProcesador = entrada.nextDouble();
            entrada.nextLine();

            procesador = new Procesador(marcaProcesador, costoProcesador);

            Computador compu = new Computador(marcaComputador, procesador,
                    memoria);
            compu.establecerCostoComputador();
            computadores.add(compu);
        }
        
        Venta venta = new Venta(computadores);
        venta.establecerValorVenta();
        System.out.printf("%s\n", venta);
    }
}
