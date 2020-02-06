package count;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import common.Info;
import menu.MenuItem;

public class CountDisply extends JPanel {
	public int count = 1; // ��ǰ ����
	JLabel jlCount; // ��ǰ ���� ��
	int num; // ���� �ε����� ������ int
	public JLabel Jname; // ��ǰ�� ���� ��
	public JLabel Jprice; // ��ǰ���� ���� ��

	public CountDisply() {
	}
	public CountDisply(String name, String price, int num) {
		rowPanel(name, price); // rowPanel �޼ҵ� ȣ��
		this.num = num; // ���� �ε��� �� ����
	}

	public void rowPanel(String name, String price) {
		Info.sum += Integer.valueOf(price) * count; // �Ѱ���

		JPanel rowPanel = new JPanel(); // �ǳ� ����
		rowPanel.setPreferredSize(new Dimension(620, 40)); // ũ�� ����
		rowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5)); // �ǳ� ���̾ƿ� ����
		Jname = new JLabel(name); // ��ǰ�� ��
		Jname.setPreferredSize(new Dimension(180, 30)); // ũ������
		Jprice = new JLabel(price + " ��"); // ��ǰ ���� ��
		Jprice.setPreferredSize(new Dimension(180, 30)); // ũ������

		JButton btnPlus = new JButton("+"); // ����������ư
		btnPlus.setBackground(Color.DARK_GRAY); // ��ư ���� ����
		btnPlus.setForeground(Color.white); // ��ư ���ڻ� ����
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // ��ư Ŭ���� �׼� �̺�Ʈ
				// TODO Auto-generated method stub
				count++; // count(��ǰ ����) ����
				Info.sum += Integer.valueOf(price); // �� �ݾ׿� ������Ų ��ǰ�� ������ ����
				Total.sum1.setText(Info.sum + ""); // �� �ݾ� ���� �ؽ�Ʈ�� sum������ ���
				jlCount.setText(count + ""); // ��ǰ ���� �󺧿� count�� ���
			}
		});
		jlCount = new JLabel(count + "");

		JButton btnMinus = new JButton("-"); // ���� ���� ��ư
		btnMinus.setBackground(Color.DARK_GRAY); // ��ư ���� ����
		btnMinus.setForeground(Color.WHITE); // ��ư ���ڻ� ����
		btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // ��ư Ŭ���� �׼� �̺�Ʈ
				// TODO Auto-generated method stub

				if (count == 1) { // ��ǰ ������ 1�� ��쿣 sum�� count ��ȭ x �״�� ���
					Total.sum1.setText(Info.sum + "");
				} else {
					Info.sum -= Integer.valueOf(price); // 1���� ū ��� ��ǰ ���ݸ�ŭ sum���� ��
					Total.sum1.setText(Info.sum + ""); // �� �ݾ� ���� �ؽ�Ʈ�� sum������ ���
					--count; // count(��ǰ ����) ����
					jlCount.setText(count + ""); // ��ǰ ���� �󺧿� count�� ���
				}
			}
		});

		JButton btnDel = new JButton("X");// ��ǰ ���� ��ư
		btnDel.setBackground(Color.WHITE); // ��ư ���� ����
		btnDel.setForeground(Color.DARK_GRAY); // ��ư ���ڻ� ����
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // x��ư Ŭ���� �̺�Ʈ
				// TODO Auto-generated method stub
				if (MenuItem.vCount.size() - 1 < num) { // ���� num(item �߰��� ���� ��)�� vCount�� �� ũ�⺸�� Ŭ ���
					MenuItem.vCount.remove(0); // vCount�� 0�� ����
					MenuItem.number--; // Menuitem Ŭ������ number�� ����
					Info.sum -= Integer.valueOf(price) * count; // ������ �������� ���ݸ�ŭ sum���� ���ҽ�Ŵ
					Total.sum1.setText(Info.sum + ""); // �� �ݾ� ���� �ؽ�Ʈ�� sum������ ���
					Count.columnpanel.remove(rowPanel); // ������ ����� �ǳ� ����
					Count.columnpanel.revalidate(); // Count�� columnpanel ���ġ
					Count.columnpanel.repaint(); // Count�� columnpanel �ٽ� �׸���
				} else {
					MenuItem.vCount.remove(num);
					MenuItem.number--; // Menuitem Ŭ������ number�� ����
					Info.sum -= Integer.valueOf(price) * count; // ������ �������� ���ݸ�ŭ sum���� ���ҽ�Ŵ
					Total.sum1.setText(Info.sum + ""); // �� �ݾ� ���� �ؽ�Ʈ�� sum������ ���
					Count.columnpanel.remove(rowPanel); // ������ ����� �ǳ� ����
					Count.columnpanel.revalidate(); // Count�� columnpanel ���ġ
					Count.columnpanel.repaint(); // Count�� columnpanel �ٽ� �׸���
				}
			}
		});

		Total.sum1.setText(Info.sum + ""); // �� �ݾ� ���� �ؽ�Ʈ�� sum������ ���
		
		// rowpanel�� ������Ʈ �߰�
		rowPanel.add(Jname);
		rowPanel.add(Jprice);
		rowPanel.add(btnMinus);
		rowPanel.add(jlCount);
		rowPanel.add(btnPlus);
		rowPanel.add(btnDel);
		rowPanel.setBackground(Color.WHITE);
		Count.columnpanel.add(rowPanel); // Count�� columnpanel�� rowpanel �߰�

	}

}
