
/*
   --- A  Singleton pattern ensures that class has only one instance
       throughout the application lifecycle and provides global access
       point to that instance
       
       should exist only once due to global state,resource contraints or logical reasonaning
       -Need to accessed from different parts of the system

       primeExamples: Logging,DB and analytics

       we can implement singleton in 2 ways
         - Eager loading
         - Lazy Loading

*/

/// Eager Loading  -- Here we can only create one object eventhough
//                    if you create mutiple instances..And its done during class loading time

/// thread safe
class JobAnalytics{

    private static final JobAnalytics jobAnalytics = new JobAnalytics();

    private JobAnalytics(){

    }

    public static JobAnalytics getInstance(){
        return jobAnalytics;
    }
}

//Lazy loading not thread safe

// Class implementing Lazy Loading
class LazySingleton {
    // Object declaration
    private static LazySingleton instance;

    // private constructor
    private LazySingleton() {
        // Declaring it private prevents creation of its object using the new keyword
    }

    // Method to get the instance of class
    public static LazySingleton getInstance() {
        // If the object is not created 
        if (instance == null) {
            // A new object is created
            instance = new LazySingleton();
        }

        // Otherwise the already created object is returned
        return instance;
    }
}


public class SingleTonPattern {
    private int run = 0;
    private int submit=0;

    public void countRun(){
        run++;
    }

    public void countSubmit(){
       submit++;
    }

    public int getCountRun(){
        return run;
    }

    public int getCountSubmit(){
        return submit;
    }

}
public class main{
     public static void main(String[] args){
        SingleTonPattern pattern = new SingleTonPattern();
        pattern.countRun();
        pattern.countSubmit();
     }
}
