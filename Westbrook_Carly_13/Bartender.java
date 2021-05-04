public class Bartender extends Employee {
    public static final double bartenderPayRate = 14.00;

    public void setJobTitle() {
        jobTitle = "bartender";
    }

    public void setPayRate(double pay) {
        if (pay > bartenderPayRate) {
            payRate = bartenderPayRate;
        } else {
            payRate = pay;
        }
    }
}