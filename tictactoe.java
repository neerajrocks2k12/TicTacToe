import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class tictactoe extends JPanel
{
	private JButton button[];
	private static int index[];
	private static JButton result, start,exit,refresh;
	
	public tictactoe()
	{
		String plaf = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
		try
		{
		UIManager.setLookAndFeel(plaf);
		SwingUtilities.updateComponentTreeUI(this);
		}
		catch(Exception ex) { ex.printStackTrace(); }
		
		setLayout(new GridLayout(3,3));
		button=new JButton[9];
		index=new int[9];
		result=new JButton("RESULT");
		start=new JButton(new ImageIcon("src/res/startnew.png"));
		refresh=new JButton(new ImageIcon("src/res/interact.png"));
		exit=new JButton(new ImageIcon("src/res/exit.png"));
		
		result.setEnabled(false);
		//here buttons are added to panel
		for(int i=0;i<9;i++)
		{
			index[i]=0;
			button[i]=new JButton();
			button[i].setEnabled(false);
			button[i].addActionListener(new buttonact(button[i],i));
		}
		
		for(int i=0;i<9;i++)
			add(button[i]);
		
		refresh.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				for(int i=0;i<9;i++)
				{
					button[i].setEnabled(false);
					button[i].setIcon(null);
				}
			}
		});
		/*result.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				for(int j=0;j<9;j+=3)
				{
					if((index[j]==index[j+1])&&(index[j]==index[j+2]))
					{
						JOptionPane.showMessageDialog(null, "YOU WON!!","result", JOptionPane.PLAIN_MESSAGE);
						break;
					}
	
					else if((index[j]==index[j+3])&&(index[j]==index[j+6]))
					{
						JOptionPane.showMessageDialog(null, "YOU WON!!","result", JOptionPane.PLAIN_MESSAGE);
						break;
					}
					
					else if((index[j]==index[j+4])&&(index[j]==index[j+8]))
					{
						JOptionPane.showMessageDialog(null, "YOU WON!!","result", JOptionPane.PLAIN_MESSAGE);
						break;
					}
					
					/*else if(((index[0]==index[4])&&(index[0]==index[8])))
						{
							JOptionPane.showMessageDialog(null, "YOU WON!!","result", JOptionPane.PLAIN_MESSAGE);
							break;
						}
					
					else if((index[2]==index[4])&&(index[2]==index[6]))
						{
								JOptionPane.showMessageDialog(null, "YOU WON!!","result", JOptionPane.PLAIN_MESSAGE);
								break;
						}
				}
			}
		});*/
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				result.setEnabled(true);
				for(int i=0;i<9;i++)
					button[i].setEnabled(true);
			}
		});
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
	}
	
	private class buttonact implements ActionListener
	{
		JButton button=new JButton();
		int a;
		
		buttonact(JButton b, int k)
		{
			button=b;
			a=k;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(index[a]==0)
			{
				button.setIcon(new ImageIcon("src/res/letterO.png"));
				index[a]=1;
			}
			else if(index[a]==1)
			{
				button.setIcon(new ImageIcon("src/res/letterX.png"));
				index[a]=0;
			}
			
		}
	}
	
	public static void main(String[] args)
	{
		JFrame fr=new JFrame("TIC-TAC-TOE");
		fr.setIconImage((new ImageIcon("src/res/tictactoe.png")).getImage());
		tictactoe game=new tictactoe();
		JPanel bottompanel=new JPanel();
		bottompanel.setLayout(new GridLayout(1,3,2,0));
		bottompanel.add(refresh);
		bottompanel.add(start);
		bottompanel.add(exit);
		fr.add(game);
		fr.add(bottompanel,BorderLayout.SOUTH);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setLocation(520,190);
		fr.setSize(300,340);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}