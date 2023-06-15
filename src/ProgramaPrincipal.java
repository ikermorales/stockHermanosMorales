import java.sql.Connection; 
import java.sql.SQLException;
import javax.swing.JOptionPane;

import GUI.VentanaPrincipal;
import baseDeDatos.ConexionBD;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		
		try {
			ConexionBD bd = new ConexionBD("50.62.223.194", "MaquinariaHnosMorales", "usuarioStock", "usuarioStock");
			bd.conectar();
			VentanaPrincipal ventanaMain = new VentanaPrincipal(bd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
			e.printStackTrace();
		}
		

	}
}
