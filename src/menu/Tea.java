package menu;
import java.awt.*;
import javax.swing.*;

import common.Info;

public class Tea extends MenuItem{
	public Tea() {
		
		p1.setBackground(new Color(234,234,234)); //�ǳ��� ���� ����
		JScrollPane sp1 = new JScrollPane(); //��ũ���� sp1 ����
		sp1.setPreferredSize(new Dimension(600,380));  //sp1 ũ�� ����
		sp1.setViewportView(p1); //p1�� sp1�� ����
		add(sp1);  //sp1�� ������
	
	item(Info.teaimg,Info.teanam,Info.teaprice,Info.teanum); //�θ�Ŭ���� �Լ� ȣ��

	   
	}

	}
