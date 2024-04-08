import java.util.*;

public class Iternary {

    public static String getStart(Map<String, String> map) {
        Set<String> to = new HashSet<>();

        for(String k : map.keySet()) {
            to.add(map.get(k));
        }
        for(String k : map.keySet()) {
            if (!to.contains(k)) return k;
        }

        return null; // no start point found
    }
    public static void main(String args[]) {
        Map<String, String> tickets = new HashMap<>();
        tickets.put("chennai", "bengalaru");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");

        String start = getStart(tickets);
        System.out.print("start = " + start);
        for(String k : tickets.keySet()) {
            System.out.print(" - > "+tickets.get(start));
            start = tickets.get(start);
        }

    }
}