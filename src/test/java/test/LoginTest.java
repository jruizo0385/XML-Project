         package test;

         import org.openqa.selenium.WebDriver;
         import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
         import Page.DashboardPage;
         import Page.LoginPage;
import Util.BrowserFactory;

      public class LoginTest {
	
	   WebDriver driver;
		
	   @Test
	   @Parameters({"UserName", "Password"})
	   public void validUserShouldBeAbleToLogin(String userName, String password) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSininButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		
		BrowserFactory.tearDown();
		
	}

}
