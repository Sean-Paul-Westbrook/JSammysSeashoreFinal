public class Waitstaff extends Employee {

    public static final double waitstaffPayRate = 10.00;

    public void setJobTitle() {
        jobTitle = "waitstaff";
    }

    public void setPayRate(double pay) {
        if (pay > waitstaffPayRate) {
            payRate = waitstaffPayRate;
        } else {
            payRate = pay;
        }
    }
}