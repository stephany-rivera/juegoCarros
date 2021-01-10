/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.sofka.cargame.domain.juego;

import co.com.sofka.cargame.domain.ids.JuegoId;
import co.com.sofka.cargame.domain.ids.JugadorId;
import co.com.sofka.cargame.domain.ids.Nombre;
import co.com.sofka.cargame.domain.juego.values.Pista;
import co.com.sofka.cargame.domain.juego.values.Podio;
import co.com.sofka.cargame.domain.juego.values.Props;
import co.com.sofka.cargame.domain.juego.values.Values;

import java.awt.Color;
import java.awt.List;
import java.util.Map;
import java.util.UUID;

/**
 * 
 * @author Stephany Rivera <anie.12106@gmail.com>
 */
public class Juego {

    public Juego() {
    }
    
    protected Map<JugadorId, Jugador>jugadores;
    protected Pista pista;
    protected Boolean jugando;
    protected Podio podio;
    
      public Juego from(JuegoId juegoId){    
        return null;
        }
      
      public void crearJugador(JugadorId jugadorId,Nombre nombre, Color color){
          Jugador jugador= new Jugador(nombre, color, 0);        
       }
      
      public void asignarPrimerLugar(JugadorId jugadorId){
      
      }
      
        public void asignarSegundoLugar(JugadorId jugadorId){
      
      }
        
          public void asignarTercerLugar(JugadorId jugadorId){
      
      }
          
       public void  iniciarJuego(){
          
          }
          
          
          public Map<JugadorId, Jugador>jugadores(){
          
          return null;
          
          }
          
          public  Boolean jugando(){
          
          return null;
          
          }
          
          public Props props(){
          return null;
          }
          
          public Values pista(){
          return null;
          }

}
