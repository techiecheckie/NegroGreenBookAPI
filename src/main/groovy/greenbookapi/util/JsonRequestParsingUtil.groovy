package greenbookapi.util

import greenbookapi.common.GreenBookConstants
import greenbookapi.domain.app.Business
import greenbookapi.domain.app.Location
import greenbookapi.domain.app.PayloadPair
import greenbookapi.domain.app.Reporter
import greenbookapi.domain.app.Town
import groovy.json.JsonSlurper

/**
 * Created by Riley on 7/3/2018.
 *
 * Parses the JSON Requests this app can receive.
 */

class JsonRequestParsingUtil {

    //TODO: Update JSON docs to reflect these changes
    private static Location parseWebLocationPayload(HashMap<String, String> location) {
        Location loc
        if (location.get('primary-type') == GreenBookConstants.BUSINESS) {
            loc = new Business(location.get('name'), location.get('address'), new Date(),
                    location.get('city'), location.get('state'), location.get('type'))
        } else {
            loc = new Town(new Date(), location.get('city'), location.get('state'), location.get('type'))
        }

        return loc
    }

    private static Reporter parseWebReporterPayload(HashMap<String, String> reporter){
        Reporter rep

        rep = new Reporter(reporter.get('id'), reporter.get('hashPass'), new Date())

        rep
    }

    /* For /report/create */
    static PayloadPair parsePayloadBody(String payload) {

        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> location = map.location

        HashMap<String, String> reporter = map.reporter

        PayloadPair pair = new PayloadPair(parseWebReporterPayload(reporter), parseWebLocationPayload(location))

        pair
    }

    /* For /report/retrieve */
    HashMap<String, String> parseMappingInfoForLocation(String payload) {

    }

}
