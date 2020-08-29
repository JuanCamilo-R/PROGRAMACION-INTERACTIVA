package juegoMemoria;

import java.util.ArrayList;

public class PrincipalJuegoMemoria {
	
	public static void main(String[] args) {	
		
		ControlJuegoMemoria control = new ControlJuegoMemoria();
		ArrayList<Cara> carasDisponibles = new ArrayList<>();
		
		control.generarNumeros();
		control.asignarNumeroACaras();
		int carasAEscoger = 12;
		//System.out.print(carasAEscoger+"\n");
		carasDisponibles = control.carasDisponiblesRonda(carasAEscoger);
		//System.out.print(carasDisponibles.size()+"\n");
		//System.out.print(carasDisponibles.get(0).getNumero()+"\n");
		control.mostrarCarasDisponibles(carasDisponibles);
	}

}
