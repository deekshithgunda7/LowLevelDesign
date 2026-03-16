import java.util.*;

// ==============================
// Strategy Interface
// ==============================
interface MatchingStrategy {
    void match(String riderLocation);
}

// ==============================
// Concrete Strategy: Nearest Driver
// ==============================
class NearestDriverStrategy implements MatchingStrategy {
    @Override
    public void match(String riderLocation) {
        System.out.println("Matching with the nearest available driver to " + riderLocation);
        // Distance-based matching logic
    }
}

// ==============================
// Concrete Strategy: Airport Queue
// ==============================
class AirportQueueStrategy implements MatchingStrategy {
    @Override
    public void match(String riderLocation) {
        System.out.println("Matching using FIFO airport queue for " + riderLocation);
        // Match first-in-line driver for airport pickup
    }
}

// ==============================
// Concrete Strategy: Surge Priority
// ==============================
class SurgePriorityStrategy implements MatchingStrategy {
    @Override
    public void match(String riderLocation) {
        System.out.println("Matching rider using surge pricing priority near " + riderLocation);
        // Prioritize high-surge zones or premium drivers
    }
}

// ==============================
// Context Class: RideMatchingService
// ==============================
class RideMatchingService {
    private MatchingStrategy strategy;

    // Constructor injection of strategy
    public RideMatchingService(MatchingStrategy strategy) {
        this.strategy = strategy;
    }

    // Setter injection for changing strategy dynamically
    public void setStrategy(MatchingStrategy strategy) {
        this.strategy = strategy;
    }

    // Delegates the matching logic to the strategy
    public void matchRider(String location) {
        strategy.match(location);
    }
}

class RiderMatchingExample {
    public static void main(String[] args) {
        // Create strategies
        MatchingStrategy nearestDriver = new NearestDriverStrategy();
        MatchingStrategy airportQueue = new AirportQueueStrategy();
        MatchingStrategy surgePriority = new SurgePriorityStrategy();

        // Create context with initial strategy
        RideMatchingService matchingService = new RideMatchingService(nearestDriver);

        // Match rider using nearest driver strategy
        matchingService.matchRider("Downtown");

        // Change strategy to airport queue and match rider
        matchingService.setStrategy(airportQueue);
        matchingService.matchRider("Airport");

        // Change strategy to surge priority and match rider
        matchingService.setStrategy(surgePriority);
        matchingService.matchRider("Suburbs");
    }
}