//Create a Logistics interface

interface Logistics {
    void send();
}

class RoadLogistics implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by road");
    }
}

class SeaLogistics implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by sea");
    }
}

 class AirLogistics implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by air");
    }
}

//Create a LogisticsFactory to generate object of concrete class based on given information.

class LogisticsFactory {
    public Logistics createLogistics(String type) {
        if (type.equalsIgnoreCase("road")) {
            return new RoadLogistics();
        } else if (type.equalsIgnoreCase("sea")) {
            return new SeaLogistics();
        } else if (type.equalsIgnoreCase("air")) {
            return new AirLogistics();
        }
        return null;
   
    }
}

//Create a logistics service to use the LogisticsFactory to get the object of concrete class by passing an information such as type.
class LogisticsService {
    private LogisticsFactory logisticsFactory;

    public LogisticsService(LogisticsFactory logisticsFactory) {
        this.logisticsFactory = logisticsFactory;
    }

    public void sendPackage(String type) {
        Logistics logistics = logisticsFactory.createLogistics(type);
        if (logistics != null) {
            logistics.send();
        } else {
            System.out.println("Invalid logistics type");
        }
    }
}

public class LogisticsExample {
    public static void main(String[] args) {
        LogisticsFactory logisticsFactory = new LogisticsFactory();
        LogisticsService logisticsService = new LogisticsService(logisticsFactory);

        logisticsService.sendPackage("road");
        logisticsService.sendPackage("sea");
        logisticsService.sendPackage("air");
        logisticsService.sendPackage("space"); // Invalid type
    }
}

// create documentation for the above code
/**     
 * The above code demonstrates the Factory Design Pattern using a logistics example. 
 * It defines a Logistics interface with a send() method, and three concrete implementations: RoadLogistics, SeaLogistics, and AirLogistics.
 * The LogisticsFactory class is responsible for creating instances of the concrete logistics classes based on a given type (road, sea, air).
 * The LogisticsService class uses the LogisticsFactory to obtain the appropriate logistics object and call its send() method.
 * In the main method, we create a LogisticsFactory and a LogisticsService, and then we test sending packages using different logistics types. An invalid type is also tested to demonstrate error handling.
 */



