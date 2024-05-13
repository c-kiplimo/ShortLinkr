//package ke.natujenge.shortenerservice.Service;
//
//
//import ke.natujenge.shortenerservice.Repository.RedirectRepository;
//import ke.natujenge.shortenerservice.entity.Redirect;
//import ke.natujenge.shortenerservice.exception.NotFoundException;
//import ke.natujenge.shortenerservice.request.RedirectionCreation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class RedirectService {
//
//    private RedirectRepository redirectRepository;
//
//    @Autowired
//    public RedirectService(RedirectRepository redirectRepository) {
//        this.redirectRepository = redirectRepository;
//    }
//
//    public Optional<Redirect> createRedirect(RedirectionCreation redirectionCreation) {
//       if(redirectRepository.existsByRedirect(redirectionCreation.getRedirect())){
//           throw new RuntimeException("Redirect query exists already");
//       }
//       System.out.println("Redirect Request" + redirectionCreation.toString());
//       Redirect redirect = new Redirect(redirectionCreation.getRedirect(), redirectionCreation.getUrl());
//       Redirect postSaveRedirect = redirectRepository.save(redirect);
//       System.out.println("Redirect" + postSaveRedirect);
//        return Optional.ofNullable(postSaveRedirect);
//    }
//
//    public Redirect getRedirect(String alias) {
//        Redirect redirect = redirectRepository.findByRedirect(alias)
//                .orElseThrow(() -> new NotFoundException("Hey we don't have that alias ! Try making it"));
//        return redirect;
//    }
//
//}
