/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.carril;

import co.com.sofka.cargame.domain.ids.CarroId;
import co.com.sofka.cargame.domain.ids.JuegoId;
import co.com.sofka.cargame.domain.carril.values.Posicion;
import co.com.sofka.cargame.domain.ids.CarrilId;
import java.util.Objects;

/**
 *
 * @author Stephany Rivera <anie.12106@gmail.com>
 */
public class Carril {

    protected CarroId carroId;
    protected JuegoId juegoId;
    protected Posicion posicion;
    protected Integer metros;
    protected Boolean desplazamientoFinal;

    public Carril(CarroId carroId, JuegoId juegoId, Posicion posicion, Integer metros, Boolean desplazamientoFinal) {
        this.carroId = carroId;
        this.juegoId = juegoId;
        this.posicion = posicion;
        this.metros = metros;
        this.desplazamientoFinal = desplazamientoFinal;
    }

    public Carril from(CarrilId carrilId) {

        return null;

    }

    public void agregarCarro(CarroId carroId) {

    }

    public void alcanzarLaMeta() {
        if (posicionActual() >= posicionDeseada()) {
            desplazamientoFinal = true;
        }

    }

    public void moverCarro(Posicion posicion, Integer cantidad) {
        this.posicion = posicion;
        posicion.setActual(posicion.actual() + cantidad);
        alcanzarLaMeta();
    }

    public Integer metros() {

        return metros;

    }

    public Posicion posicion() {

        return posicion;

    }

    public Integer posicionActual() {

        return posicion.actual();

    }

    public Integer posicionDeseada() {
        return posicion.meta();
    }

    public Boolean desplazamientoFinal() {

        return desplazamientoFinal;

    }

    public String carroId() {

        return null;

    }

}
