/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.sofka.cargame.domain.juego;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Stephany Rivera <anie.12106@gmail.com>
 */
@Entity
public class GanadoresBD implements Serializable {
    
    @Id
    private int id;    
    private String nombre;
    private int vecesPrimero;
    private int vecesSegundo;
    private int vecesTercero;
    
    public GanadoresBD() {
    }

    public GanadoresBD(int id, String nombre, int vecesPrimero, int vecesSegundo, int vecesTercero) {
        this.id = id;
        this.nombre = nombre;
        this.vecesPrimero = vecesPrimero;
        this.vecesSegundo = vecesSegundo;
        this.vecesTercero = vecesTercero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVecesPrimero() {
        return vecesPrimero;
    }

    public void setVecesPrimero(int vecesPrimero) {
        this.vecesPrimero = vecesPrimero;
    }

    public int getVecesSegundo() {
        return vecesSegundo;
    }

    public void setVecesSegundo(int vecesSegundo) {
        this.vecesSegundo = vecesSegundo;
    }

    public int getVecesTercero() {
        return vecesTercero;
    }

    public void setVecesTercero(int vecesTercero) {
        this.vecesTercero = vecesTercero;
    }
    
    
    
}

