package main;

import java.awt.*;
import javax.swing.*;

import common.Info;
import count.Count;
import count.Total;
import menu.Bakery;
import menu.Coffee;
import menu.MenuTab;
import menu.Tea;
import pay.Pay;

public class KioskMain extends JFrame {

	public KioskMain() {
		setTitle("kiosk");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// container 생성
		Container c = getContentPane();
		c.setLayout(null); // 레이아웃 null
		c.setBackground(Color.DARK_GRAY); // 배경색 지정

		// 로고 이미지
		ImageIcon icon = new ImageIcon("Images/logo.png"); // 아이콘 생성
		Image img = icon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH); // 크기 조정
		icon = new ImageIcon(img); // 조절한 이미시를 다시 담은
		JLabel logo = new JLabel(icon); // 라벨에 아이콘 부착
		logo.setSize(40, 40); // 라벨 크기 조절
		logo.setLocation(315, 5); // 위치 조절
		c.add(logo); // 컨테이너에 부착

		// JPanel 생성
		MenuTab menu = new MenuTab(); // 메뉴 패널 객체 생성
		Count count = new Count(); // 수량조절 패널 객체 생성(미완성)
		Total total = new Total(); // 총 상품가격 패널 생성
		Pay pay = new Pay(); // 결제 패널 생성

		// 컨테이너에 부착
		c.add(menu);
		c.add(count);
		c.add(total);
		c.add(pay.Jpay);

		setSize(700, 830); // 크기 조절
		setVisible(true); // 보일 수 있도록
	}
}
