/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaconstruccion.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pruebaconstruccion.logica.Equipo;

/**
 *
 * @author ferc
 */
public class EquipoDao extends GenericDao<Equipo> {

  @Override
  public void guardarEquipo(int id, int numeroSerie, byte disponibilidad) {
    
    
    String insertTableSQL = "INSERT INTO prueba_construccion.equipo"
                + "(idequipo, numero_serie, disponibilidad) VALUES"
                + "(?,?,?)";

        try {
            Connection miConexion= this.conectar();
            
      PreparedStatement preparedStatement = miConexion.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2, numeroSerie);
            preparedStatement.setByte(3, disponibilidad);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Record is inserted into DBUSER table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } 
   
  }

  @Override
  public Equipo consultarInventario(int id) {
    
     Connection miConexion = this.conectar();
		
		PreparedStatement stp = null;
		try {
			stp = miConexion.prepareStatement("SELECT * FROM prueba_construccion.equipo WHERE idequipo = ? ");
                        stp.setInt(1, id);
			ResultSet resultadoQuery = stp.executeQuery();
			resultadoQuery.next(); 
			int idEquipo = resultadoQuery.getInt("idequipo");
			int numeroSerie = resultadoQuery.getInt("numero_serie");
			boolean disponibilidad = resultadoQuery.getBoolean("disponibilidad");
                        
                        Equipo nz = new Equipo(idEquipo, numeroSerie, disponibilidad);
                        System.out.println("pasó");
			return nz;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
                        System.out.println("Holi");
                        System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		return null;
  }


  
}
