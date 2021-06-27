import java.util.ArrayList;

public class Zoo {
    int hunger;
    int happiness;
    ArrayList<ZooObserver> obs;
    ArrayList<Animal> ani;
    static Zoo zoo;

    private Zoo(){
        this.happiness = 2;
        this.hunger = 3;
        this.obs = new ArrayList<>();
        this.ani = new ArrayList<>();
    }

    public static Zoo getInstance() {
        if (zoo == null) {
            zoo = new Zoo();
            System.out.println("Creating zoo...");
        }
        else System.out.println("The zoo already exists...");
        return zoo;
    }

    public void addObserver(ZooObserver observer) {
        this.obs.add(observer);
    }

    public void addAnimal(Animal animal) {
        this.ani.add(animal);
        notifier(animal.getNotifyName() + " has been added to the zoo!");
    }

    public void showAnimalsInfo() {
        System.out.println("The zoo contains total of " + zoo.ani.size() + " animals:");
        int z_cnt = 0, u_cnt = 0, m_cnt = 0;
        for (Animal an : zoo.ani){
            if(an.getNotifyName().equals("Zebra"))z_cnt++;
            if(an.getNotifyName().equals("Unicorn"))u_cnt++;
            if(an.getNotifyName().equals("Monkey"))m_cnt++;
        }
        System.out.println("- Zebra: "+z_cnt);
        System.out.println("- Unicorn: "+u_cnt);
        System.out.println("- Monkey: "+m_cnt);
        System.out.println("Happiness level: "+zoo.happiness);
        if(zoo.happiness<3) System.out.println("The animals are not happy, you should watch them...");
        if(zoo.happiness>3) System.out.println("The animals are very happy, keep working hard...");
        System.out.println("Hunger level: "+zoo.hunger);
        if(zoo.hunger>3) System.out.println("The animals are hungry, you should feed them...");
    }

    public void notifier(String msg){
        System.out.println("Notifying observers:");
        for(ZooObserver ob : obs){
            System.out.println("["+ob.getName()+"] "+msg);
        }
    }

    public void feedAnimals() {
       if(zoo.hunger>1)zoo.hunger--;
       for (Animal animals : ani){
           System.out.println("The " + animals.getAnimalName() + " is eating " + animals.getFood() + "...");
       }
       notifier("The animals are being fed");
    }

    public void watchAnimals() {
        if(zoo.hunger<5)zoo.hunger++;
        if(zoo.happiness<5)zoo.happiness++;
        for (Animal animals : ani){
            System.out.println("The " + animals.getAnimalName() + " is " + animals.getShowName() + "...");
        }
        notifier("The animals are being watched");
    }

    public void removeObserver(ZooObserver observer) {
        this.obs.remove(observer);
    }
}

