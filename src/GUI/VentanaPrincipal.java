package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import baseDeDatos.ConexionBD;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnPlantaUno;
	JButton btnPlantaDos;
	JPanel panelContenido;
	PanelPlantaUno panelPlantaUno;
	PanelPlantaDos panelPlantaDos;
	
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

