package baseDeDatos;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BuisnessLogic.Componente;

public class ConexionBD {

	private String serverIP;
	private String dbName;
	private String user;
	private String password;
	private Connection connection; // Declaración de la variable de instancia

	public ConexionBD(String serverIP, String dbName, String user, String password) {
		this.serverIP = serverIP;
		this.dbName = dbName;
		this.user = user;
		this.password = password;
	}

	public void conectar() throws SQLException {
		String url = "jdbc:mysql://" + this.serverIP + ":3306/" + this.dbName;
		this.connection = DriverManager.getConnection(url, this.user, this.password);
	}

	public void cerrar() throws SQLException {
		if (this.connection != null && !this.connection.isClosed()) {
			this.connection.close();
		}
	}

	public ArrayList<Componente> obtenerStockFiltrado(String estanteria, int piso, String balda, String lado) throws SQLException {
		conectar();

		ArrayList<Componente> componentes = new ArrayList<>();

		String sql = "SELECT * FROM Stock WHERE piso= ? AND estanteria= ? AND balda= ?";
		if(lado != null && !lado.isBlank()) {
			sql += " AND lado= ?";
		}



		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.setInt(1, piso);
			statement.setString(2, estanteria);
			statement.setString(3, balda);
			if(lado != null && !lado.isBlank()) {
				statement.setString(4, lado);
			}

			System.out.println(statement);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String iD = resultSet.getString(1);
				String nombre = resultSet.getString(2);
				int cantidadActual = resultSet.getInt(3);
				int cantidadAvisoMax = resultSet.getInt(4);
				int cantidadAvisoMin = resultSet.getInt(5);
				float precio = resultSet.getFloat(6);
				String estanteriaBD = resultSet.getString(7);
				int pisoBD = resultSet.getInt(8);
				String baldaBD = resultSet.getString(9);
				String ladoBD = resultSet.getString(10);
				int planta = resultSet.getInt(11);

				Componente componente = new Componente(iD, nombre, cantidadActual, cantidadAvisoMax, cantidadAvisoMin, precio, estanteriaBD, pisoBD, baldaBD, ladoBD, planta);
				componentes.add(componente);
			}
		}

		cerrar();
		return componentes;
	}
	
	public ArrayList<Componente> obtenerStockNombre(String nombre) throws SQLException {
		conectar();

		ArrayList<Componente> componentes = new ArrayList<>();

		String sql = "SELECT * FROM Stock WHERE nombre LIKE ?";

	    try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
	        statement.setString(1, "%" + nombre + "%");


			System.out.println(statement);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String iD = resultSet.getString(1);
				String nombre1 = resultSet.getString(2);
				int cantidadActual = resultSet.getInt(3);
				int cantidadAvisoMax = resultSet.getInt(4);
				int cantidadAvisoMin = resultSet.getInt(5);
				float precio = resultSet.getFloat(6);
				String estanteriaBD = resultSet.getString(7);
				int pisoBD = resultSet.getInt(8);
				String baldaBD = resultSet.getString(9);
				String ladoBD = resultSet.getString(10);
				int planta = resultSet.getInt(11);

				Componente componente = new Componente(iD, nombre1, cantidadActual, cantidadAvisoMax, cantidadAvisoMin, precio, estanteriaBD, pisoBD, baldaBD, ladoBD, planta);
				componentes.add(componente);
			}
		}

		cerrar();
		return componentes;
	}
	
	public ArrayList<Componente> obtenerStockID(String id) throws SQLException {
		conectar();

		ArrayList<Componente> componentes = new ArrayList<>();

		String sql = "SELECT * FROM Stock WHERE ID LIKE ?";

	    try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
	        statement.setString(1, "%" + id + "%");


			System.out.println(statement);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String iD = resultSet.getString(1);
				String nombre1 = resultSet.getString(2);
				int cantidadActual = resultSet.getInt(3);
				int cantidadAvisoMax = resultSet.getInt(4);
				int cantidadAvisoMin = resultSet.getInt(5);
				float precio = resultSet.getFloat(6);
				String estanteriaBD = resultSet.getString(7);
				int pisoBD = resultSet.getInt(8);
				String baldaBD = resultSet.getString(9);
				String ladoBD = resultSet.getString(10);
				int planta = resultSet.getInt(11);

				Componente componente = new Componente(iD, nombre1, cantidadActual, cantidadAvisoMax, cantidadAvisoMin, precio, estanteriaBD, pisoBD, baldaBD, ladoBD, planta);
				componentes.add(componente);
			}
		}

		cerrar();
		return componentes;
	}


	public void anyadirCantidadConcreta(int cantidad, Componente componente) throws SQLException {
		conectar();

		String sql = "UPDATE Stock SET cantidadActual = cantidadActual + ? WHERE ID = ?";

		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.setInt(1, cantidad);
			statement.setString(2, componente.getId());

			System.out.println(statement);

			int rowsUpdated = statement.executeUpdate();

			if (rowsUpdated > 0 && componente.getCantidadActual() + cantidad > componente.getCanitdadAvisoMax()) {
				JOptionPane.showMessageDialog(null, "AVISO: Se han añadido unidades que han dejado " + componente.getNombre() + " por encima de la cantidad establecida.");
			}
		}

		JOptionPane.showMessageDialog(null, "CONFIRMACION: Añadidas " + cantidad + " unidades de " + componente.getNombre() + ".");

		cerrar();
	}

	public void eliminarCantidadConcreta(int cantidad, Componente componente) throws SQLException {
		conectar();

		if(cantidad < 0) {
			JOptionPane.showMessageDialog(null, "La cantidad a eliminar no puede ser menor a 0.");
			return;
		}
		if(cantidad > componente.getCantidadActual()) {
			JOptionPane.showMessageDialog(null, "No puedes retirar más de la cantidad actual de " + componente.getNombre());
			return;
		}

		String sql = "UPDATE Stock SET cantidadActual = cantidadActual - ? WHERE ID = ?";

		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.setInt(1, cantidad);
			statement.setString(2, componente.getId());

			System.out.println(statement);

			int rowsUpdated = statement.executeUpdate();

			if (rowsUpdated > 0) {
				componente.setCantidadActual(componente.getCantidadActual() - cantidad); // Actualiza la cantidad actual del objeto en memoria
				if(componente.getCantidadActual() <= componente.getCantidadAvisoMin()) {
					JOptionPane.showMessageDialog(null, "AVISO: Se han reitrado unidades que han dejado " + componente.getNombre() + " por debajo de la cantidad establecida.");
				}

				if(componente.getCantidadActual() == 0) {
					int dialogResult = JOptionPane.showConfirmDialog(null, "Has retirado todas las unidades de " + componente.getNombre() + ", ¿Quieres eliminar el registro?", "Alerta", JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						eliminarComponente(componente, false);
						return;
					}
				}
			}
		}

		JOptionPane.showMessageDialog(null, "CONFIRMACION: Retiradas " + cantidad + " unidades de " + componente.getNombre() + ".");

		cerrar();
	}

	public void eliminarComponente(Componente componente, boolean preguntar) throws SQLException {
		conectar();

		if(preguntar) {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Realmente deseas eliminar el registro: " + componente.getNombre() + ".", "Alerta", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.NO_OPTION){
				cerrar();
				return;
			}
		}

		String sql = "DELETE FROM Stock WHERE ID = ?";

		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.setString(1, componente.getId());

			System.out.println(statement);

			int rowsDeleted = statement.executeUpdate();

			if (rowsDeleted > 0) {
				JOptionPane.showMessageDialog(null, "El componente " + componente.getNombre() + " ha sido eliminado correctamente.");
			}
		}

		cerrar();
		return;
	}


	public void actualizarComponente(Componente componente) throws SQLException {

		if (componente.getCantidadActual() < 0) {
			JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor o igual a cero.");
			return;
		}

		if (componente.getCanitdadAvisoMax() < componente.getCantidadAvisoMin()) {
			JOptionPane.showMessageDialog(null, "La cantidad máxima debe ser mayor que la cantidad mínima.");
			return;
		}

		conectar();

		String sql = "UPDATE Stock SET nombre = ?, precio = ?, cantidadActual = ?, cantidadAvisoMax = ?, cantidadAvisoMin = ? WHERE ID = ?";

		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.setString(1, componente.getNombre());
			statement.setFloat(2, componente.getPrecio());
			statement.setInt(3, componente.getCantidadActual());
			statement.setInt(4, componente.getCanitdadAvisoMax());
			statement.setInt(5, componente.getCantidadAvisoMin());
			statement.setString(6, componente.getId());

			System.out.println(statement);

			int rowsUpdated = statement.executeUpdate();

			if (rowsUpdated > 0) {
				JOptionPane.showMessageDialog(null, "El componente " + componente.getNombre() + " ha sido actualizado correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "No se ha podido actualizar el componente. Por favor, comprueba el ID e inténtalo de nuevo.");
			}
		}

		cerrar();
	}


	public void insertarComponente(Componente componente) throws SQLException {
		conectar();

		String sql = "INSERT INTO Stock (ID, nombre, cantidadActual, cantidadAvisoMax, cantidadAvisoMin, precio, estanteria, piso, balda, lado, planta) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, componente.getId());
			statement.setString(2, componente.getNombre());
			statement.setInt(3, componente.getCantidadActual());
			statement.setInt(4, componente.getCanitdadAvisoMax());
			statement.setInt(5, componente.getCantidadAvisoMin());
			statement.setFloat(6, componente.getPrecio());
			statement.setString(7, componente.getEstanteria());
			statement.setInt(8, componente.getPiso());
			statement.setString(9, componente.getBalda());
			statement.setString(10, componente.getLado());
			statement.setInt(11, componente.getPlanta());

			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro " + componente.getId() + " insertado correctamente en la base de datos.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		cerrar();
	}

	
	
	public void generarYAbrirExcel(String tipoGeneracion, String piso, String balda) throws SQLException, IOException {
	    conectar();

	    String excelFilePath = "datos_estanteria.xlsx";

	    try (Workbook workbook = new XSSFWorkbook();
	         FileOutputStream fileOut = new FileOutputStream(excelFilePath)) {

	        String sql = "SELECT * FROM Stock";
	        if (tipoGeneracion.equals("planta")) {
	            sql += " ORDER BY planta, estanteria";
	        } else if (tipoGeneracion.equals("estanteria")) {
	            sql += " ORDER BY estanteria, planta, piso, balda";
	        } else if (tipoGeneracion.equals("seccion")) {
	            sql += " WHERE piso = ? AND balda = ? ORDER BY estanteria";
	        } else {
	            sql += " ORDER BY estanteria";
	        }

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            if (tipoGeneracion.equals("seccion")) {
	                statement.setString(1, piso);
	                statement.setString(2, balda);
	            }

	            try (ResultSet resultSet = statement.executeQuery()) {
	                Sheet sheet = workbook.createSheet("Datos");

	                // Crear encabezados de columna
	                ResultSetMetaData metaData = resultSet.getMetaData();
	                int columnCount = metaData.getColumnCount();
	                Row headerRow = sheet.createRow(0);
	                for (int i = 1; i <= columnCount; i++) {
	                    Cell cell = headerRow.createCell(i - 1);
	                    cell.setCellValue(metaData.getColumnName(i));
	                }

	                // Llenar datos de las filas
	                int rowNum = 1;
	                while (resultSet.next()) {
	                    Row row = sheet.createRow(rowNum++);
	                    for (int i = 1; i <= columnCount; i++) {
	                        Cell cell = row.createCell(i - 1);
	                        cell.setCellValue(resultSet.getString(i));
	                    }
	                }
	            }
	        }

	        workbook.write(fileOut);
	        System.out.println("El archivo Excel se generó correctamente.");

	        // Abrir el archivo Excel
	        File excelFile = new File(excelFilePath);
	        Desktop.getDesktop().open(excelFile);
	    }

	    cerrar();
	}





}