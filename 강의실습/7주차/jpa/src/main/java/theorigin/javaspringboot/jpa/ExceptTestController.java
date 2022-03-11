package theorigin.javaspringboot.jpa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import theorigin.javaspringboot.jpa.exception.BaseException;
import theorigin.javaspringboot.jpa.exception.ErrorResponseDTO;
import theorigin.javaspringboot.jpa.exception.PostNotInBoardException;
import theorigin.javaspringboot.jpa.exception.PostNotExistException;

@RestController
@RequestMapping("/except")
public class ExceptTestController {

    @GetMapping("/{id}")
    public void throwException(@PathVariable("id") int id) {
        switch (id) {
            case 1:
                throw new PostNotExistException();
            case 2:
                throw new PostNotInBoardException();
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

//    @ExceptionHandler(BaseException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponseDTO handleBaseException(BaseException exception) {
//        return new ErrorResponseDTO(exception.getMessage());
//    }
}
