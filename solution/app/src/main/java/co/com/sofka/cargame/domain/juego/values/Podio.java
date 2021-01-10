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
public class Podio implements Props {
    private Jugador primerLugar;
    private Jugador segundoLugar;
    private Jugador tercerLugar;
    
    public Podio asignarPrimerLugar(Jugador jugador){
    
        return null;
    
    }
   
    public Podio asignarSegundoLugar(Jugador jugador){
    
        return null;
    
    }
    
    public Podio asignarTercerLugar(Jugador jugador){
        return null;
    }

    @Override
    public Jugador primerLugar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Jugador segundoLugar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Jugador tercerLugar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean estaLleno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
}

