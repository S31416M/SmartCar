
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
        __steer = new Motor (4, 5);
    }
    
    public void moveForward (int speed, int time) {
        __drive.rotateForward (speed, time);
    }
    
    public void moveBackward (int speed, int time) {
        __drive.rotateBackward (speed, time);
    }
    
    public void brake () {
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
}