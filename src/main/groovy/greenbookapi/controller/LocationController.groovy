package greenbookapi.controller

import greenbookapi.domain.app.Location
import greenbookapi.domain.app.PayloadPair
import greenbookapi.domain.app.Reporter
import greenbookapi.service.LocationService
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
    protected LocationService service

    //TODO: Determine what the JSON should look like
    //Does this need to return a response entity?
    @RequestMapping(value = "/create", method = RequestMethod.POST,
            consumes = 'application/json')
    String create(@RequestBody String payload) throws Exception {
        try {
            PayloadPair pair = JsonRequestParsingUtil.parsePayloadBody(payload)
            'Successfully created report for location: ' + pair.location +
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
