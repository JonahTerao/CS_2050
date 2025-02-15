import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeraoGE01Polymorphism {
    public static void main(String[] args) {
        try {
        	
            // Create a File object to read data from "Animals.txt"
            File file = new File("Animals.txt");
            Scanner scanner = new Scanner(file);

            // Read the number of animals from the file
            int numAnimals = scanner.nextInt();
            scanner.nextLine();

            // Create an array of Animal objects to store the animals
            Animal[] animals = new Animal[numAnimals];

            // Loop to read each animal's information from the file and instantiate the appropriate class
            for (int i = 0; i < numAnimals; i++) {
                String type = scanner.next();
                String name = scanner.next();
                String food = scanner.next();
                int weight = scanner.nextInt();
                int sleep = scanner.nextInt();
                String location = scanner.nextLine(); // Consume the leftover newline character

                // Create specific animal objects based on the type read from the file
                if (type.equals("Bear")) {
                    animals[i] = new Bear(name, food, weight, sleep, location);
                } else if (type.equals("Elephant")) {
                    animals[i] = new Elephant(name, food, weight, sleep, location);
                } else if (type.equals("Monkey")) {
                    animals[i] = new Monkey(name, food, weight, sleep, location);
                } else if (type.equals("Sloth")) {
                    animals[i] = new Sloth(name, food, weight, sleep, location);
                } else {
                    // Handle unknown animal types
                    System.out.println("Unknown animal type: " + type);
                }
            }

            // Print details of each animal and call their behaviors (eat, sleep, swim)
            for (int i = 0; i < numAnimals; i++) {
                System.out.println("Animal[" + i + "] is a " + getAnimalType(animals[i]));
                System.out.println(animals[i].toString());
                animals[i].eat();
                animals[i].sleep();
                animals[i].swim();
                System.out.println();
            }

            // Close the scanner to prevent resource leakage
            scanner.close();
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // Method to determine the type of animal by checking the class of the object
    private static String getAnimalType(Animal animal) {
        if (animal instanceof Bear) {
            return "Bear";
        } else if (animal instanceof Elephant) {
            return "Elephant";
        } else if (animal instanceof Monkey) {
            return "Monkey";
        } else if (animal instanceof Sloth) {
            return "Sloth";
        } else {
            return "Unknown";
        }
    }
}

// Base Animal class with common attributes and methods for all animals
class Animal {
    private String name;
    private String food;
    private int weight;
    private int sleep;
    private String location;

    // Constructor to initialize an Animal object
    public Animal(String name, String food, int weight, int sleep, String location) {
        this.name = name;
        this.food = food;
        this.weight = weight;
        this.sleep = sleep;
        this.location = location;
    }

    // Getter methods for animal attributes
    public String getName() { return name; }
    public String getFood() { return food; }
    public int getWeight() { return weight; }
    public int getSleep() { return sleep; }
    public String getLocation() { return location; }

    // Common animal behavior methods (can be overridden by subclasses)
    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping - do not disturb");
    }

    public void swim() {
        System.out.println("Animal is swimming");
    }

    // Override toString method to return animal details
    @Override
    public String toString() {
        return "Name: " + name + " - Weighs: " + weight + " lbs - Sleeps: " + sleep + " hours - Location: " + location;
    }
}

// Bear subclass that overrides behaviors specific to bears
class Bear extends Animal {
    public Bear(String name, String food, int weight, int sleep, String location) {
        super(name, food, weight, sleep, location);
    }

    @Override
    public void eat() {
        System.out.println("Bear is eating " + getFood());
    }

    @Override
    public void sleep() {
        System.out.println("Bear is sleeping " + getSleep() + " hours");
    }

    @Override
    public void swim() {
        System.out.println("Bear is swimming");
    }

    @Override
    public String toString() {
        return "Bear: " + super.toString();
    }
}

// Elephant subclass that overrides behaviors specific to elephants
class Elephant extends Animal {
    public Elephant(String name, String food, int weight, int sleep, String location) {
        super(name, food, weight, sleep, location);
    }

    @Override
    public void sleep() {
        System.out.println("Elephant is sleeping " + getSleep() + " hours");
    }

    @Override
    public String toString() {
        return "Elephant: " + super.toString();
    }
}

// Monkey subclass that overrides behaviors specific to monkeys
class Monkey extends Animal {
    public Monkey(String name, String food, int weight, int sleep, String location) {
        super(name, food, weight, sleep, location);
    }

    @Override
    public void eat() {
        System.out.println("Monkey is eating " + getFood());
    }

    @Override
    public void swim() {
        System.out.println("Monkey is swimming");
    }

    @Override
    public String toString() {
        return "Monkey: " + super.toString();
    }
}

// Sloth subclass that overrides behaviors specific to sloths
class Sloth extends Animal {
    public Sloth(String name, String food, int weight, int sleep, String location) {
        super(name, food, weight, sleep, location);
    }

    @Override
    public String toString() {
        return "Sloth: " + super.toString();
    }
}

