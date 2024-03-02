/*
 * Author PRASHANT BAURAI
 */

package pages;

import org.openqa.selenium.By;

import factory.DriverFactory;

public class EmiCalculatorHomePage{

	/* start variables */
	
	private By homeLoanTab                 = By.xpath("//li[@id='home-loan']/a[@href='#']");
	private By inputHomeLoanAmount         = By.xpath("//input[@id='loanamount']");
	private By inputHomeLoanInterestRate   = By.xpath("//input[@id='loaninterest']");
	private By inputHomeLoanTenure         = By.xpath("//input[@id='loanterm']");
	private By calculatedLoanEmiPerMonth   = By.xpath("//div[@id='emiamount']");
	private By calculatedTotalInterest     = By.xpath("//div[@id='emitotalinterest']");
	private By calculatedTotalPayment      = By.xpath("//div[@id='emitotalamount']");
    
    /* end variables */
	
    
    /* start Actions methods */
    
    /*
     * Action methods to enter Home Loan Amount
     * @param Home Loan Amount
     */
	public void enterHomeLoanAmount(String homeLoanAmount) {
		DriverFactory.getDriver().findElement(inputHomeLoanAmount).sendKeys(homeLoanAmount);
		}
	
    /*
     * Action methods to home Loan Interest Rate
     * @param Home Loan Interest Rate
     */
	public void enterInterestRate (String homeLoanInterestRate ) {
		DriverFactory.getDriver().findElement(inputHomeLoanInterestRate).sendKeys(homeLoanInterestRate );
		}
	
    /*
     * Action methods to enter Home Loan Tenure
     * @param Home Loan Tenure
     */
	public void enterHomeLoanTenure (String homeLoanTenure ) {
		DriverFactory.getDriver().findElement(inputHomeLoanTenure).sendKeys(homeLoanTenure);
		}
	
    /*
     * Action methods to get Calculated Loan EMI Per Month based on user's input
     */
	public int getCalculatedLoanEmiPerMonth () {
		String monthlyEmiAmount = DriverFactory.getDriver().findElement(calculatedLoanEmiPerMonth).getText();
	    Integer.parseInt(monthlyEmiAmount);
		}
	
	 /*
      * Action methods to get Calculated Total Interest Amount based on user's input
      */
	public int getCalculatedTotalInterestAmount () {
		String totalInterestAmount = DriverFactory.getDriver().findElement(calculatedTotalInterest).getText();
		return Integer.parseInt(totalInterestAmount);
		}
	
	/*
     * Action methods to get Calculated Total Payment based on user's input
     */
	public int getCalculatedTotalPayment () {
		String totalInterestAmount = DriverFactory.getDriver().findElement(calculatedTotalPayment).getText();
		return Integer.parseInt(totalInterestAmount);
		}
	
	/* end Actions methods */

}
