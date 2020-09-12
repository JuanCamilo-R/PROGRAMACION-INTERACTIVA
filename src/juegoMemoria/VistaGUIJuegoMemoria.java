/*
 * Samuel Riascos 1922540
 * Juan Camilo Randazzo 1923948
 * Jennyfer Belalcazar 1925639
 */
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
import javax.swing.JOptionPane;
import javax.swing.Timer;



// TODO: Auto-generated Javadoc
/**
 * The Class VistaGUIJuegoMemoria. Se maneja toda la parte visual y los eventos
 */
public class VistaGUIJuegoMemoria extends JFrame {
	//Atributos
	
	/** The control juego. Determina el estado del juego*/
	private ControlJuegoMemoria controlJuego;
	
	/** The imagen principal. Mostrar mensajes al usuario que debe hacer y una imagen de apoyo*/
	private JLabel mensaje, imagenPrincipal;
	
	/** The caras. Arreglo de botones en los que se pondran las imagenes*/
	private JButton[] caras;
	
	/** The imagen. Para asignar las imagenes a los botones*/
	private ImageIcon imagen;
	
	/** The escucha. Para indicar que el objeto tiene un ActionListener*/
	private Escucha escucha;
	
	/** The cantidad agrandar. En cada ronda la ventana se agranda ese tamaÃ±o */
	private int cantidadAgrandar = 299;
	
	/** The numero cara jugar. Para indicar la cara que escogio el usuario  y el programa*/
	private int numeroEscogidoUsuario, numeroCaraJugar;
	
	/**
	 * Se llama al metodo initGUI y se inicia la configuracion del JFrame
	 */
	public VistaGUIJuegoMemoria () {
		initGUI();
		
		//Configuracion de la ventana
		this.setSize(300,cantidadAgrandar);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setTitle("Juego memoria");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	/**
	 * Inits the GUI.  Parte visual del programa
	 */
	private void initGUI() {
		//Configurar el contenedor y estilo
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		//Creamos el objeto escucha, el control y los labels
		escucha = new Escucha();
		controlJuego = new ControlJuegoMemoria();
		caras = new JButton[12];
		mensaje = new JLabel();
		imagen = new ImageIcon("src/imagenes/lupa.jpeg");
		imagenPrincipal = new JLabel(imagen);
		imagenPrincipal.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		//Agregamos los objetos al contenedor
		contenedor.add(imagenPrincipal);
		contenedor.add(mensaje);
		
		//Creamos los botones y le damos la accion Listener
		for(int i = 0; i < 12; i++) {
			caras[i] = new JButton();
			caras[i].addActionListener(escucha);
		}
		
		iniciarJuego();
		//Agregamos los botones al contenedor ya con las imagenes que se asignan en iniciarJuego()
				for( int i = 0; i < 12; i++) {
					contenedor.add(caras[i]);
				}
	}

	/**
	 * Iniciar juego. Se determinan las caras a Jugar, se le asignan las imagenes a los labels, y se inicia o reinicia el timer
	 */
	private void iniciarJuego() {
		this.setLocationRelativeTo(null);
		controlJuego.carasDisponiblesRonda(controlJuego.determinarCarasEscoger());
		asignarImagenesBotones();
		imagen = new ImageIcon("src/imagenes/lupa.jpeg");
		mensaje.setText("Observa bien las imagenes");
		imagenPrincipal.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		if(timer.isRunning()) {
			timer.restart();
		}
		else {
			timer.start();
		}
	}
	
	/**
	 * Asignar imagenes botones los cuales son definidos por la clase Control
	 */
	private void asignarImagenesBotones() {
		controlJuego.generarNumeros();
		controlJuego.determinarCarasEscoger();
		controlJuego.asignarNumeroACaras();
		for(int i = 0; i < 12; i++) {
			imagen = new ImageIcon("src/imagenes/"+controlJuego.getCara(i)+".png");
			caras[i].setPreferredSize(new Dimension(100,100));
			caras[i].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		}
	}
	
	/** The timer. */
	Timer timer = new Timer (30000, new ActionListener ()
	{  
	    public void actionPerformed(ActionEvent e)
	    {
	    	
	    	controlJuego.escogerCaraAJugar();
	    	//Tapa las imagenes despues de 30 segundos
	        voltearImagenes();
			imagen = new ImageIcon("src/imagenes/"+controlJuego.getCara(controlJuego.retornarNumeroCaraJugar())+".png");
			 System.out.print(numeroCaraJugar = controlJuego.retornarNumeroCaraJugar());
			mensaje.setText("En donde estaba esa imagen?");
			imagenPrincipal.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			//Despues de los 30 segundo el timer se para, cuando el usuario esoge una cara se vuelve a inicar con la funcion iniciarJuego()
			timer.stop();
	     }
	});
	
	/**
	 * Voltear imagenes. Se ponen las imagenes de los numeros, en es momento el usuario escoge una cara paraa ganar o perder
	 */
	private void voltearImagenes() {
		for(int i = 0; i < 12; i++) {
			imagen = new ImageIcon("src/numeros/"+i+".png");
			caras[i].setPreferredSize(new Dimension(100,100));
			caras[i].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		}
	}

		/**
		 * The Class Escucha. Se implementa la accion Listener
		 */
		private class Escucha implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param eventAction the event action
		 */
		@Override
		public void actionPerformed(ActionEvent eventAction) {
			//Si el tiempo no esta corriendo no se ejecutan las acciones
			if(!timer.isRunning()) {
				for (int i = 0; i < 12; i++) {
					if(eventAction.getSource() == caras[i]) {
						//Se determina la cara esocgida por el usuario es la misma cara que se escogio aleatoriamente
						if(controlJuego.perdioOGano(controlJuego.getCara(i))) {
							//Si gana se le pregunta si quiere seguir jugando
							String[] options= {"Si","No"};
							int input = JOptionPane.showOptionDialog(null, "¿Quiere seguir jugando?", "¿CONTIUAR?", 
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
							//Si quiere seguir jugando agrandamos el JFrame e iniciamos el juego
							if(input == 0) {
								if(cantidadAgrandar<=700){
									setSize(300,cantidadAgrandar+=105);
								}
								iniciarJuego();
								break;
							}else {
							//Mensaje de no querer seguir jugando, se cierra le juego
								JOptionPane.showMessageDialog(null, "Has abandonado el juego");
								System.exit(0);
							}
						}else {
						//Mensaje si las caras no coinciden
							JOptionPane.showMessageDialog(null, "Has perdido");
							System.exit(0);
						}
					}
				}

			}
		

		}
	}
}
