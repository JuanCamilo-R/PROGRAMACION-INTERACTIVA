package juegoMemoria;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PrincipalJuegoMemoria {
	
	public static void main(String[] args) {	
		/*
		ControlJuegoMemoria control = new ControlJuegoMemoria();
		ArrayList<Cara> carasDisponibles = new ArrayList<>();
		
		control.generarNumeros();
		control.asignarNumeroACaras();
		int carasAEscoger = 4;
		control.carasDisponiblesRonda(carasAEscoger);
		control.escogerCaraAJugar();
		control.mostrarCarasDisponibles();
		System.out.print("Cara a jugar: "+control.retornarNumeroCaraJugar());
		int usuarioEleccion = Integer.parseInt(JOptionPane.showInputDialog("Número a escoger: "));
		
		if(control.perdioOGano(usuarioEleccion)) {
			System.out.print("Gano \n");
		}else {
			System.out.print("Perdió \n");
		}
		*/
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				VistaGUIJuegoMemoria miVista =  new VistaGUIJuegoMemoria();
			}
			
		});
		
	}
	
}
