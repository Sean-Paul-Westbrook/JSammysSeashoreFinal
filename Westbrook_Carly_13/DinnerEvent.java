public class DinnerEvent extends Event {
    private int entree;
    private int sideOne;
    private int sideTwo;
    private int dessert;
    public final static String[] ENTREES = { "Ramen Noodles", "Steak", "Chicken Tacos" };
    public final static String[] SIDES = { "Sweet Potatoes", "French Onion Soup", "Side Salad" };
    public final static String[] DESSERTS = { "Strawberry Cake", "Donuts", "Rhubarb Pie" };
    static Employee[] employees = new Employee[15];

    public DinnerEvent(String eventNumber, int numberGuests, String phoneNumber, int type, int entree, int sideOne,
            int sideTwo, int dessert) {
        super(eventNumber, numberGuests, phoneNumber, type);
        this.entree = entree;
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.dessert = dessert;
    }

    public void setEmployees(Employee[] staff) {
        employees = staff;
    }

    public static Employee[] getEmployees() {
        return employees;
    }

    public void setEntree(int entree) {
        this.entree = entree;
    }

    public void setSideOne(int sideOne) {
        this.sideOne = sideOne;
    }

    public void setSideTwo(int sideTwo) {
        this.sideTwo = sideTwo;
    }

    public void setDessert(int dessert) {
        this.dessert = dessert;
    }

    public int getEntree() {
        return entree;
    }

    public int getSideOne() {
        return sideOne;
    }

    public int getSideTwo() {
        return sideTwo;
    }

    public int getDessert() {
        return dessert;
    }

    public void getMenu() {
        for (int i = 0; i < ENTREES.length; i++) {
            if (getEntree() == i) {
                System.out.println("Entree: " + ENTREES[i]);
            }
        }
        for (int j = 0; j < SIDES.length; j++) {
            if (getSideOne() == j) {
                System.out.println("Side One: " + SIDES[j]);
            }
            if (getSideTwo() == j) {
                System.out.println("Side Two: " + SIDES[j]);
            }
        }
        for (int m = 0; m < DESSERTS.length; m++) {
            if (getDessert() == m) {
                System.out.println("Dessert: " + DESSERTS[m]);
            }
        }
    }

}