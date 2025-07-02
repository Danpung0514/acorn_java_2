package test.game2;

public class Boss extends Character{

	public Boss(int x, int y) {
		super(x, y);
	}
	public void hit(int damage) {
		hp -= damage;
		if(hp <= 0) {
			setRemove(true);
		}
	}
		
}
