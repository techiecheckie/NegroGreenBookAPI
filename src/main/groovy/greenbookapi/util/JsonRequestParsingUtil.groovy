package greenbookapi.util

import greenbookapi.common.GreenBookConstants
import greenbookapi.domain.app.Business
import greenbookapi.domain.app.Location
import greenbookapi.domain.app.PayloadPair
import greenbookapi.domain.app.PopUpReport
import greenbookapi.domain.app.Reporter
import greenbookapi.domain.app.Town
import groovy.json.JsonSlurper

/**
 * Created by Riley on 7/7/2018.
 *
 * Parses the JSON Requests this app can receive.
 */

class JsonRequestParsingUtil {

    //TODO: Add offender storage
    private static Location parseWebLocationPayload(HashMap<String, String> location) {
        Location loc
        if (location.get('location-type') == GreenBookConstants.BUSINESS) {
            loc = new Business(location.get('name'), location.get('address'), new Date(),
                    location.get('city'), location.get('state'), location.get('item-type'))
        } else {
            loc = new Town(new Date(), location.get('city'), location.get('state'), location.get('item-type'))
        }

        loc
    }

    private static Reporter parseWebReporterPayload(HashMap<String, String> reporter){
        Reporter rep

        rep = new Reporter(reporter.get('id'))

        rep
    }

    private static PopUpReport parseWebAlertPayload(HashMap<String, String> alert) {
        null
    }

    static PayloadPair parseLocationPayloadBody(String payload) {

        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> location = map.location

        HashMap<String, String> reporter = map.reporter

        PayloadPair pair = new PayloadPair(parseWebReporterPayload(reporter), parseWebLocationPayload(location))

        pair
    }

    static PayloadPair parseAlertPayloadBody(String payload) {

        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> alert = map.pop_report

        HashMap<String, String> reporter = map.reporter

        PayloadPair pair = new PayloadPair(parseWebReporterPayload(reporter), parseWebAlertPayload(alert))

        pair
    }


/* For /report/retrieve */
    HashMap<String, String> parseMappingInfoForLocation(String payload) {

    }

}
