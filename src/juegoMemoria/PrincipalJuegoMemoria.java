/*
 * Samuel Riascos 1922540
 * Juan Camilo Randazzo 1923948
 * Jennyfer Belalcazar 1925639
 */
package juegoMemoria;

import java.awt.EventQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class PrincipalJuegoMemoria. Clase para ejecutar el codigo.
 */
public class PrincipalJuegoMemoria {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {	
		//La clase Evenqueue es capaz de encolar eventos de forma asíncrona.
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				//Se crea un objeto de tipo vista para visualizar el juego
				VistaGUIJuegoMemoria miVista =  new VistaGUIJuegoMemoria();
			}
			
		});
		
	}
}
