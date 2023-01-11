package appplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next()); // o parse fica apontando erro por ser uma possivel erro, indicando que deve ter uma extensão pelo trows
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		
		catch(ParseException e){ // após a inserção desse tratamento o parse para de apontar o erro
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in resevatio: " + e.getMessage());
		}
		catch (RuntimeException e) { // catch genérico e pegara qualquer erro inesperado evitando e aplicação quebre (upcasting runtimeException)
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
