package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import common.Info;

public class KioskStart extends JFrame {
	public KioskStart() {

		setTitle("kiosk");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// container 생성
		Container c = getContentPane();
		c.setLayout(null); // 레이아웃 null
		c.setBackground(Color.DARK_GRAY); // 배경색 지정

		// 로고 이미지
		ImageIcon icon = new ImageIcon("Images/logo.png"); // 아이콘 생성
		Image img = icon.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH); // 크기 조정
		icon = new ImageIcon(img); // 조절한 이미시를 다시 담은
		JLabel logo = new JLabel(icon); // 라벨에 아이콘 부착
		logo.setSize(150, 150); // 라벨 크기 조절
		logo.setLocation(170, 120); // 위치 조절
		c.add(logo); // 컨테이너에 부착

		JButton toHere = new JButton("DINE-IN");
		toHere.setPreferredSize(new Dimension(200, 50)); // 버튼 크기지정
		toHere.setBackground(Color.white); // 버튼 배경색 지정
		toHere.setForeground(Color.DARK_GRAY); // 버튼 글자색 지정
		toHere.setFont(new Font("굴림체", Font.BOLD, 15));
		toHere.setBounds(140, 310, 210, 60);
		toHere.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Info.inout = true;
				new KioskMain();
				setVisible(false); // 안보임
			}
		});

		JButton takeOut = new JButton("TAKE-OUT");
		takeOut.setPreferredSize(new Dimension(200, 50)); // 버튼 크기지정
		takeOut.setBackground(Color.white); // 버튼 배경색 지정
		takeOut.setForeground(Color.DARK_GRAY); // 버튼 글자색 지정
		takeOut.setFont(new Font("굴림체", Font.BOLD, 15));
		takeOut.setBounds(140, 380, 210, 60);
		takeOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Info.inout = false;
				new KioskMain();
				setVisible(false); // 안보임
			}
		});

		c.add(toHere);
		c.add(takeOut);
		setSize(500, 600); // 크기 조절
		setVisible(true); // 보일 수 있도록
	}

	public static void main(String[] args) {
		new KioskStart(); // KioskMain 객체 생성
	}
}
