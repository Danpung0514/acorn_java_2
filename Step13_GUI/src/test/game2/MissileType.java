package test.game2;

public enum MissileType {
	WEAK("/missileWE.png", 18, 64, 10),
    MEDIUM("/missileMI.png", 36, 64, 20),
    STRONG("/missileST.png", 48, 64, 30),
    ULTIMATE("/ult.png", 128, 128, 999);

    private final String imagePath;
    private final int width;
    private final int height;
    private final int damage;

    MissileType(String imagePath, int width, int height, int damage) {
        this.imagePath = imagePath;
        this.width = width;
        this.height = height;
        this.damage = damage;
    }

    public String getImagePath() { return imagePath; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getDamage() { return damage; }
}
