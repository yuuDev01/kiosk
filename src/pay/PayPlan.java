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
	private String[] txtCard = { "����", "�Ｚ", "�Ե�", "����", "īī��", "����", "BC", "�ϳ�" };
	private String[] tel = { "SKT", "KT", "U+" };
	private int index;
	private String telTxt;
	private String strPay;
	private String strCard;
	private JTextArea taList;
	private int intDis;
	private int intSum;

	public PayPlan() {
		setTitle("���� ���");
		setSize(430, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // �ݱ⸦ ���� �ش� �����Ӹ� �����
		setBackground(Color.white); // ��� �Ͼ��
		c = getContentPane();
		c.setLayout(null);

		discount(); // discount �޼ҵ� ȣ��

		setVisible(true);
	}

	public void discount() {
		// ��Ż� ���� ���� �ǳ�
		JPanel Discount = new JPanel(); // �ǳ� ����
		Discount.setBounds(10, 10, 400, 300); // ũ��, ��ġ ����
		Discount.setBackground(Color.white); // ���� ����
		Discount.setLayout(null); // ���̾ƿ� null
		Border border = BorderFactory.createTitledBorder("��Ż� ����"); // �׵θ� �����
		Discount.setBorder(border); // �ǳڿ� �׵θ� �ֱ�

		// ������Ʈ ����
		JLabel label = new JLabel("��Ż� ������ ���� ��� ��ȣ�� �Է��ϼ���.(10% ����)");
		label.setBounds(60, 50, 300, 30);

		// ��Ż� ������ ���� �޺��ڽ� ����
		JComboBox<String> telCombo = new JComboBox<String>(tel);
		telCombo.setBounds(50, 120, 70, 30);
		telCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox<String> cb = (JComboBox<String>) e.getSource(); // �̺�Ʈ�� ����Ǵ� �޺��ڽ� �Ӽ� ������
				index = cb.getSelectedIndex(); // ���� ������ �޺��ڽ� �ε��� ������
			}
		});

		// ��ȭ��ȣ �Է� �ؽ�Ʈ�ʵ�
		JTextField telNum = new JTextField("�޴���ȭ��ȣ �Է�");
		telNum.setBounds(130, 120, 120, 30); // ũ��,��ġ����
		telNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e); // ���콺�� Ŭ���� �ؽ�Ʈ�ʵ� ���� �����
				telNum.setText("");
			}
		});
		// �Է� ��ư
		JButton btnTel = new JButton("�Է�");
		btnTel.setBounds(260, 120, 80, 30); // ũ��,��ġ����
		btnTel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // ��ư Ŭ���� �׼��̺�Ʈ
				// TODO Auto-generated method stub
				telTxt = telNum.getText(); // telNum �ؽ�Ʈ�ʵ��� ���� ������
				if (telTxt.length() == 11) { // ���� telNum�� ������̰� 11�� ���
					intSum = Info.sum; // �ѱݾ��� intSum�� ����
					intDis = (int) (intSum * 0.1); // 10�� ���� �ݾ� ���ϱ�
					Info.sum -= intDis; // sum���� ���ΰ��ݸ�ŭ ���ҽ�Ŵ
					JOptionPane.showMessageDialog(null, "��Ż� ���� �� �ݾ� : " + Info.sum, "Noitem",
							JOptionPane.INFORMATION_MESSAGE); // ������ �ݾ� ���
				} else { // ���� 11�� �ƴϸ� ��ȣ�� ��Ȯ�� �Է��϶�� ���̾�α� ����
					JOptionPane.showMessageDialog(null, "��ȣ�� ��Ȯ�� �Է����ּ���", "Noitem", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		intSum = Info.sum; // �ѱݾ��� intSum�� ����
		intDis = 0;// ���αݾ� 0

		JButton btnNext = new JButton("����");
		btnNext.setBackground(Color.DARK_GRAY); // ��ư ���� ����
		btnNext.setForeground(Color.white); // ��ư ���ڻ� ����
		btnNext.setBounds(300, 180, 70, 30); 
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {    //next ��ư Ŭ����
				// TODO Auto-generated method stub 
				Discount.setVisible(false); //���� �ǳ� ������ �ʰ� ��
				payment();   //payment �޼ҵ� ����
			}
		});
		//������Ʈ �߰�
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
		Payment.setLayout(null);   //���̾ƿ�null
		Border border1 = BorderFactory.createTitledBorder("���� ���"); 
		Payment.setBorder(border1); //payment�ǳڿ� �׵θ� ����

		JPanel step1 = new JPanel();// ���� ��� 1(����orī��)
		JPanel step2 = new JPanel();// ���� ��� 2(ī�� ����)

		step1.setLayout(new FlowLayout(FlowLayout.CENTER));  //step1 �ǳ� ���̾ƿ��� flowlayout
		step1.setBackground(Color.white);
		step1.setBounds(20, 30, 370, 60); //ũ����ġ����
		step1.setBorder(BorderFactory.createTitledBorder("1"));  //�ɳڿ� �׵θ�����
		ButtonGroup g1 = new ButtonGroup();   //������ư �׷����
		JRadioButton cash = new JRadioButton("����");  //���� ������ư 
		cash.setBackground(Color.WHITE);
		cash.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {   //���� ���� ��ư ���ý�
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					strPay = "cash";     //strpay�� cash��
					strCard = null;      //card�� null
					step2.setVisible(false); //step2 �ǳ� ������ �ʰ� ��  
				}
			}
		});
		JRadioButton card = new JRadioButton("ī��"); //ī�� ���� ��ư
		card.setBackground(Color.WHITE);
		card.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {  //ī�� ���� ��ư ���ý�
					strPay = "card";
					step2.setVisible(true); //step2 �ǳ� ���̰� ��

				}
			}
		});
		
		//������Ʈ �߰�
		g1.add(card);
		g1.add(cash);
		step1.add(cash);
		step1.add(card);

		
		//step2 �ǳ�
		step2.setLayout(new FlowLayout(FlowLayout.LEFT)); //���̾ƿ��� flowlayout
		step2.setBounds(20, 100, 370, 60); //��ġ ũ�� ����
		step2.setBackground(Color.WHITE);  //��� ���
		step2.setBorder(BorderFactory.createTitledBorder("2")); //�ǳڿ� �׵θ� ����
		step2.setVisible(false);  //ó���� ������ �ʰ��� 
		ButtonGroup g2 = new ButtonGroup();   //���� ��ư�׷� ����
		JRadioButton[] rbCard = new JRadioButton[8]; //���� ��ư ���۷��� �迭 ����
		for (int i = 0; i < rbCard.length; i++) {
			rbCard[i] = new JRadioButton(txtCard[i]);  //�迭�� ũ�⸸ŭ ���� ��ư ����
			g2.add(rbCard[i]); //�׷쿡 ������ư�߰�
			step2.add(rbCard[i]); //�ǳڿ� ��ư �߰�
			rbCard[i].setBackground(Color.WHITE); //������ư ������ ��� 
			rbCard[i].addItemListener(new ItemListener() { //������ Ŭ����
				@Override
				public void itemStateChanged(ItemEvent e) { //������ ������ư�� ���� ���ڿ��� strcard�� �ֱ�
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
		//���� ��ư Ŭ��
		JButton btnNext2 = new JButton("����");
		btnNext2.setBounds(300, 180, 70, 30);
		btnNext2.setBackground(Color.DARK_GRAY); // ��ư ���� ����
		btnNext2.setForeground(Color.white); // ��ư ���ڻ� ����
		btnNext2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Payment.setVisible(false);   //���� �ǳ� ������ �ʰ� ��
				Success(); //success �޼ҵ� ����
			}
		});
		//������Ʈ �߰�
		Payment.add(step1);
		Payment.add(step2);
		Payment.add(btnNext2);
		c.add(Payment);
	}

	public void Success() {
		JPanel Success = new JPanel();  //�ǳ� ����
		Success.setBounds(10, 0, 400, 340); //��ġ ũ�� ����
		Success.setBackground(Color.WHITE);  //����������
		Success.setLayout(null); //���̾ƿ� null

		JLabel label1 = new JLabel("���� �Ϸ� �Ǿ����ϴ�."); //���� �Ϸ� �� ����
		label1.setBounds(145, 10, 300, 30); //��ġ ũ�� ����

		JLabel label2 = new JLabel("<�ֹ�����>"); //�ֹ����� �� ����
		label2.setBounds(165, 50, 300, 30); //��ġ ũ�� ����

		taList = new JTextArea(10, 20);  //textarea ����
		JScrollPane sp = new JScrollPane(taList); //��ũ���� ����
		sp.setBounds(30, 80, 340, 100); //��ġ ũ�� ����
		for (int i = 0; i < MenuItem.vCount.size(); i++) {  //vCount ���� �ױ⸸ŭ �ݺ�
			CountDisply cp = MenuItem.vCount.get(i);  //vCount[i]�� �ִ� Countdisply��� ��ü ���� 
			if (cp.Jname.getText().length() > 7) { //���� ��ǰ�̸� ���̰� 7���� Ŭ ���
				taList.append(cp.Jname.getText() + " \t" + cp.Jprice.getText() + "\t" + cp.count + "��\n"); //t�ѹ��ϰ� �̸�, ����, ���� ���
			} else {
				taList.append(cp.Jname.getText() + " \t\t" + cp.Jprice.getText() + "\t" + cp.count + "��\n");//t�ι��ϰ� �̸�, ����, ���� ���

			}
		}
		
		//�� �ݾ� ����� �� ��ü ����
		JLabel label3 = new JLabel("�� �ݾ� : " + intSum);
		label3.setBounds(200, 180, 150, 30);

		//������ �ݾ� ����� �� ��ü ����
		JLabel label4 = new JLabel("���� �ݾ� : " + intDis);
		label4.setBounds(200, 205, 150, 30);

		//���� ���� �ݾ� ��� �� ����
		JLabel label5 = new JLabel("���� �ݾ� : " + Info.sum);
		label5.setBounds(200, 240, 120, 30);
		label5.setFont(new Font("����ü", Font.BOLD, 13));

		//����ũ�ƿ����� �ƴ��� ��� �� ����
		JLabel label6 = new JLabel();
		label6.setBounds(30, 220, 100, 50);
		if (Info.inout == true)
			label6.setText("DINE-IN");
		else
			label6.setText("TAKE-OUT");
		
		//������� ��� ��
		JLabel laPay= new JLabel(strPay +"  "+ strCard);
		laPay.setBounds(30, 180, 120, 30);

		//�Ϸ� ��ư ����
		Button btnClose = new Button("�Ϸ�");
		btnClose.setBounds(300, 270, 80, 30);
		btnClose.setBackground(Color.DARK_GRAY); // ��ư ���� ����
		btnClose.setForeground(Color.white);
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);  //Ŭ���� ���α׷� ����
			}
		});	
		//������Ʈ �߰�
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
