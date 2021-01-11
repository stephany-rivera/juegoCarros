/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.carril.values;

/**
 *
 * @author Stephany Rivera <anie.12106@gmail.com>
 */
public class Posicion implements Props {

    private Integer actual;
    private Integer meta;

    @Override
    public Integer actual() {
        return actual;
    }

    @Override
    public Integer meta() {
        return meta;
    }

    public void setActual(Integer actual) {
        this.actual = actual;
    }

    public Posicion(Integer actual, Integer meta) {
        this.actual = actual;
        this.meta = meta;
    }

}

interface Props {

    public Integer actual();

    public Integer meta();

}
