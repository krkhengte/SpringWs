package jfs.backend.external.services;

import jfs.backend.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotels/getHotel/{hotelId}")
    Hotel getHotelDetails(@PathVariable String hotelId);

}
