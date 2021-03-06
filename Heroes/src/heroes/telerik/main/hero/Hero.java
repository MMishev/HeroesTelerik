package heroes.telerik.main.hero;


import heroes.telerik.Army;
import heroes.telerik.Coordinate;
import heroes.telerik.items.Item;
import heroes.telerik.items.MeleeWeapon;
import heroes.telerik.items.Shield;
import heroes.telerik.items.Sword;
import heroes.telerik.Map;


import java.util.ArrayList;
import java.util.List;

public class Hero {
    private static final int INITIAL_GOLD = 500;
    private static final int BASE_ATTACK = 0;
    private static final int BASE_DEFENCE = 0;
    private static final int INITIAL_X_COORDINATE = 1;
    private static final int INITIAL_Y_COORDINATE = 1;
    private static final int INITIAL_EXPERIENCE = 1000;
    private static final Shield INITIAL_SHIELD = new Shield("Brown Shield",1,0,12.50);
    private static final MeleeWeapon INITIAL_WEAPON = new Sword("Wooden Sword",1,0,8.75);


    private Coordinate coordinate;
    private int experience;
    private String name;
    private HeroClass heroClass;
    private int attack;
    private int defence;
    private Shield shield;
    private MeleeWeapon mainWeapon;
    public List<Item> items;
    public Army army;
    private int gold;

    public Hero(){
    }

    public Hero(String name) {
        this.name = name;
        this.experience = INITIAL_EXPERIENCE;
        this.coordinate = new Coordinate(INITIAL_X_COORDINATE, INITIAL_Y_COORDINATE);
        this.heroClass = HeroClass.randomHeroClass();
        this.attack = BASE_ATTACK;
        this.defence = BASE_DEFENCE;
        this.shield = INITIAL_SHIELD;
        this.mainWeapon = INITIAL_WEAPON;
        this.items = new ArrayList<>();
        this.army = new Army();
        this.gold = INITIAL_GOLD;

    }

    public void addItems(Item A){
        items.add(A);
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getLevel() {
        return experience / 1000;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAttack() {
        return attack+5*getLevel();
    }

    public int getTotalAttack() {

            return (getAttack()  + mainWeapon.getAttack());


    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getTotalDefence() {

            return (getDefence() + shield.getDefense());


    }

    public int getDefence() {
        return defence +5*getLevel();
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public MeleeWeapon getMainWeapon() {
        return mainWeapon;
    }

    public void setMainWeapon(MeleeWeapon mainWeapon) {
        this.mainWeapon = mainWeapon;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }


    public void move(char A) {

        Map.turns++;

        if (A == 'w') {
            if (!checkCoordinate(getCoordinate().getX() - 1, getCoordinate().getY())) {
                System.out.println("Invalid move!");
                return;
            }
            coordinate.setX(coordinate.getX() - 1);
        }
        if (A == 's') {
            if (!checkCoordinate(getCoordinate().getX() + 1, getCoordinate().getY())) {
                System.out.println("Invalid move!");
                return;
            }
            coordinate.setX(coordinate.getX() + 1);
        }
        if (A == 'd') {
            if (!checkCoordinate(getCoordinate().getX(), getCoordinate().getY() + 1)) {
                System.out.println("Invalid move!");
                return;
            }
            coordinate.setY(coordinate.getY() + 1);
        }
        if (A == 'a') {
            if (!checkCoordinate(getCoordinate().getX(), getCoordinate().getY() - 1)) {
                System.out.println("Invalid move!");
                return;
            }
            coordinate.setY(coordinate.getY() - 1);

        }
    }


    @Override
    public String toString() {
        return String.format("Hero name: %s, Level:%d, Attack Skill:%d, Defence Skill:%d,Gold amount:%d", getName(), getLevel(), getAttack(), getDefence(), getGold());
    }


    public boolean checkCoordinate(int x, int y) {

        if (x >= Map.map.length || x < 0 || y >= Map.map[x].length || y < 0) {
            return false;
        }

        if (Map.map[x][y] == '#' || Map.map[x][y] == '^') {
            return false;
        }

        return true;

    }


}
