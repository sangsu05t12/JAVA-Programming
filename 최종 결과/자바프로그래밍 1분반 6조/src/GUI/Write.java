package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;

public class Write {
	static public Operator o=null;
	public JFrame frame;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Write window = new Write(o);
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
	public Write(Operator _o) {
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
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setTitle("여기갈래?");
		frame.setBounds(100, 100, 358, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 192, 318, 199);
		frame.getContentPane().add(textArea);
		
		btnNewButton_2 = new RoundedButton("취소");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board window = new Board(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 20));
		btnNewButton_2.setBackground(new Color(255, 228, 225));
		btnNewButton_2.setBounds(190, 401, 106, 48);
		frame.getContentPane().add(btnNewButton_2);
		
		RoundedButton btnNewButton_2_1 = new RoundedButton("저장");
		btnNewButton_2_1.setForeground(new Color(255, 255, 255));
		
		btnNewButton_2_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 20));
		btnNewButton_2_1.setBackground(new Color(255, 228, 225));
		btnNewButton_2_1.setBounds(62, 401, 116, 48);
		frame.getContentPane().add(btnNewButton_2_1);
		
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().equals("") && !textArea.getText().equals("")) {
					if(o.db.Writing(textField.getText(),textArea.getText())) {
						Board window=new Board(o);
						window.frame.setVisible(true);
						frame.dispose();
					}
				}
			}
		});
			
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 16));
		textField.setBackground(new Color(255, 228, 225));
		textField.setBounds(92, 101, 238, 29);
		textField.setOpaque(false);
		textField.setBorder(BorderFactory.createEmptyBorder());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		ImageIcon icon12 = new ImageIcon(Write.class.getResource("/img_write/write.png"));
		Image img12 = icon12.getImage();
		Image changeimg12 = img12.getScaledInstance(340,491,Image.SCALE_SMOOTH);
		ImageIcon chageIcon12 = new ImageIcon(changeimg12);
		JLabel lblNewLabel_1 = new JLabel(chageIcon12);
		
		lblNewLabel_1.setBounds(-11, 0, 363, 491);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setLocationRelativeTo(null);
	}
}