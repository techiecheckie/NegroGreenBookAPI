package greenbookapi.service

import greenbookapi.domain.app.Location
import greenbookapi.repository.LocationRepository
import greenbookapi.repository.ReporterRepository
import greenbookapi.util.JsonRequestParsingUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by Riley on 7/3/2018.
 *
 * Connects the LocationController to the data.
 */

@Service
class LocationService {

    @Autowired
    protected LocationRepository locRepo

    @Autowired
    protected ReporterRepository repRepo

    void createNewReport(HashMap<String, Object> payload) {
        HashMap<String, Object> map = JsonRequestParsingUtil.parseReportBody(payload)
        // Do further parsing to save
        locRepo.save()
    }

    List<Location> getAllLocations(HashMap<String, Object> payload){
        HashMap<String, Object> map = JsonRequestParsingUtil.parseMappingInfoForLocation(payload)
        List<Location> locList = locRepo.findAll()
        return locList
    }


}
