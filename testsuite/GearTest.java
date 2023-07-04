package testsuite;

import Utility.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUpBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        //Mouse Hover on Gear Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));
        //Click on Bags
        mouseHoverToElementAndClick(By.xpath("//span[normalize-space()='Bags']"));
        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        Thread.sleep(1000);
        // Verify the text ‘Overnight Duffle’
        String expectedMessage = "Overnight Duffle";
        String actualMessage = getTextFromElement(By.xpath("//a[text(),'Overnight Duffle']"));
        Assert.assertEquals(expectedMessage,actualMessage);
        //Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");
        Thread.sleep(1000);
        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedText ="You added Overnight Duffle to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(1000);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //Verify the product name ‘Cronus Yoga Pant’
        String expectedMesg ="Cronus Yoga Pant";
        String actualMesg = getTextFromElement(By.xpath("//a[text()='Cronus Yoga Pant ']"));
        Assert.assertEquals(expectedMesg,actualMesg);
        Thread.sleep(1000);
        //Verify the Qty is ‘3’
        String expectedMessag = "3";
        String actualMessag= getTextFromElement(By.xpath("(//input[@class='input-text qty'])[1]"));
        Assert.assertEquals(expectedMessag, actualMessag);
        // Verify the product price ‘$135.00’
        String expectedMess = "$135.00";
        String actualMess = getTextFromElement(By.xpath("(//span[@class='cart-price']//span)[2]"));
        Assert.assertEquals(expectedMess, actualMess);
        Thread.sleep(1000);
        //Verify the product price ‘$135.00’
        String expectedtext ="$135.00";
        String actualtext = getTextFromElement(By.xpath("//span[@class='cart-price']//span)[2]"));
        Assert.assertEquals(expectedtext,actualtext);
        //Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@class='input-text qty'])[1]")).clear();
        sendTextToElement(By.xpath("//input[@class='input-text qty'])[1]"),"5");
        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        //Verify the product price ‘$225.00’
        String expectedM = "$225.00";
        String actualM = getTextFromElement(By.xpath("(//span[@class='cart-price']//span)[2]"));
        Assert.assertEquals(expectedM,actualM);

    }
    @After
    public void close() {
  //      closeBrowser();
    }
}
