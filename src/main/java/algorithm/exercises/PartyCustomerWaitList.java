package algorithm.exercises;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PartyCustomerWaitList {

    private Map<TableType, LinkedList<PartyCustomer>> mapPartyCustomer = new HashMap<>();

    {
        Arrays.stream(TableType.values()).forEach(tableType -> {
            mapPartyCustomer.put(tableType, new LinkedList<>());
        });
    }

    public Map<TableType, LinkedList<PartyCustomer>> getMapPartyCustomer() {
        return mapPartyCustomer;
    }

    public void insert(PartyCustomer partyCustomer) {
        TableType tableType = getTableType(partyCustomer.getReservedSeats());
        LinkedList<PartyCustomer> partyCustomers = mapPartyCustomer.getOrDefault(tableType, new LinkedList<>());
        partyCustomers.add(partyCustomer);
        mapPartyCustomer.put(tableType, partyCustomers);
    }

    public boolean leave(PartyCustomer partyCustomer) {
        TableType tableType = getTableType(partyCustomer.getReservedSeats());
        LinkedList<PartyCustomer> partyCustomers = mapPartyCustomer.getOrDefault(tableType, new LinkedList<>());
        boolean removeStatus = partyCustomers.remove(partyCustomer);
        mapPartyCustomer.put(tableType, partyCustomers);
        return removeStatus;
    }

    public PartyCustomer getFirstOnWaitingList(TableType tableType) {
        TableType localTableType = tableType;
        PartyCustomer partyCustomer = null;
        while (localTableType != null) {
            LinkedList<PartyCustomer> partyCustomers = mapPartyCustomer.getOrDefault(localTableType, new LinkedList<>());
            if (partyCustomers.peek() == null) {
                localTableType = nextSmallTableType(localTableType);
                continue;
            }
            partyCustomer = partyCustomers.poll();
            break;
        }
        return partyCustomer;
    }

    private TableType getTableType(int seats) {
        if (seats <= 2) {
            return TableType.TWO_SEATS;
        } else if (seats <= 4) {
            return TableType.FOUR_SEATS;
        } else if (seats <= 6) {
            return TableType.SIX_SEATS;
        } else if (seats <= 8) {
            return TableType.EIGHT_SEATS;
        } else if (seats <= 10) {
            return TableType.TEN_SEATS;
        } else {
            throw new RuntimeException(String.format("Not supported %s seats", seats));
        }
    }

    private TableType nextSmallTableType(TableType tableType) {
        switch (tableType) {
            case TEN_SEATS:
                return TableType.EIGHT_SEATS;
            case EIGHT_SEATS:
                return TableType.SIX_SEATS;
            case SIX_SEATS:
                return TableType.FOUR_SEATS;
            case FOUR_SEATS:
                return TableType.TWO_SEATS;
            default:
                return null;
        }
    }

}

enum TableType {
    TWO_SEATS, FOUR_SEATS, SIX_SEATS, EIGHT_SEATS, TEN_SEATS
}

@Getter
@AllArgsConstructor
@ToString
class PartyCustomer {
    String representativeName;
    int reservedSeats;
}