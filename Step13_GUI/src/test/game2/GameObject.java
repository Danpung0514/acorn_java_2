package test.game2;

// 게임에 등장하는 모든 오브젝트의 최상위 부모 클래스
public class GameObject {
	protected int x, y;          // 화면 상의 위치 좌표
	protected boolean isRemove;  // 삭제 대상인지 여부

	// 생성자 - 위치 초기화
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		this.isRemove = false;
	}

	// x좌표 반환
	public int getX() {
		return x;
	}

	// y좌표 반환
	public int getY() {
		return y;
	}

	// 제거 대상 여부 확인
	public boolean isRemove() {
		return isRemove;
	}

	// 제거 여부 설정
	public void setRemove(boolean remove) {
		this.isRemove = remove;
	}
}
