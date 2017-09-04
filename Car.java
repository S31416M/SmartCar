
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
    int __enPin;
    Motor __right;
    Motor __left;
    DistanceSensor __fds;
    DistanceSensor __rds;
    DistanceSensor __lds;
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
       // Gpio.pinMode (6, Gpio.OUTPUT); // was the enable output, now hardwired to 5v
        Gpio.pinMode (1, Gpio.PWM_OUTPUT); //right wheel
        Gpio.pinMode (23, Gpio.PWM_OUTPUT); //left wheel
        Gpio.pinMode (4, Gpio.OUTPUT); // right wheel
        Gpio.pinMode (5, Gpio.OUTPUT); //left wheel
        //SoftPwm.softPwmCreate(4, 0, 100);
        //SoftPwm.softPwmCreate(5,0, 100);
       __enPin =6;
        __right = new Motor (1, 4);
        __left = new Motor (23, 5);
        __fds = new DistanceSensor (30, 14);
       __lds = new DistanceSensor(2, 3);
        __rds = new DistanceSensor(24, 25);
    }
    
    public void startCar(){
        Gpio.digitalWrite(__enPin,1);
    }
    
    public void stopCar(){
        Gpio.digitalWrite(__enPin, 0);
    }
    
    public void moveForward (int speed) {
        __right.rotateForward (speed);
        __left.rotateForward (speed);
    }
    
    public void moveBackward () {
        __right.rotateBackward ();
        __left.rotateBackward ();
    }
    
    public void brake () {
        __right.stopRotation();
        __left.stopRotation();
      // __drive.rotateBackward(1000);
      //  Gpio.delay(500);
      // __drive.stopRotation();
    }

    public void brakeBackward () {
     //   __drive.stopRotation();
      //  __drive.rotateForward(1000);
      //  Gpio.delay(500);
        __right.stopRotation();
        __left.stopRotation();
    }
    
    /*public void turnRight () {
        __right.stopRotation();
        __left.rotateForward(1020);
    }
    public void turnLeft () {
        __left.stopRotation();
        __right.rotateForward(1020);
    
    }*/
  
    public void setStraight()
    {
        __right.stopRotation();
        __left.stopRotation();
    }
    
    public void turnRight(int time) {
        __right.stopRotation();
        __left.rotateForward(1023);
        Gpio.delay(time); 
        __left.stopRotation();
    }
    
    public void turnLeft(int time) {
        __left.stopRotation();
        __right.rotateForward(1023);
        Gpio.delay(time);
        __right.stopRotation();
    }
    
    public void moveForwardUntilObject (int speed, long stoppingDistance) {
        long frontDistance = getFrontDistance();
        while(frontDistance > stoppingDistance){
            moveForward(speed);
            Gpio.delay(1);
            frontDistance = getFrontDistance();
        }
        brake();
        System.out.println("Front distance is " + frontDistance);
    }
    
/*    public void turnRight (int time)
    {
        __steer.turnRight (time);
    }   

    public void turnLeft (int time)
    {
        __steer.turnLeft (time);
    }    
*/
    public long getFrontDistance ()
    {
        return __fds.getAverageDistance (3);
    }
    
    public long getLeftDistance ()
    {
        return __lds.getAverageDistance (3);
    }
    
    public long getRightDistance ()
    {
        return __rds.getAverageDistance (3);
    }

    public int sum (int n) 
    {
        int x = 1;
        int sum = 0;
        for (int count = 0; count < n; count++) {
            sum = x + sum;
            x++;
        }
        return (sum);
    }
}