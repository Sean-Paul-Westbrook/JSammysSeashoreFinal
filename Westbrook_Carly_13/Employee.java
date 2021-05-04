public abstract class Employee {
    private String idNumber;
    private String lastName;
    private String firstName;
    protected String jobTitle;
    protected double payRate;

    public abstract void setJobTitle();

    public abstract void setPayRate(double payRate);

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setidNumber(String id) {
        idNumber = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getidNumber() {
        return idNumber;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getPayRate() {
        return payRate;
    }
}