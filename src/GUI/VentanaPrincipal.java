package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BuisnessLogic.Componente;
import baseDeDatos.ConexionBD;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnPlantaUno;
	public JButton btnPlantaDos;
	private JPanel panelContenido;
	private JTextField textFieldBuscar;
	public PanelPlantaUno panelPlantaUno;
	public PanelPlantaDos panelPlantaDos;
	private JRadioButton rdbtnNombre;
	private JRadioButton rdbtnNumeroDeSerie;
	private ArrayList<Componente> componentesBuscados = new ArrayList<>();
	private JList listBusqueda;
	private JScrollPane scrollPane;
	private JButton btnEncontrar;


	public VentanaPrincipal(ConexionBD bd) {
		PanelPlantaUno panelPlantaUno = new PanelPlantaUno(bd, this);
		PanelPlantaDos panelPlantaDos = new PanelPlantaDos(bd, this);

		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 1136, 727);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(50, 81, 152));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(215, 222, 242)));
		panel.setBounds(0, 0, 1120, 688);
		getContentPane().add(panel);
		panel.setLayout(null);

		btnPlantaUno = new JButton("Planta 1º");
		btnPlantaUno.setBounds(20, 408, 91, 269);
		panel.add(btnPlantaUno);
		btnPlantaUno.setForeground(new Color(255, 255, 255));
		btnPlantaUno.setBackground(new Color(50, 80, 152));
		btnPlantaUno.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));

		btnPlantaDos = new JButton("Planta 2º");
		btnPlantaDos.setIcon(null);
		btnPlantaDos.setBounds(20, 134, 91, 269);
		panel.add(btnPlantaDos);
		btnPlantaDos.setForeground(new Color(255, 255, 255));
		btnPlantaDos.setBackground(new Color(50, 80, 152));
		btnPlantaDos.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("media/logo.png"));
		logo.setBounds(22, 22, 234, 88);
		panel.add(logo);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(50, 81, 152));
		separator.setBounds(20, 121, 1090, 2);
		panel.add(separator);

		panelContenido = new JPanel();
		panelContenido.setBorder(null);
		panelContenido.setBackground(new Color(239, 242, 250));
		panelContenido.setBounds(121, 134, 989, 543);
		panel.add(panelContenido);
		panelContenido.setLayout(null);


		btnPlantaDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlantaUno.setEnabled(true);
				btnPlantaDos.setEnabled(false);
				setPanelContenido(panelPlantaDos);
			}
		});
		btnPlantaUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlantaUno.setEnabled(false);
				btnPlantaDos.setEnabled(true);
				setPanelContenido(panelPlantaUno);


			}
		});

		JPanel panel_funciones = new JPanel();
		panel_funciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_funciones.setBackground(new Color(225, 234, 255));
		panel_funciones.setBounds(266, 11, 844, 99);
		panel.add(panel_funciones);
		panel_funciones.setLayout(null);

		rdbtnNumeroDeSerie = new JRadioButton("Numero de serie");
		rdbtnNumeroDeSerie.setBackground(new Color(225, 234, 255));
		rdbtnNumeroDeSerie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnNombre.setSelected(false);

			}
		});
		rdbtnNumeroDeSerie.setBounds(10, 65, 134, 23);
		panel_funciones.add(rdbtnNumeroDeSerie);

		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(10, 11, 248, 27);
		panel_funciones.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);

		rdbtnNombre = new JRadioButton("Nombre");
		rdbtnNombre.setSelected(true);
		rdbtnNombre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnNumeroDeSerie.setSelected(false);

			}
		});
		rdbtnNombre.setBackground(new Color(225, 234, 255));
		rdbtnNombre.setBounds(10, 45, 112, 23);
		panel_funciones.add(rdbtnNombre);

		JButton btnNBuscar = new JButton("Buscar");
		btnNBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					btnEncontrar.setVisible(false);

					if(rdbtnNombre.isSelected()) {
						componentesBuscados = bd.obtenerStockNombre(textFieldBuscar.getText());
					} else if (rdbtnNumeroDeSerie.isSelected()){
						componentesBuscados = bd.obtenerStockID(textFieldBuscar.getText());
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				String[] componentesArray = new String[componentesBuscados.size()];
				for (int i = 0; i < componentesBuscados.size(); i++) {
					componentesArray[i] = componentesBuscados.get(i).getId() + " - "+ componentesBuscados.get(i).getNombre() + "     x" + componentesBuscados.get(i).getCantidadActual();
				}

				listBusqueda.setModel(new AbstractListModel<String>() {
					String[] values = componentesArray;
					public int getSize() {
						return values.length;
					}
					public String getElementAt(int index) {
						return values[index];
					}
				});

			}
		});
		btnNBuscar.setBackground(SystemColor.inactiveCaption);
		btnNBuscar.setBounds(268, 11, 94, 27);
		panel_funciones.add(btnNBuscar);

		btnEncontrar = new JButton("Encontrar");
		btnEncontrar.setForeground(new Color(255, 255, 255));
		btnEncontrar.setBackground(new Color(0, 100, 0));
		btnEncontrar.setBounds(268, 45, 94, 43);
		btnEncontrar.setVisible(false);
		btnEncontrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Componente componenteSeleccionado = componentesBuscados.get(listBusqueda.getSelectedIndex());
				PanelComponente panelNuevo = new PanelComponente(VentanaPrincipal.this, bd, componenteSeleccionado.getPiso(), componenteSeleccionado.getBalda(), componenteSeleccionado.getEstanteria(), componenteSeleccionado.getLado(), componenteSeleccionado.getPlanta());
				setPanelContenido(panelNuevo);
				textFieldBuscar.setText("");
				listBusqueda.clearSelection();
				listBusqueda.setModel(new DefaultListModel<>());
				componentesBuscados = new ArrayList<>();
				btnEncontrar.setVisible(false);

			}
		});
		panel_funciones.add(btnEncontrar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(372, 11, 357, 77);
		panel_funciones.add(scrollPane);

		listBusqueda = new JList();
		listBusqueda.setForeground(new Color(0, 0, 0));
		listBusqueda.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(listBusqueda);

		listBusqueda.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnEncontrar.setVisible(true);

			}
		});

		JButton btnInforme = new JButton("Informe");
		btnInforme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					bd.generarExcelCompleto();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Asegurate de cerrar el excel antes de generar un nuevo informe.");
				} 


			}
		});
		btnInforme.setBackground(SystemColor.activeCaption);
		btnInforme.setBounds(750, 13, 84, 75);
		panel_funciones.add(btnInforme);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(739, 11, 1, 77);
		panel_funciones.add(separator_1);


		setResizable(false);
		setVisible(true);
	}

	public JPanel getPanelContenido() {
		return panelContenido;
	}

	public void setPanelContenido(JPanel panelContenido) {
		getContentPane().remove(this.panelContenido); // Eliminar el panel anterior
		this.panelContenido = panelContenido;
		getContentPane().add(panelContenido); // Agregar el nuevo panel
		panelContenido.repaint(); // Actualizar la ventana
		panelContenido.revalidate();
	}






}

