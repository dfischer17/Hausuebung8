/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author dfischer17
 */
public class Dagger {
    private boolean grabable = true;
    
    public void grab() {
        grabable = false;
    }
    
    public void release() {
        grabable = true;
    }
    
    public boolean isGrabable() {
        return grabable;
    }
}
