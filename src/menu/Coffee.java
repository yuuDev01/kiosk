package menu;

import java.awt.*;
import javax.swing.*;

import common.Info;

public class Coffee extends MenuItem {

	public Coffee() {
		p1.setBackground(new Color(234, 234, 234)); // �ǳ��� ���� ����
		JScrollPane sp1 = new JScrollPane(); // ��ũ���� sp1 ����
		sp1.setPreferredSize(new Dimension(600, 380)); // sp1 ũ�� ����
		sp1.setViewportView(p1); // p1�� sp1�� ����
		add(sp1); // sp1�� ������

		item(Info.cofimg, Info.cofnam, Info.cofprice, Info.cofnum); // �θ�Ŭ���� �Լ� ȣ��

	}

}
