public class EquipmentWithLesson extends Equipment {

    public static final int LESSON_FEE = 27;
    double tempFee;

    public EquipmentWithLesson(int equipmentType) {
        super(equipmentType);
        if (equipmentType <= HIGH) {
            setEquipmentType(equipmentType);
        } else {
            setEquipmentType(equipTypes.length - 1);
        }
        setEquipmentName();
        setFee();
        tempFee = fee;
        fee += LESSON_FEE;

    }

    public String lessonPolicy() {
        return "This equipment requires a $" + LESSON_FEE + " lesson.";
    }
}