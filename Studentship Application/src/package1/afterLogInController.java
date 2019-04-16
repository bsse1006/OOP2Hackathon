package package1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class afterLogInController {


    @FXML private TextField txtName;

    @FXML private TextField txtRoll;

    @FXML private TextField txtFName;

    @FXML private TextField txtAccNum;

    @FXML private PasswordField txtAccPass;

    @FXML private Label txtStatus;

    @FXML
    private TextField txtMName;

    @FXML private AnchorPane rootPane;

    public void submitApplication (ActionEvent actionEvent) throws IOException, ClassNotFoundException {


        ArrayList<Student> students = null;

        StuInfoFile file = new StuInfoFile();

        students = file.readFromFile();

        for(Student s: students) {
            if (s.getName().equals(txtName.getText()) && s.getMomName().equals(txtMName.getText()) &&
                    s.getfName().equals(txtFName.getText()) && s.getRoll().equals(txtRoll.getText())) {

                ObjectInputStream ib = null;
                ObjectOutputStream ob = null;

                Socket client = null;

                client = new Socket("localhost", 7921);

                ob = new ObjectOutputStream(client.getOutputStream());
                int marker = 0;
                ob.writeObject(marker);
                ob.flush();

                ob = new ObjectOutputStream(client.getOutputStream());
                ob.writeObject(txtAccNum.getText());
                ob.flush();

                ob = new ObjectOutputStream(client.getOutputStream());
                ob.writeObject(txtAccPass.getText());
                ob.flush();

                ib = new ObjectInputStream(client.getInputStream());
                int status = (Integer) ib.readObject();

                if(status==1)
                {
                    String certificate
                            = txtName.getText() + ", son of " + txtFName.getText()
                            + " and " + txtMName.getText() + " is a student of IIT.\nHis academic records " +
                            "are satisfactory and he has not been involved in any criminal activity.\n";

                    BufferedWriter bw = null;
                    FileWriter fw = null;

                    fw = new FileWriter("certificate.txt");


                    bw = new BufferedWriter(fw);
                    bw.flush();

                    bw.write(certificate);


                    if (bw != null)
                        bw.close();

                    if (fw != null)
                        fw.close();


                    txtStatus.setText("Certificate is delivered!\n");
                }

                /*Parent root = FXMLLoader.load(getClass().getResource("afterLogIn.fxml"));
                Scene scene = new Scene(root);
                Stage window = (Stage) rootPane.getScene().getWindow();
                window.setScene(scene);
                window.show();*/

            }
            else {

            }

        }

        /*Parent root = FXMLLoader.load(getClass().getResource("afterLogIn.fxml"));
        Scene scene = new Scene (root);
        Stage window = (Stage) rootPane.getScene().getWindow();
        window.setScene(scene);
        window.show();*/
    }

}
