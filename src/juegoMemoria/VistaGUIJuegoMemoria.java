package juegoMemoria;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class VistaGUIJuegoMemoria extends JFrame {
	private ControlJuegoMemoria controlJuego;
	private JPanel zonaJuego;
	private JLabel mensaje, imagenLupa;
	private JButton[] caras;
	private ImageIcon imagen;
	private Escucha escucha;
	private int cantidadAAgrandar;
	
	public VistaGUIJuegoMemoria () {
		initGUI();
		
		//set default window config
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void initGUI() {
		//set up container - layout
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		//Creamos el objeto escucha y el control.
		escucha = new Escucha();
		controlJuego = new ControlJuegoMemoria();
		caras = new JButton[12];
		imagen = new ImageIcon();
		mensaje = new JLabel("Observa bien las imagenes");
		//Creamos los botones.
		for(int i = 0; i < 12; i++) {
			caras[i] = new JButton();
		}
		agregarImagenes();
		//Mostramos los botones
		for( int i = 0; i < 12; i++) {
			contenedor.add(caras[i]);
		}
	}
	
	private void agregarImagenes() {
		controlJuego.determinarCarasAEscoger();
		controlJuego.generarNumeros();
		controlJuego.asignarNumeroACaras();
		for(int i = 0; i < 12; i++) {
			imagen = new ImageIcon("src/imagenes/"+controlJuego.getCara(i)+".png");
			caras[i].setPreferredSize(new Dimension(100,100));
			caras[i].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		}
	}
	
	private class Escucha implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent eventAction) {
			// TODO Auto-generated method stub
			
		}
		

	}

}
