package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdminSeason {

	JFrame frame;
	static public Operator o=null;
	public static String image1_file = "/img_season/영덕 대게축제(겨울).PNG";
	public static String image2_file = "/img_season/퍼스트가든 빛축제 별빛이 흐르는 정원(겨울).PNG";
	public static String image3_file = "/img_season/하이원리조트(겨울).PNG";
	public static String image1_txt = "영덕 대게 축제";
	public static String image2_txt = "퍼스트 가든 빛축제";
	public static String image3_txt = "하이원 리조트";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSeason window = new AdminSeason(o);
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
	public AdminSeason(Operator _o) {
		o = _o;
		initialize();
		frame.setLocationRelativeTo(null);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 384, 709);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("사진1");
		lblNewLabel_2.setIcon(new ImageIcon(AdminSeason.class.getResource("/img_season/광양_매화마을(봄).PNG")));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(12, 37, 100, 100);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("사진1");
		lblNewLabel_2_1.setIcon(new ImageIcon(AdminSeason.class.getResource("/img_season/구례_산수유마을(봄).PNG")));
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setBounds(124, 37, 100, 100);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("사진1");
		lblNewLabel_2_2.setIcon(new ImageIcon(AdminSeason.class.getResource("/img_season/진해_군항제(봄).PNG")));
		lblNewLabel_2_2.setOpaque(true);
		lblNewLabel_2_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_2.setBounds(236, 37, 100, 100);
		panel_1.add(lblNewLabel_2_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_2_3 = new JLabel("사진1");
		lblNewLabel_2_3.setIcon(new ImageIcon(AdminSeason.class.getResource("/img_season/보령_머드축제(여름).PNG")));
		lblNewLabel_2_3.setOpaque(true);
		lblNewLabel_2_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_3.setBounds(12, 37, 100, 100);
		panel_1_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("사진1");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(AdminSeason.class.getResource("/img_season/신촌_물총축제(여름).PNG")));
		lblNewLabel_2_1_1.setOpaque(true);
		lblNewLabel_2_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_1_1.setBounds(124, 37, 100, 100);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("사진1");
		lblNewLabel_2_2_1.setIcon(new ImageIcon(AdminSeason.class.getResource("/img_season/광안리(여름).PNG")));
		lblNewLabel_2_2_1.setOpaque(true);
		lblNewLabel_2_2_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_2_1.setBounds(236, 37, 100, 100);
		panel_1_1.add(lblNewLabel_2_2_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		
		JLabel lblNewLabel_2_4 = new JLabel("사진1");
		lblNewLabel_2_4.setIcon(new ImageIcon(AdminSeason.class.getResource("/img_season/성북세계음식축제 누리마실(가을).PNG")));
		lblNewLabel_2_4.setOpaque(true);
		lblNewLabel_2_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_4.setBounds(12, 37, 100, 100);
		panel_1_2.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("사진1");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(AdminSeason.class.getResource("/img_season/진주 유등축제(가을).PNG")));
		lblNewLabel_2_1_2.setOpaque(true);
		lblNewLabel_2_1_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_1_2.setBounds(124, 37, 100, 100);
		panel_1_2.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("사진1");
		lblNewLabel_2_2_2.setIcon(new ImageIcon(AdminSeason.class.getResource("/img_season/창원 단풍거리축제(가을).PNG")));
		lblNewLabel_2_2_2.setOpaque(true);
		lblNewLabel_2_2_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_2_2.setBounds(236, 37, 100, 100);
		panel_1_2.add(lblNewLabel_2_2_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		
		JLabel lblNewLabel_2_5 = new JLabel("사진1");
		lblNewLabel_2_5.setIcon(new ImageIcon(AdminSeason.class.getResource("/img_season/영덕 대게축제(겨울).PNG")));
		lblNewLabel_2_5.setOpaque(true);
		lblNewLabel_2_5.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_5.setBounds(12, 37, 100, 100);
		panel_1_3.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("사진1");
		lblNewLabel_2_1_3.setIcon(new ImageIcon(AdminSeason.class.getResource("/img_season/퍼스트가든 빛축제 별빛이 흐르는 정원(겨울).PNG")));
		lblNewLabel_2_1_3.setOpaque(true);
		lblNewLabel_2_1_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_1_3.setBounds(124, 37, 100, 100);
		panel_1_3.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("사진1");
		lblNewLabel_2_2_3.setIcon(new ImageIcon(AdminSeason.class.getResource("/img_season/하이원리조트(겨울).PNG")));
		lblNewLabel_2_2_3.setOpaque(true);
		lblNewLabel_2_2_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_2_3.setBounds(236, 37, 100, 100);
		panel_1_3.add(lblNewLabel_2_2_3);
		
		JLabel lblNewLabel = new JLabel("계절별 추천 여행지");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		
		JButton btnNewButton_4 = new JButton("닫기");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginScreen window=new loginScreen(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_1_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
							.addContainerGap(8, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
							.addComponent(btnNewButton_4)
							.addGap(26))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("겨울");
		rdbtnNewRadioButton_3.setBounds(12, 9, 72, 23);
		panel_1_3.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton_3 = new JButton("수정하기"); // 겨울 수정
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "계절 변경 완료!!");
				image1_file = "/img_season/영덕 대게축제(겨울).PNG";
				image2_file = "/img_season/퍼스트가든 빛축제 별빛이 흐르는 정원(겨울).PNG";
				image3_file = "/img_season/하이원리조트(겨울).PNG";
				image1_txt = "영덕 대게 축제";
				image2_txt = "퍼스트 가든 빛축제";
				image3_txt = "하이원 리조트";
				
			}
		});
		btnNewButton_3.setBounds(236, 9, 100, 23);
		panel_1_3.add(btnNewButton_3);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("가을");
		rdbtnNewRadioButton_2.setBounds(12, 9, 72, 23);
		panel_1_2.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton_2 = new JButton("수정하기"); // 가을 수정
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "계절 변경 완료!!");
				image1_file = "/img_season/성북세계음식축제 누리마실(가을).PNG";
				image2_file = "/img_season/진주 유등축제(가을).PNG";
				image3_file = "/img_season/창원 단풍거리축제(가을).PNG";
				image1_txt = "성북 세계음식축제";
				image2_txt = "진주 유등축제";
				image3_txt = "창원 단풍거리축제";
			}
		});
		btnNewButton_2.setBounds(236, 9, 100, 23);
		panel_1_2.add(btnNewButton_2);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("여름");
		rdbtnNewRadioButton_1.setBounds(12, 9, 72, 23);
		panel_1_1.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_1 = new JButton("수정하기"); // 여름 수정
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "계절 변경 완료!!");
				image1_file = "/img_season/광안리(여름).PNG";
                image2_file = "/img_season/보령_머드축제(여름).PNG";
                image3_file = "/img_season/신촌_물총축제(여름).PNG";
				image1_txt = "부산 광안리";
				image2_txt = "보령 머드축제";
				image3_txt = "신촌 물총축제";
			}
		});
		btnNewButton_1.setBounds(236, 9, 100, 23);
		panel_1_1.add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("봄");
		rdbtnNewRadioButton.setBounds(12, 8, 72, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JButton btnNewButton = new JButton("수정하기"); // 봄 수정
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "계절 변경 완료!!");
				image1_file = "/img_season/광양_매화마을(봄).PNG";
                image2_file = "/img_season/구례_산수유마을(봄).PNG";
                image3_file = "/img_season/진해_군항제(봄).PNG";
				image1_txt = "광양 매화마을";
				image2_txt = "구례 산수유마을";
				image3_txt = "진해 군항제";
			}
		});
		btnNewButton.setBounds(236, 8, 100, 23);
		panel_1.add(btnNewButton);
		frame.getContentPane().setLayout(groupLayout);
	}
}