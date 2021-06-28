import java.util.ArrayList;

public class Zoo {
    int hunger;
    int happiness;
    ArrayList<ZooObserver> obs;
    ArrayList<Animal> ani;
    static Zoo zoo;
    ArrayList<String> anikinds;

    /**
     * private constructor of a new zoo
     */
    private Zoo() {
        this.happiness = 2;
        this.hunger = 3;
        this.obs = new ArrayList<>();
        this.ani = new ArrayList<>();
        this.anikinds = new ArrayList<>();
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
        String kind = animal.getNotifyName();
        boolean flag = true;
        for (String name : zoo.anikinds)
            if (name.equals(kind)) {
                flag = false;
                break;
            }
        if (flag) zoo.anikinds.add(kind);
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
        int len = zoo.anikinds.size();
        int[] count = new int[len];
        for (Animal an : zoo.ani)
            for (int i = 0; i < len; i++)
                if (an.getNotifyName().equals(zoo.anikinds.get(i))) count[i]++;
        for (int i = 0; i < len; i++)
            System.out.println("- " + zoo.anikinds.get(i) + ": " + count[i]);
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

