package othersPackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Operator {

    Socket client = null;
    String s = "";
    String choiceS="";
    int choice=0;
    double choiceD=0.0;
    ObjectInputStream ib = null;
    ObjectOutputStream ob = null;

    public void menu()
    {
        Scanner cin = new Scanner (System.in);
        try {
            client = new Socket("localhost", 7921);

            ob = new ObjectOutputStream(client.getOutputStream());
            int marker = 0;
            ob.writeObject(marker);
            ob.flush();

            while(true)
            {
                ib = new ObjectInputStream(client.getInputStream());
                s = (String) ib.readObject();
                System.out.println(s);


                choice = cin.nextInt();
                ob = new ObjectOutputStream(client.getOutputStream());
                ob.writeObject(choice);
                ob.flush();

                if(choice==1)
                {
                    ib = new ObjectInputStream(client.getInputStream());
                    s = (String) ib.readObject();
                    System.out.println(s);
                    ob = new ObjectOutputStream(client.getOutputStream());
                    choiceS = cin.nextLine();
                    choiceS = cin.nextLine();
                    ob.writeObject(choiceS);
                    ob.flush();

                    ib = new ObjectInputStream(client.getInputStream());
                    s = (String) ib.readObject();
                    System.out.println(s);
                    ob = new ObjectOutputStream(client.getOutputStream());
                    choiceS = cin.nextLine();
                    ob.writeObject(choiceS);
                    ob.flush();

                    ib = new ObjectInputStream(client.getInputStream());
                    s = (String) ib.readObject();
                    System.out.println(s);
                    ob = new ObjectOutputStream(client.getOutputStream());
                    choiceS = cin.nextLine();
                    ob.writeObject(choiceS);
                    ob.flush();

                    ib = new ObjectInputStream(client.getInputStream());
                    s = (String) ib.readObject();
                    System.out.println(s);
                    ob = new ObjectOutputStream(client.getOutputStream());
                    choiceD = cin.nextDouble();
                    ob.writeObject(choiceD);
                    ob.flush();

                    ib = new ObjectInputStream(client.getInputStream());
                    s = (String) ib.readObject();
                    System.out.println(s);
                    ob = new ObjectOutputStream(client.getOutputStream());
                    choiceS = cin.nextLine();
                    choiceS = cin.nextLine();
                    ob.writeObject(choiceS);
                    ob.flush();

                    ib = new ObjectInputStream(client.getInputStream());
                    s = (String) ib.readObject();
                    System.out.println(s);

                }
                else if(choice==2)
                {
                    ib = new ObjectInputStream(client.getInputStream());
                    s = (String) ib.readObject();
                    System.out.println(s);
                    ob = new ObjectOutputStream(client.getOutputStream());
                    choiceS = cin.nextLine();
                    choiceS = cin.nextLine();
                    ob.writeObject(choiceS);
                    ob.flush();

                    ib = new ObjectInputStream(client.getInputStream());
                    s = (String) ib.readObject();
                    System.out.println(s);
                }
                else if(choice==3)
                    break;
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
