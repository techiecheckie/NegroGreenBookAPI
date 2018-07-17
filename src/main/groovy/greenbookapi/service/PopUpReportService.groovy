package greenbookapi.service

import greenbookapi.domain.app.PayloadPair
import greenbookapi.domain.app.PopUpReport
import greenbookapi.repository.PopUpReportRepository
import greenbookapi.repository.ReporterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


/**
 * Created by Riley on 7/16/2018.
 *
 * Connects the LocationController to the alert data.
 */

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
        }
        catch(Exception e) {
            println('Failed to save new alert:')
            e.printStackTrace()
        }
    }

    List<PopUpReport> getAllAlerts(){
        List<PopUpReport> popList = popRepo.findAll()
        return popList
    }

}
