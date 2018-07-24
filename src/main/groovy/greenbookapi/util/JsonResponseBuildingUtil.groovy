package greenbookapi.util

import greenbookapi.domain.app.Business
import greenbookapi.domain.app.Location
import greenbookapi.domain.app.PopUpReport
import greenbookapi.domain.app.Town
import groovy.json.JsonGenerator

/**
 * Created by Riley on 7/3/2018.
 *
 * Builds the JSON responses this API can provide.
 */

class JsonResponseBuildingUtil {

    static String businessJsonGenerator(List<Business> bizes){

    }

    static String townJsonGenerator(List<Town> towns) {

    }

    static String popReportJsonGenerator(List<PopUpReport> purs) {

    }

    //TODO: Implement these Response Building functions.
    static String createJsonForLocById(Location location) {
        null
    }

    static String createJsonForAlertById(PopUpReport popUpReport) {
        null
    }

    static String createJsonForLocationList(List<Location> locations) {
        null
    }

    static String createJsonForAlertByCityState(List<PopUpReport> popUpReports) {
        null
    }
}
