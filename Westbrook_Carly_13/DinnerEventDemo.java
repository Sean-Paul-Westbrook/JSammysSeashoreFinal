import java.util.*;

public class DinnerEventDemo {
    public static void main(String[] args) {
        DinnerEvent[] events = new DinnerEvent[2];
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
        sortProgram(events);
        repeat(events);
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
        // negatives
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

        // negatives
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

    // sorting methods
    public static void sortProgram(Event[] events) {
        boolean isOk = false;
        int sortType = 0;
        while (!isOk) {
            try {
                isOk = true;
                Scanner input = new Scanner(System.in);
                System.out.println(
                        "Sort Events in Ascending Order by: Event Number: Enter 1\tNumber Of Guests: Enter 2\tEvent Type: Enter 3");
                sortType = input.nextInt();
                while (sortType > 3 || sortType <= 0) {
                    System.out.println("Please try again");
                    System.out.println(
                            "Sort Events in Ascending Order by: Event Number: Enter 1\tNumber Of Guests:Enter 2\tEvent Type: Enter 3");
                    sortType = input.nextInt();
                }
                if (sortType == 1)
                    sortByEventNumber(events);
                else if (sortType == 2)
                    sortByGuests(events);
                else if (sortType == 3)
                    sortByEventType(events);

            } catch (Exception e) {
                isOk = false;
            }
        }
    }

    public static void sortByEventNumber(Event[] events) {
        int a, b;
        Event temp;
        int iteration = events.length - 1;
        for (a = 0; a < iteration; ++a)
            for (b = 0; b < iteration; ++b)
                if (events[b].getENumber().compareTo(events[b + 1].getENumber()) > 0) {
                    temp = events[b];
                    events[b] = events[b + 1];
                    events[b + 1] = temp;
                }
        for (int i = 0; i < events.length; i++) {
            System.out.println("Event: " + events[i].getENumber());
        }
    }

    public static void sortByGuests(Event[] events) {
        int a, b;
        Event temp;
        int iteration = events.length - 1;
        for (a = 0; a < iteration; ++a)
            for (b = 0; b < iteration; ++b)
                if (events[b].getGuests() > events[b + 1].getGuests()) {
                    temp = events[b];
                    events[b] = events[b + 1];
                    events[b + 1] = temp;
                }
        for (int i = 0; i < events.length; i++) {
            System.out.println("Event: " + events[i].getENumber() + " has " + events[i].getGuests() + " guests.");
        }
    }

    public static void sortByEventType(Event[] events) {
        String[] eventTypes = { "wedding", "baptism", "birthday", "corporate", "other" };
        int a, b;
        Event temp;
        int iteration = events.length - 1;
        for (a = 0; a < iteration; ++a)
            for (b = 0; b < iteration; ++b)
                if (eventTypes[events[b].getType()].charAt(0) > eventTypes[events[b + 1].getType()].charAt(0)) {
                    temp = events[b];
                    events[b] = events[b + 1];
                    events[b + 1] = temp;
                }
        for (int i = 0; i < events.length; i++) {
            System.out.println("Event: " + events[i].getENumber());
            System.out.println(events[i].getEventType(events[i].getType()));
        }
    }

    public static void repeat(Event[] events) {
        Scanner input2 = new Scanner(System.in);
        System.out.print("Satisfied? Y for Yes\tN for No");
        System.out.println();
        char repeat = input2.next().charAt(0);
        String thing = Character.toString(repeat);
        if (thing.equals("Y")) {
            System.out.println("Sweet, bye bye");
        } else if (thing.equals("N")) {
            sortProgram(events);
            repeat(events);
        } else {
            System.out.println("Please type Y or N");
            repeat(events);
        }
    }

}