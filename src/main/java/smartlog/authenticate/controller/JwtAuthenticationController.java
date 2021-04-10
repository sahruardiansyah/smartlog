package smartlog.authenticate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import smartlog.authenticate.config.JwtTokenUtil;
import smartlog.authenticate.entity.JwtRequest;
import smartlog.authenticate.entity.JwtResponse;
import smartlog.authenticate.entity.UserPrincipal;
import smartlog.authenticate.service.JwtUserDetailsService;
import smartlog.authenticate.service.RegistrationService;
import smartlog.exception.EmailAlreadyExistException;
import smartlog.exception.InvalidInputException;
import smartlog.exception.PhoneAlreadyExistException;
import smartlog.officer.entity.CreateOfficerRequest;
import smartlog.officer.service.OfficerService;
import smartlog.payload.ErrorResponse;
import smartlog.payload.SuccessDataResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	RegistrationService registrationService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody CreateOfficerRequest request) throws Exception {
		try {
			registrationService.registerOfficer(request);
			SuccessDataResponse<?> response = new SuccessDataResponse<Object>("User registered successfully", "User registered successfully");
			return new ResponseEntity<Object>(response, HttpStatus.CREATED);
		}catch (EmailAlreadyExistException ex) {
			ErrorResponse response = new ErrorResponse("Bad request", "Email already taken!", 500);
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}catch (PhoneAlreadyExistException ex) {
			ErrorResponse response = new ErrorResponse("Bad request", "Phone number already taken!", 500);
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}catch (InvalidInputException ex) {
			ErrorResponse response = new ErrorResponse("Bad request", "Missing at least one input parameter!", 500);
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}catch (Exception ex) {
			ErrorResponse response = new ErrorResponse("Internal Server Error", ex.getLocalizedMessage(), 500);
			return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private void authenticate(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}