/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaconstruccion.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ferc
 */
public abstract class GenericDao<T> implements DAO<T> {
  
  	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://";
	
	protected Connection conectar() {
		String usuario = CredencialesBd.usuario;
		String pass = CredencialesBd.password;
		String bd = CredencialesBd.baseDatos;
		String host = CredencialesBd.host;
                int port = CredencialesBd.port;
		
	    Connection res = null;
	    try {
	      // Registrar JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
              String url = String.format(DB_URL, host, port, bd);
              System.out.println("casi conectó");
	      res = DriverManager.getConnection(url, usuario, pass);
              
              System.out.println("Se conectó");
	    } catch (SQLException sqe) {
	      sqe.printStackTrace();
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	    try {
			res.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return res;
	  }
  
}
