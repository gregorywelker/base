package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Test;

import hu.bme.mit.train.tachograph.TrainTachograph;


public class TrainTachographTest {

    @Test
    public void TachographTest() {
        TrainTachograph t = new TrainTachograph();
        t.addElement(1,0.1,0.1);
        Assert.assertEquals(false,t.isEmpty()); 
    }
}
