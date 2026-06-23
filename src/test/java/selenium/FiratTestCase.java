package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class FiratTestCase {

	public static void main(String[] args) {
		//1)Launch Chrome Webbrowser
		ChromeDriver driver = new ChromeDriver();
		
		//Open Google 
		driver.get("https://www.google.com");
		
		//Validate Title
		String act_title = driver.getTitle();
		if(act_title.equals("Google")) {
			System.out.println("Test case is passed.");
		}else {
			System.err.println("Test case is failed.");
		}
		
		//close the webbrowser
		driver.close();//Closes the current browser window/tab
//		driver.quit();//Closes all browser windows opened by WebDriver
	}

}
