import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;



public class TestAddCart  extends BaseTest{


    @Test
    public void clickCartRightCorner() {
        // нажимаем на кнопку   Cart в правом углу сайта
        WebElement buttonCart = webDriver.findElement
                (By.cssSelector("a[href*='controller=order'][title='View my shopping cart']"));
        buttonCart.click();
        //проверяем что корзина открылась
        Assert.assertEquals("http://automationpractice.com/index.php?controller=order",
                webDriver.getCurrentUrl());

    }

    @Test

    public void addCarButtonOnImage() {
        //скролим до нужной картинки
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,700)", "");

        Actions actions = new Actions(webDriver);
        //наводим на нужную картинку мышку
        WebElement imageProduct = webDriver.findElement
                (By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]"));
        actions.moveToElement(imageProduct).build().perform();
        // нажимаем на кнопку Cart
        WebElement buttonAddCart = webDriver.findElement
                (By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]"));
        buttonAddCart.click();
        // делаем задержку, чтоб открылось окно - товар добавлен
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //проверяем что открылось окно с товаром в корзине
        WebElement windowCart = webDriver.findElement
        (By.id("index"));


        boolean checkWindowCart = windowCart.isDisplayed();

        Assert.assertTrue(checkWindowCart);

        WebElement buttonClose = webDriver.findElement
                (By.cssSelector("span[class='cross'][title='Close window']"));
        buttonClose.click();

    }

    @Test
    public void addCartFloatingButton() {

        // скролим до нужного товара
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,700)", "");

        Actions actions = new Actions(webDriver);
        //наводим курсор мышки на товар
        WebElement imageProduct = webDriver.findElement
                (By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]"));
        actions.moveToElement(imageProduct).build().perform();
        //нажимаем на всплывающую кнпку - добавление в корзину
        WebElement buttonFloatingCart = webDriver.findElement
                (By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[2]/span"));
        buttonFloatingCart.click();

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // проверяем что страница с добавленым товаром открылась
        WebElement pageCart = webDriver.findElement
                (By.id("page"));

        boolean checkPage = pageCart.isDisplayed();

        Assert.assertTrue(checkPage);

        System.out.println("Page is Displayed");

        WebElement buttonClose = webDriver.findElement
                (By.xpath("//*[@id=\"index\"]/div[2]/div/div/a"));
        buttonClose.click();
    }
}





