package count;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Count extends JPanel {
	public static JPanel columnpanel;
	public static JScrollPane sp;
	public static JPanel borderPanel;
	
	public Count() {
		setSize(650, 180);
		setLocation(16, 492);

		sp = new JScrollPane(); //��ũ���� ��ü ����
		sp.setPreferredSize(new Dimension(640, 170)); //ũ������

		borderPanel = new JPanel(); //�ǳ� ����
		sp.setViewportView(borderPanel); // ��ũ���ҿ� �ǳڳֱ�
		borderPanel.setLayout(new BorderLayout(0, 0)); //���̾ƿ��� borderlayout. ������ 0
		add(sp); // ���� �ǳڿ� ��ũ���� �ޱ�
		
		columnpanel = new JPanel();  //borderpanel ���ο� ���� �ǳ� ��ü ����
		borderPanel.add(columnpanel, BorderLayout.NORTH); //NORTH�� columnpanel �ֱ�
		columnpanel.setLayout(new GridLayout(0, 1, 0, 1)); //���� �������� x ���� 1�� �׸��巹�̾ƿ�
		columnpanel.setBackground(Color.DARK_GRAY); //���� ��ũ�׷���
		
	}
}