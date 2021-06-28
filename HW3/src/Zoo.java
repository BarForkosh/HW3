import java.util.ArrayList;

public class Zoo {
    int hunger;
    int happiness;
    ArrayList<ZooObserver> obs;
    ArrayList<Animal> ani;
    static Zoo zoo;

    /**
     * private constructor of a new zoo
     */
    private Zoo() {
        this.happiness = 2;
        this.hunger = 3;
        this.obs = new ArrayList<>();
        this.ani = new ArrayList<>();
    }

    /**
     * creates and/or return the current (static) zoo
     *
     * @return the zoo
     */
    public static Zoo getInstance() {
        if (zoo == null) {
            zoo = new Zoo();
            System.out.println("Creating zoo...");
        } else System.out.println("The zoo already exists...");
        return zoo;
    }

    /**
     * adds animal to zoo and notifies subs
     *
     * @param animal animal to be added
     */
    public void addAnimal(Animal animal) {
        this.ani.add(animal);
        notifier(animal.getNotifyName() + " has been added to the zoo!");
    }

    /**
     * adds observer to zoo's observers list
     *
     * @param observer to be added
     */
    public void addObserver(ZooObserver observer) {
        this.obs.add(observer);
    }

    /**
     * removes an observer
     *
     * @param observer to be removed
     */
    public void removeObserver(ZooObserver observer) {
        this.obs.remove(observer);
    }

    /**
     * feeds animals and notifies observers
     */
    public void feedAnimals() {
        if (zoo.hunger > 1) zoo.hunger--;
        for (Animal animals : ani) {
            System.out.println("The " + animals.getAnimalName() + " is eating " + animals.getFood() + "...");
        }
        notifier("The animals are being fed");
    }

    /**
     * puts up a show in the zoo of all animals and notifies observers
     */
    public void watchAnimals() {
        if (zoo.hunger < 5) zoo.hunger++;
        if (zoo.happiness < 5) zoo.happiness++;
        for (Animal animals : ani) {
            System.out.println("The " + animals.getAnimalName() + " is " + animals.getShowName() + "...");
        }
        notifier("The animals are being watched");
    }

    /**
     * Shows info of animals in zoo
     */
    public void showAnimalsInfo() {
        System.out.println("The zoo contains total of " + zoo.ani.size() + " animals:");
        int z_cnt = 0, u_cnt = 0, m_cnt = 0;
        for (Animal an : zoo.ani) {
            if (an.getNotifyName().equals("Zebra")) z_cnt++;
            if (an.getNotifyName().equals("Unicorn")) u_cnt++;
            if (an.getNotifyName().equals("Monkey")) m_cnt++;
        }
        System.out.println("- Zebra: " + z_cnt);
        System.out.println("- Unicorn: " + u_cnt);
        System.out.println("- Monkey: " + m_cnt);
        System.out.println("Happiness level: " + zoo.happiness);
        if (zoo.happiness < 3) System.out.println("The animals are not happy, you should watch them...");
        if (zoo.happiness > 3) System.out.println("The animals are very happy, keep working hard...");
        System.out.println("Hunger level: " + zoo.hunger);
        if (zoo.hunger > 3) System.out.println("The animals are hungry, you should feed them...");
    }

    /**
     * notifies observer's list of msg param
     *
     * @param msg to notify observers
     */
    public void notifier(String msg) {
        System.out.println("Notifying observers:");
        for (ZooObserver ob : obs) {
            System.out.println("[" + ob.getName() + "] " + msg);
        }
    }
}

