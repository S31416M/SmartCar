
/**
 * Write a description of class Motor here.
 * 
 * @author (Mayukha) 
 * @version (Start: 3/25)
 */
import com.pi4j.wiringpi.*;
public class Motor
{
    int __pin1, __pin2;
    double __ton, __toff;
    /**
     * Constructor for objects of class Motor
     */
    public Motor(int rp_pin1, int rp_pin2)
    {
        __pin1 = rp_pin1;
        __pin2 = rp_pin2;
        __ton = 250;
        __toff = 250;
    }
    
    public void rotateForward (int voltage, int time)
    {
        Gpio.pwmWrite (__pin1, voltage);
        Gpio.pwmWrite (__pin2, 0);
        Gpio.delay (time);
        Gpio.pwmWrite(__pin1, 0);
    }

    public void rotateBackward (int voltage, int time)
    {
        Gpio.pwmWrite (__pin2, voltage);
        Gpio.pwmWrite (__pin1, 0);
        Gpio.delay (time);
        Gpio.pwmWrite (__pin2, 0);
    }
    
    public void stopRotation ()
    {
        Gpio.pwmWrite (__pin1, 0);
        Gpio.pwmWrite (__pin2, 0);
    }

    public void turnRight ()
    {
       Gpio.digitalWrite (__pin1, 1);
       Gpio.digitalWrite (__pin2, 0);
    }
    
    public void turnLeft ()
    {
       Gpio.digitalWrite (__pin2, 1);
        Gpio.digitalWrite (__pin1, 0);
        //SoftPwm.softPwmWrite(__pin2, 50);
        //SoftPwm.softPwmWrite(__pin1,0);
       //SoftPwm.softPwmWrite(__pin2, 0);
    }
     public void turnRight (int time)
    {
       Gpio.digitalWrite (__pin1, 1);
       Gpio.digitalWrite (__pin2, 0);
       Gpio.delay(time);
       Gpio.digitalWrite(__pin1, 0);
    }
    
    public void turnLeft (int time)
    {
       Gpio.digitalWrite (__pin2, 1);
        Gpio.digitalWrite (__pin1, 0);
        Gpio.delay(time);
       Gpio.digitalWrite(__pin2, 0);
        //SoftPwm.softPwmWrite(__pin2, 50);
        //SoftPwm.softPwmWrite(__pin1,0);
       //SoftPwm.softPwmWrite(__pin2, 0);
    }
    public void setStraight()
    {
       Gpio.digitalWrite (__pin1, 1);
       Gpio.digitalWrite(__pin2,0);
       Gpio.delay(10);
        Gpio.digitalWrite (__pin2, 0);
        Gpio.digitalWrite (__pin1, 0);
    }
}