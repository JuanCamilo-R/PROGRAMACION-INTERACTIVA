package juegoMemoria;
import java.util.ArrayList;
import java.util.Random;

public class ControlJuegoMemoria {
	//Atributos
	int ronda;
	ArrayList<Integer> numeros = new ArrayList<>();
	Cara[] caras;
	Random aleatorio;
	
	//Methods
	
	public ControlJuegoMemoria() {
		caras = new Cara[12];
		aleatorio = new Random();
	}
	
	public void generarNumeros(){
		boolean ocupado;
		int candidato;
		while(numeros.size()<12) {
			do {
				candidato=aleatorio.nextInt(12)+1;
				ocupado=numeros.contains(candidato);
			}while(ocupado);
			numeros.add(candidato);
		}
	}
	
	public void asignarNumeroACaras() {
		for( int i = 0; i < 12; i++) {
			caras[i] = new Cara(numeros.get(i));
		}
	}
	
	
}
