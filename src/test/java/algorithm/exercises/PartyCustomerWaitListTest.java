package algorithm.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartyCustomerWaitListTest {

    PartyCustomer partyCustomer1 = new PartyCustomer("Customer1", 7);
    PartyCustomer partyCustomer2 = new PartyCustomer("Customer2", 1);
    PartyCustomer partyCustomer3 = new PartyCustomer("Customer3", 2);
    PartyCustomer partyCustomer4 = new PartyCustomer("Customer4", 3);
    PartyCustomer partyCustomer5 = new PartyCustomer("Customer5", 10);
    PartyCustomer partyCustomer6 = new PartyCustomer("Customer6", 8);
    PartyCustomerWaitList partyCustomerWaitList;
    List<PartyCustomer> partyCustomerSet = List.of(
            partyCustomer1, partyCustomer2, partyCustomer3, partyCustomer4, partyCustomer5, partyCustomer6);

    @BeforeEach
    void init() {
        partyCustomerWaitList = new PartyCustomerWaitList();
    }

    @Test
    void insert() {
        for (PartyCustomer partyCustomer : partyCustomerSet) {
            partyCustomerWaitList.insert(partyCustomer);
        }
        Assertions.assertEquals(2, partyCustomerWaitList.getMapPartyCustomer().get(TableType.TWO_SEATS).size());
        Assertions.assertEquals(1, partyCustomerWaitList.getMapPartyCustomer().get(TableType.FOUR_SEATS).size());
        Assertions.assertEquals(0, partyCustomerWaitList.getMapPartyCustomer().get(TableType.SIX_SEATS).size());
        Assertions.assertEquals(2, partyCustomerWaitList.getMapPartyCustomer().get(TableType.EIGHT_SEATS).size());
        Assertions.assertEquals(1, partyCustomerWaitList.getMapPartyCustomer().get(TableType.TEN_SEATS).size());

    }

    @Test
    void leave() {
        for (PartyCustomer partyCustomer : partyCustomerSet) {
            partyCustomerWaitList.insert(partyCustomer);
        }

        boolean leave = partyCustomerWaitList.leave(partyCustomer2);
        Assertions.assertTrue(leave);
        Assertions.assertEquals(1, partyCustomerWaitList.getMapPartyCustomer().get(TableType.TWO_SEATS).size());
        Assertions.assertEquals(partyCustomer3, partyCustomerWaitList.getMapPartyCustomer().get(TableType.TWO_SEATS).peek());

    }

    @Test
    void getFirstOnWaitingList() {

        for (PartyCustomer partyCustomer : partyCustomerSet) {
            partyCustomerWaitList.insert(partyCustomer);
        }
        PartyCustomer oldCustomerOfTwoSeats = partyCustomerWaitList.getFirstOnWaitingList(TableType.TWO_SEATS);
        Assertions.assertEquals(partyCustomer2, oldCustomerOfTwoSeats);
        PartyCustomer lastCustomerOfTwoSeats = partyCustomerWaitList.getFirstOnWaitingList(TableType.TWO_SEATS);
        Assertions.assertEquals(partyCustomer3, lastCustomerOfTwoSeats);
        PartyCustomer emptyCustomerOfTwoSeats = partyCustomerWaitList.getFirstOnWaitingList(TableType.TWO_SEATS);
        Assertions.assertNull(emptyCustomerOfTwoSeats);

        PartyCustomer oldCustomerOfSixSeats = partyCustomerWaitList.getFirstOnWaitingList(TableType.SIX_SEATS);
        Assertions.assertEquals(partyCustomer4, oldCustomerOfSixSeats);


    }
}