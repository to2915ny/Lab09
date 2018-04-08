package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class MarketAnalyzer {
	private double highestSales;
	private double averageSales;
	private SalesAssociate[] team;
	
	public void getData() {
		System.out.println("Enter the number of salesmen : ");
		Scanner keyboard = new Scanner(System.in);
		
		int numofSalesmen = keyboard.nextInt();
		team = new SalesAssociate[numofSalesmen];
		for(int i = 0; i<numofSalesmen;i++)
		{
			System.out.println("Enter data for associate number : " + (i+1));
			System.out.println("Name ? :  ");
			keyboard.nextLine();
			String name = keyboard.nextLine();
			System.out.println("Sales ? :  ");
			double sales = keyboard.nextDouble();
			
			team[i] = new SalesAssociate(); //instatiate Salesman()
			team[i].setName(name);
			team[i].setSales(sales);
			
		}
		
	}
	public void computeAverage(){
		double sum =0;
		for(int i = 0; i < team.length; i++)
		{
			sum = sum + team[i].getSales();
		}
		averageSales = sum/team.length;
	}

	public void computeHighestSales(){
		double highestSales = 0;
		for(int i =0 ; i< team.length; i++)
		{
			if(highestSales < team[i].getSales())
				highestSales = team[i].getSales();
		}
		this.highestSales = highestSales;
		
	}
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
