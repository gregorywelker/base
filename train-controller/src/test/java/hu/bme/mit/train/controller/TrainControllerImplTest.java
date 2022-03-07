package hu.bme.mit.train.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Test
    public void IsActiveTest() {
        TrainControllerImpl tci = new TrainControllerImpl();
        tci.setIsActive(true);
        Assert.assertEquals(true,tci.getIsActive()); 
    }
}
