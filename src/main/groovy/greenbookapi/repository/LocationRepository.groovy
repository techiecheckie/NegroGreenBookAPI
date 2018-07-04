package greenbookapi.repository

import greenbookapi.domain.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Riley on 7/3/2018.
 *
 * Location repo interface for Spring JPA.
 */

@Repository
interface LocationRepository extends JpaRepository<Location, Long>{
    List<Location> findByCityAndState(String city, String state)
    List<Location> findByZipCode(String zipCode)

    List<Location> findByPrimaryTypeCityAndState(String primaryType, String city, String state)
    List<Location> findByPrimaryTypeAndZipCode(String primaryType, String zipCode)

    //At some point allow ppl to define a profile that they want to search on?
}
