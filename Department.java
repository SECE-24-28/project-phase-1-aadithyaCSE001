import java.io.*;

public class Department {
    private String deptCode;
    private String deptName;

    public Department(String deptCode, String deptName) {
        this.deptCode = deptCode;
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    
    public void savePerson(Person p) {
        try (FileWriter fw = new FileWriter(deptCode + ".txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
             pw.println(p.toString());
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}
