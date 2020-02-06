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
	JPanel[] jp = new JPanel[30]; // �г� �迭 ����
	JButton jbtn; // �̹����� ���� ��ư ���� ����
	JLabel lname; // ��ǰ���� ���� �� ���� ����
	JLabel lprice; // ������ ���� �� ���� ����
	JPanel p1 = new JPanel(new GridLayout(0, 4));  
	public static int number=0; //vCount ������ ���� number ����
	public static Vector<CountDisply> vCount = new Vector<CountDisply>();  //CountDisply��ü�� ��� vCount ���� ����

	public void item(String[] img, String[] name, String[] price, int num) {
		for (int i = 0; i < num; i++) {

			// �̹��� ������ ��ü����
			ImageIcon icon = new ImageIcon(img[i]); // �Ķ���ͷ� �޾ƿ� �̹������ ���ڿ� �迭 �� i���� ���ڿ��� ������
			Image img1 = icon.getImage().getScaledInstance(120, 100, java.awt.Image.SCALE_SMOOTH); // �̹���ũ������
			icon = new ImageIcon(img1); // ������ �̹����� icon�� ����

			// �޴� �������� ���� �г� �迭
			jp[i] = new JPanel(); // �г� �迭�� ��ü ����
			jp[i].setLayout(null); // layout�� null
			jp[i].setBackground(new Color(213, 213, 213)); // �г��� ��漳��
			jp[i].setPreferredSize(new Dimension(120, 150)); // �г��� ũ�� ����
			jp[i].setBorder(BorderFactory.createLineBorder(Color.black)); // �гο� �׵θ� ����

			// ��ư
			jbtn = new JButton(); // ��ư ��ü ����
			jbtn.setBackground(Color.white); // ��ư�� ���� ����
			jbtn.setIcon(icon); // icon�� ��ư�� ����
			jbtn.setBounds(0, 0, 145, 100); // ��ư�� ��ġ ����
			int a = i;
			jbtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					vCount.add(new CountDisply(name[a], price[a], number));  //���� vCount�� countdisply�߰�
					number++;  //number ����
					revalidate(); //���ġ
					repaint(); //�ٽ� �׸�
				}
			});

			// ��ǰ��
			lname = new JLabel(); // �� ��ü ����
			lname.setText(name[i]); // �Ķ���ͷ� �޾ƿ� ��ǰ�� ���ڿ� �迭 �� i���� ���ڿ��� ������
			lname.setBounds(0, 110, 120, 20); // ���� ��ġ ����

			// ����
			lprice = new JLabel(); // �� ��ü ����
			lprice.setText(price[i]); // �Ķ���ͷ� �޾ƿ� ���� ���ڿ� �迭 �� i���� ���ڿ��� ������
			lprice.setBounds(45, 130, 120, 20); // ���� ��ġ ����

			jp[i].add(jbtn); // �гο� ��ư ����
			jp[i].add(lname); // �гο� ��ǰ�� �� ����
			jp[i].add(lprice); // �гο� ��ǰ���� �� ����
			p1.add(jp[i]);
		}

	}
}
