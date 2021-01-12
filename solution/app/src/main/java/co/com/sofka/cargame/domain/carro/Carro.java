/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.carro;

import co.com.sofka.cargame.domain.ids.CarroId;
import co.com.sofka.cargame.domain.ids.JuegoId;
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
    private final Map<CarroId, Conductor> carros = new HashMap<>();

    public Carro() {
    }

    public Carro(Conductor conductor, Integer distancia, Color color, JuegoId juegoId) {
        this.conductor = conductor;
        this.distancia = distancia;
        this.color = color;
        this.juegoId = juegoId;
    }

    public void asignarConductor(CarroId carroId, Conductor conductor) {
        carros.put(carroId, conductor);

    }

    public Map<CarroId, Conductor> carros() {
        return carros;

    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Integer numeroCarros() {
        return carros.size();
    }

    public Conductor conductor() {

        return conductor;

    }

    public Integer distancia() {

        return distancia;

    }

    public Color color() {

        return color;

    }

}
