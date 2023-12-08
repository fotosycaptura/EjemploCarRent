/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ejemplocarrent;

import controlador.ControladorPrincipal;
import javax.swing.JFrame;
import vista.VistaPrincipal;

/**
 *
 * @author Tom
 */
public class EjemploCarRent {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Car Rent");
        VistaPrincipal vista = new VistaPrincipal();
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(
                ventana,
                vista
        );
        
        controladorPrincipal.iniciar();
    }
}
