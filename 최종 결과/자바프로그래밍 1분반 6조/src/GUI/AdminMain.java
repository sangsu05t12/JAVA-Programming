package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

import GUI.AdminMain.RoundedButton;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class AdminMain {

	public JFrame frame;
	static public Operator o=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain window = new AdminMain(o);
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
	public AdminMain(Operator _o) {
		o=_o;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("여기갈래?");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 310, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원수 : "+o.db.numofperson());
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 23));
		lblNewLabel.setBounds(82, 10, 132, 60);
		frame.getContentPane().add(lblNewLabel);
		
		RoundedButton btnNewButton = new RoundedButton("게시판 운영");
		btnNewButton.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 22));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 250, 250));
		btnNewButton.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminBoard window = new AdminBoard(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(40, 92, 211, 35);
		frame.getContentPane().add(btnNewButton);
		
		RoundedButton btnNewButton_1 = new RoundedButton("계절별 유명지역 선정");
		btnNewButton_1.setForeground(new Color(230, 230, 250));
		btnNewButton_1.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSeason window = new AdminSeason(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1.setBounds(40, 167, 211, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		RoundedButton btnNewButton_2 = new RoundedButton("로그아웃");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginScreen window=new loginScreen(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 228, 225));
		btnNewButton_2.setBounds(175, 260, 107, 41);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminMain.class.getResource("/img_adminMain/admin_main.PNG")));
		lblNewLabel_1.setBounds(0, 0, 294, 311);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setLocationRelativeTo(null);
	}
}
