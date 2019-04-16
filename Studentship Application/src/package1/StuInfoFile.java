package package1;

import package1.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StuInfoFile
{

    private String filename = "src/package1/studentInfo";

    public void  writeToFile(ArrayList <Student> accounts)
    {
        FileOutputStream fout = null;
        ObjectOutputStream object_out_for_serializable = null;
        try
        {
            fout = new FileOutputStream(filename);
            object_out_for_serializable = new ObjectOutputStream(fout);

            object_out_for_serializable.writeObject(accounts);
            object_out_for_serializable.flush();

        }
        catch (FileNotFoundException ex)
        {
            System.out.println("FileOutputStream in " + ex.toString());
        }
        catch (IOException ex)
        {
            System.out.println("ObjectOutputStream in " + ex.toString());
        }
    }

    public ArrayList<Student> readFromFile()
    {
        ArrayList<Student> accounts = null;
        try
        {
            ObjectInputStream object_in_for_deserializable =
                    new ObjectInputStream(new FileInputStream(filename));

            accounts = (ArrayList<Student>) object_in_for_deserializable.readObject();

            object_in_for_deserializable.close();
        }
        catch (EOFException ex)
        {
            Logger.getLogger(StuInfoFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(StuInfoFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(StuInfoFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }

}
