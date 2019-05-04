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

    @FXML private TextField txtMName;

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
                int marker = 1;
                ob.writeObject(marker);
                ob.flush();

                ob = new ObjectOutputStream(client.getOutputStream());
                ob.writeObject(txtAccNum.getText());
                ob.flush();

                ob = new ObjectOutputStream(client.getOutputStream());
                ob.writeObject(txtAccPass.getText());
                ob.flush();

                ib = new ObjectInputStream(client.getInputStream());
                int status = -1;
                status = (Integer) ib.readObject();


                if(status==1)
                {
                    String indent = "                                                     ";
                    int nameSize = txtName.getText().length();
                    int fNameSize = txtFName.getText().length();
                    int mNameSize = txtMName.getText().length();
                    int fmSize = fNameSize + mNameSize + 5 + 8;
                    int rSize = txtRoll.getText().length() + 5;

                    String certificate
                            = indent.substring(9) + "STUDENT CERTIFICATE" + indent.substring(9) +
                            System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
                            + indent.substring(9) + "This certifies that" + indent.substring(9) +
                            System.lineSeparator() + System.lineSeparator()
                            + indent.substring(nameSize/2) + txtName.getText() + indent.substring(nameSize/2) +
                            System.lineSeparator()
                            + indent.substring(rSize/2) + "roll " + txtRoll.getText() + indent.substring(rSize/2) +
                            System.lineSeparator()
                            + indent.substring(fmSize/2) + "child of " + txtFName.getText() + " and " + txtMName.getText() + indent.substring(fmSize/2) +
                            System.lineSeparator()
                            + indent.substring(24) + "is a regular student of IIT, University of Dhaka." + indent.substring(24) +
                            System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
                            + indent.substring(4) + "Director" + indent.substring(4) +
                            System.lineSeparator() +
                            indent.substring(12) + "IIT, University of Dhaka" + indent.substring(12);



                    BufferedWriter bw = null;
                    FileWriter fw = null;

                    fw = new FileWriter("certificate.txt");

                    bw = new BufferedWriter(fw);

                    bw.write(certificate);

                    bw.flush();


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
        }

        /*Parent root = FXMLLoader.load(getClass().getResource("afterLogIn.fxml"));
        Scene scene = new Scene (root);
        Stage window = (Stage) rootPane.getScene().getWindow();
        window.setScene(scene);
        window.show();*/
    }

}
