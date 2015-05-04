package partOne;

import fxPackage.*;

import java.io.FileNotFoundException;
import java.io.IOException;



public class Part1 {

    public static void main(String[] args) throws IOException {
        run();
    }
    public static void run() throws FileNotFoundException {
        String gender = FinalProjectTemplate.getGender();
        String name = FinalProjectTemplate.getName();
        String year = FinalProjectTemplate.getYear();
        String list = SearchFile.searchList(year, name);
        String[] array = SearchFile.lineToArray(list);
        SearchFile.printResult(array, name, gender, year);
    }
    public static String resultReturn() throws FileNotFoundException {
        String result;
        if(FinalProjectTemplate.getYear().equals("All")){
            String gender = FinalProjectTemplate.getGender();
            String name = FinalProjectTemplate.getName();
            String list = SearchCumulativeFile.searchList(name);
            String[] array = SearchCumulativeFile.lineToArray(list);
            result = SearchCumulativeFile.returnResult(array, name, gender);
            return result;
        } else {
            String gender = FinalProjectTemplate.getGender();
            String name = FinalProjectTemplate.getName();
            String year = FinalProjectTemplate.getYear();
            String list = SearchFile.searchList(year, name);
            String[] array = SearchFile.lineToArray(list);
            result = SearchFile.returnResult(array, name, gender, year);
            return result;
        }
    }

}
