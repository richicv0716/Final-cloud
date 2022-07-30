package co.com.poli.showtimes.clientFeign;

import co.com.poli.showtimes.helpers.Response;
import co.com.poli.showtimes.helpers.ResponseBuilder;
import co.com.poli.showtimes.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class movieClientImplHystrixFallback implements movieClient{
    private final ResponseBuilder builder;

    @Override
    public Response findById(Long id) {
        return builder.success(new Movie());
    }


}
