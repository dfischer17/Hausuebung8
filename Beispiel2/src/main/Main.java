package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dfischer17
 */
public class Main {
    
    private Dagger leftDagger = new Dagger();
    private Dagger rightDagger = new Dagger();
    
    private static Ork ork1 = new Ork();
    private static Ork ork2 = new Ork();
    private static Ork ork3 = new Ork();
    private static Ork ork4 = new Ork();
    private static Ork ork5 = new Ork();
    
    public static void main(String[] args) {
        ExecutorService exec = new ScheduledThreadPoolExecutor(4);
        exec.execute(ork1);
        exec.execute(ork2);
        exec.execute(ork3);
        exec.execute(ork4);
        exec.execute(ork5);
        
        
    }            
}
