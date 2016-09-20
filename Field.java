/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlefieldthesea;

import battlefieldthesea.interfaces.OnShipsDrowningListener;
import java.awt.Point;
import java.util.logging.Logger;
import sun.rmi.runtime.Log;

/**
 *
 * @author webprog26
 */
public class Field implements OnShipsDrowningListener {
    
    //BattleField size
    public static final int SIZE = 10;
    
    //Logger to log important actions
    private static Logger log = Logger.getLogger(Field.class.getName());
    
    //BattleField 
    private char cells[][] = new char[SIZE][SIZE];

    public Field() {
        initCells();
    }
    
    /**
     * Fills battlefield with '.'
     */
    private void initCells()
    {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = '.';
            }
        }
    }
    
    /**
     * Returns battlefield with already drawn ships
     * @return char[][]
     */
    public char[][] getCells()
    {
        return cells;
    }
    
    /**
     * Checks whether startPoint of drawing ship is busy already
     * @param startPoint
     * @return boolean
     */
    @Override
    public boolean isStartPointBusyAlready(Point startPoint)
    {
        if(cells[startPoint.x][startPoint.y] == 'X') 
        {
            log.info("Field at x" + startPoint.x + " y" +  startPoint.y + " is busy");
            return true;
        }
        
        return false;
    }
    
    /**
     * Checks whether field is busy already
     * @param startPoint
     * @param shipSize
     * @return boolean
     */
    @Override
    public boolean areFieldsBusyAlready(Point startPoint, int shipSize)
    {
        for(int i = startPoint.x; i < (startPoint.x + 1); i++)
        {
            for (int j = startPoint.y; j < 10; j++) {
                if(cells[i][j] == 'X')
                {
                    return true;
                }
            }
        }
        return false;
    }        
}
