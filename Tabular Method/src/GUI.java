import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.io.IOException;
import java.util.Scanner;

public class GUI extends JFrame {

		
	/*JFrame f;
	JButton b;
	JPanel P;*/
	
	private JLabel label;
	private JLabel label1;
	private JLabel label2;
	private JButton button;
	private JTextField text;
	private ImageIcon image1;
	private ImageIcon image2;
	private JButton btnNewButton;
	private JTextField textFi;
	private String in = "";
	
	public GUI(){
		getContentPane().setBackground(new Color(106, 90, 205));
		
		/*label = new JLabel("I am a label");
		add(label);
		text = new JTextField(15);
		add(text);
		button = new JButton("Click me");
		add (button);*/
		
		image1 = new ImageIcon(getClass().getResource("sky.jpg"));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton = new JButton("Minimize");
		//btnNewButton.setSize(3000 , 3000);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabular t = new tabular();
				t.gui = 1;
				t.take = textFi.getText();
				if(t.take.isEmpty()){
					t.read = 1;
				}
				
				try {
					t.input();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, t.fine);
			
			}
		});
		
		
		btnNewButton.setFont(new Font("Aharoni", Font.PLAIN, 11));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(Color.RED);
		getContentPane().add(btnNewButton);
		
		Scanner input = new Scanner(System.in);
		textFi = new JTextField();
		add(textFi);
		//String g = input.nextLine();
		
		
		textFi.setForeground(new Color(0, 0, 255));
		getContentPane().add(textFi);
		textFi.setColumns(10);
		label1 = new JLabel(image1);
		getContentPane().add(label1);
		
		JButton btnNewButton_1 = new JButton("New button");
		getContentPane().add(btnNewButton_1);
		/*label = new JLabel("");
		getContentPane().add(label);
		button = new JButton("Click me man!!!!!!!!!!");
		getContentPane().add(button);
		event e = new event();
		button.addActionListener(e);*/
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GUI first = new GUI();
		first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		first.setSize(500 , 500);
		first.setVisible(true);
		first.setTitle("My first GUI");
		first.setBackground(Color.BLACK);
		
	}
	
	public class event implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText("now you can see words!!!");
			
		}	
	}
}

