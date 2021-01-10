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
public class Posicion  implements Props{
    private Integer actual;
    private Integer meta;

    @Override
    public Integer actual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer meta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

 interface Props{

     public Integer actual();
     public  Integer meta();

}
