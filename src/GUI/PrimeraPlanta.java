package GUI;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

import BuisnessLogic.LadoEstanteria;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.GridLayout;

public class PrimeraPlanta {

	private JFrame frame;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeraPlanta window = new PrimeraPlanta();
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
	public PrimeraPlanta() {
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
		btnPlantaDos.setIcon(null);
		btnPlantaDos.setBounds(20, 134, 91, 269);
		panel.add(btnPlantaDos);
		btnPlantaDos.setForeground(new Color(255, 255, 255));
		btnPlantaDos.setBackground(new Color(50, 80, 152));
		btnPlantaDos.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:\\Users\\Asus\\Documents\\GitHub\\stockHermanosMorales\\media\\logo.png"));
		logo.setBounds(22, 22, 234, 88);
		panel.add(logo);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(50, 81, 152));
		separator.setBounds(20, 121, 1090, 2);
		panel.add(separator);
		
		
		
		
		
		
		
		JPanel panelContenido = new JPanel();
		
		
		//Estanterías de esta ventana
		LadoEstanteria variosDos = new LadoEstanteria(1,"Hornos",'D',3, new ArrayList<>());
		variosDos.construirSecciones();
		
		LadoEstanteria fermentadorasIZQ = new LadoEstanteria(1,"Fermentadoras IZQ",'D',3, new ArrayList<>());
		fermentadorasIZQ.construirSecciones();
		
		LadoEstanteria fermentadorasDCH = new LadoEstanteria(1,"Fermentadoras DCH",'D',3, new ArrayList<>());
		fermentadorasDCH.construirSecciones();
		
		LadoEstanteria cobre = new LadoEstanteria(1,"Cobre",'D',11, new ArrayList<>());
		cobre.construirSecciones();
		
		LadoEstanteria fontaneria = new LadoEstanteria(1,"Fontanería",'A',4, new ArrayList<>());
		fontaneria.construirSecciones();
		
		LadoEstanteria resistencias = new LadoEstanteria(1,"Resistencias",'A',4, new ArrayList<>());
		resistencias.construirSecciones();
		
		LadoEstanteria compresoresUno = new LadoEstanteria(1,"Compresores 1",'A',4, new ArrayList<>());
		compresoresUno.construirSecciones();
		
		LadoEstanteria compresoresDos = new LadoEstanteria(1,"Compresores 2",'A',3, new ArrayList<>());
		compresoresDos.construirSecciones();
		
		LadoEstanteria hornosDCH = new LadoEstanteria(1,"Hornos DCH",'D',3, new ArrayList<>());
		hornosDCH.construirSecciones();
		
		LadoEstanteria hornosIZQ = new LadoEstanteria(1,"Hornos IZQ",'D',3, new ArrayList<>());
		hornosIZQ.construirSecciones();
		
		LadoEstanteria variosDCH = new LadoEstanteria(1,"Varios 1 DCH",'D',3, new ArrayList<>());
		variosDCH.construirSecciones();
		
		LadoEstanteria variosIZQ = new LadoEstanteria(1,"Varios 1 IZQ",'D',3, new ArrayList<>());
		variosIZQ.construirSecciones();
		
		LadoEstanteria variosLateralArriba = new LadoEstanteria(1,"Varios 1 Lateral-1",'A',1, new ArrayList<>());
		variosLateralArriba.construirSecciones();
		
		LadoEstanteria variosLateralAbajo = new LadoEstanteria(1,"Varios 1 Lateral-3",'A',1, new ArrayList<>());
		variosLateralAbajo.construirSecciones();
		
		LadoEstanteria termopan = new LadoEstanteria(1,"Termopan",'3',1, new ArrayList<>());
		termopan.construirSecciones();
		
		
		panelContenido.setBorder(null);
		panelContenido.setBackground(new Color(239, 242, 250));
		panelContenido.setBounds(121, 134, 989, 543);
		panel.add(panelContenido);
		panelContenido.setLayout(null);
		
		JButton btnCovi = new JButton("Covi");
		btnCovi.setBackground(SystemColor.inactiveCaption);
		btnCovi.setBounds(137, 186, 118, 37);
		panelContenido.add(btnCovi);
		
		JButton btnResistencias = new JButton("Resistencias");
		btnResistencias.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnResistencias.setBackground(SystemColor.inactiveCaption);
		btnResistencias.setBounds(252, 459, 320, 73);
		panelContenido.add(btnResistencias);
		
		JButton btnVariosDos = new JButton("Varios 2");
		btnVariosDos.setBackground(SystemColor.inactiveCaption);
		btnVariosDos.setBounds(10, 232, 118, 136);
		panelContenido.add(btnVariosDos);
		
		JButton btnFontaneria = new JButton("Fontanería");
		btnFontaneria.setBackground(SystemColor.inactiveCaption);
		btnFontaneria.setBounds(582, 459, 293, 73);
		panelContenido.add(btnFontaneria);
		
		JButton btnCobre = new JButton("Cobre");
		btnCobre.setBackground(SystemColor.inactiveCaption);
		btnCobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCobre.setBounds(885, 396, 94, 136);
		panelContenido.add(btnCobre);
		
		JButton btnCompresores = new JButton("Compresores 2");
		btnCompresores.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCompresores.setBackground(SystemColor.inactiveCaption);
		btnCompresores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompresores.setBounds(10, 379, 118, 80);
		panelContenido.add(btnCompresores);
		
		JButton btnFrio = new JButton("Frío");
		btnFrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnFrio.setBackground(SystemColor.inactiveCaption);
		btnFrio.setBounds(304, 229, 118, 47);
		panelContenido.add(btnFrio);
		
		JPanel panel_Ventiladores = new JPanel();
		panel_Ventiladores.setBounds(304, 286, 118, 136);
		panelContenido.add(panel_Ventiladores);
		panel_Ventiladores.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnVentiladoresDCH = new JButton("DCH");
		btnVentiladoresDCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_Ventiladores.add(btnVentiladoresDCH);
		btnVentiladoresDCH.setBackground(SystemColor.inactiveCaption);
		
		JButton btnVentiladoresIZQ = new JButton("IZQ");
		btnVentiladoresIZQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_Ventiladores.add(btnVentiladoresIZQ);
		btnVentiladoresIZQ.setBackground(SystemColor.inactiveCaption);
		
		JPanel panel_Fermentadoras = new JPanel();
		panel_Fermentadoras.setBounds(432, 286, 118, 136);
		panelContenido.add(panel_Fermentadoras);
		panel_Fermentadoras.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnFermentadorasDCH = new JButton("DCH");
		btnFermentadorasDCH.setBackground(SystemColor.inactiveCaption);
		panel_Fermentadoras.add(btnFermentadorasDCH);
		
		JButton btnFermentadorasIZQ = new JButton("IZQ");
		btnFermentadorasIZQ.setBackground(SystemColor.inactiveCaption);
		panel_Fermentadoras.add(btnFermentadorasIZQ);
		
		JPanel panel_Hornos = new JPanel();
		panel_Hornos.setBounds(560, 286, 118, 136);
		panelContenido.add(panel_Hornos);
		panel_Hornos.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnHornosDCH = new JButton("DCH");
		btnHornosDCH.setBackground(SystemColor.inactiveCaption);
		panel_Hornos.add(btnHornosDCH);
		
		JButton btnHornosIZQ = new JButton("IZQ");
		btnHornosIZQ.setBackground(SystemColor.inactiveCaption);
		panel_Hornos.add(btnHornosIZQ);
		
		JPanel panel_VariosUno = new JPanel();
		panel_VariosUno.setBounds(688, 317, 118, 73);
		panelContenido.add(panel_VariosUno);
		panel_VariosUno.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnVarios1DCH = new JButton("DCH");
		btnVarios1DCH.setBackground(SystemColor.inactiveCaption);
		panel_VariosUno.add(btnVarios1DCH);
		
		JButton btnVarios1IZQ = new JButton("IZQ");
		btnVarios1IZQ.setBackground(SystemColor.inactiveCaption);
		panel_VariosUno.add(btnVarios1IZQ);
		
		JPanel panel_LateralUno = new JPanel();
		panel_LateralUno.setBounds(10, 131, 245, 44);
		panelContenido.add(panel_LateralUno);
		panel_LateralUno.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnLateral1DCH = new JButton("Lateral 1 - DCH");
		btnLateral1DCH.setBackground(SystemColor.inactiveCaption);
		panel_LateralUno.add(btnLateral1DCH);
		
		JButton btnLateral1IZQ = new JButton("Lateral 1 - IZQ");
		btnLateral1IZQ.setBackground(SystemColor.inactiveCaption);
		panel_LateralUno.add(btnLateral1IZQ);
		
		JPanel panel_LateralDos = new JPanel();
		panel_LateralDos.setBounds(10, 76, 245, 44);
		panelContenido.add(panel_LateralDos);
		panel_LateralDos.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnLateral2DCH = new JButton("Lateral 2 - DCH");
		btnLateral2DCH.setBackground(SystemColor.inactiveCaption);
		panel_LateralDos.add(btnLateral2DCH);
		
		JButton btnLateral2IZQ = new JButton("Lateral 2 - IZQ");
		btnLateral2IZQ.setBackground(SystemColor.inactiveCaption);
		panel_LateralDos.add(btnLateral2IZQ);
		
		JPanel panel_Termopan = new JPanel();
		panel_Termopan.setBounds(10, 24, 245, 44);
		panelContenido.add(panel_Termopan);
		panel_Termopan.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnTermoPanDCH = new JButton("Termopan - DCH");
		btnTermoPanDCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnTermoPanDCH.setBackground(SystemColor.inactiveCaption);
		panel_Termopan.add(btnTermoPanDCH);
		
		JButton btnTermopanIZQ = new JButton("Termopan - IZQ");
		btnTermopanIZQ.setBackground(SystemColor.inactiveCaption);
		panel_Termopan.add(btnTermopanIZQ);
		
		JLabel lblVentiladores = new JLabel("Ventiladores");
		lblVentiladores.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentiladores.setBounds(326, 422, 80, 14);
		panelContenido.add(lblVentiladores);
		
		JLabel lblFermentadoras = new JLabel("Fermentadoras");
		lblFermentadoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblFermentadoras.setBounds(432, 422, 118, 14);
		panelContenido.add(lblFermentadoras);
		
		JLabel lblHornos = new JLabel("Hornos");
		lblHornos.setHorizontalAlignment(SwingConstants.CENTER);
		lblHornos.setBounds(560, 422, 118, 14);
		panelContenido.add(lblHornos);
		
		JLabel lblVarios1 = new JLabel("Varios 1");
		lblVarios1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVarios1.setBounds(688, 422, 118, 14);
		panelContenido.add(lblVarios1);
		
		JButton btnCompresores_2 = new JButton("Compresores 1");
		btnCompresores_2.setBackground(SystemColor.inactiveCaption);
		btnCompresores_2.setBounds(10, 460, 236, 73);
		panelContenido.add(btnCompresores_2);
		
		JButton btnVarios1LateralAbajo = new JButton("Lateral");
		btnVarios1LateralAbajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVarios1LateralAbajo.setBackground(SystemColor.inactiveCaption);
		btnVarios1LateralAbajo.setBounds(688, 391, 118, 31);
		panelContenido.add(btnVarios1LateralAbajo);
		
		JButton btnVarios1LateralArriba = new JButton("Lateral");
		btnVarios1LateralArriba.setBackground(SystemColor.inactiveCaption);
		btnVarios1LateralArriba.setBounds(688, 285, 118, 31);
		panelContenido.add(btnVarios1LateralArriba);
		btnPlantaDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlantaUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
