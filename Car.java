
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
    Motor drive;
    int __speed;
   // Motor steer;
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
        drive = new Motor (1, 23);
    }
    
    public void setSpeed(int speed){
        __speed = speed;
    }
    
    public void moveForward(int delay){
        drive.setSpeed(__speed);
        drive.moveForward(delay);
    }
    
    public void moveBackward(int delay){
        drive.setSpeed(__speed);
        drive.moveBackward(delay);
    }

}
