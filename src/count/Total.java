package count;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.Info;

public class Total extends JPanel {
	public static JLabel sum1; // �� �ݾ� ����� ���� static�� ����

	public Total() {
		setSize(650, 40);
		setLocation(16, 670);
		setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 7)); // ���̾ƿ��� flowlayout
		JLabel total = new JLabel("�� �ݾ�  :");
		total.setFont(new Font("����ü", Font.BOLD, 15)); // ��Ʈ ����ü,�β���, ũ�� 15
		sum1 = new JLabel("  0 ");
		sum1.setFont(new Font("����ü", Font.BOLD, 15)); // ��Ʈ ����ü,�β���, ũ�� 15
		JLabel won = new JLabel("��");
		won.setFont(new Font("����ü", Font.BOLD, 15)); // ��Ʈ ����ü,�β���, ũ�� 15
		add(total);
		add(sum1);
		add(won);
	}

}
