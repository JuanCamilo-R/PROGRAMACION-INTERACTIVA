package juegoMemoria;

import java.util.Random;
import java.util.ArrayList;

public class Cara {
	
	//Atributos
	int numeroCara;
	ArrayList<int> numeros;
	Random aleatorio;
	
	//Methods
	public  Cara() {
		numeros = new ArrayList<int>();
		aleatorio = new Random();
	}
	
	public void modificarNumeroCara(int valor) {
		numeroCara = valor;
	}
	
	public void mostrar() {
		for(int i=0;i<12;i++){
			System.out.print(numeros.get(i)+" \n");
		}
	}
	
	public void generarNumeros(){
		boolean ocupado;
		while(numeros.size()<12) {
			do {
				int candidato=aleatorio.nextInt(12)+1;
				ocupado=numeros.contains(candidato);
			}while(ocupado)
			numeros.add(candidato);
		}
	}
	
	public int getNumeroCara() {
		return numeroCara;
	}

}
