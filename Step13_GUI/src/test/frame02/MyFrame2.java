package test.frame02;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 *  Graphic User Interface 를 만들 수 있는 클래스 설계하기
 *  
 *  1. Jframe 클래스를 상속 받는다.
 *  2. 생성자에서 필요한 초기화 작업을 한다.
 *  3. main() 메소드에서 이 클래스로 객체를 생성하면 프레임(window) 가 만들어진다.
 */
public class MyFrame2 extends JFrame{
	// 생성자
	public MyFrame2() {
		// 프레임의 제목 설정
		this.setTitle("나의 프레임");
		// 프레임의 위치와 크기 설정 setBounds(x, y, width, height)
		/*this.*/setBounds(100, 100, 500, 500);
		// 종료(X) 버튼을 눌렀을 때 프로세스(app) 전체가 종료 되도록 한다
		/*this.*/setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// 레이아웃 매니저 객체 생성
		FlowLayout layout=new FlowLayout(FlowLayout.CENTER);
		// 프레임의 레이아웃 매니저 설정
		setLayout(layout);
		// FButton 객체 생성
		String[] labels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
		
		for(String label : labels) {
			JButton btn = new JButton(label);
			add(btn);
			// 버튼 클릭 시 동작하는 리스터
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// e.getSource()를 JButton으로 형변환 후 텍스트 출력
					JButton clickedBtn = (JButton)e.getSource();
					System.out.print(clickedBtn.getText());
				}
			});
		}
		
		
		// 화면상에 실제 보이도록 한다.
		/*this.*/setVisible(true);
	}
	 // main 메소드 만들기
	public static void main(String[] args) {
		new MyFrame2();
	}
}
