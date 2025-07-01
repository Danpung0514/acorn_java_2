package test.frame04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame_2 extends JFrame implements ActionListener{
	
	// 버튼의 참조값을 담을 필드
	JButton countBtn;
	// 버튼을 누른 횟수를 저장할 필드
	int count = 0;
	
	// 생성자
	public MyFrame_2() {
		setTitle("나의 프레임");
		setBounds(100, 100, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 레이아웃 매니저 객체 생성
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		// 프레임의 레이아웃 매니저 설정
		setLayout(layout);
		/*this.*/countBtn = new JButton("0");
		add(countBtn);
//		countBtn.addActionListener((e)->{
//			int btnNum = Integer.parseInt(countBtn.getText());
//			btnNum++;
//			countBtn.setText(String.valueOf(btnNum));
//		});
		countBtn.addActionListener(this);
		
		
		
		
		// 버튼의 이름 바꾸기
//		countBtn.setText("1");
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame_2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// count 값을 1 증가 시킨다
		count++;
		countBtn.setText(Integer.toString(count));
	}
}
