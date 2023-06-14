package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import baseDeDatos.ConexionBD;

public class PanelPlantaUno extends JPanel{

	private static final long serialVersionUID = 1L;

	public PanelPlantaUno(ConexionBD bd, VentanaPrincipal vP) {
		
		setBorder(null);
		setBackground(new Color(239, 242, 250));
		setBounds(121, 134, 989, 543);
		setLayout(null);
		
		JButton btnCovi = new JButton("Covi");
		btnCovi.setBackground(SystemColor.inactiveCaption);
		btnCovi.setBounds(137, 186, 118, 37);
		add(btnCovi);
		btnCovi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 1, "A", "COVI", null, 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		
		JButton btnResistencias = new JButton("Resistencias");
		btnResistencias.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 4, "A", "RESISTENCIAS", null, 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnResistencias.setBackground(SystemColor.inactiveCaption);
		btnResistencias.setBounds(252, 459, 320, 73);
		add(btnResistencias);
		
		JButton btnVariosDos = new JButton("Varios 2");
		btnVariosDos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnVariosDos.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						vP.setPanelContenido(new LadoEstanteria(bd, vP, 3, "D", "VARIOS 2", null, 1));
						vP.btnPlantaUno.setEnabled(true);
						
					}
				});
				
			}
		});
		btnVariosDos.setBackground(SystemColor.inactiveCaption);
		btnVariosDos.setBounds(10, 232, 118, 136);
		add(btnVariosDos);
		
		JButton btnFontaneria = new JButton("Fontanería");
		btnFontaneria.setBackground(SystemColor.inactiveCaption);
		btnFontaneria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 4, "A", "FONTANERÍA", null, 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnFontaneria.setBounds(582, 459, 293, 73);
		add(btnFontaneria);
		
		JButton btnCobre = new JButton("Cobre");
		btnCobre.setBackground(SystemColor.inactiveCaption);
		btnCobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 11, "D", "COBRE", null, 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnCobre.setBounds(885, 396, 94, 136);
		add(btnCobre);
		
		JButton btnCompresores = new JButton("Compresores 2");
		btnCompresores.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCompresores.setBackground(SystemColor.inactiveCaption);
		btnCompresores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 3, "A", "COMPRESORES 2", null, 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnCompresores.setBounds(10, 379, 118, 80);
		add(btnCompresores);
		
		JButton btnFrio = new JButton("Frío");
		btnFrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 12, "A", "FRÍO", null, 1));
				vP.btnPlantaUno.setEnabled(true);
			}
		});
		btnFrio.setBackground(SystemColor.inactiveCaption);
		btnFrio.setBounds(304, 229, 118, 47);
		add(btnFrio);
		
		JPanel panel_Ventiladores = new JPanel();
		panel_Ventiladores.setBounds(304, 286, 118, 136);
		add(panel_Ventiladores);
		panel_Ventiladores.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnVentiladoresDCH = new JButton("DCH");
		btnVentiladoresDCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 4, "D", "VENTILADORES", "DCH", 1));
				vP.btnPlantaUno.setEnabled(true);
			}
		});
		panel_Ventiladores.add(btnVentiladoresDCH);
		btnVentiladoresDCH.setBackground(SystemColor.inactiveCaption);
		
		JButton btnVentiladoresIZQ = new JButton("IZQ");
		btnVentiladoresIZQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 4, "D", "VENTILADORES", "IZQ", 1));
				vP.btnPlantaUno.setEnabled(true);
			}
		});
		panel_Ventiladores.add(btnVentiladoresIZQ);
		btnVentiladoresIZQ.setBackground(SystemColor.inactiveCaption);
		
		JPanel panel_Fermentadoras = new JPanel();
		panel_Fermentadoras.setBounds(432, 286, 118, 136);
		add(panel_Fermentadoras);
		panel_Fermentadoras.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnFermentadorasDCH = new JButton("DCH");
		btnFermentadorasDCH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 3, "D", "FERMENTACION", "DCH", 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnFermentadorasDCH.setBackground(SystemColor.inactiveCaption);
		panel_Fermentadoras.add(btnFermentadorasDCH);
		
		
		JButton btnFermentadorasIZQ = new JButton("IZQ");
		btnFermentadorasIZQ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 3, "D", "FERMENTACION", "IZQ", 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnFermentadorasIZQ.setBackground(SystemColor.inactiveCaption);
		panel_Fermentadoras.add(btnFermentadorasIZQ);
		
		JPanel panel_Hornos = new JPanel();
		panel_Hornos.setBounds(560, 286, 118, 136);
		add(panel_Hornos);
		panel_Hornos.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnHornosDCH = new JButton("DCH");
		btnHornosDCH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 3, "D", "HORNOS", "DCH", 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnHornosDCH.setBackground(SystemColor.inactiveCaption);
		panel_Hornos.add(btnHornosDCH);
		
		JButton btnHornosIZQ = new JButton("IZQ");
		btnHornosIZQ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 3, "D", "HORNOS", "IZQ", 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnHornosIZQ.setBackground(SystemColor.inactiveCaption);
		panel_Hornos.add(btnHornosIZQ);
		
		JPanel panel_VariosUno = new JPanel();
		panel_VariosUno.setBounds(688, 317, 118, 73);
		add(panel_VariosUno);
		panel_VariosUno.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnVarios1DCH = new JButton("DCH");
		btnVarios1DCH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 3, "D", "VARIOS 1", "DCH", 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnVarios1DCH.setBackground(SystemColor.inactiveCaption);
		panel_VariosUno.add(btnVarios1DCH);
		
		JButton btnVarios1IZQ = new JButton("IZQ");
		btnVarios1IZQ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 3, "D", "VARIOS 1", "IZQ", 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnVarios1IZQ.setBackground(SystemColor.inactiveCaption);
		panel_VariosUno.add(btnVarios1IZQ);
		
		JPanel panel_LateralUno = new JPanel();
		panel_LateralUno.setBounds(10, 131, 245, 44);
		add(panel_LateralUno);
		panel_LateralUno.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnLateral1DCH = new JButton("Lateral 1 - DCH");
		
		btnLateral1DCH.setBackground(SystemColor.inactiveCaption);
		panel_LateralUno.add(btnLateral1DCH);
		btnLateral1DCH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 2, "C", "LATERAL 1", "DCH", 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		JButton btnLateral1IZQ = new JButton("Lateral 1 - IZQ");
		btnLateral1IZQ.setBackground(SystemColor.inactiveCaption);
		btnLateral1IZQ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 2, "C", "LATERAL 1", "IZQ", 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		panel_LateralUno.add(btnLateral1IZQ);
		
		JPanel panel_LateralDos = new JPanel();
		panel_LateralDos.setBounds(10, 76, 245, 44);
		add(panel_LateralDos);
		panel_LateralDos.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnLateral2DCH = new JButton("Lateral 2 - DCH");
		btnLateral2DCH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 2, "E", "LATERAL 2", "DCH", 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnLateral2DCH.setBackground(SystemColor.inactiveCaption);
		panel_LateralDos.add(btnLateral2DCH);
		
		JButton btnLateral2IZQ = new JButton("Lateral 2 - IZQ");
		btnLateral2IZQ.setBackground(SystemColor.inactiveCaption);
		btnLateral2IZQ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 2, "E", "LATERAL 2", "IZQ", 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		panel_LateralDos.add(btnLateral2IZQ);
		
		JPanel panel_Termopan = new JPanel();
		panel_Termopan.setBounds(10, 24, 245, 44);
		add(panel_Termopan);
		panel_Termopan.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnTermoPanDCH = new JButton("Termopan - DCH");
		btnTermoPanDCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 4, "A", "TERMOPAN", "DCH", 1));
				vP.btnPlantaUno.setEnabled(true);
			}
		});
		btnTermoPanDCH.setBackground(SystemColor.inactiveCaption);
		panel_Termopan.add(btnTermoPanDCH);
		
		JButton btnTermopanIZQ = new JButton("Termopan - IZQ");
		btnTermopanIZQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 4, "A", "TERMOPAN", "IZQ", 1));
				vP.btnPlantaUno.setEnabled(true);
			}
		});
		btnTermopanIZQ.setBackground(SystemColor.inactiveCaption);
		panel_Termopan.add(btnTermopanIZQ);
		
		JLabel lblVentiladores = new JLabel("Ventiladores");
		lblVentiladores.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentiladores.setBounds(326, 422, 80, 14);
		add(lblVentiladores);
		
		JLabel lblFermentadoras = new JLabel("Fermentadoras");
		lblFermentadoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblFermentadoras.setBounds(432, 422, 118, 14);
		add(lblFermentadoras);
		
		JLabel lblHornos = new JLabel("Hornos");
		lblHornos.setHorizontalAlignment(SwingConstants.CENTER);
		lblHornos.setBounds(560, 422, 118, 14);
		add(lblHornos);
		
		JLabel lblVarios1 = new JLabel("Varios 1");
		lblVarios1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVarios1.setBounds(688, 422, 118, 14);
		add(lblVarios1);
		
		JButton btnCompresores_1 = new JButton("Compresores 1");
		btnCompresores_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 4, "A", "Compresores 1", null, 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnCompresores_1.setBackground(SystemColor.inactiveCaption);
		btnCompresores_1.setBounds(10, 460, 236, 73);
		add(btnCompresores_1);
		
		JButton btnVarios1LateralAbajo = new JButton("Lateral");
		btnVarios1LateralAbajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 1, "A", "VARIOS 1", "LT2", 1));
				vP.btnPlantaUno.setEnabled(true);
			}
		});
		btnVarios1LateralAbajo.setBackground(SystemColor.inactiveCaption);
		btnVarios1LateralAbajo.setBounds(688, 391, 118, 31);
		add(btnVarios1LateralAbajo);
		
		JButton btnVarios1LateralArriba = new JButton("Lateral");
		btnVarios1LateralArriba.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vP.setPanelContenido(new LadoEstanteria(bd, vP, 1, "A", "VARIOS 1", "LT2", 1));
				vP.btnPlantaUno.setEnabled(true);
				
			}
		});
		btnVarios1LateralArriba.setBackground(SystemColor.inactiveCaption);
		btnVarios1LateralArriba.setBounds(688, 285, 118, 31);
		add(btnVarios1LateralArriba);
		
	}
	
}
