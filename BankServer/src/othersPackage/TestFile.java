package othersPackage;

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


public class TestFile 
{
	
	private String filename = "database.txt";
	
	public void  writeToFile(ArrayList <Account> accounts) 
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
	
	public ArrayList<Account> readFromFile() 
	{
		ArrayList<Account> accounts = null;
		try 
		{
            ObjectInputStream object_in_for_deserializable =
                    new ObjectInputStream(new FileInputStream(filename));
            
            accounts = (ArrayList<Account>) object_in_for_deserializable.readObject();
            
            object_in_for_deserializable.close();
        } 
		catch (EOFException ex) 
		{
            Logger.getLogger(TestFile.class.getName()).log(Level.SEVERE, null, ex);
        }
		catch (IOException ex) 
		{
            Logger.getLogger(TestFile.class.getName()).log(Level.SEVERE, null, ex);
        } 
		catch (ClassNotFoundException ex) 
		{
            Logger.getLogger(TestFile.class.getName()).log(Level.SEVERE, null, ex);
        }
		return accounts;
	}

}
