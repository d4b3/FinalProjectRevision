package commonFiles;

import java.io.*;
import java.util.*;


public class SortFile {
    static SortedSet<String> nameList = new TreeSet<String>();

    public static String getFileName(int year){
        String fileName = "Babynamesranking" + year + ".txt";
        return fileName;
    }
    public static void setTokens(String line) {
        StringTokenizer token = new StringTokenizer(line);
        String[] tokens = new String[5];
        for (int i = 0; i < tokens.length; i++){
            tokens[i] = token.nextToken();
        }
        setName(tokens[1]);
        setName(tokens[3]);
    }
    public static void setName(String token){
        nameList.add(token);
    }
    public static SortedSet<String> getName(){
        return nameList;
    }
    public static void readFile() throws FileNotFoundException {
        int[] years = {2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010};
        for(int i = 0; i < years.length; i++){
            String fileName = getFileName(years[i]);
//			File currentFile = new File(fileName);
//			Scanner file = new Scanner(currentFile);
            Scanner file = new Scanner(new File(fileName));
            while(file.hasNextLine()){
                String currentLine = file.nextLine();
                setTokens(currentLine);
            }
        }
    }
    public static void printList() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter w = new PrintWriter("names-collated.txt", "UTF-8");
        SortedSet<String> names = getName();
        Object[] n = names.toArray();
        for (int i = 0; i < n.length; i = i + 10) {
            try {
                System.out.println(n[i] + ", " + n[i + 1] + ", " + n[i + 2] + ", " + n[i + 3] + ", " + n[i + 4] + ", " + n[i + 5] + ", " + n[i + 6] + ", " + n[i + 7] + ", " + n[i + 8] + ", " + n[i + 9]);
                w.println(n[i] + ", " + n[i + 1] + ", " + n[i + 2] + ", " + n[i + 3] + ", " + n[i + 4] + ", " + n[i + 5] + ", " + n[i + 6] + ", " + n[i + 7] + ", " + n[i + 8] + ", " + n[i + 9]);
                w.flush();
            }catch(Exception e) {
                System.out.print(n[2530] + ", " + n[2531]); //exception fix, appending missing values
                w.println(n[2530] + ", " + n[2531]); //exception fix, appending missing values
                w.flush();
            }
        }
        w.close();
    }
}
