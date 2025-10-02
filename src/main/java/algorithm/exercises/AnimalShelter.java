package algorithm.exercises;

import lombok.AllArgsConstructor;
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
        if (animal instanceof Dog) queueDogs.offer((Dog) animal);
        else if (animal instanceof Cat) queueCats.offer((Cat) animal);
        else throw new RuntimeException("Unsupported animal");
    }

    Optional<?> dequeueAny() {
        if (queueDogs.isEmpty()) return dequeueCat();
        if (queueCats.isEmpty()) return dequeueDog();

        Dog oldDog = queueDogs.peek();
        Cat oldCat = queueCats.peek();
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


}

@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
abstract class Animal {
    String name;
    LocalDateTime arrivalDate;
}

@SuperBuilder
@Getter
class Dog extends Animal {
}

@SuperBuilder
@Getter
class Cat extends Animal {
}
