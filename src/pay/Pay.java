package pay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import menu.MenuItem;

public class Pay extends JPanel {
	public JPanel Jpay = new JPanel(); // 패널 객체 생성

	public Pay() {
		Jpay.setSize(650, 50); // 패널 사이즈 지정
		Jpay.setLocation(16, 725); // 패널 위치 지정
		Jpay.setBackground(Color.white); // 패널 배경색 지정

		JButton Bpay = new JButton(); // 지불 버튼 객체 생성
		Bpay.setText("결           제"); // 버튼 문자열 지정
		Bpay.setPreferredSize(new Dimension(200, 40)); // 버튼 크기지정
		Bpay.setBackground(Color.DARK_GRAY); // 버튼 배경색 지정
		Bpay.setForeground(Color.white); // 버튼 글자색 지정
		Bpay.setFont(new Font("굴림체", Font.BOLD, 15));
		Bpay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MenuItem.vCount.size() > 0) { // 만약 vCount 벡터가 0이상이면 payPaln 객체 생성
					new PayPlan();
				} else {// 0미만이면 상품을 선택하라는 메시지다이얼로그 생성
					JOptionPane.showMessageDialog(null, "상품을 선택해주세요", "Noitem", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton Bcancel = new JButton(); // 결제 취소 버튼
		Bcancel.setText("취          소"); // 버튼 문자열 지정
		Bcancel.setPreferredSize(new Dimension(200, 40)); // 버튼 크기지정
		Bcancel.setBackground(Color.DARK_GRAY); // 버튼 배겅색 지정
		Bcancel.setForeground(Color.white); // 버튼 글자색 지정
		Bcancel.setFont(new Font("굴림체", Font.BOLD, 15));
		Bcancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0); // 클릭시 프로그램 종료
			}
		});
		Jpay.add(Bpay); // 패널에 부착
		Jpay.add(Bcancel); // 패널에 부착
	}
}
