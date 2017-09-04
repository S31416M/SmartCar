
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
       if(speed <=0 ){
          System.out.println("Stopping car and exiting");
          myCar.moveForward(0);
          System.exit(0);
        }
   /*   while(true){
          long frontDistance = myCar.getFrontDistance();
          System.out.println("Front distance is " + frontDistance);
          Gpio.delay(1000);
        }*/ 
   
             while (true) {
            myCar.moveForwardUntilObject (speed, 12000);
            long rightDistance = myCar.getRightDistance();
            System.out.println ("Right distance is " + rightDistance);
            long leftDistance = myCar.getLeftDistance();
            System.out.println ("Left distance is " + leftDistance);
            if(rightDistance > leftDistance){
                myCar.turnRight(time);
            }
            else{
                myCar.turnLeft(time);
            }
            myCar.setStraight();
        }
      
        
/*    myCar.moveForward(speed);
    Gpio.delay(time);
    myCar.brake();
  
   while (frontDistance < 12000) {
    myCar.turnRight(time);
    frontDistance = myCar.getFrontDistance();
}
    myCar.moveForward(speed);
    Gpio.delay(time);
    myCar.brake();
}
*/
}
}



    
   


