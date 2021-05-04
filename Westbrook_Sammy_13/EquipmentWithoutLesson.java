public class EquipmentWithoutLesson extends Equipment {

    public EquipmentWithoutLesson(int equipmentType) {
        super(equipmentType);
        if (equipmentType > HIGH) {
            setEquipmentType(equipmentType);
        } else {
            setEquipmentType(equipTypes.length - 1);
        }
        setEquipmentName();
        setFee();

    }

    public String lessonPolicy() {
        return "This equipment does not require a lesson.";
    }
}