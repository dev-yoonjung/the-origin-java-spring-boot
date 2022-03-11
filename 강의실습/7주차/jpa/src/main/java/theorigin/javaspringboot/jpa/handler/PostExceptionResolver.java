package theorigin.javaspringboot.jpa.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import theorigin.javaspringboot.jpa.exception.BaseException;
import theorigin.javaspringboot.jpa.exception.ErrorResponseDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PostExceptionResolver extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) {
        logger.debug(ex.getClass());
//        if (ex instanceof BaseException) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            try {
//                response.getOutputStream().print(
//                        new ObjectMapper().writeValueAsString(
//                                new ErrorResponseDTO("in resolver, message: " + ex.getMessage())
//                        )
//                );
//                response.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//                return new ModelAndView();
//            } catch (IOException e) {
//                logger.warn("Handling exception cased exception: {}", e);
//            }
//        }
        return null;
    }
}
