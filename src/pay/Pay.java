package pay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import menu.MenuItem;

public class Pay extends JPanel {
	public JPanel Jpay = new JPanel(); // �г� ��ü ����

	public Pay() {
		Jpay.setSize(650, 50); // �г� ������ ����
		Jpay.setLocation(16, 725); // �г� ��ġ ����
		Jpay.setBackground(Color.white); // �г� ���� ����

		JButton Bpay = new JButton(); // ���� ��ư ��ü ����
		Bpay.setText("��           ��"); // ��ư ���ڿ� ����
		Bpay.setPreferredSize(new Dimension(200, 40)); // ��ư ũ������
		Bpay.setBackground(Color.DARK_GRAY); // ��ư ���� ����
		Bpay.setForeground(Color.white); // ��ư ���ڻ� ����
		Bpay.setFont(new Font("����ü", Font.BOLD, 15));
		Bpay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MenuItem.vCount.size() > 0) { // ���� vCount ���Ͱ� 0�̻��̸� payPaln ��ü ����
					new PayPlan();
				} else {// 0�̸��̸� ��ǰ�� �����϶�� �޽������̾�α� ����
					JOptionPane.showMessageDialog(null, "��ǰ�� �������ּ���", "Noitem", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton Bcancel = new JButton(); // ���� ��� ��ư
		Bcancel.setText("��          ��"); // ��ư ���ڿ� ����
		Bcancel.setPreferredSize(new Dimension(200, 40)); // ��ư ũ������
		Bcancel.setBackground(Color.DARK_GRAY); // ��ư ��ϻ� ����
		Bcancel.setForeground(Color.white); // ��ư ���ڻ� ����
		Bcancel.setFont(new Font("����ü", Font.BOLD, 15));
		Bcancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0); // Ŭ���� ���α׷� ����
			}
		});
		Jpay.add(Bpay); // �гο� ����
		Jpay.add(Bcancel); // �гο� ����
	}
}
