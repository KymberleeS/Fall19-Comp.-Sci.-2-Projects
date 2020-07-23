/* Kymberlee Sables
   COP 3503 - Project 2 */

import java.util.Scanner;
import java.lang.Math;

public class MyCalendar
{
	public static void main(String[] args) 
	{
		//variable initialization
			double day;
			double dayOne = 0;
			int year;
			int numOfDays;
			int month;
			int i = 0;
			String monthName;
			
		//statements
			
			//scanning user input
			Scanner input = new Scanner (System.in);
			
			//do while loop - repeats if user inputs an invalid year that is outside the range
			do
			{
				System.out.print("Enter a year from 1780 to 2040: ");
				year = input.nextInt();
				if(year < 1780 || year > 2040)
				{
					System.out.print("Year out of range. Please enter a valid year.\n");
				}
			}
			while(year < 1780 || year > 2040);
			
			//formula - given the year, this calculates the first day [0 - 6 ((Sunday = 0) - (Saturday = 6))]
			day = (28 + (year % 100) + (Math.floor(((year % 100) - 1) / (double)(4))) + (Math.floor((year) / (double)(400))) - (2 * (Math.floor((year) / (double)(100))))) % (double)7;
			
			if(day < 0)
			{
				day += 7;
			}
			
			//prints the day values
			System.out.printf("%.1f\n", day);
			
			//for loop - iterates statements, commands, functions below 12 times for 12 months
			for(month = 1; month <= 12; month++)	
			{
				//initialization
				numOfDays = 0;
				monthName = " ";
				
				//switch - each case represents a month, the month's number of days, and the positioning of the first day of the month
				switch(month)
				{
					case 1: monthName = "January";
							numOfDays = 31;
							dayOne = day;
						break;
						
					case 2: monthName = "February";
							if(((year % 4 == 0 ) && (year % 100 != 0)) || (year % 400 == 0))
								numOfDays = 29;
							else
								numOfDays = 28;
							dayOne = day + 3;
						break;
						
					case 3: monthName = "March";
							numOfDays = 31;
							dayOne = day + 3;
							if(((year % 4 == 0 ) && (year % 100 != 0)) || (year % 400 == 0))
								dayOne = day + 4;
						break;
						
					case 4: monthName = "April";
							numOfDays = 30;
							dayOne = day + 6;
							if(((year % 4 == 0 ) && (year % 100 != 0)) || (year % 400 == 0))
								dayOne = day + 7;
						break;
					
					case 5: monthName = "May";
							numOfDays = 31;
							dayOne = day + 8;
							if(((year % 4 == 0 ) && (year % 100 != 0)) || (year % 400 == 0))
								dayOne = day + 9;
						break;
						
					case 6: monthName = "June";
							numOfDays = 30;
							dayOne = day + 11;
							if(((year % 4 == 0 ) && (year % 100 != 0)) || (year % 400 == 0))
								dayOne = day + 12;
						break;
						
					case 7: monthName = "July";
							numOfDays = 31;
							dayOne = day + 13;
							if(((year % 4 == 0 ) && (year % 100 != 0)) || (year % 400 == 0))
								dayOne = day + 14;
						break;
						
					case 8: monthName = "August";
							numOfDays = 31;
							dayOne = day + 16;
							if(((year % 4 == 0 ) && (year % 100 != 0)) || (year % 400 == 0))
								dayOne = day + 17;
						break;
						
					case 9: monthName = "September";
							numOfDays = 30;
							dayOne = day + 19;
							if(((year % 4 == 0 ) && (year % 100 != 0)) || (year % 400 == 0))
								dayOne = day + 20;
						break;
						
					case 10: monthName = "October";
							 numOfDays = 31;
							 dayOne = day + 21;
							 if(((year % 4 == 0 ) && (year % 100 != 0)) || (year % 400 == 0))
								 dayOne = day + 22;
						break;
						
					case 11: monthName = "November";
							 numOfDays = 30;
							 dayOne = day + 24;
							 if(((year % 4 == 0 ) && (year % 100 != 0)) || (year % 400 == 0))
								 dayOne = day + 25;
						break;
						
					case 12: monthName = "December";
							 numOfDays = 31;
							 dayOne = day + 26;
							 if(((year % 4 == 0 ) && (year % 100 != 0)) || (year % 400 == 0))
								 dayOne = day + 27;
						break;
				}
				
				//series of print statements for the header of the calendar
				System.out.println(" ---------------------------");
				System.out.printf(" %14s %4d\n", monthName, year);
				System.out.print(" Sun Mon Tue Wed Thu Fri Sat\n");
							
				//nested if else - calculates the spacing of the first day to fall under the right day of the week
				if((dayOne % 7) >= 0)
				{
					if((dayOne % 7) == 0) {
								; 
					}
					else if((dayOne % 7) == 1) {
						System.out.print("    ");
					}
					else if((dayOne % 7) == 2) {
						System.out.print("        ");
					}
					else if((dayOne % 7) == 3) {
						System.out.print("\t    ");
					}
					else if((dayOne % 7) == 4) {
						System.out.print("\t\t");
					}
					else if((dayOne % 7) == 5) {
						System.out.print("\t\t    ");
					}
					else if((dayOne % 7) == 6) {
						System.out.print("\t\t        ");
					}
				} 
				
				//for loop - calculates the spacing between the numbers to make an even calendar grid
				for(i = 1; i <= numOfDays; i++) 
				{
					if(i < 10)
						System.out.print("   " + i);
					else
						System.out.print("  " + i);
					
					if((i + dayOne) % 7 == 0)
						System.out.println();
				}
				System.out.println();
			}		
		input.close();
	}
}
