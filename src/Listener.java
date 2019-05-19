import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class Listener implements ActionListener, MouseListener{
	Vector values;
	String ID,Name,Gender,Month,Day,Year,Age,Color,Type,Breed,Price;
	Database data;
	public Listener() {
		values=new Vector();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(PanelButtons.btnAdd)){		
			PanelTable.model_pet.addRow(addNewRecord());
			PanelInfo.txtID.setText(PanelTable.getRowCount()+"");
			JOptionPane.showMessageDialog(null, "Pet's record are successfully added.");
		}else if(e.getSource().equals(PanelButtons.btnUpdate)){	
			int row=PanelTable.tbl_Pet.getSelectedRow();
			addNewRecord();
				for (int j = 1; j < PanelTable.model_pet.getColumnCount(); j++) { //column
					PanelTable.model_pet.setValueAt(values.get(j), row, j);
				}
			
		}else if(e.getSource().equals(PanelButtons.btnDelete)){	
			int row=PanelTable.tbl_Pet.getSelectedRow();
			PanelTable.model_pet.removeRow(row);
			//NOTE: Delete is NOT encourage in Transactional Processing System
		}else if(e.getSource().equals(PanelButtons.btnClose)){
			data=new Database("Pet.txt");
			String records="";
			for (int r = 0; r < PanelTable.model_pet.getRowCount(); r++) {
				for (int c = 0; c < PanelTable.model_pet.getColumnCount(); c++) {
					records+=PanelTable.model_pet.getValueAt(r, c)+"#";
				}
				records+="\n";
			}
			data.storeToFile(records);
			System.exit(0);
		}
	}
	public Vector addNewRecord(){
		values=new Vector();
		values.add(PanelInfo.txtID.getText());
		values.add(PanelInfo.txtName.getText());
		values.add(PanelInfo.cboGender.getSelectedItem());
		values.add(PanelBirthdate.cboMonth.getSelectedItem());
		values.add(PanelBirthdate.cboDay.getSelectedItem());
		values.add(PanelBirthdate.cboYear.getSelectedItem());
		values.add(PanelBirthdate.txtAge.getText());
		values.add(PanelInfo.txtColor.getText());
		values.add(PanelInfo.cboType.getSelectedItem());
		values.add(PanelInfo.cboBreed.getSelectedItem());
		values.add(PanelInfo.txtPrice.getText());
		return values; 
	}
	public void getValues(){ //Sa karun wala siyay use
		ID=PanelInfo.txtID.getText();
		Name=PanelInfo.txtName.getText();
		Gender=PanelInfo.cboGender.getSelectedItem()+"";
		Month=PanelBirthdate.cboMonth.getSelectedItem()+"";
		Day=PanelBirthdate.cboDay.getSelectedItem()+"";
		Year=PanelBirthdate.cboYear.getSelectedItem()+"";
		Age=PanelBirthdate.txtAge.getText();
		Color=PanelInfo.txtColor.getText();
		Type=PanelInfo.cboType.getSelectedItem()+"";
		Breed=PanelInfo.cboBreed.getSelectedItem()+"";;
		Price=PanelInfo.txtPrice.getText();
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(PanelTable.tbl_Pet)){
			int row=PanelTable.tbl_Pet.getSelectedRow();	
			PanelInfo.txtID.setText(PanelTable.model_pet.getValueAt(row,0)+"");
			PanelInfo.txtName.setText(PanelTable.model_pet.getValueAt(row,1)+"");
			PanelInfo.cboGender.setSelectedItem(PanelTable.model_pet.getValueAt(row,2)+"");
			PanelBirthdate.cboMonth.setSelectedItem(PanelTable.model_pet.getValueAt(row,3)+"");
			PanelBirthdate.cboDay.setSelectedItem(PanelTable.model_pet.getValueAt(row,4)+"");
			PanelBirthdate.cboYear.setSelectedItem(PanelTable.model_pet.getValueAt(row,5)+"");
			PanelBirthdate.txtAge.setText(PanelTable.model_pet.getValueAt(row,6)+"");
			PanelInfo.txtColor.setText(PanelTable.model_pet.getValueAt(row,7)+"");
			PanelInfo.cboType.setSelectedItem(PanelTable.model_pet.getValueAt(row,8)+"");
			PanelInfo.cboBreed.setSelectedItem(PanelTable.model_pet.getValueAt(row,9)+"");
			PanelInfo.txtPrice.setText(PanelTable.model_pet.getValueAt(row,10)+"");
		}if(e.getSource().equals(PanelInfo.txtColor)){
			//Color color=JColorChooser.showDialog(null, "Choose",Color.black);
			//PanelInfo.txtColor.setBackground(color);
		}
	}
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	
}
