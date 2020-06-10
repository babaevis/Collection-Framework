package com.kroyce;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharCounterTests {
    @Test
    void nullArg(){
        CharCounter charCounter = new CharCounter();
        String input = null;
        assertThrows(IllegalArgumentException.class, () ->{
            charCounter.getUniqueCharacters(input);
        });
    }

    @Test
    void example(){
        CharCounter charCounter = new CharCounter();
        String actual = charCounter.getUniqueCharacters("hello world");
        String expected =   "hello world\n" +
                            "\"h\" - 1\n" +
                            "\"e\" - 1\n" +
                            "\"l\" - 3\n" +
                            "\"o\" - 2\n" +
                            "\" \" - 1\n" +
                            "\"w\" - 1\n" +
                            "\"r\" - 1\n" +
                            "\"d\" - 1\n";

        assertEquals(actual,expected);
    }

    @Test
    void spaces(){
        CharCounter charCounter = new CharCounter();
        String input = "    ";
        String actual = charCounter.getUniqueCharacters(input);
        String expected =    "    \n" +
                             "\" \" - 4\n";

        assertEquals(expected,actual);
    }

    @Test
    void emptyInput(){
        CharCounter charCounter = new CharCounter();
        String input = "";
        String expected = "";
        String actual = charCounter.getUniqueCharacters(input);

        assertEquals(expected,actual);
    }
}
