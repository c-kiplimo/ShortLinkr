//package ke.natujenge.shortenerservice.rest;
//
//import com.google.common.hash.Hashing;
//import com.sun.istack.NotNull;
//import ke.natujenge.shortenerservice.Service.RedirectService;
//import ke.natujenge.shortenerservice.entity.Redirect;
//import ke.natujenge.shortenerservice.request.RedirectionCreation;
//import org.apache.commons.validator.routines.UrlValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import javax.validation.Valid;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.nio.charset.Charset;
//import java.time.LocalDateTime;
//import java.util.concurrent.TimeUnit;
//
//import static org.springframework.http.HttpStatus.MOVED_PERMANENTLY;
//
//
//@RestController
//public class UrlShortenerRequest {
//
//    private RedirectService redirectService;
//
//    @Autowired
//    public UrlShortenerRequest(RedirectService redirectService) {
//        this.redirectService = redirectService;
//    }
//
//    @GetMapping("/{redirect}")
//    public ResponseEntity<?> handleRedirect(@PathVariable String redirect) throws URISyntaxException {
////        URI uri = new URI("https://www.google.com");
//        Redirect redirect1 = redirectService.getRedirect(redirect);
//        URI uri = new URI(redirect1.getUrl());
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(uri);
//        return new ResponseEntity<>(httpHeaders, MOVED_PERMANENTLY);
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<?> createRedirect(@Valid @RequestBody RedirectionCreation redirectionCreation) {
//       return ResponseEntity.ok(redirectService.createRedirect(redirectionCreation));
//    }
//
//}
