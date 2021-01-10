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

public interface Props {
    
public Jugador primerLugar();
public Jugador segundoLugar();
public Jugador tercerLugar();
public Boolean estaLleno();
    
}
