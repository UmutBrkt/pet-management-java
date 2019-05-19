import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
public class PetRegistrationForm extends MyFrame implements WindowListener{
	Database data;
	public PetRegistrationForm() {
		setLayout(null); 
		add(new PanelInfo()).setBounds(10,10,300,250);
		add(new PanelBirthdate()).setBounds(10,260,300,80);
		add(new PanelSearch()).setBounds(320,20,300,30);
		add(new JScrollPane(new PanelTable())).setBounds(340,50,450,290);
		add(new PanelButtons()).setBounds(40, 340, 600, 30);
	
		addWindowListener(this);
		
		setMyFrame("Pet Registration Form", 800, 600, true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	public static void main(String[] args) {
		new PetRegistrationForm();
	}

	public void windowOpened(WindowEvent e) { }
	public void windowClosing(WindowEvent e) { 
		String records="";
		data=new Database("Pet.txt");
		for (int r = 0; r < PanelTable.model_pet.getRowCount(); r++) {
			for (int c = 0; c < PanelTable.model_pet.getColumnCount(); c++) {
				records+=PanelTable.model_pet.getValueAt(r, c)+"#";
			}
			//records;
		}
		data.storeToFile(records);
	}
	public void windowClosed(WindowEvent e) { }
	public void windowIconified(WindowEvent e) { }
	public void windowDeiconified(WindowEvent e) { }
	public void windowActivated(WindowEvent e) { }
	public void windowDeactivated(WindowEvent e) { }
}
