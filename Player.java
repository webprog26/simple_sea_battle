/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlefieldthesea;

import static battlefieldthesea.Field.SIZE;
import battlefieldthesea.interfaces.Shootable;
import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author webprog26
 */
public class Player implements Shootable{
    
    private char[][] mCells;
    
    private static final String MSG_ENTER_X_SHOOT_POINT = "Введите x координату выстрела (0-9):";
    private static final String MSG_ENTER_Y_SHOOT_POINT = "Введите y координату выстрела (0-9):";
    
    private static final String MSG_SHOOT_MISSED = "Промах!";
    private static final String MSG_POINT_ALREADY_SHOT = "Уже стреляли!";
    private static final String MSG_HIT = "Попадание!";
    private static final String MSG_WRONG_SHOOT_COORDINATES = "Некорректные координаты! Стреляйте от 0 до 9!";
    private static final String MSG_GAME_OVER = "Игра окончена!";
    
    private static final int ERROR_WHILE_HADNLING_SHOOT = 100;
    private static final int WRONG_SHOOT_COORDINATES = -1;
    private static final int MISSED = 0;
    private static final int ALREADY_SHOT = 1;
    private static final int HIT = 2;
    
    
    
    
    

    public Player(char[][] mCells) {
        this.mCells = mCells;
    }
    
    /**
     * Gets two integer coordinates from user input
     * @return Point()
     */
    private Point getShootCoordinates(){
        
        Point point = new Point();
        
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s\n", MSG_ENTER_X_SHOOT_POINT);
        point.x = Integer.parseInt(scanner.nextLine());
        System.out.printf("%s\n", MSG_ENTER_Y_SHOOT_POINT);
        point.y = Integer.parseInt(scanner.nextLine());
        
        return point;
        
        
    }

    /**
     * Informs user with shoot results, prints battlefield with printCells(char[][] cells) method
     */
    @Override
    public void doShoot() {
        do
        {
            Point point = getShootCoordinates();
            
            switch(handleShoot(mCells, point))
            {
                case WRONG_SHOOT_COORDINATES:
                    printCells(mCells);
                    System.out.printf("%s\n", MSG_WRONG_SHOOT_COORDINATES);
                    break;
                case MISSED:
                    printCells(mCells);
                    System.out.printf("%s\n", MSG_SHOOT_MISSED);
                    break;
                case ALREADY_SHOT:
                    printCells(mCells);
                    System.out.printf("%s\n", MSG_POINT_ALREADY_SHOT);
                    break;
                case HIT:
                    printCells(mCells);
                    System.out.printf("%s\n", MSG_HIT);
                    break;
            }
        } while(isNotGameOver(mCells));
        
        System.out.printf("%s\n", MSG_GAME_OVER);
    }
    
    
    
    /**
     * Checks are there are alive ships 
     * @return 
     */
    private boolean isNotGameOver(char[][] cells)
    {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(cells[i][j] == 'X') return true;
            }
        }
        
        return false;
    } 
    
    /**
     * Handles shoot results and sends them to doShoot() method
     * @param cells
     * @param point
     * @return int constant
     */
    private int handleShoot(char[][] cells, Point point)
    {
        if(point.x >= Field.SIZE || point.y >= Field.SIZE)
        {
            return WRONG_SHOOT_COORDINATES;
        }
        
        switch(cells[point.x][point.y])
        {
            case '.':
                cells[point.x][point.y] = '*';
                return MISSED;
            case '*':
                return ALREADY_SHOT;
            case 'X':
                cells[point.x][point.y] = '*';
                return HIT;
        }
        return ERROR_WHILE_HADNLING_SHOOT;
    }
    
    /**
     * Prints battlefield
     * @param cells 
     */
    private void printCells(char[][] cells)
    {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%c", cells[i][j]);
            }
            System.out.println("");
        }
    }
            
}