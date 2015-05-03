package commonFiles;
import fxPackage.*;

public class UserQuery {
    public static String setName(){
        String name = FinalProjectTemplate.getName();
        return name;
    }
    public static String setYear() {
        String year = FinalProjectTemplate.getYear();
        return year;
    }

    public static String queryGender() {
        String gender = FinalProjectTemplate.getGender();
        return gender;
    }

    public static String fromFile(String year) {
        System.out.println("Removing ranks from Babynamesranking" + year + ".txt");
        return "Babynamesranking" + year + ".txt";
    }
    public static String toFile(String year) {
        System.out.println("Writing to Babynamesranking" + year + ".new");
        return "Babynamesranking" + year + ".new";
    }

    public static String getFilename(String year) {
        String filename = "Babynamesranking" + year + ".txt";
        return filename;

    }
    public static String getFilename(int year) {
        String filename = "Babynamesranking" + year + ".txt";
        return filename;

    }

}

