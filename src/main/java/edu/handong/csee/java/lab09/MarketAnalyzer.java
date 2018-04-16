package edu.handong.csee.java.lab09;

import java.util.ArrayList;//Gets ArrayList class from package to use
import java.util.Scanner;
/** This class gets data of number of salesmen then according to the number of salesmen gets data of each name and sales
 * to calculate the average of total sales of salesmen and prints out the name and sales of the salesmen who
 * made the higestsales.
 * @author to291
 *
 */
public class MarketAnalyzer {
	private double highestSales; //declare private higestsales so this variable so it be accessed only by setters and getters from outside
	private double averageSales; //This stores the averagesale of salesmen
	private int length =0;;//stores the number of sales in total
	ArrayList<SalesAssociate> team = new ArrayList<SalesAssociate>(); //instantiate ArrayList<SalesAssociate> to a thing called team
	// previous array SalesAssociate[] is named team
	/**
	 * This method gets the number of salesmen and sets name and sales in the SalesAssociate class
	 */
	public void getData() {
		
		
		
		Scanner keyboard = new Scanner(System.in);//instantiate scanner so data can be typed in

		boolean done = false;//boolean done variable is set false
		int i= 0; // int i variable declared
			while(!done) { //while done = true
			SalesAssociate asso = new SalesAssociate(); //instantiate class SalesAssociate to asso
			System.out.println("Enter data for associate number : " + (i+1)); //Enter data for 1st salesment. i+1 because array starts with 0
			i++;//increment i so next salesman number can be print out
			this.length = i;//stores the number of salesmen
			System.out.println("Name ? :  ");//tell user to enter name
			
			String name = keyboard.nextLine(); //store whats typed into string variable name
			asso.setName(name);// now store name into class SalesAssociate using the setters
			System.out.println("Sales ? :  ");//print out sales?
			
			double sales = keyboard.nextDouble();//store value sales
			asso.setSales(sales);//store sales into SalesAssociate using setters
			team.add(asso);//store name and sales into arraylist
			System.out.println("More items for the list? ");//ask user to add more salesmen to the array 
			
			keyboard.nextLine();//use netLine() twice so it reads whats in the buffer first
			String ans = keyboard.nextLine();//read from keyboard
			if(!ans.equalsIgnoreCase("yes"))//if user types yes whether its in caps or undercaps
				done = true;//done is equal to true and the loop continues
			
			
		}
			
	}
	/**
	 * This method calculates the average of total sales of salemen
	 */
	public void computeAverage(){
		double sum =0; //declare double sum
		for(int i = 0; i < this.length; i++)//for i =0 , and i is smaller then arraylist size; i increments by 1
		{
			sum = sum + team.get(i).getSales();// sum = sum + team.get(i).getSales() -> add all the sales stored in all salesmen array
		}
		averageSales = sum/this.length; // store sum/length of team in variable averageSales
	}
	/**
	 * This method calculate the highestSales from all the salesmen
	 */
	public void computeHighestSales(){
		double highestSales = 0;//declare variable highestslaes
		for(int i =0 ; i< this.length; i++) //for is declared once again so all the sales for salesmen can be read
		{
			if(highestSales < team.get(i).getSales()); // if highestsales smaller then that salesman's sales
				highestSales = team.get(i).getSales();// put that value into highestSales and continue the loop
		}
		this.highestSales = highestSales; // highestsales is not smaller than one's sale then that the highest value
		//put this value into instance variable highestSales which is declared as private

	}
	/**
	 * This method prints out the final results - AverageSales, Higestsales and the rest sales compared with average
	 */
	public void printData() {
		System.out.println("Average : " + averageSales);//print out average
		System.out.println("Salesman who has the highest sales: ");// print out salesman who has the highest sales
		for(int i = 0; i <this.length; i++) //for i =0 i is smaller then array team's lenght, increment i by 1
		{
			if(team.get(i).getSales() == highestSales) {// if the value in team.(i).getsales is equal to the value in highestSales
				System.out.println("Name:" + team.get(i).getName());//then print out that name of the index
				System.out.println("Sales:" + team.get(i).getSales());//print out the sales of that index
				System.out.println( (highestSales - averageSales) + " above the average"); // then print out the value subtracted from highestsales and average
				System.out.println("\n");//to show how much more sales he did than the average
			}
		}
		System.out.println("The rest performed as follows : ");//print out the rest of the salesmen
		for(int i = 0; i <this.length; i++)//for i=0 and i is smaller than team's length
		{

			if(team.get(i).getSales() != highestSales) {//if the value in team.get(i).getSales() is not highestsales

				System.out.println("Name:" + team.get(i).getName());//print out the name
				System.out.println("Sales:" + team.get(i).getSales());//print out the sales
				if(averageSales >= team.get(i).getSales())//if average sales is bigger than that indexs sales
					System.out.println((averageSales - team.get(i).getSales())+ " below the average" );// print out the averagesale - team.get(i).getSales() that much below the average
				else
					System.out.println( (team.get(i).getSales() - averageSales) + " above the average");//if not print out the subtracted value and above the average
				System.out.println("\n");//print out enter for better view

			}
		}
	}
	/**
	 * This class initiate methods and results are given
	 * @param args
	 */
	public static void main(String[] args) {
		MarketAnalyzer analyzer = new MarketAnalyzer();//instantiate the class
		analyzer.getData();//run method get data
		analyzer.computeHighestSales();//then compute the highestsales
		analyzer.computeAverage();//then compute the average
		
		analyzer.printData();//print the result

	}

}
