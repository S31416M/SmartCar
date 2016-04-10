
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
    int __speed;

    /**
     * Constructor for objects of class Motor
     */
    public Motor(int pin1, int pin2)
    {
        __pin1 = pin1;
        __pin2 = pin2;
       __speed = 0; 
    }
    
    public void setSpeed (int speed) 
    {
        __speed = speed;
    }
    
    public void moveForward (int time)
    {
        Gpio.pwmWrite (__pin2, 0);
        Gpio.pwmWrite (__pin1, __speed);
        Gpio.delay (time);
        Gpio.pwmWrite(__pin1, 0);
    }

    public void moveBackward (int time)
    {
        Gpio.pwmWrite (__pin1, 0);
        Gpio.pwmWrite (__pin2, __speed);
        Gpio.delay (time);
        Gpio.pwmWrite (__pin2, 0);
    }
}
