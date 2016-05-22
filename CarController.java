
/**
 * Write a description of class CarController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarController
{
  public static void main(String [] args){
      int speed = 0;
      int dir = 1;
      int time = 1;
      int turn = 1;
      
      if(args.length > 0){
          try {
              speed = Integer.parseInt(args[0]);
              dir = Integer.parseInt(args[1]);
              time = Integer.parseInt(args[2]);
              turn= Integer.parseInt(args[3]);
             
            }
            catch (NumberFormatException e){
                System.err.println("Argument" + args[0] + " must be an integer");
                System.exit(1);
            }
        }
      Car myCar = new Car();
      System.out.println("Speed is " + speed);
     if(dir >0){ // moving forward
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
            myCar.setStraight();
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
        */
    }
    System.out.println("Complete");
    }
    
}
