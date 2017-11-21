package sqliteclase;

import java.sql.Connection;

public class Conexion {
    // LOS DISTINTOS METODOS ESTATICOS CONECTARAN CON LAS DIFERENTES BBDD
    public static java.sql.Connection mySQL(String baseDatos, String username, String password) {
        java.sql.Connection con = null;
        try { 
                // 1.1) Cargamos el driver JDBC que vayamos a usar
                        Class.forName("com.mysql.jdbc.Driver");
                // 1.2) Establecemos una conexión con nuestra base de datos
                //El objeto Properties hace que salgan tildes y eñes, también podemos añadir el usuario y contraseña
                        java.util.Properties props = new java.util.Properties();
                        props.put("charSet", "iso-8859-1");
                        props.put("user", username);
                        props.put("password", password);
                //conectamos con la base de datos
                        String url = "jdbc:mysql://localhost:3306/" + baseDatos;
                        con = (java.sql.Connection) java.sql.DriverManager.getConnection(url, props);
                        return con;
        } catch (java.sql.SQLException e) {
                System.out.println("SQL Exception: " + e.toString());
                return null;         
        } catch (ClassNotFoundException e) {
                System.out.println("Class Not Found Exception: " 
                + e.toString());
                return null;
        }   
    }
    // CONEXION PARA DERBY //
    public static Connection derby(String baseDatos, String username, String password) {
	Connection con = null;
	try {
		// 1.1) Cargamos el driver Conexion que vayamos a usar
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		//especificamos el driver
		// 1.2) Establecemos una conexión con nuestra base de datos
		//El objeto Properties hace que salgan tildes y eñes, también podemos añadir el usuario y contraseña
			java.util.Properties props = new java.util.Properties();
			props.put("charSet", "iso-8859-1");
			props.put("user", username);
			props.put("password", password);
		//conectamos con la base de datos
			String url = "jdbc:derby://localhost:1527/"+baseDatos; 
			con = (java.sql.Connection) java.sql.DriverManager.getConnection(url, props);
			return con;
	} catch (java.sql.SQLException e) {
		System.out.println("SQL Exception: " + e.toString());
	} catch (ClassNotFoundException e) {
		System.out.println("Class Not Found Exception: "+ e.toString());
	}
	return null;
    }
    // CONEXION PARA SQLite //
    public static Connection sqlite(String baseDatos) {
	Connection con = null;
	try {
		// 1.1) Cargamos el driver Conexion que vayamos a usar
			Class.forName("org.sqlite.JDBC");
		//especificamos el driver
		// 1.2) Establecemos una conexión con nuestra base de datos
		//El objeto Properties hace que salgan tildes y eñes, también podemos añadir el usuario y contraseña
			java.util.Properties props = new java.util.Properties();
			props.put("charSet", "iso-8859-1");
		//conectamos con la base de datos
			String url = baseDatos;
			con = (java.sql.Connection) java.sql.DriverManager.getConnection(url, props);
			return con;
	} catch (java.sql.SQLException e) {
		System.out.println("SQL Exception: " + e.toString());
		return null;
	} catch (ClassNotFoundException e) {
		System.out.println("Class Not Found Exception: " + e.toString());
		return null;
	}
    }
}
