package greenbookapi.util

import greenbookapi.common.GreenBookConstants
import greenbookapi.domain.app.Business
import greenbookapi.domain.app.Location
import greenbookapi.domain.app.PayloadPair
import greenbookapi.domain.app.PopUpReport
import greenbookapi.domain.app.Town
import spock.lang.Specification

/**
 * Created by Riley on 7/26/18.
 *
 * Tests JSON building.
 */
class JsonResponseBuildingUtilSpec extends Specification{

    def 'test Location building'(){
        given:
        String payload =
                '''{
                    "request_id": "1234567890123456789",
                    "location": {
                       "name": "Very Bad Restaurant",
                       "location_type": "Business",
                       "item_type": "Restaurant",
                       "address": "1313 Dead End Drive",
                       "city": "Crap City",
                       "state": "AL",
                       "offenders": ["RACISM", "HOMOPHOBIA"]
                     },
                    "reporter": {
                       "id": "email@email.com"
                     }
                    }'''
        String payload2 =
                '''{
                    "request_id": "1234567890123456789",
                    "location": {
                       "location_type": "Town",
                       "item_type": "Sundown Town",
                       "city": "Crap City",
                       "state": "AL",
                       "offenders": ["TRANSMISOGYNY"]
                     },
                    "reporter": {
                       "id": "blargityblargh"
                     }
                    }'''

        when:
        PayloadPair pair = JsonRequestParsingUtil.parseLocationPayloadBody(payload)
        Business bus = (Business) pair.location
        bus.id = "00000000001"
        println(bus.name)
        println(pair.reporter.id)

        PayloadPair pair2 = JsonRequestParsingUtil.parseLocationPayloadBody(payload2)
        Town town = (Town) pair2.location
        town.id = "00000000002"
        println(town.city)
        println(pair2.reporter.id)

        List<Location> locs = Arrays.asList(bus, town)
        String s = JsonResponseBuildingUtil.createJsonForLocationList(locs)

        then:
        println(s)

    }

    def 'test alert building'(){
        given:
        String payload =
                '''{
                   "request_id": "13749832479234834",
                   "pop_report": {
                     "date_reported": "07/17/2018",
                     "time_reported": "02:00:00",
                     "location_time_zone": "UTC",
                     "alert_type": "ICE Checkpoint",
                     "location": {
                       "city": "someCity",
                       "state": "someState",
                       "street1": "Klavier Ave",
                       "street2": "Klaus Ave",
                       "latitude": "",
                       "longitude": ""
                     },
                     "offenders": ["KKK", "POLICE", "MISOGYNOIR"]
                   },
                   "reporter": {
                     "id": "21222102lksjdfla70"
                   }
                }'''

        when:
        PayloadPair pair = JsonRequestParsingUtil.parseAlertPayloadBody(payload)
        PopUpReport alert = pair.popUpReport
        alert.id = "00000000003"
        println(alert.street1Name + ' and ' + alert.street2Name)
        println(alert.getOffenders())
        println(pair.reporter.id)

        List<PopUpReport> purs = Arrays.asList(alert)
        String s = JsonResponseBuildingUtil.createJsonForAlertList(purs)

        then:
        println(s)

    }

}
