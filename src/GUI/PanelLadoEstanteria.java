package GUI;

import java.awt.EventQueue; 

import javax.swing.JFrame;
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
import java.awt.GridLayout;
import javax.swing.UIManager;

public class PanelLadoEstanteria {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelLadoEstanteria window = new PanelLadoEstanteria();
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
	public PanelLadoEstanteria() {
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
		panelContenido.setLayout(null);
		
		JPanel panelEstanteria = new JPanel();
		panelEstanteria.setBackground(new Color(176, 224, 230));
		panelEstanteria.setBorder(new LineBorder(UIManager.getColor("FormattedTextField.selectionBackground")));
		panelEstanteria.setBounds(33, 33, 921, 477);
		panelContenido.add(panelEstanteria);
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
		
		JLabel lblNombreEstanteria = new JLabel("Nombre");
		lblNombreEstanteria.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreEstanteria.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEstanteria.setBounds(10, 0, 969, 32);
		panelContenido.add(lblNombreEstanteria);
		
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
