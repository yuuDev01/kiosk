package menu;
import java.awt.*;
import javax.swing.*;

public class MenuTab extends JPanel{
	public MenuTab(){
		
		//메뉴화면 패널
    	setBackground(Color.white);  //페널 배경화면 설정
    	setSize(650,430); //패널 사이즈 조절
    	setLocation(16,50); //패널 위치 조절
    	
		JTabbedPane t = new JTabbedPane();  //탭팬 객체 t 생성

		//t.addTab("신상품",new Newer());
		t.addTab("coffee",new Coffee());  //첫번째 탭 생성 
		t.addTab("라떼/티",new Tea());  //두번쨰 탭 생성
		t.addTab("베이커리",new Bakery());  //세번쨰 탭 생성
				 
		t.setForeground(Color.white);  //글자색 지정
		t.setBackground(new Color(206,54, 54)); //선택되지 않은 탭 색 지정
	    this.add(t);  //패널에 탭 부착
	}

}
