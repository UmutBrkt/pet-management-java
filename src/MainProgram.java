import java.awt.*;
import javax.swing.*;
public class MainProgram extends MyFrame{
	ImageIcon icon;
	JLabel back;
	public MainProgram() { 	
		icon=new ImageIcon("IMAGES/123.jpg");
		back=new JLabel("",icon,0);
	}
	public void setUI(){
		setJMenuBar(new MyMenu());
		add(new MyToolbar(),BorderLayout.NORTH);
		//add(new PanelChange(), BorderLayout.CENTER);
		
		add(new MyTab(), BorderLayout.CENTER);
		//add(new PanelInfo(),BorderLayout.WEST);
		//add(new PanelButtons(),BorderLayout.SOUTH);
		setTitle("Main Program");
		setExtendedState(MAXIMIZED_BOTH);
		//setUndecorated(true);
		getContentPane().setBackground(new Color(0, 90, 250, 90));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		MainProgram mp=new MainProgram();
		mp.setUI();
		mp.setVisible(true);
	}

}
