
/**
 * Write a description of class Car here.
 * 
 * @author (Mayukha) 
 * @version (Start: 3/20)
 */

import com.pi4j.wiringpi.*;

public class Car
{
    // instance variables - replace the example below with your own
    Motor __drive;
    Motor __steer;
    DistanceSensor __ds;
   // EchoSensor frontSensor;

    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        Gpio.wiringPiSetup();
        Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
        Gpio.pwmSetClock(384);
        Gpio.pwmSetRange(1024);
        Gpio.pinMode (1, Gpio.PWM_OUTPUT);
        Gpio.pinMode (23, Gpio.PWM_OUTPUT);
        Gpio.pinMode (4, Gpio.OUTPUT);
        Gpio.pinMode (5, Gpio.OUTPUT);
        //SoftPwm.softPwmCreate(4, 0, 100);
        //SoftPwm.softPwmCreate(5,0, 100);
       
        __drive = new Motor (23, 1);
        __steer = new Motor (5, 4);
        __ds = new DistanceSensor (15,16);
    }
    
    public void moveForward (int speed) {
        __drive.rotateForward (speed);
    }
    
    public void moveBackward (int speed) {
        __drive.rotateBackward (speed);
    }
    
    public void brake () {
        __drive.stopRotation();
        __drive.rotateBackward(1000);
        Gpio.delay(600);
        __drive.stopRotation();
    }

    public void turnRight () {
        __steer.turnRight();
    }
    public void turnLeft () {
        __steer.turnLeft();
  //      __steer.turnRight(10);
    
    }
    public void setStraight()
    {
        __steer.setStraight();
    } 
    public void turnRight(int time){
        __steer.turnRight(time);
    }
    public void turnLeft(int time){
        __steer.turnLeft(time);
    }
    public long getDistance(){
    return  __ds.GetAverageDistance(1);
}
public void brakeBackward () {
        //__drive.stopRotation();
        //__drive.rotateForward(1000);
        //Gpio.delay(600);
        __drive.stopRotation();
    }
}