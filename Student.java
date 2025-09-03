public class Student extends Person {
    private String rollNo;
    private String course;

    public Student(String name, int age, Department dept, String rollNo, String course) {
        super(name, age, dept);   
        this.rollNo = rollNo;
        this.course = course;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Department: " + getDept().getDeptName());
        System.out.println("Roll No: " + rollNo);
        System.out.println("Course: " + course);
    }

    @Override
    public String toString() {
        return "Student," + getName() + "," + getAge() + "," +
               getDept().getDeptCode() + "," + rollNo + "," + course;
    }
}
