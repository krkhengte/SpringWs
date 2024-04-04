package jfs.backend.bms.payment.service.externalService;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("BOOKINGS-SERVICE")
public interface BookingService {

}
