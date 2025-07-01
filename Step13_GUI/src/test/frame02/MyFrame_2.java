package test.frame02;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 *  Graphic User Interface 를 만들 수 있는 클래스 설계하기
 *  
 *  1. Jframe 클래스를 상속 받는다.
 *  2. 생성자에서 필요한 초기화 작업을 한다.
 *  3. main() 메소드에서 이 클래스로 객체를 생성하면 프레임(window) 가 만들어진다.
 */
public class MyFrame_2 extends JFrame{
	// 입력창 필드로 선언해서 버튼 클릭 시 접근 가능하게 함
	private JTextField displayField;
	
	public MyFrame_2() {
		setTitle("전화기 UI");
		setBounds(100, 100, 300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// 입력창 생성
		displayField = new JTextField();
		displayField.setEditable(false); // 사용자가 직접 입력 못하게
		displayField.setFont(new Font("굴림", Font.BOLD, 24));
		displayField.setHorizontalAlignment(JTextField.RIGHT); // 오른쪽 정렬
		add(displayField, BorderLayout.NORTH); // 상단에 배치
		
		// 버튼 패널 생성
				JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 10, 10)); // 4행 3열 + 간격
				String[] labels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};

				for (String label : labels) {
					JButton btn = new JButton(label);
					btn.setFont(new Font("굴림", Font.BOLD, 20));
					
					// 버튼 클릭 시 동작하는 리스너 설정
					btn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							String currentText = displayField.getText();
							displayField.setText(currentText + label); // 입력창에 문자 추가
							
						}
					});
					buttonPanel.add(btn);
				}

				// 버튼 패널을 프레임 가운데에 추가
				add(buttonPanel, BorderLayout.CENTER);

				setVisible(true);
	}
	 // main 메소드 만들기
	public static void main(String[] args) {
		new MyFrame_2();
	}
}
