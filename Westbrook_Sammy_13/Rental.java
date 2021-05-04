public class Rental {
    private String contractNumber;
    private String phoneNumber;
    private int totalTimeRented;
    private int hoursRented;
    private int minutesRented;
    private int price;
    private int basePrice;
    public static final int costPerHour = 40;
    public static final int costPerMinute = 1;
    private int equipmentType;
    Equipment equipment;

    public Rental() {
        this("Aooo", 0, "0000000000", "other");
    }

    public Rental(String contractNumber, int totalTimeRented, String phoneNumber, int equipmentType) {
        this.contractNumber = contractNumber;
        this.totalTimeRented = totalTimeRented;
        this.phoneNumber = phoneNumber;
        this.equipmentType = equipmentType;
        setContractNumber(contractNumber);
        setHoursAndMinutes(totalTimeRented);
        setPhoneNumber(phoneNumber);
        if (equipmentType <= Equipment.HIGH) {
            equipment = new EquipmentWithLesson(equipmentType);
            price = basePrice + equipment.getFee();
        } else {
            equipment = new EquipmentWithoutLesson(equipmentType);
            price = basePrice + equipment.getFee();
        }
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipmentType(int equip) {
        if (equip > equipment.length) {
            equip = 7;
        }
        equipmentType = equip;
    }

    public int getEquipmentType() {
        return equipmentType;
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

    public void setContractNumber(String cNum) {
        if (cNum.length() != 4) {
            cNum = "Aooo";
        } else {
            if (!Character.isLetter(cNum.charAt(0)) || !Character.isDigit(cNum.charAt(1))
                    || !Character.isDigit(cNum.charAt(2)) || !Character.isDigit(cNum.charAt(3))) {
                cNum = "Aooo";
            }
        }
        if (Character.isLowerCase(cNum.charAt(0))) {
            cNum = cNum.substring(0, 1).toUpperCase() + cNum.substring(1);
        }
        contractNumber = cNum;
    }

    public void setTotalTimeRented(int rented) {
        totalTimeRented = rented;
    }

    public void setHoursAndMinutes(int totalTimeRented) {
        this.totalTimeRented = totalTimeRented;
        this.hoursRented = totalTimeRented / 60;
        this.minutesRented = totalTimeRented % 60;
        // over 40 minutes counts as an additional hr
        if (minutesRented <= 40) {
            basePrice = (hoursRented * costPerHour) + (minutesRented * costPerMinute);
        } else {
            basePrice = (hoursRented * costPerHour) + costPerHour;
        }
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public int getTotalTimeRented() {
        return totalTimeRented;
    }

    public int getHours() {
        return hoursRented;
    }

    public int getMinutes() {
        return minutesRented;
    }

    public int getPrice() {
        return price;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getHourlyRate() {
        return costPerHour;
    }
}