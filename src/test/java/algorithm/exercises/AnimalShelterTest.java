package algorithm.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class AnimalShelterTest {

    AnimalShelter animalShelter;

    //Order of Animal arrival
    Dog dog1 = Dog.builder().name("dog1").arrivalDate(LocalDateTime.now()).build();
    Cat cat1 = Cat.builder().name("cat1").arrivalDate(LocalDateTime.now()).build();
    Dog dog2 = Dog.builder().name("dog2").arrivalDate(LocalDateTime.now()).build();
    Dog dog3 = Dog.builder().name("dog3").arrivalDate(LocalDateTime.now()).build();
    Cat cat2 = Cat.builder().name("cat2").arrivalDate(LocalDateTime.now()).build();
    Cat cat3 = Cat.builder().name("cat3").arrivalDate(LocalDateTime.now()).build();

    @BeforeEach
    void init() {
        animalShelter = new AnimalShelter();
    }

    @Test
    void enqueue() {

        animalShelter.enqueue(dog1);
        animalShelter.enqueue(cat1);
        animalShelter.enqueue(dog2);

        Assertions.assertEquals(1, animalShelter.queueCats.size());
        Assertions.assertEquals(2, animalShelter.queueDogs.size());
    }

    @Test
    void dequeueAny() {

        animalShelter.enqueue(dog1);
        animalShelter.enqueue(cat1);
        animalShelter.enqueue(dog2);
        animalShelter.enqueue(dog3);
        animalShelter.enqueue(cat2);

        Assertions.assertEquals(dog1, animalShelter.dequeueAny().get());
        Assertions.assertEquals(cat1, animalShelter.dequeueAny().get());
        Assertions.assertEquals(dog2, animalShelter.dequeueAny().get());
        Assertions.assertEquals(dog3, animalShelter.dequeueAny().get());
        Assertions.assertEquals(cat2, animalShelter.dequeueAny().get());
        Assertions.assertTrue(animalShelter.dequeueAny().isEmpty());

    }

    @Test
    void dequeueDog() {

        animalShelter.enqueue(dog1);
        animalShelter.enqueue(cat1);
        animalShelter.enqueue(dog2);

        Assertions.assertEquals(dog1, animalShelter.dequeueDog().get());
        Assertions.assertEquals(dog2, animalShelter.dequeueDog().get());
        Assertions.assertTrue(animalShelter.dequeueDog().isEmpty());

    }
    @Test
    void dequeueCat() {

        animalShelter.enqueue(dog1);
        animalShelter.enqueue(cat1);
        animalShelter.enqueue(dog2);
        animalShelter.enqueue(cat3);

        Assertions.assertEquals(cat1, animalShelter.dequeueCat().get());
        Assertions.assertEquals(cat3, animalShelter.dequeueCat().get());
        Assertions.assertTrue(animalShelter.dequeueCat().isEmpty());
    }
}