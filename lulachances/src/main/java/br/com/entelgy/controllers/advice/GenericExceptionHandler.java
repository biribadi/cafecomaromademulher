package br.com.entelgy.controllers.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.entelgy.dtos.MessageDto;
import br.com.entelgy.dtos.MessageType;

@ControllerAdvice
public class GenericExceptionHandler {
	
	 @Autowired
	  private MessageSource msgSource;

	  @ExceptionHandler(MethodArgumentNotValidException.class)
	  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	  @ResponseBody
	  public MessageDto processValidationError(MethodArgumentNotValidException ex) {
	    return new MessageDto(MessageType.ERROR, "API UNAVAILABLE");
	  }

}
