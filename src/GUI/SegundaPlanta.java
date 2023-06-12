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

public class SegundaPlanta {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegundaPlanta window = new SegundaPlanta();
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
	public SegundaPlanta() {
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
		logo.setIcon(new ImageIcon("media/logo.png"));
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
		
		JButton btnVariosCuatro = new JButton("Varios 4");
		btnVariosCuatro.setBackground(SystemColor.inactiveCaption);
		btnVariosCuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVariosCuatro.setBounds(135, 27, 713, 68);
		panelContenido.add(btnVariosCuatro);
		
		JButton btnBombillas = new JButton("Bombillas");
		btnBombillas.setBackground(SystemColor.inactiveCaption);
		btnBombillas.setBounds(32, 95, 100, 100);
		panelContenido.add(btnBombillas);
		
		JButton btnCablesYElectricidad = new JButton("Electricidad 1");
		btnCablesYElectricidad.setBackground(SystemColor.inactiveCaption);
		btnCablesYElectricidad.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCablesYElectricidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCablesYElectricidad.setBounds(858, 106, 100, 214);
		panelContenido.add(btnCablesYElectricidad);
		
		JButton btnNewButton = new JButton("Fluorescentes");
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(32, 200, 100, 332);
		panelContenido.add(btnNewButton);
		
		JButton btnMaquinaria = new JButton("Maquinaria");
		btnMaquinaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMaquinaria.setBackground(SystemColor.inactiveCaptionBorder);
		btnMaquinaria.setBounds(401, 228, 175, 170);
		panelContenido.add(btnMaquinaria);
		
		JButton btnCables = new JButton("Cables");
		btnCables.setBackground(SystemColor.inactiveCaption);
		btnCables.setBounds(858, 27, 100, 68);
		panelContenido.add(btnCables);
		
		JButton btnElectricidad = new JButton("Electricidad 2");
		btnElectricidad.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnElectricidad.setBackground(SystemColor.inactiveCaption);
		btnElectricidad.setBounds(858, 324, 100, 208);
		panelContenido.add(btnElectricidad);
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
