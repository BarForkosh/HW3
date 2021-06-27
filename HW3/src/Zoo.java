import java.util.ArrayList;

public class Zoo {
    int hunger;
    int happiness;
    ArrayList<ZooObserver> obs;
    ArrayList<Animal> ani;

    public Zoo(){
        this.happiness = 2;
        this.hunger = 3;
        this.obs = new ArrayList<>();
        this.ani = new ArrayList<>();
    }

    public int getHappiness(){
        return this.happiness;
    }

    public void setHappiness(int happinessToSet){
        this.happiness = happinessToSet;
    }

    public int getHunger(){
        return this.hunger;
    }

    public void setHunger(int hungerToSet){
        this.hunger = hungerToSet;
    }

    public static Zoo getInstance(){
        Zoo zoo = new Zoo();
        return zoo;
    }

    public void addObserver(ZooObserver observer) {
        this.obs.add(observer);
    }

    public void addAnimal(Animal animal) {
        this.ani.add(animal);
    }

    public void showAnimalsInfo() {
        //TODO: implemente
    }

    public void feedAnimals() {
    }

    public void watchAnimals() {
    }

    public void removeObserver(ZooObserver observer) {
    }
}

