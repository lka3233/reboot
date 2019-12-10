package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class FrequencyAnalysis {
    public static void main(String[] args) {
        File file = new File("C://reboot//newfile.txt");
        Path outFilePath = Paths.get("C://reboot//output.txt");
        HashMap<Character, Integer> hashmap = analyseFile(file);
        try{
            saveMapToFile(hashmap, outFilePath);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void saveMapToFile(HashMap<Character, Integer> hashmap, Path outFilePath) throws IOException {
        if(Files.exists(outFilePath))
            Files.write(outFilePath, hashmap.toString().getBytes(), StandardOpenOption.APPEND);
        else
            Files.write(outFilePath, hashmap.toString().getBytes(), StandardOpenOption.CREATE);
    }

    public static HashMap<Character, Integer> analyseFile(File file){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            while (br.ready()){
                //читаем строку
                String s = br.readLine();
                //смотрим строку посимвольно
                char[] characters = s.toCharArray();
                for (int i = 0; i < characters.length; i++) {
                    //если символ есть в ключе мапы валью + 1 иначе добавляем в мапу с валью 1
                    if(!(hashMap.containsKey(characters[i])))
                       hashMap.put(characters[i],1);
                    else
                        for (Map.Entry<Character, Integer> entry:hashMap.entrySet()){
                        if (entry.getKey() == characters[i])
                            entry.setValue(entry.getValue() + 1);
                        }
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return hashMap;
    }
}
