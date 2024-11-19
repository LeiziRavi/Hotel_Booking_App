package com.lakeside.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	@Column(name = "check_in")
	private LocalDate checkInDate;
	@Column(name = "check_out")
	private LocalDate checkOutDate;
	@Column(name = "guest_full_name")
	private String guestFullName;
	@Column(name = "guest_email")
	private String guestEmail;
	@Column(name = "adults")
	private int numOfAdults;
	@Column(name = "children")
	private int numOfChildren;
	@Column(name = "total_guest")
	private int totalNumOfGuest;
	@Column(name = "confirmation_code")
	private String bookingConfirmationCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;

	public void calculateTotalNumberOfGuests() {
		this.totalNumOfGuest = this.numOfAdults + this.numOfChildren;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @param checkInDate the checkInDate to set
	 */
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	/**
	 * @param checkOutDate the checkOutDate to set
	 */
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	/**
	 * @param guestFullName the guestFullName to set
	 */
	public void setGuestFullName(String guestFullName) {
		this.guestFullName = guestFullName;
	}

	/**
	 * @param guestEmail the guestEmail to set
	 */
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	/**
	 * @param numOfAdults the numOfAdults to set
	 */
	public void setNumOfAdults(int numOfAdults) {
		this.numOfAdults = numOfAdults;
		calculateTotalNumberOfGuests();
	}

	/**
	 * @param numOfChildren the numOfChildren to set
	 */
	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
		calculateTotalNumberOfGuests();
	}

	/**
	 * @param bookingConfirmationCode the bookingConfirmationCode to set
	 */
	public void setBookingConfirmationCode(String bookingConfirmationCode) {
		this.bookingConfirmationCode = bookingConfirmationCode;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

}
