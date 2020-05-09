package com.stereo.endpoint_information.controllers;

import com.stereo.endpoint_information.exceptions.IncorrectCredentialException;
import com.stereo.endpoint_information.models.AuthenticationRequest;
import com.stereo.endpoint_information.models.AuthenticationResponse;
import com.stereo.endpoint_information.models.User;
import com.stereo.endpoint_information.services.UserDetailService;
import com.stereo.endpoint_information.utilities.JwtUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EntityManager entityManager;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
    {
        try {
            String  originalPassword = authenticationRequest.getPassword();
            String generatedSecuredPasswordHash = Sha512DigestUtils.shaHex(originalPassword);


            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), generatedSecuredPasswordHash));
        } catch (BadCredentialsException e) {

            throw new IncorrectCredentialException("The user credintials are wrong");
        }

        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class, authenticationRequest.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwt ,  user));

    }

}
