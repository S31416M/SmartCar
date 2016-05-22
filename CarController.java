
/**
 * Write a description of class CarController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarController
{
  public static void main(String [] args){
      int speed =0;
      int dir =1;
      if(args.length > 0){
          try {
              speed = Integer.parseInt(args[0]);
              dir = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e){
                System.err.println("Argument" + args[0] + " must be an integer");
                System.exit(1);
            }
        }
      Car myCar = new Car();
      System.out.println("Speed is " + speed);
     if(dir >0){
        //myCar.moveForward(speed,5000);
        myCar.turnRight(2000);
    }
       else{
           //myCar.moveBackward(speed,5000);
           myCar.turnLeft(2000);
           myCar.turnRight(10);
        }
        /*myCar.turnRight(5000);
        myCar.turnLeft(5000);
        */
    System.out.println("Complete");
    }
    
}
