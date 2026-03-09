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

//split the code into multiple files as per the class definitions

