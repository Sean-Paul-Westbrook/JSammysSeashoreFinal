import java.util.Scanner;

public class LessonWithRentalDemo {
    public static void main(String[] args) {
        LessonWithRental[] rentals = new LessonWithRental[2];

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

        // sortProgram(rentals);
        // repeat(rentals);
    }

    // sorting methods

    // public static void sortProgram(Rental[] rentals) {
    // int sortType;
    // Scanner input = new Scanner(System.in);
    // boolean isSortOk = false;
    // while (!isSortOk) {
    // try {
    // isSortOk = true;
    // System.out.println(
    // "Sort Rentals in Ascending Order by Contract Number: Enter 1\tPrice:
    // Enter2\tEquipment Type: Enter 3");
    // sortType = input.nextInt();
    // while (sortType > 3 || sortType <= 0) {
    // System.out.println("Please try again");
    // System.out.println(
    // "Sort Rentals in Ascending Order by: Contract Number: Enter
    // 1\tPrice:Enter2\tEquipment Type: Enter 3");
    // sortType = input.nextInt();
    // }
    // if (sortType == 1)
    // sortByRentalNumber(rentals);
    // else if (sortType == 2)
    // sortByPrice(rentals);
    // else if (sortType == 3)
    // sortByEquipmentType(rentals);
    // } catch (Exception e) {
    // isSortOk = false;
    // }
    // input.nextLine();
    // }
    // }

    // public static void sortByRentalNumber(Rental[] rentals) {
    // int a, b;
    // Rental temp;
    // int rentalLength = rentals.length - 1;
    // for (a = 0; a < rentalLength; ++a)
    // for (b = 0; b < rentalLength; ++b)
    // if (rentals[b].getContractNumber().compareTo(rentals[b +
    // 1].getContractNumber()) > 0) {
    // temp = rentals[b];
    // rentals[b] = rentals[b + 1];
    // rentals[b + 1] = temp;
    // }
    // for (int i = 0; i < rentals.length; i++) {
    // System.out.println("Rental: " + rentals[i].getContractNumber());
    // }
    // }

    // public static void sortByPrice(Rental[] rentals) {
    // int a, b;
    // Rental temp;
    // int rentalLength = rentals.length - 1;
    // for (a = 0; a < rentalLength; ++a)
    // for (b = 0; b < rentalLength; ++b)
    // if (rentals[b].getPrice() > rentals[b + 1].getPrice()) {
    // temp = rentals[b];
    // rentals[b] = rentals[b + 1];
    // rentals[b + 1] = temp;
    // }
    // for (int i = 0; i < rentals.length; i++) {
    // System.out.println("Rental " + rentals[i].getContractNumber() + ": $" +
    // rentals[i].getPrice());
    // }
    // }

    // public static void sortByEquipmentType(Rental[] rentals) {
    // String[] equipment = { "personal watercraft", "pontoon boat", "rowboat",
    // "canoe", "kayak", "beach chair",
    // "umbrella", "other" };
    // int a, b;
    // Rental temp;
    // int iteration = rentals.length - 1;
    // for (a = 0; a < iteration; ++a)
    // for (b = 0; b < iteration; ++b)
    // if (equipment[rentals[b].getEquipmentType()].charAt(0) > equipment[rentals[b
    // + 1].getEquipmentType()]
    // .charAt(0)) {
    // temp = rentals[b];
    // rentals[b] = rentals[b + 1];
    // rentals[b + 1] = temp;
    // }
    // for (int i = 0; i < rentals.length; i++) {
    // System.out.println("Rental: " + rentals[i].getContractNumber());
    // System.out.println(rentals[i].getEquipmentName());
    // // rentals[i].getEquipment(rentals[i].getEquipmentType())
    // }
    // }

    // public static void repeat(Rental[] rentals) {
    // Scanner input2 = new Scanner(System.in);
    // System.out.print("Satisfied? Y for Yes\tN for No");
    // System.out.println();
    // char repeat = input2.next().charAt(0);
    // String toString = Character.toString(repeat);
    // if (toString.equals("Y")) {
    // System.out.println("Sweet, bye bye");
    // } else if (toString.equals("N")) {
    // sortProgram(rentals);
    // repeat(rentals);
    // } else {
    // System.out.println("Please type Y or N");
    // repeat(rentals);
    // }
    // }
}
