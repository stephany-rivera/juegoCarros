/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.sofka.cargame.domain.juego;

import co.com.sofka.cargame.domain.carro.Carro;
import co.com.sofka.cargame.domain.carro.Conductor;
import co.com.sofka.cargame.domain.ids.CarroId;
import co.com.sofka.cargame.domain.ids.JuegoId;
import co.com.sofka.cargame.domain.ids.JugadorId;
import co.com.sofka.cargame.domain.ids.Nombre;
import co.com.sofka.cargame.domain.juego.values.Pista;
import co.com.sofka.cargame.domain.juego.values.Podio;
import co.com.sofka.cargame.domain.juego.values.Props;
import co.com.sofka.cargame.domain.juego.values.Values;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;


/**
 * 
 * @author Stephany Rivera <anie.12106@gmail.com>
 */
public class Juego {

    public Juego() {
    }
    
    protected Map<JugadorId, Jugador>jugadores=new HashMap<>();
    protected Pista pista;
    protected Boolean jugando;
    protected Podio podio;
    
      public Juego from(JuegoId juegoId){    
        return null;
        }
      
      
      // Crear jugador y la lista de jugadores con sus respectivos id
      public void crearJugador(JugadorId jugadorId,Nombre nombre, Color color){          
          Jugador jugador= new Jugador(nombre, color, 0);        
          jugadores.put(jugadorId, jugador);   
          crearConductor(nombre);
        
       }
      
        // Elegir si se desea que el jugador sea un conductor y crear el conductor y asignarle un carro.
        public void crearConductor(Nombre nombre){      
           UUID id;
          Carro carro=  new Carro();
          Scanner in = new Scanner(System.in);
          System.out.println("Desea que el jugador con nombre: "+nombre.getNombre()+" sea conductor ? "+"Y/N");
          String consultaConductores=in.nextLine();
          
           if (consultaConductores.equals("Y") || consultaConductores.equals("y")){
               Conductor conductor= new Conductor(nombre.getNombre());
               id= UUID.randomUUID();   
               CarroId carroId = new CarroId(id);
               carro.asignarConductor (carroId,conductor);              
          }
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
          
          return jugadores;
          
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
