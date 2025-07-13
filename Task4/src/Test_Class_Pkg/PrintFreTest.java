package Test_Class_Pkg;

import Main.Main;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class PrintFreTest {
    Main main = new Main();

    @Test
    public void TestExtract(){
        HashMap<Character,Integer> map = main.textExtract("Hello World");
        assertEquals(7, map.size());
        System.out.println(map);
    }
}
