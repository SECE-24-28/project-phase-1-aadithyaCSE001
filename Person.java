public abstract class Person {
    private String name;
    private int age;
    private Department dept;   

    public Person(String name, int age, Department dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public Department getDept() { return dept; }

    public abstract void displayInfo();
}
