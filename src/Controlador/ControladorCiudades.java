package Controlador;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class ControladorCiudades {
	public void guardarEnBaseDatos(String ciudad, int codigoPostal) {
		try {
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:C:\\bbdd\\prueba.txt";
			Connection conexion = DriverManager.getConnection(url);

			if (conexion != null) {
				System.out.println("Hay conexion ");

			} else {
				System.out.println("no hay conexion ");
			}

			var pt = conexion.prepareStatement(" insert into Ciudades values ( ? , ?)");
			pt.setString(1, ciudad);
			pt.setInt(2, codigoPostal);

			pt.executeUpdate();

			if (conexion != null) {
				conexion.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showInternalMessageDialog(null, "ha ocurrido un error ");

		}
	}

	public boolean existeEnBaseDeDatos(String ciudad) {

		try {
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:C:\\bbdd\\prueba.txt";
			Connection conexion = DriverManager.getConnection(url);

			if (conexion != null) {
				System.out.println("Hay conexion ");

			} else {
				System.out.println("NO hay conexion ");
			}

			var pt = conexion.prepareStatement(" select * from Ciudades where nombre =  ? ");
			pt.setString(1, ciudad);
			ResultSet rs = pt.executeQuery();

			if (conexion != null) {
				conexion.close();

			}

			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showInternalMessageDialog(null, "ha ocurrido un error ");

		}
		return false;
	}

	public String listarBaseDeDatos() {

		try {
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:C:\\bbdd\\prueba.txt";
			Connection conexion = DriverManager.getConnection(url);

			if (conexion != null) {
				System.out.println("Hay conexion ");

			} else {
				System.out.println("NO hay conexion ");
			}

			var pt = conexion.prepareStatement(" select * from Ciudades ");

			ResultSet rs = pt.executeQuery();
			// crear una variable para guardar el mensaje construido y crear un bucle pra
			// resultnext :
			String mensaje = "";

			while (rs.next()) {
				mensaje += rs.getString(1) + "   " + "CP : " + rs.getInt(2);
				mensaje += "\n";

			}

			if (conexion != null) {
				conexion.close();

			}

			return mensaje;

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showInternalMessageDialog(null, "ha ocurrido un error ");

		}

		return null;
	}
	// eliminar de base de datos :

	public void eliminarDeBaseDatos(String ciudad) {

		try {
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:C:\\bbdd\\prueba.txt";
			Connection conexion = DriverManager.getConnection(url);

			if (conexion != null) {
				System.out.println("Hay conexion ");

			} else {
				System.out.println("no hay conexion ");
			}

			var pt = conexion.prepareStatement(" delete from Ciudades where nombre = ? ");
			pt.setString(1, ciudad);

			pt.executeUpdate();

			if (conexion != null) {
				conexion.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showInternalMessageDialog(null, "ha ocurrido un error ");

		}
	}

	// editar lista :
	public void modificarEnBaseDatos(String ciudad, int codigoPostal) 
	{
		try {
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:C:\\bbdd\\prueba.txt";
			Connection conexion = DriverManager.getConnection(url);

			if (conexion != null) {
				System.out.println("Hay conexion ");

			} else {
				System.out.println("no hay conexion ");
			}

			var pt = conexion.prepareStatement(" update Ciudades set codigoPostal = ? where nombre = ?");
			pt.setString(2, ciudad);
			pt.setInt(1, codigoPostal);

			pt.executeUpdate();

			if (conexion != null) {
				conexion.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showInternalMessageDialog(null, "ha ocurrido un error ");

		}

	}

}
