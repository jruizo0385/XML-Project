        package test;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
        import Page.AddCustomerPage;
        import Page.DashboardPage;
        import Page.LoginPage;
import Util.BrowserFactory;

        public class AddCustomerTest {
	    WebDriver driver;
	
	   //@Test
	    @Parameters({"UserName", "Password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip",  "Country"})
	    public void validUserShouldBeAbleToCreateCustomer(String userName, String password, String fullName, String company, String email, String phone, String address, String city, String state, String zip, String country) {
		driver = BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(userName);
		login.insertPassword(password);
		login.clickSininButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropdown(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.selectCountryFromDropdown(country);
		addCustomerPage.insertZip(zip);
		addCustomerPage.clickSubmitButton();
		addCustomerPage.verifyProfilePage();
		
		dashboardPage.clickListCustomerMenuButton();
		
		addCustomerPage.verifyEnteredNameAndDelete();
	}
	
	    @Test
	    @Parameters({"UserName", "Password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip",  "Country"})
	    public void validUserShouldBeAbleToAddCustomerFromListCustomer(String userName, String password, String fullName, String company, String email, String phone, String address, String city, String state, String zip, String country) {
		driver = BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(userName);
		login.insertPassword(password);
		login.clickSininButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickListCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickAddCustomerOnListCusomer();
		addCustomerPage.verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropdown(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.selectCountryFromDropdown(country);
		addCustomerPage.insertZip(zip);
		addCustomerPage.clickSubmitButton();
		addCustomerPage.verifyProfilePage();
		
		dashboardPage.clickListCustomerMenuButton();
		
		addCustomerPage.insertSearchBarOnListCusomer();
		addCustomerPage.verifyEnteredNameOnSearchAndProfile();
		
		
	}

}