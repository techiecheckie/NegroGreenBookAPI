package greenbookapi.util

import greenbookapi.domain.app.AlertList
import greenbookapi.domain.app.AlertResponse
import greenbookapi.domain.app.Location
import greenbookapi.domain.app.LocationList
import greenbookapi.domain.app.LocationResponse
import greenbookapi.domain.app.PopUpReport

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by Riley on 7/26/2018.
 *
 * Builds the JSON responses this API can provide.
 */

class JsonResponseBuildingUtil {

    static LocationList makeLocationList(List<Location> locs) {
        LocationList list = new LocationList()
        if (locs) {
            list.addAll(locs)
        }

        list
    }

    static String createJsonForLocationList(List<Location> locations){

        LocationList list = makeLocationList(locations)
        LocationResponse res = new LocationResponse(list)
        ObjectMapper om = new ObjectMapper()
        om.writeValueAsString(res)

    }

    static AlertList makeAlertList(List<PopUpReport> alerts) {

        AlertList list = new AlertList()
        if (alerts) {
            list.addAll(alerts)
        }

        list
    }

    static String createJsonForAlertList(List<PopUpReport> popUpReports) {

        AlertList list = makeAlertList(popUpReports)
        AlertResponse res = new AlertResponse(list)
        ObjectMapper om = new ObjectMapper()
        om.writeValueAsString(res)

    }
}
