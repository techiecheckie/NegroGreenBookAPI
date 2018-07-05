package greenbookapi.util

import groovy.json.JsonSlurper

/**
 * Created by Riley on 7/3/2018.
 *
 * Parses the JSON Requests this app can receive.
 */

class JsonRequestParsingUtil {

    /* For /report/create */
    static HashMap<String, String> parseReportBody(String payload) {

        def map = new JsonSlurper().parseText(payload) as Map

        HashMap<String, String> location = map.location

        HashMap<String, String> reporter = map.reporter

        println("Location: " + location)
        println("Reporter: " + reporter)

        location
    }

    /* For /report/retrieve */
    HashMap<String, String> parseMappingInfoForLocation(String payload) {

    }

}
