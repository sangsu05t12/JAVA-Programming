package GUI;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class loginScreen {

	public JFrame frame;
	static public Operator o=null;
	private JTextField txtTest;
	private JTextField textField_1;
	
	public class RoundedButton extends JButton {
	      public RoundedButton() { super(); decorate(); } 
	      public RoundedButton(String text) { super(text); decorate(); } 
	      public RoundedButton(Action action) { super(action); decorate(); } 
	      public RoundedButton(Icon icon) { super(icon); decorate(); } 
	      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(255, 228, 225); //배경색 결정
	         Color o=new Color(255,255,255); //글자색 결정
	         int width = getWidth(); 
	         int height = getHeight(); 
	         Graphics2D graphics = (Graphics2D) g; 
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
	         else { graphics.setColor(c); } 
	         graphics.fillRoundRect(0, 0, width, height, 10, 10); 
	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	         int textX = (width - stringBounds.width) / 2; 
	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	         graphics.setColor(o); 
	         graphics.setFont(getFont()); 
	         graphics.drawString(getText(), textX, textY); 
	         graphics.dispose(); 
	         super.paintComponent(g); 
	         }
	      }
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginScreen window = new loginScreen(o);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	
	public loginScreen(Operator _o) {
		o=_o;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		frame = new JFrame();
		frame.setTitle("여기 갈래?");
		frame.getContentPane().setBackground(Color.WHITE);
		
		txtTest = new JTextField(); // 아이디
		txtTest.setForeground(Color.WHITE);
		txtTest.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		txtTest.setBounds(129, 363, 179, 23);
		txtTest.setBackground(new Color(255, 228, 225));
		txtTest.setOpaque(false); //background
		txtTest.setBorder(BorderFactory.createEmptyBorder()); // 테두리 없애기
		txtTest.setColumns(10);
		
		textField_1 = new JPasswordField(); // 비밀번호
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("굴림체", Font.PLAIN, 21));
		textField_1.setBounds(129, 412, 179, 23);
		textField_1.setColumns(10);
		textField_1.setBorder(BorderFactory.createEmptyBorder()); // 테두리 없애기
		textField_1.setOpaque(false); //background
		textField_1.setBackground(new Color(255, 228, 225));

		ButtonGroup g = new ButtonGroup();
		
		RoundedButton btnNewButton = new RoundedButton("로그인");
		btnNewButton.setBounds(76, 448, 93, 36);
		btnNewButton.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 15));
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "admin";
				String pass = "1234";
				if(txtTest.getText().equals(id)&&textField_1.getText().equals(pass)) {
					AdminMain window = new AdminMain(o);
					JOptionPane.showMessageDialog(null, "관리자 로그인 성공!!");
					window.frame.setVisible(true);
					frame.dispose();
				}
				if(o.db.logincheck(txtTest.getText(),textField_1.getText())){
					MainScreen window = new MainScreen(o);
					JOptionPane.showMessageDialog(null, "로그인 성공!!");
					window.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
			
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 228, 225));
		
		RoundedButton btnNewButton_1 = new RoundedButton("회원가입");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(187, 448, 99, 36);
		btnNewButton_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				joinScreen window = new joinScreen(o);
				window.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(txtTest);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(btnNewButton_1);
		frame.getContentPane().add(textField_1);
		
		ImageIcon icon4 = new ImageIcon(loginScreen.class.getResource("/img_login/img_main3.png"));
		Image img4 = icon4.getImage();
		Image changeimg4 = img4.getScaledInstance(939,533,Image.SCALE_SMOOTH);
		ImageIcon chageIcon4 = new ImageIcon(changeimg4);
		JLabel lblNewLabel_2 = new JLabel(chageIcon4);
		
		lblNewLabel_2.setBounds(0, 0, 923, 494);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setBounds(100, 100, 939, 533);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
