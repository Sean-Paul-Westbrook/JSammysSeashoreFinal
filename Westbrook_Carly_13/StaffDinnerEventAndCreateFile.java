import java.util.*;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.nio.channels.FileChannel;

public class StaffDinnerEventAndCreateFile {
    public static void main(String[] args) {
        DinnerEvent[] events = new DinnerEvent[1];
        Employee[] employees = new Employee[15];
        int waiters;
        int bartenders;
        int count = 0;

        for (int i = 0; i < events.length; i++) {
            int numberGuests = CarlysEventPriceWithMethods.numberOfGuests();
            while (numberGuests < 5 || numberGuests > 100) {
                System.out.println("There must be atleast 5 guests and no more than 100.");
                System.out.println("Please try again: ");
                numberGuests = CarlysEventPriceWithMethods.numberOfGuests();
            }
            String eNumber = CarlysEventPriceWithMethods.eNumber();
            String phoneNumber = CarlysEventPriceWithMethods.phoneNumber();
            int type = CarlysEventPriceWithMethods.eventType();
            int entree = CarlysEventPriceWithMethods.entreeChoice();
            while (entree < 0 || entree > 2) {
                System.out.println("Please type a valid entry");
                entree = CarlysEventPriceWithMethods.entreeChoice();
            }
            int sideOne = CarlysEventPriceWithMethods.sideOneChoice();
            while (sideOne < 0 || sideOne > 2) {
                System.out.println("Please type a valid entry");
                sideOne = CarlysEventPriceWithMethods.sideOneChoice();
            }
            int sideTwo = CarlysEventPriceWithMethods.sideTwoChoice();
            while (sideTwo < 0 || sideTwo > 2) {
                System.out.println("Please type a valid entry");
                sideTwo = CarlysEventPriceWithMethods.sideTwoChoice();
            }
            int dessert = CarlysEventPriceWithMethods.dessertChoice();
            while (dessert < 0 || dessert > 2) {
                System.out.println("Please type a valid entry");
                dessert = CarlysEventPriceWithMethods.dessertChoice();
            }
            events[i] = new DinnerEvent(eNumber, numberGuests, phoneNumber, type, entree, sideOne, sideTwo, dessert);

            waiters = (numberGuests / 10) + 1;
            for (count = 0; count < waiters; ++count) {
                employees[count] = getWaitStaff();
            }

            bartenders = numberGuests / 25;
            for (; count < waiters + bartenders; ++count) {
                employees[count] = getBartender();
            }
            employees[count] = getCoordinator();
            events[i].setEmployees(employees);
            ++count;
            CarlysEventPriceWithMethods.getData(events[i], events[i].getGuests(), events[i].getType(), count);
            System.out.println("Menu");
            events[i].getMenu();
        }

        for (int j = 0; j < events.length; j++) {
            CarlysEventPriceWithMethods.getData(events[j], events[j].getGuests(), events[j].getType(), count);
            events[j].getMenu();
        }

        writeFile(events);
    }

    // write to a data file
    public static void writeFile(DinnerEvent[] event) {
        String string;
        String delimiter = ",";
        OutputStream outputStream;
        BufferedWriter writer;
        Path file = Paths
                .get("C:\\Users\\SeanWestbrook\\OneDrive\\Desktop\\WilmU\\Java2\\Westbrook_Carly_12\\Events.java");
        try {
            outputStream = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            for (int i = 0; i < event.length; i++) {
                string = event[i].getENumber() + delimiter + event[i].getType() + delimiter + event[i].getGuests()
                        + delimiter + event[i].getTotalPrice() + System.getProperty("line.separator");
                writer.write(string, 0, string.length());
                writer.close();
            }
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }

    }

    // Employee methods

    public static Waitstaff getWaitStaff() {
        Waitstaff waiter = new Waitstaff();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Waiter ID Number: ");
        String idNumber = input.nextLine();
        waiter.setidNumber(idNumber);
        System.out.println("Enter Waiter First Name: ");
        String firstName = input.nextLine();
        waiter.setFirstName(firstName);
        System.out.println("Enter Waiter Last Name: ");
        String lastName = input.nextLine();
        waiter.setLastName(lastName);
        // negatives
        boolean isWaiterPayOk = false;
        double pay = 10.00;
        while (!isWaiterPayOk || pay < 0) {
            try {
                isWaiterPayOk = true;
                System.out.println("Enter Waiter Pay Rate: ");
                pay = input.nextDouble();
            } catch (Exception e) {
                isWaiterPayOk = false;
            }
            input.nextLine();
        }
        waiter.setPayRate(pay);
        waiter.setJobTitle();
        return waiter;
    }

    public static Bartender getBartender() {
        Bartender bartender = new Bartender();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Bartender ID Number: ");
        String idNumber = input.nextLine();
        bartender.setidNumber(idNumber);
        System.out.println("Enter First Name: ");
        String firstName = input.nextLine();
        bartender.setFirstName(firstName);
        System.out.println("Enter Last Name: ");
        String lastName = input.nextLine();
        bartender.setLastName(lastName);
        boolean isBartenderPayOk = false;
        double pay = 25.00;
        while (!isBartenderPayOk || pay < 0) {
            try {
                isBartenderPayOk = true;
                System.out.println("Enter Bartender Pay Rate: ");
                pay = input.nextDouble();
            } catch (Exception e) {
                isBartenderPayOk = false;
            }
            input.nextLine();
        }
        bartender.setPayRate(pay);
        bartender.setJobTitle();
        return bartender;
    }

    public static Coordinator getCoordinator() {
        Coordinator coordinator = new Coordinator();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Coordinator ID Number: ");
        String idNumber = input.nextLine();
        coordinator.setidNumber(idNumber);
        System.out.println("Enter First Name: ");
        String firstName = input.nextLine();
        coordinator.setFirstName(firstName);
        System.out.println("Enter Last Name: ");
        String lastName = input.nextLine();
        coordinator.setLastName(lastName);

        boolean isCoordPayOk = false;
        double pay = 25.00;
        while (!isCoordPayOk || pay < 0) {
            try {
                isCoordPayOk = true;
                System.out.println("Enter Coordinator Pay Rate: ");
                pay = input.nextDouble();
            } catch (Exception e) {
                isCoordPayOk = false;
            }
            input.nextLine();
        }
        coordinator.setPayRate(pay);
        coordinator.setJobTitle();
        return coordinator;
    }
}