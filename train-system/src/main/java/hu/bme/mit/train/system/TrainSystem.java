package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import java.util.Timer;

public class TrainSystem {

	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);

	private Timer myTimer = new Timer();

	public TrainSystem()
	{
		controller.setSpeedLimit(10);

		myTimer.Tick += new EventHandler(TimerEventProcessor);
		myTimer.Interval = 5000;
      	myTimer.Start();
	}	

	private void TimerEventProcessor(){

		controller.setJoystickPosition(user.getJoystickPosition);

	}	
	
	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

}
