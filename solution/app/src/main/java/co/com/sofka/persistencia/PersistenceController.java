/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.sofka.persistencia;

import co.com.sofka.cargame.domain.juego.GanadoresBD;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Stephany Rivera <anie.12106@gmail.com>
 */
public class PersistenceController {
    
    GanadoresBDJpaController ganadoresJPA= new GanadoresBDJpaController();
    
    public void crearRegistro(GanadoresBD ganadores){
        try {
            ganadoresJPA.create(ganadores);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public void modificarRegistro(GanadoresBD ganadores){
        try {
            ganadoresJPA.edit(ganadores);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    

}
