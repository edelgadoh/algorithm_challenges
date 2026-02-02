package algorithm.cracking.stacks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class AnimalShelter {

    Queue<Dog> queueDogs = new LinkedList<>();
    Queue<Cat> queueCats = new LinkedList<>();

    void enqueue(Animal animal) {
        if (animal instanceof Dog dog) queueDogs.offer(dog);
        else if (animal instanceof Cat cat) queueCats.offer(cat);
        else throw new RuntimeException("Unsupported animal");
    }

    Optional<?> dequeueAny() {
        if (queueDogs.isEmpty()) return dequeueCat();
        if (queueCats.isEmpty()) return dequeueDog();

        var oldDog = queueDogs.peek();
        var oldCat = queueCats.peek();
        if (oldDog.getArrivalDate().isBefore(oldCat.getArrivalDate())) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    Optional<Dog> dequeueDog() {
        return Optional.ofNullable(queueDogs.poll());
    }

    Optional<Cat> dequeueCat() {
        return Optional.ofNullable(queueCats.poll());
    }


    @Getter
    @NoArgsConstructor
    @SuperBuilder
    @ToString
    abstract static class Animal {
        private String name;
        private LocalDateTime arrivalDate;
    }

    @SuperBuilder
    @Getter
    static class Dog extends Animal {
    }

    @SuperBuilder
    @Getter
    static class Cat extends Animal {
    }

}