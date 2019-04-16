package package1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;

public class Controller
{

    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private AnchorPane rootPane;
    @FXML private CheckBox checkStu;
    @FXML private CheckBox checkAd;



    public void logIn(ActionEvent actionEvent) throws IOException {

        /*Student temp = new Student("asd","qwe","zxc","123","asd","asd",false);



        ArrayList<Student> students = new ArrayList<Student>();

        students.add(temp);

        StuInfoFile file = new StuInfoFile();

        file.writeToFile(students);*/

        ArrayList<Student> students = new ArrayList<Student>();

        StuInfoFile file = new StuInfoFile();

        students = file.readFromFile();

        for(Student s: students)
        {
            System.out.println(s.getUsername() + "\n" + s.getPassword() + "\n" + txtUsername + "\n" + txtPassword);
            if(s.getUsername().equals(txtUsername.getText())&&s.getPassword().equals(txtPassword.getText())
            &&checkStu.isSelected()&&!checkAd.isSelected()&&!s.isAdmin())
            {
                System.out.println("wth");
                Parent root = FXMLLoader.load(getClass().getResource("afterLogIn.fxml"));
                Scene scene = new Scene (root);
                Stage window = (Stage) rootPane.getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
            else if(txtUsername.getText().equals("admin")&&txtPassword.getText().equals("1234567")
                    &&!checkStu.isSelected()&&checkAd.isSelected())
            {
                Parent root = FXMLLoader.load(getClass().getResource("adminAfterLogIn.fxml"));
                Scene scene = new Scene (root);
                Stage window = (Stage) rootPane.getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
        }



    }
}
