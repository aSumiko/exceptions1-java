package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");	
		}//PROGRAMA��O DEFENSIVA, TRATAR NO COME�O DOS METODOS
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); //getTime devolve em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//TIMEUNIT,TIPOENUMERDO COMPLEXO QUE TEM ALGUMAS OPERA��ES, CONVERTE MILISEGUBDOS PARA DIAS
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {//n�o ira return e sim lan�ar atraves do throw
			throw new DomainException("Reservation dates for update must be future dates") ;//exce��o esta lan�ada mas n�o esta tratada, quem fara isso ser� o programa principal no cacth, ent�o sera propagada atrav�s do throws
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");	
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+  ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
		
	}
	
	
	
	

}
