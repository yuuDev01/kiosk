package pay;

import javax.swing.*;
import javax.swing.border.Border;

import menu.MenuItem;
import common.Info;
import count.CountDisply;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PayPlan extends JFrame {
	Container c;
	private String[] txtCard = { "현대", "삼성", "롯데", "농협", "카카오", "신한", "BC", "하나" };
	private String[] tel = { "SKT", "KT", "U+" };
	private int index;
	private String telTxt;
	private String strPay;
	private String strCard;
	private JTextArea taList;
	private int intDis;
	private int intSum;

	public PayPlan() {
		setTitle("결제 방식");
		setSize(430, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 닫기를 누른 해당 프레임만 사라짐
		setBackground(Color.white); // 배경 하얀색
		c = getContentPane();
		c.setLayout(null);

		discount(); // discount 메소드 호출

		setVisible(true);
	}

	public void discount() {
		// 통신사 할인 선택 판넬
		JPanel Discount = new JPanel(); // 판넬 생성
		Discount.setBounds(10, 10, 400, 300); // 크기, 위치 지정
		Discount.setBackground(Color.white); // 색상 지정
		Discount.setLayout(null); // 레이아웃 null
		Border border = BorderFactory.createTitledBorder("통신사 할인"); // 테두리 만들기
		Discount.setBorder(border); // 판넬에 테두리 넣기

		// 컴포넌트 부착
		JLabel label = new JLabel("통신사 할인을 원할 경우 번호를 입력하세요.(10% 할인)");
		label.setBounds(60, 50, 300, 30);

		// 통신사 선택을 위한 콤보박스 생성
		JComboBox<String> telCombo = new JComboBox<String>(tel);
		telCombo.setBounds(50, 120, 70, 30);
		telCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox<String> cb = (JComboBox<String>) e.getSource(); // 이벤트를 실행되는 콤보박스 속성 가져옴
				index = cb.getSelectedIndex(); // 현재 선택한 콤보박스 인덱스 가져옴
			}
		});

		// 전화번호 입력 텍스트필드
		JTextField telNum = new JTextField("휴대전화번호 입력");
		telNum.setBounds(130, 120, 120, 30); // 크기,위치지정
		telNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e); // 마우스로 클릭시 텍스트필드 내용 지우기
				telNum.setText("");
			}
		});
		// 입력 버튼
		JButton btnTel = new JButton("입력");
		btnTel.setBounds(260, 120, 80, 30); // 크기,위치지정
		btnTel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // 버튼 클릭시 액션이벤트
				// TODO Auto-generated method stub
				telTxt = telNum.getText(); // telNum 텍스트필드의 내용 가져옴
				if (telTxt.length() == 11) { // 만약 telNum의 내용길이가 11일 경우
					intSum = Info.sum; // 총금액을 intSum에 저장
					intDis = (int) (intSum * 0.1); // 10퍼 할인 금액 구하기
					Info.sum -= intDis; // sum에서 할인가격만큼 감소시킴
					JOptionPane.showMessageDialog(null, "통신사 할인 후 금액 : " + Info.sum, "Noitem",
							JOptionPane.INFORMATION_MESSAGE); // 할인한 금액 출력
				} else { // 만약 11이 아니면 번호를 정확히 입력하라는 다이얼로그 생성
					JOptionPane.showMessageDialog(null, "번호를 정확히 입력해주세요", "Noitem", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		intSum = Info.sum; // 총금액을 intSum에 저장
		intDis = 0;// 할인금액 0

		JButton btnNext = new JButton("다음");
		btnNext.setBackground(Color.DARK_GRAY); // 버튼 배경색 지정
		btnNext.setForeground(Color.white); // 버튼 글자색 지정
		btnNext.setBounds(300, 180, 70, 30); 
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {    //next 버튼 클릭스
				// TODO Auto-generated method stub 
				Discount.setVisible(false); //현재 판넬 보이지 않게 함
				payment();   //payment 메소드 실행
			}
		});
		//컴포넌트 추가
		Discount.add(label);
		Discount.add(telCombo);
		Discount.add(telNum);
		Discount.add(btnTel);
		Discount.add(btnNext);
		c.add(Discount);
	   }

	public void payment() {
		JPanel Payment = new JPanel();
		Payment.setBounds(10, 10, 400, 300);
		Payment.setBackground(Color.white);
		Payment.setLayout(null);   //레이아웃null
		Border border1 = BorderFactory.createTitledBorder("지불 방식"); 
		Payment.setBorder(border1); //payment판넬에 테두리 생성

		JPanel step1 = new JPanel();// 지불 방식 1(현금or카드)
		JPanel step2 = new JPanel();// 지불 방식 2(카드 종류)

		step1.setLayout(new FlowLayout(FlowLayout.CENTER));  //step1 판넬 레이아웃을 flowlayout
		step1.setBackground(Color.white);
		step1.setBounds(20, 30, 370, 60); //크기위치지정
		step1.setBorder(BorderFactory.createTitledBorder("1"));  //핀넬에 테두리생성
		ButtonGroup g1 = new ButtonGroup();   //라디오버튼 그룹생성
		JRadioButton cash = new JRadioButton("현금");  //현금 라디오버튼 
		cash.setBackground(Color.WHITE);
		cash.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {   //현금 라디오 버튼 선택시
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					strPay = "cash";     //strpay는 cash로
					strCard = null;      //card는 null
					step2.setVisible(false); //step2 판넬 보이지 않게 함  
				}
			}
		});
		JRadioButton card = new JRadioButton("카드"); //카드 라디오 버튼
		card.setBackground(Color.WHITE);
		card.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {  //카드 라디오 버튼 선택시
					strPay = "card";
					step2.setVisible(true); //step2 판넬 보이게 함

				}
			}
		});
		
		//컴포넌트 추가
		g1.add(card);
		g1.add(cash);
		step1.add(cash);
		step1.add(card);

		
		//step2 판넬
		step2.setLayout(new FlowLayout(FlowLayout.LEFT)); //레이아웃은 flowlayout
		step2.setBounds(20, 100, 370, 60); //위치 크기 지정
		step2.setBackground(Color.WHITE);  //배경 흰색
		step2.setBorder(BorderFactory.createTitledBorder("2")); //판넬에 테두리 생성
		step2.setVisible(false);  //처음엔 보이지 않게함 
		ButtonGroup g2 = new ButtonGroup();   //라디오 버튼그룹 생성
		JRadioButton[] rbCard = new JRadioButton[8]; //라디오 버튼 레퍼런스 배열 생성
		for (int i = 0; i < rbCard.length; i++) {
			rbCard[i] = new JRadioButton(txtCard[i]);  //배열의 크기만큼 라디오 버튼 생성
			g2.add(rbCard[i]); //그룹에 라디오버튼추가
			step2.add(rbCard[i]); //판넬에 버튼 추간
			rbCard[i].setBackground(Color.WHITE); //라디오버튼 색상은 흰색 
			rbCard[i].addItemListener(new ItemListener() { //아이템 클릭시
				@Override
				public void itemStateChanged(ItemEvent e) { //선택한 라디오버튼에 적힌 문자열을 strcard에 넣기
					// TODO Auto-generated method stub
					if (rbCard[0].isSelected()) {
						strCard = txtCard[0];  
					}
					if (rbCard[1].isSelected()) {
						strCard = txtCard[1];
					}
					if (rbCard[2].isSelected()) {
						strCard = txtCard[2];
					}
					if (rbCard[3].isSelected()) {
						strCard = txtCard[3];
					}
					if (rbCard[4].isSelected()) {
						strCard = txtCard[4];
					}
					if (rbCard[5].isSelected()) {
						strCard = txtCard[5];
					}
					if (rbCard[6].isSelected()) {
						strCard = txtCard[6];
					}
					if (rbCard[7].isSelected()) {
						strCard = txtCard[7];
					}
				}
			});
		}
		//결제 버튼 클릭
		JButton btnNext2 = new JButton("결제");
		btnNext2.setBounds(300, 180, 70, 30);
		btnNext2.setBackground(Color.DARK_GRAY); // 버튼 배경색 지정
		btnNext2.setForeground(Color.white); // 버튼 글자색 지정
		btnNext2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Payment.setVisible(false);   //현재 판넬 보이지 않게 함
				Success(); //success 메소드 실행
			}
		});
		//컴포넌트 추가
		Payment.add(step1);
		Payment.add(step2);
		Payment.add(btnNext2);
		c.add(Payment);
	}

	public void Success() {
		JPanel Success = new JPanel();  //판넬 생성
		Success.setBounds(10, 0, 400, 340); //위치 크기 지정
		Success.setBackground(Color.WHITE);  //배경색상지정
		Success.setLayout(null); //레이아웃 null

		JLabel label1 = new JLabel("결제 완료 되었습니다."); //결제 완료 라벨 생성
		label1.setBounds(145, 10, 300, 30); //위치 크기 지정

		JLabel label2 = new JLabel("<주문내역>"); //주문내역 라벨 생성
		label2.setBounds(165, 50, 300, 30); //위치 크기 지정

		taList = new JTextArea(10, 20);  //textarea 생성
		JScrollPane sp = new JScrollPane(taList); //스크롤팬 부착
		sp.setBounds(30, 80, 340, 100); //위치 크기 지정
		for (int i = 0; i < MenuItem.vCount.size(); i++) {  //vCount 벡터 그기만큼 반복
			CountDisply cp = MenuItem.vCount.get(i);  //vCount[i]에 있는 Countdisply담는 객체 생성 
			if (cp.Jname.getText().length() > 7) { //만약 상품이름 길이가 7보다 클 경우
				taList.append(cp.Jname.getText() + " \t" + cp.Jprice.getText() + "\t" + cp.count + "개\n"); //t한번하고 이름, 가격, 개수 출력
			} else {
				taList.append(cp.Jname.getText() + " \t\t" + cp.Jprice.getText() + "\t" + cp.count + "개\n");//t두번하고 이름, 가격, 개수 출력

			}
		}
		
		//총 금액 출력할 라벨 객체 생성
		JLabel label3 = new JLabel("총 금액 : " + intSum);
		label3.setBounds(200, 180, 150, 30);

		//할인한 금액 출력할 라벨 객체 생성
		JLabel label4 = new JLabel("할인 금액 : " + intDis);
		label4.setBounds(200, 205, 150, 30);

		//최종 결제 금액 출력 라벨 생성
		JLabel label5 = new JLabel("결제 금액 : " + Info.sum);
		label5.setBounds(200, 240, 120, 30);
		label5.setFont(new Font("굴림체", Font.BOLD, 13));

		//테이크아웃인지 아닌지 출력 라벨 생성
		JLabel label6 = new JLabel();
		label6.setBounds(30, 220, 100, 50);
		if (Info.inout == true)
			label6.setText("DINE-IN");
		else
			label6.setText("TAKE-OUT");
		
		//결제방식 출력 라벨
		JLabel laPay= new JLabel(strPay +"  "+ strCard);
		laPay.setBounds(30, 180, 120, 30);

		//완료 버튼 생성
		Button btnClose = new Button("완료");
		btnClose.setBounds(300, 270, 80, 30);
		btnClose.setBackground(Color.DARK_GRAY); // 버튼 배경색 지정
		btnClose.setForeground(Color.white);
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);  //클릭시 프로그램 종료
			}
		});	
		//컴포넌트 추가
		Success.add(label1);
		Success.add(label2);
		Success.add(label3);
		Success.add(label4);
		Success.add(label5);
		Success.add(label6);
		Success.add(laPay);
		Success.add(btnClose);
		Success.add(sp);
		Success.setVisible(true); 
		c.add(Success);
	}
}
