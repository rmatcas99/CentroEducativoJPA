package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import model.controllers.ControladorSexo;
import model.entities.TipologiaSexo;

import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;

public class PnlDatos extends JPanel {
	private JTextField jtfNombre;
	private JTextField jtfPrimer;
	private JTextField jtfSegundo;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelf;
	private JLabel jlblSexo;
	private JComboBox<TipologiaSexo> jcbSexo;
	

	/**
	 * Create the panel.
	 */
	public PnlDatos() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 0;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
		gbc_lblPrimerApellido.anchor = GridBagConstraints.EAST;
		gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerApellido.gridx = 0;
		gbc_lblPrimerApellido.gridy = 1;
		add(lblPrimerApellido, gbc_lblPrimerApellido);
		
		jtfPrimer = new JTextField();
		jtfPrimer.setColumns(10);
		GridBagConstraints gbc_jtfPrimer = new GridBagConstraints();
		gbc_jtfPrimer.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPrimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrimer.gridx = 1;
		gbc_jtfPrimer.gridy = 1;
		add(jtfPrimer, gbc_jtfPrimer);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		GridBagConstraints gbc_lblSegundoApellido = new GridBagConstraints();
		gbc_lblSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoApellido.anchor = GridBagConstraints.EAST;
		gbc_lblSegundoApellido.gridx = 0;
		gbc_lblSegundoApellido.gridy = 2;
		add(lblSegundoApellido, gbc_lblSegundoApellido);
		
		jtfSegundo = new JTextField();
		jtfSegundo.setColumns(10);
		GridBagConstraints gbc_jtfSegundo = new GridBagConstraints();
		gbc_jtfSegundo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSegundo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSegundo.gridx = 1;
		gbc_jtfSegundo.gridy = 2;
		add(jtfSegundo, gbc_jtfSegundo);
		
		jlblSexo = new JLabel("Sexo");
		GridBagConstraints gbc_jlblSexo = new GridBagConstraints();
		gbc_jlblSexo.anchor = GridBagConstraints.EAST;
		gbc_jlblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jlblSexo.gridx = 0;
		gbc_jlblSexo.gridy = 3;
		add(jlblSexo, gbc_jlblSexo);
		
		jcbSexo = new JComboBox();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 0);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 3;
		add(jcbSexo, gbc_jcbSexo);
		
		JLabel lblDni = new JLabel("DNI");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 4;
		add(lblDni, gbc_lblDni);
		
		jtfDni = new JTextField();
		jtfDni.setColumns(10);
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 4;
		add(jtfDni, gbc_jtfDni);
		
		JLabel lblDireccin = new JLabel("Dirección");
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.anchor = GridBagConstraints.EAST;
		gbc_lblDireccin.gridx = 0;
		gbc_lblDireccin.gridy = 5;
		add(lblDireccin, gbc_lblDireccin);
		
		jtfDireccion = new JTextField();
		jtfDireccion.setColumns(10);
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 5;
		add(jtfDireccion, gbc_jtfDireccion);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		add(jtfEmail, gbc_jtfEmail);
		
		JLabel lblTelfono = new JLabel("Teléfono");
		GridBagConstraints gbc_lblTelfono = new GridBagConstraints();
		gbc_lblTelfono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelfono.anchor = GridBagConstraints.EAST;
		gbc_lblTelfono.gridx = 0;
		gbc_lblTelfono.gridy = 7;
		add(lblTelfono, gbc_lblTelfono);
		
		jtfTelf = new JTextField();
		jtfTelf.setColumns(10);
		GridBagConstraints gbc_jtfTelf = new GridBagConstraints();
		gbc_jtfTelf.insets = new Insets(0, 0, 5, 0);
		gbc_jtfTelf.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelf.gridx = 1;
		gbc_jtfTelf.gridy = 7;
		add(jtfTelf, gbc_jtfTelf);
		
		cargarDatos();

	}

	public String getNombre() {
		return this.jtfNombre.getText();
	}

	public void setNombre(String nombre) {
		this.jtfNombre.setText(nombre);
	}

	public String getPrimerApellido() {
		return this.jtfPrimer.getText();
	}

	public void setPrimerApellido(String primerApellido) {
		this.jtfPrimer.setText(primerApellido);
	}

	public String getSegundoApellido() {
		return this.jtfSegundo.getText();
	}

	public void setSegundoApellido(String segundoApellido) {
		this.jtfSegundo.setText(segundoApellido);
	}

	public String getDni() {
		return this.jtfDni.getText();
	}

	public void setDni(String dni) {
		this.jtfDni.setText(dni);;
	}

	public String getDireccion() {
		return this.jtfDireccion.getText();
	}

	public void setDireccion(String direccion) {
		this.jtfDireccion.setText(direccion);
	}

	public String getEmail() {
		return this.jtfEmail.getText();
	}

	public void setEmail(String email) {
		this.jtfEmail.setText(email);
	}

	public String getTelefono() {
		return this.jtfTelf.getText();
	}

	public void setTelefono(String telefono) {
		this.jtfTelf.setText(telefono);
	}
	
	private void cargarDatos() {
		List<TipologiaSexo> sexo = ControladorSexo.getInstance().findAll();

		for (TipologiaSexo t : sexo) {
			this.jcbSexo.addItem(t);
		}
	}
	
	public JComboBox<TipologiaSexo> getJcbSexo() {
		return jcbSexo;
	}

	public void setJcbSexo(JComboBox<TipologiaSexo> jcbSexo) {
		this.jcbSexo = jcbSexo;
	}
	
}
