package com.lakeside.response;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class RoomResponse {

	private Long id;
	private String roomType;
	private BigDecimal roomPrice;
	private boolean isBooked = false;
	private String photo;
	private List<BookingResponse> bookings;

	/**
	 * @param id
	 * @param roomType
	 * @param roomPrice
	 */
	public RoomResponse(Long id, String roomType, BigDecimal roomPrice) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
	}

	/**
	 * @param id
	 * @param roomType
	 * @param roomPrice
	 * @param isBooked
	 * @param picture
	 * @param bookings
	 */
	public RoomResponse(Long id, String roomType, BigDecimal roomPrice, boolean isBooked, byte[] photoBytes,
			List<BookingResponse> bookings) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.isBooked = isBooked;
		this.photo = photoBytes != null ? Base64.getEncoder().encodeToString(photoBytes) : null;
		this.bookings = bookings;
	}

}