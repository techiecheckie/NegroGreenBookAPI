package greenbookapi.service

import greenbookapi.domain.app.Location
import greenbookapi.domain.app.PayloadPair
import greenbookapi.domain.app.Reporter
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

    void createNewLocation(PayloadPair pair) {
        try {
            repRepo.save(pair.getReporter())
            locRepo.save(pair.getLocation())
        }
        catch(Exception e) {
            println('Failed to save new location:')
            e.printStackTrace()
        }
    }

    List<Location> getAllLocations(){
        List<Location> locList = locRepo.findAll()
        return locList
    }


}
