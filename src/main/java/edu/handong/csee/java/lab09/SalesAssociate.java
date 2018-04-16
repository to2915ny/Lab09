package edu.handong.csee.java.lab09;
/**
 * Here this class simply sets and return the value stored from the class MarketAnalyzer.
 * @author to291
 *
 */
public class SalesAssociate {

	private String name = ""; //declare name and
	private double sales; //declare sales as private so information cannot be altered.
	
	public void sales(double sales, String name) {
		this.sales = sales;
		this.name =name;
	}
	/**This method gets name from class MarketAnalyzer and stores into local variable name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;//name is stored
	}
	/**
	 * This method gets sales value from class MarketAnalyzer and stores into local variable sales
	 * @param sales
	 */
	public void setSales(double sales) {
		this.sales = sales;//sales is stored
	}
	/**
	 * This method returns stored double value to class MarketAnalyzer 
	 * @return
	 */
	public double getSales()
	{
		return sales;//returns the value sales
	}
	/**
	 * This method returns the stored string value name to class MarketAnalyzer
	 * @return
	 */
	public String getName()
	{
		return name;//returns name
	}

}
