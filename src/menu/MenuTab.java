package menu;
import java.awt.*;
import javax.swing.*;

public class MenuTab extends JPanel{
	public MenuTab(){
		
		//�޴�ȭ�� �г�
    	setBackground(Color.white);  //��� ���ȭ�� ����
    	setSize(650,430); //�г� ������ ����
    	setLocation(16,50); //�г� ��ġ ����
    	
		JTabbedPane t = new JTabbedPane();  //���� ��ü t ����

		//t.addTab("�Ż�ǰ",new Newer());
		t.addTab("coffee",new Coffee());  //ù��° �� ���� 
		t.addTab("��/Ƽ",new Tea());  //�ι��� �� ����
		t.addTab("����Ŀ��",new Bakery());  //������ �� ����
				 
		t.setForeground(Color.white);  //���ڻ� ����
		t.setBackground(new Color(206,54, 54)); //���õ��� ���� �� �� ����
	    this.add(t);  //�гο� �� ����
	}

}
