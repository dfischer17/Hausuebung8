/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {

    /* implement this */
    private final String name;
    private final Storage storage;
    private final int sleepTime;

    private final List<Integer> received;

    public Consumer(String name, Storage storage, int sleepTime) {
        this.name = name;
        this.storage = storage;
        this.sleepTime = sleepTime;
        this.received = new ArrayList<>();
    }

    // implement this
    public List<Integer> getReceived() {
        // implement this
        return received;
    }

    @Override
    public void run() {
        while (!storage.isProductionComplete() && storage.getStoredCounter() > 0) {
            try {
                received.add(storage.get());
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
}