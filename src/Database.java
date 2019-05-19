import java.io.*;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Database {
	File file=null;
	FileWriter fWrite=null;
	FileReader fRead=null;
	Scanner scan=null;
	String message="";
	Vector row, column;
	
	StringTokenizer strToken;
	
	public Database() { } //default constructor
	public Database(String filename) { //parameterized constructor w/c sets the filename of a textfile
		file=new File(filename);
	}
	public void setFilename(String filename) { //another option foe setting a filename
		file=new File(filename);
	}
	public String getFilename() { //when you want to read or get the name of the file
		return file.getName();
	}
	public void storeToFile(String records){ //Store information to a file
		try {
			fWrite=new FileWriter(file);
			fWrite.write(records);
			fWrite.flush();
		} catch (Exception e) {
			errorMessage("Error 101: storeToFile\n"+e.getMessage());
		}
	}//end of storetofile
	
	public String readRecordsFromTextFile(){
		String original="";
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);		
			while(scan.hasNext()){
				original+=scan.nextLine()+"\n"; //reads the information per line -from a textfile
			}
			fRead.close();
			scan.close();
		} catch (Exception e) {
			errorMessage("Error 104: getStringTokenizer\n"+e.getMessage());
		}
		return original;
	}
	
	public void displayRecords(DefaultTableModel model){
		try {		
			//Extracting the information via #
			strToken=new StringTokenizer(readRecordsFromTextFile(), "#"); //read String from original, then separate each datum by #			
			while(strToken.hasMoreTokens()){
				row=new Vector();
				for (int i = 0; i < model.getColumnCount(); i++) {
					row.add(strToken.nextToken()); 
					//read each record based on column count of a  table-store to a vector
				}
				model.addRow(row);
			}
		} catch (Exception e) {
			errorMessage("Error 102: displayRecords\n"+e.getMessage());
		}
	}// end of display records
	
	
	public void setColumn(DefaultTableModel model){
		try {
			column=new Vector();
			fRead=new FileReader(file);
			scan=new Scanner(fRead);
			while(scan.hasNext()){
				column.add(scan.nextLine());
			}
			model.setColumnIdentifiers(column);
			fRead.close();
			scan.close();
			
		} catch (Exception e) {
			errorMessage("Error 103: setColumns\n"+e.getMessage());
		}
	}	
	public int recordCount(){
		int i=0;
		try {
			fRead=new FileReader(file);
			scan=new Scanner(fRead);		
			while(scan.hasNext()){
				scan.nextLine();
				i++;
			}
			fRead.close();
			scan.close();
		} catch (Exception e) {
			errorMessage("Error 105: recordcount\n"+e.getMessage());
		}
		return i;
	}
	public void fillToComboBox(JComboBox combo){
		try {
			strToken=new StringTokenizer(readRecordsFromTextFile(), "#"); //read String from original, then separate each datum by #			
			while(strToken.hasMoreTokens()){
				combo.addItem(strToken.nextToken()); 
			}
		} catch (Exception e) {
			errorMessage("Error 106: fillToCOmboBox\n"+e.getMessage());
		}
	}
	public void errorMessage(String msg){ //universal error message
		System.err.println(msg);
	}
	
	public Vector fillToComboBox(){
		try {
			column=new Vector();
			fRead=new FileReader(file);
			scan=new Scanner(fRead);
			strToken=new StringTokenizer(readRecordsFromTextFile(), "#"); //read String from original, then separate each datum by #			
			while(strToken.hasMoreTokens()){
				column.add(strToken.nextToken()); 
			}
			fRead.close();
			scan.close();
		} catch (Exception e) {
			System.err.println("Error 103: setColumn \n"+e.getMessage());
		}
		return column;
	}//end of fillToComboBox
	
	public boolean isFound(String username, String password){
		boolean f=false;
		try {
			String un="", pwd="";
			fRead=new FileReader(file);
			scan=new Scanner(fRead);
			while(scan.hasNext()){
				un=scan.next();
				pwd=scan.next();
				if(un.equals(username) && pwd.equals(password)){
					f=true;
				}	
			}
			fRead.close();
			scan.close();
		} catch (Exception e) {
			System.err.println("Error 105: isFound \n"+e.getMessage());
		}
		return f;
	}//end of fillToComboBox

}

