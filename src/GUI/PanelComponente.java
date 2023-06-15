package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BuisnessLogic.Componente;
import baseDeDatos.ConexionBD;

public class PanelComponente extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField textFieldComponente;
	private JTextField textFieldID;
	private JTextField textField_codigoLocalizacion;
	private ArrayList<Componente> componentes = new ArrayList();
	public JList list;
	public JSpinner spinnerAnadirEliminarCantidad;
	public JButton btnEditarInformacion;


	public PanelComponente(VentanaPrincipal vp, ConexionBD bd, int piso, String balda, String nombreEstanteria, String lado, int planta){

		setBounds(121, 134, 989, 543);
		setBorder(null);
		setBackground(new Color(239, 242, 250));
		setLayout(null);

		JLabel lblEstanteriaSeccion = new JLabel("ESTANTERIA - SECCION");
		if(lado != null) {
			if(!lado.isBlank() || !lado.isEmpty()) {
				lblEstanteriaSeccion = new JLabel(nombreEstanteria + " - " + piso + balda + " - " + lado);
			}
		} else {
			lblEstanteriaSeccion = new JLabel(nombreEstanteria + " - " + piso + balda);
		}
		lblEstanteriaSeccion.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEstanteriaSeccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstanteriaSeccion.setBounds(10, 11, 969, 41);
		add(lblEstanteriaSeccion);

		JPanel panel_BotoneraCantidades = new JPanel();
		panel_BotoneraCantidades.setBackground(SystemColor.activeCaption);
		panel_BotoneraCantidades.setBounds(10, 326, 969, 206);
		add(panel_BotoneraCantidades);
		panel_BotoneraCantidades.setLayout(null);

		JLabel lblComponente = new JLabel("Componente:");
		lblComponente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblComponente.setBounds(10, 45, 80, 23);
		panel_BotoneraCantidades.add(lblComponente);

		textFieldComponente = new JTextField();
		textFieldComponente.setEditable(false);
		textFieldComponente.setEnabled(false);
		textFieldComponente.setBounds(100, 45, 170, 20);
		panel_BotoneraCantidades.add(textFieldComponente);
		textFieldComponente.setColumns(10);

		JSpinner spinnerCantidadActual = new JSpinner();
		spinnerCantidadActual.setEnabled(false);
		spinnerCantidadActual.setBounds(100, 78, 71, 20);
		panel_BotoneraCantidades.add(spinnerCantidadActual);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCantidad.setBounds(10, 78, 80, 23);
		panel_BotoneraCantidades.add(lblCantidad);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(10, 111, 80, 23);
		panel_BotoneraCantidades.add(lblPrecio);
		
		JSpinner spinnerPrecio = new JSpinner();
		spinnerPrecio.setEnabled(false);
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), Float.valueOf(999999), Float.valueOf((float) 0.1));
		spinnerPrecio.setModel(spinnerModel);
		spinnerPrecio.setBounds(100, 111, 71, 20);
		panel_BotoneraCantidades.add(spinnerPrecio);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(55, 62, 89));
		separator_1.setForeground(new Color(70, 130, 180));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(356, 11, -35, 124);
		panel_BotoneraCantidades.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(280, 11, 2, 184);
		panel_BotoneraCantidades.add(separator_2);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBackground(new Color(55, 62, 89));

		JLabel lblNMax = new JLabel("Nº Max:");
		lblNMax.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNMax.setBounds(10, 143, 80, 23);
		panel_BotoneraCantidades.add(lblNMax);

		JSpinner spinnerMax = new JSpinner();
		spinnerMax.setEnabled(false);
		spinnerMax.setBounds(100, 142, 71, 20);
		panel_BotoneraCantidades.add(spinnerMax);

		JSpinner spinnerMin = new JSpinner();
		spinnerMin.setEnabled(false);
		spinnerMin.setBounds(100, 176, 71, 20);
		panel_BotoneraCantidades.add(spinnerMin);

		JLabel lblNMin = new JLabel("Nº Min:");
		lblNMin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNMin.setBounds(10, 177, 80, 23);
		panel_BotoneraCantidades.add(lblNMin);

		JButton btnEliminarRegistro = new JButton("Eliminar");
		btnEliminarRegistro.setEnabled(false);
		btnEliminarRegistro.setBackground(new Color(128, 0, 0));
		btnEliminarRegistro.setForeground(Color.WHITE);
		btnEliminarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					bd.eliminarComponente(componentes.get(list.getSelectedIndex()), true);
					PanelComponente panelNuevo = new PanelComponente(vp, bd, piso, balda, nombreEstanteria, lado, planta);
					vp.setPanelContenido(panelNuevo);
					panelNuevo.list.setSelectedIndex(PanelComponente.this.list.getSelectedIndex());
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error con la base de datos al eliminar el componente.");
					e1.printStackTrace();
				}

			}
		});
		btnEliminarRegistro.setBounds(860, 11, 99, 23);
		panel_BotoneraCantidades.add(btnEliminarRegistro);
		

		textFieldID = new JTextField();
		textFieldID.setEnabled(false);
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		textFieldID.setBounds(100, 11, 170, 20);
		panel_BotoneraCantidades.add(textFieldID);

		JLabel lblComponente_1 = new JLabel("Número de serie:");
		lblComponente_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblComponente_1.setBounds(10, 11, 122, 23);
		panel_BotoneraCantidades.add(lblComponente_1);

		JPanel panel_BotoneraCantidad = new JPanel();
		panel_BotoneraCantidad.setBackground(SystemColor.inactiveCaption);
		panel_BotoneraCantidad.setBounds(292, 111, 667, 84);
		panel_BotoneraCantidades.add(panel_BotoneraCantidad);
		panel_BotoneraCantidad.setLayout(null);

		JButton btnEliminar = new JButton("Eliminar -1");
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					bd.eliminarCantidadConcreta(1, componentes.get(list.getSelectedIndex()));
					PanelComponente panelNuevo = new PanelComponente(vp, bd, piso, balda, nombreEstanteria, lado, planta);
					vp.setPanelContenido(panelNuevo);
					panelNuevo.list.setSelectedIndex(PanelComponente.this.list.getSelectedIndex());
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error con la base de datos al retirar una unidad.");
					e1.printStackTrace();
				}

			}
		});
		btnEliminar.setBounds(10, 11, 111, 62);
		panel_BotoneraCantidad.add(btnEliminar);
		btnEliminar.setEnabled(false);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(55, 62, 89));

		JButton btnEliminarCantidad = new JButton("Eliminar cantidad >>");
		btnEliminarCantidad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


				int cantidad = 0;

				try {
					cantidad = (int) spinnerAnadirEliminarCantidad.getValue();
					bd.eliminarCantidadConcreta(cantidad, componentes.get(list.getSelectedIndex()));
					PanelComponente panelNuevo = new PanelComponente(vp, bd, piso, balda, nombreEstanteria, lado, planta);
					vp.setPanelContenido(panelNuevo);
					panelNuevo.list.setSelectedIndex(PanelComponente.this.list.getSelectedIndex());
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error con la base de datos al retirar " + cantidad + " unidades.");
					e1.printStackTrace();
				}

			}
		});
		btnEliminarCantidad.setBounds(131, 11, 161, 62);
		panel_BotoneraCantidad.add(btnEliminarCantidad);
		btnEliminarCantidad.setEnabled(false);
		btnEliminarCantidad.setForeground(Color.WHITE);
		btnEliminarCantidad.setBackground(new Color(55, 62, 89));

		spinnerAnadirEliminarCantidad = new JSpinner();
		spinnerAnadirEliminarCantidad.setBounds(302, 11, 71, 62);
		panel_BotoneraCantidad.add(spinnerAnadirEliminarCantidad);
		spinnerAnadirEliminarCantidad.setEnabled(false);
		spinnerAnadirEliminarCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerAnadirEliminarCantidad.setForeground(Color.WHITE);
		spinnerAnadirEliminarCantidad.setBackground(new Color(55, 62, 89));

		JButton btnAnadirCantidad = new JButton("<< Añadir cantidad");
		btnAnadirCantidad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int cantidad = 0;

				try {
					cantidad = (int) spinnerAnadirEliminarCantidad.getValue();
					bd.anyadirCantidadConcreta(cantidad , componentes.get(list.getSelectedIndex()));
					PanelComponente panelNuevo = new PanelComponente(vp, bd, piso, balda, nombreEstanteria, lado, planta);
					vp.setPanelContenido(panelNuevo);
					panelNuevo.list.setSelectedIndex(PanelComponente.this.list.getSelectedIndex());
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error con la base de datos al añadir " + cantidad + " unidades." );
					e1.printStackTrace();
				}

			}
		});
		btnAnadirCantidad.setBounds(378, 11, 161, 62);
		panel_BotoneraCantidad.add(btnAnadirCantidad);
		btnAnadirCantidad.setEnabled(false);
		btnAnadirCantidad.setForeground(Color.WHITE);
		btnAnadirCantidad.setBackground(new Color(55, 62, 89));

		JButton btnAnadir = new JButton("Añadir +1");
		btnAnadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					bd.anyadirCantidadConcreta(1, componentes.get(list.getSelectedIndex()));
					PanelComponente panelNuevo = new PanelComponente(vp, bd, piso, balda, nombreEstanteria, lado, planta);
					vp.setPanelContenido(panelNuevo);
					panelNuevo.list.setSelectedIndex(PanelComponente.this.list.getSelectedIndex());
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error con la base de datos al añadir una unidad.");
					e1.printStackTrace();
				}

			}
		});
		btnAnadir.setBounds(543, 11, 111, 62);
		panel_BotoneraCantidad.add(btnAnadir);
		btnAnadir.setEnabled(false);
		btnAnadir.setForeground(Color.WHITE);
		btnAnadir.setBackground(new Color(55, 62, 89));

		JPanel panel_codigoLocalizacion = new JPanel();
		panel_codigoLocalizacion.setBackground(new Color(255, 255, 255));
		panel_codigoLocalizacion.setBounds(292, 11, 345, 57);
		panel_BotoneraCantidades.add(panel_codigoLocalizacion);
		panel_codigoLocalizacion.setLayout(null);

		textField_codigoLocalizacion = new JTextField();
		textField_codigoLocalizacion.setHorizontalAlignment(SwingConstants.CENTER);
		textField_codigoLocalizacion.setForeground(Color.WHITE);
		textField_codigoLocalizacion.setBackground(new Color(55, 62, 89));
		textField_codigoLocalizacion.setBounds(129, 11, 202, 35);
		//textField_codigoLocalizacion.setEnabled(false);
		textField_codigoLocalizacion.setEditable(false);
		panel_codigoLocalizacion.add(textField_codigoLocalizacion);
		textField_codigoLocalizacion.setColumns(10);

		JLabel lblCodigoLocalizacion = new JLabel("Código localización:");
		lblCodigoLocalizacion.setBounds(10, 11, 124, 35);
		panel_codigoLocalizacion.add(lblCodigoLocalizacion);

		JButton btnInsertar = new JButton("Insertar nuevo");
		btnInsertar.setForeground(Color.WHITE);
		btnInsertar.setEnabled(true);
		btnInsertar.setBackground(new Color(55, 62, 89));
		btnInsertar.setBounds(647, 11, 203, 23);
		panel_BotoneraCantidades.add(btnInsertar);
		
		JButton btnConfirmarCambios = new JButton("Confirmar");
		btnConfirmarCambios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					
					spinnerCantidadActual.setEnabled(false);
					spinnerMax.setEnabled(false);
					spinnerMin.setEnabled(false);
					spinnerPrecio.setEnabled(false);
					textFieldComponente.setEnabled(false);
					textFieldComponente.setEditable(false);
					btnConfirmarCambios.setVisible(false);
					
					btnAnadir.setEnabled(true);
					btnEliminar.setEnabled(true);
					btnAnadirCantidad.setEnabled(true);
					btnEliminarCantidad.setEnabled(true);
					btnEliminarRegistro.setEnabled(true);
					spinnerAnadirEliminarCantidad.setEnabled(true);
					btnInsertar.setEnabled(true);
					btnEditarInformacion.setEnabled(true);
					
					Componente componente = componentes.get(list.getSelectedIndex());
					componente.setNombre(textFieldComponente.getText());
					componente.setCanitdadAvisoMax((int) spinnerMax.getValue());
					componente.setCantidadAvisoMin((int) spinnerMin.getValue());
					componente.setCantidadActual((int) spinnerCantidadActual.getValue());
					componente.setPrecio((float) spinnerPrecio.getValue());
					
					bd.actualizarComponente(componente);
					
					PanelComponente panelNuevo = new PanelComponente(vp, bd, piso, balda, nombreEstanteria, lado, planta);
					vp.setPanelContenido(panelNuevo);
					panelNuevo.list.setSelectedIndex(PanelComponente.this.list.getSelectedIndex());
					
				} catch (SQLException e1) {
					JOptionPane.showConfirmDialog(null, "Error con la base de datos al actualizar el componente.");
					e1.printStackTrace();
				}	
			}
		});
		btnConfirmarCambios.setForeground(Color.WHITE);
		btnConfirmarCambios.setVisible(false);
		btnConfirmarCambios.setBackground(new Color(46, 139, 87));
		btnConfirmarCambios.setBounds(860, 45, 99, 23);
		panel_BotoneraCantidades.add(btnConfirmarCambios);

		btnEditarInformacion = new JButton("Editar");
		btnEditarInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				spinnerCantidadActual.setEnabled(true);
				spinnerMax.setEnabled(true);
				spinnerMin.setEnabled(true);
				spinnerPrecio.setEnabled(true);
				textFieldComponente.setEnabled(true);
				textFieldComponente.setEditable(true);
				btnConfirmarCambios.setVisible(true);
				
				btnAnadir.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnAnadirCantidad.setEnabled(false);
				btnEliminarCantidad.setEnabled(false);
				btnEliminarRegistro.setEnabled(false);
				spinnerAnadirEliminarCantidad.setEnabled(false);
				btnInsertar.setEnabled(false);
				btnEditarInformacion.setEnabled(false);
				
				PanelComponente.this.repaint();
			

			}
		});
		btnEditarInformacion.setForeground(Color.WHITE);
		btnEditarInformacion.setEnabled(false);
		btnEditarInformacion.setBackground(new Color(55, 62, 89));
		btnEditarInformacion.setBounds(647, 45, 203, 23);
		panel_BotoneraCantidades.add(btnEditarInformacion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Componentes: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setBounds(10, 63, 969, 252);
		add(scrollPane);

		list = new JList();
		list.setForeground(Color.WHITE);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(new Color(55, 62, 89));


		try {
			componentes = bd.obtenerStockFiltrado(nombreEstanteria, piso, balda, lado);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String[] componentesArray = new String[componentes.size()];
		for (int i = 0; i < componentes.size(); i++) {
			componentesArray[i] = componentes.get(i).getNombre();
		}

		list.setModel(new AbstractListModel<String>() {
			String[] values = componentesArray;
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});


		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) { //This line prevents double events

					btnAnadir.setEnabled(true);
					btnAnadirCantidad.setEnabled(true);
					btnEliminar.setEnabled(true);
					btnEliminarCantidad.setEnabled(true);
					btnEditarInformacion.setEnabled(true);
					btnEliminarRegistro.setEnabled(true);
					spinnerAnadirEliminarCantidad.setEnabled(true);

					textFieldComponente.setText(componentes.get(list.getSelectedIndex()).getNombre());
					textFieldID.setText(componentes.get(list.getSelectedIndex()).getId());
					String cod = cod = planta + "_" + nombreEstanteria + "_" + piso + balda;
					if(lado != null && !lado.isBlank()) {
						cod += "_" + lado;
					}
					textField_codigoLocalizacion.setText(cod);
					spinnerCantidadActual.setValue(componentes.get(list.getSelectedIndex()).getCantidadActual());
					spinnerPrecio.setValue(componentes.get(list.getSelectedIndex()).getPrecio());
					spinnerMax.setValue(componentes.get(list.getSelectedIndex()).getCanitdadAvisoMax());
					spinnerMin.setValue(componentes.get(list.getSelectedIndex()).getCantidadAvisoMin());
					
					
					spinnerColores(spinnerCantidadActual,spinnerMax,spinnerMin);

					panel_BotoneraCantidad.repaint();
					panel_BotoneraCantidades.repaint();

					String selectedComponent = (String) list.getSelectedValue();
					System.out.println(selectedComponent);

				}
			}
		});


		list.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		scrollPane.setViewportView(list);

	}



	public void spinnerColores(JSpinner spinnerCantidadActual, JSpinner spinnerMax, JSpinner spinnerMin) {
		if((int) spinnerCantidadActual.getValue() >= (int) spinnerMax.getValue()) {
			JComponent comp = spinnerCantidadActual.getEditor();
			if(comp instanceof JSpinner.DefaultEditor) {
				JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) comp;
				editor.getTextField().setBackground(Color.blue);
				editor.getTextField().setForeground(Color.white);
			}
		} else if((int) spinnerCantidadActual.getValue() <= (int) spinnerMin.getValue()) {
			JComponent comp = spinnerCantidadActual.getEditor();
			if(comp instanceof JSpinner.DefaultEditor) {
				JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) comp;
				editor.getTextField().setBackground(Color.red);
				editor.getTextField().setForeground(Color.white);
			}
		} else {
			JComponent comp = spinnerCantidadActual.getEditor();
			if(comp instanceof JSpinner.DefaultEditor) {
				JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) comp;
	            editor.getTextField().setBackground(UIManager.getColor("TextField.background"));
	            editor.getTextField().setForeground(UIManager.getColor("TextField.foreground"));
			}
		}
	}
	
	
}
