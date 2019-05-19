import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelButtons extends JPanel{
	static JButton btnAdd, btnClear, btnUpdate, btnDelete, btnClose;
	Listener listen=new Listener();
	
	public PanelButtons() {
		
		btnAdd=new JButton("Add New");
		btnClear=new JButton("Clear");
		btnUpdate=new JButton("Update");
		btnDelete=new JButton("Delete");
		btnClose=new JButton("Close");
		setLayout(new GridLayout(1, 5, 4,2));
		add(btnAdd); add(btnClear);
		add(new JLabel(""));
		add(btnUpdate); add(btnDelete);
		add(btnClose);	
		btnDelete.addActionListener(listen);
		btnAdd.addActionListener(listen);
		btnUpdate.addActionListener(listen);
		btnClose.addActionListener(listen);
		btnClear.addActionListener(listen);		
	}
}
