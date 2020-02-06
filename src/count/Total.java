package count;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.Info;

public class Total extends JPanel {
	public static JLabel sum1; // 총 금액 출력할 라벨을 static로 생성

	public Total() {
		setSize(650, 40);
		setLocation(16, 670);
		setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 7)); // 레이아웃은 flowlayout
		JLabel total = new JLabel("총 금액  :");
		total.setFont(new Font("굴림체", Font.BOLD, 15)); // 폰트 굴림체,두껍게, 크기 15
		sum1 = new JLabel("  0 ");
		sum1.setFont(new Font("굴림체", Font.BOLD, 15)); // 폰트 굴림체,두껍게, 크기 15
		JLabel won = new JLabel("원");
		won.setFont(new Font("굴림체", Font.BOLD, 15)); // 폰트 굴림체,두껍게, 크기 15
		add(total);
		add(sum1);
		add(won);
	}

}
