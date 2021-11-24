import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;

public class Admin extends User {
    public Admin(String userName, String mobileNum, String email, String passWord) {
        super(userName, mobileNum, email, passWord);
    }

    public void suspendcustomer(String customer, AllData data) {
        data.suspendCustomer(customer);
    }

    public void suspenddriver(String driver, AllData data) {
        data.SuspendDriver(driver);
    }

    public void verifysuspendeddriver(String driver, AllData data) {
        data.verifysuspended(driver);
    }

    public void verifypendingdriver(AllData data) {
        data.verifypenders();
    }
}