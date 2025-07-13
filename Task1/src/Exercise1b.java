//The main method is not inside a class. Java requires all code to be in classes.

public class Exercise1b { //Class Added
    public static void main(String [] args) {
        int x = 5;
        while ( x > 1 ) {
            x = x - 1;
            if ( x < 3) {
                System.out.println("small x");
            }
        }
    }

}
