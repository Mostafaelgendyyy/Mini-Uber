import java.util.*;


public class Driver extends User {
    private String Licence="";
    private String nID="";
    private LinkedList<String> favareas = new LinkedList<String>();
    private double avgrate;
    private boolean permission;
    private boolean available;
    private HashMap<String, Integer> rating = new HashMap<String, Integer>();
    private LinkedList<Ride> requests = new LinkedList<Ride>();
    private Ride currentRide;


    public Driver(String userName, String mobileNum, String email, String passWord, String licence, String nID) {
        super(userName, mobileNum, email, passWord);
        this.Licence = licence;
        this.nID = nID;
    }

    public int getsize()
    {
        return favareas.size();
    }
    public String getLicence() {
        return Licence;
    }

    public void setLicence(String licence) {
        Licence = licence;
    }

    public String getnID() {
        return nID;
    }

    public void setnID(String nID) {
        this.nID = nID;
    }

    public boolean Permission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void addFavarea(String area) {
        favareas.add(area);
        System.out.println(area+ " is added to Favorite Areas.");
        System.out.println();
        // Collections.sort(favareas);
    }

    public void setCurrentRide(Ride ride) {
        this.currentRide=ride;
    }

    public void deleteFavaArea(String area) {
        if (favareas.size()==0)
        {
            return;
        }
        for (String a : favareas) {
            if (a.equalsIgnoreCase(area)) {
                favareas.remove(a);
                System.out.println(area+ " is deleted from Favorite Areas.");
                System.out.println();
                return;
            }
        }
        System.out.println(area+ " isn't found in Favorite Areas.");
        System.out.println();
    }

    public void printFavarea() {
        if (favareas.size()==0)
        {
            System.out.println("There is no Area to Show.");
            return;
        }
        for (String A : favareas) {
            System.out.println("Place: "+A);
        }
    }

    public void SearchFavarea(Ride ride) {
        for (String A : favareas) {
            if (ride.getSource().equalsIgnoreCase(A)) {
                requests.add(ride);
                return;
            }
        }
    }

    public void viewratings()
    {
        if (rating.size()==0)
        {
            System.out.println("There is no Ratings.");
            System.out.println("");
            return;
        }
        for (Map.Entry me : rating.entrySet())
        {
            System.out.println("Customer: " + me.getKey() + " has rated you by "+ me.getValue()+ " stars");
        }
    }
    
    public void viewnotification()
    {
        if (requests.size()==0)
        {
            System.out.println("There is no notification.");
            System.out.println("");
            return;
        }
        for (int i = 0; i < requests.size(); i++) {
        System.out.println((i + 1) +" Source: "+ requests.get(i).getSource()+ " Destination: "+ requests.get(i).getDestination());
        }
    }
    public void checkrequest()
    {
        this.viewnotification();
        if (requests.size()==0)
        {
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of the ride you want to suggest price");
        int i = input.nextInt();
        System.out.print("Enter price for ride #"+ (i) + ": ");
        double price = input.nextDouble();
        requests.get(i-1).setPrice(price);
        requests.get(i-1).addsuggesteddriver(this,price);
        requests.remove(i-1);
    }

    public void addratebycust() {
        rating.put(currentRide.getCust().getUserName(), currentRide.getRateDriver());
        avragRate();
    }

    private void avragRate() {
        int avg = 0;
        for (int i : rating.values()) {
            avg += i;
        }
        avgrate = avg / rating.size();
    }

    public String printDriverInfo() {
        return "Name:" + this.getUserName() + "\n" + "Mobile:" + this.getMobileNum() + "\n" + "E-mail:" + this.getEmail() + "\n" + "avrage Rate:" + avgrate + "\n";
    }
}