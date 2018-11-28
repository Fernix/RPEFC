/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaconstruccion.logica;

import pruebaconstruccion.db.DAO;
import pruebaconstruccion.db.EquipoDao;

/**
 *
 * @author ferc
 */
public class Equipo {
  
  public int idEquipo;
  public int numeroSerie;
  public boolean disponibilidad;
  DAO equipoDao = new EquipoDao();
  
  public Equipo() {
    
  }
  
  public Equipo(int id, int numSerie, boolean disponibilidad) {
    this.idEquipo = id;
    this.numeroSerie = numSerie;
    this.disponibilidad = disponibilidad;
  }
  
  public void consultarEquipo(int id) {
    try { 
      Equipo eTemporal = (Equipo) equipoDao.consultarInventario(id);
    this.idEquipo = eTemporal.idEquipo;
    this.disponibilidad = eTemporal.disponibilidad;
    this.numeroSerie = eTemporal.numeroSerie;
  
    } catch(Exception e) {
      System.out.println(" 2");
    }

  }
  
  public void registrarEqipo(int id, int numeroSerie, byte disponibilidad){
    this.equipoDao.guardarEquipo(id, numeroSerie, disponibilidad);
  }
}
