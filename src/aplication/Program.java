package aplication;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		 //chamando as classes scanner e simpledateformat ler dados e formatar datas
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         // aplicação do programa
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
           //comparação de datas usando o método after
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			//instanciando a classe criada reservation
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			//método que pega os dados digitados e formata na forma de data desejada
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			//criação de uma variável date para comparar dados atualizados da aplicação
			Date now = new Date();
			//nova verificação para confirmar se os dados foram digitados corretamente
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				//chamando o método updateDates para alterar o valor que está na nos argumentos checkIn e CheckOut
				reservation.updateDates(checkIn, checkOut);
				//estando tudo certo, o programa imprime o string da classe reservation
				System.out.println("Reservation: " + reservation);
			}
		}

		sc.close();

	}

}
