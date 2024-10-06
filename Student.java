package JsonStudentData;

public class Student {
    private int id;
    private String firstName;
    private String gender;
    private String email;
    private double gpa;

    public Student(int id, String firstName, String gender, String email, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.gender = gender;
        this.email = email;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

}
