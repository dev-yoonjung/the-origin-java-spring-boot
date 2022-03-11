package theorigin.javaspringboot.jpa.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import theorigin.javaspringboot.jpa.exception.BaseException;
import theorigin.javaspringboot.jpa.exception.ErrorResponseDTO;

@RestControllerAdvice
public class PostControllerAdvice {

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleException(BaseException exception) {
        return new ErrorResponseDTO(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseDTO handleValidException(
            MethodArgumentNotValidException exception
    ) {
        return new ErrorResponseDTO(exception.getMessage());
    }
}
