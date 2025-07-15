//x never changes inside the while loop → infinite loop.
//This doesn't cause a compile-time error, but will cause the program to hang at runtime

class Exercise1a {
    public static void main(String[] args) {
        int x = 1;
        while (x < 10) {
            if (x > 3) {
                System.out.println("big x");
            }
            x++; // Fix: move x toward terminating the loop
        }
    }
}
