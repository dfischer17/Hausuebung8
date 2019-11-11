package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    private static Dagger dagger1 = new Dagger();
    private static Dagger dagger2 = new Dagger();
    private static Dagger dagger3 = new Dagger();
    private static Dagger dagger4 = new Dagger();
    private static Dagger dagger5 = new Dagger();

    private static Ork ork1;
    private static Ork ork2;
    private static Ork ork3;
    private static Ork ork4;
    private static Ork ork5;

    public static void main(String[] args) {
        ork1 = new Ork("ork1", dagger1, dagger2);
        ork2 = new Ork("ork2", dagger2, dagger3);
        ork3 = new Ork("ork3", dagger3, dagger4);
        ork4 = new Ork("ork4", dagger4, dagger5);
        ork5 = new Ork("ork5", dagger5, dagger1);
        
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        executor.execute(ork1);
        executor.execute(ork2);
        executor.execute(ork3);
        executor.execute(ork4);
        executor.execute(ork5);
        
    }
}
