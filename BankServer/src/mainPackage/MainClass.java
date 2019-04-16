package mainPackage;

import othersPackage.Operator;
import othersPackage.TestFile;

import java.io.IOException;

public class MainClass 
{

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		TestFile f;
		f = new TestFile();
		Operator op = null;
		try {
			op = new Operator();
		} catch (IOException e) {
			e.printStackTrace();
		}
		op.setAccounts(f.readFromFile());
		op.Menu();
		f.writeToFile(op.getAccounts());
		
	}

}
