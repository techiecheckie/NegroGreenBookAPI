package greenbookapi.repository

import greenbookapi.domain.app.PopUpReport
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Riley, 6/29/2018.
 *
 * Sets up needed methods for the repo.
 */

@Repository
interface PopUpReportRepository extends JpaRepository<PopUpReport, Long> {

    // Already implemented through Spring JPA
    List<PopUpReport> findByCityAndState(String city, String state)

    // Just in case
    // Already implemented through Spring JPA
    List<PopUpReport> findByCityAndStateOrderByLastReportDateDesc(String city, String state)

    // Will be used for abuse management and to find stale reports.
    List<PopUpReport> findByReporterId(String reporterId)
    List<PopUpReport> findByLastReportDateOrderByLastReportDateDesc(Date date)

    //Saving functions already included here.
}