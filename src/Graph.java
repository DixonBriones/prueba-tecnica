import java.util.*;

public class Graph {
    private final Map<String, Map<String, Integer>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public void addEdge(String start, String end, int weight) {
        adjacencyMap.putIfAbsent(start, new HashMap<>());
        adjacencyMap.get(start).put(end, weight);
    }

    public int getDistance(String... route) {
        int totalDistance = 0;
        for (int i = 0; i < route.length - 1; i++) {
            String start = route[i];
            String end = route[i + 1];
            if (adjacencyMap.containsKey(start) && adjacencyMap.get(start).containsKey(end)) {
                totalDistance += adjacencyMap.get(start).get(end);
            } else {
                return -1; 
            }
        }
        return totalDistance;
    }

    public int countRoutesWithMaxStops(String start, String end, int maxStops) {
        return countRoutesWithMaxStopsHelper(start, end, maxStops, 0);
    }

    private int countRoutesWithMaxStopsHelper(String current, String end, int maxStops, int currentStops) {
        if (currentStops > maxStops) return 0;
        int count = 0;
        if (current.equals(end) && currentStops != 0) {
            count++;
        }
        if (adjacencyMap.containsKey(current)) {
            for (String neighbor : adjacencyMap.get(current).keySet()) {
                count += countRoutesWithMaxStopsHelper(neighbor, end, maxStops, currentStops + 1);
            }
        }
        return count;
    }

    public int countRoutesWithExactStops(String start, String end, int exactStops) {
        return countRoutesWithExactStopsHelper(start, end, exactStops, 0);
    }

    private int countRoutesWithExactStopsHelper(String current, String end, int exactStops, int currentStops) {
        if (currentStops > exactStops) return 0;
        if (currentStops == exactStops && current.equals(end)) return 1;

        int count = 0;
        if (adjacencyMap.containsKey(current)) {
            for (String neighbor : adjacencyMap.get(current).keySet()) {
                count += countRoutesWithExactStopsHelper(neighbor, end, exactStops, currentStops + 1);
            }
        }
        return count;
    }

    public int shortestDistance(String start, String end) {
        return shortestDistanceHelper(start, end, new HashSet<>(), 0);
    }

    private int shortestDistanceHelper(String current, String end, Set<String> visited, int currentDistance) {
        if (current.equals(end) && currentDistance != 0) {
            return currentDistance;
        }
        visited.add(current);
        int shortest = Integer.MAX_VALUE;
        if (adjacencyMap.containsKey(current)) {
            for (Map.Entry<String, Integer> neighbor : adjacencyMap.get(current).entrySet()) {
                if (!visited.contains(neighbor.getKey()) || neighbor.getKey().equals(end)) {
                    int distance = shortestDistanceHelper(neighbor.getKey(), end, visited, currentDistance + neighbor.getValue());
                    if (distance < shortest) {
                        shortest = distance;
                    }
                }
            }
        }
        visited.remove(current);
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    public int countRoutesWithMaxDistance(String start, String end, int maxDistance) {
        return countRoutesWithMaxDistanceHelper(start, end, maxDistance, 0);
    }

    private int countRoutesWithMaxDistanceHelper(String current, String end, int maxDistance, int currentDistance) {
        if (currentDistance >= maxDistance) return 0;
        int count = 0;
        if (current.equals(end) && currentDistance != 0) {
            count++;
        }
        if (adjacencyMap.containsKey(current)) {
            for (Map.Entry<String, Integer> neighbor : adjacencyMap.get(current).entrySet()) {
                count += countRoutesWithMaxDistanceHelper(neighbor.getKey(), end, maxDistance, currentDistance + neighbor.getValue());
            }
        }
        return count;
    }
}