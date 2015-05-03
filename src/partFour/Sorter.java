package partFour;

import commonFiles.UserQuery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sorter extends UserQuery {

    public static void openFile(int year) throws FileNotFoundException  {
        String filename = getFilename(year);
//			String filename = "Babynamesranking" + year + ".txt";
//			File currentFile = new File(filename);
        Scanner in = new Scanner(new File(filename));
        while(in.hasNextLine()) {
            String currentLine = in.nextLine();
            stringToToken(currentLine);
        }
        in.close();
    }
    public static void stringToToken(String input) {
        StringTokenizer st = new StringTokenizer(input);
        String[] tokens = new String[5];
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = st.nextToken();
        }
        addToBoyList(tokens[1], tokens[2]);
        addToGirlList(tokens[3], tokens[4]);
    }
    public static void addToBoyList(String name, String count) {
        int nameCount = formatCount(count);
        if(Data.boyName.contains(name)) {
            int index = Data.boyName.indexOf(name);
            int currentCount = Data.boyCount.get(index);
            int newCount = currentCount + nameCount;
            Data.boyCount.set(index, newCount);
        }
        else {
            Data.boyName.add(name);
            Data.boyCount.add(nameCount);
        }
    }
    public static void addToGirlList(String name, String count) {
        int nameCount = formatCount(count);
        if(Data.girlName.contains(name)) {
            int index = Data.girlName.indexOf(name);
            int currentCount = Data.girlCount.get(index);
            int newCount = currentCount + nameCount;
            Data.girlCount.set(index, newCount);
        }
        else {
            Data.girlName.add(name);
            Data.girlCount.add(nameCount);
        }
    }
    public static void sortList() {
        while(Data.boyCount.size() > 0) {
            int highest = Data.boyCount.get(0);
            for (int i = 0; i < Data.boyCount.size(); i++) {
                int current = Data.boyCount.get(i);
                if(current > highest) {
                    highest = current;
                }
            }
            int indexOfHighest = Data.boyCount.indexOf(highest);
            String name = Data.boyName.get(indexOfHighest);
            Data.boyNameSorted.add(name);
            Data.boyCountSorted.add(highest);
            Data.boyCount.remove(indexOfHighest);
            Data.boyName.remove(indexOfHighest);
        }
        while(Data.girlCount.size() > 0) {
            int highest = Data.girlCount.get(0);
            for (int i = 0; i < Data.girlCount.size(); i++) {
                int current = Data.girlCount.get(i);
                if(current > highest) {
                    highest = current;
                }
            }
            int indexOfHighest = Data.girlCount.indexOf(highest);
            String name = Data.girlName.get(indexOfHighest);
            Data.girlNameSorted.add(name);
            Data.girlCountSorted.add(highest);
            Data.girlCount.remove(indexOfHighest);
            Data.girlName.remove(indexOfHighest);
        }
    }
    public static void printList() throws FileNotFoundException, UnsupportedEncodingException {
//		PrintWriter cumulative = new PrintWriter("ranking_cumulative.txt", "UTF-8");
        PrintWriter boys = new PrintWriter("ranking_boys.txt", "UTF-8");
        PrintWriter girls = new PrintWriter("ranking_girls.txt", "UTF-8");
        Object[] bn = Data.boyNameSorted.toArray();
        Object[] gn = Data.girlNameSorted.toArray();
        Object[] bc = Data.boyCountSorted.toArray();
        Object[] gc = Data.girlCountSorted.toArray();
        try {
            for (int i = 0; i < bc.length; i++) {
//				cumulative.println(i+1 + "  " + bn[i] + "  " + bc[i] + "  " + gn[i] + "  " + gc[i]);
//				cumulative.flush();
                boys.println(i + "  " + bn[i] + "  " + bc[i]);
                boys.flush();
            }
//			for (int i = bc.length; i < gc.length; i++) {
//				cumulative.println(i+1 + "  " + gn[i] + "  " + gc[i]);
//				cumulative.flush();
//			}
            for (int i = 0; i < gc.length; i++) {
                girls.println(i+1 + "  " + gn[i] + "  " + gc[i]);
                girls.flush();
            }
        } finally {
//			cumulative.close();
            boys.close();
            girls.close();
        }

    }
    public static int formatCount(String count) {
        int intCount;
        StringBuilder sb = new StringBuilder(count);
        int length = count.length();
        if(length == 6) {
            sb.deleteCharAt(2);
            String result = sb.toString();
            intCount = Integer.parseInt(result);
        }
        else if(length == 5) {
            sb.deleteCharAt(1);
            String result = sb.toString();
            intCount = Integer.parseInt(result);
        }
        else {
            intCount = Integer.parseInt(count);

        }
        return intCount;
    }
}


