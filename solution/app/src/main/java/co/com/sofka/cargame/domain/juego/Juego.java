/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.juego;

import co.com.sofka.cargame.domain.carril.Carril;
import co.com.sofka.cargame.domain.carril.values.Posicion;
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
import java.util.ArrayList;
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

    protected Map<JugadorId, Jugador> jugadores = new HashMap<>();
    protected Pista pista;
    protected Boolean jugando;
    protected Podio podio = new Podio();
    protected ArrayList<Pista> pistas = new ArrayList<>();
    protected ArrayList<Carro> carrosEnJuego = new ArrayList<>();
    protected ArrayList<Carril> carrilesEnJuego = new ArrayList<>();
    private final Carro carro = new Carro();

    public Juego from(JuegoId juegoId) {
        return null;
    }

    // Crear jugador y la lista de jugadores con sus respectivos id
    public void crearJugador(JugadorId jugadorId, Nombre nombre, Color color) {
        Jugador jugador = new Jugador(nombre, color, 0);
        jugadores.put(jugadorId, jugador);
        crearConductor(nombre);
    }

    // Elegir si se desea que el jugador sea un conductor y crear el conductor y asignarle un carro.
    public void crearConductor(Nombre nombre) {
        UUID id;
        Scanner in = new Scanner(System.in);
        System.out.println("Desea que el jugador con nombre: " + nombre.getNombre() + " sea conductor ? " + "Y/N");
        String consultaConductores = in.nextLine();

        if (consultaConductores.equals("Y") || consultaConductores.equals("y")) {
            Conductor conductor = new Conductor(nombre.getNombre());
            id = UUID.randomUUID();
            CarroId carroId = new CarroId(id);
            carro.asignarConductor(carroId, conductor);
        }
    }

    /*  Eligir pistas que se crean según cantidad de carros (pueden existir tantos carros como pistas)
        y dar kilometros  aleatorios a cada pista con limites de kilometros 100 y cada pista tiene la misma
        cantidad de carriles que carros existentes para que todos los conductores puedan participar de la carrera.
        
     */
    public void crearPistas() {
        int kilometrosRandom;
        int numeroCarriles = carro.numeroCarros();
        for (int i = 0; i < carro.numeroCarros(); i++) {
            kilometrosRandom = (int) (Math.random() * 100 + 1);
            Pista pista = new Pista(kilometrosRandom, numeroCarriles);
            pistas.add(pista);
        }
    }

    public void asignarPrimerLugar(JugadorId jugadorId) {
        podio.asignarPrimerLugar(jugadores.get(jugadorId));

    }

    public void asignarSegundoLugar(JugadorId jugadorId) {
        podio.asignarSegundoLugar(jugadores.get(jugadorId));
    }

    public void asignarTercerLugar(JugadorId jugadorId) {
        podio.asignarTercerLugar(jugadores.get(jugadorId));

    }

    public void iniciarJuego() {
        //Identificado para iniciar el juego
        UUID id;
        id = UUID.randomUUID();
        JuegoId juegoId = new JuegoId(id);

        //Elegir pista en cuál jugar
        Scanner in = new Scanner(System.in);
        System.out.println("Para iniciar el juego, elige la  pista (numero) en la que deseas jugar:  ");
        System.out.println("Pistas: ");
        int counter = 1;
        for (Pista p : pistas) {
            System.out.println(counter + "." + " Kilometros: " + p.kilometros() + " Número de carriles:  " + p.numeroDeCarriles());
            counter++;
        }

        int pistaElegida = in.nextInt();

        carro.carros().forEach((key, value) -> {
            Carro carrosJuego = new Carro(value, 0, Color.yellow, juegoId);
            carrosEnJuego.add(carrosJuego);

            //añadir carros a los Carriles
            int kilometrosToMetros = pistas.get(pistaElegida - 1).kilometros() * 1000;
            Posicion posicion = new Posicion(0, kilometrosToMetros);
            Carril carriles = new Carril(key, juegoId, posicion, kilometrosToMetros, false);
            carrilesEnJuego.add(carriles);
        });

        //Iniciar JUEGO
        jugando = true;
        Conductor conductor = new Conductor();
        System.out.println("----------Inicia la carrera--------");
        while (jugando) {
            int contador = 0;
            System.out.println("--------Avance----- " + "--------- Meta: " + carrilesEnJuego.get(contador).metros() + " metros");
            for (Carro carros : carrosEnJuego) {
                if (!yaGanoCarro(carros.conductor().nombre())) {
                    int mover = conductor.lanzarDado() * 100;
                    carros.setDistancia(carros.distancia() + mover);
                    carrilesEnJuego.get(contador).moverCarro(carrilesEnJuego.get(contador).posicion(), mover);
                    System.out.println(carros.conductor().nombre() + ":" + " mueve: " + mover + " Nueva posición: " + carros.distancia());
                    if (carrilesEnJuego.get(contador).desplazamientoFinal()) {
                        if (podio.primerLugar() == null) {
                            asignarPrimerLugar(jugadorID(carros.conductor().nombre()));
                        } else if (podio.segundoLugar() == null) {
                            asignarSegundoLugar(jugadorID(carros.conductor().nombre()));
                        } else if (podio.tercerLugar() == null) {
                            asignarTercerLugar(jugadorID(carros.conductor().nombre()));
                        } else if (podio.estaLleno()) {
                            jugando = false;

                        }
                    }
                }
                contador++;
            }
        }

    }

    public Map<JugadorId, Jugador> jugadores() {

        return jugadores;

    }

    public Boolean jugando() {

        return jugando;

    }

    public JugadorId jugadorID(String nombre) {
        JugadorId lookId = null;
        for (JugadorId keys : jugadores.keySet()) {
            if (jugadores.get(keys).nombre().getNombre().equals(nombre)) {
                lookId = keys;
            }
        }
        return lookId;
    }

    public Boolean yaGanoCarro(String nombre) {
        boolean yaGano = false;
        if (podio.tercerLugar() == jugadores.get(jugadorID(nombre))
                || podio.primerLugar() == jugadores.get(jugadorID(nombre))
                || podio.segundoLugar() == jugadores.get(jugadorID(nombre))) {
            yaGano = true;
        }
        return yaGano;
    }

    public Props props() {
        return null;
    }

    public Values pista() {
        return null;
    }

}
