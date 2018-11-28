/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaconstruccion;

import pruebaconstruccion.db.EquipoDao;
import pruebaconstruccion.logica.Equipo;

/**
 *
 * @author ferc
 */
public class Pruebaconstruccion {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    Equipo n =new  Equipo();
    byte asd = 0;
    n.registrarEqipo(10, 123, asd);
 
    
  }
  
}
