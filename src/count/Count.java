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

		sp = new JScrollPane(); //스크롤팬 객체 생성
		sp.setPreferredSize(new Dimension(640, 170)); //크기조정

		borderPanel = new JPanel(); //판넬 생성
		sp.setViewportView(borderPanel); // 스크롤팬에 판넬넣기
		borderPanel.setLayout(new BorderLayout(0, 0)); //레이아웃을 borderlayout. 간격은 0
		add(sp); // 현재 판넬에 스크롤팬 달기
		
		columnpanel = new JPanel();  //borderpanel 내부에 넣을 판넬 객체 생성
		borderPanel.add(columnpanel, BorderLayout.NORTH); //NORTH에 columnpanel 넣기
		columnpanel.setLayout(new GridLayout(0, 1, 0, 1)); //행은 정해지지 x 열만 1로 그리드레이아웃
		columnpanel.setBackground(Color.DARK_GRAY); //배경색 다크그레이
		
	}
}