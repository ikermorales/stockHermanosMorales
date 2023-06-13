package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPlantaDos extends JPanel {
	
	public PanelPlantaDos() {
		setBorder(null);
		setBackground(new Color(239, 242, 250));
		setBounds(121, 134, 989, 543);
		setLayout(null);
		
		JButton btnVariosCuatro = new JButton("Varios 4");
		btnVariosCuatro.setBackground(SystemColor.inactiveCaption);
		btnVariosCuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVariosCuatro.setBounds(135, 27, 713, 68);
		add(btnVariosCuatro);
		
		JButton btnBombillas = new JButton("Bombillas");
		btnBombillas.setBackground(SystemColor.inactiveCaption);
		btnBombillas.setBounds(32, 95, 100, 100);
		add(btnBombillas);
		
		JButton btnCablesYElectricidad = new JButton("Electricidad 1");
		btnCablesYElectricidad.setBackground(SystemColor.inactiveCaption);
		btnCablesYElectricidad.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCablesYElectricidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCablesYElectricidad.setBounds(858, 106, 100, 214);
		add(btnCablesYElectricidad);
		
		JButton btnNewButton = new JButton("Fluorescentes");
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(32, 200, 100, 332);
		add(btnNewButton);
		
		JButton btnMaquinaria = new JButton("Maquinaria");
		btnMaquinaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMaquinaria.setBackground(SystemColor.inactiveCaptionBorder);
		btnMaquinaria.setBounds(401, 228, 175, 170);
		add(btnMaquinaria);
		
		JButton btnCables = new JButton("Cables");
		btnCables.setBackground(SystemColor.inactiveCaption);
		btnCables.setBounds(858, 27, 100, 68);
		add(btnCables);
		
		JButton btnElectricidad = new JButton("Electricidad 2");
		btnElectricidad.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnElectricidad.setBackground(SystemColor.inactiveCaption);
		btnElectricidad.setBounds(858, 324, 100, 208);
		add(btnElectricidad);

	
	}
	
}
