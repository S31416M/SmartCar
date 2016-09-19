import com.pi4j.wiringpi.*;
public class DistanceSensor
{
    // instance variables - replace the example below with your own
    int __trig;
    int __echo;
    long __counter;

    /**
     * Constructor for objects of class DistanceSensor
     */
    public DistanceSensor(int rpi_trig, int rpi_echo)
    {
        __trig = rpi_trig;
        __echo = rpi_echo;
       Gpio.pinMode(__trig, Gpio.OUTPUT);
       Gpio.pinMode(__echo, Gpio.INPUT);
        Gpio.digitalWrite(__trig, 0);
        Gpio.delay(250);
        Gpio.digitalWrite(__trig, 1);
        Gpio.delay(500);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    private long getDistance()
    {
   //    Gpio.digitalWrite(__trig, 1);
    //   Gpio.delay(100);
       // wait for echo to go down
   //   System.out.println("***********************************************************************");
        __counter = 0;
        while(Gpio.digitalRead(__echo)==1){
   //       System.out.println("waiting for echo to go down");
        }
    //   System.out.println("***********************************************************************");
       while(Gpio.digitalRead(__echo)==0){
    //     System.out.println("waiting for echo to go up");
        }
  //    System.out.println("***********************************************************************");
       while(Gpio.digitalRead(__echo)==1){
           __counter++;
   //        System.out.println("sensing distance, counting up");
        }
        return __counter;
    }
    
    public long getAverageDistance3 (int x) {
        long distance = getDistance();
        distance = distance + getDistance();
        distance = distance + getDistance();
        return (distance/3);
      
    }
    
    /*The function gets the average distance based on the distances given from the sensor from an obstacle.
     * The user inputs how many distances they want to average (numReadings)
     * The output returns the average of those distances 
     */
    
    public long getAverageDistance (int numReadings) {
        long distance = 0;
    /*    int count = 0;
        while (count < numReadings) {
            distance = distance + getDistance();
            count++;
        } */
        for (int count = 0; count < numReadings; count++) {
            distance = distance + getDistance();
            Gpio.delay(50);
        }
        return (distance/numReadings);
    }
}

