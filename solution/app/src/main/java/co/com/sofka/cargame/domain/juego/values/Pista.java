/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.sofka.cargame.domain.juego.values;

import co.com.sofka.cargame.domain.juego.Jugador;

/**
 * 
 * @author Stephany Rivera <anie.12106@gmail.com>
 */
public class Pista implements Values {
    
    public Pista(Integer kilometros, Integer numeroDeCarriles) {
        this.kilometros = kilometros;
        this.numeroDeCarriles = numeroDeCarriles;
    }
    
    private  Integer kilometros;
    private Integer numeroDeCarriles;            

    @Override
    public Integer kilometros() {
      return kilometros;
    }

    @Override
    public Integer numeroDeCarriles() {
       return numeroDeCarriles;
    }

    

  
}


