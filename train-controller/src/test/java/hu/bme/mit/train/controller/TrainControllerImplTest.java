package hu.bme.mit.train.controller;

import org.junit.Assert;
import org.junit.Test;


public class TrainControllerImplTest {

    @Test
    public void IsActiveTest() {
        TrainControllerImpl tci = new TrainControllerImpl();
        tci.setIsActive(true);
        Assert.assertEquals(true,tci.getIsActive()); 
    }
}
