/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.concurrent.ArrayBlockingQueue;

public class Storage {

    private final ArrayBlockingQueue<Integer> queue;

    private int fetchedCounter;
    private int storedCounter;
    private int underflowCounter;
    private int overflowCounter;
    private boolean productionComplete;

    public Storage() {
        // implement this
        this.fetchedCounter = fetchedCounter;
        this.storedCounter = storedCounter;
        this.underflowCounter = underflowCounter;
        this.overflowCounter = overflowCounter;
        this.productionComplete = productionComplete;
        this.queue = new ArrayBlockingQueue<>(10);
    }

    public synchronized boolean put(Integer data) throws InterruptedException {
        // implement this
        queue.offer(data);
        storedCounter++;
        if (queue.size() == 10) {
            overflowCounter++;
            return false;
        }
        return true;
    }

    public synchronized Integer get() {
        // implement this
        try {
            queue.poll();
            fetchedCounter++;
            if (queue.isEmpty()) {
                underflowCounter++;
                return null;
            }
        } catch (Exception ex) {

        }
        return fetchedCounter;

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
