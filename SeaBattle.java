/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlefieldthesea;

/**
 *
 * @author webprog26
 */
public class SeaBattle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Field field = new Field();
        Ship ship = new Ship(field);
        Player player = new Player(field.getCells());
        player.doShoot();
    }
}
