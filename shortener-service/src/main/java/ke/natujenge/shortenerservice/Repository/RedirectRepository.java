//package ke.natujenge.shortenerservice.Repository;
//
//import ke.natujenge.shortenerservice.entity.Redirect;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface RedirectRepository extends JpaRepository<Redirect, Long>{
//    Optional<Redirect> findByRedirect(String redirect);
//
//    Boolean existsByRedirect(String redirect);
//
//
//}