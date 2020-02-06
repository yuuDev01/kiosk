package menu;

import java.awt.*;
import javax.swing.*;

import common.Info;

public class Coffee extends MenuItem {

	public Coffee() {
		p1.setBackground(new Color(234, 234, 234)); // 판넬의 배경색 설정
		JScrollPane sp1 = new JScrollPane(); // 스크롤팬 sp1 생성
		sp1.setPreferredSize(new Dimension(600, 380)); // sp1 크기 조절
		sp1.setViewportView(p1); // p1을 sp1에 부착
		add(sp1); // sp1를 부착함

		item(Info.cofimg, Info.cofnam, Info.cofprice, Info.cofnum); // 부모클래스 함수 호출

	}

}
