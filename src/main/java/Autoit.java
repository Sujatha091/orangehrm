import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Autoit {
	WebDriver driver;
	
	@BeforeClass
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "././drivers/chromedriver);
        driver=new ChromeDriver();
	
	}
	
	@Test
	public void test1() throws IOException{
		driver.get("http://the-internet.herokuapp.com/upload");
		driver.findElement(By.id("file-upload")).click();
		
	}

	
}
