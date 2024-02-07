package aplication;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args)  {
				 //chamando as classes scanner e simpledateformat ler dados e formatar datas
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
					
					 // aplicação do programa
					System.out.print("Room number: ");
					int number = sc.nextInt();
					System.out.print("Check-in date (dd/MM/yyyy): ");
					Date checkIn = sdf.parse(sc.next());
					System.out.print("Check-out date (dd/MM/yyyy): ");
					Date checkOut = sdf.parse(sc.next());	   
					Reservation reservation = new Reservation(number, checkIn, checkOut);
					System.out.println("Reservation: " + reservation);
					System.out.println();
					System.out.println("Enter data to update the reservation:");
					System.out.print("Check-in date (dd/MM/yyyy): ");
					//método que pega os dados digitados e formata na forma de data desejada
					checkIn = sdf.parse(sc.next());
					System.out.print("Check-out date (dd/MM/yyyy): ");
					checkOut = sdf.parse(sc.next());
					
					reservation.updateDates(checkIn, checkOut);
				    System.out.println("Reservation: " + reservation);
				    
				}
				catch(ParseException e) {
					System.out.println("Invalid date format! ");
				}
				catch(DomainException e) {
					System.out.println("Error in reservation: " + e.getMessage());
				}
		sc.close();
	}

	}


