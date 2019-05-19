import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends MyFrame{
	JTextField txtUN=new JTextField(20);
	JPasswordField txtPass=new JPasswordField(20);
	JButton btnLogin=new JButton("Login");
	Database db=new Database();
	public Login() {
		db.setFilename("Account.txt");
		add(txtUN);
		add(txtPass);
		add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u, p;
				u=txtUN.getText();
				p=txtPass.getText();
				if(db.isFound(u, p)){
					JOptionPane.showMessageDialog(null, "Log-in Successful");
					new PetRegistrationForm();
				}else{
					JOptionPane.showMessageDialog(null, "Incorrect");
				}
			}
		});
		setLayout(new FlowLayout());
		setMyFrame("", 300, 100, true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Login();
	}
}
