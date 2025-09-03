import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Person[] people = new Person[1000]; 
        int count = 0; 

        Department cs = new Department("CS01", "Computer Science");
        Department math = new Department("MA01", "Mathematics");
        count = loadData("CS01.txt", cs, people, count);
        count = loadData("MA01.txt", math, people, count);


        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Show All People");
            System.out.println("4. Show People by Department");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String sname = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int sage = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Roll No: ");
                    String roll = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Choose Department (1-CS, 2-Math): ");
                    int sdepChoice = sc.nextInt();
                    sc.nextLine();
                    Department sdept = (sdepChoice == 1) ? cs : math;

                    Student st = new Student(sname, sage, sdept, roll, course);
                    people[count++] = st;  
                    sdept.savePerson(st); 
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Enter Teacher Name: ");
                    String tname = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int tage = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Emp ID: ");
                    String emp = sc.nextLine();
                    System.out.print("Enter Subject: ");
                    String sub = sc.nextLine();

                    System.out.print("Choose Department (1-CS, 2-Math): ");
                    int tdepChoice = sc.nextInt();
                    sc.nextLine();
                    Department tdept = (tdepChoice == 1) ? cs : math;

                    Teacher th = new Teacher(tname, tage, tdept, emp, sub);
                    people[count++] = th; 
                    tdept.savePerson(th); 
                    System.out.println("Teacher added.");
                    break;

                case 3:
                    System.out.println("\n--- All People ---");
                    for (int i = 0; i < count; i++) {
                        people[i].displayInfo();
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.print("Enter Department Code (CS01 / MA01): ");
                    String code = sc.next();

                    System.out.println("\n--- People in Department " + code + " ---");
                    for (int i = 0; i < count; i++) {
                        if (people[i].getDept().getDeptCode().equals(code)) {
                            people[i].displayInfo();
                            System.out.println();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
       private static int loadData(String fileName, Department dept, Person[] people, int count) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals("Student")) {
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String roll = parts[4];
                    String course = parts[3];
                    people[count++] = new Student(name, age, dept, roll, course);
                } else if (parts[0].equals("Teacher")) {
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String empId = parts[4];
                    String subject = parts[3];
                    people[count++] = new Teacher(name, age, dept, empId, subject);
                }
            }
            System.out.println("Loaded " + count + " people from files.");
        } catch (IOException e) {
          
        }
        return count;
    }
}
