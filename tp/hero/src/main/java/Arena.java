import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private final int width;
    private final int height;
    private final Hero hero;
    private final List<Wall> walls;
    private final List<Coin> coins;
    private final List<Monster> monsters;


    Arena(int width, int height){
        this.width = width;
        this.height = height;
        this.hero = new Hero(10,10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    public List<Coin> getCoins(){
        return coins;
    }

    private boolean canHeroMove(Position position){
        for(Wall wall: this.walls){
            if (wall.getPosition().equals(position)) return false;
        }
        return position.getX() > -1 && position.getX() < this.width
                && position.getY() > -1 && position.getY() < this.height;
    }

    public void moveHero(Position position){
        if(canHeroMove(position)){
            this.hero.setPosition(position);
        }
    }

    public void processKey(KeyStroke key){
        switch (key.getKeyType()){
            case ArrowUp:
                moveHero(this.hero.moveUp());
                break;
            case ArrowDown:
                moveHero(this.hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(this.hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(this.hero.moveRight());
            default:
                break;
        }
        retrieveCoins();
        moveMonsters();
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#D0E1D4"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');
        for (Wall wall : this.walls)
            wall.draw(graphics);
        for (Coin coin : this.coins)
            coin.draw(graphics);
        for(Monster monster: this.monsters)
            monster.draw(graphics);
        this.hero.draw(graphics);
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        int x, y;
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            do {
                x = random.nextInt(width - 2) + 1;
                y = random.nextInt(height - 2) + 1;
            }while(!canPlaceCoin(x,y,coins));
            coins.add(new Coin(x,y));
        }
        return coins;
    }

    private void retrieveCoins(){
         coins.removeIf(coin -> hero.getPosition().equals(coin.getPosition()));
    }

    private boolean canPlaceCoin(int x, int y,ArrayList<Coin> coins){
        Position pos = new Position(x,y);
        if(this.hero.getPosition().equals(pos)) return false;
        for(Coin coin: coins)
            if(coin.getPosition().equals(pos)) return false;
        return true;
    }

    private List<Monster> createMonsters() {
        int x, y;
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            do {
                x = random.nextInt(width - 2) + 1;
                y = random.nextInt(height - 2) + 1;
            }while(!canPlaceMonster(x,y,monsters));
            monsters.add(new Monster(x,y));
        }
        return monsters;
    }

    private boolean canPlaceMonster(int x, int y, ArrayList<Monster> monsters){
        Position pos = new Position(x,y);
        if(this.hero.getPosition().equals(pos)) return false;
        for(Coin coin: this.coins)
            if(coin.getPosition().equals(pos)) return false;
        for(Monster monster: monsters)
            if(monster.getPosition().equals(pos)) return false;
        return true;
    }

    private void moveMonsters(){
        Position position;
        for(Monster monster : this.monsters){
            position =  monster.move();
            if(canHeroMove(position)) monster.setPosition(position);
        }
    }

    public boolean verifyMonsterCollisions(){
        for(Monster monster : this.monsters){
            if(monster.getPosition().equals(this.hero.getPosition())) return true;
        }
        return false;
    }
}
