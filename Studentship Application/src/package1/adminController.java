package package1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class adminController {

    @FXML
    private TextField txtName;

    @FXML private TextField txtRoll;

    @FXML private TextField txtFName;

    @FXML private TextField txtAccNum;

    @FXML private PasswordField txtAccPass;

    @FXML private Label txtStatus;

    @FXML
    private TextField txtMName;

    @FXML private AnchorPane rootPane;

    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;


    public void createEntry(ActionEvent actionEvent) throws IOException {

        Student tempStu = new Student(txtName.getText(),
                txtMName.getText(),txtFName.getText(),txtRoll.getText(),txtUsername.getText(),
                txtPassword.getText(),false);

        ArrayList<Student> students = null;

        StuInfoFile file = new StuInfoFile();

        students = file.readFromFile();

        students.add(tempStu);

        file.writeToFile(students);

    }
}
