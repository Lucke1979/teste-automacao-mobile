package page;

import org.junit.Assert;
import org.openqa.selenium.By;

import config.PageBase;
import io.appium.java_client.MobileElement;

public class CalculadoraPage extends PageBase{
	public static int count = 0;
	public static int firstDigit;
	public static int secondDigit;
	public static String op;
	public static double result;
	
	MobileElement element;
//	MobileElement elementResult = driver.findElement(By.id("com.google.android.calculator:id/reult_final"));
	
	
	public void click(String option) {
		if (count == 0) {
			this.element = driver.findElement(By.id("com.google.android.calculator:id/digit_" + option));
			this.element.click();
			firstDigit = Integer.parseInt(option);
			count++;
		} else if (count == 1) {
			element = driver.findElement(By.id("com.google.android.calculator:id/op_" + option));
			element.click();
			op = option;
			count++;
		} else if (count == 2) {
			element = driver.findElement(By.id("com.google.android.calculator:id/digit_" + option));
			element.click();
			secondDigit = Integer.parseInt(option);
			count++;
		} else if (count == 3) {
			element = driver.findElement(By.id("com.google.android.calculator:id/eq"));
			element.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			MobileElement resultado = driver.findElementById("com.google.android.calculator:id/result_final");
			Assert.assertTrue("Resultado Errado" , 
					calcResult() == Integer.parseInt(resultado.getText()));
			
		}
							
	}
	public int calcResult() {
		
		switch (op) {
		case "add":
			return firstDigit + secondDigit;
		case "sub":
			return firstDigit - secondDigit;
		case "div":
			return firstDigit / secondDigit;
		case "mul":
			return firstDigit * secondDigit;

		default:
			break;
		}
		return 0;
	}
	
}
