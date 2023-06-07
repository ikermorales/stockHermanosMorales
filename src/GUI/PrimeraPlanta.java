package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

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
		panelContenido.setBorder(null);
		panelContenido.setBackground(new Color(239, 242, 250));
		panelContenido.setBounds(121, 134, 989, 543);
		panel.add(panelContenido);
		panelContenido.setLayout(null);
		
		JButton btnTermopan = new JButton("Termopan");
		btnTermopan.setBackground(SystemColor.inactiveCaption);
		btnTermopan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTermopan.setBounds(10, 11, 245, 47);
		panelContenido.add(btnTermopan);
		
		JButton btnLateralDos = new JButton("Lateral 2");
		btnLateralDos.setBackground(SystemColor.inactiveCaption);
		btnLateralDos.setBounds(10, 70, 245, 47);
		panelContenido.add(btnLateralDos);
		
		JButton btnNLateralTres = new JButton("Lateral 3");
		btnNLateralTres.setBackground(SystemColor.inactiveCaption);
		btnNLateralTres.setBounds(10, 128, 245, 47);
		panelContenido.add(btnNLateralTres);
		
		JButton btnCovi = new JButton("Covi");
		btnCovi.setBackground(SystemColor.inactiveCaption);
		btnCovi.setBounds(137, 186, 118, 37);
		panelContenido.add(btnCovi);
		
		JButton btnVentilacion = new JButton("Ventiladores");
		btnVentilacion.setBackground(SystemColor.inactiveCaption);
		btnVentilacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVentilacion.setBounds(304, 286, 118, 136);
		panelContenido.add(btnVentilacion);
		
		JButton btnFermentacion = new JButton("Fermentadoras");
		btnFermentacion.setBackground(SystemColor.inactiveCaption);
		btnFermentacion.setBounds(432, 286, 118, 136);
		panelContenido.add(btnFermentacion);
		
		JButton btnHornos = new JButton("Hornos");
		btnHornos.setBackground(SystemColor.inactiveCaption);
		btnHornos.setBounds(560, 286, 118, 136);
		panelContenido.add(btnHornos);
		
		JButton btnVAR = new JButton("VAR");
		btnVAR.setBackground(SystemColor.inactiveCaption);
		btnVAR.setBounds(688, 286, 118, 136);
		panelContenido.add(btnVAR);
		
		JButton btnResistencias = new JButton("Resistencias");
		btnResistencias.setBackground(SystemColor.inactiveCaption);
		btnResistencias.setBounds(252, 459, 320, 73);
		panelContenido.add(btnResistencias);
		
		JButton btnVarDos = new JButton("VAR - 2");
		btnVarDos.setBackground(SystemColor.inactiveCaption);
		btnVarDos.setBounds(10, 232, 82, 136);
		panelContenido.add(btnVarDos);
		
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
		
		JButton btnCompresores = new JButton("Compresores");
		btnCompresores.setBackground(SystemColor.inactiveCaption);
		btnCompresores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompresores.setBounds(10, 379, 232, 153);
		panelContenido.add(btnCompresores);
		
		JButton btnFrio = new JButton("Frío");
		btnFrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFrio.setBackground(SystemColor.inactiveCaption);
		btnFrio.setBounds(304, 229, 118, 47);
		panelContenido.add(btnFrio);
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
