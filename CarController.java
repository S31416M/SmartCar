
/**
 * Write a description of class CarController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import com.pi4j.wiringpi.*;
public class CarController
{
  public static void main(String [] args){
      int speed = 0;
      int dir = 1;
      int time = 1;
      int turn = 1;
      int turnTime = 1;
    
      
      if(args.length > 0){
          try {
              speed = Integer.parseInt(args[0]);
              //dir = Integer.parseInt(args[1]);
              time = Integer.parseInt(args[1]);
              //turn= Integer.parseInt(args[3]);
              //turnTime = Integer.parseInt(args[2]);
             
            }
            catch (NumberFormatException e){
                System.err.println("Argument" + args[0] + " must be an integer");
                System.exit(1);
            }
        }
      System.out.println("Speed is " + speed);
      Car myCar = new Car();
   /*   while(true){
          long frontDistance = myCar.getFrontDistance();
          System.out.println("Front distance is " + frontDistance);
          Gpio.delay(1000);
        }*/ 
        long frontDistance = myCar.getFrontDistance();
       
         System.out.println("Front distance is " + frontDistance);
     if(frontDistance > 12000){
          myCar.moveForward(speed);
        }
      while(frontDistance > 12000){
       //   delay(1);
         frontDistance = myCar.getFrontDistance(); 
          Gpio.delay(1);
         // System.out.println("Front distance is " + frontDistance);
    }  
     System.out.println("Front distance is " + frontDistance);
    myCar.brake();
     long rightDistance = myCar.getRightDistance();
        long leftDistance = myCar.getLeftDistance();
    if(rightDistance > leftDistance){
        myCar.turnRight();
        Gpio.delay(time);
    }
    else{
        myCar.turnLeft();
        Gpio.delay(time);
    }
    myCar.setStraight();
    myCar.moveForward(speed);
    Gpio.delay(time);
    myCar.brake();
}
}

    
   


