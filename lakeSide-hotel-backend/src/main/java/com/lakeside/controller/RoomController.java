package com.lakeside.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lakeside.model.Room;
import com.lakeside.response.RoomResponse;
import com.lakeside.service.IRoomService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoomController {

	private final IRoomService roomService = null;

	public ResponseEntity<RoomResponse> addNewRoom(@RequestParam("photo") MultipartFile photo,
			@RequestParam("roomType") String roomType, @RequestParam("roomPrice") BigDecimal roomPrice) {

		Room savedRoom = roomService.addNewRoom(photo, roomType, roomPrice);
		RoomResponse response = new RoomResponse(savedRoom.getId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());

	}

}
