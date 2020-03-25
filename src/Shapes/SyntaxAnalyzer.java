package Shapes;

import java.io.*;
import java.util.Arrays;

public class SyntaxAnalyzer {
    public static void main(String[] args) {
        String[] exe= new String[0];
        try {
            File file = new File("exercise.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();

            while (line != null) {
                //System.out.println(line);
                String[] split = line.split(" ");
                String[] joinedArray = new String[exe.length + split.length];
                System.arraycopy(exe, 0, joinedArray, 0, exe.length);
                System.arraycopy(split, 0, joinedArray, exe.length, split.length);
                exe = joinedArray;
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String word:exe){
            System.out.println(word);
        }
    }
}
