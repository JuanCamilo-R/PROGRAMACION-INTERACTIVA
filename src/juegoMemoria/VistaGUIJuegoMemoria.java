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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



public class VistaGUIJuegoMemoria extends JFrame {
	private ControlJuegoMemoria controlJuego;
	private JPanel zonaJuego;
	private JLabel mensaje, imagenPrincipal;
	private JButton[] caras;
	private ImageIcon imagen;
	private Escucha escucha;
	private int cantidadAgrandar = 305;
	private int numeroEscogidoUsuario, numeroCaraJugar;
	
	public VistaGUIJuegoMemoria () {
		initGUI();
		
		//set default window config
		this.setSize(300,cantidadAgrandar);
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
		//imagen = new ImageIcon();
		mensaje = new JLabel("Observa bien las imagenes");
		imagen = new ImageIcon("src/imagenes/lupa.jpeg");
		imagenPrincipal = new JLabel(imagen);
		imagenPrincipal.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		//Numero cara a jugar.
		
		//numeroCaraJugar = controlJuego.retornarNumeroCaraJugar();
		
		contenedor.add(imagenPrincipal);
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
		for(int i = 0; i < 12; i++) {
			imagen = new ImageIcon("src/numeros/"+i+".png");
			caras[i].setPreferredSize(new Dimension(100,100));
			caras[i].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		}
	}
	
	//Timer, ejecuta la funcion voltearImagenes()
	Timer timer = new Timer (5000, new ActionListener ()
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    	controlJuego.escogerCaraAJugar();
	    	System.out.print("\n"+controlJuego.retornarNumeroCaraJugar());
	        voltearImagenes();
			imagen = new ImageIcon("src/imagenes/"+controlJuego.getCara(controlJuego.retornarNumeroCaraJugar())+".png");
			mensaje = new JLabel("¿Dónde estaba esa imagen?");
			imagenPrincipal.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			timer.stop();
	     }
	});
	
	
	private void iniciarJuego() {
		controlJuego.carasDisponiblesRonda(controlJuego.determinarCarasEscoger());
		asignarImagenesBotones();
		if(timer.isRunning()) {
			timer.restart();
		}
		else {
			timer.start();
		}
	}
	
	private void asignarImagenesBotones() {
		controlJuego.determinarCarasEscoger();
		controlJuego.generarNumeros();
		controlJuego.asignarNumeroACaras();
		for(int i = 0; i < 12; i++) {
			imagen = new ImageIcon("src/imagenes/"+controlJuego.getCara(i)+".png");
			caras[i].setPreferredSize(new Dimension(100,100));
			caras[i].addActionListener(escucha);
			caras[i].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		}
	}
	
	private class Escucha implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent eventAction) {
				
			for (int i = 0; i < 12; i++) {
				if(eventAction.getSource() == caras[i]) {
					if(controlJuego.perdioOGano(controlJuego.getCara(i))) {
						int input = JOptionPane.showConfirmDialog(null, "¿Quiere seguir jugando? Bot�n:"+i);
						if(input == 0) {
							setSize(300,cantidadAgrandar+=100);
							iniciarJuego();
						}else {
							System.exit(0);
						}
						
					}else {
						System.exit(0);
					}
				}
			}
			
		}
		

	}

}
