package com.lakeside.service;

import java.math.BigDecimal;
import org.springframework.web.multipart.MultipartFile;
import com.lakeside.model.Room;

public interface IRoomService {

	Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice);

}
