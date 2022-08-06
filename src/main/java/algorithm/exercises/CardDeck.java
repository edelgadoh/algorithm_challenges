package algorithm.exercises;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    public ResultChanges getChanges(int[] arrayBefore, int[] arrayAfter) {

        List<Card> removes = new ArrayList<>();
        List<Card> adds = new ArrayList<>();

        List<Card> cardsBefore = parseToCard(arrayBefore);
        List<Card> cardsAfter = parseToCard(arrayAfter);

        Collections.sort(cardsBefore);
        Collections.sort(cardsAfter);

        int i = 0;
        int j = 0;
        while (i < cardsBefore.size() && j < cardsAfter.size()) {
            if (cardsBefore.get(i).equals(cardsAfter.get(j))) {
                i++;
                j++;
            } else {
                if (cardsBefore.get(i).symbol == cardsAfter.get(i).symbol) {
                    if (cardsBefore.get(i).cardNumber.value < cardsAfter.get(j).cardNumber.value) {
                        removes.add(cardsBefore.get(i));
                        i++;
                    } else {
                        adds.add(cardsAfter.get(j));
                        j++;
                    }
                } else {
                    if (cardsBefore.get(i).symbol.value < cardsAfter.get(i).symbol.value) {
                        removes.add(cardsBefore.get(i));
                        i++;
                    } else {
                        adds.add(cardsAfter.get(j));
                        j++;
                    }
                }
            }
        }
        while (i < cardsBefore.size()) {
            removes.add(cardsBefore.get(i));
            i++;
        }
        while (j < cardsAfter.size()) {
            removes.add(cardsAfter.get(j));
            j++;
        }

        return new ResultChanges(adds, removes);
    }

    public List<Card> parseToCard(int[] array) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i <= array.length - 2; i += 2) {
            Card card = new Card(Symbol.getEnum(array[i]), CardNumber.getEnum(array[i + 1]));
            cards.add(card);
        }
        return cards;
    }

}

@Data
@AllArgsConstructor
class ResultChanges {

    List<Card> adds;
    List<Card> removes;

}

@Data
@AllArgsConstructor
@EqualsAndHashCode
class Card implements Comparable {
    Symbol symbol;
    CardNumber cardNumber;

    @Override
    public int compareTo(Object o) {

        Card card = (Card) o;
        if (this.symbol.value < card.symbol.value) {
            return -1;
        } else if (this.symbol.value > card.symbol.value) {
            return 1;
        } else {
            if (this.cardNumber.value < card.cardNumber.value) {
                return -1;
            } else if (this.cardNumber.value > card.cardNumber.value) {
                return 1;
            }
        }

        return 0;
    }
}

enum Symbol {
    CLUB(1, "♧"),
    HEART(2, "♡"),
    SPADE(3, "♤"),
    DIAMOND(4, "♢");

    Integer value;
    String text;

    Symbol(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Symbol getEnum(Integer searchValue) {
        return Arrays.stream(Symbol.values()).filter(symbol -> symbol.value.equals(searchValue)).findFirst().get();
    }

}

enum CardNumber {
    A(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    J(11),
    Q(12),
    K(13);

    Integer value;

    CardNumber(Integer value) {
        this.value = value;
    }

    public static CardNumber getEnum(Integer searchValue) {
        return Arrays.stream(CardNumber.values()).filter(symbol -> symbol.value.equals(searchValue)).findFirst().get();
    }
}