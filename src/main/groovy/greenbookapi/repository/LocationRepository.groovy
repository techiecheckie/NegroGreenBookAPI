package greenbookapi.repository

import greenbookapi.domain.app.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Riley on 7/4/2018.
 *
 * Location repo interface for Spring JPA.
 */

@Repository
interface LocationRepository extends JpaRepository<Location, Long>{
    List<Location> findByCityAndState(String city, String state)

    List<Location> findByPrimaryTypeAndCityAndState(String primaryType, String city, String state)

    //TODO: At some point allow ppl to define a profile that they want to search on?
}
