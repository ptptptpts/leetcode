import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Collect the tickets as its start to find possible destinations easier
        HashMap<String, LinkedList<String>> ticketsMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!ticketsMap.containsKey(ticket.get(0))) {
                ticketsMap.put(ticket.get(0), new LinkedList<>());
            }
            ticketsMap.get(ticket.get(0)).add(ticket.get(1));
        }

        // Sort the destinations of each departure as a lexical order
        for (List<String> destinations : ticketsMap.values()) {
            destinations.sort(String::compareTo);
        }

        // Use DFS to traverse all tickets
        int numberOfAllTickets = tickets.size();
        List<String> flightsList = new ArrayList<>();
        traverseTicket(ticketsMap, flightsList, numberOfAllTickets, "JFK", 0);
        return flightsList;
    }

    private boolean traverseTicket(HashMap<String, LinkedList<String>> ticketsMap,
            List<String> flightsList, int numberOfAllTickets, String departure,
            int numberOfUsedTickets) {
        boolean isFound = false;

        flightsList.add(departure);

        if (numberOfUsedTickets == numberOfAllTickets) {
            isFound = true;
        } else {
            // Destinations are already sorted by a lexical order
            // Pop from the list of destinations of each start
            // If we find some flight that can use all the tickets, it is the solution because we use the tickets as the lexical order
            if (ticketsMap.containsKey(departure) && !ticketsMap.get(departure).isEmpty()) {
                LinkedList<String> destinationsList = ticketsMap.get(departure);
                for (int cursor = 0; cursor < destinationsList.size(); cursor++) {
                    String destination = destinationsList.get(cursor);
                    destinationsList.remove(cursor);
                    if (traverseTicket(ticketsMap, flightsList, numberOfAllTickets,
                            destination, numberOfUsedTickets + 1)) {
                        isFound = true;
                        break;
                    }
                    destinationsList.add(cursor, destination);
                }
            }
        }

        if (!isFound) {
            flightsList.remove(numberOfUsedTickets);
        }

        return isFound;
    }
}
