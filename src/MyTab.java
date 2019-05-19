import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
public class MyTab extends JTabbedPane{
	JPanel panelAll;
	ImageIcon icon;
	public MyTab() {
		icon=new ImageIcon("IMAGES/456.png");
		add(new JLabel(icon));
		add("Tab2",new PanelInfo());
		add("Tab3",new PanelButtons());
		add("Tab4",new PanelTable());
		
		icon=new ImageIcon("IMAGES/1.png");
		setIconAt(0, icon);
		panelAll=new JPanel(new BorderLayout());
		panelAll.add(new PanelInfo(),BorderLayout.WEST);
		panelAll.add(new PanelButtons(),BorderLayout.SOUTH);
		panelAll.add(new PanelTable(),BorderLayout.CENTER);
		add("Tab5",panelAll);
	}
}
