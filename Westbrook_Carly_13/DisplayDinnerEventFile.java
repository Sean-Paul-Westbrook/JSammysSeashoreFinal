import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class DisplayDinnerEventFile {
    public static void main(String[] args) {
        Path file = Paths
                .get("C:\\Users\\SeanWestbrook\\OneDrive\\Desktop\\WilmU\\Java2\\Westbrook_Carly_12\\Events.java");
        String s = "";

        try {
            InputStream input = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            s = reader.readLine();
            while (s != null) {
                display(s);
                s = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void display(String s) {
        String[] array = new String[4];
        String delimiter = ",";
        String stringId;
        String eventType;
        int guests;
        double price;
        array = s.split(delimiter);
        stringId = array[0];
        eventType = array[1];
        guests = Integer.parseInt(array[2]);
        price = Double.parseDouble(array[3]);
        System.out.println(
                stringId + "    " + "Event Type Code: " + eventType + "      " + "Guests: " + guests + "    $" + price);
    }
}