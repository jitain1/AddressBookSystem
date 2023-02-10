package com.bridgelabz;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {
	
	public static void writeIntoFile(String adBookName, AddressBook addressBook) {

        try {
        	FileWriter filewriter = new FileWriter("D:\\Eclipse\\eclipse\\Address_Book_System\\src\\Resources\\ContactList.txt");
            
            for (Contact contact: addressBook.allContacts) {
            	String data = "";
                data += contact.toString();
                filewriter.write(data);
            }
            filewriter.close();
            
            System.out.println("Data stored in file");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFromFile(){
        Path path = Paths.get("D:\\\\Eclipse\\\\eclipse\\\\Address_Book_System\\\\src\\\\Resources\\\\ContactList.txt");
        try {
            System.out.println(Files.readAllLines(path));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
