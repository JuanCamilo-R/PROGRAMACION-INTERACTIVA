package juegoMemoria;

import java.util.Random;

public class ControlJuegoMemoria {
	//Atributos
	int ronda;
	Cara[] caras;
	
	//Methods
	public void redefinirNumeroCara() {
		caras = new Cara[12];
		int i = 0;
		Random aleatorio = new Random();
		
		
		
		caras[0].modificarNumeroCara(aleatorio.nextInt(12)+1);
		
		for(i = 1; i < 12; i++)
		{
			caras[i].modificarNumeroCara(aleatorio.nextInt(12)+1);
			for(int j = 0; j < 1; j++) {
				if(caras[i].getNumeroCara() == caras[j].getNumeroCara()) {
					i--;
				}
				
			}
		}
		
		for (int k = 0; i < 12; i++) {
			System.out.print(caras[k].getNumeroCara()+"\n");
		}
		
	}
	
}
