import com.smartcity.reporting.common.dto.ErrorResponse;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException exception) {
        int status = exception.getResponse().getStatus();
        String message = exception.getMessage() != null ? exception.getMessage() : "Request failed";

        return Response.status(status)
                .entity(new ErrorResponse(message, status))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}