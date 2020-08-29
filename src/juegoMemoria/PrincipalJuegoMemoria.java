package juegoMemoria;

public class PrincipalJuegoMemoria {

	public static void main(String[] args) {
		
		ControlJuegoMemoria control = new ControlJuegoMemoria();
		
		Cara cara = new Cara();
		
		cara.generarNumeros();
		cara.mostrar();
		

	}

}
