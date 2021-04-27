package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JToolBar;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import model.controllers.ControladorEstudiante;
import model.entities.Estudiante;
import model.entities.TipologiaSexo;

public class PnlEstudiante extends JPanel {

	PnlDatos pnlDatos = new PnlDatos();
	Estudiante actual = new Estudiante();
	
	/**
	 * Create the panel.
	 */
	public PnlEstudiante() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		add(toolBar, gbc_toolBar);
		
		JButton jbtnBorrar = new JButton("");
		jbtnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrar();
			}
		});
		
		JButton jbtnGuardar = new JButton("");
		jbtnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		
		JButton jbtnNuevo = new JButton("");
		jbtnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vaciarCampos();
			}
		});
		
		JButton jbtnUltimo = new JButton("");
		jbtnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actual = ControladorEstudiante.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		
		JButton jbtnSiguiente = new JButton("");
		jbtnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actual = ControladorEstudiante.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		
		JButton jbtnAnterior = new JButton("");
		jbtnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actual = ControladorEstudiante.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		
		JButton jbtnPrimero = new JButton("");
		jbtnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actual = ControladorEstudiante.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		
		jbtnPrimero.setIcon(new ImageIcon(PnlEstudiante.class.getResource("/imagenes/primero.jpg")));
		toolBar.add(jbtnPrimero);
		jbtnAnterior.setIcon(new ImageIcon(PnlEstudiante.class.getResource("/imagenes/anterior.jpg")));
		toolBar.add(jbtnAnterior);
		jbtnSiguiente.setIcon(new ImageIcon(PnlEstudiante.class.getResource("/imagenes/siguiente.jpg")));
		toolBar.add(jbtnSiguiente);
		jbtnUltimo.setIcon(new ImageIcon(PnlEstudiante.class.getResource("/imagenes/ultimo.jpg")));
		toolBar.add(jbtnUltimo);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
		jbtnNuevo.setIcon(new ImageIcon(PnlEstudiante.class.getResource("/imagenes/nuevo.jpg")));
		toolBar.add(jbtnNuevo);
		jbtnGuardar.setIcon(new ImageIcon(PnlEstudiante.class.getResource("/imagenes/guardar.jpg")));
		toolBar.add(jbtnGuardar);
		jbtnBorrar.setIcon(new ImageIcon(PnlEstudiante.class.getResource("/imagenes/borrado.jpg")));
		toolBar.add(jbtnBorrar);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(pnlDatos, gbc_lblNewLabel);
		
		this.actual = ControladorEstudiante.getInstance().findPrimero();
		cargarActualEnPantalla();

	}
	
	private void cargarActualEnPantalla() {
		if (this.actual != null) {

			this.pnlDatos.setNombre(this.actual.getNombre());
			this.pnlDatos.setPrimerApellido(this.actual.getApellido1());
			this.pnlDatos.setSegundoApellido(this.actual.getApellido2());
			this.pnlDatos.setDni(this.actual.getDni());
			this.pnlDatos.setDireccion(this.actual.getDireccion());
			this.pnlDatos.setEmail(this.actual.getEmail());
			this.pnlDatos.setTelefono(this.actual.getTelefono());

			for (int i = 0; i < this.pnlDatos.getJcbSexo().getItemCount(); i++) {
				if (this.actual.getTipologiasexo().getId() == this.pnlDatos.getJcbSexo().getItemAt(i).getId()) {
					this.pnlDatos.getJcbSexo().setSelectedIndex(i);

				}
			}

			//this.pnlDatos.setImagen(this.actual.getImagen());
			//this.pnlDatos.setColor(this.actual.getColorFav());
		}
	}
	
	/**
	 * 
	 */
	private void guardar() {
		cargarActualDesdePantalla();
		boolean resultado = ControladorEstudiante.getInstance().guardar(this.actual);
		if (resultado == true && this.actual != null) {
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		} else { // Alta - nuevo
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}

	/**
	 * 
	 */
	private void vaciarCampos() {

		this.actual.setId(0);
		this.pnlDatos.setNombre("");
		this.pnlDatos.setPrimerApellido("");
		this.pnlDatos.setSegundoApellido("");
		this.pnlDatos.setDni("");
		this.pnlDatos.setDireccion("");
		this.pnlDatos.setEmail("");
		this.pnlDatos.setTelefono("");
		this.pnlDatos.getJcbSexo().setSelectedItem(null);
		//this.pnlDatos.setImagen(null);
		//this.pnlDatos.setColor("");

	}

	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
		this.actual.setNombre(this.pnlDatos.getNombre());
		this.actual.setApellido1(this.pnlDatos.getPrimerApellido());
		this.actual.setApellido2(this.pnlDatos.getSegundoApellido());
		this.actual.setDni(this.pnlDatos.getDni());
		this.actual.setDireccion(this.pnlDatos.getDireccion());
		this.actual.setEmail(this.pnlDatos.getEmail());
		this.actual.setTelefono(this.pnlDatos.getTelefono());

		TipologiaSexo t = (TipologiaSexo) this.pnlDatos.getJcbSexo().getSelectedItem();
		this.actual.setTipologiasexo(t);
//
//		this.actual.setImagen(this.pnlDatos.getImagen());
//		this.actual.setColorFav(this.pnlDatos.getColor());

	}

	/**
	 * 
	 */
	private void borrar() {
		String posiblesRespuestas[] = { "SI", "NO" };
		// En esta opciï¿½n se utiliza un showOptionDialog en el que personalizo el
		// icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Desea eliminar?", "Centro educativo",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas,
				posiblesRespuestas[1]);
		if (opcionElegida == 0) {
			ControladorEstudiante.getInstance().borrar(this.actual);

			vaciarCampos();
			JOptionPane.showMessageDialog(null, "Eliminado correctamente");

		}
	}

}
