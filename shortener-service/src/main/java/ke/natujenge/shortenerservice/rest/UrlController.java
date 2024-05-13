package ke.natujenge.shortenerservice.rest;
//
//import com.amarin.urlshortenerapi.dto.UrlLongRequest;
//import com.amarin.urlshortenerapi.service.UrlService;
//import io.swagger.annotations.ApiOperation;
import ke.natujenge.shortenerservice.Service.UrlService;
import ke.natujenge.shortenerservice.exception.LinkExpiredException;
import ke.natujenge.shortenerservice.request.ShortUrlResponse;
import ke.natujenge.shortenerservice.request.UrlLongRequest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/shortener")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

//    @ApiOperation(value = "Convert new url", notes = "Converts long url to short url")
//    @PostMapping("/create-short")
//    public String convertToShortUrl(@RequestBody UrlLongRequest urlLongRequest) {
//        return urlService.convertToShortUrl(urlLongRequest);
//    }
    @PostMapping("/create-short")
    public ResponseEntity<ShortUrlResponse> createShortUrl(@RequestBody UrlLongRequest request) {
        ShortUrlResponse response = urlService.convertToShortUrl(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

//    @ApiOperation(value = "Redirect", notes = "Finds original url from short url and redirects")
@GetMapping(value = "{shortUrl}")
//@Cacheable(value = "urls", key = "#shortUrl", sync = true)
public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl) {
    var url = urlService.getOriginalUrl(shortUrl);
    return ResponseEntity.status(HttpStatus.FOUND)
            .location(URI.create(url))
            .build();
}
}
