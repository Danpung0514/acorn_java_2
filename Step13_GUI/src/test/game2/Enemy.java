package test.game2;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Character{
	private int speed; // 이동 속도

	public Enemy(int x, int y, int hp, int speed) {
		super(x, y, hp);
		this.speed = speed;
	}

	// 프레임마다 적의 위치 갱신
	@Override
	public void update() {
		y += speed; // 아래로 이동

		// 화면 벗어나면 제거
		if (y > 800) {
			setRemove(true);
		}
	}

	// 적 그리기
	@Override
	public void draw(Graphics g) {
		// 적 본체 (빨간색 원)
		g.setColor(Color.RED);
		g.fillOval(x - 20, y - 20, 40, 40);

		// 체력바 배경 (검정색)
		g.setColor(Color.BLACK);
		g.fillRect(x - 20, y - 30, 40, 5);

		// 체력바 (초록색: 남은 체력 비율)
		g.setColor(Color.GREEN);
		int barWidth = (int)(40 * ((double)hp / 100)); // 체력 100 기준 비율
		g.fillRect(x - 20, y - 30, barWidth, 5);
	}
}