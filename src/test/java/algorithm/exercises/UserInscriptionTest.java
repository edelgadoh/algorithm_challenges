package algorithm.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInscriptionTest {

    private UserInscription userInscription = new UserInscription();

    @Test
    void mostCommonSubscriptionsTest() {
        List<UserInscription.User> users = List.of(
                new UserInscription.User(1, List.of(1, 3)),
                new UserInscription.User(2, List.of(1, 3, 11, 6, 7)),
                new UserInscription.User(3, List.of(2, 5)),
                new UserInscription.User(4, List.of(5, 6)),
                new UserInscription.User(5, List.of(1, 10))
        );
        var response = userInscription.mostCommonSubscriptions(users, 4);
        assertEquals(List.of(1, 3, 5, 6), response);
    }

    @Test
    void mostCommonSubscriptionsAllTest() {
        var users = List.of(
                new UserInscription.User(1, List.of(1, 2)),
                new UserInscription.User(2, List.of(1, 3)),
                new UserInscription.User(3, List.of(3, 4)),
                new UserInscription.User(4, List.of(3, 5)),
                new UserInscription.User(5, List.of(5, 6))
        );
        var response = userInscription.mostCommonSubscriptions(users, 2);
        assertEquals(List.of(3, 1), response);
    }

    @Test
    void mostCommonSubscriptionsEmptyTest() {
        var users = List.of(
                new UserInscription.User(1, List.of()),
                new UserInscription.User(5, List.of())
        );
        var response = userInscription.mostCommonSubscriptions(users, 1);
        assertEquals(List.of(), response);
    }

    @Test
    void mostCommonSubscriptionsNullTest() {
        var users = List.of(
                new UserInscription.User(1, null),
                new UserInscription.User(5, null)
        );
        var response = userInscription.mostCommonSubscriptions(users, 1);
        assertEquals(List.of(), response);
    }

}