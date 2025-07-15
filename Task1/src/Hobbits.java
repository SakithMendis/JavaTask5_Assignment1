// Compile Failed : Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//	at Task1.Hobbits.main(Hobbits.java:11)
//Fixed: Change z=0 to z=-1 and Change z<4 to z<2 Because array can only store 3 values

class Hobbits {
    String name;
    public static void main(String[] args) {
        Hobbits[] h = new Hobbits[3];
        int z = -1; // Change z=0 to z=-1
        while (z < 2) { // Change z<4 to z<2 Because array can only store 3 values
            z = z + 1;
            h[z] = new Hobbits();
            h[z].name = "bilbo";
            if (z == 1) {
                h[z].name = "frodo";
            }
            if (z == 2) {
                h[z].name = "sam";
            }
            System.out.print(h[z].name + " is a ");
            System.out.println("good Hobbit name");
        }
    }
}

