package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import BuisnessLogic.Componente;

public class LadoEstanteria extends JPanel{


	public LadoEstanteria(int pisosMax, String baldaMax) {

		setBorder(null);
		setBackground(new Color(239, 242, 250));
		setBounds(121, 134, 989, 543);
		setLayout(null);
		
		JPanel panelEstanteria = new JPanel();
		panelEstanteria.setBackground(new Color(176, 224, 230));
		panelEstanteria.setBorder(new LineBorder(UIManager.getColor("FormattedTextField.selectionBackground")));
		panelEstanteria.setBounds(33, 33, 921, 477);
		add(panelEstanteria);
		panelEstanteria.setLayout(null);
		
		JPanel panel_Superior = new JPanel();
		panel_Superior.setBackground(Color.WHITE);
		panel_Superior.setBounds(10, 11, 901, 51);
		panelEstanteria.add(panel_Superior);
		panel_Superior.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnSuperior = new JButton("SUPERIOR");
		btnSuperior.setBackground(Color.WHITE);
		panel_Superior.add(btnSuperior);
		
		JPanel panel_Inferior = new JPanel();
		panel_Inferior.setBackground(Color.WHITE);
		panel_Inferior.setBounds(10, 415, 901, 51);
		panelEstanteria.add(panel_Inferior);
		panel_Inferior.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnAbajo = new JButton("SUELO");
		btnAbajo.setBackground(Color.WHITE);
		panel_Inferior.add(btnAbajo);
		
		JPanel panel_Central = new JPanel();
		panel_Central.setBackground(Color.WHITE);
		panel_Central.setBounds(10, 73, 901, 331);
		panelEstanteria.add(panel_Central);
		int indiceParaLayout = 0;
		
		for (int i = 1; i <= pisosMax; i++) {
			for (char letra = 'A'; letra <= baldaMax.charAt(0); letra++) {

				JButton botonSeccion = new JButton(i + "-" +  letra);
				botonSeccion.setBackground(Color.WHITE);
				panel_Central.add(botonSeccion);
				
				indiceParaLayout++;
			}
		}
		
		panel_Central.setLayout(new GridLayout(pisosMax, indiceParaLayout, 0, 0));
		
	}
}

