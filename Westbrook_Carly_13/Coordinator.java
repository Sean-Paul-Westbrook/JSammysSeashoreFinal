public class Coordinator extends Employee {
    public static final double coordinatorPayRate = 20.00;

    public void setJobTitle() {
        jobTitle = "coordinator";
    }

    public void setPayRate(double pay) {
        if (pay > coordinatorPayRate) {
            payRate = coordinatorPayRate;
        } else {
            payRate = pay;
        }
    }
}