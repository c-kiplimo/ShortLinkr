package ke.natujenge.shortenerservice.Service;

//import com.amarin.urlshortenerapi.dto.UrlLongRequest;
//import com.amarin.urlshortenerapi.entity.Url;
//import com.amarin.urlshortenerapi.repository.UrlRepository;
import ke.natujenge.shortenerservice.Repository.UrlRepository;
import ke.natujenge.shortenerservice.entity.Url;
import ke.natujenge.shortenerservice.exception.LinkExpiredException;
import ke.natujenge.shortenerservice.request.ShortUrlResponse;
import ke.natujenge.shortenerservice.request.UrlLongRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class UrlService {

    private final UrlRepository urlRepository;
    private final BaseConversion conversion;

    public UrlService(UrlRepository urlRepository, BaseConversion baseConversion) {
        this.urlRepository = urlRepository;
        this.conversion = baseConversion;
    }

//    public String convertToShortUrl(UrlLongRequest request) {
//        var url = new Url();
//        url.setLongUrl(request.getLongUrl());
//        url.setExpiresDate(request.getExpiresDate());
//        url.setCreatedDate(new Date());
//        var entity = urlRepository.save(url);
//
//        return "localhost:9191/shortner/"+  conversion.encode(entity.getId());
//    }

//    public ResponseEntity<String> convertToShortUrl(UrlLongRequest request) {
//        var url = new Url();
//        url.setLongUrl(request.getLongUrl());
//        url.setExpiresDate(request.getExpiresDate());
//        url.setCreatedDate(new Date());
//        var entity = urlRepository.save(url);
//        String shortUrl = "localhost:9191/shortner/" + conversion.encode(entity.getId());
//        return new ShortUrlResponse(shortUrl);
//    }

    public ShortUrlResponse convertToShortUrl(UrlLongRequest request) {
        var url = new Url();
        url.setLongUrl(request.getLongUrl());
        url.setExpiresDate(request.getExpiresDate());
        url.setCreatedDate(new Date());
        var entity = urlRepository.save(url);
        String shortUrl = "localhost:9191/shortener/" + conversion.encode(entity.getId());
        return new ShortUrlResponse(shortUrl);
    }

    public String getOriginalUrl(String shortUrl) {
        var id = conversion.decode(shortUrl);
        var entity = urlRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));

        if (entity.getExpiresDate() != null && entity.getExpiresDate().before(new Date())){
            urlRepository.delete(entity);
            throw new EntityNotFoundException("Link expired!");
        }

        return entity.getLongUrl();
    }
}
