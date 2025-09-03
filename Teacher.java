public class Teacher extends Person {
    private String empId;
    private String subject;

    public Teacher(String name, int age, Department dept, String empId, String subject) {
        super(name, age, dept);         
        this.empId = empId;
        this.subject = subject;
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Department: " + getDept().getDeptName());
        System.out.println("Emp ID: " + empId);
        System.out.println("Subject: " + subject);
    }

    @Override
    public String toString() {
        return "Teacher," + getName() + "," + getAge() + "," +
               getDept().getDeptCode() + "," + empId + "," + subject;
    }
}
