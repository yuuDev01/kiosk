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

		// container ����
		Container c = getContentPane();
		c.setLayout(null); // ���̾ƿ� null
		c.setBackground(Color.DARK_GRAY); // ���� ����

		// �ΰ� �̹���
		ImageIcon icon = new ImageIcon("Images/logo.png"); // ������ ����
		Image img = icon.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH); // ũ�� ����
		icon = new ImageIcon(img); // ������ �̹̽ø� �ٽ� ����
		JLabel logo = new JLabel(icon); // �󺧿� ������ ����
		logo.setSize(150, 150); // �� ũ�� ����
		logo.setLocation(170, 120); // ��ġ ����
		c.add(logo); // �����̳ʿ� ����

		JButton toHere = new JButton("DINE-IN");
		toHere.setPreferredSize(new Dimension(200, 50)); // ��ư ũ������
		toHere.setBackground(Color.white); // ��ư ���� ����
		toHere.setForeground(Color.DARK_GRAY); // ��ư ���ڻ� ����
		toHere.setFont(new Font("����ü", Font.BOLD, 15));
		toHere.setBounds(140, 310, 210, 60);
		toHere.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Info.inout = true;
				new KioskMain();
				setVisible(false); // �Ⱥ���
			}
		});

		JButton takeOut = new JButton("TAKE-OUT");
		takeOut.setPreferredSize(new Dimension(200, 50)); // ��ư ũ������
		takeOut.setBackground(Color.white); // ��ư ���� ����
		takeOut.setForeground(Color.DARK_GRAY); // ��ư ���ڻ� ����
		takeOut.setFont(new Font("����ü", Font.BOLD, 15));
		takeOut.setBounds(140, 380, 210, 60);
		takeOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Info.inout = false;
				new KioskMain();
				setVisible(false); // �Ⱥ���
			}
		});

		c.add(toHere);
		c.add(takeOut);
		setSize(500, 600); // ũ�� ����
		setVisible(true); // ���� �� �ֵ���
	}

	public static void main(String[] args) {
		new KioskStart(); // KioskMain ��ü ����
	}
}
