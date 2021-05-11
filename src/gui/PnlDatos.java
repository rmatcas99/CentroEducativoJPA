package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import model.controllers.ControladorSexo;
import model.entities.TipologiaSexo;

import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JLabel lblNewLabel;
	private JTextField jtfColor;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JColorChooser jColorChooser;
	private byte[] imagen = new byte[] {};
	private JButton jbtnCambiarImagen;
	public JFileChooser jfilechooserImagen;
	public File fichero;
	private JPopupMenu popupMenu;
	private JLabel label;
	private JLabel lblDimensiones;
	private JButton jbtnImagenClick;

	/**
	 * Create the panel.
	 */
	public PnlDatos() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 0;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		scrollPane = new JScrollPane();
		
		popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);
		
		lblDimensiones = new JLabel("Dimensiones");
		popupMenu.add(lblDimensiones);
		
		jbtnImagenClick = new JButton("Cambiar Imagen");
		jbtnImagenClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionaFichero();
			}
		});
		popupMenu.add(jbtnImagenClick);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		label = new JLabel("New label");
		scrollPane.setViewportView(label);

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
		gbc_jtfPrimer.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfSegundo.insets = new Insets(0, 0, 5, 5);
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
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 4;
		add(jtfDni, gbc_jtfDni);

		jbtnCambiarImagen = new JButton("Cambiar Imagen");
		jbtnCambiarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionaFichero();
			}
		});
		GridBagConstraints gbc_jbtnCambiarImagen = new GridBagConstraints();
		gbc_jbtnCambiarImagen.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnCambiarImagen.gridx = 2;
		gbc_jbtnCambiarImagen.gridy = 4;
		add(jbtnCambiarImagen, gbc_jbtnCambiarImagen);

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
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfTelf.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelf.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelf.gridx = 1;
		gbc_jtfTelf.gridy = 7;
		add(jtfTelf, gbc_jtfTelf);

		lblNewLabel = new JLabel("Color Preferido");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 8;
		add(lblNewLabel, gbc_lblNewLabel);

		jtfColor = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 8;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);

		btnNewButton = new JButton("Cambiar Color");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 8;
		add(btnNewButton, gbc_btnNewButton);

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
		this.jtfDni.setText(dni);
		;
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

	public void setColor(String color) {
		if (color != null) {
			this.jtfColor.setText(color);
			this.setBackground(Color.decode(color));
		} else {
			this.jtfColor.setText("");
			this.setBackground(Color.LIGHT_GRAY);
		}

	}

	
	/**
	 * 
	 */
	public void seleccionaColor() {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no ser� nulo
		if (color != null) {
			String strColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.setBackground(color);
		}
	}

	public String getColor() {
		return jtfColor.getText();
	}

	/**
	 * 
	 */
	private void seleccionaFichero() {
		this.jfilechooserImagen = new JFileChooser();

		// Configurando el componente

		// Establecimiento de la carpeta de inicio
		this.jfilechooserImagen.setCurrentDirectory(new File("C:\\"));

		// Tipo de selecciï¿½n que se hace en el diï¿½logo
		this.jfilechooserImagen.setFileSelectionMode(JFileChooser.FILES_ONLY); // Sï¿½lo selecciona ficheros

		this.jfilechooserImagen.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Archivos de texto *.jpg";
			}

			@Override
			public boolean accept(File f) {
				if (f.isFile() && f.getAbsolutePath().endsWith(".jpg"))
					return true;
				return false;
			}
		});

		// Abro el diï¿½logo para la elecciï¿½n del usuario
		int seleccionUsuario = jfilechooserImagen.showOpenDialog(null);

		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			fichero = jfilechooserImagen.getSelectedFile();
			try {
				this.imagen = Files.readAllBytes(fichero.toPath());
			} catch (IOException e) {
				System.out.println("Error al leer el contenido del fichero binario");
				e.printStackTrace();
			}

			try {

				ImageIcon img = new ImageIcon(fichero.toString());
				JLabel lbl = new JLabel(img);
				// System.out.println("JLabel : " + lbl.getHeight() + " x " + lbl.getWidth());
				this.scrollPane.setViewportView(lbl);

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(null, "Error abriendo la imagen " + ex);

			}

		}

	}

	public void setLabelImag(String str) {
		JLabel lbl = new JLabel(str);
		this.scrollPane.setViewportView(lbl);
	}

	public void setImagen(byte imagen[]) {
		ImageIcon icon = new ImageIcon(imagen);
		JLabel lbl = new JLabel(icon);
		this.scrollPane.setViewportView(lbl);
		this.scrollPane.revalidate();
		this.scrollPane.repaint();
	}

	/**
	 * 
	 * @return
	 */
	public byte[] getImagen() {
		return this.imagen;
	}

	/**
	 * 
	 * @return
	 */
	public JLabel getLblDimensiones() {
		return lblDimensiones;
	}

	public void setLblDimensiones(String lblDimensiones) {
		this.lblDimensiones.setText(lblDimensiones);
	}

	
	/**
	 * 
	 * @param component
	 * @param popup
	 */
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
