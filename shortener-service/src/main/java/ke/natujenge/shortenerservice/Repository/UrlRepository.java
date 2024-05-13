package ke.natujenge.shortenerservice.Repository;

import ke.natujenge.shortenerservice.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
}
