package greenbookapi.controller

import greenbookapi.domain.app.Location
import greenbookapi.service.LocationService
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
        String report = ''
        service.createNewReport(report)

        'Successfully created report'
    }

    @RequestMapping(value = "/retrieve", method = RequestMethod.GET,
            consumes = 'application/json')
    List<Location> retrieve(@RequestBody String payload) throws Exception {
        service.getAllLocations(payload)
    }
}
