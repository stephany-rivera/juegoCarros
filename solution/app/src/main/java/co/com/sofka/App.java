package co.com.sofka;

import co.com.sofka.cargame.domain.ids.Nombre;
import co.com.sofka.cargame.domain.juego.Juego;
import java.awt.Color;
import java.util.Scanner;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App        
{
   
    
    public static void main( String[] args )
    {    
        //Datos Nuevo jugador
        UUID jugadorId;
        jugadorId=UUID.randomUUID();    
        System.out.println("Iniciando un nuevo juego");
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador: ");
        String nombreJugador=in.nextLine();
        Nombre nombre= new Nombre(nombreJugador);        
        
       
       
       
       
       
       
       
   
        
    }
}
