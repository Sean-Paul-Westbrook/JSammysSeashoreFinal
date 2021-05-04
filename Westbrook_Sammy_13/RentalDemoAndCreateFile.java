import java.util.Scanner;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.nio.channels.FileChannel;

public class RentalDemoAndCreateFile {
    public static void main(String[] args) {
        LessonWithRental[] rentals = new LessonWithRental[1];

        for (int x = 0; x < rentals.length; x++) {
            int totalTimeRented = SammysRentalPriceWithMethods.inputRentalTime();
            while (totalTimeRented < 60 || totalTimeRented > 7200) {
                System.out.println("Rental time must be between 60 and 7200, please try again.");
                totalTimeRented = SammysRentalPriceWithMethods.inputRentalTime();
            }
            String contractNumber = SammysRentalPriceWithMethods.inputContractNumber();
            String phoneNumber = SammysRentalPriceWithMethods.phoneNumber();
            int equipmentType = SammysRentalPriceWithMethods.inputEquipmentType();
            while (equipmentType < 0 || equipmentType >= 8) {
                System.out.println("Must be between 0 and 7.");
                equipmentType = SammysRentalPriceWithMethods.inputEquipmentType();
            }
            rentals[x] = new LessonWithRental(contractNumber, totalTimeRented, phoneNumber, equipmentType);
        }
        for (int y = 0; y < rentals.length; y++) {
            System.out.print(SammysRentalPriceWithMethods.getData(rentals[y]));
            rentals[y].getInstructor();
        }
        writeFile(rentals);
    }

    public static void writeFile(LessonWithRental[] r) {
        String s;
        String delimiter = ",";
        OutputStream outputStream;
        BufferedWriter writer;
        Path file = Paths
                .get("C:\\Users\\SeanWestbrook\\OneDrive\\Desktop\\WilmU\\Java2\\Westbrook_Sammy_12\\Rentals.java");

        try {
            outputStream = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            for (int i = 0; i < r.length; ++i) {
                Equipment e = r[i].getEquipment();
                s = r[i].getContractNumber() + delimiter + r[i].getHours() + delimiter + r[i].getMinutes() + delimiter
                        + e.getEquipmentType() + delimiter + e.getEquipmentName() + delimiter + r[i].getPrice()
                        + System.getProperty("line.separator");
                writer.write(s, 0, s.length());
            }
            writer.close();
        } catch (Exception x) {
            System.out.println("Message: " + x);
        }
    }
}
