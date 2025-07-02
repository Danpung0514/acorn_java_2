package test.game2;

public class Player extends Character{
	// 레벨 관련
	private int level;			// 현재 레벨
	private int exp;			// 현재 경험치
	private int expToLevelUp;	// 최대 경험치
	
	// 체력
	private int hp;				// 현재 체력
	private final int maxHp;	// 최대 체력
	
	// 발사 관련
	private int missileDamage;	// 현재 미사일 데미지
	private int missileInterval;	// 미사일 발사 간격 (ms)
	private MissileType missileType;	// 미사일 타입: 약, 중, 강
	
	// 필살기
	private boolean isUsingUltimate;	// 필살기 사용 중 여부
	private long ultimateEndTime;		// 필살기 종료 시각
	
	// 생성자
	public Player() {
		this.level = 1;
		this.exp = 0;
		this.expToLevelUp = 10;
		this.hp = 3;
		this.maxHp = 3;
		
		this.missileDamage = 1;
		this.missileInterval = 300;
		this.missileType = MissileType.WEAK;
		
		this.isUsingUltimate = false;
		this.ultimateEndTime = 0;
	}
}
