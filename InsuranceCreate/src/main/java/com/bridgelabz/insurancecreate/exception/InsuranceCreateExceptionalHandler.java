package com.bridgelabz.insurancecreate.exception;

import com.bridgelabz.insurancecreate.dto.ResponseDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice									// <- whenever controller gets in trouble he looks for solution in
public class InsuranceCreateExceptionalHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		
		List<ObjectError> errorList=exception.getBindingResult().getAllErrors(); //<- binds all the errors & exceptions  and stores in error list,
		List<String> errMesg = errorList.stream()								 //and handles the validation part & showing the issues in REST call
							.map(objErr->objErr.getDefaultMessage())		
							.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST requests",errMesg);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
	//to handle exception related to user ID
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ResponseDTO> handleUserNotFound(UserException exception) {
		ResponseDTO response = new ResponseDTO("Invalid Userid input", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
	
	//to handle exception related to Insurance Create Id 
	@ExceptionHandler(InsuranceException.class)
	public ResponseEntity<ResponseDTO> handleUserNotFound(InsuranceException exception) {
		ResponseDTO response = new ResponseDTO("Invalid Insurance Create Id input", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
}
