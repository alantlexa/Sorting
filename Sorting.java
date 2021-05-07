package com.alantMergeSort;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import static java.nio.charset.StandardCharsets.UTF_8;

public class Sorting {


    public static void main(String[] args)  {

        ArrayList<Integer> combo = new ArrayList<>();

        try {
            cmd(args, combo);

            for (int s : combo)
            System.out.println(s);

        } catch(ArrayIndexOutOfBoundsException ai){
            System.err.println("Invalid arguments set.");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Integer> sort(ArrayList<Integer> combo) {
        // метод разбивает переданный массив на множество малых массивов,
        // содержащие по 2 элемента.
        if (combo.size() == 1) {
            return combo;
        }
        else {
            int div = combo.size() / 2;
            ArrayList<Integer> left = new ArrayList<>(div);
            ArrayList<Integer> right = new ArrayList<>(combo.size() - div);

            for (int i = 0; i < div; i++) {
                left.add(combo.get(i));
            }

            for (int i = div; i < combo.size(); i++) {
                right.add(combo.get(i));
            }

                sort(left);
                sort(right);
                merge(left, right, combo);

        }
        return combo;
    }

    public static void merge (ArrayList<Integer>left, ArrayList<Integer>right, ArrayList<Integer>combo)
    {

        int indL = 0;
        int indR = 0;

        for (int i = 0; i < combo.size(); i++) {

            if (indL == left.size()) {
                combo.set(i, right.get(indR));
                indR++;
            }
            else {
                if (indR == right.size()) {
                    combo.set(i, left.get(indL));
                    indL++;
                }
                else {
                    if (left.get(indL) <= right.get(indR)) {
                        combo.set(i, left.get(indL));
                        indL++;
                    }
                    else {
                        if (left.get(indL) >= right.get(indR)) {
                            combo.set(i, right.get(indR));
                            indR++;
                        }
                    }
                }
            }
        }
    }

    public static void cmd(String[] args, ArrayList<Integer> combo)  {

        int p;
        if (args[0].equals("-a")) {
            p = 2;

        } else if (!args[0].equals("-i")){
            System.out.println("Invalid arguments set.");
            return;
        } else {
            p = 1;
        }
        String out = args[p];
        try {

        p++;

            for (int i = p; i < args.length; i++) {
                try {
                String inFile = new File(args[i]).getAbsolutePath();
                List<String> lines = Files.readAllLines(Paths.get(inFile), UTF_8);
                    for (String s : lines) {
                        combo.add(Integer.parseInt(s));
                    }
                } catch (NoSuchFileException nsf) {
                    System.err.println("Invalid file name entered.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            sort(combo);

        } catch (StackOverflowError soe) {
            System.err.println("Invalid arguments set.");
        }

        try {
            FileWriter writer = new FileWriter(out);

            for (Integer co : combo) {
                String str = co.toString();
                writer.write(str);
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (IOException io) {
            System.err.println("The output file is not created.");
        }
    }
}
