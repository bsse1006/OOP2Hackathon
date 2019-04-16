package package1;


import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private String momName;
    private String fName;
    private String roll;
    private String username;
    private String password;
    //private BankAccount acc;
    private boolean isAdmin;

    public Student ()
    {

    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Student(String name, String momName, String fName, String roll, String username, String password, boolean isAdmin) {
        this.name = name;
        this.momName = momName;
        this.fName = fName;
        this.roll = roll;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMomName() {
        return momName;
    }

    public void setMomName(String momName) {
        this.momName = momName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
