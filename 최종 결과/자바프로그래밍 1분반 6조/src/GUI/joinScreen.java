package GUI;

import java.awt.*;
import javax.swing.*;
import javax.tools.StandardJavaFileManager;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class joinScreen {
	static public Operator o=null;
	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					joinScreen window = new joinScreen(o);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public class RoundedButton extends JButton {
	      public RoundedButton() { super(); decorate(); } 
	      public RoundedButton(String text) { super(text); decorate(); } 
	      public RoundedButton(Action action) { super(action); decorate(); } 
	      public RoundedButton(Icon icon) { super(icon); decorate(); } 
	      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(255, 182, 193); //배경색 결정
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
	 * Create the application.
	 */
	
	public joinScreen(Operator _o) {
		o=_o;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		frame.setTitle("여기 갈래?");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 344, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		textField.setBackground(new Color(255, 228, 225));
		textField.setBounds(107, 87, 209, 21);
		textField.setOpaque(false); //background
		frame.getContentPane().add(textField);
		textField.setBorder(BorderFactory.createEmptyBorder());
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setFont(new Font("굴림", Font.PLAIN, 18));
		textField_1.setBackground(new Color(255, 228, 225));
		textField_1.setColumns(10);
		textField_1.setBounds(107, 134, 209, 21);
		textField_1.setOpaque(false); //background
		textField_1.setBorder(BorderFactory.createEmptyBorder());
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		textField_2.setBackground(new Color(255, 228, 225));
		textField_2.setColumns(10);
		textField_2.setBounds(107, 179, 209, 21);
		textField_2.setOpaque(false); //background
		textField_2.setBorder(BorderFactory.createEmptyBorder());
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(255, 255, 255));
		textField_3.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		textField_3.setBackground(new Color(255, 228, 225));
		textField_3.setColumns(10);
		textField_3.setBounds(107, 227, 209, 21);
		textField_3.setOpaque(false); //background
		textField_3.setBorder(BorderFactory.createEmptyBorder());
		frame.getContentPane().add(textField_3);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"인천", "서울", "대전", "대구", "울산", "부산", "광주", "강릉", "가평", "수원", "제주도"}));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(111, 277, 97, 37);
		frame.getContentPane().add(comboBox);
		
		RoundedButton btnNewButton = new RoundedButton("회원가입");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					int error_code = 0;
					
					
					String new_id = textField.getText();
					String new_pass = textField_1.getText();
					String new_name = textField_2.getText();
					String new_email = textField_3.getText();
					if(textField.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "아이디를 입력하세요!!");
					}
					
					
					else if(textField_1.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요!!");
					}
					
					else if(textField_2.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "이름을 입력하세요!!");
					}
					
					else if(textField_3.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "이메일을 입력하세요!!");
					}
					else
					{
						error_code = 1;
					}
					
					if(error_code == 1)
					{
						if(o.db.joinCheck(textField.getText(), textField_1.getText(),
								textField_2.getText(),textField_3.getText(), comboBox.getSelectedItem().toString())){
						JOptionPane.showMessageDialog(null, "회원가입 성공!!");
						loginScreen window=new loginScreen(o);
						window.frame.setVisible(true);
						frame.dispose();
					}
				}
			}
		});
		btnNewButton.setBounds(48, 368, 107, 50);
		frame.getContentPane().add(btnNewButton);
		
		RoundedButton btnNewButton_1 = new RoundedButton("취소");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginScreen window=new loginScreen(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(178, 368, 114, 50);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(joinScreen.class.getResource("/img_join/mem_join.png")));
		lblNewLabel_2.setBounds(0, 0, 335, 452);
		frame.getContentPane().add(lblNewLabel_2);
		
		frame.setLocationRelativeTo(null);
	}
}