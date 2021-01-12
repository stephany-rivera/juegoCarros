package co.com.sofka;

import co.com.sofka.cargame.domain.ids.JugadorId;
import co.com.sofka.cargame.domain.ids.Nombre;
import co.com.sofka.cargame.domain.juego.Juego;
import co.com.sofka.cargame.domain.juego.values.Pista;
import co.com.sofka.cargame.domain.juego.values.Podio;
import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        UUID id;
        int cantidadJugadores;
        String nombreJugador;

        Juego nuevoJuego = new Juego();

        //Datos jugadores para iniciar el juego 
        System.out.println("Iniciando un nuevo juego ...");

        Scanner in = new Scanner(System.in);
        System.out.println("¿Cuántos jugadores desea crear?");
        cantidadJugadores = in.nextInt();

        for (int i = 0; i < cantidadJugadores; i++) {
            id = UUID.randomUUID();
            JugadorId jugadorId = new JugadorId(id);
            nombreJugador = "jugador" + (i + 1);
            Nombre nombre = new Nombre(nombreJugador);
            nuevoJuego.crearJugador(jugadorId, nombre, Color.yellow);
        }

        // Crear pistas
        nuevoJuego.crearPistas();

        // Iniciar el Juego
        nuevoJuego.iniciarJuego();
        
     


 
      
        
    }

}
