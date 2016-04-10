
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
      if(args.length > 0){
          try {
              speed = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e){
                System.err.println("Argument" + args[0] + " must be an integer");
                System.exit(1);
            }
        }
      Car myCar = new Car();
      System.out.println("Speed is " + speed);
      myCar.setSpeed(speed);
      myCar.moveForward(30000);
      System.out.println("Done");
    }
    
}
