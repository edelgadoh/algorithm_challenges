package algorithm.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CardDeckTest {

    @Test
    void shouldCalculateSingleDifferenceInCardDeck() {

        CardDeck cardDeck = new CardDeck();
        int[] arrayBefore = {3, 8, 1, 5};//SPADE 8, CLUB 5
        int[] arrayAfter = {3, 8, 1, 5, 1, 5};//SPADE 8, CLUB 5, CLUB 5

        List<Card> expectedAdds = cardDeck.parseToCard(new int[]{1,5});

        ResultChanges cardDeckChanges = cardDeck.getChanges(arrayBefore, arrayAfter);
        Assertions.assertEquals(expectedAdds, cardDeckChanges.getAdds());
        Assertions.assertTrue(cardDeckChanges.getRemoves().isEmpty());

    }

    @Test
    void shouldCalculateDifferencesInCardDeck() {

        CardDeck cardDeck = new CardDeck();
        int[] arrayBefore = {3, 8, 4, 5, 1, 5, 1, 5, 2, 7};//SPADE 8, DIAMOND 5, CLUB 5, CLUB 5, HEART 7
        int[] arrayAfter = {3, 8, 1, 5, 3, 3, 3, 1, 2, 7, 4, 1};//SPADE 8, CLUB 5, SPADE 3, SPADE 1, HEART 7, DIAMOND 1

        List<Card> expectedAdds = cardDeck.parseToCard(new int[]{3, 1, 3, 3, 4, 1});
        List<Card> expectedRemoves = cardDeck.parseToCard(new int[]{1, 5, 4, 5});

        ResultChanges cardDeckChanges = cardDeck.getChanges(arrayBefore, arrayAfter);
        Assertions.assertEquals(expectedAdds, cardDeckChanges.getAdds());
        Assertions.assertEquals(expectedRemoves, cardDeckChanges.getRemoves());

    }

    @Test
    void shouldNotCalculateDifferencesInCardDeck() {

        CardDeck cardDeck = new CardDeck();
        int[] arrayBefore = {4, 10, 4, 9, 3, 1, 3, 2};
        int[] arrayAfter = {4, 10, 4, 9, 3, 1, 3, 2};

        ResultChanges cardDeckChanges = cardDeck.getChanges(arrayBefore, arrayAfter);
        Assertions.assertTrue(cardDeckChanges.getAdds().isEmpty());
        Assertions.assertTrue(cardDeckChanges.getRemoves().isEmpty());

    }
}