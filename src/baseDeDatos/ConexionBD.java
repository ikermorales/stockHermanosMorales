package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public ArrayList<Componente> obtenerStockCompleto(String estanteria, int piso, String balda, String lado) throws SQLException {
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

    public static void main(String[] args) {
        String serverIP = "50.62.223.194"; //IP DEL SERVER
        String dbName = "MaquinariaHnosMorales";
        String user = "usuarioStock";
        String password = "usuarioStock";

        ConexionBD conexion = new ConexionBD(serverIP, dbName, user, password);

    }
}