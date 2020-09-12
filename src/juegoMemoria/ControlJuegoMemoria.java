/*
 * Samuel Riascos 1922540
 * Juan Camilo Randazzo 1923948
 * Jennyfer Belalcazar 1925639
 */
package juegoMemoria;
import java.util.ArrayList;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlJuegoMemoria. La clase controla todo el juego asigna un numero a cada cara, se determina si gano o perdio,
 * me indica que caras se le estan visualizando al usuario y determina que caras se deben escoger dependiendo de la ronda
 */
public class ControlJuegoMemoria {
	
	/** The ronda. Indica en que ronda dl juego estamos*/
	//Atributos
	private int ronda;
	
	/** The numeros. En cada indice del arreglo se guarda un numero unico que se le asignara a cada cara del juego */
	private ArrayList<Integer> numeros = new ArrayList<>();
	
	/** The caras. En cada indice se guarda un numero no repetido*/
	private Cara[] caras;
	
	/** The aleatorio. Crear los numeros aleatoriamente */
	private Random aleatorio;
	
	/** The indice escogido. Indice de la cara que se debe memorizar*/
	private int indiceEscogido;
	
	/** The caras disponibles. Array de Caras que se le visualizando al usuario*/
	private ArrayList<Cara> carasDisponibles = new ArrayList<Cara>();
	
	//Methods
	
	/**
	 * Contructor, se inicia en ronda uno, se crean las doce caras del juego y objeto de tipo aleatorio
	 * Instantiates a new control juego memoria.
	 */
	public ControlJuegoMemoria() {
		ronda = 1;
		caras = new Cara[12];
		aleatorio = new Random();
	}
	
	/**
	 * Generar numeros.  Genera números aleatorios únicos y se guarda n el array llamado numeros
	 */
	public void generarNumeros(){
		boolean ocupado;
		int candidato;
		while(numeros.size()<12) {
			do {
				candidato=aleatorio.nextInt(12);
				ocupado=numeros.contains(candidato);
			}while(ocupado);
			numeros.add(candidato);
		}
	}
	
	/**
	 * Asignar un número único a cada cara que se guardo en el array numeros
	 */
	public void asignarNumeroACaras() {
		for( int i = 0; i < 12; i++) {
			caras[i] = new Cara(numeros.get(i));
		}
	}
	
	/**
	 * Caras disponibles ronda. Define que caras se van visualizar en cada ronda
	 *
	 * @param cantidadCarasEscoger the cantidad caras escoger. Recibe como parametro cuaentas caras debe escoger dependiendo de la ronda
	 */
	public void carasDisponiblesRonda(int cantidadCarasEscoger) {
		carasDisponibles.clear();
		for (int i = 0; i < cantidadCarasEscoger; i++) {
			carasDisponibles.add(caras[i]);
		}
	}
	
	/**
	 * Escoge la cara que el jugador debe adivinar.
	 */
	public void escogerCaraAJugar() {
		 int size = carasDisponibles.size();
		 indiceEscogido = aleatorio.nextInt(size);
	}
	
	/**
	 * Retornar el indice de la cara que se debe memorizar.
	 *
	 * @return the int
	 */
	public int retornarNumeroCaraJugar() {
		return indiceEscogido;
	}
	
	/**
	 * Perdio O gano.
	 *
	 * @param numeroEscogidoUsuario, es el indice de la imagen que escogio el usuario 
	 * @return true o falso, si es true se pasa de ronda y se vuelven a esocoger las cara aleatoriamente a jugar
	 */
	public boolean perdioOGano(int numeroEscogidoUsuario) {
		int carasAEscoger = determinarCarasEscoger();
		carasDisponiblesRonda(carasAEscoger);
		if(numeroEscogidoUsuario == carasDisponibles.get(indiceEscogido).getNumero()) {
			ronda++;
			carasDisponiblesRonda(determinarCarasEscoger());
			carasDisponibles.clear();
			numeros.clear();
			return true;
		}
		return false;
	}
	
	/**
	 * Determinar caras escoger dependiendo de que ronda se esta jugando
	 *
	 * @return un tipo de dato int(cantidad caras que se van a visualizar por ronda)
	 */
	//Cuántas caras podemos escoger.
	public int determinarCarasEscoger() {
		int cantidadCarasEscoger = 0;
			switch(ronda) {
				case 1:
					cantidadCarasEscoger = 4;
					return cantidadCarasEscoger;
				case 2:
					cantidadCarasEscoger = 6;
					return cantidadCarasEscoger;
				case 3:
					cantidadCarasEscoger =  8;
					return cantidadCarasEscoger;
				case 4: 
					cantidadCarasEscoger = 10;
					return cantidadCarasEscoger;
				case 5:
					cantidadCarasEscoger = 12;
					return cantidadCarasEscoger;
				default:
					cantidadCarasEscoger = 12;
					return cantidadCarasEscoger;
			}	
	}
	
	/**
	 * Gets the cara.
	 *
	 * @param recibe un indice
	 * @return retorna el numero que se guardo en esa cara
	 */
	public int getCara(int indice) {
		return caras[indice].getNumero();
	}
	
}
