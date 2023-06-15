package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import BuisnessLogic.Componente;
import baseDeDatos.ConexionBD;

public class InsertarInternalFrame extends JInternalFrame{

	private JTextField textFieldEstanteria;
	private JTextField textField_Lado;
	private JTextField textField_Nombre;
	private JTextField textField_ID;
	private JTextField textField_Balda;
	
	public InsertarInternalFrame(VentanaPrincipal vp, PanelComponente pc, ConexionBD bd, int piso, String balda, String nombreEstanteria, String lado, int planta) {
		
		setClosable(true);
		setBounds(292, 11, 667, 184);
		setVisible(true);
		toFront();
		getContentPane().setLayout(null);
		requestFocusInWindow();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
               
            	PanelComponente panelNuevo = new PanelComponente(vp, bd, piso, balda, nombreEstanteria, lado, planta);
				vp.setPanelContenido(panelNuevo);
				panelNuevo.list.setSelectedIndex(pc.list.getSelectedIndex());
            }
        });

		
		JLabel lbl_Planta = new JLabel("Planta:");
		lbl_Planta.setBounds(91, 14, 46, 14);
		getContentPane().add(lbl_Planta);
		
		JSpinner spinnerPlanta = new JSpinner();
		spinnerPlanta.setValue(planta);
		spinnerPlanta.setEnabled(false);
		spinnerPlanta.setBounds(156, 11, 66, 21);
		getContentPane().add(spinnerPlanta);
		
		JLabel lbl_Estantera = new JLabel("Estantería:");
		lbl_Estantera.setBounds(91, 58, 73, 14);
		getContentPane().add(lbl_Estantera);
		
		textFieldEstanteria = new JTextField();
		textFieldEstanteria.setEditable(false);
		textFieldEstanteria.setEnabled(false);
		textFieldEstanteria.setText(nombreEstanteria);
		textFieldEstanteria.setBounds(156, 55, 137, 20);
		getContentPane().add(textFieldEstanteria);
		textFieldEstanteria.setColumns(10);
		
		JLabel lbl_Piso = new JLabel("Piso:");
		lbl_Piso.setBounds(91, 103, 73, 14);
		getContentPane().add(lbl_Piso);
		
		JSpinner spinner_Piso = new JSpinner();
		spinner_Piso.setValue(piso);
		spinner_Piso.setEnabled(false);
		spinner_Piso.setBounds(156, 100, 66, 21);
		getContentPane().add(spinner_Piso);
		
		JLabel lbl_Lado = new JLabel("Lado:");
		lbl_Lado.setBounds(91, 146, 73, 14);
		getContentPane().add(lbl_Lado);
		
		textField_Lado = new JTextField();
		if(lado != null && !lado.isBlank() && !lado.isEmpty()) {
			textField_Lado.setText(lado);
		} else {
			textField_Lado.setText(null);
		}
		
		textField_Lado.setEditable(false);
		textField_Lado.setEnabled(false);
		textField_Lado.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Lado.setColumns(10);
		textField_Lado.setBounds(156, 143, 66, 20);
		getContentPane().add(textField_Lado);
		
		JLabel lblCantidadActual = new JLabel("Cantidad actual:");
		lblCantidadActual.setBounds(672, 104, 103, 14);
		getContentPane().add(lblCantidadActual);
		
		JLabel lbl_Precio = new JLabel("Precio:");
		lbl_Precio.setBounds(355, 146, 73, 14);
		getContentPane().add(lbl_Precio);
		
		JSpinner spinner_Precio = new JSpinner();
		spinner_Precio.setBounds(450, 142, 66, 21);
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), Float.valueOf(999999), Float.valueOf((float) 0.01));
		spinner_Precio.setModel(spinnerModel);
		getContentPane().add(spinner_Precio);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(450, 101, 137, 20);
		getContentPane().add(textField_Nombre);
		
		JLabel lbl_Nombre = new JLabel("Nombre:");
		lbl_Nombre.setBounds(355, 104, 73, 14);
		getContentPane().add(lbl_Nombre);
		
		JLabel lbl_ID = new JLabel("S/N:");
		lbl_ID.setBounds(355, 58, 103, 14);
		getContentPane().add(lbl_ID);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(450, 55, 137, 20);
		getContentPane().add(textField_ID);
		
		JSpinner spinner_cantActual = new JSpinner();
		spinner_cantActual.setBounds(767, 100, 66, 21);
		getContentPane().add(spinner_cantActual);
		
		JSpinner spinner_cantMax = new JSpinner();
		spinner_cantMax.setBounds(767, 11, 66, 21);
		getContentPane().add(spinner_cantMax);
		
		JLabel lblCantidadMaxima = new JLabel("Cantidad MAX:");
		lblCantidadMaxima.setBounds(672, 15, 103, 14);
		getContentPane().add(lblCantidadMaxima);
		
		JLabel lblCantidadMinima = new JLabel("Cantidad MIN:");
		lblCantidadMinima.setBounds(672, 59, 103, 14);
		getContentPane().add(lblCantidadMinima);
		
		JSpinner spinner_cantMin = new JSpinner();
		spinner_cantMin.setBounds(767, 55, 66, 21);
		getContentPane().add(spinner_cantMin);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Componente nuevo = new Componente(textField_ID.getText(), textField_Nombre.getText(), (int) spinner_cantActual.getValue(), (int) spinner_cantMax.getValue(), (int) spinner_cantMin.getValue(), (float) spinner_Precio.getValue(), nombreEstanteria, piso, balda, lado, planta);
				try {
					bd.insertarComponente(nuevo);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error con la base de datos al insertar el componente.");
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnInsertar.setForeground(new Color(255, 255, 255));
		btnInsertar.setBackground(new Color(46, 139, 87));
		btnInsertar.setBounds(672, 143, 161, 21);
		getContentPane().add(btnInsertar);
		
		JLabel lbl_Balda = new JLabel("Balda:");
		lbl_Balda.setBounds(355, 14, 73, 14);
		getContentPane().add(lbl_Balda);
		
		textField_Balda = new JTextField();
		textField_Balda.setEnabled(false);
		textField_Balda.setEditable(false);
		textField_Balda.setText(balda);
		textField_Balda.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Balda.setColumns(10);
		textField_Balda.setBounds(450, 11, 66, 20);
		getContentPane().add(textField_Balda);
		
		
		setVisible(true);
		try {
			setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
