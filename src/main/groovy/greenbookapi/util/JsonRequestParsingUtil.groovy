package greenbookapi.util

import greenbookapi.common.GreenBookConstants
import greenbookapi.domain.app.Business
import greenbookapi.domain.app.Location
import greenbookapi.domain.app.PayloadPair
import greenbookapi.domain.app.PopUpReport
import greenbookapi.domain.app.Reporter
import greenbookapi.domain.app.Town
import greenbookapi.service.LocationService
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by Riley on 7/7/2018.
 *
 * Parses the JSON Requests this app can receive.
 */

class JsonRequestParsingUtil {

    @Autowired
    LocationService locService

    //TODO: Add offender storage
    private static Location parseWebLocationPayload(HashMap<String, String> location, String repId) {
        Location loc
        if (location.get('location_type') == GreenBookConstants.BUSINESS) {
            loc = new Business(location.get('name'), location.get('address'), new Date(),
                    location.get('city'), location.get('state'), location.get('item_type'), repId)
        } else {
            loc = new Town(new Date(), location.get('city'), location.get('state'), location.get('item_type'))
        }

        loc
    }

    private static Reporter parseWebReporterPayload(HashMap<String, String> reporter){
        Reporter rep = new Reporter(reporter.get('id'))

        rep
    }

    private static PopUpReport parseWebAlertPayload(HashMap<String, String> alert, HashMap<String, String> loc, String repId) {
        PopUpReport pur = new PopUpReport(new Date(), loc.get('city'), loc.get('state'), alert.get('time_reported'),
                alert.get('alert_type'), loc.get('street1'), loc.get('street2'), repId)

        pur
    }

    static PayloadPair parseLocationPayloadBody(String payload) {

        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> location = map.location

        HashMap<String, String> reporter = map.reporter

        PayloadPair pair = new PayloadPair(parseWebReporterPayload(reporter), parseWebLocationPayload(location, reporter.id))

        pair
    }

    static PayloadPair parseAlertPayloadBody(String payload) {

        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> alert = map.pop_report

        HashMap<String, String> location = map.pop_report.location

        HashMap<String, String> reporter = map.reporter

        PayloadPair pair = new PayloadPair(parseWebReporterPayload(reporter), parseWebAlertPayload(alert, location, reporter.id))

        pair
    }

//    static String parseLocationSearchPayload(String payload) {
//        def map = new JsonSlurper().parseText(payload) as Map
//
//        HashMap<String, String> location = map.pop_report.location
//
//    }

/* For /report/retrieve */
    HashMap<String, String> parseMappingInfoForLocation(String payload) {

    }

}
