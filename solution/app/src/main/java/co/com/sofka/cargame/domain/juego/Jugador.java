/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.juego;

import co.com.sofka.cargame.domain.ids.Nombre;
import java.awt.Color;

/**
 *
 * @author Stephany Rivera <anie.12106@gmail.com>
 */
public class Jugador {

    private Nombre nombre;
    private Color color;
    private Integer puntos;

    public Jugador(Nombre nombre, Color color, Integer puntos) {
        this.nombre = nombre;
        this.color = color;
        this.puntos = puntos;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Color color() {
        return color;
    }

    public void asignarPuntos(Integer puntos) {
        puntos = puntos;
    }

}
