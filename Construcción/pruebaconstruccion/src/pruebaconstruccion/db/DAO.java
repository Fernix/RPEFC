/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaconstruccion.db;

import java.util.List;

/**
 *
 * @author ferc
 */

public interface DAO<T> {
  
  public void guardarEquipo(int id, int numeroSerie, byte disponibilidad);
  public T consultarInventario(int id);
  
}
