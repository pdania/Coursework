package Shapes;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class SyntaxAnalyzer {
    public static void main(String[] args) {
        Stack<String> exercise = new Stack<>();
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
                for (String word:split){
                    exercise.push(word);
                }
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for (String word:exercise) {
//            System.out.println(word);
//        }
            analyze(exercise);


    }
    private static void analyze ( Stack<String> exercise ){
        String answer="";
        Shape sh=new Shape() {
            @Override
            public double perimeter() {
                return 0;
            }

            @Override
            public double area() {
                return 0;
            }
        };
        for (int i =0; i<exercise.size();++i) {
            String fst = exercise.get(i);
            if (fst.equals("Периметр")) {
               int g =++i;
                    String shape = exercise.get(g);

                    //then we need to add other shapes and
                    while (!shape.equals("трикутника")) {
                        shape = exercise.get(g++);
                    }
                    sh = new MyTriangle();
                    if(g>i){

                            String type = exercise.get(i);
                            if(type.equals("рівнобедренного")){
                                ((MyTriangle) sh).setTriangleType(Type.Rivnobedrenyi);
                            }
                            if(type.equals("прямокутного")){
                                ((MyTriangle) sh).setTriangleType(Type.Pryamokutnyi);
                            } else if (  ((MyTriangle) sh).getTriangleType() == null){
                                ((MyTriangle) sh).setTriangleType(Type.Riznostoronni);
                            }

                    }
                String num = exercise.get(i++);
                while (!isNumeric(num)){
                    num = exercise.get(i++);
                    i++;
                }
                ((MyTriangle) sh).setPerimeter( Double.parseDouble(num));
                }


            fst = exercise.get(i);
            if(fst.equals("бічна")){
                String snd = exercise.get(++i);
                while(!isNumeric(snd)){
                    snd = exercise.get(++i);
                }
                ((MyTriangle) sh).setSideA(Double.parseDouble(snd));
                ((MyTriangle) sh).setSideC(Double.parseDouble(snd));

            }
            if(fst.equals("сторона")){
                String snd = exercise.get(++i);
                while(!isNumeric(snd)){
                    snd = exercise.get(++i);
                }
                //add which side
//                ((MyTriangle) sh).setSideA(Double.parseDouble(snd));
            }
            //looking dor question
            if(fst.equals("Знайдіть")){
                int g = ++i;
                String snd = exercise.get(g);
                if(snd.equals("основу")){
                    answer += "Основа="+((MyTriangle) sh).getSideB();
                }
            }
        }

        System.out.println(answer);
            System.out.println(sh.toString());

    }
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
