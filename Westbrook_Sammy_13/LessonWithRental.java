public class LessonWithRental extends Rental {
    private boolean isRequired = false;
    final String[] instructors = { "Joey", "Pacey", "Dawson", "Jen", "Cory", "Topanga", "Shawn", "Feeny" };
    public static final String[] equipTypes = { "personal watercraft", "pontoon boat", "rowboat", "canoe", "kayak",
            "beach chair", "umbrella", "other" };

    public LessonWithRental(String contractNumber, int totalTimeRented, String phoneNumber, int equipmentType) {
        super(contractNumber, totalTimeRented, phoneNumber, equipmentType);
        if (equipmentType == 0 || equipmentType == 1) {
            isRequired = true;
        }
    }

    public void getInstructor() {
        System.out.println("Lesson required:  " + isTrue());
        for (int i = 0; i < equipTypes.length; i++) {
            if (i == getEquipmentType()) {
                System.out.println("Lesson instructor: " + instructors[i]);
            }
        }
    }

    public String isTrue() {
        if (isRequired) {
            return "Yes";
        } else {
            return "No";
        }
    }
}