package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.Action;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.SystemColor;
import java.awt.Choice;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.sql.*;
import java.awt.Component;
import javax.swing.JTextArea;

public class MainScreen {
	Database db = null;
	joinScreen mf = null;
	loginScreen jf = null;
	public JFrame frame;
	
	String placename[];
	Connection con = null;
	public static Statement stmt = null;
	
	static public Operator o=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen(o);
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
	public MainScreen(Operator _o) {
		placename = new String[10];
		String url = "jdbc:mysql://127.0.0.1:3306/project";
		String userid = "root";
		String pwd = "Tkdtn2040!"; 

		        try { // 데이터베이스를 연결하는 과정
		        	Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(url, userid, pwd);
					stmt = con.createStatement();
		        
		            System.out.println("데이터베이스연결 준비...");
		            con = DriverManager.getConnection(url, userid, pwd);  // db접속
		            System.out.println("데이터베이스연결 성공");

		            String query1 = "SELECT 이름 FROM " + o.db.Area + "관광지"; // 모텔 sql문

		            Statement stmt1 = con.createStatement();  // 결과랑 연결시킬 커넥션
		            ResultSet rs1 = stmt1.executeQuery(query1);     // 모텔 결과를받을 rs

		    int index = 0;
		            ////////////대구
		            while(rs1.next()) {  // 데이터를 뽑아오는 과정
		               placename[index] = rs1.getString("이름");
		    index++;
		         }
		
		
		rs1.close();
		        }
		        catch(Exception e) {
		        	
		        }
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
	
	public class RoundedButton1 extends JButton {
	      public RoundedButton1() { super(); decorate(); } 
	      public RoundedButton1(String text) { super(text); decorate(); } 
	      public RoundedButton1(Action action) { super(action); decorate(); } 
	      public RoundedButton1(Icon icon) { super(icon); decorate(); } 
	      public RoundedButton1(String text, Icon icon) { super(text, icon); decorate(); } 
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
	
	public class roundpanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("여기 갈래?");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 768, 904);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		RoundedButton btnNewButton_1_1 = new RoundedButton("지역검색");  //RoundedButton
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchMap window=new SearchMap(o);
				window.rdbtnNewRadioButton.setSelected(true);
				window.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(235, 22, 112, 34);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("여기 갈래?");
		lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 23));
		lblNewLabel.setForeground(new Color(255, 182, 193));
		lblNewLabel.setBounds(12, 16, 136, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("회원님에게 딱 맞는 여행지 추천");
		lblNewLabel_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 17));
		lblNewLabel_1.setBounds(255, 253, 285, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		RoundedButton1 btnNewButton_1 = new RoundedButton1("게시판"); //RoundedButton1
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board window = new Board(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(368, 22, 112, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		RoundedButton btnNewButton_2 = new RoundedButton("내정보수정");  //RoundedButton
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPage window = new MyPage(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(492, 22, 123, 34);
		frame.getContentPane().add(btnNewButton_2);
		
		RoundedButton1 btnNewButton_3 = new RoundedButton1("로그아웃");  // RoundedButton1
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginScreen window = new loginScreen(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(634, 22, 105, 34);
		frame.getContentPane().add(btnNewButton_3);
		
		ImageIcon icon3 = new ImageIcon(MainScreen.class.getResource(o.as.image1_file));
		Image img3 = icon3.getImage();
		Image changeimg3 = img3.getScaledInstance(200,200,Image.SCALE_SMOOTH);
		ImageIcon chageIcon3 = new ImageIcon(changeimg3);
		
		ImageIcon icon4 = new ImageIcon(MainScreen.class.getResource(o.as.image2_file));
		Image img4 = icon4.getImage();
		Image changeimg4 = img4.getScaledInstance(200,200,Image.SCALE_SMOOTH);
		ImageIcon chageIcon4 = new ImageIcon(changeimg4);
		
		ImageIcon icon5 = new ImageIcon(MainScreen.class.getResource(o.as.image3_file));
		Image img5 = icon5.getImage();
		Image changeimg5 = img5.getScaledInstance(200,200,Image.SCALE_SMOOTH);
		ImageIcon chageIcon5 = new ImageIcon(changeimg5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 0, 758, 73);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 240, 245));
		panel_1.setBounds(0, 545, 752, 320);
		frame.getContentPane().add(panel_1);
		
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel(o.as.image1_txt);
        lblNewLabel_3.setForeground(new Color(255, 182, 193));
        lblNewLabel_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 15));
        lblNewLabel_3.setBounds(54, 267, 146, 43);
        panel_1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_1_1 = new JLabel("계절별 여행지 추천");
        lblNewLabel_1_1.setBounds(296, 10, 183, 46);
        panel_1.add(lblNewLabel_1_1);
        lblNewLabel_1_1.setForeground(new Color(221, 160, 221));
        lblNewLabel_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 18));
        JLabel lblNewLabel_2_3 = new JLabel(chageIcon3);
        lblNewLabel_2_3.setBounds(12, 57, 200, 200);
        panel_1.add(lblNewLabel_2_3);
        
        lblNewLabel_2_3.setOpaque(true);
        lblNewLabel_2_3.setBackground(Color.LIGHT_GRAY);
        JLabel lblNewLabel_2_4 = new JLabel(chageIcon4);
        lblNewLabel_2_4.setBounds(279, 57, 200, 200);
        panel_1.add(lblNewLabel_2_4);
        
        lblNewLabel_2_4.setOpaque(true);
        lblNewLabel_2_4.setBackground(Color.LIGHT_GRAY);
        JLabel lblNewLabel_2_5 = new JLabel(chageIcon5);
        lblNewLabel_2_5.setBounds(540, 57, 200, 200);
        panel_1.add(lblNewLabel_2_5);
        
        lblNewLabel_2_5.setOpaque(true);
        lblNewLabel_2_5.setBackground(Color.LIGHT_GRAY);
        
        JLabel lblNewLabel_3_1 = new JLabel(o.as.image2_txt);
        lblNewLabel_3_1.setForeground(new Color(255, 182, 193));
        lblNewLabel_3_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 15));
        lblNewLabel_3_1.setBounds(304, 267, 175, 43);
        panel_1.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_3_2 = new JLabel(o.as.image3_txt);
        lblNewLabel_3_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 15));
        lblNewLabel_3_2.setForeground(new Color(255, 182, 193));
        lblNewLabel_3_2.setBounds(591, 267, 132, 43);
        panel_1.add(lblNewLabel_3_2);
		
	      ImageIcon cicon1 = new ImageIcon(MainScreen.class.getResource("/place/"+o.db.Area+"관광지1.jpg"));
	      Image cimg1 = cicon1.getImage();
	      Image cchangeimg1 = cimg1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	      
	      ImageIcon cicon2 = new ImageIcon(MainScreen.class.getResource("/place/"+o.db.Area+"관광지2.jpg"));
	      Image cimg2 = cicon2.getImage();
	      Image cchangeimg2 = cimg2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	      
	      ImageIcon cicon3 = new ImageIcon(MainScreen.class.getResource("/place/"+o.db.Area+"관광지3.jpg"));
	      Image cimg3 = cicon3.getImage();
	      Image cchangeimg3 = cimg3.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 240, 245));
		panel_2_1.setBounds(0, 83, 752, 155);
		frame.getContentPane().add(panel_2_1);
		
		
		ImageIcon icon10 = new ImageIcon(MainScreen.class.getResource("/img_icon/호텔.png"));
		Image img10 = icon10.getImage();
		Image changeimg10 = img10.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		ImageIcon chageIcon10 = new ImageIcon(changeimg10);
		panel_2_1.setLayout(null);
		JLabel lblNewLabel_4 = new JLabel(chageIcon10);
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				o.smf.area = o.db.Area;
				SearchScreen window=new SearchScreen(o);
				window.rdbtnNewRadioButton.setSelected(true);
				
				window.rdbtnNewRadioButton.setVisible(false);
				window.rdbtnNewRadioButton_1.setVisible(false);
				window.rdbtnNewRadioButton_1_1.setVisible(false);
				window.rdbtnNewRadioButton_1_3.setVisible(false);
				window.rdbtnNewRadioButton_1_3_1.setVisible(false);
				window.rdbtnNewRadioButton_1_2.setVisible(false);
				
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel_4.setBounds(28, 10, 100, 100);
		panel_2_1.add(lblNewLabel_4);
		
		ImageIcon icon11 = new ImageIcon(MainScreen.class.getResource("/img_icon/모텔.png"));
		Image img11 = icon11.getImage();
		Image changeimg11 = img11.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		ImageIcon chageIcon11 = new ImageIcon(changeimg11);
		JLabel lblNewLabel_5 = new JLabel(chageIcon11);
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				o.smf.area=o.db.Area;
				SearchScreen window=new SearchScreen(o);
				window.rdbtnNewRadioButton_1.setSelected(true);
				window.rdbtnNewRadioButton.setVisible(false);
				window.rdbtnNewRadioButton_1.setVisible(false);
				window.rdbtnNewRadioButton_1_1.setVisible(false);
				window.rdbtnNewRadioButton_1_3.setVisible(false);
				window.rdbtnNewRadioButton_1_3_1.setVisible(false);
				window.rdbtnNewRadioButton_1_2.setVisible(false);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setBounds(172, 10, 100, 100);
		panel_2_1.add(lblNewLabel_5);
		
		ImageIcon icon12 = new ImageIcon(MainScreen.class.getResource("/img_icon/펜션.png"));
		Image img12 = icon12.getImage();
		Image changeimg12 = img12.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		ImageIcon chageIcon12 = new ImageIcon(changeimg12);
		JLabel lblNewLabel_6 = new JLabel(chageIcon12);
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				o.smf.area=o.db.Area;
				SearchScreen window=new SearchScreen(o);
				window.rdbtnNewRadioButton_1_1.setSelected(true);
				window.rdbtnNewRadioButton.setVisible(false);
				window.rdbtnNewRadioButton_1.setVisible(false);
				window.rdbtnNewRadioButton_1_1.setVisible(false);
				window.rdbtnNewRadioButton_1_3.setVisible(false);
				window.rdbtnNewRadioButton_1_3_1.setVisible(false);
				window.rdbtnNewRadioButton_1_2.setVisible(false);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.setBounds(324, 10, 100, 100);
		panel_2_1.add(lblNewLabel_6);
		
		
		
		ImageIcon icon13 = new ImageIcon(MainScreen.class.getResource("/img_icon/음식점.png"));
		Image img13 = icon13.getImage();
		Image changeimg13 = img13.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		ImageIcon chageIcon13 = new ImageIcon(changeimg13);
		JLabel lblNewLabel_7 = new JLabel(chageIcon13);
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				o.smf.area=o.db.Area;
				SearchScreen window=new SearchScreen(o);
				window.rdbtnNewRadioButton_1_3.setSelected(true);
				window.rdbtnNewRadioButton.setVisible(false);
				window.rdbtnNewRadioButton_1.setVisible(false);
				window.rdbtnNewRadioButton_1_1.setVisible(false);
				window.rdbtnNewRadioButton_1_3.setVisible(false);
				window.rdbtnNewRadioButton_1_3_1.setVisible(false);
				window.rdbtnNewRadioButton_1_2.setVisible(false);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_7.setBounds(472, 10, 100, 100);
		panel_2_1.add(lblNewLabel_7);
		
		ImageIcon icon14 = new ImageIcon(MainScreen.class.getResource("/img_icon/관광지.png"));
		Image img14 = icon14.getImage();
		Image changeimg14 = img14.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		ImageIcon chageIcon14 = new ImageIcon(changeimg14);
		JLabel lblNewLabel_8 = new JLabel(chageIcon14);
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				o.smf.area=o.db.Area;
				SearchScreen window=new SearchScreen(o);
				window.rdbtnNewRadioButton_1_3_1.setSelected(true);
				window.rdbtnNewRadioButton.setVisible(false);
				window.rdbtnNewRadioButton_1.setVisible(false);
				window.rdbtnNewRadioButton_1_1.setVisible(false);
				window.rdbtnNewRadioButton_1_3.setVisible(false);
				window.rdbtnNewRadioButton_1_3_1.setVisible(false);
				window.rdbtnNewRadioButton_1_2.setVisible(false);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_8.setBounds(622, 10, 100, 100);
		panel_2_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("HOTEL");
		lblNewLabel_9.setBounds(38, 112, 116, 36);
		lblNewLabel_9.setForeground(new Color(221, 160, 221));
		lblNewLabel_9.setFont(new Font("휴먼모음T", Font.BOLD, 28));
		panel_2_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("MOTEL");
		lblNewLabel_10.setBounds(172, 115, 101, 31);
		lblNewLabel_10.setFont(new Font("휴먼모음T", Font.BOLD, 28));
		lblNewLabel_10.setForeground(new Color(255, 192, 203));
		panel_2_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("PENSION");
		lblNewLabel_11.setBounds(314, 115, 128, 31);
		lblNewLabel_11.setFont(new Font("휴먼모음T", Font.BOLD, 28));
		lblNewLabel_11.setForeground(new Color(221, 160, 221));
		panel_2_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("FOOD");
		lblNewLabel_12.setBounds(490, 116, 91, 28);
		lblNewLabel_12.setFont(new Font("휴먼모음T", Font.BOLD, 28));
		lblNewLabel_12.setForeground(new Color(255, 192, 203));
		panel_2_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("PLACE");
		lblNewLabel_13.setBounds(625, 115, 97, 28);
		lblNewLabel_13.setFont(new Font("휴먼모음T", Font.BOLD, 28));
		lblNewLabel_13.setForeground(new Color(221, 160, 221));
		panel_2_1.add(lblNewLabel_13);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 250));
		panel_2.setBounds(0, 253, 752, 290);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		JLabel lblNewLabel_2 = new JLabel("사진1");
		lblNewLabel_2.setBounds(25, 32, 200, 200);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(cchangeimg1));
		lblNewLabel_2.setBackground(new Color(255, 250, 250));
		lblNewLabel_2.setOpaque(true);
		JLabel lblNewLabel_2_1 = new JLabel("사진2");
		lblNewLabel_2_1.setBounds(278, 32, 200, 200);
		panel_2.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setIcon(new ImageIcon(cchangeimg2));
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setBackground(new Color(255, 250, 250));
		JLabel lblNewLabel_2_2 = new JLabel("사진3");
		lblNewLabel_2_2.setBounds(525, 32, 200, 200);
		panel_2.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setIcon(new ImageIcon(cchangeimg3));
		lblNewLabel_2_2.setOpaque(true);
		lblNewLabel_2_2.setBackground(new Color(255, 250, 250));
		
		JTextArea textArea = new JTextArea(placename[0]);
		textArea.setForeground(Color.PINK);
		textArea.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 13));
		textArea.setBounds(25, 247, 200, 33);
		panel_2.add(textArea);
		textArea.setEditable(false);
		textArea.setOpaque(false);
		textArea.setLineWrap(true);
		
		JTextArea textArea_1 = new JTextArea(placename[1]);
		textArea_1.setOpaque(false);
		textArea_1.setLineWrap(true);
		textArea_1.setForeground(Color.PINK);
		textArea_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 13));
		textArea_1.setEditable(false);
		textArea_1.setBounds(278, 246, 200, 33);
		panel_2.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea(placename[2]);
		textArea_2.setOpaque(false);
		textArea_2.setLineWrap(true);
		textArea_2.setForeground(Color.PINK);
		textArea_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 13));
		textArea_2.setEditable(false);
		textArea_2.setBounds(525, 246, 200, 33);
		panel_2.add(textArea_2);
		frame.setLocationRelativeTo(null);
	}
}