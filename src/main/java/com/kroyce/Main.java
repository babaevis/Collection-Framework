package com.kroyce;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CharCounter charCounter = new CharCounter();
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while(true){
            input = scanner.nextLine();
            if(input.equals("exit")){
                break ;
            }

            String result = charCounter.getUniqueCharacters(input);
            System.out.println(result);
        }
    }
}
