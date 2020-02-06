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

		// container ����
		Container c = getContentPane();
		c.setLayout(null); // ���̾ƿ� null
		c.setBackground(Color.DARK_GRAY); // ���� ����

		// �ΰ� �̹���
		ImageIcon icon = new ImageIcon("Images/logo.png"); // ������ ����
		Image img = icon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH); // ũ�� ����
		icon = new ImageIcon(img); // ������ �̹̽ø� �ٽ� ����
		JLabel logo = new JLabel(icon); // �󺧿� ������ ����
		logo.setSize(40, 40); // �� ũ�� ����
		logo.setLocation(315, 5); // ��ġ ����
		c.add(logo); // �����̳ʿ� ����

		// JPanel ����
		MenuTab menu = new MenuTab(); // �޴� �г� ��ü ����
		Count count = new Count(); // �������� �г� ��ü ����(�̿ϼ�)
		Total total = new Total(); // �� ��ǰ���� �г� ����
		Pay pay = new Pay(); // ���� �г� ����

		// �����̳ʿ� ����
		c.add(menu);
		c.add(count);
		c.add(total);
		c.add(pay.Jpay);

		setSize(700, 830); // ũ�� ����
		setVisible(true); // ���� �� �ֵ���
	}
}
