package greenbookapi.controller

import greenbookapi.domain.app.PayloadPair
import greenbookapi.service.LocationService
import greenbookapi.service.PopUpReportService
import greenbookapi.util.JsonRequestParsingUtil
import greenbookapi.util.JsonResponseBuildingUtil
import groovy.util.logging.Slf4j
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


@Slf4j
@RestController
@RequestMapping('/report')
class LocationController {

    @Autowired
    protected LocationService locService

    @Autowired
    protected PopUpReportService prService

    /**
     * FOR LOCATIONS
     */
    @RequestMapping(value = "/create-location", method = RequestMethod.POST,
            consumes = 'application/json')
    String createLocation(@RequestBody String payload) throws Exception {
        try {
            PayloadPair pair = JsonRequestParsingUtil.parseLocationPayloadBody(payload)
            locService.createNewLocation(pair)
            log.info('Successfully created report for location: ' + pair.location +
                    'and reporter with ID: ' + pair.reporter.id)
            'Successfully created report for location: ' + pair.location +
                    'and reporter with ID: ' + pair.reporter.id
        } catch (Exception e) {
            log.error('Error creating a location: ' + e.getStackTrace())
            'Error happened processing your request.'
        }
    }

    @RequestMapping(value = "/retrieve-location-by-id", method = RequestMethod.GET,
            consumes = 'application/json')
    String retrieveLocationById(@RequestBody String payload) throws Exception {
        try {
            String locId = JsonRequestParsingUtil.parseLocationIdBody(payload)
            String locType = JsonRequestParsingUtil.parseLocationTypeBody(payload)
            String response = JsonResponseBuildingUtil.createJsonForLocationList(Arrays.asList(locService.getById(locId, locType)))
            log.info('Successfully received: '+ response)
            response
        }
        catch(Exception e) {
            log.error('Error retrieving location: ' + e.getStackTrace())
            'Error happened processing your request.'
        }
    }

    @RequestMapping(value = "/retrieve-location-by-city-state", method = RequestMethod.GET,
            consumes = 'application/json')
    String retrieveLocationsByCityState(@RequestBody String payload) throws Exception {
        try {
            String city = JsonRequestParsingUtil.parseLocationCity(payload)
            String state = JsonRequestParsingUtil.parseLocationState(payload)
            String response = JsonResponseBuildingUtil.createJsonForLocationList(locService.getByCityState(city, state))
            log.info('Successfully retrieved location by city/state: '+ response)
            response
        }
        catch(Exception e) {
            log.error('Error happened retrieving location by city/state: ' + e.getStackTrace())
            'Error happened processing your request.'
        }
    }

    @RequestMapping(value = "/retrieve-location-by-reporter", method = RequestMethod.GET,
            consumes = 'application/json')
    String retrieveLocationsByReporter(@RequestBody String payload) throws Exception {
        try {
            String repId = JsonRequestParsingUtil.parseReporterId(payload)
            String response = JsonResponseBuildingUtil.createJsonForLocationList(locService.getByReporterId(repId))
            log.info('Successfully retrieved location by reporter: '+ response)
            response
        } catch (Exception e) {
            log.error('Error happened retrieving location by reporter: ' + e.getStackTrace())
            'Error happened processing your request.'
        }
    }

    /**
     * FOR ALERT
     */
    @RequestMapping(value = "/create-alert", method = RequestMethod.POST,
            consumes = 'application/json')
    String createAlert(@RequestBody String payload) throws Exception {
        try {
            PayloadPair pair = JsonRequestParsingUtil.parseAlertPayloadBody(payload)
            prService.createNewAlert(pair)
            log.info('Successfully created report for alert: ' + pair.popUpReport +
                    'and reporter with ID: ' + pair.reporter.id)
            'Successfully created report for alert: ' + pair.popUpReport +
                    'and reporter with ID: ' + pair.reporter.id

        } catch (Exception e) {
            log.error('Error happened creating alert: ' + e.getStackTrace())
            'Error happened processing your request.'
        }
    }

    @RequestMapping(value = "/retrieve-alert-by-id", method = RequestMethod.GET,
            consumes = 'application/json')
    String retrieveAlertById(@RequestBody String payload) throws Exception {
        try {
            String alertId = JsonRequestParsingUtil.parseAlertIdBody(payload)
            String response = JsonResponseBuildingUtil.createJsonForAlertList(Arrays.asList(prService.getById(alertId)))
            log.info('Successfully retrieved alert by id: ' + response)
            response
        }
        catch(Exception e) {
            log.error('Error happened retrieving alert by id: ' + e.getStackTrace())
            'Error happened processing your request.'
        }
    }

    @RequestMapping(value = "/retrieve-alert-by-city-state", method = RequestMethod.GET,
            consumes = 'application/json')
    String retrieveAlertsByCityState(@RequestBody String payload) throws Exception {
        try {
            String city = JsonRequestParsingUtil.parseAlertCity(payload)
            String state = JsonRequestParsingUtil.parseAlertState(payload)
            String response = JsonResponseBuildingUtil.createJsonForAlertList(prService.getByCityState(city, state))
            log.info('Successfully retrieved alert by city/state: ' + response)
            response
        }
        catch(Exception e) {
            log.error('Error happened retrieving alert by city/state: ' + e.getStackTrace())
            'Error happened processing your request.'
        }
    }

}
