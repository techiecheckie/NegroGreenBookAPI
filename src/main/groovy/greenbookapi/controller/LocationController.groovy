package greenbookapi.controller

import greenbookapi.domain.app.PayloadPair
import greenbookapi.service.LocationService
import greenbookapi.service.PopUpReportService
import greenbookapi.util.JsonRequestParsingUtil
import greenbookapi.util.JsonResponseBuildingUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by Riley on 7/3/2018.
 *
 * Rest Controller that receives requests and then forwards them back to the front end.
 */

@RestController
@RequestMapping('/report')
class LocationController {

    @Autowired
    protected LocationService locService

    @Autowired
    protected PopUpReportService prService

    @RequestMapping(value = "/create-location", method = RequestMethod.POST,
            consumes = 'application/json')
    String createLocation(@RequestBody String payload) throws Exception {
        try {
            PayloadPair pair = JsonRequestParsingUtil.parseLocationPayloadBody(payload)
            locService.createNewLocation(pair)
            'Successfully created report for location: ' + pair.location +
                    'and reporter with ID: ' + pair.reporter.id

        } catch (Exception e) {
            'Error happened processing your request: ' + e.printStackTrace()
        }
    }

    @RequestMapping(value = "/create-alert", method = RequestMethod.POST,
            consumes = 'application/json')
    String createAlert(@RequestBody String payload) throws Exception {
        try {
            PayloadPair pair = JsonRequestParsingUtil.parseAlertPayloadBody(payload)
            prService.createNewAlert(pair)
            'Successfully created report for alert: ' + pair.popUpReport +
                    'and reporter with ID: ' + pair.reporter.id

        } catch (Exception e) {
            'Error happened processing your request: ' + e.printStackTrace()
        }
    }


    @RequestMapping(value = "/retrieve-location-by-id", method = RequestMethod.GET,
            consumes = 'application/json')
    String retrieveLocationById(@RequestBody String payload) throws Exception {
        try {
            String locId = JsonRequestParsingUtil.parseLocationIdBody(payload)
            String locType = JsonRequestParsingUtil.parseLocationTypeBody(payload)
            String response = JsonResponseBuildingUtil.createJsonForLocById(locService.getById(locId, locType))
            response
        }
        catch(Exception e) {
            'Error happened processing your request: ' + e.printStackTrace()
        }
    }

    @RequestMapping(value = "/retrieve-alert-by-id", method = RequestMethod.GET,
            consumes = 'application/json')
    String retrieveAlertById(@RequestBody String payload) throws Exception {
        try {
            String alertId = JsonRequestParsingUtil.parseAlertIdBody(payload)
            String response = JsonResponseBuildingUtil.createJsonForAlertById(prService.getById(alertId))
            response
        }
        catch(Exception e) {
            'Error happened processing your request: ' + e.printStackTrace()
        }
    }

    @RequestMapping(value = "/retrieve-location-by-city-state", method = RequestMethod.GET,
            consumes = 'application/json')
    String retrieveLocationsByCityState(@RequestBody String payload) throws Exception {
        try {
            String city = JsonRequestParsingUtil.parseLocationCity(payload)
            String state = JsonRequestParsingUtil.parseLocationState(payload)
            String response = JsonResponseBuildingUtil.createJsonForLocationList(locService.getByCityState(city, state))
            response
        }
        catch(Exception e) {
            'Error happened processing your request: ' + e.printStackTrace()
        }
    }

    @RequestMapping(value = "/retrieve-alert-by-city-state", method = RequestMethod.GET,
            consumes = 'application/json')
    String retrieveAlertsByCityState(@RequestBody String payload) throws Exception {
        try {
            String city = JsonRequestParsingUtil.parseAlertCity(payload)
            String state = JsonRequestParsingUtil.parseAlertState(payload)
            String response = JsonResponseBuildingUtil.createJsonForAlertByCityState(prService.getByCityState(city, state))
            response
        }
        catch(Exception e) {
            'Error happened processing your request: ' + e.printStackTrace()
        }
    }

    @RequestMapping(value = "/retrieve-location-by-reporter", method = RequestMethod.GET,
            consumes = 'application/json')
    String retrieveLocationsByReporter(@RequestBody String payload) throws Exception {
        try {
            String repId = JsonRequestParsingUtil.parseReporterId(payload)
            String response = JsonResponseBuildingUtil.createJsonForLocationList(locService.getByReporterId(repId))
            response
        } catch (Exception e) {
            'Error happened processing your request: ' + e.printStackTrace()
        }
    }
}
