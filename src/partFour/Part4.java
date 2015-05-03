package partFour;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Part4 extends Sorter{
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        for (int i = 2001; i < 2011; i++) {
            openFile(i);
        }
        System.out.println("Sorting");
        sortList();
        System.out.println("Done");

        System.out.println("Printing");
        printList();
        System.out.println("Done");
    }

}

