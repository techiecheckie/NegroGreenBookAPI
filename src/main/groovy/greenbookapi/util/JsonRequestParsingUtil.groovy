package greenbookapi.util

import greenbookapi.common.GreenBookConstants
import greenbookapi.domain.app.Location
import greenbookapi.domain.app.PayloadPair
import greenbookapi.domain.app.Reporter
import groovy.json.JsonSlurper

/**
 * Created by Riley on 7/3/2018.
 *
 * Parses the JSON Requests this app can receive.
 */

class JsonRequestParsingUtil {

    private static Location parseLocationPayload(HashMap<String, String> location) {
        Location loc
        if (location.get('primary-type') != GreenBookConstants.TOWN) {
            loc = new Location(location.get('name'), location.get('address'), new Date(),
                    location.get('city'), location.get('state'), location.get('primary-type'))
            if (location.get('secondary-type')!= '') {
                loc.setSecondaryType(location.get('secondary-type'))
            }
        } else {
            loc = new Location(location.get('name'), null, new Date(),
                    location.get('city'), location.get('state'), location.get('primary-type'))
        }

        return loc
    }

    private static Reporter parseReporterPayload(HashMap<String, String> reporter){
        Reporter rep
        if (reporter.get('isUsian') == 'y') {
            rep = new Reporter(reporter.get('id'), new Date(), reporter.get('phone-country-code'),
                    reporter.get('city'), reporter.get('state'))
        } else {
            rep = new Reporter(reporter.get('id'), new Date(), reporter.get('phone-country-code'), reporter.get('country'))
        }
        rep
    }

    /* For /report/create */
    static PayloadPair parsePayloadBody(String payload) {

        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> location = map.location

        HashMap<String, String> reporter = map.reporter

        PayloadPair pair = new PayloadPair(parseReporterPayload(reporter), parseLocationPayload(location))

        pair
    }

    /* For /report/retrieve */
    HashMap<String, String> parseMappingInfoForLocation(String payload) {

    }

}
