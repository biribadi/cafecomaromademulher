package br.com.entelgy.controllers.advice;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
public class ControllerValidationHandler {
  @Autowired
  private MessageSource msgSource;

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public MessageDto processValidationError(MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();
    FieldError error = result.getFieldError();
    return processFieldError(error);
  }
  
  private MessageDto processFieldError(FieldError error) {
    MessageDto message = null;
    if (error != null) {
      Locale currentLocale = LocaleContextHolder.getLocale();
      String msg = msgSource.getMessage(error.getField() + "requerid", null, currentLocale);
      message = new MessageDto(MessageType.ERROR, msg);
    }
    return message;
  }
}