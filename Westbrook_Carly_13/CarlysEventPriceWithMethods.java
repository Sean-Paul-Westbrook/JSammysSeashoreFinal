import java.util.*;

import jdk.nashorn.internal.runtime.arrays.IntOrLongElements;

public class CarlysEventPriceWithMethods {
    public static void main(String[] args) {
        // empty - classwork
    }

    public static int entreeChoice() {
        Scanner inputDevice = new Scanner(System.in);
        boolean isEntreeOK = false;
        int entree = 0;
        while (!isEntreeOK) {
            try {
                isEntreeOK = true;
                System.out.println("Entree:");
                System.out.println("Type 0 for Ramen Noodles");
                System.out.println("Type 1 for Steak");
                System.out.println("Type 2 for Chicken Tacos");
                entree = inputDevice.nextInt();
            } catch (InputMismatchException e) {
                isEntreeOK = false;
                System.out.println("Please try again");
            }
            inputDevice.nextLine();
        }
        return entree;
    }

    public static int sideOneChoice() {
        Scanner inputDevice = new Scanner(System.in);
        boolean isSideOneOK = false;
        int sideOne = 0;
        while (!isSideOneOK) {
            try {
                isSideOneOK = true;
                System.out.println("Side One:");
                System.out.println("Type 0 for Sweet Potatoes");
                System.out.println("Type 1 for French Onion Soup");
                System.out.println("Type 2 for Side Salad");
                sideOne = inputDevice.nextInt();
            } catch (InputMismatchException e) {
                isSideOneOK = false;
                System.out.println("Please try again");
            }
            inputDevice.nextLine();
        }
        return sideOne;
    }

    public static int sideTwoChoice() {
        Scanner inputDevice = new Scanner(System.in);
        boolean isSideTwoOK = false;
        int sideTwo = 0;
        while (!isSideTwoOK) {
            try {
                isSideTwoOK = true;
                System.out.println("Side Two:");
                System.out.println("Type 0 for Sweet Potatoes");
                System.out.println("Type 1 for French Onion Soup");
                System.out.println("Type 2 for Side Salad");
                sideTwo = inputDevice.nextInt();
            } catch (InputMismatchException e) {
                isSideTwoOK = false;
                System.out.println("Please try again");
            }
            inputDevice.nextLine();
        }
        return sideTwo;
    }

    public static int dessertChoice() {
        Scanner inputDevice = new Scanner(System.in);
        boolean dessertOK = false;
        int dessert = 0;
        while (!dessertOK) {
            try {
                dessertOK = true;
                System.out.println("Dessert:");
                System.out.println("Type 0 for Strawberry Cake");
                System.out.println("Type 1 for Donuts");
                System.out.println("Type 2 for Rhubarb Pie");
                dessert = inputDevice.nextInt();
            } catch (InputMismatchException e) {
                dessertOK = false;
                System.out.println("Please try again");
            }
            inputDevice.nextLine();
        }
        return dessert;
    }

    public static int eventType() {
        Scanner inputDevice = new Scanner(System.in);
        boolean isTypeOK = false;
        int entry = 0;
        while (!isTypeOK) {
            try {
                isTypeOK = true;
                System.out.println("Type 0 for wedding");
                System.out.println("Type 1 for baptism");
                System.out.println("Type 2 for birthday");
                System.out.println("Type 3 for corporate");
                System.out.println("Type 4 for other");
                entry = inputDevice.nextInt();
            } catch (Exception e) {
                isTypeOK = false;
                System.out.println("Please try again");
            }
            inputDevice.nextLine();
        }
        return entry;
    }

    public static int numberOfGuests() {
        Scanner inputDevice = new Scanner(System.in);
        boolean isGuestsOk = false;
        int numberGuests = 0;
        while (!isGuestsOk) {
            isGuestsOk = true;
            try {
                System.out.print("Type number of guests attending: ");
                numberGuests = inputDevice.nextInt();
            } catch (Exception e) {
                isGuestsOk = false;
                System.out.println("Please enter a valid number");
            }
            inputDevice.nextLine();
        }
        return numberGuests;
    }

    public static String eNumber() {
        Scanner inputDeviceTwo = new Scanner(System.in);
        System.out.print("Type Event Number: ");
        String eNumber = inputDeviceTwo.nextLine();
        return eNumber;
    }

    public static String phoneNumber() {
        Scanner inputDeviceThree = new Scanner(System.in);
        System.out.print("Type Phone Number: ");
        String number = inputDeviceThree.nextLine();
        return number;
    }

    public static void companyMotto() {
        System.out.println("*************************************************");
        System.out.println("* Carly’s makes the food that makes it a party. *");
        System.out.println("*************************************************");
    }

    public static String getData(DinnerEvent e, int numberGuests, int type, int count) {
        Employee[] employees = new Employee[15];
        employees = e.getEmployees();
        companyMotto();
        System.out.println("Event Number: " + e.getENumber());
        System.out.println("Number of Guests: " + e.getGuests());
        System.out.println("Price Per Guest: $" + e.pricePerGuest());
        System.out.println("Price: $" + e.setGuests(numberGuests));
        System.out.println("Phone Number: " + e.getPhoneNumber());
        System.out.println(e.getEventType(type));
        System.out.println(e.isLargeEvent());
        System.out.println("Staff: ");
        for (int y = 0; y < count; y++) {
            System.out.println(employees[y].getJobTitle() + " --" + " Id Number: " + employees[y].getidNumber() + " --"
                    + " Name: " + employees[y].getFirstName() + " " + employees[y].getLastName() + " --"
                    + " Pay Rate: $" + employees[y].getPayRate());
        }
        return "";
    }

    public static String eventWar(Event one, Event two) {
        System.out.println("Battle of the Events");
        if (one.getGuests() > two.getGuests()) {
            System.out.println("Event " + one.getENumber() + " is larger with " + one.getGuests() + " guests.");
            System.out.println("Event " + two.getENumber() + " is smaller with " + two.getGuests() + " guests.");
            return "";
        } else {
            System.out.println("Event " + two.getENumber() + " is larger with " + two.getGuests() + " guests.");
            System.out.println("Event " + one.getENumber() + " is smaller with " + one.getGuests() + " guests.");
            return "";
        }
    }

}
