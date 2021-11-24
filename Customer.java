import java.util.Map;
import java.util.Scanner;

public class Customer extends User {
    Ride ride;


    public Customer(String userName, String mobileNum, String email, String passWord) {
        super(userName, mobileNum, email, passWord);
    }

    public Ride getRide() {
        return ride;
    }

    public void requestaAride(String source, String destination) {

        if ( ride==null ||ride.getrate()==true)
        {
            ride = new Ride(source, destination, this);
            System.out.println("Ride was Successfully requested.");
            System.out.println("");
        }
        else {
            System.out.println("You are often on a ride or booked a ride");

        }

    }

    public void showRideInfo() {
        System.out.println(ride.printRideInfo());
    }

    public void rateRide(int rate) {
        /*if (ride == null || ride.getDriver()==null)
        {
            System.out.println("Sorry, Your Ride has no Driver to rate");
            System.out.println("");
        }*/
        if (ride.getrate()==true)
        {
            System.out.println("You rated this ride before.");
            System.out.println("");
        }
        else
        {
            ride.setRateDriver(rate);
            System.out.println("Done!");
            System.out.println("");
        }
    }

    public void seenotificationonride()
    {
        if (ride ==null || ride.suggesteddriver.size()==0)
        {
            System.out.println("There is no notification.");
            System.out.println();
        }
        else {
            ride.returnsuggesteddrivers();
        }
    }

    public void choosedriver() {
        this.seenotificationonride();
        if (ride ==null || ride.suggesteddriver.size()==0)
        {
            return;
        }
        System.out.print("Choose the name of Driver you want: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        for (Map.Entry me : ride.suggesteddriver.entrySet() )
        {
            Driver d= (Driver) me.getKey();
            if (d.getUserName().equals(name) && d.isAvailable()==true)
            {
                ride.setDriver(d);
                d.setAvailable(false);
                ride.getDriver().setCurrentRide(ride);
                System.out.println("Done!");
                System.out.println("");
                this.ride.suggesteddriver.clear();
                return;
            }
            else if (d.getUserName().equals(name))
            {
                System.out.println("This Driver was in a ride or Unavailable.");
                System.out.println("Please delete the ride and make another one");
                System.out.println("");
                ride.suggesteddriver.remove(d);
            }
        }
    }

    public void deleteride(){
        if (ride==null)
        {
            System.out.println("You don't have any ride to delete.");
            return;
        }
        else if (ride.getDriver()==null || (ride.getrate()==true))
        {
            System.out.println("The Ride was Deleted.");
            this.ride =null;
            return;
        }
        System.out.println("You Can't delete this Ride.");
    }
}
