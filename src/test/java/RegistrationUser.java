import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationUser extends BaseTest {

    private By buttonSignIn = By.cssSelector("div.header_user_info>a[href*=\"my-account\"]");
    private By userEmailAdress = By.id("email_create");
    private By buttonCreatAnAccount = By.id("SubmitCreate");
    private By buttonGender = By.cssSelector("input[type='radio'][value='2']");
    private By userFirstName = By.cssSelector("#customer_firstname");
    private By userLastName = By.cssSelector("#customer_lastname");
    private By userPassword = By.id("passwd");
    private By dayBith = By.cssSelector("#days");
    private By monthBith = By.cssSelector("#months");
    private By yearBith = By.cssSelector("#years");
    private By userAdress = By.cssSelector("#address1");
    private By userCity = By.cssSelector("#city");
    private By userState = By.cssSelector("#id_state");
    private By userPostCode = By.cssSelector("#postcode");
    private By userCountry = By.cssSelector("#id_country");
    private By userPhone = By.cssSelector("#phone_mobile");
    private By userAlias = By.cssSelector("#alias");
    private By buttonRegistered = By.cssSelector("#submitAccount");

    DataUser getData = new DataUser();

      @Test
    public void registration(){


        webDriver.findElement(buttonSignIn).click();
        webDriver.findElement(userEmailAdress).sendKeys(getData.email);
        webDriver.findElement(buttonCreatAnAccount).click();

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

         webDriver.findElement(buttonGender).click();
          webDriver.findElement(userFirstName).sendKeys(getData.firstName);
          webDriver.findElement(userLastName).sendKeys(getData.lastName);
          webDriver.findElement(userPassword).sendKeys(getData.password);
          webDriver.findElement(dayBith).sendKeys(getData.dayBith);
          webDriver.findElement(monthBith).sendKeys(getData.monthBith);
          webDriver.findElement(yearBith).sendKeys(getData.yearBith);
          webDriver.findElement(userAdress).sendKeys(getData.userAdress);
          webDriver.findElement(userCity).sendKeys(getData.userCity);
          webDriver.findElement(userState).sendKeys(getData.userState);
          webDriver.findElement(userPostCode).sendKeys(getData.userPostCode);
          webDriver.findElement(userCountry).sendKeys(getData.userCountry);
          webDriver.findElement(userPhone).sendKeys(getData.userPhone);
          webDriver.findElement(userAlias).sendKeys(getData.alias);
          webDriver.findElement(buttonRegistered).click();


          Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account",
                  webDriver.getCurrentUrl());
      }

}
