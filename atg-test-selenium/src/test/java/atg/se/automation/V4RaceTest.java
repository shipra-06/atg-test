
package atg.se.automation;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class V4RaceTest extends SetupTest {

	

	@Test
	public void v4RaceTest() {
		driver.get(BASE_URL);
		Actions builder = new Actions(driver);

		// Accept Cookie
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(COOKIE_ACCEPT)).click();
		}
		// Select Horse option in left menu
		{
			driver.findElement(By.xpath(LEFT_MENU)).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			js.executeScript(WINDOW_SCROLL_TO_0_88);
			WebElement horseOption = driver.findElement(By.xpath(LEFT_MENU_HORSE_OPTION));
			builder.moveToElement(horseOption).click().perform();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		// Get GameType in Horse Race Page
		{
			List<WebElement> raceTypes = driver.findElements(By.xpath(GAME_TYPE));
			try {

				// Search the V4 Game
				for (WebElement webElement : raceTypes) {

					System.out.println("race type=" + webElement.getText());

					if (webElement.getText().equalsIgnoreCase(RACE_TYPE)) {
						webElement.click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						// data-test-id="coupon-button-leg-1-start-1"
						selectRaceV4Options();

					} else {
						System.out.println("there is no v4 race at the moment!!");
						driver.findElement(By.xpath(HORSEBETTING_CALENDAR)).click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						try {
							selectV4Race();

						} catch (Exception ex) {
							System.out.println("Selecting race for next day, today V4 race is finished.");
							driver.findElement(By.xpath(CALENDAR_NEXT_DAY_BUTTON)).click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							selectV4Race();
						}
					}
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale element exception because of page refresh " + e.getMessage());
			}
		}
	}

	private void selectRaceV4Options() {

		driver.findElement(By.xpath(V1_LEG1_HORSE1)).click();
		driver.findElement(By.xpath(V1_LEG1_HORSE2)).click();
		driver.findElement(By.xpath(V1_LEG1_HORSE3)).click();
		driver.findElement(By.xpath(V1_LEG1_HORSE4)).click();
		driver.findElement(By.xpath(V2_LEG1_HORSE1)).click();
		driver.findElement(By.xpath(V2_LEG1_HORSE2)).click();
		driver.findElement(By.xpath(V3_LEG1_HORSE1)).click();
		driver.findElement(By.xpath(V3_LEG1_HORSE3)).click();
		driver.findElement(By.xpath(V3_LEG1_HORSE5)).click();
		driver.findElement(By.xpath(V4_ALL)).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	private void selectV4Race() {
		WebElement raceV4 = driver.findElement(By.xpath(SELECT_RACE_TYPE_V4));
		if (raceV4.getAttribute(SELECT_RACE_TYPE_V4_AVAILABLE).equals("true")) {
			raceV4.click();
			selectRaceV4Options();
		}
	}
}
