package ETicaret.Eticaret.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> handleValidationException( MethodArgumentNotValidException ex ){
        List<String> errors = new ArrayList<>();
        if(!ex.getFieldErrors().isEmpty()){
            for (FieldError fieldError : ex.getFieldErrors()){
                errors.add(fieldError.getDefaultMessage());
            }
        }
        return  errors;

    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public  String handleRuntimeException(NotFoundException ex){
        return ex.getMessage();
    }

}
