public abstract class Equipment {
    private int equipmentType;
    private String equipmentName;
    protected int fee;
    public static final String[] equipTypes = { "personal watercraft", "pontoon boat", "rowboat", "canoe", "kayak",
            "beach chair", "umbrella", "other" };
    public static final int[] FEES = { 50, 40, 15, 12, 10, 2, 1, 0 };
    public final static int HIGH = 4;

    public abstract String lessonPolicy();

    public Equipment(int type) {
        if (type < equipTypes.length) {
            equipmentType = type;
        } else {
            equipmentType = equipTypes.length - 1;
        }
    }

    public int getEquipmentType() {
        return equipmentType;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public int getFee() {
        return fee;
    }

    protected void setEquipmentName() {
        equipmentName = equipTypes[equipmentType];
    }

    protected void setFee() {
        fee = FEES[equipmentType];
    }

    protected void setEquipmentType(int equipmentType) {
        this.equipmentType = equipmentType;
    }
}