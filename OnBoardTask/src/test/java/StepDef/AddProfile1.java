package StepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.rules.Timeout;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddProfile1 {

    WebDriver driver;
    Duration timeout;
    @Given("user navigates to given url")
    public void userNavigatesToGivenUrl() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://www.skillswap.pro/Account/Profile#");
    }

    @When("user enters username")
    public void userEntersUsername() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kavya.vaddepally@gmail.com");
    }

    @And("User enters password")
    public void userEntersPassword() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Duggu26");
    }

    @And("user clicks on submit button")
    public void userClicksOnSubmitButton() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
    }

    @Then("user login to the site")
    public void userLoginToTheSite() {
        System.out.println("Sucess");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @And("user clicks languages")
    public void userClicksLanguages() {
        String status=driver.findElement(By.xpath("//a[@data-tab='first']")).getAttribute("class");
        if(status.contains("active")){
            Assert.assertTrue(status.contains("active"));
        }
        else{
            driver.findElement(By.xpath("//a[@data-tab='first']")).click();
            Assert.assertTrue(status.contains("active"));
        }


    }

    @And("user click Add new button for language")
    public void userClickAddNewButtonForLanguage() {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(120) );
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[text()='Language']//following::div[1][text()='Add New']")));
        try{
        TimeUnit.SECONDS.sleep(10);
        driver.findElement(By.xpath("//th[text()='Language']//following::div[1][text()='Add New']")).click();}
        catch(InterruptedException e){
            System.out.println("catched");
        }

    }

    @And("user edit add language")
    public void userEditAddLanguage() {
        driver.findElement(By.xpath("//input[contains(@placeholder,'Add Language')]")).sendKeys("English");

    }

    @And("user edit Level")
    public void userEditLevel() {
        Select s=new Select(driver.findElement(By.xpath("//select[contains(@class,'ui dropdown')]")));
        s.selectByIndex(3);
    }

    @And("user clicks Add button")
    public void userClicksAddButton() {
        driver.findElement(By.xpath("//input[contains(@class,'ui teal button')]")).click();

    }

    @And("user enters to skills")
    public void userEntersToSkills() {
        try{
            TimeUnit.SECONDS.sleep(10);
        driver.findElement(By.xpath("//a[@data-tab='second']")).click();}
        catch(InterruptedException e){
            System.out.println("catched");
        }

    }

    @And("user edit Add skills")
    public void userEditAddSkills() {
        driver.findElement(By.xpath("//input[contains(@placeholder,'Add Skill')]")).sendKeys("Test");

    }

    @And("user edit level skills")
    public void userEditLevelSkills() {
        Select s=new Select(driver.findElement(By.xpath("//select[contains(@name,'level')]")));
        s.selectByIndex(3);
    }

    @And("user enters to Education")
    public void userEntersToEducation() {
        try{
            TimeUnit.SECONDS.sleep(10);
            driver.findElement(By.xpath("//a[@data-tab='third']")).click();}
        catch(InterruptedException e){
            System.out.println("catched");
        }
    }

    @And("user edit Add education")
    public void userEditAddEducation() {
        driver.findElement(By.name("instituteName")).sendKeys("Industry Connect");
    }


    @And("user enters to Certifications")
    public void userEntersToCertifications() {
        try{
            TimeUnit.SECONDS.sleep(10);
            driver.findElement(By.xpath("//a[@data-tab='fourth']")).click();}
        catch(InterruptedException e){
            System.out.println("catched");
        }
    }

    @And("user edit Add certification")
    public void userEditAddCertification() {
        driver.findElement(By.name("certificationName")).sendKeys("ISTQB");
    }

    @And("close the driver")
    public void closeTheDriver() {
        driver.close();

    }


    @And("user can close driver")
    public void userCanCloseDriver() {
    }

    @Then("language is successfully added to languages list")
    public void languageIsSuccessfullyAddedToLanguagesList() {
        driver.findElement(By.xpath("//*[text()='English has been added to your languages']")).isDisplayed();
    }

    @Then("skill is successfully added to skills list")
    public void skillIsSuccessfullyAddedToSkillsList() {
        driver.findElement(By.xpath("//*[text()='Test has been added to your skills']")).isDisplayed();
    }

    @Then("user click Add new button for skills")
    public void userClickAddNewButtonForSkills() {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(120) );
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[text()='Skill']//following::div[1][text()='Add New']")));
        try{
            TimeUnit.SECONDS.sleep(10);
            driver.findElement(By.xpath("//th[text()='Skill']//following::div[1][text()='Add New']")).click();}
        catch(InterruptedException e){
            System.out.println("catched");
        }
    }

    @Then("user click Add new button for Education")
    public void userClickAddNewButtonForEducation() {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(120) );
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[text()='Graduation Year']//following::div[1][text()='Add New']")));
        try{
            TimeUnit.SECONDS.sleep(10);
            driver.findElement(By.xpath("//th[text()='Graduation Year']//following::div[1][text()='Add New']")).click();}
        catch(InterruptedException e){
            System.out.println("catched");
        }
    }

    @Then("user click Add new button for Certifications")
    public void userClickAddNewButtonForCertifications() {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(120) );
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[text()='Certificate']//following::div[1][text()='Add New']")));
        try{
            TimeUnit.SECONDS.sleep(10);
            driver.findElement(By.xpath("//th[text()='Certificate']//following::div[1][text()='Add New']")).click();}
        catch(InterruptedException e){
            System.out.println("catched");
        }
    }

    @And("user selects country")
    public void userSelectsCountry() {
        Select s=new Select(driver.findElement(By.name("country")));
        s.selectByVisibleText("New Zealand");
    }

    @And("user selects title")
    public void userSelectsTitle() {
        Select s=new Select(driver.findElement(By.name("title")));
        s.selectByVisibleText("B.Tech");
    }

    @And("user can enter Degree")
    public void userCanEnterDegree() {
        driver.findElement(By.name("degree")).sendKeys("degree");
    }

    @And("user selects year of graduation")
    public void userSelectsYearOfGraduation() {
        Select s=new Select(driver.findElement(By.name("yearOfGraduation")));
        s.selectByVisibleText("2014");
    }

    @Then("Education is successfully added to Education list")
    public void educationIsSuccessfullyAddedToEducationList() {
        driver.findElement(By.xpath("//*[text()=' Education has been added ']")).isDisplayed();
    }

    @Then("Certification is successfully added to Certification list")
    public void certificationIsSuccessfullyAddedToCertificationList() {
        driver.findElement(By.xpath("//*[text()='ISTQB has been added to your certification']")).isDisplayed();
    }

    @And("user can add certification from")
    public void userCanAddCertificationFrom() {
        driver.findElement(By.name("certificationFrom")).sendKeys("nz");
    }

    @And("user selects year")
    public void userSelectsYear() {
        Select s=new Select(driver.findElement(By.name("certificationYear")));
        s.selectByVisibleText("2018");
    }
}