package greenbookapi.repository

import greenbookapi.domain.app.Business
import greenbookapi.domain.app.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Riley on 7/18/2018.
 *
 * Business repo interface for Spring JPA.
 */

@Repository
interface BusinessRepository extends JpaRepository<Business, String> {

    List<Location> findByCityAndState(String city, String state)

    List<Location> findByReporter(String repId)

}
