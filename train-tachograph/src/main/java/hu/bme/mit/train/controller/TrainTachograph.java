package hu.bme.mit.train.tachograph;

import com.google.common.collect.Table;  
import com.google.common.collect.HashBasedTable;  

public class TrainTachograph {

	private Table<long, double, double> tachograph = HashBasedTable.create();

	public void addElement(long timestamp,double joystick, double speed){
		tachograph.put(timestamp, joystick, speed); 
	}	

	public boolean isEmpty(){
		return tachograph.isEmpty(); 
	} 

}
