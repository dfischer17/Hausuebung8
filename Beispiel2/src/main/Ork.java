/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dfischer17
 */
public class Ork implements Runnable {

    private String name;
    private Dagger leftDagger;
    private Dagger rightDagger;
    Lock lock = new ReentrantLock(true);

    public Ork(String name, Dagger leftDagger, Dagger rightDagger) {
        this.name = name;
        this.leftDagger = leftDagger;
        this.rightDagger = rightDagger;
    }

    @Override
    public void run() {
        while (true) {
            drinking();

            if (lock.tryLock()) {
                try {
                    grabRightDagger();
                    grabLeftDagger();

                    feasting();

                    releaseLeftDagger();
                    releaseRightDagger();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private void drinking() {  
        System.out.println(java.time.LocalTime.now() + "\n" + name + " drinking");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void feasting() {
        System.out.println(java.time.LocalTime.now() + "\n" + name + " feasting");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void grabLeftDagger() {
        //if (lock.tryLock()) {
            if (!leftDagger.isGrabable()) {
                System.err.println(java.time.LocalTime.now() + "\n" + name + " grabbed blocked dagger (left)");
            } else {
                System.out.println(java.time.LocalTime.now() + "\n" + name + " grabbed left dagger");
            }
            leftDagger.grab();
        //}
    }

    private void grabRightDagger() {
        //if (lock.tryLock()) {
        if (!rightDagger.isGrabable()) {
            System.err.println(java.time.LocalTime.now() + "\n" + name + " grabbed blocked dagger (right)");
        } else {
            System.out.println(java.time.LocalTime.now() + "\n" + name + " grabbed right dagger");
        }

        rightDagger.grab();
        //}        
    }

    private void releaseLeftDagger() {
        System.out.println(java.time.LocalTime.now() + "\n" + name + " released left dagger");
        //leftDagger.release();
    }

    private void releaseRightDagger() {
        System.out.println(java.time.LocalTime.now() + "\n" + name + " released right dagger");
        rightDagger.release();
        //lock.unlock();
    }
}
