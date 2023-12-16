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
 * 
 * Modificado por integrantes del grupo 2:
 * Xavier Fuentes
 * Carlos Anch
 * Felipe González
 * Sebastian Lantadilla
 * Ivan Rojas
 * 
 * ## Consideraciones

 *  En el enunciado:

 * Algunos métodos, se les cambió el nombre por uno más descriptivo que el mencionado en el enunciado.
 * Se cambiaron algunos nombres de elementos para que fueran más descriptivos a nuestro juicio.
 * No se menciona que hacer luego de el arriendo se encuentre con todas las cuotas pagadas.
 * No se menciona condición si el cliente se puede desactivar con un arriendo en curso.
 * La clase Archivos sólo existe para inicializar los ArrayList de clientes y vehículos. No se considera funciones de guardado dado que en clases se indicó que no era necesario. Se podría haber realizado la inicialización por código también, pero consideramos hacerlo mediante archivos.
 * No se menciona si puede realizarse una devolución de un vehículo.
 * No se menciona la impresión de un ticket o algo similar.
 * 
 * ## Mejoras
 * 
 * Se le pueden hacer muchas mejoras sobre todo de apariencia, como agregar imágenes o logotipos. 
 * Se pueden reemplazar los JList por tablas para mejorar un poco más la apariencia. En algunos lugares de implementó.
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
