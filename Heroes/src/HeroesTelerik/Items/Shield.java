package HeroesTelerik.Items;

/**
 * Created by Joro on 27/04/2018
 */
public class Shield extends DefensiveItem {

    public Shield(String name, int defense, int price,double weight){
        super();
        this.setItemName(name);
        this.setDefense(defense);
        this.setPrice(price);
        this.setWeight(weight);

    }
    @Override
    public String toString() {
        return String.format("Weapon: %s, Damage: %d, Price: %d",getClass().getSimpleName(),getDefense(),getPrice());
    }
}