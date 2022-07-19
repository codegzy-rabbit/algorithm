package chapter1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 */

public class DogCatQueue {

    private Queue<PetEnter> dogQueue;
    private Queue<PetEnter> catQueue;
    private long count;

    public DogCatQueue() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
        this.count = 0;
    }

    public void pollAll() {
        while (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
            if (dogQueue.peek().getCount() < catQueue.peek().getCount()) {
                dogQueue.poll().getEnterPetType();
            } else {
                catQueue.poll().getEnterPetType();
            }
        }
        while (!dogQueue.isEmpty()) {
            dogQueue.poll().getEnterPetType();
        }
        while (!catQueue.isEmpty()) {
            catQueue.poll().getEnterPetType();
        }
    }

    public Pet pollDog() {
        if (!dogQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        }
        return null;
    }

    public Pet pollCat() {
        if (!catQueue.isEmpty()) {
            return catQueue.poll().getPet();
        }
        return null;
    }

    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }


    public void add(Pet pet) {
        if (pet.getPetType().equals("Dog")) {
            dogQueue.add(new PetEnter(pet, this.count++));
        }
        if (pet.getPetType().equals("Cat")) {
            catQueue.add(new PetEnter(pet, this.count++));
        }
    }

    class PetEnter {
        private Pet pet;
        private long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }


    class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    class Dog extends Pet {

        public Dog(String type) {
            super("Dog");
        }
    }

    class Cat extends Pet {
        public Cat(String type) {
            super("Cat");
        }
    }
}
