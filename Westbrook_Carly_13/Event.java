public class Event {
    public static final int pricePerPersonLow = 32;
    public static final int pricePerPersonHigh = 35;
    private String eNumber;
    private String phoneNumber;
    private int numberGuests;
    private int totalPrice;
    private int eventType;
    final String[] eventTypes = { "wedding", "baptism", "birthday", "corporate", "other" };

    public Event() {
        this("Aooo", 0, "0000000000", "other");
    }

    public Event(String eNum, int numGuests, String phoneNumber, int type) {
        eNumber = eNum;
        numberGuests = numGuests;
        this.phoneNumber = phoneNumber;
        eventType = type;
        setENumber(eNumber);
        setGuests(numberGuests);
        setPhoneNumber(phoneNumber);
        setType(type);
    }

    public void setType(int type) {
        if (type > eventTypes.length) {
            type = 4;
        }
        eventType = type;
    }

    public int getType() {
        return eventType;
    }

    public String getEventType(int eventType) {
        for (int i = 0; i < eventTypes.length; i++) {
            if (eventType == i) {
                System.out.print("Event Type: " + eventTypes[i]);
            }
        }
        return " ";
    }

    public void setPhoneNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            number = number.replaceAll("\\D+", "");
        }
        if (number.length() != 10) {
            number = "0000000000";
        }
        phoneNumber = number;
    }

    public String getPhoneNumber() {
        return "(" + phoneNumber.substring(0, 3) + ")" + " " + phoneNumber.substring(3, 6) + "-"
                + phoneNumber.substring(6, 10);
    }

    public void setENumber(String eNumb) {
        if (eNumb.length() != 4) {
            eNumb = "Aooo";
        } else {
            if (!Character.isLetter(eNumb.charAt(0)) || !Character.isDigit(eNumb.charAt(1))
                    || !Character.isDigit(eNumb.charAt(2)) || !Character.isDigit(eNumb.charAt(3))) {
                eNumb = "Aooo";
            }
        }
        if (Character.isLowerCase(eNumb.charAt(0))) {
            eNumb = eNumb.substring(0, 1).toUpperCase() + eNumb.substring(1);
        }
        eNumber = eNumb;
    }

    public int setGuests(int numGuests) {
        numberGuests = numGuests;
        if (numberGuests >= 50) {
            totalPrice = numberGuests * pricePerPersonLow;
        } else {
            totalPrice = numberGuests * pricePerPersonHigh;
        }
        return totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getENumber() {
        return eNumber;
    }

    public int getGuests() {
        return numberGuests;
    }

    public boolean isLargeEvent() {
        if (numberGuests >= 50) {
            System.out.print("Large Event: ");
            return true;
        } else {
            System.out.print("Large Event: ");
            return false;
        }
    }

    public int pricePerGuest() {
        if (numberGuests >= 50) {
            return pricePerPersonLow;
        } else {
            return pricePerPersonHigh;
        }
    }

}