import java.util.HashMap;
import java.util.Map;

public class Ride {
    private String source;
    private String destination;
    private Customer cust;
    private Driver driver;
    private double price;
    private int rateDriver;
    private Boolean rated=false;
    HashMap<Driver, Double> suggesteddriver= new HashMap<Driver, Double>();


    public Ride(String source, String des, Customer cu) {
        this.source = source;
        this.destination = des;
        this.cust = cu;
    }
    boolean getrate (){return rated;}

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getRateDriver() {
        return rateDriver;
    }

    public void addsuggesteddriver(Driver d, double p)
    {
        suggesteddriver.put(d,p);
    }

    public void setRateDriver(int rateDriver) {
        if (rateDriver <=5 && rateDriver>=1)
        {
            this.rateDriver= rateDriver;
            driver.addratebycust();
            this.rated=true;
        }
        else {
            System.out.println("The rate is from 1 to 5 only");
        }
    }

    public String printRideInfo() {

        return driver.printDriverInfo() + ("price:" + this.price);
    }

    public void returnsuggesteddrivers() {
        for (Map.Entry me : suggesteddriver.entrySet())
        {
            Driver d= (Driver) me.getKey();
            System.out.print(d.printDriverInfo());
            System.out.println("Offer price:" + me.getValue());
            System.out.println("");
        }
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCust() {
        return cust;
    }

    public void searchDriverForRide(AllData ob) {
        ob.searchavailable(this);
    }
}