package greenbookapi.repository

import greenbookapi.domain.app.Reporter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Riley on 7/4/2018.
 *
 * Reporter repo interface for Spring JPA.
 */

@Repository
interface ReporterRepository extends JpaRepository<Reporter, String>{

}
