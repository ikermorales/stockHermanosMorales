package GUI;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPlantaUno extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelPlantaUno() {
		
		setBorder(null);
		setBackground(new Color(239, 242, 250));
		setBounds(121, 134, 989, 543);
		setLayout(null);
		
		JButton btnTermopan = new JButton("Termopan");
		btnTermopan.setBackground(SystemColor.inactiveCaption);
		btnTermopan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTermopan.setBounds(10, 11, 245, 47);
		add(btnTermopan);
		
		JButton btnLateralDos = new JButton("Lateral 2");
		btnLateralDos.setBackground(SystemColor.inactiveCaption);
		btnLateralDos.setBounds(10, 70, 245, 47);
		add(btnLateralDos);
		
		JButton btnNLateralTres = new JButton("Lateral 3");
		btnNLateralTres.setBackground(SystemColor.inactiveCaption);
		btnNLateralTres.setBounds(10, 128, 245, 47);
		add(btnNLateralTres);
		
		JButton btnCovi = new JButton("Covi");
		btnCovi.setBackground(SystemColor.inactiveCaption);
		btnCovi.setBounds(137, 186, 118, 37);
		add(btnCovi);
		
		JButton btnVentilacion = new JButton("Ventiladores");
		btnVentilacion.setBackground(SystemColor.inactiveCaption);
		btnVentilacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVentilacion.setBounds(304, 286, 118, 136);
		add(btnVentilacion);
		
		JButton btnFermentacion = new JButton("Fermentación");
		btnFermentacion.setBackground(SystemColor.inactiveCaption);
		btnFermentacion.setBounds(432, 286, 118, 136);
		add(btnFermentacion);
		
		JButton btnHornos = new JButton("Hornos");
		btnHornos.setBackground(SystemColor.inactiveCaption);
		btnHornos.setBounds(560, 286, 118, 136);
		add(btnHornos);
		
		JButton btnVAR = new JButton("VAR");
		btnVAR.setBackground(SystemColor.inactiveCaption);
		btnVAR.setBounds(688, 286, 118, 136);
		add(btnVAR);
		
		JButton btnResistencias = new JButton("Resistencias");
		btnResistencias.setBackground(SystemColor.inactiveCaption);
		btnResistencias.setBounds(252, 459, 320, 73);
		add(btnResistencias);
		
		JButton btnVarDos = new JButton("VAR - 2");
		btnVarDos.setBackground(SystemColor.inactiveCaption);
		btnVarDos.setBounds(10, 232, 82, 136);
		add(btnVarDos);
		
		JButton btnFontaneria = new JButton("Fontanería");
		btnFontaneria.setBackground(SystemColor.inactiveCaption);
		btnFontaneria.setBounds(582, 459, 293, 73);
		add(btnFontaneria);
		
		JButton btnCobre = new JButton("Cobre");
		btnCobre.setBackground(SystemColor.inactiveCaption);
		btnCobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCobre.setBounds(885, 396, 94, 136);
		add(btnCobre);
		
		JButton btnCompresores = new JButton("Compresores");
		btnCompresores.setBackground(SystemColor.inactiveCaption);
		btnCompresores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompresores.setBounds(10, 379, 232, 153);
		add(btnCompresores);
		
		JButton btnFrio = new JButton("Frío");
		btnFrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFrio.setBackground(SystemColor.inactiveCaption);
		btnFrio.setBounds(304, 229, 118, 47);
		add(btnFrio);
		
	}
}
