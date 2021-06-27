public class Zoo {
    int hunger;
    int happiness;

    public Zoo(){
        this.happiness = 2;
        this.hunger = 3;
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
}
