/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.sofka.cargame.domain.carro;

import co.com.sofka.cargame.domain.ids.CarrilId;
import co.com.sofka.cargame.domain.ids.CarroId;
import co.com.sofka.cargame.domain.ids.JuegoId;
import co.com.sofka.cargame.domain.ids.JugadorId;
import co.com.sofka.cargame.domain.juego.Jugador;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Stephany Rivera <anie.12106@gmail.com>
 */
public class Carro {
    protected Conductor conductor;
    protected Integer distancia;
    protected Color color;
    protected JuegoId juegoId;
    protected Map<CarroId, Conductor>jugadores=new HashMap<>();
      
     public Carro() {
    }
    
    
    public Carro from(CarroId carroId){        
        return null;    
    
    }
      
    
    public void asignarConductor (CarroId carroId, Conductor conductor){
        
        
        
    
    }

    
    public void avanzarEnCarril(CarrilId carrilId){
    
    
    }
    
   public Conductor conductor(){
   
        return null;
   
   }
   
   public Integer distancia(){
   
        return null;
   
   }
   
   public String color(){
   
        return null;
   
   }
   
   
   
   
   
   
    
    
    
    

}
