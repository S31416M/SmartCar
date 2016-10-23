
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
      //int dir = 1;
      int time = 1;
      //int turn = 1;
      int turnTime = 1;
      
      if(args.length > 0){
          try {
              speed = Integer.parseInt(args[0]);
              //dir = Integer.parseInt(args[1]);
              time = Integer.parseInt(args[1]);
              //turn= Integer.parseInt(args[3]);
          //    turnTime = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException e){
                System.err.println("Argument" + args[0] + " must be an integer");
                System.exit(1);
            }
        }
      Car myCar = new Car();
      System.out.println("Speed is " + speed);
      // this isthe control
     /* if(dir >0){ // moving forward
        myCar.moveForward(speed,time);
        if(turn > 0){
            myCar.turnRight();
            myCar.moveForward(speed,time);
            myCar.setStraight();
            myCar.brake();
        }
        else{
           myCar.turnLeft();
            myCar.moveForward(speed,time);
            myCar.setStraight();
            myCar.brake();
        }   
    }
    else{ //moving backward 
         myCar.moveBackward(speed,time);
         if (turn >0){
             myCar.turnRight();
            myCar.moveBackward(speed,time);
            myCar.setStraight();;
            myCar.brake();
        }
        else{
            myCar.turnLeft();
            myCar.moveBackward(speed,time);
            myCar.setStraight();
            myCar.brake();
        }
        /*myCar.turnRight(5000);
        myCar.turnLeft(5000);
        
       } */
   
       /*myCar.moveForward(speed,time);
       myCar.turnRight(turnTime);
       myCar.setStraight();
       myCar.brake();*/
   
      long distance = myCar.getDistance();
      System.out.println(distance);
      if(myCar.getDistance() > 15000) {
          myCar.moveForward(speed);
        }
        while (distance > 15000){
            System.out.println(distance);
            //myCar.moveForward(speed);
            Gpio.delay(time);
            distance = myCar.getDistance();
       
        }
        myCar.brake();
        System.out.println(distance);
        myCar.moveBackward(speed);
        Gpio.delay(2000);
        myCar.brakeBackward();
        myCar.turnRight();
        myCar.moveForward(speed);
        Gpio.delay(5000);
        myCar.setStraight();
        myCar.brake();
}
}
   

