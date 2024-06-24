package GUI;

import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import GUI.SearchMap.RoundedButton;

import javax.swing.event.ChangeEvent;

public class SearchMap extends JFrame {
	
	public static String area="";
	private JPanel contentPane;
	static public Operator o=null;
	JRadioButton rdbtnNewRadioButton = new JRadioButton("서울");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMap frame = new SearchMap(o);
					frame.setVisible(true);
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
	 * Create the frame.
	 */
	public SearchMap(Operator _o) {
		o=_o;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		
		ImageIcon icon3 = new ImageIcon(SearchMap.class.getResource("/map/전국지도.PNG"));
		Image img3 = icon3.getImage();
		Image changeimg3 = img3.getScaledInstance(501,517,Image.SCALE_SMOOTH);
		ImageIcon chageIcon3 = new ImageIcon(changeimg3);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("인천");
		rdbtnNewRadioButton_7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				area="인천";
			}
		});
		rdbtnNewRadioButton_7.setForeground(new Color(128, 128, 128));
		rdbtnNewRadioButton_7.setFont(new Font("굴림", Font.BOLD, 15));
		rdbtnNewRadioButton_7.setBounds(122, 78, 57, 23);
		rdbtnNewRadioButton_7.setContentAreaFilled(false);
		rdbtnNewRadioButton_7.setBorderPainted(false);
		contentPane.add(rdbtnNewRadioButton_7);
		
		rdbtnNewRadioButton_7.addItemListener((ItemListener) new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				area = "인천";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("대전");
		rdbtnNewRadioButton_6.setFont(new Font("굴림", Font.BOLD, 15));
		rdbtnNewRadioButton_6.setBounds(216, 217, 66, 23);
		rdbtnNewRadioButton_6.setContentAreaFilled(false);
		rdbtnNewRadioButton_6.setBorderPainted(false);
		contentPane.add(rdbtnNewRadioButton_6);
		
		rdbtnNewRadioButton_6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				area = "대전";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("울산");
		rdbtnNewRadioButton_5.setFont(new Font("굴림", Font.BOLD, 15));
		rdbtnNewRadioButton_5.setBounds(389, 291, 66, 23);
		rdbtnNewRadioButton_5.setContentAreaFilled(false);
		rdbtnNewRadioButton_5.setBorderPainted(false);
		contentPane.add(rdbtnNewRadioButton_5);
		
		rdbtnNewRadioButton_5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				area = "울산";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("제주도");
		rdbtnNewRadioButton_4.setFont(new Font("굴림", Font.BOLD, 15));
		rdbtnNewRadioButton_4.setForeground(new Color(192, 192, 192));
		rdbtnNewRadioButton_4.setBounds(109, 470, 121, 23);
		rdbtnNewRadioButton_4.setContentAreaFilled(false);
		rdbtnNewRadioButton_4.setBorderPainted(false);
		contentPane.add(rdbtnNewRadioButton_4);
		
		rdbtnNewRadioButton_4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				area = "제주도";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("대구");
		rdbtnNewRadioButton_3.setForeground(new Color(0, 128, 128));
		rdbtnNewRadioButton_3.setFont(new Font("굴림", Font.BOLD, 15));
		rdbtnNewRadioButton_3.setBounds(320, 266, 121, 23);
		rdbtnNewRadioButton_3.setContentAreaFilled(false);
		rdbtnNewRadioButton_3.setBorderPainted(false);
		contentPane.add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				area = "대구";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("부산");
		rdbtnNewRadioButton_2.setForeground(new Color(0, 128, 128));
		rdbtnNewRadioButton_2.setFont(new Font("굴림", Font.BOLD, 15));
		rdbtnNewRadioButton_2.setBounds(351, 330, 121, 23);
		rdbtnNewRadioButton_2.setContentAreaFilled(false);
		rdbtnNewRadioButton_2.setBorderPainted(false);
		contentPane.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				area = "부산";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("광주");
		rdbtnNewRadioButton_1.setForeground(new Color(0, 0, 0));
		rdbtnNewRadioButton_1.setFont(new Font("굴림", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBounds(154, 330, 121, 23);
		rdbtnNewRadioButton_1.setContentAreaFilled(false);
		rdbtnNewRadioButton_1.setBorderPainted(false);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				area = "광주";
			}
		});
		
		
		rdbtnNewRadioButton.setForeground(new Color(128, 128, 192));
		rdbtnNewRadioButton.setFont(new Font("굴림", Font.BOLD, 15));
		rdbtnNewRadioButton.setBackground(SystemColor.window);
		rdbtnNewRadioButton.setBounds(185, 91, 57, 32);
		rdbtnNewRadioButton.setContentAreaFilled(false);
		rdbtnNewRadioButton.setBorderPainted(false);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				area = "서울";
			}
		});
		
		ButtonGroup g=new ButtonGroup();
		g.add(rdbtnNewRadioButton);
		g.add(rdbtnNewRadioButton_1);
		g.add(rdbtnNewRadioButton_2);
		g.add(rdbtnNewRadioButton_3);
		g.add(rdbtnNewRadioButton_4);
		g.add(rdbtnNewRadioButton_5);
		g.add(rdbtnNewRadioButton_6);
		g.add(rdbtnNewRadioButton_7);
		
		
		RoundedButton button = new RoundedButton("검색");
		button.setForeground(new Color(255, 255, 255));
		button.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 17));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchScreen window = new SearchScreen(o);
				dispose();
				window.frame.setVisible(true);
			}
		});
		button.setBounds(389, 10, 100, 40);
		contentPane.add(button);
		JLabel lblNewLabel1 = new JLabel(chageIcon3);
		
		setLocationRelativeTo(null);
		
		
		JRadioButton rdbtnNewRadioButton_7_1 = new JRadioButton("강릉");
		rdbtnNewRadioButton_7_1.setForeground(Color.GRAY);
		rdbtnNewRadioButton_7_1.setFont(new Font("굴림", Font.BOLD, 15));
		rdbtnNewRadioButton_7_1.setContentAreaFilled(false);
		rdbtnNewRadioButton_7_1.setBorderPainted(false);
		rdbtnNewRadioButton_7_1.setBounds(314, 66, 57, 23);
		contentPane.add(rdbtnNewRadioButton_7_1);
		
		rdbtnNewRadioButton_7_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				area = "강릉";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_7_2 = new JRadioButton("수원");
		rdbtnNewRadioButton_7_2.setForeground(Color.GRAY);
		rdbtnNewRadioButton_7_2.setFont(new Font("굴림", Font.BOLD, 15));
		rdbtnNewRadioButton_7_2.setContentAreaFilled(false);
		rdbtnNewRadioButton_7_2.setBorderPainted(false);
		rdbtnNewRadioButton_7_2.setBounds(173, 144, 57, 23);
		contentPane.add(rdbtnNewRadioButton_7_2);
		
		rdbtnNewRadioButton_7_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				area = "수원";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_7_3 = new JRadioButton("가평");
		rdbtnNewRadioButton_7_3.setForeground(Color.GRAY);
		rdbtnNewRadioButton_7_3.setFont(new Font("굴림", Font.BOLD, 15));
		rdbtnNewRadioButton_7_3.setContentAreaFilled(false); // background
		rdbtnNewRadioButton_7_3.setBorderPainted(false);
		rdbtnNewRadioButton_7_3.setBounds(216, 66, 57, 23);
		contentPane.add(rdbtnNewRadioButton_7_3);
		lblNewLabel1.setBounds(0, 0, 501, 517);
		contentPane.add(lblNewLabel1);
		
		rdbtnNewRadioButton_7_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				area = "가평";
			}
		});
		
		g.add(rdbtnNewRadioButton_7_1);
		g.add(rdbtnNewRadioButton_7_2);
		g.add(rdbtnNewRadioButton_7_3);
	}
	public String Area() {
		return area;
	}
}