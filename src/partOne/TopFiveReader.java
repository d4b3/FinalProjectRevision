package partOne;

import fxPackage.FinalProjectTemplate;

import java.util.Scanner;
import java.io.*;
/**
 * Created by Dan Blocker on 5/3/2015.
 */
public class TopFiveReader {
    public static String[] labelList(String file) throws FileNotFoundException {
        Scanner input = new Scanner(new File(file));
        String[] list = new String[5];
        for(int i = 0; i < list.length; i++){
            list[i] = input.nextLine();
        }
        return list;
    }
    public static String[] labelYearList() throws FileNotFoundException {
        String year = FinalProjectTemplate.getYear();
        String yearList = "Babynamesranking" + year + ".txt";
        Scanner input = new Scanner(new File(yearList));
        String[] list = new String[5];
        for(int i = 0; i < list.length; i++){
            list[i] = input.nextLine();
        }
        return list;
    }

}
