package partOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SearchCumulativeFile {
    public static String searchList(String name) throws FileNotFoundException {
        String targetLine = null;
        @SuppressWarnings("resource")
        Scanner input = new Scanner(new File("ranking_cumulative.txt"));
        while(input.hasNextLine()){
            String currentLine = input.nextLine();
            if(currentLine.contains(name)){
                StringTokenizer tokenizer = new StringTokenizer(currentLine);
                while(tokenizer.hasMoreTokens()){
                    if(tokenizer.nextToken().equals(name)) {
                        targetLine = currentLine;
                    }
                }
            }
        }
        return targetLine;
    }

    public static String[] lineToArray(String list){
        String[] table = new String[5];

        try{
            StringTokenizer tokenizer = new StringTokenizer(list);
            while(tokenizer.hasMoreTokens()) {
                for(int i = 0; i < table.length; i++){
                    table[i] = tokenizer.nextToken();
                }
            }
        } catch (Exception e) {

        }
        return table;
    }

    public static void printResult(String[] list, String name, String gender){
        if(gender.equals("M") && name.equals(list[1])){
            System.out.println(name + " is ranked #" + list[0] + " overall " );
        }
        else if(gender.equals("F") && name.equals(list[3])){
            System.out.println(name + " is ranked #" + list[0] + " overall ");
        }
        else {
            System.out.println(name + " is unranked overall " );
        }
    }

    public static String returnResult(String[] list, String name, String gender){
        String result;
        if(gender.equals("M") && name.equals(list[1])){
            result = (name + " is ranked #" + list[0] + " overall ");
        }
        else if(gender.equals("F") && name.equals(list[3])){
            result = (name + " is ranked #" + list[0] + " overall " );
        }
        else {
            result = (name + " is unranked overall ");
        }
        return result;
    }

}
