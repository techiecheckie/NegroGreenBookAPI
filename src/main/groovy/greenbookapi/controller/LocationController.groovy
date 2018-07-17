package greenbookapi.controller

import greenbookapi.domain.app.PayloadPair
import greenbookapi.service.LocationService
import greenbookapi.service.PopUpReportService
import greenbookapi.util.JsonRequestParsingUtil
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

    //TODO: Add other endpoints

    @RequestMapping(value = "/create-location", method = RequestMethod.POST,
            consumes = 'application/json')
    String createLocation(@RequestBody String payload) throws Exception {
        try {
            PayloadPair pair = JsonRequestParsingUtil.parseLocationPayloadBody(payload)
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
            'Successfully created report for alert: ' + pair.popUpReport +
                    'and reporter with ID: ' + pair.reporter.id

        } catch (Exception e) {
            'Error happened processing your request: ' + e.printStackTrace()
        }
    }

    @RequestMapping(value = "/retrieve", method = RequestMethod.GET,
            consumes = 'application/json')
    String retrieve(@RequestBody String payload) throws Exception {

    }
}
