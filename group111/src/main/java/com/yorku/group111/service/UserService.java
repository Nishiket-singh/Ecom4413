package com.yorku.group111.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.yorku.group111.dto.ResponseDto;
import com.yorku.group111.dto.SigninDto;
import com.yorku.group111.dto.SigninResponseDto;
import com.yorku.group111.dto.SignupDto;
import com.yorku.group111.exceptions.AuthenticationFailException;
import com.yorku.group111.exceptions.CustomException;
import com.yorku.group111.model.AuthenticationToken;
import com.yorku.group111.model.User;
import com.yorku.group111.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

  
    public ResponseDto signUp(SignupDto signupDto) {
        // check if user is already present
        if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
        	ResponseDto responseDto = new ResponseDto("try again", "user already present");
            return responseDto;
        }


        // hash the password

        String encryptedpassword = signupDto.getPassword();

//        try {
//            encryptedpassword = hashPassword(signupDto.getPassword());
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }

        User user = new User(signupDto.getFirstname(), signupDto.getLastname(),signupDto.getEmail(), encryptedpassword, signupDto.getStreetaddress(), signupDto.getPostalcode(), signupDto.getCity(), signupDto.getCountry());

        userRepository.save(user);

        // save the user

        // create the token

        final AuthenticationToken authenticationToken = new AuthenticationToken(user);

        authenticationService.saveConfirmationToken(authenticationToken);

        ResponseDto responseDto = new ResponseDto("success", "user created succesfully");
        return responseDto;
    }

//    private String hashPassword(String password) throws NoSuchAlgorithmException {
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        md.update(password.getBytes());
//        byte[] digest = md.digest();
//        String hash = DatatypeConverter
//                .printHexBinary(digest).toUpperCase();
//        return hash;
//    }

    public SigninResponseDto signIn(SigninDto  signInDto) {
        // find user by email

        User user = userRepository.findByEmail(signInDto.getEmail());

        if (Objects.isNull(user)) {
        	return new SigninResponseDto("User is not valid", null);
        }

        // hash the password

        try {
            if (!user.getPasswoprd().equals((signInDto.getPassword()))){ // change to hashed passwrod
            	return new SigninResponseDto("Wrong Password", null);
            }
        } catch (Exception e) { // change here to alogorithm excpetion
            e.printStackTrace();
        }

        // compare the password in DB

        // if password match

        AuthenticationToken token = authenticationService.getToken(user);

        // retrive the token

        if (Objects.isNull(token)) {
            throw new CustomException("token is not present");
        }

        return new SigninResponseDto("sucess", token.getToken());

        // return response
    }
}