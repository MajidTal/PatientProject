package patientsrc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class PatientInfo implements Serializable {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Patient pa = new Patient();

		boolean condation = true ;
		
		while(condation)
		{
			System.out.println("select 1 for serlization ");
			System.out.println("select 2 for de-serlization");
			System.out.println("select 3 for Exit ");
         int select = sc.nextInt();
		if(select == 1)
		{
		System.out.println("(Welcome to our site)");
		System.out.println("\nPlease Enter your name:");
		pa.setName(sc.next());
		System.out.println("Enter your id please:");
		pa.setId(sc.nextInt());
		System.out.println("Enter your age please:");
		pa.setAge(sc.nextInt());
		System.out.println("Enter your phone number please:");
		pa.setPhone(sc.nextInt());

		try {
			FileOutputStream file = new FileOutputStream("Patient.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(pa);
			out.close();
			file.close();
			System.out.println("serialized and saved");
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		else if(select == 2)
		{
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream("Patient.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			// Method for deserialization of object
			Patient ob = (Patient) in.readObject();
			in.close();
			file.close();
			System.out.println("Object has been deserialized ");
			System.out.println("The Patient Name is:  " + ob.getName());
			System.out.println("The Patient ID is:  " + ob.getId());
			System.out.println("The Patient age is:  " + ob.getAge());
			System.out.println("The Patient phone number is:  " + ob.getPhone());
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
		}
		
		else if(select == 3)
		{
			condation = false ;
			System.out.println("thanks!!!!!");
		}
	}

	}

}
