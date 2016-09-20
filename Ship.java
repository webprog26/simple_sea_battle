/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlefieldthesea;

import java.awt.Point;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author webprog26
 */
public class Ship {
    
    private Field mField;
    
    //Logger to log important actions
    private static Logger log = Logger.getLogger(Ship.class.getSimpleName());
    
    private static final int TOTAL_DECKS_NUMBER = 0;
    
    //Ships sizes
    private static final int ONE_DECK_SHIP_SIZE = 1;
    private static final int TWO_DECK_SHIP_SIZE = 2;
    private static final int THREE_DECK_SHIP_SIZE = 3;
    private static final int FOUR_DECK_SHIP_SIZE = 4;
    
    //Ship number
    private static final int ONE_DECK_SHIPS_NUMBER = 4;
    private static final int TWO_DECK_SHIPS_NUMBER = 3;
    private static final int THREE_DECK_SHIPS_NUMBER = 2;
    private static final int FOUR_DECK_SHIPS_NUMBER = 1;

    public Ship(Field mField) {
        this.mField = mField;
        
        drawShip(ONE_DECK_SHIP_SIZE, ONE_DECK_SHIPS_NUMBER);//drawing 4 one-deck ships
        drawShip(TWO_DECK_SHIP_SIZE, TWO_DECK_SHIPS_NUMBER);//drawing 3 two-deck ships
        drawShip(THREE_DECK_SHIP_SIZE, THREE_DECK_SHIPS_NUMBER);//drawing 2 three-deck ships
        drawShip(FOUR_DECK_SHIP_SIZE, FOUR_DECK_SHIPS_NUMBER);//drawing 1 four-deck ship
                
    }
   
    /**
     * Draws specified number of ships with specified size
     * @param shipSize
     * @param shipsNumber 
     */
    private void drawShip(int shipSize, int shipsNumber)
    {
        Random random = new Random();
        
        Point point = new Point();
        
        //get random start point to draw ship
        //producing new point if received coordinates are busy already
        //with any ship drawn earlier
        for(int i = 0; i < shipsNumber; i++)
        {
            do
            {
                point.x = random.nextInt(Field.SIZE);
                point.y = random.nextInt(Field.SIZE - shipSize);
                
            }while(mField.isStartPointBusyAlready(point) 
                    || mField.areFieldsBusyAlready(point, shipSize) ||(point.y + shipSize + 1 <  Field.SIZE && mField.isStartPointBusyAlready(new Point(point.x, point.y + shipSize))) 
                    || (point.y - 1 > 0 && mField.isStartPointBusyAlready(new Point(point.x, point.y - 1))));
            log.info("Drawing " + shipSize + " deck ship at x" + point.x + " y" + point.y);
            
            //draw ship deck by deck
            drawDeck(shipSize, point);
        }
        
    }
    
    /**
     * Draws specified number of single decks, starting from the specified point  
     * @param shipSize
     * @param point 
     */
    private void drawDeck(int shipSize, Point point)
    {
        for(int i = 0; i < 1; i++)
        {
            for (int j = point.y; j < (point.y + shipSize); j++) {
                mField.getCells()[point.x][j] = 'X';
            }
        }
    }
   
}
