package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import model.controllers.ControladorEstudiante;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;
import model.controllers.ControladorValoracionMateria;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PnlSeleccionNota extends JPanel {

	JComboBox jcbMateria;
	JComboBox jcbProfesor;
	JComboBox jcbNota;
	JList jListSeleccionados;
	JList jListNoSeleccionados;
	DefaultListModel<Estudiante> dlmSeleccionados =  new DefaultListModel<Estudiante>();
	DefaultListModel<Estudiante> dlmNoSeleccionados =  new DefaultListModel<Estudiante>();
	JScrollPane scrollPane_1 = new JScrollPane(jListNoSeleccionados);
	JScrollPane scrollPane = new JScrollPane(jListSeleccionados);
	
	Materia m = new Materia();
	Profesor p = new Profesor();
	
	/**
	 * Create the panel.
	 */
	public PnlSeleccionNota() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMateria = new JComboBox();
		List<Materia> materia = ControladorMateria.getInstance().findAll();
		for (Materia m : materia) {
			jcbMateria.addItem(m);
		}
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox();
		List<Profesor> profesor = ControladorProfesor.getInstance().findAll();
		for (Profesor p : profesor) {
			jcbProfesor.addItem(p);
		}
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNewLabel_2 = new JLabel("Nota:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbNota = new JComboBox();
		List<Integer> nota;
		for (int i = 0; i < 11; i++) {
			jcbNota.addItem(i);
		}
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		add(jcbNota, gbc_jcbNota);
		
		JButton jbtnActualizarAlumnado = new JButton("Botón actualizar alumnado");
		jbtnActualizarAlumnado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarAlumnado();
			}
		});
		GridBagConstraints gbc_jbtnActualizarAlumnado = new GridBagConstraints();
		gbc_jbtnActualizarAlumnado.anchor = GridBagConstraints.EAST;
		gbc_jbtnActualizarAlumnado.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnActualizarAlumnado.gridx = 1;
		gbc_jbtnActualizarAlumnado.gridy = 3;
		add(jbtnActualizarAlumnado, gbc_jbtnActualizarAlumnado);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.anchor = GridBagConstraints.WEST;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		jListNoSeleccionados = new JList(dlmNoSeleccionados);
		scrollPane.setViewportView(jListNoSeleccionados);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{85, 0};
		gbl_panel_1.rowHeights = new int[]{21, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton_2 = new JButton("<<");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deseleccionarTodos();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 0;
		panel_1.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deseleccionarUno();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_3 = new JButton(">");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionarUno();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 2;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton(">>");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionarTodos();
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 3;
		panel_1.add(btnNewButton_4, gbc_btnNewButton_4);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.anchor = GridBagConstraints.EAST;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 0;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		jListSeleccionados = new JList(dlmSeleccionados);
		scrollPane_1.setViewportView(jListSeleccionados);
		
		JButton btnNewButton_1 = new JButton("Guardar las notas de todos los alumnos seleccionados");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 5;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
	}
	
	private void seleccionarTodos() {
		for (int i = 0; i < this.dlmNoSeleccionados.size(); i++) {
			this.dlmSeleccionados.addElement(this.dlmNoSeleccionados.elementAt(i));
		}
		this.dlmNoSeleccionados.clear();
	}
	
	private void deseleccionarTodos() {
		for (int i = 0; i < this.dlmSeleccionados.size(); i++) {
			this.dlmNoSeleccionados.addElement(this.dlmSeleccionados.elementAt(i));
		}
		this.dlmSeleccionados.clear();
	}
	
	private void seleccionarUno() {
		for (int i = 0; i < this.jListNoSeleccionados.getSelectedIndices().length; i++) {
			this.dlmSeleccionados.addElement(this.dlmNoSeleccionados.getElementAt(jListNoSeleccionados.getSelectedIndices()[i]));
		}
		
		for (int i = this.jListNoSeleccionados.getSelectedIndices().length - 1; i >= 0; i--) {
			this.dlmNoSeleccionados.removeElementAt(this.jListNoSeleccionados.getSelectedIndices()[i]);
		}
	}
	
	private void deseleccionarUno() {
		for (int i = 0; i < this.jListSeleccionados.getSelectedIndices().length; i++) {
			this.dlmNoSeleccionados.addElement(this.dlmSeleccionados.getElementAt(jListSeleccionados.getSelectedIndices()[i]));
		}
		
		for (int i = this.jListSeleccionados.getSelectedIndices().length - 1; i >= 0; i--) {
			this.dlmSeleccionados.removeElementAt(this.jListSeleccionados.getSelectedIndices()[i]);
		}
	}

	private void actualizarAlumnado() {
		
		dlmNoSeleccionados.removeAllElements();
		dlmSeleccionados.removeAllElements();
		
		m = (Materia) this.jcbMateria.getSelectedItem();
		p = (Profesor) this.jcbProfesor.getSelectedItem();
		Integer n = (Integer) this.jcbNota.getSelectedItem();
		
		List<Estudiante> estudiantes = ControladorEstudiante.getInstance().findAll();
		
		for (Estudiante estudiante : estudiantes) {
			
			ValoracionMateria vm = ControladorValoracionMateria.getInstancia().findByMateriaAndProfesorAndEstudianteAndValoracion(m, p, estudiante, Float.valueOf(n));
			if (vm == null) {
				this.dlmNoSeleccionados.addElement(estudiante);
			}
			else {
				this.dlmSeleccionados.addElement(estudiante);
			}
		}
		
	}
	
	private void guardar() {
		Profesor p = (Profesor) this.jcbProfesor.getSelectedItem();
		Materia m = (Materia) this.jcbMateria.getSelectedItem();
		Integer v = (Integer) this.jcbNota.getSelectedItem();
		
		for (int i = 0; i < this.dlmSeleccionados.size(); i++) {
			Estudiante e = this.dlmSeleccionados.elementAt(i);
			
			ValoracionMateria vm = ControladorValoracionMateria.getInstancia().findByMateriaAndProfesorAndEstudiante(m, p, e);
			
			if (vm == null) {
				vm = new ValoracionMateria();
				vm.setEstudiante(e);
				vm.setProfesor(p);
				vm.setMateria(m);
				vm.setValoracion(v);
			}
			else {
				vm.setValoracion(v);
			}
			
			ControladorValoracionMateria.getInstancia().save(vm);
		}
				
	}
}
