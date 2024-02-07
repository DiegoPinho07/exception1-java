package model.entities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	//criando as variáveis da classe
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
    //chamando o método simpledateformat como static para ser usado somente nessa classe
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   //criação dos construtores com argumentos
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw new DomainException ("Check-out date must be after check-in date!");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
    //chamando os getters e setters
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
    //criando um método para calcular a duração de um período. o mesmo precisa ser do tipo long pelo tamanho do dado 
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		//método que converte uma unidade de tempo em outra unidade de tempo para fins de cálculo
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
    //método de atualização do tipo string, pois após a checagem o programa deve retornar uma string para o programa principal
	public void updateDates(Date checkIn, Date checkOut) {
		//nova verificação para confirmar se os dados foram digitados corretamente, feitos na classe auxiliar
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException ("Error in reservation: Reservation dates for update must be future dates");
		}
		 if (!checkOut.after(checkIn)) {
			throw new DomainException ("Error in reservation: Check-out date must be after check-in date");
		 }
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
    //string para imprimir na tela
	@Override
	public String toString() {
		return "Room "
			+ roomNumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duration()
			+ " nights";
	}

}
