package hu.bme.mit.train.sensor;



import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.user.TrainUserImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TrainSensorTest {

    TrainControllerImpl mockController;
    TrainUserImpl mockUser;
    TrainSensorImpl sensor; 

    @Before
    public void before() {

        mockController = mock(TrainControllerImpl.class);
        mockUser = mock(TrainUserImpl.class);
        sensor = new TrainSensorImpl(mockController, mockUser); 
    }

    @Test
    public void LessThan0() {
        when(mockController.getReferenceSpeed()).thenReturn(10);
        sensor.overrideSpeedLimit(-10);

        assertEquals(-10, sensor.getSpeedLimit());
        verify (mockUser, times(1)).setAlarmState(true);
        verify (mockController, never()).getReferenceSpeed();   
    }

    @Test 
    public void MoreThan500(){
        when(mockController.getReferenceSpeed()).thenReturn(10);
        sensor.overrideSpeedLimit(600);

        assertEquals(600, sensor.getSpeedLimit());
        verify (mockUser, times(1)).setAlarmState(true);
        verify (mockController, never()).getReferenceSpeed();
    }

    @Test 
    public void LessThanHalf(){
        when(mockController.getReferenceSpeed()).thenReturn(10);
        sensor.overrideSpeedLimit(4);

        assertEquals(4, sensor.getSpeedLimit());
        verify (mockUser, times(1)).setAlarmState(true);
        verify (mockController, times(1)).getReferenceSpeed();
    }

    @Test 
    public void ValidSpeed(){
        when(mockController.getReferenceSpeed()).thenReturn(10);
        sensor.overrideSpeedLimit(12);

        assertEquals(12, sensor.getSpeedLimit());
        verify (mockUser, never()).setAlarmState(true);
        verify (mockController, times(1)).getReferenceSpeed();
    }


}
