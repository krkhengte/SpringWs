package jfs.backend.bms.user.service.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

	private String bookingId;
    private String userId;
    private String theaterId;
    private String showTimeId;
    private String movieId;
    private List<String> seats;
}
