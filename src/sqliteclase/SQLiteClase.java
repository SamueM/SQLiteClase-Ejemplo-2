package sqliteclase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteClase {
    
    public static void main(String[] args) {
        
	//Paso 1: Conectar con la base de datos
	Connection conexion = null;
	conexion = Conexion.sqlite("..\\src\\sqliteclase\\db_clase.sqlite");
	if (conexion != null) {
		System.out.println("Conexion realizada con éxito");
		try {
			ResultSet rs = null;
			Statement sentencia = conexion.createStatement(); 
			String sql = "SELECT * FROM clase";
			rs = sentencia.executeQuery(sql);
			while (rs.next()) {
                            String nombre = rs.getString("nombre"); 
                            String apellido = rs.getString("apellido"); 
                            System.out.println(nombre + ", " + apellido );
			}  
		} catch (SQLException ex) {
			System.out.println("Error SQL");
		}
	}

    }
    
}
