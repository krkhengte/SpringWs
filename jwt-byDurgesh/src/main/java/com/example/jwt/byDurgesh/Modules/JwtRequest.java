package com.example.jwt.byDurgesh.Modules;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtRequest {

   private String email;
   private String password;
}
