package org.example;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertEquals;

public class PlayerQueueTest {
    PlayerQueue pQueue = new PlayerQueue();

    @Test
    public void addTest() throws Exception {
        pQueue.add(new Player("Mahmoud"));
        pQueue.add(new Player("ali"));
        pQueue.add(new Player("ahmad"));
        pQueue.add(new Player("morad"));


        pQueue.print();

        assertEquals(4, pQueue.size());
    }

    @Test
    public void removeTest() throws Exception {
        Player a = new Player("Mahmoud");
        Player b = new Player("ali");
        Player c = new Player("ahmad");

        pQueue.add(a);
        pQueue.add(b);
        pQueue.add(c);

        pQueue.remove(b);
        pQueue.remove(a);

        pQueue.print();

        assertEquals(1, pQueue.size());
    }
}
