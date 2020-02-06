package menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.*;

import common.Info;
import count.Count;
import count.CountDisply;
import count.Total;

public class MenuItem extends JPanel {
	JPanel[] jp = new JPanel[30]; // 패널 배열 생성
	JButton jbtn; // 이미지를 담을 버튼 변수 선언
	JLabel lname; // 상품명을 담을 라벨 변수 선언
	JLabel lprice; // 가격을 담을 라벨 변수 선언
	JPanel p1 = new JPanel(new GridLayout(0, 4));  
	public static int number=0; //vCount 순서를 담을 number 변수
	public static Vector<CountDisply> vCount = new Vector<CountDisply>();  //CountDisply객체를 담는 vCount 벡터 생성

	public void item(String[] img, String[] name, String[] price, int num) {
		for (int i = 0; i < num; i++) {

			// 이미지 아이콘 객체생성
			ImageIcon icon = new ImageIcon(img[i]); // 파라미터로 받아온 이미지경로 문자열 배열 중 i번쨰 문자열을 가져옴
			Image img1 = icon.getImage().getScaledInstance(120, 100, java.awt.Image.SCALE_SMOOTH); // 이미지크기조절
			icon = new ImageIcon(img1); // 조절한 이미지를 icon에 담음

			// 메뉴 아이템을 담을 패널 배열
			jp[i] = new JPanel(); // 패널 배열의 객체 생성
			jp[i].setLayout(null); // layout은 null
			jp[i].setBackground(new Color(213, 213, 213)); // 패널의 배경설정
			jp[i].setPreferredSize(new Dimension(120, 150)); // 패널의 크기 설정
			jp[i].setBorder(BorderFactory.createLineBorder(Color.black)); // 패널에 테두리 만듬

			// 버튼
			jbtn = new JButton(); // 버튼 객체 생성
			jbtn.setBackground(Color.white); // 버튼의 배경색 지정
			jbtn.setIcon(icon); // icon을 버튼에 부착
			jbtn.setBounds(0, 0, 145, 100); // 버튼의 위치 지정
			int a = i;
			jbtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					vCount.add(new CountDisply(name[a], price[a], number));  //벡터 vCount에 countdisply추가
					number++;  //number 증가
					revalidate(); //재배치
					repaint(); //다시 그림
				}
			});

			// 상품명
			lname = new JLabel(); // 라벨 객체 생성
			lname.setText(name[i]); // 파라미터로 받아온 상품명 문자열 배열 중 i번쨰 문자열을 가져옴
			lname.setBounds(0, 110, 120, 20); // 라벨의 위치 지정

			// 가격
			lprice = new JLabel(); // 라벨 객체 생성
			lprice.setText(price[i]); // 파라미터로 받아온 가격 문자열 배열 중 i번쨰 문자열을 가져옴
			lprice.setBounds(45, 130, 120, 20); // 라벨의 위치 지정

			jp[i].add(jbtn); // 패널에 버튼 부착
			jp[i].add(lname); // 패널에 상품명 라벨 부착
			jp[i].add(lprice); // 패널에 상품가격 라벨 부착
			p1.add(jp[i]);
		}

	}
}
