package count;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import common.Info;
import menu.MenuItem;

public class CountDisply extends JPanel {
	public int count = 1; // 상품 개수
	JLabel jlCount; // 상품 갯수 라벨
	int num; // 벡터 인덱스값 저장할 int
	public JLabel Jname; // 상품명 적을 라벨
	public JLabel Jprice; // 상품가격 적을 라벨

	public CountDisply() {
	}
	public CountDisply(String name, String price, int num) {
		rowPanel(name, price); // rowPanel 메소드 호출
		this.num = num; // 벡터 인덱스 값 저장
	}

	public void rowPanel(String name, String price) {
		Info.sum += Integer.valueOf(price) * count; // 총가격

		JPanel rowPanel = new JPanel(); // 판넬 생성
		rowPanel.setPreferredSize(new Dimension(620, 40)); // 크기 지정
		rowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5)); // 판넬 레이아웃 지정
		Jname = new JLabel(name); // 상품명 라벨
		Jname.setPreferredSize(new Dimension(180, 30)); // 크기지정
		Jprice = new JLabel(price + " 원"); // 상품 가격 라벨
		Jprice.setPreferredSize(new Dimension(180, 30)); // 크기지정

		JButton btnPlus = new JButton("+"); // 갯수증가버튼
		btnPlus.setBackground(Color.DARK_GRAY); // 버튼 배경색 지정
		btnPlus.setForeground(Color.white); // 버튼 글자색 지정
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // 버튼 클릭시 액션 이벤트
				// TODO Auto-generated method stub
				count++; // count(상품 개수) 증가
				Info.sum += Integer.valueOf(price); // 총 금액에 증가시킨 상품의 가격을 더함
				Total.sum1.setText(Info.sum + ""); // 총 금액 라벨의 텍스트를 sum값으로 출력
				jlCount.setText(count + ""); // 상품 갯수 라벨에 count값 출력
			}
		});
		jlCount = new JLabel(count + "");

		JButton btnMinus = new JButton("-"); // 갯수 감소 버튼
		btnMinus.setBackground(Color.DARK_GRAY); // 버튼 배경색 지정
		btnMinus.setForeground(Color.WHITE); // 버튼 글자색 지정
		btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // 버튼 클릭시 액션 이벤트
				// TODO Auto-generated method stub

				if (count == 1) { // 상품 갯수가 1일 경우엔 sum과 count 변화 x 그대로 출력
					Total.sum1.setText(Info.sum + "");
				} else {
					Info.sum -= Integer.valueOf(price); // 1보다 큰 경우 상품 가격만큼 sum에서 뺌
					Total.sum1.setText(Info.sum + ""); // 총 금액 라벨의 텍스트를 sum값으로 출력
					--count; // count(상품 개수) 감소
					jlCount.setText(count + ""); // 상품 갯수 라벨에 count값 출력
				}
			}
		});

		JButton btnDel = new JButton("X");// 상품 삭제 버튼
		btnDel.setBackground(Color.WHITE); // 버튼 배경색 지정
		btnDel.setForeground(Color.DARK_GRAY); // 버튼 글자색 지정
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // x버튼 클릭시 이벤트
				// TODO Auto-generated method stub
				if (MenuItem.vCount.size() - 1 < num) { // 만약 num(item 추가한 순서 값)이 vCount의 총 크기보다 클 경우
					MenuItem.vCount.remove(0); // vCount의 0을 삭제
					MenuItem.number--; // Menuitem 클래스의 number수 감소
					Info.sum -= Integer.valueOf(price) * count; // 삭제한 아이템의 가격만큼 sum에서 감소시킴
					Total.sum1.setText(Info.sum + ""); // 총 금액 라벨의 텍스트를 sum값으로 출력
					Count.columnpanel.remove(rowPanel); // 아이템 출력한 판넬 삭제
					Count.columnpanel.revalidate(); // Count의 columnpanel 재배치
					Count.columnpanel.repaint(); // Count의 columnpanel 다시 그리기
				} else {
					MenuItem.vCount.remove(num);
					MenuItem.number--; // Menuitem 클래스의 number수 감소
					Info.sum -= Integer.valueOf(price) * count; // 삭제한 아이템의 가격만큼 sum에서 감소시킴
					Total.sum1.setText(Info.sum + ""); // 총 금액 라벨의 텍스트를 sum값으로 출력
					Count.columnpanel.remove(rowPanel); // 아이템 출력한 판넬 삭제
					Count.columnpanel.revalidate(); // Count의 columnpanel 재배치
					Count.columnpanel.repaint(); // Count의 columnpanel 다시 그리기
				}
			}
		});

		Total.sum1.setText(Info.sum + ""); // 총 금액 라벨의 텍스트를 sum값으로 출력
		
		// rowpanel에 컴포넌트 추가
		rowPanel.add(Jname);
		rowPanel.add(Jprice);
		rowPanel.add(btnMinus);
		rowPanel.add(jlCount);
		rowPanel.add(btnPlus);
		rowPanel.add(btnDel);
		rowPanel.setBackground(Color.WHITE);
		Count.columnpanel.add(rowPanel); // Count의 columnpanel에 rowpanel 추가

	}

}
