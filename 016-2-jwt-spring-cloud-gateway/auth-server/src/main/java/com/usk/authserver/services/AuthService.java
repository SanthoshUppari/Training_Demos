package com.usk.authserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.usk.authserver.entities.AuthRequest;
import com.usk.authserver.entities.AuthResponse;
import com.usk.authserver.entities.value_objects.UserVO;
import com.usk.authserver.feignclient.UserCLient;

@Service
public class AuthService {

	@Autowired
	UserCLient userCLient;
    
	@Autowired
	JwtUtil jwt;

    public AuthResponse register(AuthRequest authRequest) {
        //do validation if user already exists
        authRequest.setPassword(BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt()));

        UserVO userVO = userCLient.save(authRequest);
        Assert.notNull(userVO, "Failed to register user. Please try again later");

        String accessToken = jwt.generate(userVO, "ACCESS");
        String refreshToken = jwt.generate(userVO, "REFRESH");

        return new AuthResponse(accessToken, refreshToken);

    }
    
}
