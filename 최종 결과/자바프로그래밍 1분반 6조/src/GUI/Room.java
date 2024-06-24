package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class Room {
	String hotel[][];
	   
	Connection con;
	int index = 0;
	public JFrame frame;
	static public Operator o=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Room window = new Room(o);
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
	public Room(Operator _o) {
		o=_o;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
			hotel = new String[10][25];
	      
	      	String url = "jdbc:mysql://127.0.0.1:3306/project";
	      	String userid = "root";
	      	String pwd = "Tkdtn2040!"; 
	      
	      	try { // 데이터베이스를 연결하는 과정
	      		System.out.println("데이터베이스연결 준비...");
	      		con = DriverManager.getConnection(url, userid, pwd);  // db접속
	      		System.out.println("데이터베이스연결 성공");
	         
	         
	      		String area1 = o.smf.Area();
	            String query1 = "SELECT * FROM " + o.smf.area + "호텔"; // 모텔 sql문

	            Statement stmt1 = con.createStatement();  // 결과랑 연결시킬 커넥션
	            ResultSet rs1 = stmt1.executeQuery(query1);     // 모텔 결과를받을 rs

	               	index = 0;
	               
	               	System.out.println(o.cf.index);
	               
	               	while(rs1.next()) {  // 데이터를 뽑아오는 과정
	               		hotel[index][0] = rs1.getString("장소");
	               		hotel[index][1] = rs1.getString("위치");
	               		hotel[index][2] = rs1.getString("별점");
	                  
	                  
	               		int j = 1;
	               		for(int i = 1; i < 20; i+=2) {
	               			hotel[index][i+2] = rs1.getString("방" + j);
	               			hotel[index][i+3] = rs1.getString("가격" + j);
	               			j++;
	               		}
	                  
	               		index++;   
	               	}
	               	System.out.println(hotel[o.db.idx][3] + ' ' + hotel[o.db.idx][4] + ' ' + hotel[o.db.idx][5]);  // 뽑은거 확인용   
	               	rs1.close();

	      	} catch (Exception e) {
	           //System.out.println("데이터베이스 연동 실패");
	      	}
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setTitle("여기갈래?");
		frame.setBounds(100, 100, 684, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 644, 497);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(scrollPane);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		scrollPane.setColumnHeaderView(panel);
		
		RoundedButton btnNewButton_1 = new RoundedButton("뒤로가기");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(505)
					.addComponent(btnNewButton_1)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel_2_1);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBackground(Color.WHITE);
		
		// 호텔 방리스트 시작
		ImageIcon chicon49 = new ImageIcon("src/hotel/"+o.smf.area+"호텔"+o.db.idx+"번째 -0.jpg");
		Image chimg49 = chicon49.getImage();
		Image cchimg49 = chimg49.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		ImageIcon cchicon49 = new ImageIcon(cchimg49);
		JLabel lblNewLabel_1_1_2 = new JLabel(cchicon49);
		lblNewLabel_1_1_2.setOpaque(true);
		lblNewLabel_1_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2.setBounds(12, 10, 120, 124);
		panel_1_1_2.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel(hotel[o.db.idx][3]);
		lblNewLabel_2_2_2.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2.setOpaque(true);
		lblNewLabel_2_2_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblNewLabel_2_2_2.setBackground(Color.WHITE);
		lblNewLabel_2_2_2.setBounds(144, 10, 358, 30);
		panel_1_1_2.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_1_1_2_2 = new JLabel(hotel[o.db.idx][4]);
		lblNewLabel_2_1_1_2_2.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2.setOpaque(true);
		lblNewLabel_2_1_1_2_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 19));
		lblNewLabel_2_1_1_2_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2.setBounds(144, 45, 440, 30);
		panel_1_1_2.add(lblNewLabel_2_1_1_2_2);
		
		JPanel panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setLayout(null);
		panel_1_1_2_1.setBackground(Color.WHITE);
		
		ImageIcon chicon50 = new ImageIcon("src/hotel/"+o.smf.area+"호텔"+o.db.idx+"번째 -1.jpg");
		Image chimg50 = chicon50.getImage();
		Image cchimg50 = chimg50.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		ImageIcon cchicon50 = new ImageIcon(cchimg50);
		JLabel lblNewLabel_1_1_2_1 = new JLabel(cchicon50);
		lblNewLabel_1_1_2_1.setOpaque(true);
		lblNewLabel_1_1_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_1.setBounds(12, 10, 120, 124);
		panel_1_1_2_1.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel(hotel[o.db.idx][5]);
		lblNewLabel_2_2_2_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_1.setOpaque(true);
		lblNewLabel_2_2_2_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblNewLabel_2_2_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_1.setBounds(144, 10, 358, 30);
		panel_1_1_2_1.add(lblNewLabel_2_2_2_1);
		
		JLabel lblNewLabel_2_1_1_2_2_1 = new JLabel(hotel[o.db.idx][6]);
		lblNewLabel_2_1_1_2_2_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_1.setOpaque(true);
		lblNewLabel_2_1_1_2_2_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 19));
		lblNewLabel_2_1_1_2_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_1.setBounds(144, 45, 440, 30);
		panel_1_1_2_1.add(lblNewLabel_2_1_1_2_2_1);
		
		JPanel panel_1_1_2_2 = new JPanel();
		panel_1_1_2_2.setLayout(null);
		panel_1_1_2_2.setBackground(Color.WHITE);
		
		ImageIcon chicon51 = new ImageIcon("src/hotel/"+o.smf.area+"호텔"+o.db.idx+"번째 -2.jpg");
		Image chimg51 = chicon51.getImage();
		Image cchimg51 = chimg51.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		ImageIcon cchicon51 = new ImageIcon(cchimg51);
		JLabel lblNewLabel_1_1_2_2 = new JLabel(cchicon51);
		lblNewLabel_1_1_2_2.setOpaque(true);
		lblNewLabel_1_1_2_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_2_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_2.setBounds(12, 10, 120, 124);
		panel_1_1_2_2.add(lblNewLabel_1_1_2_2);
		
		JLabel lblNewLabel_2_2_2_2 = new JLabel(hotel[o.db.idx][7]);
		lblNewLabel_2_2_2_2.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_2.setOpaque(true);
		lblNewLabel_2_2_2_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblNewLabel_2_2_2_2.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_2.setBounds(144, 10, 358, 30);
		panel_1_1_2_2.add(lblNewLabel_2_2_2_2);
		
		JLabel lblNewLabel_2_1_1_2_2_2 = new JLabel(hotel[o.db.idx][8]);
		lblNewLabel_2_1_1_2_2_2.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_2.setOpaque(true);
		lblNewLabel_2_1_1_2_2_2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 19));
		lblNewLabel_2_1_1_2_2_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_2.setBounds(144, 45, 440, 30);
		panel_1_1_2_2.add(lblNewLabel_2_1_1_2_2_2);
		
		JPanel panel_1_1_2_3 = new JPanel();
		panel_1_1_2_3.setLayout(null);
		panel_1_1_2_3.setBackground(Color.WHITE);
		
		ImageIcon chicon52 = new ImageIcon("src/hotel/"+o.smf.area+"호텔"+o.db.idx+"번째 -3.jpg");
		Image chimg52 = chicon52.getImage();
		Image cchimg52 = chimg52.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		ImageIcon cchicon52 = new ImageIcon(cchimg52);
		JLabel lblNewLabel_1_1_2_3 = new JLabel(cchicon52);
		lblNewLabel_1_1_2_3.setOpaque(true);
		lblNewLabel_1_1_2_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_2_3.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_3.setBounds(12, 10, 120, 124);
		panel_1_1_2_3.add(lblNewLabel_1_1_2_3);
		
		JLabel lblNewLabel_2_2_2_3 = new JLabel(hotel[o.db.idx][9]);
		lblNewLabel_2_2_2_3.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_3.setOpaque(true);
		lblNewLabel_2_2_2_3.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblNewLabel_2_2_2_3.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_3.setBounds(144, 10, 358, 30);
		panel_1_1_2_3.add(lblNewLabel_2_2_2_3);
		
		JLabel lblNewLabel_2_1_1_2_2_3 = new JLabel(hotel[o.db.idx][10]);
		lblNewLabel_2_1_1_2_2_3.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_3.setOpaque(true);
		lblNewLabel_2_1_1_2_2_3.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 19));
		lblNewLabel_2_1_1_2_2_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_3.setBounds(144, 45, 440, 30);
		panel_1_1_2_3.add(lblNewLabel_2_1_1_2_2_3);
		
		JPanel panel_1_1_2_4 = new JPanel();
		panel_1_1_2_4.setLayout(null);
		panel_1_1_2_4.setBackground(Color.WHITE);
		
		ImageIcon chicon53 = new ImageIcon("src/hotel/"+o.smf.area+"호텔"+o.db.idx+"번째 -4.jpg");
		Image chimg53 = chicon53.getImage();
		Image cchimg53 = chimg53.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		ImageIcon cchicon53 = new ImageIcon(cchimg53);
		JLabel lblNewLabel_1_1_2_4 = new JLabel(cchicon53);
		lblNewLabel_1_1_2_4.setOpaque(true);
		lblNewLabel_1_1_2_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_2_4.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_4.setBounds(12, 10, 120, 124);
		panel_1_1_2_4.add(lblNewLabel_1_1_2_4);
		
		JLabel lblNewLabel_2_2_2_4 = new JLabel(hotel[o.db.idx][11]);
		lblNewLabel_2_2_2_4.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_4.setOpaque(true);
		lblNewLabel_2_2_2_4.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblNewLabel_2_2_2_4.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_4.setBounds(144, 10, 358, 30);
		panel_1_1_2_4.add(lblNewLabel_2_2_2_4);
		
		JLabel lblNewLabel_2_1_1_2_2_4 = new JLabel(hotel[o.db.idx][12]);
		lblNewLabel_2_1_1_2_2_4.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_4.setOpaque(true);
		lblNewLabel_2_1_1_2_2_4.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 19));
		lblNewLabel_2_1_1_2_2_4.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_4.setBounds(144, 45, 440, 30);
		panel_1_1_2_4.add(lblNewLabel_2_1_1_2_2_4);
		
		JPanel panel_1_1_2_5 = new JPanel();
		panel_1_1_2_5.setLayout(null);
		panel_1_1_2_5.setBackground(Color.WHITE);
		
		ImageIcon chicon54 = new ImageIcon("src/hotel/"+o.smf.area+"호텔"+o.db.idx+"번째 -5.jpg");
		Image chimg54 = chicon54.getImage();
		Image cchimg54 = chimg54.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		ImageIcon cchicon54 = new ImageIcon(cchimg54);
		JLabel lblNewLabel_1_1_2_5 = new JLabel(cchicon54);
		lblNewLabel_1_1_2_5.setOpaque(true);
		lblNewLabel_1_1_2_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_2_5.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_5.setBounds(12, 10, 120, 124);
		panel_1_1_2_5.add(lblNewLabel_1_1_2_5);
		
		JLabel lblNewLabel_2_2_2_5 = new JLabel(hotel[o.db.idx][13]);
		lblNewLabel_2_2_2_5.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_5.setOpaque(true);
		lblNewLabel_2_2_2_5.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblNewLabel_2_2_2_5.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_5.setBounds(144, 10, 358, 30);
		panel_1_1_2_5.add(lblNewLabel_2_2_2_5);
		
		JLabel lblNewLabel_2_1_1_2_2_5 = new JLabel(hotel[o.db.idx][14]);
		lblNewLabel_2_1_1_2_2_5.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_5.setOpaque(true);
		lblNewLabel_2_1_1_2_2_5.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 19));
		lblNewLabel_2_1_1_2_2_5.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_5.setBounds(144, 45, 440, 30);
		panel_1_1_2_5.add(lblNewLabel_2_1_1_2_2_5);
		
		JPanel panel_1_1_2_6 = new JPanel();
		panel_1_1_2_6.setLayout(null);
		panel_1_1_2_6.setBackground(Color.WHITE);
		
		ImageIcon chicon55 = new ImageIcon("src/hotel/"+o.smf.area+"호텔"+o.db.idx+"번째 -6.jpg");
		Image chimg55 = chicon55.getImage();
		Image cchimg55 = chimg55.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		ImageIcon cchicon55 = new ImageIcon(cchimg55);
		JLabel lblNewLabel_1_1_2_6 = new JLabel(cchicon55);
		lblNewLabel_1_1_2_6.setOpaque(true);
		lblNewLabel_1_1_2_6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_2_6.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_6.setBounds(12, 10, 120, 124);
		panel_1_1_2_6.add(lblNewLabel_1_1_2_6);
		
		JLabel lblNewLabel_2_2_2_6 = new JLabel(hotel[o.db.idx][15]);
		lblNewLabel_2_2_2_6.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_6.setOpaque(true);
		lblNewLabel_2_2_2_6.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblNewLabel_2_2_2_6.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_6.setBounds(144, 10, 358, 30);
		panel_1_1_2_6.add(lblNewLabel_2_2_2_6);
		
		JLabel lblNewLabel_2_1_1_2_2_6 = new JLabel(hotel[o.db.idx][16]);
		lblNewLabel_2_1_1_2_2_6.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_6.setOpaque(true);
		lblNewLabel_2_1_1_2_2_6.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 19));
		lblNewLabel_2_1_1_2_2_6.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_6.setBounds(144, 45, 440, 30);
		panel_1_1_2_6.add(lblNewLabel_2_1_1_2_2_6);
		
		JPanel panel_1_1_2_7 = new JPanel();
		panel_1_1_2_7.setLayout(null);
		panel_1_1_2_7.setBackground(Color.WHITE);
		
		ImageIcon chicon56 = new ImageIcon("src/hotel/"+o.smf.area+"호텔"+o.db.idx+"번째 -7.jpg");
		Image chimg56 = chicon56.getImage();
		Image cchimg56 = chimg56.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		ImageIcon cchicon56 = new ImageIcon(cchimg56);
		JLabel lblNewLabel_1_1_2_7 = new JLabel(cchicon56);
		lblNewLabel_1_1_2_7.setOpaque(true);
		lblNewLabel_1_1_2_7.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_2_7.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_7.setBounds(12, 10, 120, 124);
		panel_1_1_2_7.add(lblNewLabel_1_1_2_7);
		
		JLabel lblNewLabel_2_2_2_7 = new JLabel(hotel[o.db.idx][17]);
		lblNewLabel_2_2_2_7.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_7.setOpaque(true);
		lblNewLabel_2_2_2_7.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblNewLabel_2_2_2_7.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_7.setBounds(144, 10, 358, 30);
		panel_1_1_2_7.add(lblNewLabel_2_2_2_7);
		
		JLabel lblNewLabel_2_1_1_2_2_7 = new JLabel(hotel[o.db.idx][18]);
		lblNewLabel_2_1_1_2_2_7.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_7.setOpaque(true);
		lblNewLabel_2_1_1_2_2_7.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 19));
		lblNewLabel_2_1_1_2_2_7.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_7.setBounds(144, 45, 440, 30);
		panel_1_1_2_7.add(lblNewLabel_2_1_1_2_2_7);
		
		JPanel panel_1_1_2_8 = new JPanel();
		panel_1_1_2_8.setLayout(null);
		panel_1_1_2_8.setBackground(Color.WHITE);
		
		ImageIcon chicon57 = new ImageIcon("src/hotel/"+o.smf.area+"호텔"+o.db.idx+"번째 -8.jpg");
		Image chimg57 = chicon57.getImage();
		Image cchimg57 = chimg57.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		ImageIcon cchicon57 = new ImageIcon(cchimg57);
		JLabel lblNewLabel_1_1_2_8 = new JLabel(cchicon57);
		lblNewLabel_1_1_2_8.setOpaque(true);
		lblNewLabel_1_1_2_8.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_2_8.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_8.setBounds(12, 10, 120, 124);
		panel_1_1_2_8.add(lblNewLabel_1_1_2_8);
		
		JLabel lblNewLabel_2_2_2_8 = new JLabel(hotel[o.db.idx][19]);
		lblNewLabel_2_2_2_8.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_8.setOpaque(true);
		lblNewLabel_2_2_2_8.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblNewLabel_2_2_2_8.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_8.setBounds(144, 10, 358, 30);
		panel_1_1_2_8.add(lblNewLabel_2_2_2_8);
		
		JLabel lblNewLabel_2_1_1_2_2_8 = new JLabel(hotel[o.db.idx][20]);
		lblNewLabel_2_1_1_2_2_8.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_8.setOpaque(true);
		lblNewLabel_2_1_1_2_2_8.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 19));
		lblNewLabel_2_1_1_2_2_8.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_8.setBounds(144, 45, 440, 30);
		panel_1_1_2_8.add(lblNewLabel_2_1_1_2_2_8);
		
		JPanel panel_1_1_2_9 = new JPanel();
		panel_1_1_2_9.setLayout(null);
		panel_1_1_2_9.setBackground(Color.WHITE);
		
		ImageIcon chicon58 = new ImageIcon("src/hotel/"+o.smf.area+"호텔"+o.db.idx+"번째 -9.jpg");
		Image chimg58 = chicon58.getImage();
		Image cchimg58 = chimg58.getScaledInstance(120, 124, Image.SCALE_SMOOTH);
		ImageIcon cchicon58 = new ImageIcon(cchimg58);
		JLabel lblNewLabel_1_1_2_9 = new JLabel(cchicon58);
		lblNewLabel_1_1_2_9.setOpaque(true);
		lblNewLabel_1_1_2_9.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_2_9.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_9.setBounds(12, 10, 120, 124);
		panel_1_1_2_9.add(lblNewLabel_1_1_2_9);
		
		JLabel lblNewLabel_2_2_2_9 = new JLabel(hotel[o.db.idx][21]);
		lblNewLabel_2_2_2_9.setForeground(new Color(255, 192, 203));
		lblNewLabel_2_2_2_9.setOpaque(true);
		lblNewLabel_2_2_2_9.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		lblNewLabel_2_2_2_9.setBackground(Color.WHITE);
		lblNewLabel_2_2_2_9.setBounds(144, 10, 358, 30);
		panel_1_1_2_9.add(lblNewLabel_2_2_2_9);
		
		JLabel lblNewLabel_2_1_1_2_2_9 = new JLabel(hotel[o.db.idx][22]);
		lblNewLabel_2_1_1_2_2_9.setForeground(Color.ORANGE);
		lblNewLabel_2_1_1_2_2_9.setOpaque(true);
		lblNewLabel_2_1_1_2_2_9.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 19));
		lblNewLabel_2_1_1_2_2_9.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2_2_9.setBounds(144, 45, 440, 30);
		panel_1_1_2_9.add(lblNewLabel_2_1_1_2_2_9);
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 625, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addGap(12)
							.addComponent(panel_1_1_2, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1_1_2_2, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1_1_2_3, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1_1_2_4, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1_1_2_5, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1_1_2_6, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1_1_2_7, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1_1_2_8, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1_1_2_9, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_panel_2_1.setVerticalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1540, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_1_1_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1_2_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1_2_3, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1_2_4, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1_2_5, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1_2_6, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1_2_7, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1_2_8, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1_2_9, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(88))
		);
		panel_2_1.setLayout(gl_panel_2_1);
		frame.setLocationRelativeTo(null);
	}
}
