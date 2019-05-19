import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelInfo extends JPanel implements ActionListener,MouseListener, KeyListener, ItemListener{
	JLabel lblID,lblName, lblType, lblGender,lblColor,lblBreed,lblPrice;
	static JTextField txtID, txtName,txtColor, txtPrice;
	static JComboBox cboGender, cboType,cboBreed;
	Font f=new Font("Arial", Font.BOLD, 16);

	Database db=new Database();
	
	public PanelInfo() {
		lblID=new JLabel("ID: ");
		lblName=new JLabel("Name: ");
		lblType=new JLabel("Type: ");
		lblGender=new JLabel("Gender: ");
		lblColor=new JLabel("Color: ");
		lblBreed=new JLabel("Breed: ");
		lblPrice=new JLabel("Price: ");
		
		txtID=new JTextField(20);
		txtID.setEditable(false);
		txtID.setText(PanelTable.getRowCount()+"");

		txtName=new JTextField(20);
		txtColor=new JTextField(20);
		txtPrice=new JTextField(20);
	
		Data d=new Data();
		cboGender=new JComboBox(d.Gender);
		
		db.setFilename("Type.txt");
		cboType=new JComboBox(db.fillToComboBox());
		cboType.addItemListener(this);
		
		db.setFilename("Breed.txt");
		cboBreed=new JComboBox();
		db.fillToComboBox(cboBreed);
		
		setBorder(BorderFactory.createTitledBorder(null,"Pet Registration Form",0,0,f));
		setLayout(new GridLayout(7, 2));
		setFont(f);
		add(lblID); add(txtID);
		add(lblName); add(txtName);
		add(lblType); add(cboType);
		add(lblGender); add(cboGender);
		add(lblColor); add(txtColor);
		add(lblBreed); add(cboBreed);
		add(lblPrice); add(txtPrice); 
		
		txtColor.addActionListener(this);
		txtColor.addMouseListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Color color=JColorChooser.showDialog(null, "Choose",Color.black);
		txtColor.setForeground(color);	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Color color=JColorChooser.showDialog(null, "Choose",Color.black);
		txtColor.setBackground(color);
		txtColor.setText("");
		//setBackground(color);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals(cboType)){
			String chosen=cboType.getSelectedItem().toString();
			if(chosen.equals("Add-New")){
				PetType type=new PetType();
				type.setUI();
			}
			
		}
		
	}
	
}
