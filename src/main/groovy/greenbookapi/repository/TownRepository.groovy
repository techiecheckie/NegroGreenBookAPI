package greenbookapi.repository

import greenbookapi.domain.app.Location
import greenbookapi.domain.app.Town
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Riley on 7/18/2018.
 *
 * Town repo interface for Spring JPA.
 */

@Repository
interface TownRepository extends JpaRepository<Town, String> {

    List<Location> findByCityAndState(String city, String state)

    List<Location> findByReporter (String repId)

}
