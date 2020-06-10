package com.kroyce;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounter {
    private static final Map<String, Map<Character, Integer>> cache = new HashMap<>();

    public String getUniqueCharacters(String input){
        if(input == null){
            throw new IllegalArgumentException("Bad argument");
        }

        if (input.isEmpty()){
            return input;
        }

        String mapAsString = transformMap(getCharMap(input));

        return (input + "\n" + mapAsString);
    }

    private String transformMap(Map<Character, Integer> charMap){
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()){
            result.append("\"").append(entry.getKey()).append("\"");
            result.append(" - ").append(entry.getValue()).append("\n");
        }

        return result.toString();
    }

    private Map<Character, Integer> getCharMap(String input){
        if(cache.containsKey(input)){
            return cache.get(input);
        }

        return makeMap(input);
    }

    private Map<Character, Integer> makeMap(String input){
        Map<Character, Integer> charMap = new LinkedHashMap<>();

        for(char symbol : input.toCharArray()){
            charMap.merge(symbol, 1, (oldVal, newVal) -> oldVal + 1);
        }

        cache.put(input, charMap);

        return charMap;
    }
}
