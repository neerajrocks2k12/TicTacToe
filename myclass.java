import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class myclass extends JFrame
{
	private JPanel panel,panel2;
	private JTextArea pane,mypane;
	private JScrollPane scroll1, scroll2;
	private JButton button;
	
	myclass()
	{
		panel=new JPanel();
		panel2=new JPanel();
		pane=new JTextArea(20,50);
		mypane=new JTextArea(8,50);
		pane.setForeground(Color.PINK);
		pane.setEditable(false);
		scroll1=new JScrollPane(pane);
		scroll2=new JScrollPane(mypane);
		button=new JButton("SEND");

		button.addActionListener(new myact());
		
		panel.add(scroll1);
		panel2.add(scroll2);
		panel2.add(button);
		panel.setBackground(new Color(95,31,84));
		panel2.setBackground(new Color(95,31,84));
		
		setLayout(new GridLayout(2,1,1,0));
		add(panel);
		add(panel2);
		
	}
	private class myact implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String str=mypane.getText();
			pane.append("YOU: "+str+"\n");
			mypane.setText(null);
			botreply(str.toLowerCase());
		}
	}
	
	private void botreply(String str)
	{
		if(str.equals(""))
			pane.append("BOT: "+"heyy say something na...are you sad? or not willing to talk??"+"\n");
		else if((str.equals("hi"))||(str.equals("hello"))||(str.equals("heya")))
			pane.append("BOT: "+"hi"+"\n");
		else if((str.equals("how are you?"))||(str.equals("howz u?"))||(str.equals("hows u?")))
			pane.append("BOT: "+"I am fine, what about you?"+"\n");
		else if((str.equals("am fine too"))||(str.equals("fine"))||(str.equals("fyn")))
			pane.append("BOT: "+" That's gud..."+"\n");
		else
			pane.append("BOT: "+"kuch nahi samjha mai :( "+"\n");
	}
	
	public static void main(String[] args)
	{
		myclass fr=new myclass();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(600,500);
		fr.setResizable(false);
		fr.setVisible(true);
	}
}