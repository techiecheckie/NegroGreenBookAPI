package greenbookapi.service

import greenbookapi.common.GreenBookConstants
import greenbookapi.domain.app.Business
import greenbookapi.domain.app.Location
import greenbookapi.domain.app.PayloadPair
import greenbookapi.domain.app.Town
import greenbookapi.repository.BusinessRepository

import greenbookapi.repository.ReporterRepository
import greenbookapi.repository.TownRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by Riley on 7/3/2018.
 *
 * Connects the LocationController to the Location data.
 */

@Slf4j
@Service
class LocationService {

    @Autowired
    protected BusinessRepository busRepo

    @Autowired
    protected TownRepository townRepo

    @Autowired
    protected ReporterRepository repRepo

    void createNewLocation(PayloadPair pair) {
        try {
            repRepo.save(pair.getReporter())
            if (pair.getLocation() instanceof Business) {
                busRepo.save((Business) pair.getLocation())
                log.info('Saved business: ' + (Business) pair.getLocation())
            } else if (pair.getLocation() instanceof Town) {
                townRepo.save((Town) pair.getLocation())
                log.info('Saved town: ' + (Town) pair.getLocation())
            }
        }
        catch(Exception e) {
            log.error('Failed to save new location:' + e.getStackTrace())
        }
    }

    List<Location> getByCityState(String city, String state) {
        List<Location> locList = new ArrayList<>()
        try {
            locList = busRepo.findByCityAndState(city, state)
            locList.addAll(townRepo.findByCityAndState(city, state))
            log.info('Retrieved locations by city state.')
        }
        catch(Exception e) {
            log.error('Failed to get location by city state:' + e.getStackTrace())
        }
        locList
    }

    Location getById(String id, String type) {
        Optional<Location> opLoc
        Location loc = null
        try {
            if (type == GreenBookConstants.BUSINESS) {
                opLoc = busRepo.findById(id)
                if (opLoc.present) {
                    loc = opLoc.get()
                }
            } else if (type == GreenBookConstants.TOWN) {
                opLoc = townRepo.findById(id)
                if (opLoc.present) {
                    loc = opLoc.get()
                }
            }
            log.info('Retrieved location by id.')
        }
        catch (Exception e) {
            log.error('Failed to get location by id:' + e.getStackTrace())
        }
        loc
    }

    List<Location> getByReporterId(String repId) {
        List<Location> locList = new ArrayList<>()
        try {
            locList = busRepo.findByReporter(repId)
            locList.addAll(townRepo.findByReporter(repId))
            log.info('Retrieved location by reporter id.')
        }
        catch (Exception e) {
            log.error('Failed to get location by reporter id:' + e.getStackTrace())
        }
        locList
    }
}
