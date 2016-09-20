/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlefieldthesea.interfaces;

import java.awt.Point;

/**
 *
 * @author webprog26
 */
public interface OnShipsDrowningListener {
    boolean isStartPointBusyAlready(Point startPoint);
    boolean areFieldsBusyAlready(Point startPoint, int shipSize);
}
