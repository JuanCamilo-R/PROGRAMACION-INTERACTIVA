package juegoMemoria;
import java.util.ArrayList;
import java.util.Random;

public class ControlJuegoMemoria {
	//Atributos
	private int ronda;
	private int numeroEscogidoUsuario;
	private ArrayList<Integer> numeros = new ArrayList<>();
	private Cara[] caras;
	private Random aleatorio;
	
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
	public void mostrarCarasDisponibles(ArrayList<Cara> carasDisponibles) {
		for(int i = 0; i < carasDisponibles.size(); i++) {
			System.out.print(carasDisponibles.get(i).getNumero()+"\n");
		}
	}
	//Define las caras disponibles en cada ronda.
	public ArrayList<Cara> carasDisponiblesRonda(int cantidadCarasEscoger) {
		ArrayList<Cara> carasDisponibles = new ArrayList<>();
		for (int i = 0; i < cantidadCarasEscoger; i++) {
			carasDisponibles.add(caras[i]);
		}
		return carasDisponibles;
	}
	
	//Escoge la cara que el jugador debe adivinar.
	public int escogerCaraAJugar(ArrayList<Cara> carasDisponibles) {
		int size = carasDisponibles.size();
		return aleatorio.nextInt(size);
	
	}
	
	public boolean perdioOGano(int numeroEscogido) {
		numeroEscogidoUsuario = numeroEscogido;
		int carasAEscoger = determinarCarasAEscoger();
		ArrayList<Cara> carasDisponibles = new ArrayList<>();
		carasDisponibles = carasDisponiblesRonda(carasAEscoger);
		int numeroCara = escogerCaraAJugar(carasDisponibles);
		if(numeroEscogidoUsuario == numeroCara) {
			ronda++;
			carasDisponibles.clear();
			return true;
		}
		return false;
	}
	//Cuántas caras podemos escoger.
	public int determinarCarasAEscoger() {
		int cantidadCarasEscoger = 0;
		do {
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
			
		}while(perdioOGano(numeroEscogidoUsuario));
	}
	
	public int getCara(int indice) {
		return caras[indice].getNumero();
	}
	
}
