package GUI;

import java.awt.EventQueue;  

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JInternalFrame;

public class ComponentesWindowBuilder {

	private JFrame frame;
	private JTextField textFieldComponente;
	private JTextField textFieldID;
	private JTextField textField_codigoLocalizacion;
	private JTextField textField;
	private JTextField textField_1;





	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComponentesWindowBuilder window = new ComponentesWindowBuilder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ComponentesWindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1136, 727);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(50, 81, 152));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(215, 222, 242)));
		panel.setBounds(0, 0, 1120, 688);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnPlantaUno = new JButton("Planta 1º");
		btnPlantaUno.setBounds(20, 408, 91, 269);
		panel.add(btnPlantaUno);
		btnPlantaUno.setForeground(new Color(255, 255, 255));
		btnPlantaUno.setBackground(new Color(50, 80, 152));
		btnPlantaUno.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));

		JButton btnPlantaDos = new JButton("Planta 2º");
		btnPlantaDos.setBounds(20, 134, 91, 269);
		btnPlantaDos.setIcon(null);
		panel.add(btnPlantaDos);
		btnPlantaDos.setForeground(new Color(255, 255, 255));
		btnPlantaDos.setBackground(new Color(50, 80, 152));
		btnPlantaDos.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));

		JLabel logo = new JLabel("");
		logo.setBounds(22, 22, 234, 88);
		logo.setIcon(new ImageIcon("C:\\Users\\Asus\\Documents\\GitHub\\stockHermanosMorales\\media\\logo.png"));
		panel.add(logo);

		JPanel panelContenido = new JPanel();	
		panelContenido.setBounds(121, 134, 989, 543);
		panelContenido.setBorder(null);
		panelContenido.setBackground(new Color(239, 242, 250));
		panel.add(panelContenido);
		panelContenido.setLayout(null);
		
		JLabel lblEstanteriaSeccion = new JLabel("ESTANTERIA - SECCION");
		lblEstanteriaSeccion.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEstanteriaSeccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstanteriaSeccion.setBounds(10, 11, 969, 41);
		panelContenido.add(lblEstanteriaSeccion);
		
		JPanel panel_BotoneraCantidades = new JPanel();
		panel_BotoneraCantidades.setBackground(SystemColor.activeCaption);
		panel_BotoneraCantidades.setBounds(10, 326, 969, 206);
		panelContenido.add(panel_BotoneraCantidades);
		panel_BotoneraCantidades.setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		try {
			internalFrame.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			internalFrame.setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		internalFrame.setClosable(true);
		internalFrame.setBounds(292, 11, 667, 184);
		internalFrame.setVisible(true);
		internalFrame.toFront();
		panel_BotoneraCantidades.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.requestFocusInWindow();

		
		JLabel lblPlanta = new JLabel("Planta:");
		lblPlanta.setBounds(22, 23, 46, 14);
		internalFrame.getContentPane().add(lblPlanta);
		
		JSpinner spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setBounds(141, 20, 66, 21);
		internalFrame.getContentPane().add(spinner);
		
		JLabel lblEstantera = new JLabel("Estantería:");
		lblEstantera.setBounds(22, 51, 73, 14);
		internalFrame.getContentPane().add(lblEstantera);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(141, 48, 137, 20);
		internalFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setBounds(22, 79, 73, 14);
		internalFrame.getContentPane().add(lblPiso);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setEnabled(false);
		spinner_1.setBounds(141, 76, 66, 21);
		internalFrame.getContentPane().add(spinner_1);
		
		JLabel lblBalda = new JLabel("Balda:");
		lblBalda.setBounds(22, 107, 73, 14);
		internalFrame.getContentPane().add(lblBalda);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(141, 104, 66, 20);
		internalFrame.getContentPane().add(textField_1);
		
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
		spinnerPrecio.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), Float.valueOf(999999), Float.valueOf(0)));
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
			}
		});
		btnEliminarRegistro.setBounds(860, 11, 99, 23);
		panel_BotoneraCantidades.add(btnEliminarRegistro);
		
		JButton btnEditarInformacin = new JButton("Editar");
		btnEditarInformacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarInformacin.setForeground(Color.WHITE);
		btnEditarInformacin.setEnabled(false);
		btnEditarInformacin.setBackground(new Color(55, 62, 89));
		btnEditarInformacin.setBounds(647, 45, 203, 23);
		panel_BotoneraCantidades.add(btnEditarInformacin);
		
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
		btnEliminar.setBounds(10, 11, 111, 62);
		panel_BotoneraCantidad.add(btnEliminar);
		btnEliminar.setEnabled(false);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(55, 62, 89));
		
		JButton btnEliminarCantidad = new JButton("Eliminar cantidad >>");
		btnEliminarCantidad.setBounds(131, 11, 161, 62);
		panel_BotoneraCantidad.add(btnEliminarCantidad);
		btnEliminarCantidad.setEnabled(false);
		btnEliminarCantidad.setForeground(Color.WHITE);
		btnEliminarCantidad.setBackground(new Color(55, 62, 89));
		
		JSpinner spinnerAnadirEliminarCantidad = new JSpinner();
		spinnerAnadirEliminarCantidad.setBounds(302, 11, 71, 62);
		panel_BotoneraCantidad.add(spinnerAnadirEliminarCantidad);
		spinnerAnadirEliminarCantidad.setEnabled(false);
		spinnerAnadirEliminarCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerAnadirEliminarCantidad.setForeground(Color.WHITE);
		spinnerAnadirEliminarCantidad.setBackground(new Color(55, 62, 89));
		
		JButton btnAnadirCantidad = new JButton("<< Añadir cantidad");
		btnAnadirCantidad.setBounds(378, 11, 161, 62);
		panel_BotoneraCantidad.add(btnAnadirCantidad);
		btnAnadirCantidad.setEnabled(false);
		btnAnadirCantidad.setForeground(Color.WHITE);
		btnAnadirCantidad.setBackground(new Color(55, 62, 89));
		
		JButton btnAnadir = new JButton("Añadir +1");
		btnAnadir.setBounds(543, 11, 111, 62);
		panel_BotoneraCantidad.add(btnAnadir);
		btnAnadir.setEnabled(false);
		btnAnadir.setForeground(Color.WHITE);
		btnAnadir.setBackground(new Color(55, 62, 89));
		
		JButton btnConfirmarCambios = new JButton("Confirmar");
		btnConfirmarCambios.setForeground(Color.WHITE);
		btnConfirmarCambios.setEnabled(false);
		btnConfirmarCambios.setBackground(new Color(46, 139, 87));
		btnConfirmarCambios.setBounds(860, 45, 99, 23);
		panel_BotoneraCantidades.add(btnConfirmarCambios);
		
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
		panel_codigoLocalizacion.add(textField_codigoLocalizacion);
		textField_codigoLocalizacion.setColumns(10);
		
		JLabel lblCodigoLocalizacion = new JLabel("Código localización: ");
		lblCodigoLocalizacion.setBounds(10, 11, 124, 35);
		panel_codigoLocalizacion.add(lblCodigoLocalizacion);
		
		JButton btnInsertar = new JButton("Insertar nuevo");
		btnInsertar.setForeground(Color.WHITE);
		btnInsertar.setEnabled(false);
		btnInsertar.setBackground(new Color(55, 62, 89));
		btnInsertar.setBounds(647, 11, 203, 23);
		panel_BotoneraCantidades.add(btnInsertar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Componentes: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setBounds(10, 63, 969, 252);
		panelContenido.add(scrollPane);
		
		JList list = new JList();
		list.setForeground(Color.WHITE);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(new Color(55, 62, 89));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Q", "W", "E", "R", "T", "Y", "U", "I", "OP", "Ñ", "L", "J", "JH", "GF", "F", "D", "S", "A", "Z", "XC", "VB", "N", "M", "H", "GF", "D", "W", "E"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		scrollPane.setViewportView(list);
	}
}