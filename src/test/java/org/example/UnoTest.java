package org.example;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertEquals;
public class UnoTest {
    Uno uno = new Uno();
    @Test
    public void handInitTest(){
        try{
            uno.initializeGame();
        }catch(Exception e){

        }
    }

}
