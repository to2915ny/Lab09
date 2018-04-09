package edu.handong.csee.java.lab09;

import java.util.Scanner;
/** This class gets data of number of salesmen then according to the number of salesmen gets data of each name and sales
 * to calculate the average of total sales of salesmen and prints out the name and sales of the salesmen who
 * made the higestsales.
 * @author to291
 *
 */
public class MarketAnalyzer {
	private double highestSales; //declare private higestsales so this variable cannot be altered
	private double averageSales; //This is a fixed variable that cannot be altered
	private SalesAssociate[] team; //array SalesAssociate[] is named team this also cannot be altered
	/**
	 * This method gets the number of salesmen and sets name and sales in the SalesAssociate class
	 */
	public void getData() {
		System.out.println("Enter the number of salesmen : ");//make user to type number of salesmen
		Scanner keyboard = new Scanner(System.in);//instantiate scanner so data can be typed in
		
		int numofSalesmen = keyboard.nextInt(); // data input from user is stored in int variable numofSalesmen
		team = new SalesAssociate[numofSalesmen];//length of array team is declared. numofSalesmen is the length of the array team
		for(int i = 0; i<numofSalesmen;i++)// for loop is declared for i=0 and i less then numofSalesmen, i increments by 1
		{
			System.out.println("Enter data for associate number : " + (i+1)); //Enter data for 1st salesment. i+1 because array starts with 0
			System.out.println("Name ? :  ");//tell user to enter name
			keyboard.nextLine();//use netLine() twice so it reads whats in the buffer first
			String name = keyboard.nextLine();//then stores the actual name typed in by user
			System.out.println("Sales ? :  ");//print out sales?
			double sales = keyboard.nextDouble();//store value sales
			
			team[i] = new SalesAssociate(); //instatiate SalesAssociate() so information typed in by user can be stored
			team[i].setName(name);//in SalesAssociate class setters setName
			team[i].setSales(sales);//and setsale. eg team[1].setName = Kevin, so in salesAssociate[1] setname would be Kevin
			
		}
		
	}
	/**
	 * This method calculates the average of total sales of salemen
	 */
	public void computeAverage(){
		double sum =0; //declare double sum
		for(int i = 0; i < team.length; i++)//for i =0 , and i is smaller then array team's length; i increments by 1
		{
			sum = sum + team[i].getSales();// sum = sum + team[i].getsales() -> add all the sales stored in array team
		}
		averageSales = sum/team.length; // store sum/length of team in variable averageSales
	}
/**
 * This method calculate the highestSales from all the salesmen
 */
	public void computeHighestSales(){
		double highestSales = 0;//declare variable highestslaes
		for(int i =0 ; i< team.length; i++) //for is declared once again so all the sales for salesmen can be read
		{
			if(highestSales < team[i].getSales()) // if highestsales smaller then that salesman's sales
				highestSales = team[i].getSales();// put that value into highestSales and continue the loop
		}
		this.highestSales = highestSales; // highestsales is not smaller than one's sale then that the highest value
										//put this value into local variable highestSales which is declared as private
		
	}
	/**
	 * This method prints out the final results - AverageSales, Higestsales and the rest sales compared with average
	 */
	public void printData() {
		System.out.println("Average : " + averageSales);
		System.out.println("Salesman who has the highest sales: ");
		for(int i = 0; i <team.length; i++)
		{
			if(team[i].getSales() == highestSales) {
				System.out.println("Name:" + team[i].getName());
				System.out.println("Sales:" + team[i].getSales());
				System.out.println( (highestSales - averageSales) + " above the average");
				System.out.println("\n");
			}
		}
		System.out.println("The rest performed as follows : ");
		for(int i = 0; i <team.length; i++)
		{
			
			if(team[i].getSales() != highestSales) {
				
				System.out.println("Name:" + team[i].getName());
				System.out.println("Sales:" + team[i].getSales());
				if(averageSales >= team[i].getSales())
					System.out.println((averageSales - team[i].getSales())+ " below the average" );
				else
					System.out.println( (team[i].getSales() - averageSales) + " above the average");
				System.out.println("\n");
				
			}
		}
	}

	public static void main(String[] args) {
		MarketAnalyzer analyzer = new MarketAnalyzer();
		analyzer.getData();
		analyzer.computeAverage();
		analyzer.computeHighestSales();
		analyzer.printData();

	}

}
