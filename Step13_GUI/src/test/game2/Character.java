package test.game2;

// 적들을 구현할 상위 클래스
public abstract class Character extends GameObject{
protected int hp; // 체력
	
	// 생성자
	public Character(int x, int y, int hp) {
		super(x, y);     // GameObject의 생성자 호출
		this.hp = hp;    // 체력 초기화
	}

	// 체력 반환
	public int getHp() {
		return hp;
	}

	// 데미지를 받아 체력을 줄이는 메소드
	public void takeDamage(int damage) {
		hp -= damage;
		if (hp <= 0) {
			hp = 0;
			setRemove(true); // 체력이 0 이하이면 제거 대상 표시
		}
	}

	// 자식 클래스에서 구현해야 하는 이동, 그리기 등
	public abstract void update();       // 위치 갱신 또는 행동
	public abstract void draw(java.awt.Graphics g); // 화면 그리기
}
