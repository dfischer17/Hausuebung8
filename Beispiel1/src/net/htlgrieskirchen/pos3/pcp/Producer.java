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

public class Producer implements Runnable {

    /* implement this */
    private String name;
    private Storage storage;
    private int sleepTime;

    private List<Integer> sent;
    private int numberOfItems;

    public Producer(String name, Storage storage, int sleepTime, int numberOfItems) {
        this.name = name;
        this.storage = storage;
        this.sleepTime = sleepTime;
        this.numberOfItems = numberOfItems;
        this.sent = new ArrayList<>();
    }

    // implement this
    public List<Integer> getSent() {
        // implement this
        return sent;
    }

    @Override
    public void run() {

        for (int i = 0; i < numberOfItems; i++) {
            try {
                storage.put(i);
                if (storage.getStoredCounter() <= 10) {
                    sent.add(i);
                }
                /*
                else {
                    Thread.sleep(sleepTime);
                }
                */
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        storage.setProductionComplete();
    }
}
