package GUI;

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

public class SearchScreen {
	public static String place = "";  // 이거room으로넘기려고씀
	String motel[][];  // db에서 데이터 가져와서 저장할 2차원배열
	String hotel[][];  
	String pension[][];  
	String placey[][];
	String food[][];
	String festival[][];
	JRadioButton rdbtnNewRadioButton = new JRadioButton("호텔");
	
	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("모텔");
	JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("펜션");
	JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("축제");
	JRadioButton rdbtnNewRadioButton_1_3 = new JRadioButton("음식점");
	JRadioButton rdbtnNewRadioButton_1_3_1 = new JRadioButton("관광지");
	Connection con;  // db 커넥션
	int index=0;  
	
	public JFrame frame;
	static public Operator o=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchScreen window = new SearchScreen(o);
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
	public SearchScreen(Operator _o) {
		o=_o;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		motel = new String[10][10];  // 2차원배열생성
		hotel = new String[10][25];  
		pension = new String[10][25];  
		food = new String[5][4];
        placey = new String[10][2];
        festival = new String[5][3];
		String url = "jdbc:mysql://127.0.0.1:3306/project";
		String userid = "root";
		String pwd = "Tkdtn2040!"; 
		
		try { // 데이터베이스를 연결하는 과정
			System.out.println("데이터베이스연결 준비...");
			con = DriverManager.getConnection(url, userid, pwd);  // db접속
			System.out.println("데이터베이스연결 성공");
			
			String area1 = o.smf.Area();
            String mquery1 = "SELECT 장소, 위치, 별점, 대실, 숙박 FROM " + o.smf.area + "모텔"; // 모텔 sql문
            String hquery1 = "SELECT * FROM " + o.smf.area + "호텔"; // 호텔
            String pquery1 = "SELECT * FROM " + o.smf.area + "펜션";  // 펜션
            String fquery1 = "SELECT * FROM " + o.smf.area + "음식점";
            String pcquery1 = "SELECT * FROM " + o.smf.area + "관광지";
            String fsquery1 = "SELECT * FROM " + o.smf.area + "축제";

            Statement stmt1 = con.createStatement();  // 결과랑 연결시킬 커넥션
            ResultSet rs1 = stmt1.executeQuery(mquery1);     // 모텔 결과를받을 rs
            
            Statement stmt2 = con.createStatement();  // 결과랑 연결시킬 커넥션
            ResultSet rs2 = stmt2.executeQuery(hquery1);     // 호텔 결과를받을 rs
            
            Statement stmt3 = con.createStatement();  // 결과랑 연결시킬 커넥션
            ResultSet rs3 = stmt3.executeQuery(pquery1);     // 펜션 결과를받을 rs
            
            Statement stmt4 = con.createStatement();  // 결과랑 연결시킬 커넥션
            ResultSet rs4 = stmt4.executeQuery(fquery1);     // 펜션 결과를받을 rs
            
            Statement stmt5 = con.createStatement();  // 결과랑 연결시킬 커넥션
            ResultSet rs5 = stmt5.executeQuery(pcquery1);     // 펜션 결과를받을 rs
            
            Statement stmt6 = con.createStatement();  // 결과랑 연결시킬 커넥션
            ResultSet rs6 = stmt6.executeQuery(fsquery1);     // 축제 결과를받을 rs
				
            ////////////대구
            while(rs1.next()) {  // 데이터를 뽑아오는 과정
               motel[index][0] = rs1.getString("장소");
               motel[index][1] = rs1.getString("위치");
               motel[index][2] = rs1.getString("별점");
               motel[index][3] = rs1.getString("대실");
               motel[index][4] = rs1.getString("숙박");
               index++;   
         }
            index = 0;
            
            while(rs2.next()) {  // 데이터를 뽑아오는 과정
               hotel[index][0] = rs2.getString("장소");
               hotel[index][1] = rs2.getString("위치");
               hotel[index][2] = rs2.getString("별점");
               
               
               int j = 1;
               for(int i = 1; i < 20; i+=2) {
                  hotel[index][i+2] = rs2.getString("방" + j);
                  hotel[index][i+3] = rs2.getString("가격" + j);
                  j++;
               }   
               index++;   
         }
            index = 0;
            
            while(rs3.next()) {  // 데이터를 뽑아오는 과정
               pension[index][0] = rs3.getString("장소");
               pension[index][1] = rs3.getString("위치");
               pension[index][2] = rs3.getString("별점");
               
               int j = 1;
               for(int i = 1; i < 20; i+=2) {
                  pension[index][i+2] = rs3.getString("방" + j);
                  pension[index][i+3] = rs3.getString("가격" + j);
                  j++;
               }         
               index++;   
         }   
            
               index = 0;
            
            while(rs4.next()) {  // 데이터를 뽑아오는 과정
               food[index][0] = rs4.getString("이름");
               food[index][1] = rs4.getString("위치");
               food[index][2] = rs4.getString("별점");
               food[index][3] = rs4.getString("종류");
               index++;   
         }   
            
               index = 0;
            
            while(rs5.next()) {  // 데이터를 뽑아오는 과정
               placey[index][0] = rs5.getString("이름");
               placey[index][1] = rs5.getString("위치");
               index++;   
         }   
            
        	index = 0;
        
       while(rs6.next()) {  // 데이터를 뽑아오는 과정  축제
            festival[index][0] = rs6.getString("이름");
            festival[index][1] = rs6.getString("위치");
            festival[index][2] = rs6.getString("기간");
            index++;   
      }  
       
         rs1.close();
         rs2.close();
         rs3.close();
         rs4.close();
         rs5.close();
         rs6.close();

		} catch (Exception e) {
	}
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("여기갈래?");
		frame.setBounds(100, 100, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 10, 659, 475);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setAutoscrolls(true);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		panel.setBackground(new Color(255, 250, 250));
		
		RoundedButton btnNewButton_1 = new RoundedButton("뒤로가기");
		btnNewButton_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 18));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen window = new MainScreen(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		rdbtnNewRadioButton.setForeground(new Color(255, 192, 203));
		rdbtnNewRadioButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		
		
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBackground(new Color(255, 228, 225));
		rdbtnNewRadioButton.setContentAreaFilled(false); // background
		rdbtnNewRadioButton.setBorderPainted(false);
		
		rdbtnNewRadioButton_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setForeground(new Color(255, 192, 203));
		
		
		rdbtnNewRadioButton_1.setBackground(new Color(255, 228, 225));
		rdbtnNewRadioButton_1.setContentAreaFilled(false); // background
		rdbtnNewRadioButton_1.setBorderPainted(false);
		rdbtnNewRadioButton_1_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		rdbtnNewRadioButton_1_1.setForeground(new Color(255, 192, 203));
		
		
		rdbtnNewRadioButton_1_1.setBackground(new Color(255, 228, 225));
		rdbtnNewRadioButton_1_1.setContentAreaFilled(false); // background
		rdbtnNewRadioButton_1_1.setBorderPainted(false);
		ButtonGroup g=new ButtonGroup();
		g.add(rdbtnNewRadioButton);
		g.add(rdbtnNewRadioButton_1);
		g.add(rdbtnNewRadioButton_1_1);
		
		rdbtnNewRadioButton_1_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		rdbtnNewRadioButton_1_2.setForeground(new Color(255, 192, 203));
		
		rdbtnNewRadioButton_1_2.setBackground(new Color(255, 228, 225));
		rdbtnNewRadioButton_1_2.setContentAreaFilled(false); // background
		rdbtnNewRadioButton_1_2.setBorderPainted(false);
		rdbtnNewRadioButton_1_3.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		rdbtnNewRadioButton_1_3.setForeground(new Color(255, 192, 203));

		rdbtnNewRadioButton_1_3.setBackground(new Color(255, 228, 225));
		rdbtnNewRadioButton_1_3.setContentAreaFilled(false); // background
		rdbtnNewRadioButton_1_3.setBorderPainted(false);
		rdbtnNewRadioButton_1_3_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		rdbtnNewRadioButton_1_3_1.setForeground(new Color(255, 192, 203));
		
		rdbtnNewRadioButton_1_3_1.setBackground(new Color(255, 228, 225));
		rdbtnNewRadioButton_1_3_1.setContentAreaFilled(false); // background
		rdbtnNewRadioButton_1_3_1.setBorderPainted(false);
		
		g.add(rdbtnNewRadioButton_1_2);
		g.add(rdbtnNewRadioButton_1_3);
		g.add(rdbtnNewRadioButton_1_3_1);
		
		JLabel lblNewLabel = new JLabel(o.smf.area + " 검색 결과입니다.");
		lblNewLabel.setForeground(new Color(255, 192, 203));
		lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 20));
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(rdbtnNewRadioButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnNewRadioButton_1_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnNewRadioButton_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnNewRadioButton_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnNewRadioButton_1_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnNewRadioButton_1_3_1)
							.addGap(14)))
					.addGap(74)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(106))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnNewRadioButton, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
								.addComponent(rdbtnNewRadioButton_1_1, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
								.addComponent(rdbtnNewRadioButton_1, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
								.addComponent(rdbtnNewRadioButton_1_2, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
								.addComponent(rdbtnNewRadioButton_1_3, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
								.addComponent(rdbtnNewRadioButton_1_3_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setVisible(false);
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBackground(Color.WHITE);
		
		JPanel panel_1_1_2_1_1 = new JPanel();
		panel_1_1_2_1_1.setLayout(null);
		panel_1_1_2_1_1.setBackground(Color.WHITE);
		panel_1_1_2_1_1.setBounds(12, 10, 596, 145);
		panel_2_1_1_1.add(panel_1_1_2_1_1);
		
	     //////////////음식점
	    ImageIcon chicon44 = new ImageIcon("src/food/"+o.smf.area+"음식1.jpg");
	    Image chimg44 = chicon44.getImage();
	    Image cchimg44 = chimg44.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon44 = new ImageIcon(cchimg44);
	      JLabel lblNewLabel_1_1_2_1_1 = new JLabel(cchicon44);
	      lblNewLabel_1_1_2_1_1.setOpaque(true);
	      lblNewLabel_1_1_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_1.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_1.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_1.add(lblNewLabel_1_1_2_1_1);
	      
	      JLabel lblNewLabel_2_1_1_1_2_2_1_1 = new JLabel(food[0][2]);
	      lblNewLabel_2_1_1_1_2_2_1_1.setOpaque(true);
	      lblNewLabel_2_1_1_1_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	      lblNewLabel_2_1_1_1_2_2_1_1.setForeground(Color.RED);
	      lblNewLabel_2_1_1_1_2_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_1_2_2_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_2_2_1_1.setBounds(144, 10, 70, 25);
	      panel_1_1_2_1_1.add(lblNewLabel_2_1_1_1_2_2_1_1);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_1 = new JLabel(food[0][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_1.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_1.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_1_1_1_2_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_1.setBounds(144, 85, 440, 25);
	      panel_1_1_2_1_1.add(lblNewLabel_2_1_1_1_1_1_2_1_1);
	      
	      JLabel lblNewLabel_2_2_2_1_1 = new JLabel(food[0][0]);
	      lblNewLabel_2_2_2_1_1.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_1.setOpaque(true);
	      lblNewLabel_2_2_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_2_2_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_1.setBounds(144, 48, 358, 20);
	      panel_1_1_2_1_1.add(lblNewLabel_2_2_2_1_1);
	      
	      JLabel lblNewLabel_2_1_1_2_2_1_1 = new JLabel(food[0][3]);
	      lblNewLabel_2_1_1_2_2_1_1.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_1_1_2_2_1_1.setOpaque(true);
	      lblNewLabel_2_1_1_2_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_2_2_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_2_2_1_1.setBounds(144, 118, 440, 20);
	      panel_1_1_2_1_1.add(lblNewLabel_2_1_1_2_2_1_1);
	      
	      JPanel panel_1_1_2_1_1_1 = new JPanel();
	      panel_1_1_2_1_1_1.setLayout(null);
	      panel_1_1_2_1_1_1.setBackground(Color.WHITE);
	      panel_1_1_2_1_1_1.setBounds(12, 165, 596, 145);
	      panel_2_1_1_1.add(panel_1_1_2_1_1_1);
	      
		  ImageIcon chicon45 = new ImageIcon("src/food/"+o.smf.area+"음식2.jpg");
		  Image chimg45 = chicon45.getImage();
		  Image cchimg45 = chimg45.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		  ImageIcon cchicon45 = new ImageIcon(cchimg45);
	      JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel(cchicon45);
	      lblNewLabel_1_1_2_1_1_1.setOpaque(true);
	      lblNewLabel_1_1_2_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_1_1.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_1_1.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_1_1.add(lblNewLabel_1_1_2_1_1_1);
	      
	      JLabel lblNewLabel_2_1_1_1_2_2_1_1_1 = new JLabel(food[1][2]);
	      lblNewLabel_2_1_1_1_2_2_1_1_1.setOpaque(true);
	      lblNewLabel_2_1_1_1_2_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	      lblNewLabel_2_1_1_1_2_2_1_1_1.setForeground(Color.RED);
	      lblNewLabel_2_1_1_1_2_2_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_1_2_2_1_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_2_2_1_1_1.setBounds(144, 10, 70, 25);
	      panel_1_1_2_1_1_1.add(lblNewLabel_2_1_1_1_2_2_1_1_1);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_1_1 = new JLabel(food[1][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_1_1.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_1_1.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_1_1_1_2_1_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_1_1.setBounds(144, 85, 440, 25);
	      panel_1_1_2_1_1_1.add(lblNewLabel_2_1_1_1_1_1_2_1_1_1);
	      
	      JLabel lblNewLabel_2_2_2_1_1_1 = new JLabel(food[1][0]);
	      lblNewLabel_2_2_2_1_1_1.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_1_1.setOpaque(true);
	      lblNewLabel_2_2_2_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_2_2_1_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_1_1.setBounds(144, 48, 358, 20);
	      panel_1_1_2_1_1_1.add(lblNewLabel_2_2_2_1_1_1);
	      
	      JLabel lblNewLabel_2_1_1_2_2_1_1_1 = new JLabel(food[1][3]);
	      lblNewLabel_2_1_1_2_2_1_1_1.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_1_1_2_2_1_1_1.setOpaque(true);
	      lblNewLabel_2_1_1_2_2_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_2_2_1_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_2_2_1_1_1.setBounds(144, 118, 440, 20);
	      panel_1_1_2_1_1_1.add(lblNewLabel_2_1_1_2_2_1_1_1);
	      
	      JPanel panel_1_1_2_1_2_1 = new JPanel();
	      panel_1_1_2_1_2_1.setLayout(null);
	      panel_1_1_2_1_2_1.setBackground(Color.WHITE);
	      panel_1_1_2_1_2_1.setBounds(12, 320, 596, 145);
	      panel_2_1_1_1.add(panel_1_1_2_1_2_1);
	      
		  ImageIcon chicon46 = new ImageIcon("src/food/"+o.smf.area+"음식3.jpg");
		  Image chimg46 = chicon46.getImage();
		  Image cchimg46 = chimg46.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		  ImageIcon cchicon46 = new ImageIcon(cchimg46);
	      JLabel lblNewLabel_1_1_2_1_2_1 = new JLabel(cchicon46);
	      lblNewLabel_1_1_2_1_2_1.setOpaque(true);
	      lblNewLabel_1_1_2_1_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_2_1.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_2_1.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_2_1.add(lblNewLabel_1_1_2_1_2_1);
	      
	      JLabel lblNewLabel_2_1_1_1_2_2_1_2_1 = new JLabel(food[2][2]);
	      lblNewLabel_2_1_1_1_2_2_1_2_1.setOpaque(true);
	      lblNewLabel_2_1_1_1_2_2_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
	      lblNewLabel_2_1_1_1_2_2_1_2_1.setForeground(Color.RED);
	      lblNewLabel_2_1_1_1_2_2_1_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_1_2_2_1_2_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_2_2_1_2_1.setBounds(144, 10, 70, 25);
	      panel_1_1_2_1_2_1.add(lblNewLabel_2_1_1_1_2_2_1_2_1);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_2_1 = new JLabel(food[2][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1.setBounds(144, 85, 440, 25);
	      panel_1_1_2_1_2_1.add(lblNewLabel_2_1_1_1_1_1_2_1_2_1);
	      
	      JLabel lblNewLabel_2_2_2_1_2_1 = new JLabel(food[2][0]);
	      lblNewLabel_2_2_2_1_2_1.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_2_1.setOpaque(true);
	      lblNewLabel_2_2_2_1_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_2_2_1_2_1.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_2_1.setBounds(144, 48, 358, 20);
	      panel_1_1_2_1_2_1.add(lblNewLabel_2_2_2_1_2_1);
	      
	      JLabel lblNewLabel_2_1_1_2_2_1_2 = new JLabel(food[2][3]);
	      lblNewLabel_2_1_1_2_2_1_2.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_1_1_2_2_1_2.setOpaque(true);
	      lblNewLabel_2_1_1_2_2_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_2_2_1_2.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_2_2_1_2.setBounds(144, 118, 440, 20);
	      panel_1_1_2_1_2_1.add(lblNewLabel_2_1_1_2_2_1_2);
	      
	      JPanel panel_1_1_2_1_2_1_1 = new JPanel();
	      panel_1_1_2_1_2_1_1.setLayout(null);
	      panel_1_1_2_1_2_1_1.setBackground(Color.WHITE);
	      panel_1_1_2_1_2_1_1.setBounds(12, 475, 596, 145);
	      panel_2_1_1_1.add(panel_1_1_2_1_2_1_1);
	      
		  ImageIcon chicon47 = new ImageIcon("src/food/"+o.smf.area+"음식4.jpg");
		  Image chimg47 = chicon47.getImage();
		  Image cchimg47 = chimg47.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		  ImageIcon cchicon47 = new ImageIcon(cchimg47);
	      JLabel lblNewLabel_1_1_2_1_2_1_1 = new JLabel(cchicon47);
	      lblNewLabel_1_1_2_1_2_1_1.setOpaque(true);
	      lblNewLabel_1_1_2_1_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_2_1_1.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_2_1_1.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_2_1_1.add(lblNewLabel_1_1_2_1_2_1_1);
	      
	      JLabel lblNewLabel_2_1_1_1_2_2_1_2_1_1 = new JLabel(food[3][2]);
	      lblNewLabel_2_1_1_1_2_2_1_2_1_1.setOpaque(true);
	      lblNewLabel_2_1_1_1_2_2_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	      lblNewLabel_2_1_1_1_2_2_1_2_1_1.setForeground(Color.RED);
	      lblNewLabel_2_1_1_1_2_2_1_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_1_2_2_1_2_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_2_2_1_2_1_1.setBounds(144, 10, 70, 25);
	      panel_1_1_2_1_2_1_1.add(lblNewLabel_2_1_1_1_2_2_1_2_1_1);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_2_1_1 = new JLabel(food[3][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1_1.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1_1.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1_1.setBounds(144, 85, 440, 25);
	      panel_1_1_2_1_2_1_1.add(lblNewLabel_2_1_1_1_1_1_2_1_2_1_1);
	      
	      JLabel lblNewLabel_2_2_2_1_2_1_1 = new JLabel(food[3][0]);
	      lblNewLabel_2_2_2_1_2_1_1.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_2_1_1.setOpaque(true);
	      lblNewLabel_2_2_2_1_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_2_2_1_2_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_2_1_1.setBounds(144, 48, 358, 20);
	      panel_1_1_2_1_2_1_1.add(lblNewLabel_2_2_2_1_2_1_1);
	      
	      JLabel lblNewLabel_2_1_1_2_2_1_2_1_1 = new JLabel(food[3][3]);
	      lblNewLabel_2_1_1_2_2_1_2_1_1.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_1_1_2_2_1_2_1_1.setOpaque(true);
	      lblNewLabel_2_1_1_2_2_1_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_2_2_1_2_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_2_2_1_2_1_1.setBounds(144, 118, 440, 20);
	      panel_1_1_2_1_2_1_1.add(lblNewLabel_2_1_1_2_2_1_2_1_1);
	      
	      JPanel panel_1_1_2_1_2_1_1_1 = new JPanel();
	      panel_1_1_2_1_2_1_1_1.setLayout(null);
	      panel_1_1_2_1_2_1_1_1.setBackground(Color.WHITE);
	      panel_1_1_2_1_2_1_1_1.setBounds(12, 630, 596, 145);
	      panel_2_1_1_1.add(panel_1_1_2_1_2_1_1_1);
	      
		  ImageIcon chicon48 = new ImageIcon("src/food/"+o.smf.area+"음식5.jpg");
		  Image chimg48 = chicon48.getImage();
		  Image cchimg48 = chimg48.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		  ImageIcon cchicon48 = new ImageIcon(cchimg48);
	      JLabel lblNewLabel_1_1_2_1_2_1_1_1 = new JLabel(cchicon48);
	      lblNewLabel_1_1_2_1_2_1_1_1.setOpaque(true);
	      lblNewLabel_1_1_2_1_2_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_2_1_1_1.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_2_1_1_1.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_2_1_1_1.add(lblNewLabel_1_1_2_1_2_1_1_1);
	      
	      JLabel lblNewLabel_2_1_1_1_2_2_1_2_1_1_1 = new JLabel(food[4][2]);
	      lblNewLabel_2_1_1_1_2_2_1_2_1_1_1.setOpaque(true);
	      lblNewLabel_2_1_1_1_2_2_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	      lblNewLabel_2_1_1_1_2_2_1_2_1_1_1.setForeground(Color.RED);
	      lblNewLabel_2_1_1_1_2_2_1_2_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_1_2_2_1_2_1_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_2_2_1_2_1_1_1.setBounds(144, 10, 70, 25);
	      panel_1_1_2_1_2_1_1_1.add(lblNewLabel_2_1_1_1_2_2_1_2_1_1_1);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_2_1_1_1 = new JLabel(food[4][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1_1_1.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1_1_1.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_1_1_1.setBounds(144, 85, 440, 25);
	      panel_1_1_2_1_2_1_1_1.add(lblNewLabel_2_1_1_1_1_1_2_1_2_1_1_1);
	      
	      JLabel lblNewLabel_2_2_2_1_2_1_1_1 = new JLabel(food[4][0]);
	      lblNewLabel_2_2_2_1_2_1_1_1.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_2_1_1_1.setOpaque(true);
	      lblNewLabel_2_2_2_1_2_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_2_2_1_2_1_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_2_1_1_1.setBounds(144, 48, 358, 20);
	      panel_1_1_2_1_2_1_1_1.add(lblNewLabel_2_2_2_1_2_1_1_1);
	      
	      JLabel lblNewLabel_2_1_1_2_2_1_2_1_1_1 = new JLabel(food[4][3]);
	      lblNewLabel_2_1_1_2_2_1_2_1_1_1.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_1_1_2_2_1_2_1_1_1.setOpaque(true);
	      lblNewLabel_2_1_1_2_2_1_2_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_2_1_1_2_2_1_2_1_1_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_2_2_1_2_1_1_1.setBounds(144, 118, 440, 20);
	      panel_1_1_2_1_2_1_1_1.add(lblNewLabel_2_1_1_2_2_1_2_1_1_1);
	      
	      JPanel panel_2_1_1_2 = new JPanel();
	      panel_2_1_1_2.setVisible(false);
	      panel_2_1_1_2.setLayout(null);
	      panel_2_1_1_2.setBackground(Color.WHITE);
	      
	      JPanel panel_1_1_2_1_3 = new JPanel();
	      panel_1_1_2_1_3.setLayout(null);
	      panel_1_1_2_1_3.setBackground(Color.WHITE);
	      panel_1_1_2_1_3.setBounds(12, 10, 596, 145);
	      panel_2_1_1_2.add(panel_1_1_2_1_3);
	      
	      /////////////////////관광지
	      ImageIcon chicon1 = new ImageIcon("src/place/"+o.smf.area+"관광지1.jpg");
	      Image chimg1 = chicon1.getImage();
	      Image cchimg1 = chimg1.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	      ImageIcon cchicon1 = new ImageIcon(cchimg1);
	      JLabel lblNewLabel_1_1_2_1_3 = new JLabel(cchicon1);
	      lblNewLabel_1_1_2_1_3.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_3.setBounds(12, 10, 120, 124);
	      lblNewLabel_1_1_2_1_3.setOpaque(true);
	      panel_1_1_2_1_3.add(lblNewLabel_1_1_2_1_3);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_3 = new JLabel(placey[0][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_3.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_3.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_3.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
	      lblNewLabel_2_1_1_1_1_1_2_1_3.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_3.setBounds(144, 50, 440, 44);
	      panel_1_1_2_1_3.add(lblNewLabel_2_1_1_1_1_1_2_1_3);
	      
	      JLabel lblNewLabel_2_2_2_1_3 = new JLabel(placey[0][0]);
	      lblNewLabel_2_2_2_1_3.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_3.setOpaque(true);
	      lblNewLabel_2_2_2_1_3.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
	      lblNewLabel_2_2_2_1_3.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_3.setBounds(144, 10, 358, 30);
	      panel_1_1_2_1_3.add(lblNewLabel_2_2_2_1_3);
	      
	      JPanel panel_1_1_2_1_1_2 = new JPanel();
	      panel_1_1_2_1_1_2.setLayout(null);
	      panel_1_1_2_1_1_2.setBackground(Color.WHITE);
	      panel_1_1_2_1_1_2.setBounds(12, 165, 596, 145);
	      panel_2_1_1_2.add(panel_1_1_2_1_1_2);
	      
	      ImageIcon chicon2 = new ImageIcon("src/place/"+o.smf.area+"관광지2.jpg");
	      Image chimg2 = chicon2.getImage();
	      Image cchimg2 = chimg2.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	      ImageIcon cchicon2 = new ImageIcon(cchimg2);
	      JLabel lblNewLabel_1_1_2_1_1_2 = new JLabel(cchicon2);
	      lblNewLabel_1_1_2_1_1_2.setOpaque(true);
	      lblNewLabel_1_1_2_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_1_2.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_1_2.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_1_2.add(lblNewLabel_1_1_2_1_1_2);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_1_2 = new JLabel(placey[1][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_1_2.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_1_2.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
	      lblNewLabel_2_1_1_1_1_1_2_1_1_2.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_1_2.setBounds(144, 50, 440, 44);
	      panel_1_1_2_1_1_2.add(lblNewLabel_2_1_1_1_1_1_2_1_1_2);
	      
	      JLabel lblNewLabel_2_2_2_1_1_2 = new JLabel(placey[1][0]);
	      lblNewLabel_2_2_2_1_1_2.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_1_2.setOpaque(true);
	      lblNewLabel_2_2_2_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
	      lblNewLabel_2_2_2_1_1_2.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_1_2.setBounds(144, 10, 358, 30);
	      panel_1_1_2_1_1_2.add(lblNewLabel_2_2_2_1_1_2);
	      
	      JPanel panel_1_1_2_1_2_2 = new JPanel();
	      panel_1_1_2_1_2_2.setLayout(null);
	      panel_1_1_2_1_2_2.setBackground(Color.WHITE);
	      panel_1_1_2_1_2_2.setBounds(12, 320, 596, 145);
	      panel_2_1_1_2.add(panel_1_1_2_1_2_2);
	      
	      ImageIcon chicon3 = new ImageIcon("src/place/"+o.smf.area+"관광지3.jpg");
	      Image chimg3 = chicon3.getImage();
	      Image cchimg3 = chimg3.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	      ImageIcon cchicon3 = new ImageIcon(cchimg3);
	      JLabel lblNewLabel_1_1_2_1_2_2 = new JLabel(cchicon3);
	      lblNewLabel_1_1_2_1_2_2.setOpaque(true);
	      lblNewLabel_1_1_2_1_2_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_2_2.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_2_2.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_2_2.add(lblNewLabel_1_1_2_1_2_2);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_2_2 = new JLabel(placey[2][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_2.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_2.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
	      lblNewLabel_2_1_1_1_1_1_2_1_2_2.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_2_2.setBounds(144, 50, 440, 44);
	      panel_1_1_2_1_2_2.add(lblNewLabel_2_1_1_1_1_1_2_1_2_2);
	      
	      JLabel lblNewLabel_2_2_2_1_2_2 = new JLabel(placey[2][0]);
	      lblNewLabel_2_2_2_1_2_2.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_2_2.setOpaque(true);
	      lblNewLabel_2_2_2_1_2_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
	      lblNewLabel_2_2_2_1_2_2.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_2_2.setBounds(144, 10, 358, 30);
	      panel_1_1_2_1_2_2.add(lblNewLabel_2_2_2_1_2_2);
	      
	      JPanel panel_1_1_2_1_3_1 = new JPanel();
	      panel_1_1_2_1_3_1.setLayout(null);
	      panel_1_1_2_1_3_1.setBackground(Color.WHITE);
	      panel_1_1_2_1_3_1.setBounds(12, 475, 596, 145);
	      panel_2_1_1_2.add(panel_1_1_2_1_3_1);
	      
	      ImageIcon chicon4 = new ImageIcon("src/place/"+o.smf.area+"관광지4.jpg");
	      Image chimg4 = chicon4.getImage();
	      Image cchimg4 = chimg4.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	      ImageIcon cchicon4 = new ImageIcon(cchimg4);
	      JLabel lblNewLabel_1_1_2_1_3_1 = new JLabel(cchicon4);
	      lblNewLabel_1_1_2_1_3_1.setOpaque(true);
	      lblNewLabel_1_1_2_1_3_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_3_1.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_3_1.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_3_1.add(lblNewLabel_1_1_2_1_3_1);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_3_1 = new JLabel(placey[3][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_3_1.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_3_1.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_3_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
	      lblNewLabel_2_1_1_1_1_1_2_1_3_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_3_1.setBounds(144, 50, 440, 44);
	      panel_1_1_2_1_3_1.add(lblNewLabel_2_1_1_1_1_1_2_1_3_1);
	      
	      JLabel lblNewLabel_2_2_2_1_3_1 = new JLabel(placey[3][0]);
	      lblNewLabel_2_2_2_1_3_1.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_3_1.setOpaque(true);
	      lblNewLabel_2_2_2_1_3_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
	      lblNewLabel_2_2_2_1_3_1.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_3_1.setBounds(144, 10, 358, 30);
	      panel_1_1_2_1_3_1.add(lblNewLabel_2_2_2_1_3_1);
	      
	      JPanel panel_1_1_2_1_4 = new JPanel();
	      panel_1_1_2_1_4.setLayout(null);
	      panel_1_1_2_1_4.setBackground(Color.WHITE);
	      panel_1_1_2_1_4.setBounds(12, 630, 596, 145);
	      panel_2_1_1_2.add(panel_1_1_2_1_4);
	      
	      ImageIcon chicon5 = new ImageIcon("src/place/"+o.smf.area+"관광지5.jpg");
	      Image chimg5 = chicon5.getImage();
	      Image cchimg5 = chimg5.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	      ImageIcon cchicon5 = new ImageIcon(cchimg5);
	      JLabel lblNewLabel_1_1_2_1_4 = new JLabel(cchicon5);
	      lblNewLabel_1_1_2_1_4.setOpaque(true);
	      lblNewLabel_1_1_2_1_4.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_4.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_4.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_4.add(lblNewLabel_1_1_2_1_4);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_4 = new JLabel(placey[4][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_4.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_4.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_4.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
	      lblNewLabel_2_1_1_1_1_1_2_1_4.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_4.setBounds(144, 50, 440, 44);
	      panel_1_1_2_1_4.add(lblNewLabel_2_1_1_1_1_1_2_1_4);
	      
	      JLabel lblNewLabel_2_2_2_1_4 = new JLabel(placey[4][0]);
	      lblNewLabel_2_2_2_1_4.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_4.setOpaque(true);
	      lblNewLabel_2_2_2_1_4.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
	      lblNewLabel_2_2_2_1_4.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_4.setBounds(144, 10, 358, 30);
	      panel_1_1_2_1_4.add(lblNewLabel_2_2_2_1_4);
	      
	      JPanel panel_1_1_2_1_4_1 = new JPanel();
	      panel_1_1_2_1_4_1.setLayout(null);
	      panel_1_1_2_1_4_1.setBackground(Color.WHITE);
	      panel_1_1_2_1_4_1.setBounds(12, 785, 596, 145);
	      panel_2_1_1_2.add(panel_1_1_2_1_4_1);
	      
	      ImageIcon chicon6 = new ImageIcon("src/place/"+o.smf.area+"관광지6.jpg");
	      Image chimg6 = chicon6.getImage();
	      Image cchimg6 = chimg6.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	      ImageIcon cchicon6 = new ImageIcon(cchimg6);
	      JLabel lblNewLabel_1_1_2_1_4_1 = new JLabel(cchicon6);
	      lblNewLabel_1_1_2_1_4_1.setOpaque(true);
	      lblNewLabel_1_1_2_1_4_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_4_1.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_4_1.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_4_1.add(lblNewLabel_1_1_2_1_4_1);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_4_1 = new JLabel(placey[5][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_1.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_1.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
	      lblNewLabel_2_1_1_1_1_1_2_1_4_1.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_1.setBounds(144, 50, 440, 44);
	      panel_1_1_2_1_4_1.add(lblNewLabel_2_1_1_1_1_1_2_1_4_1);
	      
	      JLabel lblNewLabel_2_2_2_1_4_1 = new JLabel(placey[5][0]);
	      lblNewLabel_2_2_2_1_4_1.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_4_1.setOpaque(true);
	      lblNewLabel_2_2_2_1_4_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
	      lblNewLabel_2_2_2_1_4_1.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_4_1.setBounds(144, 10, 358, 30);
	      panel_1_1_2_1_4_1.add(lblNewLabel_2_2_2_1_4_1);
	      
	      JPanel panel_1_1_2_1_4_2 = new JPanel();
	      panel_1_1_2_1_4_2.setLayout(null);
	      panel_1_1_2_1_4_2.setBackground(Color.WHITE);
	      panel_1_1_2_1_4_2.setBounds(12, 940, 596, 145);
	      panel_2_1_1_2.add(panel_1_1_2_1_4_2);
	      
	      ImageIcon chicon7 = new ImageIcon("src/place/"+o.smf.area+"관광지7.jpg");
	      Image chimg7 = chicon7.getImage();
	      Image cchimg7 = chimg7.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	      ImageIcon cchicon7 = new ImageIcon(cchimg7);
	      JLabel lblNewLabel_1_1_2_1_4_2 = new JLabel(cchicon7);
	      lblNewLabel_1_1_2_1_4_2.setOpaque(true);
	      lblNewLabel_1_1_2_1_4_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_4_2.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_4_2.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_4_2.add(lblNewLabel_1_1_2_1_4_2);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_4_2 = new JLabel(placey[6][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_2.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_2.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
	      lblNewLabel_2_1_1_1_1_1_2_1_4_2.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_2.setBounds(144, 50, 440, 44);
	      panel_1_1_2_1_4_2.add(lblNewLabel_2_1_1_1_1_1_2_1_4_2);
	      
	      JLabel lblNewLabel_2_2_2_1_4_2 = new JLabel(placey[6][0]);
	      lblNewLabel_2_2_2_1_4_2.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_4_2.setOpaque(true);
	      lblNewLabel_2_2_2_1_4_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
	      lblNewLabel_2_2_2_1_4_2.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_4_2.setBounds(144, 10, 358, 30);
	      panel_1_1_2_1_4_2.add(lblNewLabel_2_2_2_1_4_2);
	      
	      JPanel panel_1_1_2_1_4_3 = new JPanel();
	      panel_1_1_2_1_4_3.setLayout(null);
	      panel_1_1_2_1_4_3.setBackground(Color.WHITE);
	      panel_1_1_2_1_4_3.setBounds(12, 1095, 596, 145);
	      panel_2_1_1_2.add(panel_1_1_2_1_4_3);
	      
	      ImageIcon chicon8 = new ImageIcon("src/place/"+o.smf.area+"관광지8.jpg");
	      Image chimg8 = chicon8.getImage();
	      Image cchimg8 = chimg8.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	      ImageIcon cchicon8 = new ImageIcon(cchimg8);
	      JLabel lblNewLabel_1_1_2_1_4_3 = new JLabel(cchicon8);
	      lblNewLabel_1_1_2_1_4_3.setOpaque(true);
	      lblNewLabel_1_1_2_1_4_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_4_3.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_4_3.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_4_3.add(lblNewLabel_1_1_2_1_4_3);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_4_3 = new JLabel(placey[7][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_3.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_3.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_3.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
	      lblNewLabel_2_1_1_1_1_1_2_1_4_3.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_3.setBounds(144, 50, 440, 44);
	      panel_1_1_2_1_4_3.add(lblNewLabel_2_1_1_1_1_1_2_1_4_3);
	      
	      JLabel lblNewLabel_2_2_2_1_4_3 = new JLabel(placey[7][0]);
	      lblNewLabel_2_2_2_1_4_3.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_4_3.setOpaque(true);
	      lblNewLabel_2_2_2_1_4_3.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
	      lblNewLabel_2_2_2_1_4_3.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_4_3.setBounds(144, 10, 358, 30);
	      panel_1_1_2_1_4_3.add(lblNewLabel_2_2_2_1_4_3);
	      
	      JPanel panel_1_1_2_1_4_4 = new JPanel();
	      panel_1_1_2_1_4_4.setLayout(null);
	      panel_1_1_2_1_4_4.setBackground(Color.WHITE);
	      panel_1_1_2_1_4_4.setBounds(12, 1250, 596, 145);
	      panel_2_1_1_2.add(panel_1_1_2_1_4_4);
	      
	      ImageIcon chicon9 = new ImageIcon("src/place/"+o.smf.area+"관광지9.jpg");
	      Image chimg9 = chicon9.getImage();
	      Image cchimg9 = chimg9.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	      ImageIcon cchicon9 = new ImageIcon(cchimg9);
	      JLabel lblNewLabel_1_1_2_1_4_4 = new JLabel(cchicon9);
	      lblNewLabel_1_1_2_1_4_4.setOpaque(true);
	      lblNewLabel_1_1_2_1_4_4.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_4_4.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_4_4.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_4_4.add(lblNewLabel_1_1_2_1_4_4);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_4_4 = new JLabel(placey[8][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_4.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_4.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_4.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
	      lblNewLabel_2_1_1_1_1_1_2_1_4_4.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_4.setBounds(144, 50, 440, 44);
	      panel_1_1_2_1_4_4.add(lblNewLabel_2_1_1_1_1_1_2_1_4_4);
	      
	      JLabel lblNewLabel_2_2_2_1_4_4 = new JLabel(placey[8][0]);
	      lblNewLabel_2_2_2_1_4_4.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_4_4.setOpaque(true);
	      lblNewLabel_2_2_2_1_4_4.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
	      lblNewLabel_2_2_2_1_4_4.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_4_4.setBounds(144, 10, 358, 30);
	      panel_1_1_2_1_4_4.add(lblNewLabel_2_2_2_1_4_4);
	      
	      JPanel panel_1_1_2_1_4_5 = new JPanel();
	      panel_1_1_2_1_4_5.setLayout(null);
	      panel_1_1_2_1_4_5.setBackground(Color.WHITE);
	      panel_1_1_2_1_4_5.setBounds(12, 1405, 596, 145);
	      panel_2_1_1_2.add(panel_1_1_2_1_4_5);
	      
	      ImageIcon chicon10 = new ImageIcon("src/place/"+o.smf.area+"관광지10.jpg");
	      Image chimg10 = chicon10.getImage();
	      Image cchimg10 = chimg10.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	      ImageIcon cchicon10 = new ImageIcon(cchimg10);
	      JLabel lblNewLabel_1_1_2_1_4_5 = new JLabel(cchicon10);
	      lblNewLabel_1_1_2_1_4_5.setOpaque(true);
	      lblNewLabel_1_1_2_1_4_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
	      lblNewLabel_1_1_2_1_4_5.setBackground(Color.WHITE);
	      lblNewLabel_1_1_2_1_4_5.setBounds(12, 10, 120, 124);
	      panel_1_1_2_1_4_5.add(lblNewLabel_1_1_2_1_4_5);
	      
	      JLabel lblNewLabel_2_1_1_1_1_1_2_1_4_5 = new JLabel(placey[9][1]);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_5.setForeground(Color.ORANGE);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_5.setOpaque(true);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_5.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
	      lblNewLabel_2_1_1_1_1_1_2_1_4_5.setBackground(Color.WHITE);
	      lblNewLabel_2_1_1_1_1_1_2_1_4_5.setBounds(144, 50, 440, 44);
	      panel_1_1_2_1_4_5.add(lblNewLabel_2_1_1_1_1_1_2_1_4_5);
	      
	      JLabel lblNewLabel_2_2_2_1_4_5 = new JLabel(placey[9][0]);
	      lblNewLabel_2_2_2_1_4_5.setForeground(new Color(255, 192, 203));
	      lblNewLabel_2_2_2_1_4_5.setOpaque(true);
	      lblNewLabel_2_2_2_1_4_5.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
	      lblNewLabel_2_2_2_1_4_5.setBackground(Color.WHITE);
	      lblNewLabel_2_2_2_1_4_5.setBounds(144, 10, 358, 30);
	      panel_1_1_2_1_4_5.add(lblNewLabel_2_2_2_1_4_5);
	      
	      JPanel panel_2_1_1_3 = new JPanel();
	      panel_2_1_1_3.setVisible(false);
	      panel_2_1_1_3.setBackground(Color.WHITE);
	      panel_2_1_1_3.setLayout(null);
	      
	      JPanel panel_1_1_2_1_5 = new JPanel();
	      panel_1_1_2_1_5.setBounds(12, 10, 596, 145);
	      panel_1_1_2_1_5.setLayout(null);
	      panel_1_1_2_1_5.setBackground(Color.WHITE);
	      panel_2_1_1_3.add(panel_1_1_2_1_5);

		//////////////////////축제
	    ImageIcon chicon11 = new ImageIcon("src/festival/"+o.smf.area+"축제1.jpg");
	    Image chimg11 = chicon11.getImage();
	    Image cchimg11 = chimg11.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon11 = new ImageIcon(cchimg11);
		JLabel lblNewLabel_1_1_2_1_5 = new JLabel(cchicon11);
		lblNewLabel_1_1_2_1_5.setOpaque(true);
		lblNewLabel_1_1_2_1_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_1_5.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_1_5.setBounds(12, 10, 120, 124);
		panel_1_1_2_1_5.add(lblNewLabel_1_1_2_1_5);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_1_5 = new JLabel(festival[0][1]);
		lblNewLabel_2_1_1_1_1_1_2_1_5.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_1_5.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_1_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_1_5.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_1_5.setBounds(144, 40, 440, 44);
		panel_1_1_2_1_5.add(lblNewLabel_2_1_1_1_1_1_2_1_5);
		
		JLabel lblNewLabel_2_2_2_1_5 = new JLabel(festival[0][0]);
		lblNewLabel_2_2_2_1_5.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_1_5.setOpaque(true);
		lblNewLabel_2_2_2_1_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_1_5.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_1_5.setBounds(144, 10, 358, 30);
		panel_1_1_2_1_5.add(lblNewLabel_2_2_2_1_5);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_1_1_3 = new JLabel(festival[0][2]);
		lblNewLabel_2_1_1_1_1_1_2_1_1_3.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_1_2_1_1_3.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_1_1_3.setBounds(144, 89, 440, 44);
		panel_1_1_2_1_5.add(lblNewLabel_2_1_1_1_1_1_2_1_1_3);
		
		JPanel panel_1_1_2_1_1_3 = new JPanel();
		panel_1_1_2_1_1_3.setBounds(12, 165, 596, 145);
		panel_1_1_2_1_1_3.setLayout(null);
		panel_1_1_2_1_1_3.setBackground(Color.WHITE);
		panel_2_1_1_3.add(panel_1_1_2_1_1_3);
		
	    ImageIcon chicon12 = new ImageIcon("src/festival/"+o.smf.area+"축제2.jpg");
	    Image chimg12 = chicon12.getImage();
	    Image cchimg12 = chimg12.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon12 = new ImageIcon(cchimg12);
		JLabel lblNewLabel_1_1_2_1_1_3 = new JLabel(cchicon12);
		lblNewLabel_1_1_2_1_1_3.setOpaque(true);
		lblNewLabel_1_1_2_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_1_1_3.setBounds(12, 10, 120, 124);
		panel_1_1_2_1_1_3.add(lblNewLabel_1_1_2_1_1_3);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_1_2_3 = new JLabel(festival[1][1]);
		lblNewLabel_2_1_1_1_1_1_2_1_2_3.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_1_2_3.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_1_2_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_1_2_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_1_2_3.setBounds(144, 40, 440, 44);
		panel_1_1_2_1_1_3.add(lblNewLabel_2_1_1_1_1_1_2_1_2_3);
		
		JLabel lblNewLabel_2_2_2_1_1_3 = new JLabel(festival[1][0]);
		lblNewLabel_2_2_2_1_1_3.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_1_1_3.setOpaque(true);
		lblNewLabel_2_2_2_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_1_1_3.setBounds(144, 10, 358, 30);
		panel_1_1_2_1_1_3.add(lblNewLabel_2_2_2_1_1_3);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_1_1_1_1 = new JLabel(festival[1][2]);
		lblNewLabel_2_1_1_1_1_1_2_1_1_1_1.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_1_2_1_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_1_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_1_1_1_1.setBounds(144, 89, 440, 44);
		panel_1_1_2_1_1_3.add(lblNewLabel_2_1_1_1_1_1_2_1_1_1_1);
		
		JPanel panel_1_1_2_1_2_3 = new JPanel();
		panel_1_1_2_1_2_3.setBounds(12, 320, 596, 145);
		panel_1_1_2_1_2_3.setLayout(null);
		panel_1_1_2_1_2_3.setBackground(Color.WHITE);
		panel_2_1_1_3.add(panel_1_1_2_1_2_3);
		
	    ImageIcon chicon13 = new ImageIcon("src/festival/"+o.smf.area+"축제3.jpg");
	    Image chimg13 = chicon13.getImage();
	    Image cchimg13 = chimg13.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon13 = new ImageIcon(cchimg13);
		JLabel lblNewLabel_1_1_2_1_2_3 = new JLabel(cchicon13);
		lblNewLabel_1_1_2_1_2_3.setOpaque(true);
		lblNewLabel_1_1_2_1_2_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_1_2_3.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_1_2_3.setBounds(12, 10, 120, 124);
		panel_1_1_2_1_2_3.add(lblNewLabel_1_1_2_1_2_3);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_1_3_2 = new JLabel(festival[2][1]);
		lblNewLabel_2_1_1_1_1_1_2_1_3_2.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_1_3_2.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_1_3_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_1_3_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_1_3_2.setBounds(144, 40, 440, 44);
		panel_1_1_2_1_2_3.add(lblNewLabel_2_1_1_1_1_1_2_1_3_2);
		
		JLabel lblNewLabel_2_2_2_1_2_3 = new JLabel(festival[2][0]);
		lblNewLabel_2_2_2_1_2_3.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_1_2_3.setOpaque(true);
		lblNewLabel_2_2_2_1_2_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_1_2_3.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_1_2_3.setBounds(144, 10, 358, 30);
		panel_1_1_2_1_2_3.add(lblNewLabel_2_2_2_1_2_3);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_1_1_2_1 = new JLabel(festival[2][2]);
		lblNewLabel_2_1_1_1_1_1_2_1_1_2_1.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_1_2_1_1_2_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_1_1_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_1_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_1_1_2_1.setBounds(144, 89, 440, 44);
		panel_1_1_2_1_2_3.add(lblNewLabel_2_1_1_1_1_1_2_1_1_2_1);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setVisible(false);
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBackground(Color.WHITE);
		
		JPanel panel_1_1_2_5 = new JPanel();
		panel_1_1_2_5.setLayout(null);
		panel_1_1_2_5.setBackground(Color.WHITE);
		panel_1_1_2_5.setBounds(12, 10, 596, 145);
		panel_2_1_2.add(panel_1_1_2_5);
		
		//////////////////////모텔
	    ImageIcon chicon14 = new ImageIcon("src/motel/"+o.smf.area+"모텔0번째.jpg");
	    Image chimg14 = chicon14.getImage();
	    Image cchimg14 = chimg14.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon14 = new ImageIcon(cchimg14);
		JLabel lblNewLabel_1_1_2_5 = new JLabel(cchicon14);
		lblNewLabel_1_1_2_5.setOpaque(true);
		lblNewLabel_1_1_2_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_5.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_5.setBounds(12, 10, 120, 124);
		panel_1_1_2_5.add(lblNewLabel_1_1_2_5);
		
		JLabel lblNewLabel_2_1_1_1_2_2_5 = new JLabel(motel[0][2]);
		lblNewLabel_2_1_1_1_2_2_5.setOpaque(true);
		lblNewLabel_2_1_1_1_2_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_2_5.setForeground(Color.RED);
		lblNewLabel_2_1_1_1_2_2_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_2_5.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_2_5.setBounds(144, 10, 70, 25);
		panel_1_1_2_5.add(lblNewLabel_2_1_1_1_2_2_5);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_5 = new JLabel(motel[0][1]);
		lblNewLabel_2_1_1_1_1_1_2_5.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_5.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_5.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_5.setBounds(144, 65 ,440, 20);
		panel_1_1_2_5.add(lblNewLabel_2_1_1_1_1_1_2_5);
		
		JLabel lblNewLabel_2_2_2_5 = new JLabel(motel[0][0]);
		lblNewLabel_2_2_2_5.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_5.setOpaque(true);
		lblNewLabel_2_2_2_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_5.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_5.setBounds(144, 42, 358, 20);
		panel_1_1_2_5.add(lblNewLabel_2_2_2_5);
		
		JLabel lblNewLabel_2_1_1_2_2_6 = new JLabel("대실 : " + motel[0][3]);
		lblNewLabel_2_1_1_2_2_6.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_2_2_6.setOpaque(true);
		lblNewLabel_2_1_1_2_2_6.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_6.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_6.setBounds(144, 90, 440, 20);
		panel_1_1_2_5.add(lblNewLabel_2_1_1_2_2_6);
		
		JLabel lblNewLabel_2_1_1_2_2_1_5 = new JLabel("숙박 : " + motel[0][4]);
		lblNewLabel_2_1_1_2_2_1_5.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_1_5.setOpaque(true);
		lblNewLabel_2_1_1_2_2_1_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_1_5.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_1_5.setBounds(144, 118, 440, 20);
		panel_1_1_2_5.add(lblNewLabel_2_1_1_2_2_1_5);
		
		JPanel panel_1_1_2_1_2 = new JPanel();
		panel_1_1_2_1_2.setLayout(null);
		panel_1_1_2_1_2.setBackground(Color.WHITE);
		panel_1_1_2_1_2.setBounds(12, 165, 596, 145);
		panel_2_1_2.add(panel_1_1_2_1_2);
		
	    ImageIcon chicon15 = new ImageIcon("src/motel/"+o.smf.area+"모텔1번째.jpg");
	    Image chimg15 = chicon15.getImage();
	    Image cchimg15 = chimg15.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon15 = new ImageIcon(cchimg15);
		JLabel lblNewLabel_1_1_2_1_2 = new JLabel(cchicon15);
		lblNewLabel_1_1_2_1_2.setOpaque(true);
		lblNewLabel_1_1_2_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_1_2.setBounds(12, 10, 120, 124);
		panel_1_1_2_1_2.add(lblNewLabel_1_1_2_1_2);
		
		JLabel lblNewLabel_2_1_1_1_2_2_1_2 = new JLabel(motel[1][2]);
		lblNewLabel_2_1_1_1_2_2_1_2.setOpaque(true);
		lblNewLabel_2_1_1_1_2_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_2_1_2.setForeground(Color.RED);
		lblNewLabel_2_1_1_1_2_2_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_2_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_2_1_2.setBounds(144, 10, 70, 25);
		panel_1_1_2_1_2.add(lblNewLabel_2_1_1_1_2_2_1_2);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_1_2 = new JLabel(motel[1][1]);
		lblNewLabel_2_1_1_1_1_1_2_1_2.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_1_2.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_1_2.setBounds(144, 65 ,440, 20);
		panel_1_1_2_1_2.add(lblNewLabel_2_1_1_1_1_1_2_1_2);
		
		JLabel lblNewLabel_2_2_2_1_2 = new JLabel(motel[1][0]);
		lblNewLabel_2_2_2_1_2.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_1_2.setOpaque(true);
		lblNewLabel_2_2_2_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_1_2.setBounds(144, 42, 358, 20);
		panel_1_1_2_1_2.add(lblNewLabel_2_2_2_1_2);
		
		JLabel lblNewLabel_2_1_1_2_2_2_1 = new JLabel("대실 : " + motel[1][3]);
		lblNewLabel_2_1_1_2_2_2_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_2_2_2_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_2_1.setBounds(144, 90, 440, 20);
		panel_1_1_2_1_2.add(lblNewLabel_2_1_1_2_2_2_1);
		
		JLabel lblNewLabel_2_1_1_2_2_1_1_2 = new JLabel("숙박 : " + motel[1][4]);
		lblNewLabel_2_1_1_2_2_1_1_2.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_1_1_2.setOpaque(true);
		lblNewLabel_2_1_1_2_2_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_1_1_2.setBounds(144, 118, 440, 20);
		panel_1_1_2_1_2.add(lblNewLabel_2_1_1_2_2_1_1_2);
		
		JPanel panel_1_1_2_2_1 = new JPanel();
		panel_1_1_2_2_1.setLayout(null);
		panel_1_1_2_2_1.setBackground(Color.WHITE);
		panel_1_1_2_2_1.setBounds(12, 320, 596, 145);
		panel_2_1_2.add(panel_1_1_2_2_1);
		
	    ImageIcon chicon16 = new ImageIcon("src/motel/"+o.smf.area+"모텔2번째.jpg");
	    Image chimg16 = chicon16.getImage();
	    Image cchimg16 = chimg16.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon16 = new ImageIcon(cchimg16);
		JLabel lblNewLabel_1_1_2_2_1 = new JLabel(cchicon16);
		lblNewLabel_1_1_2_2_1.setOpaque(true);
		lblNewLabel_1_1_2_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_2_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_2_1.setBounds(12, 10, 120, 124);
		panel_1_1_2_2_1.add(lblNewLabel_1_1_2_2_1);
		
		JLabel lblNewLabel_2_1_1_1_2_2_2_1 = new JLabel(motel[2][2]);
		lblNewLabel_2_1_1_1_2_2_2_1.setOpaque(true);
		lblNewLabel_2_1_1_1_2_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_2_2_1.setForeground(Color.RED);
		lblNewLabel_2_1_1_1_2_2_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_2_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_2_2_1.setBounds(144, 10, 70, 25);
		panel_1_1_2_2_1.add(lblNewLabel_2_1_1_1_2_2_2_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_2_1 = new JLabel(motel[2][1]);
		lblNewLabel_2_1_1_1_1_1_2_2_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_2_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_2_1.setBounds(144, 65 ,440, 20);
		panel_1_1_2_2_1.add(lblNewLabel_2_1_1_1_1_1_2_2_1);
		
		JLabel lblNewLabel_2_2_2_2_1 = new JLabel(motel[2][0]);
		lblNewLabel_2_2_2_2_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_2_1.setOpaque(true);
		lblNewLabel_2_2_2_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_2_1.setBounds(144, 42, 358, 20);
		panel_1_1_2_2_1.add(lblNewLabel_2_2_2_2_1);
		
		JLabel lblNewLabel_2_1_1_2_2_3_1 = new JLabel("대실 : " + motel[2][3]);
		lblNewLabel_2_1_1_2_2_3_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_2_2_3_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_3_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_3_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_3_1.setBounds(144, 90, 440, 20);
		panel_1_1_2_2_1.add(lblNewLabel_2_1_1_2_2_3_1);
		
		JLabel lblNewLabel_2_1_1_2_2_1_2_1 = new JLabel("숙박 : " + motel[2][4]);
		lblNewLabel_2_1_1_2_2_1_2_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_1_2_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_1_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_1_2_1.setBounds(144, 118, 440, 20);
		panel_1_1_2_2_1.add(lblNewLabel_2_1_1_2_2_1_2_1);
		
		JPanel panel_1_1_2_3_1 = new JPanel();
		panel_1_1_2_3_1.setLayout(null);
		panel_1_1_2_3_1.setBackground(Color.WHITE);
		panel_1_1_2_3_1.setBounds(12, 475, 596, 145);
		panel_2_1_2.add(panel_1_1_2_3_1);
		
	    ImageIcon chicon17 = new ImageIcon("src/motel/"+o.smf.area+"모텔3번째.jpg");
	    Image chimg17 = chicon17.getImage();
	    Image cchimg17 = chimg17.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon17 = new ImageIcon(cchimg17);
		JLabel lblNewLabel_1_1_2_3_1 = new JLabel(cchicon17);
		lblNewLabel_1_1_2_3_1.setOpaque(true);
		lblNewLabel_1_1_2_3_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_3_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_3_1.setBounds(12, 10, 120, 124);
		panel_1_1_2_3_1.add(lblNewLabel_1_1_2_3_1);
		
		JLabel lblNewLabel_2_1_1_1_2_2_3_1 = new JLabel(motel[3][2]);
		lblNewLabel_2_1_1_1_2_2_3_1.setOpaque(true);
		lblNewLabel_2_1_1_1_2_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_2_3_1.setForeground(Color.RED);
		lblNewLabel_2_1_1_1_2_2_3_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_2_3_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_2_3_1.setBounds(144, 10, 70, 25);
		panel_1_1_2_3_1.add(lblNewLabel_2_1_1_1_2_2_3_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_3_1 = new JLabel(motel[3][1]);
		lblNewLabel_2_1_1_1_1_1_2_3_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_3_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_3_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_3_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_3_1.setBounds(144, 65 ,440, 20);
		panel_1_1_2_3_1.add(lblNewLabel_2_1_1_1_1_1_2_3_1);
		
		JLabel lblNewLabel_2_2_2_3_1 = new JLabel(motel[3][0]);
		lblNewLabel_2_2_2_3_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_3_1.setOpaque(true);
		lblNewLabel_2_2_2_3_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_3_1.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_3_1.setBounds(144, 42, 358, 20);
		panel_1_1_2_3_1.add(lblNewLabel_2_2_2_3_1);
		
		JLabel lblNewLabel_2_1_1_2_2_4_1 = new JLabel("대실 : " + motel[3][3]);
		lblNewLabel_2_1_1_2_2_4_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_2_2_4_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_4_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_4_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_4_1.setBounds(144, 90, 440, 20);
		panel_1_1_2_3_1.add(lblNewLabel_2_1_1_2_2_4_1);
		
		JLabel lblNewLabel_2_1_1_2_2_1_3_1 = new JLabel("숙박 : " + motel[3][4]);
		lblNewLabel_2_1_1_2_2_1_3_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_1_3_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_1_3_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_1_3_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_1_3_1.setBounds(144, 118, 440, 20);
		panel_1_1_2_3_1.add(lblNewLabel_2_1_1_2_2_1_3_1);
		
		JPanel panel_1_1_2_4_1 = new JPanel();
		panel_1_1_2_4_1.setLayout(null);
		panel_1_1_2_4_1.setBackground(Color.WHITE);
		panel_1_1_2_4_1.setBounds(12, 630, 596, 145);
		panel_2_1_2.add(panel_1_1_2_4_1);
		
	    ImageIcon chicon18 = new ImageIcon("src/motel/"+o.smf.area+"모텔4번째.jpg");
	    Image chimg18 = chicon18.getImage();
	    Image cchimg18 = chimg18.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon18 = new ImageIcon(cchimg18);
		JLabel lblNewLabel_1_1_2_4_1 = new JLabel(cchicon18);
		lblNewLabel_1_1_2_4_1.setOpaque(true);
		lblNewLabel_1_1_2_4_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_4_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_4_1.setBounds(12, 10, 120, 124);
		panel_1_1_2_4_1.add(lblNewLabel_1_1_2_4_1);
		
		JLabel lblNewLabel_2_1_1_1_2_2_4_1 = new JLabel(motel[4][2]);
		lblNewLabel_2_1_1_1_2_2_4_1.setOpaque(true);
		lblNewLabel_2_1_1_1_2_2_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_2_4_1.setForeground(Color.RED);
		lblNewLabel_2_1_1_1_2_2_4_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_2_4_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_2_4_1.setBounds(144, 10, 70, 25);
		panel_1_1_2_4_1.add(lblNewLabel_2_1_1_1_2_2_4_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_4_1 = new JLabel(motel[4][1]);
		lblNewLabel_2_1_1_1_1_1_2_4_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_4_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_4_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_4_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_4_1.setBounds(144, 65 ,440, 20);
		panel_1_1_2_4_1.add(lblNewLabel_2_1_1_1_1_1_2_4_1);
		
		JLabel lblNewLabel_2_2_2_4_1 = new JLabel(motel[4][0]);
		lblNewLabel_2_2_2_4_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_4_1.setOpaque(true);
		lblNewLabel_2_2_2_4_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_4_1.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_4_1.setBounds(144, 42, 358, 20);
		panel_1_1_2_4_1.add(lblNewLabel_2_2_2_4_1);
		
		JLabel lblNewLabel_2_1_1_2_2_5_1 = new JLabel("대실 : " + motel[4][3]);
		lblNewLabel_2_1_1_2_2_5_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_2_2_5_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_5_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_5_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_5_1.setBounds(144, 90, 440, 20);
		panel_1_1_2_4_1.add(lblNewLabel_2_1_1_2_2_5_1);
		
		JLabel lblNewLabel_2_1_1_2_2_1_4_1 = new JLabel("숙박 : " + motel[4][4]);
		lblNewLabel_2_1_1_2_2_1_4_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_1_4_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_1_4_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_1_4_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_1_4_1.setBounds(144, 118, 440, 20);
		panel_1_1_2_4_1.add(lblNewLabel_2_1_1_2_2_1_4_1);
		
		JPanel panel_1_1_2_5_1 = new JPanel();
		panel_1_1_2_5_1.setLayout(null);
		panel_1_1_2_5_1.setBackground(Color.WHITE);
		panel_1_1_2_5_1.setBounds(12, 785, 596, 145);
		panel_2_1_2.add(panel_1_1_2_5_1);
		
	    ImageIcon chicon19 = new ImageIcon("src/motel/"+o.smf.area+"모텔5번째.jpg");
	    Image chimg19 = chicon19.getImage();
	    Image cchimg19 = chimg19.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon19 = new ImageIcon(cchimg19);
		JLabel lblNewLabel_1_1_2_5_1 = new JLabel(cchicon19);
		lblNewLabel_1_1_2_5_1.setOpaque(true);
		lblNewLabel_1_1_2_5_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_5_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_5_1.setBounds(12, 10, 120, 124);
		panel_1_1_2_5_1.add(lblNewLabel_1_1_2_5_1);
		
		JLabel lblNewLabel_2_1_1_1_2_2_5_1 = new JLabel(motel[5][2]);
		lblNewLabel_2_1_1_1_2_2_5_1.setOpaque(true);
		lblNewLabel_2_1_1_1_2_2_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_2_5_1.setForeground(Color.RED);
		lblNewLabel_2_1_1_1_2_2_5_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_2_5_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_2_5_1.setBounds(144, 10, 70, 25);
		panel_1_1_2_5_1.add(lblNewLabel_2_1_1_1_2_2_5_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_5_1 = new JLabel(motel[5][1]);
		lblNewLabel_2_1_1_1_1_1_2_5_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_5_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_5_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_5_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_5_1.setBounds(144, 65 ,440, 20);
		panel_1_1_2_5_1.add(lblNewLabel_2_1_1_1_1_1_2_5_1);
		
		JLabel lblNewLabel_2_2_2_5_1 = new JLabel(motel[5][0]);
		lblNewLabel_2_2_2_5_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_5_1.setOpaque(true);
		lblNewLabel_2_2_2_5_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_5_1.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_5_1.setBounds(144, 42, 358, 20);
		panel_1_1_2_5_1.add(lblNewLabel_2_2_2_5_1);
		
		JLabel lblNewLabel_2_1_1_2_2_6_1 = new JLabel("대실 : " + motel[5][3]);
		lblNewLabel_2_1_1_2_2_6_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_2_2_6_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_6_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_6_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_6_1.setBounds(144, 90, 440, 20);
		panel_1_1_2_5_1.add(lblNewLabel_2_1_1_2_2_6_1);
		
		JLabel lblNewLabel_2_1_1_2_2_1_5_1 = new JLabel("숙박 : " + motel[5][4]);
		lblNewLabel_2_1_1_2_2_1_5_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_1_5_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_1_5_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_1_5_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_1_5_1.setBounds(144, 118, 440, 20);
		panel_1_1_2_5_1.add(lblNewLabel_2_1_1_2_2_1_5_1);
		
		JPanel panel_1_1_2_5_1_1 = new JPanel();
		panel_1_1_2_5_1_1.setLayout(null);
		panel_1_1_2_5_1_1.setBackground(Color.WHITE);
		panel_1_1_2_5_1_1.setBounds(12, 940, 596, 145);
		panel_2_1_2.add(panel_1_1_2_5_1_1);
		
	    ImageIcon chicon20 = new ImageIcon("src/motel/"+o.smf.area+"모텔6번째.jpg");
	    Image chimg20 = chicon20.getImage();
	    Image cchimg20 = chimg20.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon20 = new ImageIcon(cchimg20);
		JLabel lblNewLabel_1_1_2_5_1_1 = new JLabel(cchicon20);
		lblNewLabel_1_1_2_5_1_1.setOpaque(true);
		lblNewLabel_1_1_2_5_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_5_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_5_1_1.setBounds(12, 10, 120, 124);
		panel_1_1_2_5_1_1.add(lblNewLabel_1_1_2_5_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2_2_5_1_1 = new JLabel(motel[6][2]);
		lblNewLabel_2_1_1_1_2_2_5_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_2_2_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_2_5_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1_1_2_2_5_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_2_5_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_2_5_1_1.setBounds(144, 10, 70, 25);
		panel_1_1_2_5_1_1.add(lblNewLabel_2_1_1_1_2_2_5_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_5_1_1 = new JLabel(motel[6][1]);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_5_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1.setBounds(144, 65 ,440, 20);
		panel_1_1_2_5_1_1.add(lblNewLabel_2_1_1_1_1_1_2_5_1_1);
		
		JLabel lblNewLabel_2_2_2_5_1_1 = new JLabel(motel[6][0]);
		lblNewLabel_2_2_2_5_1_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_5_1_1.setOpaque(true);
		lblNewLabel_2_2_2_5_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_5_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_5_1_1.setBounds(144, 42, 358, 20);
		panel_1_1_2_5_1_1.add(lblNewLabel_2_2_2_5_1_1);
		
		JLabel lblNewLabel_2_1_1_2_2_6_1_1 = new JLabel("대실 : " + motel[6][3]);
		lblNewLabel_2_1_1_2_2_6_1_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_2_2_6_1_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_6_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_6_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_6_1_1.setBounds(144, 90, 440, 20);
		panel_1_1_2_5_1_1.add(lblNewLabel_2_1_1_2_2_6_1_1);
		
		JLabel lblNewLabel_2_1_1_2_2_1_5_1_1 = new JLabel("숙박 : " + motel[6][4]);
		lblNewLabel_2_1_1_2_2_1_5_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_1_5_1_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_1_5_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_1_5_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_1_5_1_1.setBounds(144, 118, 440, 20);
		panel_1_1_2_5_1_1.add(lblNewLabel_2_1_1_2_2_1_5_1_1);
		
		JPanel panel_1_1_2_5_1_1_1 = new JPanel();
		panel_1_1_2_5_1_1_1.setLayout(null);
		panel_1_1_2_5_1_1_1.setBackground(Color.WHITE);
		panel_1_1_2_5_1_1_1.setBounds(12, 1095, 596, 145);
		panel_2_1_2.add(panel_1_1_2_5_1_1_1);
		
	    ImageIcon chicon21 = new ImageIcon("src/motel/"+o.smf.area+"모텔7번째.jpg");
	    Image chimg21 = chicon21.getImage();
	    Image cchimg21 = chimg21.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon21 = new ImageIcon(cchimg21);
		JLabel lblNewLabel_1_1_2_5_1_1_1 = new JLabel(cchicon21);
		lblNewLabel_1_1_2_5_1_1_1.setOpaque(true);
		lblNewLabel_1_1_2_5_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_5_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_5_1_1_1.setBounds(12, 10, 120, 124);
		panel_1_1_2_5_1_1_1.add(lblNewLabel_1_1_2_5_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2_2_5_1_1_1 = new JLabel(motel[7][2]);
		lblNewLabel_2_1_1_1_2_2_5_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_2_2_5_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_2_5_1_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1_1_2_2_5_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_2_5_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_2_5_1_1_1.setBounds(144, 10, 70, 25);
		panel_1_1_2_5_1_1_1.add(lblNewLabel_2_1_1_1_2_2_5_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_5_1_1_1 = new JLabel(motel[7][1]);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_1.setBounds(144, 65 ,440, 20);
		panel_1_1_2_5_1_1_1.add(lblNewLabel_2_1_1_1_1_1_2_5_1_1_1);
		
		JLabel lblNewLabel_2_2_2_5_1_1_1 = new JLabel(motel[7][0]);
		lblNewLabel_2_2_2_5_1_1_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_5_1_1_1.setOpaque(true);
		lblNewLabel_2_2_2_5_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_5_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_5_1_1_1.setBounds(144, 42, 358, 20);
		panel_1_1_2_5_1_1_1.add(lblNewLabel_2_2_2_5_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2_2_6_1_1_1 = new JLabel("대실 : " + motel[7][3]);
		lblNewLabel_2_1_1_2_2_6_1_1_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_2_2_6_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_6_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_6_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_6_1_1_1.setBounds(144, 90, 440, 20);
		panel_1_1_2_5_1_1_1.add(lblNewLabel_2_1_1_2_2_6_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2_2_1_5_1_1_1 = new JLabel("숙박 : " + motel[7][4]);
		lblNewLabel_2_1_1_2_2_1_5_1_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_1_5_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_1_5_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_1_5_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_1_5_1_1_1.setBounds(144, 118, 440, 20);
		panel_1_1_2_5_1_1_1.add(lblNewLabel_2_1_1_2_2_1_5_1_1_1);
		
		JPanel panel_1_1_2_5_1_1_2 = new JPanel();
		panel_1_1_2_5_1_1_2.setLayout(null);
		panel_1_1_2_5_1_1_2.setBackground(Color.WHITE);
		panel_1_1_2_5_1_1_2.setBounds(12, 1250, 596, 145);
		panel_2_1_2.add(panel_1_1_2_5_1_1_2);
		
	    ImageIcon chicon22 = new ImageIcon("src/motel/"+o.smf.area+"모텔8번째.jpg");
	    Image chimg22 = chicon22.getImage();
	    Image cchimg22 = chimg22.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon22 = new ImageIcon(cchimg22);
		JLabel lblNewLabel_1_1_2_5_1_1_2 = new JLabel(cchicon22);
		lblNewLabel_1_1_2_5_1_1_2.setOpaque(true);
		lblNewLabel_1_1_2_5_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_5_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_5_1_1_2.setBounds(12, 10, 120, 124);
		panel_1_1_2_5_1_1_2.add(lblNewLabel_1_1_2_5_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_2_2_5_1_1_2 = new JLabel(motel[8][2]);
		lblNewLabel_2_1_1_1_2_2_5_1_1_2.setOpaque(true);
		lblNewLabel_2_1_1_1_2_2_5_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_2_5_1_1_2.setForeground(Color.RED);
		lblNewLabel_2_1_1_1_2_2_5_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_2_5_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_2_5_1_1_2.setBounds(144, 10, 70, 25);
		panel_1_1_2_5_1_1_2.add(lblNewLabel_2_1_1_1_2_2_5_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_5_1_1_2 = new JLabel(motel[8][1]);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_2.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_2.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_2.setBounds(144, 65 ,440, 20);
		panel_1_1_2_5_1_1_2.add(lblNewLabel_2_1_1_1_1_1_2_5_1_1_2);
		
		JLabel lblNewLabel_2_2_2_5_1_1_2 = new JLabel(motel[8][0]);
		lblNewLabel_2_2_2_5_1_1_2.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_5_1_1_2.setOpaque(true);
		lblNewLabel_2_2_2_5_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_5_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_5_1_1_2.setBounds(144, 42, 358, 20);
		panel_1_1_2_5_1_1_2.add(lblNewLabel_2_2_2_5_1_1_2);
		
		JLabel lblNewLabel_2_1_1_2_2_6_1_1_2 = new JLabel("대실 : " + motel[8][3]);
		lblNewLabel_2_1_1_2_2_6_1_1_2.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_2_2_6_1_1_2.setOpaque(true);
		lblNewLabel_2_1_1_2_2_6_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_6_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_6_1_1_2.setBounds(144, 90, 440, 20);
		panel_1_1_2_5_1_1_2.add(lblNewLabel_2_1_1_2_2_6_1_1_2);
		
		JLabel lblNewLabel_2_1_1_2_2_1_5_1_1_2 = new JLabel("숙박 : " + motel[8][4]);
		lblNewLabel_2_1_1_2_2_1_5_1_1_2.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_1_5_1_1_2.setOpaque(true);
		lblNewLabel_2_1_1_2_2_1_5_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_1_5_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_1_5_1_1_2.setBounds(144, 118, 440, 20);
		panel_1_1_2_5_1_1_2.add(lblNewLabel_2_1_1_2_2_1_5_1_1_2);
		
		JPanel panel_1_1_2_5_1_1_3 = new JPanel();
		panel_1_1_2_5_1_1_3.setLayout(null);
		panel_1_1_2_5_1_1_3.setBackground(Color.WHITE);
		panel_1_1_2_5_1_1_3.setBounds(12, 1405, 596, 145);
		panel_2_1_2.add(panel_1_1_2_5_1_1_3);
		
	    ImageIcon chicon23 = new ImageIcon("src/motel/"+o.smf.area+"모텔9번째.jpg");
	    Image chimg23 = chicon23.getImage();
	    Image cchimg23 = chimg23.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon23 = new ImageIcon(cchimg23);
		JLabel lblNewLabel_1_1_2_5_1_1_3 = new JLabel(cchicon23);
		lblNewLabel_1_1_2_5_1_1_3.setOpaque(true);
		lblNewLabel_1_1_2_5_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_5_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_5_1_1_3.setBounds(12, 10, 120, 124);
		panel_1_1_2_5_1_1_3.add(lblNewLabel_1_1_2_5_1_1_3);
		
		JLabel lblNewLabel_2_1_1_1_2_2_5_1_1_3 = new JLabel(motel[9][2]);
		lblNewLabel_2_1_1_1_2_2_5_1_1_3.setOpaque(true);
		lblNewLabel_2_1_1_1_2_2_5_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_2_5_1_1_3.setForeground(Color.RED);
		lblNewLabel_2_1_1_1_2_2_5_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_2_5_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_2_5_1_1_3.setBounds(144, 10, 70, 25);
		panel_1_1_2_5_1_1_3.add(lblNewLabel_2_1_1_1_2_2_5_1_1_3);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_5_1_1_3 = new JLabel(motel[9][1]);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_3.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_3.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_5_1_1_3.setBounds(144, 65 ,440, 20);
		panel_1_1_2_5_1_1_3.add(lblNewLabel_2_1_1_1_1_1_2_5_1_1_3);
		
		JLabel lblNewLabel_2_2_2_5_1_1_3 = new JLabel(motel[9][0]);
		lblNewLabel_2_2_2_5_1_1_3.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_5_1_1_3.setOpaque(true);
		lblNewLabel_2_2_2_5_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_5_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_5_1_1_3.setBounds(144, 42, 358, 20);
		panel_1_1_2_5_1_1_3.add(lblNewLabel_2_2_2_5_1_1_3);
		
		JLabel lblNewLabel_2_1_1_2_2_6_1_1_3 = new JLabel("대실 : " + motel[9][3]);
		lblNewLabel_2_1_1_2_2_6_1_1_3.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_2_2_6_1_1_3.setOpaque(true);
		lblNewLabel_2_1_1_2_2_6_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_6_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_6_1_1_3.setBounds(144, 90, 440, 20);
		panel_1_1_2_5_1_1_3.add(lblNewLabel_2_1_1_2_2_6_1_1_3);
		
		JLabel lblNewLabel_2_1_1_2_2_1_5_1_1_3 = new JLabel("숙박 : " + motel[9][4]);
		lblNewLabel_2_1_1_2_2_1_5_1_1_3.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_1_5_1_1_3.setOpaque(true);
		lblNewLabel_2_1_1_2_2_1_5_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_2_2_1_5_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_1_5_1_1_3.setBounds(144, 118, 440, 20);
		panel_1_1_2_5_1_1_3.add(lblNewLabel_2_1_1_2_2_1_5_1_1_3);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setVisible(false);
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(Color.WHITE);
		
		JPanel panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setLayout(null);
		panel_1_1_2_1.setBackground(Color.WHITE);
		panel_1_1_2_1.setBounds(12, 10, 596, 145);
		panel_2_1_1.add(panel_1_1_2_1);
		
		/////////////////////펜션
	    ImageIcon chicon24 = new ImageIcon("src/pension/"+o.smf.area+"펜션0번째.jpg");
	    Image chimg24 = chicon24.getImage();
	    Image cchimg24 = chimg24.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon24 = new ImageIcon(cchimg24);
		JLabel lblNewLabel_1_1_2_1 = new JLabel(cchicon24);
		lblNewLabel_1_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				o.db.index(a);
				RoomPension window=new RoomPension(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_1_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1_2_1.setOpaque(true);
		lblNewLabel_1_1_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_1.setBounds(12, 10, 120, 124);
		panel_1_1_2_1.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_2_1_1_1_2_2_1 = new JLabel(pension[0][2]);
		lblNewLabel_2_1_1_1_2_2_1.setOpaque(true);
		lblNewLabel_2_1_1_1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_2_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_2_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_2_1.setBounds(144, 10, 70, 25);
		panel_1_1_2_1.add(lblNewLabel_2_1_1_1_2_2_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_1 = new JLabel(pension[0][1]);
		lblNewLabel_2_1_1_1_1_1_2_1.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_1_2_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2_1.setBounds(144, 85, 440, 25);
		panel_1_1_2_1.add(lblNewLabel_2_1_1_1_1_1_2_1);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel(pension[0][0]);
		lblNewLabel_2_2_2_1.setForeground(Color.ORANGE);
		lblNewLabel_2_2_2_1.setOpaque(true);
		lblNewLabel_2_2_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_1.setBounds(144, 42, 358, 25);
		panel_1_1_2_1.add(lblNewLabel_2_2_2_1);

		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1_1_1.setBounds(12, 165, 596, 145);
		panel_2_1_1.add(panel_1_1_1_1_1);
		
	    ImageIcon chicon25 = new ImageIcon("src/pension/"+o.smf.area+"펜션1번째.jpg");
	    Image chimg25 = chicon25.getImage();
	    Image cchimg25 = chimg25.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon25 = new ImageIcon(cchimg25);
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel(cchicon25);
		lblNewLabel_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 1;
				o.db.index(a);
				RoomPension window=new RoomPension(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_1_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setBounds(12, 10, 120, 124);
		panel_1_1_1_1_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2_1_1_1 = new JLabel(pension[1][2]);
		lblNewLabel_2_1_1_1_2_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_1_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_2_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_1_1_1.setBounds(144, 10, 70, 25);
		panel_1_1_1_1_1.add(lblNewLabel_2_1_1_1_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1 = new JLabel(pension[1][1]);
		lblNewLabel_2_1_1_1_1_1_1_1_1.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_1_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_1_1_1.setBounds(144, 80, 440, 49);
		panel_1_1_1_1_1.add(lblNewLabel_2_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel(pension[1][0]);
		lblNewLabel_2_2_1_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_2_1_1_1.setOpaque(true);
		lblNewLabel_2_2_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_2_1_1_1.setBounds(144, 40, 362, 25);
		panel_1_1_1_1_1.add(lblNewLabel_2_2_1_1_1);
		
		JPanel panel_1_2_1_1 = new JPanel();
		panel_1_2_1_1.setLayout(null);
		panel_1_2_1_1.setBackground(Color.WHITE);
		panel_1_2_1_1.setBounds(12, 320, 596, 145);
		panel_2_1_1.add(panel_1_2_1_1);
		
	    ImageIcon chicon26 = new ImageIcon("src/pension/"+o.smf.area+"펜션2번째.jpg");
	    Image chimg26 = chicon26.getImage();
	    Image cchimg26 = chimg26.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon26 = new ImageIcon(cchimg26);
		JLabel lblNewLabel_1_2_1_1 = new JLabel(cchicon26);
		lblNewLabel_1_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 2;
				o.db.index(a);
				RoomPension window=new RoomPension(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_2_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_2_1_1.setOpaque(true);
		lblNewLabel_1_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_2_1_1.setBounds(12, 10, 120, 124);
		panel_1_2_1_1.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1_3_1_1 = new JLabel(pension[2][2]);
		lblNewLabel_2_1_1_1_3_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_3_1_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_3_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_3_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_3_1_1.setBounds(144, 10, 70, 25);
		panel_1_2_1_1.add(lblNewLabel_2_1_1_1_3_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_2_1_1 = new JLabel(pension[2][1]);
		lblNewLabel_2_1_1_1_1_2_1_1.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_2_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_2_1_1.setBounds(144, 80, 440, 49);
		panel_1_2_1_1.add(lblNewLabel_2_1_1_1_1_2_1_1);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel(pension[2][0]);
		lblNewLabel_2_3_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_3_1_1.setOpaque(true);
		lblNewLabel_2_3_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_3_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_3_1_1.setBounds(144, 40, 362, 25);
		panel_1_2_1_1.add(lblNewLabel_2_3_1_1);

		JPanel panel_1_3_1_1 = new JPanel();
		panel_1_3_1_1.setLayout(null);
		panel_1_3_1_1.setBackground(Color.WHITE);
		panel_1_3_1_1.setBounds(12, 475, 596, 145);
		panel_2_1_1.add(panel_1_3_1_1);
		
	    ImageIcon chicon27 = new ImageIcon("src/pension/"+o.smf.area+"펜션3번째.jpg");
	    Image chimg27 = chicon27.getImage();
	    Image cchimg27 = chimg27.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon27 = new ImageIcon(cchimg27);
		JLabel lblNewLabel_1_3_1_1 = new JLabel(cchicon27);
		lblNewLabel_1_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 3;
				o.db.index(a);
				RoomPension window=new RoomPension(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_3_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_3_1_1.setOpaque(true);
		lblNewLabel_1_3_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_3_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_3_1_1.setBounds(12, 10, 120, 124);
		panel_1_3_1_1.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_2_1_1_1_4_1_1 = new JLabel(pension[3][2]);
		lblNewLabel_2_1_1_1_4_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_4_1_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_4_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_4_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_4_1_1.setBounds(144, 10, 70, 25);
		panel_1_3_1_1.add(lblNewLabel_2_1_1_1_4_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_3_1_1 = new JLabel(pension[3][1]);
		lblNewLabel_2_1_1_1_1_3_1_1.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_3_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_3_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_3_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_3_1_1.setBounds(144, 80, 440, 49);
		panel_1_3_1_1.add(lblNewLabel_2_1_1_1_1_3_1_1);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel(pension[3][0]);
		lblNewLabel_2_4_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_4_1_1.setOpaque(true);
		lblNewLabel_2_4_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_4_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_4_1_1.setBounds(144, 40, 362, 25);
		panel_1_3_1_1.add(lblNewLabel_2_4_1_1);

		JPanel panel_1_4_1_1 = new JPanel();
		panel_1_4_1_1.setLayout(null);
		panel_1_4_1_1.setBackground(Color.WHITE);
		panel_1_4_1_1.setBounds(12, 630, 596, 145);
		panel_2_1_1.add(panel_1_4_1_1);
		
	    ImageIcon chicon28 = new ImageIcon("src/pension/"+o.smf.area+"펜션4번째.jpg");
	    Image chimg28 = chicon28.getImage();
	    Image cchimg28 = chimg28.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon28 = new ImageIcon(cchimg28);
		JLabel lblNewLabel_1_4_1_1 = new JLabel(cchicon28);
		lblNewLabel_1_4_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 4;
				o.db.index(a);
				RoomPension window=new RoomPension(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_4_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_4_1_1.setOpaque(true);
		lblNewLabel_1_4_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_4_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_4_1_1.setBounds(12, 10, 120, 124);
		panel_1_4_1_1.add(lblNewLabel_1_4_1_1);
		
		JLabel lblNewLabel_2_1_1_1_5_1_1 = new JLabel(pension[4][2]);
		lblNewLabel_2_1_1_1_5_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_5_1_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_5_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_5_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_5_1_1.setBounds(144, 10, 70, 25);
		panel_1_4_1_1.add(lblNewLabel_2_1_1_1_5_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1_1 = new JLabel(pension[4][1]);
		lblNewLabel_2_1_1_1_1_4_1_1.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_4_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_4_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_4_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_4_1_1.setBounds(144, 80, 440, 49);
		panel_1_4_1_1.add(lblNewLabel_2_1_1_1_1_4_1_1);
		
		JLabel lblNewLabel_2_5_1_1 = new JLabel(pension[4][0]);
		lblNewLabel_2_5_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_5_1_1.setOpaque(true);
		lblNewLabel_2_5_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_5_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_5_1_1.setBounds(144, 40, 362, 25);
		panel_1_4_1_1.add(lblNewLabel_2_5_1_1);

		JPanel panel_1_4_1_1_1 = new JPanel();
		panel_1_4_1_1_1.setLayout(null);
		panel_1_4_1_1_1.setBackground(Color.WHITE);
		panel_1_4_1_1_1.setBounds(12, 785, 596, 145);
		panel_2_1_1.add(panel_1_4_1_1_1);
		
	    ImageIcon chicon29 = new ImageIcon("src/pension/"+o.smf.area+"펜션5번째.jpg");
	    Image chimg29 = chicon29.getImage();
	    Image cchimg29 = chimg29.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon29 = new ImageIcon(cchimg29);
		JLabel lblNewLabel_1_4_1_1_1 = new JLabel(cchicon29);
		lblNewLabel_1_4_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 5;
				o.db.index(a);
				RoomPension window=new RoomPension(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_4_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_4_1_1_1.setOpaque(true);
		lblNewLabel_1_4_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_4_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_4_1_1_1.setBounds(12, 10, 120, 124);
		panel_1_4_1_1_1.add(lblNewLabel_1_4_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_5_1_1_1 = new JLabel(pension[5][2]);
		lblNewLabel_2_1_1_1_5_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_5_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_5_1_1_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_5_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_5_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_5_1_1_1.setBounds(144, 10, 70, 25);
		panel_1_4_1_1_1.add(lblNewLabel_2_1_1_1_5_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1_1_1 = new JLabel(pension[5][1]);
		lblNewLabel_2_1_1_1_1_4_1_1_1.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_4_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_4_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_4_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_4_1_1_1.setBounds(144, 80, 440, 49);
		panel_1_4_1_1_1.add(lblNewLabel_2_1_1_1_1_4_1_1_1);
		
		JLabel lblNewLabel_2_5_1_1_1 = new JLabel(pension[5][0]);
		lblNewLabel_2_5_1_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_5_1_1_1.setOpaque(true);
		lblNewLabel_2_5_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_5_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_5_1_1_1.setBounds(144, 40, 362, 25);
		panel_1_4_1_1_1.add(lblNewLabel_2_5_1_1_1);
		
		JPanel panel_1_4_1_1_2 = new JPanel();
		panel_1_4_1_1_2.setLayout(null);
		panel_1_4_1_1_2.setBackground(Color.WHITE);
		panel_1_4_1_1_2.setBounds(12, 940, 596, 145);
		panel_2_1_1.add(panel_1_4_1_1_2);
		
	    ImageIcon chicon30 = new ImageIcon("src/pension/"+o.smf.area+"펜션6번째.jpg");
	    Image chimg30 = chicon30.getImage();
	    Image cchimg30 = chimg30.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon30 = new ImageIcon(cchimg30);
		JLabel lblNewLabel_1_4_1_1_2 = new JLabel(cchicon30);
		lblNewLabel_1_4_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 6;
				o.db.index(a);
				RoomPension window=new RoomPension(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_4_1_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_4_1_1_2.setOpaque(true);
		lblNewLabel_1_4_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_4_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_4_1_1_2.setBounds(12, 10, 120, 124);
		panel_1_4_1_1_2.add(lblNewLabel_1_4_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_5_1_1_2 = new JLabel(pension[6][2]);
		lblNewLabel_2_1_1_1_5_1_1_2.setOpaque(true);
		lblNewLabel_2_1_1_1_5_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_5_1_1_2.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_5_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_5_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_5_1_1_2.setBounds(144, 10, 70, 25);
		panel_1_4_1_1_2.add(lblNewLabel_2_1_1_1_5_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1_1_2 = new JLabel(pension[6][1]);
		lblNewLabel_2_1_1_1_1_4_1_1_2.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_4_1_1_2.setOpaque(true);
		lblNewLabel_2_1_1_1_1_4_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_4_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_4_1_1_2.setBounds(144, 80, 440, 49);
		panel_1_4_1_1_2.add(lblNewLabel_2_1_1_1_1_4_1_1_2);
		
		JLabel lblNewLabel_2_5_1_1_2 = new JLabel(pension[6][0]);
		lblNewLabel_2_5_1_1_2.setForeground(Color.ORANGE);
		lblNewLabel_2_5_1_1_2.setOpaque(true);
		lblNewLabel_2_5_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_5_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_5_1_1_2.setBounds(144, 40, 362, 25);
		panel_1_4_1_1_2.add(lblNewLabel_2_5_1_1_2);

		JPanel panel_1_4_1_1_3 = new JPanel();
		panel_1_4_1_1_3.setLayout(null);
		panel_1_4_1_1_3.setBackground(Color.WHITE);
		panel_1_4_1_1_3.setBounds(12, 1095, 596, 145);
		panel_2_1_1.add(panel_1_4_1_1_3);
		
	    ImageIcon chicon31 = new ImageIcon("src/pension/"+o.smf.area+"펜션7번째.jpg");
	    Image chimg31 = chicon31.getImage();
	    Image cchimg31 = chimg31.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon31 = new ImageIcon(cchimg31);
		JLabel lblNewLabel_1_4_1_1_3 = new JLabel(cchicon31);
		lblNewLabel_1_4_1_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 7;
				o.db.index(a);
				RoomPension window=new RoomPension(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_4_1_1_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_4_1_1_3.setOpaque(true);
		lblNewLabel_1_4_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_4_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_4_1_1_3.setBounds(12, 10, 120, 124);
		panel_1_4_1_1_3.add(lblNewLabel_1_4_1_1_3);
		
		JLabel lblNewLabel_2_1_1_1_5_1_1_3 = new JLabel(pension[7][2]);
		lblNewLabel_2_1_1_1_5_1_1_3.setOpaque(true);
		lblNewLabel_2_1_1_1_5_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_5_1_1_3.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_5_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_5_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_5_1_1_3.setBounds(144, 10, 70, 25);
		panel_1_4_1_1_3.add(lblNewLabel_2_1_1_1_5_1_1_3);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1_1_3 = new JLabel(pension[7][1]);
		lblNewLabel_2_1_1_1_1_4_1_1_3.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_4_1_1_3.setOpaque(true);
		lblNewLabel_2_1_1_1_1_4_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_4_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_4_1_1_3.setBounds(144, 80, 440, 49);
		panel_1_4_1_1_3.add(lblNewLabel_2_1_1_1_1_4_1_1_3);
		
		JLabel lblNewLabel_2_5_1_1_3 = new JLabel(pension[7][0]);
		lblNewLabel_2_5_1_1_3.setForeground(Color.ORANGE);
		lblNewLabel_2_5_1_1_3.setOpaque(true);
		lblNewLabel_2_5_1_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_5_1_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_5_1_1_3.setBounds(144, 40, 362, 25);
		panel_1_4_1_1_3.add(lblNewLabel_2_5_1_1_3);

		JPanel panel_1_4_1_1_4 = new JPanel();
		panel_1_4_1_1_4.setLayout(null);
		panel_1_4_1_1_4.setBackground(Color.WHITE);
		panel_1_4_1_1_4.setBounds(12, 1250, 596, 145);
		panel_2_1_1.add(panel_1_4_1_1_4);
		
	    ImageIcon chicon32 = new ImageIcon("src/pension/"+o.smf.area+"펜션8번째.jpg");
	    Image chimg32 = chicon32.getImage();
	    Image cchimg32 = chimg32.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon32 = new ImageIcon(cchimg32);
		JLabel lblNewLabel_1_4_1_1_4 = new JLabel(cchicon32);
		lblNewLabel_1_4_1_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 8;
				o.db.index(a);
				RoomPension window=new RoomPension(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_4_1_1_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_4_1_1_4.setOpaque(true);
		lblNewLabel_1_4_1_1_4.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_4_1_1_4.setBackground(Color.WHITE);
		lblNewLabel_1_4_1_1_4.setBounds(12, 10, 120, 124);
		panel_1_4_1_1_4.add(lblNewLabel_1_4_1_1_4);
		
		JLabel lblNewLabel_2_1_1_1_5_1_1_4 = new JLabel(pension[8][2]);
		lblNewLabel_2_1_1_1_5_1_1_4.setOpaque(true);
		lblNewLabel_2_1_1_1_5_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_5_1_1_4.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_5_1_1_4.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_5_1_1_4.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_5_1_1_4.setBounds(144, 10, 70, 25);
		panel_1_4_1_1_4.add(lblNewLabel_2_1_1_1_5_1_1_4);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1_1_4 = new JLabel(pension[8][1]);
		lblNewLabel_2_1_1_1_1_4_1_1_4.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_4_1_1_4.setOpaque(true);
		lblNewLabel_2_1_1_1_1_4_1_1_4.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_4_1_1_4.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_4_1_1_4.setBounds(144, 80, 440, 49);
		panel_1_4_1_1_4.add(lblNewLabel_2_1_1_1_1_4_1_1_4);
		
		JLabel lblNewLabel_2_5_1_1_4 = new JLabel(pension[8][0]);
		lblNewLabel_2_5_1_1_4.setForeground(Color.ORANGE);
		lblNewLabel_2_5_1_1_4.setOpaque(true);
		lblNewLabel_2_5_1_1_4.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_5_1_1_4.setBackground(Color.WHITE);
		lblNewLabel_2_5_1_1_4.setBounds(144, 40, 362, 25);
		panel_1_4_1_1_4.add(lblNewLabel_2_5_1_1_4);

		JPanel panel_1_4_1_1_5 = new JPanel();
		panel_1_4_1_1_5.setLayout(null);
		panel_1_4_1_1_5.setBackground(Color.WHITE);
		panel_1_4_1_1_5.setBounds(12, 1405, 596, 145);
		panel_2_1_1.add(panel_1_4_1_1_5);
		
	    ImageIcon chicon33 = new ImageIcon("src/pension/"+o.smf.area+"펜션9번째.jpg");
	    Image chimg33 = chicon33.getImage();
	    Image cchimg33 = chimg33.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon33 = new ImageIcon(cchimg33);
		JLabel lblNewLabel_1_4_1_1_5 = new JLabel(cchicon33);
		lblNewLabel_1_4_1_1_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 9;
				o.db.index(a);
				RoomPension window=new RoomPension(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_4_1_1_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_4_1_1_5.setOpaque(true);
		lblNewLabel_1_4_1_1_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_4_1_1_5.setBackground(Color.WHITE);
		lblNewLabel_1_4_1_1_5.setBounds(12, 10, 120, 124);
		panel_1_4_1_1_5.add(lblNewLabel_1_4_1_1_5);
		
		JLabel lblNewLabel_2_1_1_1_5_1_1_5 = new JLabel(pension[9][2]);
		lblNewLabel_2_1_1_1_5_1_1_5.setOpaque(true);
		lblNewLabel_2_1_1_1_5_1_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_5_1_1_5.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_5_1_1_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_5_1_1_5.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_5_1_1_5.setBounds(144, 10, 70, 25);
		panel_1_4_1_1_5.add(lblNewLabel_2_1_1_1_5_1_1_5);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1_1_5 = new JLabel(pension[9][1]);
		lblNewLabel_2_1_1_1_1_4_1_1_5.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_4_1_1_5.setOpaque(true);
		lblNewLabel_2_1_1_1_1_4_1_1_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_4_1_1_5.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_4_1_1_5.setBounds(144, 80, 440, 49);
		panel_1_4_1_1_5.add(lblNewLabel_2_1_1_1_1_4_1_1_5);
		
		JLabel lblNewLabel_2_5_1_1_5 = new JLabel(pension[9][0]);
		lblNewLabel_2_5_1_1_5.setForeground(Color.ORANGE);
		lblNewLabel_2_5_1_1_5.setOpaque(true);
		lblNewLabel_2_5_1_1_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_5_1_1_5.setBackground(Color.WHITE);
		lblNewLabel_2_5_1_1_5.setBounds(144, 40, 362, 25);
		panel_1_4_1_1_5.add(lblNewLabel_2_5_1_1_5);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setBounds(12, 10, 596, 145);
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBackground(Color.WHITE);
		
		////////////////////호텔
	    ImageIcon chicon34 = new ImageIcon("src/hotel/"+o.smf.area+"호텔0번째.jpg");
	    Image chimg34 = chicon34.getImage();
	    Image cchimg34 = chimg34.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon34 = new ImageIcon(cchimg34);
		JLabel lblNewLabel_1_1_2 = new JLabel(cchicon34);
		lblNewLabel_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				o.db.index(a);
				Room window=new Room(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1_2.setOpaque(true);
		lblNewLabel_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2.setBounds(12, 10, 120, 124);
		panel_1_1_2.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_2_2 = new JLabel(hotel[0][2]);
		lblNewLabel_2_1_1_1_2_2.setOpaque(true);
		lblNewLabel_2_1_1_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_2.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_2_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_2.setBounds(144, 10, 70, 25);
		panel_1_1_2.add(lblNewLabel_2_1_1_1_2_2);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2 = new JLabel(hotel[0][1]);
		lblNewLabel_2_1_1_1_1_1_2.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_1_2.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_2.setBounds(144, 85, 440, 25);
		panel_1_1_2.add(lblNewLabel_2_1_1_1_1_1_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel(hotel[0][0]);
		lblNewLabel_2_2_2.setForeground(Color.ORANGE);
		lblNewLabel_2_2_2.setOpaque(true);
		lblNewLabel_2_2_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_2.setBackground(Color.WHITE);
		lblNewLabel_2_2_2.setBounds(144, 42, 358, 25);
		panel_1_1_2.add(lblNewLabel_2_2_2);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBounds(12, 165, 596, 145);
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(Color.WHITE);
		
	    ImageIcon chicon35 = new ImageIcon("src/hotel/"+o.smf.area+"호텔1번째.jpg");
	    Image chimg35 = chicon35.getImage();
	    Image cchimg35 = chimg35.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon35 = new ImageIcon(cchimg35);
		JLabel lblNewLabel_1_1_1_1 = new JLabel(cchicon35);
		lblNewLabel_1_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 1;
				o.db.index(a);
				Room window=new Room(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1_1.setBounds(12, 10, 120, 124);
		panel_1_1_1_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2_1_1 = new JLabel(hotel[1][2]);
		lblNewLabel_2_1_1_1_2_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_2_1_1.setBounds(144, 10, 70, 25);
		panel_1_1_1_1.add(lblNewLabel_2_1_1_1_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1 = new JLabel(hotel[1][1]);
		lblNewLabel_2_1_1_1_1_1_1_1.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_1_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_1_1.setBounds(144, 60, 440, 49);
		panel_1_1_1_1.add(lblNewLabel_2_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel(hotel[1][0]);
		lblNewLabel_2_2_1_1.setForeground(Color.ORANGE);
		lblNewLabel_2_2_1_1.setOpaque(true);
		lblNewLabel_2_2_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_2_1_1.setBounds(144, 35, 362, 15);
		panel_1_1_1_1.add(lblNewLabel_2_2_1_1);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBounds(12, 320, 596, 145);
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(Color.WHITE);
		
	    ImageIcon chicon36 = new ImageIcon("src/hotel/"+o.smf.area+"호텔2번째.jpg");
	    Image chimg36 = chicon36.getImage();
	    Image cchimg36 = chimg36.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon36 = new ImageIcon(cchimg36);
		JLabel lblNewLabel_1_2_1 = new JLabel(cchicon36);
		lblNewLabel_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 2;
				o.db.index(a);
				Room window=new Room(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_2_1.setOpaque(true);
		lblNewLabel_1_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_1_2_1.setBounds(12, 10, 120, 124);
		panel_1_2_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2_1_1_1_3_1 = new JLabel(hotel[2][2]);
		lblNewLabel_2_1_1_1_3_1.setOpaque(true);
		lblNewLabel_2_1_1_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_3_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_3_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_3_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_3_1.setBounds(144, 10, 70, 25);
		panel_1_2_1.add(lblNewLabel_2_1_1_1_3_1);
		
		JLabel lblNewLabel_2_1_1_1_1_2_1 = new JLabel(hotel[2][1]);
		lblNewLabel_2_1_1_1_1_2_1.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_2_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_2_1.setBounds(144, 60, 440, 49);
		panel_1_2_1.add(lblNewLabel_2_1_1_1_1_2_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel(hotel[2][0]);
		lblNewLabel_2_3_1.setForeground(Color.ORANGE);
		lblNewLabel_2_3_1.setOpaque(true);
		lblNewLabel_2_3_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_3_1.setBackground(Color.WHITE);
		lblNewLabel_2_3_1.setBounds(144, 35, 362, 15);
		panel_1_2_1.add(lblNewLabel_2_3_1);
		
		JPanel panel_1_3_1 = new JPanel();
		panel_1_3_1.setBounds(12, 475, 596, 145);
		panel_1_3_1.setLayout(null);
		panel_1_3_1.setBackground(Color.WHITE);
		
	    ImageIcon chicon37 = new ImageIcon("src/hotel/"+o.smf.area+"호텔3번째.jpg");
	    Image chimg37 = chicon37.getImage();
	    Image cchimg37 = chimg37.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon37 = new ImageIcon(cchimg37);
		JLabel lblNewLabel_1_3_1 = new JLabel(cchicon37);
		lblNewLabel_1_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 3;
				o.db.index(a);
				Room window=new Room(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_3_1.setOpaque(true);
		lblNewLabel_1_3_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_3_1.setBackground(Color.WHITE);
		lblNewLabel_1_3_1.setBounds(12, 10, 120, 124);
		panel_1_3_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_2_1_1_1_4_1 = new JLabel(hotel[3][2]);
		lblNewLabel_2_1_1_1_4_1.setOpaque(true);
		lblNewLabel_2_1_1_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_4_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_4_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_4_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_4_1.setBounds(144, 10, 70, 25);
		panel_1_3_1.add(lblNewLabel_2_1_1_1_4_1);
		
		JLabel lblNewLabel_2_1_1_1_1_3_1 = new JLabel(hotel[3][1]);
		lblNewLabel_2_1_1_1_1_3_1.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_3_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_3_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_3_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_3_1.setBounds(144, 60, 440, 49);
		panel_1_3_1.add(lblNewLabel_2_1_1_1_1_3_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel(hotel[3][0]);
		lblNewLabel_2_4_1.setForeground(Color.ORANGE);
		lblNewLabel_2_4_1.setOpaque(true);
		lblNewLabel_2_4_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_4_1.setBackground(Color.WHITE);
		lblNewLabel_2_4_1.setBounds(144, 35, 362, 15);
		panel_1_3_1.add(lblNewLabel_2_4_1);
		
		JPanel panel_1_4_1 = new JPanel();
		panel_1_4_1.setBounds(12, 630, 596, 145);
		panel_1_4_1.setLayout(null);
		panel_1_4_1.setBackground(Color.WHITE);
		
	    ImageIcon chicon38 = new ImageIcon("src/hotel/"+o.smf.area+"호텔4번째.jpg");
	    Image chimg38 = chicon38.getImage();
	    Image cchimg38 = chimg38.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon38 = new ImageIcon(cchimg38);
		JLabel lblNewLabel_1_4_1 = new JLabel(cchicon38);
		lblNewLabel_1_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 4;
				o.db.index(a);
				Room window=new Room(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_4_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_4_1.setOpaque(true);
		lblNewLabel_1_4_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_4_1.setBackground(Color.WHITE);
		lblNewLabel_1_4_1.setBounds(12, 10, 120, 124);
		panel_1_4_1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_2_1_1_1_5_1 = new JLabel(hotel[4][2]);
		lblNewLabel_2_1_1_1_5_1.setOpaque(true);
		lblNewLabel_2_1_1_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_5_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_5_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_5_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_5_1.setBounds(144, 10, 70, 25);
		panel_1_4_1.add(lblNewLabel_2_1_1_1_5_1);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1 = new JLabel(hotel[4][1]);
		lblNewLabel_2_1_1_1_1_4_1.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_4_1.setOpaque(true);
		lblNewLabel_2_1_1_1_1_4_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_4_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_4_1.setBounds(144, 60, 440, 49);
		panel_1_4_1.add(lblNewLabel_2_1_1_1_1_4_1);
		
		JLabel lblNewLabel_2_5_1 = new JLabel(hotel[4][0]);
		lblNewLabel_2_5_1.setForeground(Color.ORANGE);
		lblNewLabel_2_5_1.setOpaque(true);
		lblNewLabel_2_5_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_5_1.setBackground(Color.WHITE);
		lblNewLabel_2_5_1.setBounds(144, 35, 362, 15);
		panel_1_4_1.add(lblNewLabel_2_5_1);
		panel_2_1.setLayout(null);
		panel_2_1.add(panel_1_1_2);
		panel_2_1.add(panel_1_1_1_1);
		panel_2_1.add(panel_1_2_1);
		panel_2_1.add(panel_1_3_1);
		panel_2_1.add(panel_1_4_1);
		
		JPanel panel_1_4_1_2 = new JPanel();
		panel_1_4_1_2.setLayout(null);
		panel_1_4_1_2.setBackground(Color.WHITE);
		panel_1_4_1_2.setBounds(12, 785, 596, 145);
		panel_2_1.add(panel_1_4_1_2);
		
	    ImageIcon chicon39 = new ImageIcon("src/hotel/"+o.smf.area+"호텔5번째.jpg");
	    Image chimg39 = chicon39.getImage();
	    Image cchimg39 = chimg39.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon39 = new ImageIcon(cchimg39);
		JLabel lblNewLabel_1_4_1_2 = new JLabel(cchicon39);
		lblNewLabel_1_4_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 5;
				o.db.index(a);
				Room window=new Room(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_4_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_4_1_2.setOpaque(true);
		lblNewLabel_1_4_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_4_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_4_1_2.setBounds(12, 10, 120, 124);
		panel_1_4_1_2.add(lblNewLabel_1_4_1_2);
		
		JLabel lblNewLabel_2_1_1_1_5_1_2 = new JLabel(hotel[5][2]);
		lblNewLabel_2_1_1_1_5_1_2.setOpaque(true);
		lblNewLabel_2_1_1_1_5_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_5_1_2.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_5_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_5_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_5_1_2.setBounds(144, 10, 70, 25);
		panel_1_4_1_2.add(lblNewLabel_2_1_1_1_5_1_2);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1_2 = new JLabel(hotel[5][1]);
		lblNewLabel_2_1_1_1_1_4_1_2.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_4_1_2.setOpaque(true);
		lblNewLabel_2_1_1_1_1_4_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_4_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_4_1_2.setBounds(144, 60, 440, 49);
		panel_1_4_1_2.add(lblNewLabel_2_1_1_1_1_4_1_2);
		
		JLabel lblNewLabel_2_5_1_2 = new JLabel(hotel[5][0]);
		lblNewLabel_2_5_1_2.setForeground(Color.ORANGE);
		lblNewLabel_2_5_1_2.setOpaque(true);
		lblNewLabel_2_5_1_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_5_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_5_1_2.setBounds(144, 35, 362, 15);
		panel_1_4_1_2.add(lblNewLabel_2_5_1_2);
		
		JPanel panel_1_4_1_3 = new JPanel();
		panel_1_4_1_3.setLayout(null);
		panel_1_4_1_3.setBackground(Color.WHITE);
		panel_1_4_1_3.setBounds(12, 940, 596, 145);
		panel_2_1.add(panel_1_4_1_3);
		
	    ImageIcon chicon40 = new ImageIcon("src/hotel/"+o.smf.area+"호텔6번째.jpg");
	    Image chimg40 = chicon40.getImage();
	    Image cchimg40 = chimg40.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon40 = new ImageIcon(cchimg40);
		JLabel lblNewLabel_1_4_1_3 = new JLabel(cchicon40);
		lblNewLabel_1_4_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 6;
				o.db.index(a);
				Room window=new Room(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_4_1_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_4_1_3.setOpaque(true);
		lblNewLabel_1_4_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_4_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_4_1_3.setBounds(12, 10, 120, 124);
		panel_1_4_1_3.add(lblNewLabel_1_4_1_3);
		
		JLabel lblNewLabel_2_1_1_1_5_1_3 = new JLabel(hotel[6][2]);
		lblNewLabel_2_1_1_1_5_1_3.setOpaque(true);
		lblNewLabel_2_1_1_1_5_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_5_1_3.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_5_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_5_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_5_1_3.setBounds(144, 10, 70, 25);
		panel_1_4_1_3.add(lblNewLabel_2_1_1_1_5_1_3);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1_3 = new JLabel(hotel[6][1]);
		lblNewLabel_2_1_1_1_1_4_1_3.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_4_1_3.setOpaque(true);
		lblNewLabel_2_1_1_1_1_4_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_4_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_4_1_3.setBounds(144, 60, 440, 49);
		panel_1_4_1_3.add(lblNewLabel_2_1_1_1_1_4_1_3);
		
		JLabel lblNewLabel_2_5_1_3 = new JLabel(hotel[6][0]);
		lblNewLabel_2_5_1_3.setForeground(Color.ORANGE);
		lblNewLabel_2_5_1_3.setOpaque(true);
		lblNewLabel_2_5_1_3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_5_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_5_1_3.setBounds(144, 35, 362, 15);
		panel_1_4_1_3.add(lblNewLabel_2_5_1_3);
		
		JPanel panel_1_4_1_4 = new JPanel();
		panel_1_4_1_4.setLayout(null);
		panel_1_4_1_4.setBackground(Color.WHITE);
		panel_1_4_1_4.setBounds(12, 1095, 596, 145);
		panel_2_1.add(panel_1_4_1_4);
		
	    ImageIcon chicon41 = new ImageIcon("src/hotel/"+o.smf.area+"호텔7번째.jpg");
	    Image chimg41 = chicon41.getImage();
	    Image cchimg41 = chimg41.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon41 = new ImageIcon(cchimg41);
		JLabel lblNewLabel_1_4_1_4 = new JLabel(cchicon41);
		lblNewLabel_1_4_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 7;
				o.db.index(a);
				Room window=new Room(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_4_1_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_4_1_4.setOpaque(true);
		lblNewLabel_1_4_1_4.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_4_1_4.setBackground(Color.WHITE);
		lblNewLabel_1_4_1_4.setBounds(12, 10, 120, 124);
		panel_1_4_1_4.add(lblNewLabel_1_4_1_4);
		
		JLabel lblNewLabel_2_1_1_1_5_1_4 = new JLabel(hotel[7][2]);
		lblNewLabel_2_1_1_1_5_1_4.setOpaque(true);
		lblNewLabel_2_1_1_1_5_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_5_1_4.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_5_1_4.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_5_1_4.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_5_1_4.setBounds(144, 10, 70, 25);
		panel_1_4_1_4.add(lblNewLabel_2_1_1_1_5_1_4);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1_4 = new JLabel(hotel[7][1]);
		lblNewLabel_2_1_1_1_1_4_1_4.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_4_1_4.setOpaque(true);
		lblNewLabel_2_1_1_1_1_4_1_4.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_4_1_4.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_4_1_4.setBounds(144, 60, 440, 49);
		panel_1_4_1_4.add(lblNewLabel_2_1_1_1_1_4_1_4);
		
		JLabel lblNewLabel_2_5_1_4 = new JLabel(hotel[7][0]);
		lblNewLabel_2_5_1_4.setForeground(Color.ORANGE);
		lblNewLabel_2_5_1_4.setOpaque(true);
		lblNewLabel_2_5_1_4.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_5_1_4.setBackground(Color.WHITE);
		lblNewLabel_2_5_1_4.setBounds(144, 35, 362, 15);
		panel_1_4_1_4.add(lblNewLabel_2_5_1_4);
		
		JPanel panel_1_4_1_5 = new JPanel();
		panel_1_4_1_5.setLayout(null);
		panel_1_4_1_5.setBackground(Color.WHITE);
		panel_1_4_1_5.setBounds(12, 1250, 596, 145);
		panel_2_1.add(panel_1_4_1_5);
		
	    ImageIcon chicon42 = new ImageIcon("src/hotel/"+o.smf.area+"호텔8번째.jpg");
	    Image chimg42 = chicon42.getImage();
	    Image cchimg42 = chimg42.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon42 = new ImageIcon(cchimg42);
		JLabel lblNewLabel_1_4_1_5 = new JLabel(cchicon42);
		lblNewLabel_1_4_1_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 8;
				o.db.index(a);
				Room window=new Room(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_4_1_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_4_1_5.setOpaque(true);
		lblNewLabel_1_4_1_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_4_1_5.setBackground(Color.WHITE);
		lblNewLabel_1_4_1_5.setBounds(12, 10, 120, 124);
		panel_1_4_1_5.add(lblNewLabel_1_4_1_5);
		
		JLabel lblNewLabel_2_1_1_1_5_1_5 = new JLabel(hotel[8][2]);
		lblNewLabel_2_1_1_1_5_1_5.setOpaque(true);
		lblNewLabel_2_1_1_1_5_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_5_1_5.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_5_1_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_5_1_5.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_5_1_5.setBounds(144, 10, 70, 25);
		panel_1_4_1_5.add(lblNewLabel_2_1_1_1_5_1_5);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1_5 = new JLabel(hotel[8][1]);
		lblNewLabel_2_1_1_1_1_4_1_5.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_4_1_5.setOpaque(true);
		lblNewLabel_2_1_1_1_1_4_1_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_4_1_5.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_4_1_5.setBounds(144, 60, 440, 49);
		panel_1_4_1_5.add(lblNewLabel_2_1_1_1_1_4_1_5);
		
		JLabel lblNewLabel_2_5_1_5 = new JLabel(hotel[8][0]);
		lblNewLabel_2_5_1_5.setForeground(Color.ORANGE);
		lblNewLabel_2_5_1_5.setOpaque(true);
		lblNewLabel_2_5_1_5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_5_1_5.setBackground(Color.WHITE);
		lblNewLabel_2_5_1_5.setBounds(144, 35, 362, 15);
		panel_1_4_1_5.add(lblNewLabel_2_5_1_5);
		
		JPanel panel_1_4_1_6 = new JPanel();
		panel_1_4_1_6.setLayout(null);
		panel_1_4_1_6.setBackground(Color.WHITE);
		panel_1_4_1_6.setBounds(12, 1405, 596, 145);
		panel_2_1.add(panel_1_4_1_6);
		
	    ImageIcon chicon43 = new ImageIcon("src/hotel/"+o.smf.area+"호텔9번째.jpg");
	    Image chimg43 = chicon43.getImage();
	    Image cchimg43 = chimg43.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
	    ImageIcon cchicon43 = new ImageIcon(cchimg43);
		JLabel lblNewLabel_1_4_1_6 = new JLabel(cchicon43);
		lblNewLabel_1_4_1_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_4_1_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 9;
				o.db.index(a);
				Room window=new Room(o);
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_4_1_6.setOpaque(true);
		lblNewLabel_1_4_1_6.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_1_4_1_6.setBackground(Color.WHITE);
		lblNewLabel_1_4_1_6.setBounds(12, 10, 120, 124);
		panel_1_4_1_6.add(lblNewLabel_1_4_1_6);
		
		JLabel lblNewLabel_2_1_1_1_5_1_6 = new JLabel(hotel[9][2]);
		lblNewLabel_2_1_1_1_5_1_6.setOpaque(true);
		lblNewLabel_2_1_1_1_5_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_5_1_6.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_1_1_1_5_1_6.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_5_1_6.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_5_1_6.setBounds(144, 10, 70, 25);
		panel_1_4_1_6.add(lblNewLabel_2_1_1_1_5_1_6);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1_6 = new JLabel(hotel[9][1]);
		lblNewLabel_2_1_1_1_1_4_1_6.setForeground(Color.PINK);
		lblNewLabel_2_1_1_1_1_4_1_6.setOpaque(true);
		lblNewLabel_2_1_1_1_1_4_1_6.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_4_1_6.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_4_1_6.setBounds(144, 60, 440, 49);
		panel_1_4_1_6.add(lblNewLabel_2_1_1_1_1_4_1_6);
		
		JLabel lblNewLabel_2_5_1_6 = new JLabel(hotel[9][0]);
		lblNewLabel_2_5_1_6.setForeground(Color.ORANGE);
		lblNewLabel_2_5_1_6.setOpaque(true);
		lblNewLabel_2_5_1_6.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		lblNewLabel_2_5_1_6.setBackground(Color.WHITE);
		lblNewLabel_2_5_1_6.setBounds(144, 35, 362, 15);
		panel_1_4_1_6.add(lblNewLabel_2_5_1_6);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2_1_1_2, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1_1_3, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1_1, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1_2, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2_1_1_2, GroupLayout.PREFERRED_SIZE, 1587, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1_1_3, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1_1, GroupLayout.PREFERRED_SIZE, 1637, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 1637, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1_2, GroupLayout.PREFERRED_SIZE, 1564, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 801, GroupLayout.PREFERRED_SIZE)))
		);
		panel_1.setLayout(gl_panel_1);
		frame.setLocationRelativeTo(null);
		
		// 라디오 버튼 선택 시
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				place = "호텔";
				scrollPane.getVerticalScrollBar().setValue(0);
				panel_2_1_2.setVisible(false);
				panel_2_1.setVisible(true);
				panel_2_1_1.setVisible(false);
				panel_2_1_1_1.setVisible(false);
				panel_2_1_1_2.setVisible(false);
				panel_2_1_1_3.setVisible(false);
			}
		});
		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				scrollPane.getVerticalScrollBar().setValue(0);
				panel_2_1_2.setVisible(true);
				panel_2_1.setVisible(false);
				panel_2_1_1.setVisible(false);
				panel_2_1_1_1.setVisible(false);
				panel_2_1_1_2.setVisible(false);
				panel_2_1_1_3.setVisible(false);
			}
		});
		rdbtnNewRadioButton_1_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				place = "펜션";
				scrollPane.getVerticalScrollBar().setValue(0);
				panel_2_1_2.setVisible(false);
				panel_2_1.setVisible(false);
				panel_2_1_1.setVisible(true);
				panel_2_1_1_1.setVisible(false);
				panel_2_1_1_2.setVisible(false);
				panel_2_1_1_3.setVisible(false);
			}
		});
		rdbtnNewRadioButton_1_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				scrollPane.getVerticalScrollBar().setValue(0);
				panel_2_1_2.setVisible(false);
				panel_2_1.setVisible(false);
				panel_2_1_1.setVisible(false);
				panel_2_1_1_1.setVisible(false);
				panel_2_1_1_2.setVisible(false);
				panel_2_1_1_3.setVisible(true);
			}
		});
		rdbtnNewRadioButton_1_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				scrollPane.getVerticalScrollBar().setValue(0);
				panel_2_1_2.setVisible(false);
				panel_2_1.setVisible(false);
				panel_2_1_1.setVisible(false);
				panel_2_1_1_1.setVisible(true);
				panel_2_1_1_2.setVisible(false);
				panel_2_1_1_3.setVisible(false);
			}
		});
		rdbtnNewRadioButton_1_3_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				scrollPane.getVerticalScrollBar().setValue(0);
				panel_2_1_2.setVisible(false);
				panel_2_1.setVisible(false);
				panel_2_1_1.setVisible(false);
				panel_2_1_1_1.setVisible(false);
				panel_2_1_1_2.setVisible(true);
				panel_2_1_1_3.setVisible(false);
			}
		});
	}
	
	public String Place() {
		return place;
	}
}