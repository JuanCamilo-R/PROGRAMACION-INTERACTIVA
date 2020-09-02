package juegoMemoria;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class VistaGUIJuegoMemoria extends JFrame {
	private ControlJuegoMemoria controlJuego;
	private JPanel zonaJuego;
	private JLabel mensaje, lupa;
	private JButton[] caras;
	private ImageIcon imagen;
	private Escucha escucha;
	private int cantidadAAgrandar = 305;
	
	public VistaGUIJuegoMemoria () {
		initGUI();
		
		//set default window config
		this.setSize(300,cantidadAAgrandar);
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
		imagen = new ImageIcon("src/imagenes/lupa.jpeg");
		lupa = new JLabel(imagen);
		lupa.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		contenedor.add(lupa);
		contenedor.add(mensaje);
		//Creamos los botones.
		for(int i = 0; i < 12; i++) {
			caras[i] = new JButton();
		}
		iniciarJuego();
		//Mostramos los botones con imagenes.
		for( int i = 0; i < 12; i++) {
			contenedor.add(caras[i]);
		}
		
	}
	private void voltearImagenes() {
		
	}
	
	private void iniciarJuego() {
		asignarImagenesBotones();
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		voltearImagenes();
	}
	private void asignarImagenesBotones() {
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
