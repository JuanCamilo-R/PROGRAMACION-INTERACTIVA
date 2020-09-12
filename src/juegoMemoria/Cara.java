/*
 * Samuel Riascos 1922540
 * Juan Camilo Randazzo 1923948
 * Jennyfer Belalcazar 1925639
 */
package juegoMemoria;

// TODO: Auto-generated Javadoc
/**
 * The Class Cara. La clase sirve para crear caras( Imagenes que se van a visualizar en pantalla), cada Cara tiene un numero unico(Imagen que 
 * se le otroga) que se decide en la clase ControlJuego
 */
public class Cara {
	
	/** The numero. Numero que tendra la cara que representa el numero de la imagen que s visualizara en pantalla*/
	//Atributos
	int numero;
	
	/**
	 * Constructor de la clase Cara, recibe un dato de tipo int el cual se decide en clase ControlJuego
	 * Instantiates a new cara.
	 *
	 * @param numeroRecibido the numero recibido
	 */
	//Methods
	public  Cara(int numeroRecibido) {
		numero = numeroRecibido;
	}
	
	/**
	 * Retorna el numero que se le asigno a la cara
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public int getNumero(){
		return numero;
	}
}
