import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class DisplayRentalFile {
    public static void main(String[] args) {
        Path file = Paths
                .get("C:\\Users\\SeanWestbrook\\OneDrive\\Desktop\\WilmU\\Java2\\Westbrook_Sammy_12\\Rentals.java");
        String s = "";

        try {
            InputStream rental = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader rentalReader = new BufferedReader(new InputStreamReader(rental));
            s = rentalReader.readLine();
            while (s != null) {
                display(s);
                s = rentalReader.readLine();
            }
            rentalReader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void display(String s) {
        String[] array = new String[6];
        String delimiter = ",";
        String stringId;
        String equipment;
        int hours;
        int minutes;
        int equipmentType;
        double price;
        array = s.split(delimiter);
        stringId = array[0];
        hours = Integer.parseInt(array[1]);
        minutes = Integer.parseInt(array[2]);
        equipmentType = Integer.parseInt(array[3]);
        equipment = (array[4]);
        price = Double.parseDouble(array[5]);
        System.out.println("#" + stringId + "    " + hours + " hours and " + minutes + " minutes   Equipment: "
                + equipmentType + " " + equipment + "    Price  $" + price);
    }
}