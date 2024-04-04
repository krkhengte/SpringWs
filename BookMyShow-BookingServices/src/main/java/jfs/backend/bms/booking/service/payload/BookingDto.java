package jfs.backend.bms.booking.service.payload;

import java.time.LocalDate;
import java.util.List;

import org.antlr.v4.runtime.misc.TestRig;

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
    private String foodId;
    private List<String> seats;
    private Double totalAmmount;
    private LocalDate createDate;
	private String cardHolderName;
	private String cvv;
	private String cardExpiry;
	private String cardNo;

    


}
