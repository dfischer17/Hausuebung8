/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dfischer17
 */
public class Ork implements Runnable {

    @Override
    public void run() {
      while (true) {
          drinking();
      }
    }
    
    private static void drinking() {
        System.out.println("drinking");
    }
    
    private static void feasting() {
        
    }
}
