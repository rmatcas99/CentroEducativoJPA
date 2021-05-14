package gui;

import java.awt.BorderLayout;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import gui.PanelValoracionMultiple.PnlValoracion;

public class VentanaPrincipal extends JFrame {

	private JTabbedPane jTabbedPane = null;
	
	private static VentanaPrincipal instance = null;
	  
	/**
	 * 
	 * @return 
	 */
	public static VentanaPrincipal getInstance () {
		if (instance == null) {
			instance = new VentanaPrincipal();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public VentanaPrincipal() {
		super("Centro Educativo");
		this.setBounds(0, 0, 600, 400);
		
		//this.setJMenuBar(new gui.MenuBar());
		
		this.setLayout(new BorderLayout());
		this.add(getPanelPrincipal(), BorderLayout.CENTER);
	}

	/**
	 * 
	 * @return
	 */
	private JTabbedPane getPanelPrincipal() {
		jTabbedPane = new JTabbedPane();
		
		jTabbedPane.add("Estudiantes", new PnlEstudiante());
		jTabbedPane.add("Valoracion Múltiple", new PnlValoracion());
		jTabbedPane.add("Seleccion Nota", new PnlSeleccionNota());
		
		return jTabbedPane;
	}
	
	/**
	 * @return the jTabbedPane
	 */
	public JTabbedPane getjTabbedPane() {
		return jTabbedPane;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaPrincipal.getInstance().setVisible(true);
	}

}
