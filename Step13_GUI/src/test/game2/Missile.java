package test.game2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missile extends GameObject{
	// 미사일이 날라가는 속도
    private int speed = 10;
    // 미사일 타입 (약중강)
    private MissileType type;
    // 미사일 타입에 따른 이미지
    private Image image;
    // 미사일 타입에 따른 이미지 사이즈
    private int width, height;
    
    
    public Missile(int x, int y, MissileType type) {
    	super(x, y);
        this.type = type;

        // type에 따라 크기와 이미지 자동 설정
        this.width = type.getWidth();
        this.height = type.getHeight();
        this.image = new ImageIcon(getClass().getResource(type.getImagePath())).getImage();
	}
    
    // 미사일 속도 메소드
	public void move() {
		y -= speed;
	}
	
	// 미사일 이미지 그리는 메소드
	public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }
	
	// 충돌 범위 지정하는 메소드
    public Rectangle getBounds() {
        int padding = 4;
        return new Rectangle(x + padding, y + padding, width - padding * 2, height - padding * 2);
    }
	
    // 미사일 데미지 값을 가져오는 getter
    public int getDamage() {
        return type.getDamage();
    }
    
    // 미사일 타입을 가져오는 getter
    public MissileType getType() {
        return type;
    }
    
}
