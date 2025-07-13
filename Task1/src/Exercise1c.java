//cannot have statements like while directly in the class body outside a method or initializer block

class Exercise1c {

    public static void main(String [] args) { //main methord is added
        int x = 5;
        while (x > 1) {
            x = x - 1;
            if (x < 3) {
                System.out.println("small x");
            }
        }
    }
}
