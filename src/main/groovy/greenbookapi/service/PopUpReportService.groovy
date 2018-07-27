package greenbookapi.service

import greenbookapi.common.GreenBookConstants
import greenbookapi.domain.app.PayloadPair
import greenbookapi.domain.app.PopUpReport
import greenbookapi.repository.PopUpReportRepository
import greenbookapi.repository.ReporterRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


/**
 * Created by Riley on 7/16/2018.
 *
 * Connects the LocationController to the alert data.
 */

@Slf4j
@Service
class PopUpReportService {

    @Autowired
    protected PopUpReportRepository popRepo

    @Autowired
    protected ReporterRepository repRepo

    void createNewAlert(PayloadPair pair) {
        try {
            repRepo.save(pair.getReporter())
            popRepo.save(pair.getPopUpReport())
            log.info('Saved new alert.')
        }
        catch(Exception e) {
            log.error('Failed to save new alert:'+ e.getStackTrace())

        }
    }

    List<PopUpReport> getAllAlerts(){
        List<PopUpReport> popList = new ArrayList<>()
        try {
            popRepo.findAll()
            log.info('Retrieved all alerts.')
        }
        catch (Exception e) {
            log.error('Failed to get all alerts: ' + e.getStackTrace())
        }
        popList
    }

    PopUpReport getById(String id) {
        Optional<PopUpReport> pur = popRepo.findById(id)
        PopUpReport popReport = null
        try {
            if (pur.present) {
                popReport = pur.get()
            }
            log.info('Retrieved alert by id.')
        }
        catch (Exception e) {
            log.error('Failed to get alert by id: ' + e.getStackTrace())
        }
        popReport
    }

    List<PopUpReport> getByCityState(String city, String state) {
        try {
            popRepo.findByCityAndState(city, state)
            log.info('Retrieved alerts by city state.')
        }
        catch (Exception e) {
            log.error('Failed to get alert by city state: ' + e.getStackTrace())
        }
    }
}
