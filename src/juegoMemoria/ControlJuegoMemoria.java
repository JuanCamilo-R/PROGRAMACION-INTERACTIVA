package juegoMemoria;
import java.util.ArrayList;
import java.util.Random;

public class ControlJuegoMemoria {
	//Atributos
	private int ronda;
	private ArrayList<Integer> numeros = new ArrayList<>();
	private Cara[] caras;
	private Random aleatorio;
	private int indiceEscogido;
	private ArrayList<Cara> carasDisponibles = new ArrayList<Cara>();
	
	//Methods
	
	public ControlJuegoMemoria() {
		ronda = 1;
		caras = new Cara[12];
		aleatorio = new Random();
	}
	//Genera números aleatorios únicos.
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
	//Asigna un número único a cada cara.
	public void asignarNumeroACaras() {
		for( int i = 0; i < 12; i++) {
			caras[i] = new Cara(numeros.get(i));
		}
	}
	public void mostrarCarasDisponibles() {
		for(int i = 0; i < carasDisponibles.size(); i++) {
			System.out.print(carasDisponibles.get(i).getNumero()+"\n");
		}
	}
	//Define las caras disponibles en cada ronda.
	public void carasDisponiblesRonda(int cantidadCarasEscoger) {
		carasDisponibles.clear();
		for (int i = 0; i < cantidadCarasEscoger; i++) {
			carasDisponibles.add(caras[i]);
		}
	}
	
	//Escoge la cara que el jugador debe adivinar.
	public void escogerCaraAJugar() {
		 int size = carasDisponibles.size();
		 System.out.print("Tamano caras disponibles "+size+"\n");
		 indiceEscogido = aleatorio.nextInt(size);
	}
	public int retornarNumeroCaraJugar() {
		return indiceEscogido;
	}
	public int retornarElemento() {
		return carasDisponibles.get(indiceEscogido).getNumero();
	}
	
	public boolean perdioOGano(int numeroEscogidoUsuario) {
		int carasAEscoger = determinarCarasEscoger();
		carasDisponiblesRonda(carasAEscoger);
		if(numeroEscogidoUsuario == carasDisponibles.get(indiceEscogido).getNumero()) {
			ronda++;
			carasDisponiblesRonda(determinarCarasEscoger());
			carasDisponibles.clear();
			return true;
		}
		return false;
	}
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
	public int getCara(int indice) {
		return caras[indice].getNumero();
	}
	
}
