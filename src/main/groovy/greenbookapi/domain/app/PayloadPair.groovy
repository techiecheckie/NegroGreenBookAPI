package greenbookapi.domain.app

import greenbookapi.repository.LocationRepository
import greenbookapi.repository.ReporterRepository

/**
 * Created by Riley on 7/6/2018.
 *
 * Creates a pair object that I can send to functions to manage Locations and Reporters
 * at the same time.
 */

class PayloadPair {

    Reporter reporter

    Location location

    PayloadPair(Reporter rep, Location loc) {
        reporter = rep
        location = loc
    }
}
