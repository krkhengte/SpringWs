package jfs.backend.bms.user.service.jwtToken;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponce {

    private String token;
    private String userName;
}
