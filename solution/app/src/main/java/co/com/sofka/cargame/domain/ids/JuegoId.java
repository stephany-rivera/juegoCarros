/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.sofka.cargame.domain.ids;

import java.util.UUID;

/**
 * 
 * @author Stephany Rivera <anie.12106@gmail.com>
 */
public class JuegoId {
    
    private UUID id;

    public JuegoId(UUID id) {
        this.id = id;
    }
    
    
    public String getValue() {
        return id.toString();
    }

}
