package co.com.poli.users.helpers;

import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.*;

@Component
public class ResponseBuilder {

    public Response success(){
        return Response.builder()
                .data(OK)
                .status(OK.value())
                .build();
    }
    public Response success(Object data){
        return Response.builder()
                .data(data)
                .status(OK.value())
                .build();
    }
    public Response failed(Object data){
        return Response.builder()
                .data(data)
                .status(INTERNAL_SERVER_ERROR.value())
                .build();
    }

}
