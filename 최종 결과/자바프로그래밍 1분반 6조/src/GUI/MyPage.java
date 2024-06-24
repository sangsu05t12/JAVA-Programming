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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPage {

	public JFrame frame;
	static public Operator o=null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String idd;
	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:mysql://127.0.0.1:3306/dbstudy";	//dbstudy 스키마
	String user = "root";
	String passwd = "Tkdtn2040!";		//본인이 설정한 root 계정의 비밀번호를 입력하면 된다.
	
	String pww;
	String nam;
	String ema;
	ResultSet rs=null;
	String changeStr=null;

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

	/**
	 * Create the application.
	 */
	public MyPage(Operator _o) {
		o=_o;
		initialize();
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
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		frame.setTitle("여기 갈래?");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 483, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 192, 203));
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 17));
		textField.setEnabled(false);
		textField.setBounds(157, 136, 167, 29);
		textField.setText(o.db.id());
		textField.setBorder(BorderFactory.createEmptyBorder());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setForeground(new Color(255, 192, 203));
		textField_1.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setText(o.db.password());
		textField_1.setBorder(BorderFactory.createEmptyBorder()); // 테두리 없애기
		textField_1.setBounds(157, 195, 167, 29);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 192, 203));
		textField_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 17));
		textField_2.setColumns(10);
		textField_2.setText(o.db.name());
		textField_2.setBorder(BorderFactory.createEmptyBorder());

		textField_2.setBounds(157, 251, 167, 21);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(255, 192, 203));
		textField_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 17));
		textField_3.setColumns(10);
		textField_3.setText(o.db.email());
		textField_3.setBorder(BorderFactory.createEmptyBorder());

		textField_3.setBounds(157, 298, 167, 29);
		frame.getContentPane().add(textField_3);
		
		RoundedButton btnNewButton = new RoundedButton("저장하기");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_1.getText().equals("")&&!textField_2.getText().equals("")&&!textField_3.getText().equals("")) {
				o.db.swap(textField.getText(),textField_1.getText() ,textField_2.getText() ,textField_3.getText());
				MainScreen window = new MainScreen(o);
				JOptionPane.showMessageDialog(null, "회원 정보 수정 성공!");
				window.frame.setVisible(true);
				frame.dispose();
				}
			}
		});

		btnNewButton.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(255, 228, 225));
		
		btnNewButton.setBounds(108, 396, 112, 44);
		frame.getContentPane().add(btnNewButton);
		
		RoundedButton btnNewButton_1 = new RoundedButton("취소");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen window=new MainScreen(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 17));
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		
		
		btnNewButton_1.setBounds(243, 396, 106, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		ImageIcon icon11 = new ImageIcon(MyPage.class.getResource("/img_mypage/mypage.png"));
		Image img11 = icon11.getImage();
		Image changeimg11 = img11.getScaledInstance(467,508,Image.SCALE_SMOOTH);
		ImageIcon chageIcon11 = new ImageIcon(changeimg11);
		JLabel lblNewLabel_2 = new JLabel(chageIcon11);
		
		lblNewLabel_2.setBounds(0, 0, 467, 508);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setLocationRelativeTo(null);
		}
}
