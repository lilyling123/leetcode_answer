package th332;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findItinerary(new String[][]{
                {"JFK", "KUL"},
                {"JFK", "NRT"},
                {"NRT", "JFK"}
        }));
    }
}