/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.concurrent.ArrayBlockingQueue;

public class Storage {

    private ArrayBlockingQueue<Integer> queue;

    private int fetchedCounter;
    private int storedCounter;
    private int underflowCounter;
    private int overflowCounter;
    private boolean productionComplete;

    public Storage() {
        this.fetchedCounter = 0;
        this.storedCounter = 0;
        this.underflowCounter = 0;
        this.overflowCounter = 0;
        this.productionComplete = false;
        this.queue = new ArrayBlockingQueue<>(10);
    }

    public boolean put(Integer data) throws InterruptedException {
        // implement this       
        if (queue.remainingCapacity() == 0) {
            overflowCounter++;
            return false;
        }

        queue.put(data);
        storedCounter++;
        return true;
    }

    public Integer get() {
        // implement this

        if (queue.poll() == null) {
            underflowCounter++;
            return null;
        }

        fetchedCounter++;

        return queue.poll();

    }

    public boolean isProductionComplete() {
        // implement this
        return productionComplete;
    }

    public void setProductionComplete() {
        // implement this
        this.productionComplete = true;
    }

    public int getFetchedCounter() {
        // implement this
        return fetchedCounter;
    }

    public int getStoredCounter() {
        // implement this
        return storedCounter;
    }

    public int getUnderflowCounter() {
        // implement this
        return underflowCounter;
    }

    public int getOverflowCounter() {
        // implement this
        return overflowCounter;
    }
}
