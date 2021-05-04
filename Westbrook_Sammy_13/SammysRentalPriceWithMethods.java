import java.util.*;

public class SammysRentalPriceWithMethods {

    public static int inputEquipmentType() {
        Scanner inputDevice = new Scanner(System.in);
        boolean isTypeOk = false;
        int type = 7;
        while (!isTypeOk) {
            try {
                isTypeOk = true;
                System.out.println("0 for Personal Watercraft");
                System.out.println("1 for Pontoon Boat");
                System.out.println("2 for Rowboat");
                System.out.println("3 for Canoe");
                System.out.println("4 for Kayak");
                System.out.println("5 for Beach Chair");
                System.out.println("6 for Umbrella");
                System.out.println("7 for Other");
                type = inputDevice.nextInt();
            } catch (Exception e) {
                isTypeOk = false;
            }
            inputDevice.nextLine();
        }
        return type;
    }

    public static int inputRentalTime() {
        Scanner inputDevice = new Scanner(System.in);
        boolean isTimeOk = false;
        int totalTimeRented = 0;
        while (!isTimeOk) {
            try {
                isTimeOk = true;
                System.out.print("Number of minutes rented: ");
                totalTimeRented = inputDevice.nextInt();
            } catch (Exception e) {
                isTimeOk = false;
            }
            inputDevice.nextLine();
        }
        return totalTimeRented;
    }

    public static String inputContractNumber() {
        Scanner inputDevice = new Scanner(System.in);
        System.out.print("Contract Number: ");
        String contractNumber = inputDevice.nextLine();
        return contractNumber;
    }

    public static String phoneNumber() {
        Scanner inputDevice = new Scanner(System.in);
        System.out.print("Type Phone Number: ");
        String number = inputDevice.nextLine();
        return number;
    }

    public static void displayMotto() {
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        System.out.println("S Sammy’s makes it fun in the sun. S");
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
    }

    public static String getData(Rental r) {
        Equipment e = r.getEquipment();
        displayMotto();
        System.out.println("Contract Number: " + r.getContractNumber());
        System.out.println("Hourly Rate: $" + r.getHourlyRate());
        System.out.println("Rented for  " + r.getHours() + " hours and " + r.getMinutes() + " minutes.");
        System.out.println("Phone Number: " + r.getPhoneNumber());
        System.out.println("Equipment rented: " + e.getEquipmentName());
        System.out.println(e.lessonPolicy());
        System.out.println("The equipment fee with lesson: $" + e.getFee());
        System.out.println("Total price: $" + r.getPrice());
        return "";
    }

    public static void rentalBattle(Rental one, Rental two) {
        System.out.println("WHO RENTED LONGER?");
        if (one.getTotalTimeRented() > two.getTotalTimeRented()) {
            System.out.println("Rental " + one.getContractNumber() + " was rented longer: " + one.getHours()
                    + " hours and " + one.getMinutes() + " minutes.");
            System.out.println("Rental " + two.getContractNumber() + " was rented shorter: " + two.getHours()
                    + " hours and " + two.getMinutes() + " minutes.");
        } else {
            System.out.println("Rental " + two.getContractNumber() + " was rented longer: " + two.getHours()
                    + " hours and " + two.getMinutes() + " minutes.");
            System.out.println("Rental " + one.getContractNumber() + " was rented for: " + one.getHours()
                    + " hours and " + one.getMinutes() + " minutes.");
        }
    }
}