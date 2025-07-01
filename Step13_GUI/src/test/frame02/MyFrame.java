package test.frame02;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
public class MyFrame extends JFrame{
	// 생성자
	public MyFrame() {
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
		JButton btn1=new JButton("1");
		JButton btn2=new JButton("2");
		JButton btn3=new JButton("3");
		JButton btn4=new JButton("4");
		JButton btn5=new JButton("5");
		JButton btn6=new JButton("6");
		JButton btn7=new JButton("7");
		JButton btn8=new JButton("8");
		JButton btn9=new JButton("9");
		JButton btn01=new JButton("*");
		JButton btn0=new JButton("0");
		JButton btn02=new JButton("#");
		// 프레임의 add() 메소드 호출하면서 JButton 객체의 참조값을 전달하면 프레임에 버튼이 배치된다.
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
		add(btn8);
		add(btn9);
		add(btn01);
		add(btn0);
		add(btn02);
		
		
		// 화면상에 실제 보이도록 한다.
		/*this.*/setVisible(true);
	}
	 // main 메소드 만들기
	public static void main(String[] args) {
		new MyFrame();
	}
}
