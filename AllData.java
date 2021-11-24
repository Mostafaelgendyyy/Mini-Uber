
import java.io.LineNumberReader;
import java.util.LinkedList;

public class AllData {
    private LinkedList<Customer>Customers=new LinkedList<Customer>();
    private LinkedList<Admin>admins=new LinkedList<Admin>();
    private LinkedList<Driver> pendingDriver = new LinkedList<Driver>();
    private LinkedList<Driver> Drivers = new LinkedList<Driver>();
    private LinkedList<Driver> suspendedDriver = new LinkedList<Driver>();
    /////////////////////////////////////////////////////////////

    public void addCustomer(Customer cust)
    {
        Customers.add(cust);
    }

    public boolean searchCustomer(String usN, String password)
    {
        for(int i = 0 ; i <Customers.size();i++)
        {
            if(Customers.get(i).getUserName().equals(usN)&& Customers.get(i).getPassWord().equals(password))
            {
                return true;
            }
        }
        return false;
    }
    public Customer search(String usN)
    {
        for(int i = 0 ; i <Customers.size();i++)
        {
            if(Customers.get(i).getUserName().equals(usN))
            {
                return Customers.get(i);
            }
        }
        return null;
    }
    public Driver searchd(String usN)
    {
        for(int i = 0 ; i <Drivers.size();i++)
        {
            if(Drivers.get(i).getUserName().equals(usN))
            {
                return Drivers.get(i);
            }
        }
        return null;
    }
    public boolean checkCustomername(String usN)
    {
        for(int i = 0 ; i <Customers.size();i++)
        {
            if(Customers.get(i).getUserName().equals(usN))
            {
                return true;
            }
        }
        return false;
    }
    public void suspendCustomer(String CustomerName)
    {
        for(int i = 0 ; i<Customers.size();i++){
            if(Customers.get(i).getUserName().equals(CustomerName))
            {
                System.out.println("Customer "+ CustomerName + " Was Deleted Successfully.");
                System.out.println("");
                Customers.remove(i);
                return;
            }
        }
        System.out.println("Customer " + CustomerName + " Was not found in the System.");
        System.out.println("");
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addpenders(Driver driver)
    {
        pendingDriver.add(driver);
    }

    public boolean searchDriver(String usN, String password)
    {
        for(int i = 0 ; i <Drivers.size();i++)
        {
            if(Drivers.get(i).getUserName().equals(usN) && Drivers.get(i).getPassWord().equals(password))
            {
                return true;
            }
        }
        return false;
    }
    public boolean checkdrivername(String usN)
    {
        for(int i = 0 ; i <Drivers.size();i++)
        {
            if(Drivers.get(i).getUserName().equals(usN))
            {
                return true;
            }
        }
        return false;
    }

    public boolean searchAdmin(String usN, String password)
    {
        for(int i = 0 ; i <admins.size();i++)
        {
            if(admins.get(i).getUserName().equals(usN) &&admins.get(i).getPassWord().equals(password))
            {
                return true;
            }
        }
        return false;
    }

    ////////////////////////////////////////////////////////
    public void SuspendDriver(String username) {
        for (int i = 0; i < Drivers.size(); i++) {
            if (Drivers.get(i).getUserName().equals(username)) {
                System.out.println("Driver " +username+ " Was suspended Successfully.");
                System.out.println("");
                Drivers.get(i).setPermission(false);
                suspendedDriver.add(Drivers.get(i));
                Drivers.remove(i);
                return;
            }
        }
        System.out.println("Driver " +username + " Was not found in the system.");
    }


    public void verifypenders()
    {
        if (pendingDriver.size()!=0)
        {
            for (int i =0; i< pendingDriver.size() ; ++i)
            {
                boolean cond=pendingDriver.get(i).getLicence()!="" && pendingDriver.get(i).getnID().length()==14;
                if (cond)
                {
                    pendingDriver.get(i).setPermission(true);
                    Drivers.add(pendingDriver.get(i));
                    pendingDriver.remove(i);
                }
            }
            System.out.println("Done!, According to System Policies.");
            System.out.println("");
        }
        else
        {
            System.out.println("There is No Drivers to be verified");
            System.out.println("");
        }
    }

    public void verifysuspended(String username) {
        if (suspendedDriver.size() != 0) {
            for (int i = 0; i < suspendedDriver.size(); i++) {
                if (suspendedDriver.get(i).getUserName().equals(username))
                {
                    suspendedDriver.get(i).setPermission(true);
                    Drivers.add(suspendedDriver.get(i));
                    suspendedDriver.remove(i);
                    System.out.println("Driver " +username + " Was verified Successfully.");
                    return;
                }
            }
            System.out.println("Driver " +username + " Was not found in the system.");
        }
        else {
            System.out.println("There is No Drivers to be verified");
            System.out.println("");
        }
    }

    public void searchavailable(Ride ride) {
        for (int i = 0; i < Drivers.size(); i++) {
            Drivers.get(i).SearchFavarea(ride);
        }
    }

    public void addadmin(Admin x) {
        admins.add(x);
    }
}