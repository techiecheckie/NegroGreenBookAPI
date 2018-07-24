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

    private static String getCurrentDate(Date date) {
        FormatUtil.convertDateToString(date)
    }

    private static String getCurrentTime(Date date) {
        FormatUtil.extractTimeFromDate(date)
    }
    //TODO: Add offender storage
    private static Location parseWebLocationPayload(HashMap<String, String> location, String repId) {
        Location loc
        Date date = new Date()
        String sDate = getCurrentDate(date)
        if (location.get('location_type') == GreenBookConstants.BUSINESS) {
            loc = new Business(location.get('name'), location.get('address'), sDate,
                    location.get('city'), location.get('state'), location.get('item_type'), repId)
        } else {
            loc = new Town(sDate, location.get('city'), location.get('state'), location.get('location_type'), location.get('item_type'), repId)
        }

        loc
    }

    private static Reporter parseWebReporterPayload(HashMap<String, String> reporter){
        Reporter rep = new Reporter(reporter.get('id'))

        rep
    }

    private static PopUpReport parseWebAlertPayload(HashMap<String, String> alert, HashMap<String, String> loc, String repId) {
        Date date = new Date()
        String sDate = getCurrentDate(date)
        PopUpReport pur = new PopUpReport(sDate, loc.get('city'), loc.get('state'), alert.get('time_reported'),
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

    static String parseLocationIdBody(String payload) {
        def map = new JsonSlurper().parseText(payload) as Map
        HashMap<String, String> location = map.location

        location.get('id')
    }

    static String parseAlertIdBody(String payload) {
        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> alert = map.pop_alert

        alert.get('id')
    }

    static String parseLocationCity(String payload) {
        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> location = map.location
        location.get('city')
    }

    static String parseLocationState(String payload) {
        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> location = map.location

        location.get('state')
    }

    static String parseAlertState(String payload) {
        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> alert = map.pop_alert

        alert.get('state')
    }

    static String parseAlertCity(String payload) {
        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> alert = map.pop_alert

        alert.get('city')
    }

    static String parseReporterId(String payload) {
        def map = new JsonSlurper().parseText(payload) as Map
        HashMap<String, String> reporter = map.reporter
        reporter.get('id')
    }

    static String parseLocationTypeBody(String payload) {
        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> location = map.location

        location.get('type')
    }

}
