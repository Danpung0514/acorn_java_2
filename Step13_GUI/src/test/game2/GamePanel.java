package test.game2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel{
	// 필요한 필드 정의 (같은 type 이면 콤마(,)로 여러개 정의 할 수 있다
	Image unitImage, backImage, missImage; // [^1] null로 비어있는 필드 생성 후
	// 드래곤의 좌표
	int unitX=250;
	int unitY=700;
	// 배경1의 y 좌표, 배경2의 y 좌표
	int back1Y=0, back2Y=-800;
	// Missile 객체를 누적시킬 ArrayList 객체
	List<Missile> missList=new ArrayList<>();
	
	// 카운트다운
	String countdownText = "";
	boolean isCountingDown = true; // 카운트다운 중 여부
	
	// 미사일 생성간격 및 시간 기록
	int missileInterval = 300;  // 미사일 생성 간격 (ms)
	long lastMissileTime;	// 미사일을 발사한 시간을 넣을 필드
	
	
	// 생성자
	public GamePanel() {
		// 무언가 준비 작업 ...
		
		// 카운트다운 타이머 (1초간격 텍스트 바뀜)
		new Timer(1000, new java.awt.event.ActionListener() {
			int count = 3;
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("카운트다운 텍스트:"+countdownText);
				if (count == 0) {
					countdownText = "START!";
				} else if (count == -1) {
					countdownText = "";
					isCountingDown = false;
					((Timer)e.getSource()).stop(); // 카운트다운 끝 -> 타이머 종료
					lastMissileTime = System.currentTimeMillis(); // 실제 발사 시작 시점 설정
				} else {
					countdownText = String.valueOf(count);
				}
				count--;
			}
			
		}).start();
		
		// Panel 의 크기 설정 width:500, height:800
		setPreferredSize(new Dimension(500, 800));
		
		// src/images/unit1.png 파일의 위치를 URL 객체로 얻어내기
		URL url=getClass().getResource("/images/unit1.png");
		
		// src/images/unit1.png 파일을 로딩해서 Image 객체로 만들기
		unitImage=new ImageIcon(url).getImage();  // [^1] 이곳에서 필드 내부 대입
		// 배경 이미지
		backImage=new ImageIcon(getClass().getResource("/images/backbg.png")).getImage();
		// 미사일 이미지
		missImage=new ImageIcon(getClass().getResource("/images/mi2.png")).getImage();
		
		
		MouseMotionAdapter adapter=new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				// 마우스의 좌표
				int x=e.getX();
				int y=e.getY();
				// 마우스의 좌표를 unit 의 좌표에 반영
				unitX=x;
				unitY=y;
				
			}
		};
		// 마우스 움직임을 처리 하기 위한 code
		addMouseMotionListener(adapter);
		
		// Panel 이 포커스를 받을 수 있도록 (Key event 처리를 위해)
		setFocusable(true);
		requestFocusInWindow();

		// Panel 이 10/1000 초 마다 다시 그려지게 하기위한 타이머 설정
		Timer timer=new Timer(10, (e)->{
			System.out.println("타이머 작동중");
			long now = System.currentTimeMillis(); // 현재 시간을 밀리초 단위로 측정
			// 카운트다운이 끝났고, 미사일 발사 주기가 지났을 때만 발사
			if (!isCountingDown && now -lastMissileTime >= missileInterval) {
				System.out.println("미사일 생성됨!");
				missList.add(new Missile(unitX, unitY));
				lastMissileTime = now;
			}
			
			// [^2] Panel 객체의 repaint() 메소드를 호출(결과적으로paintComponent() 메소드가 다시 호출된다)
			repaint();
		});
		
		timer.start();
	}
	
	// Panel 에 무언가를 그릴 때 호출되는 메소드
	// [^2] Panel 이 초기화될 때 한 번 호출되고 그 다음에는 repaint() 라는 메소드가 호출될 때 마다 다시 호출된다.
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		// 배경이미지 그리기
		g.drawImage(backImage, 0, back1Y, 500, 800, this);
		g.drawImage(backImage, 0, back2Y, 500, 800, this);
		// 반복문 돌면서 미사일 이미지 모두 그리기
		for(int i=0; i<missList.size(); i++) {
			//i번째 미사일 객체
			Missile tmp=missList.get(i);
			g.drawImage(missImage, tmp.getX()-15, tmp.getY()-20, 30, 40, this);
		}
		
		// 메소드의 매개변수에 전달되는 Graphics 객체를 Panel 에 그림을 그릴 수 있는 도구이다.
		g.drawImage(unitImage, unitX-50, unitY-50, 100, 100, this);
		
		// 테스트로 미사일의 갯수 표시
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Missile:"+missList.size(), 10, 20);
		
		// 카운트다운 텍스트 표시
		if (!countdownText.equals("")) {
			g.setColor(Color.WHITE);
			Font font = new Font("Arial", Font.BOLD, 60);
			g.setFont(font);
			
			// 텍스트 폭 계산 후 중앙 위치 계산
			java.awt.FontMetrics fm = g.getFontMetrics(font);
			int textWidth = fm.stringWidth(countdownText);
			int x = (getWidth() - textWidth) / 2;
			int y = getHeight() / 2;

			g.drawString(countdownText, x, y);
		}
		
		// 모든 미사일의 y 좌표를 감소 시켜서 미사일이 위로 이동 하도록 한다.
		for(Missile tmp : missList) {
			// 현재 y 좌표에서 10 증가 시킨 값 얻어내서
			int resultY = tmp.getY()-10;
			// 해당 객체에 다시 넣어준다.
			tmp.setY(resultY);
			// 만일 위쪽으로 화면을 벗어난 미사일 객체라면
			if(tmp.getY() <= -20) {
				// 제거 하도록 표시 해둔다.
				tmp.setRemove(true);
			}
		}
		
		// 반복문 돌면서 List 에서 제거 할 Missile 객체는 제거한다.
		for(int i=0; i<missList.size(); i++) {
			// i 번째 Missile 객체
			Missile tmp=missList.get(i);
			// 만일 i 번째 미사일 객체가 제거 할 객체라면
			if(tmp.isRemove()) {
				//List 에서 i 번째 item 을 제거한다
				missList.remove(i);
			}
		}
		
		back1Y += 2;
		back2Y += 2;
		// 만일 배경1이 아래쪽으로 벗어난다면
		if(back1Y >= 800) { // 배경의 속도가 일정하지 않을때 딱 800이 아닐 수 있기 때문에 '>=' 라는 조건을 닮
			// -800 의 좌표로 다시 보낸다.
			back1Y = -800;
		}
		// 만일 배경2이 아래쪽으로 벗어난다면
		if(back2Y >= 800) {
			// -800 의 좌표로 다시 보낸다.
			back2Y = -800;
		}
	}
}
