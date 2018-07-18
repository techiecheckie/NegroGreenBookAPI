package greenbookapi.util

import greenbookapi.domain.app.Business
import greenbookapi.domain.app.PayloadPair
import greenbookapi.domain.app.PopUpReport
import spock.lang.Specification

class JsonRequestParsingUtilSpec extends Specification{


    def 'test Location body'(){
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
                       "offenders": ["RACISM"]
                     },
                    "reporter": {
                       "id": "email@email.com"
                     }
                    }'''

        expect:
        PayloadPair pair = JsonRequestParsingUtil.parseLocationPayloadBody(payload)
        Business bus = (Business) pair.location
        println(bus.name)
        println(pair.reporter.id)
    }

    def 'test Alert parsing'(){
        given:
        String payload =
                '''{
                     "request_id": "13749832479234834",
                     "pop_report": {
                       "date_reported": "07/03/2018",
                       "time_reported": "02:00:00",
                       "location_time_zone": "UTC",
                       "alert_type": "ICE Checkpoint",
                       "location": {
                         "city": "someCity",
                         "state": "someState",
                         "street1": "Klavier Ave",
                         "street2": "Klaus Ave"
                       }
                     },
                     "reporter": {
                       "id": "21222102lksjdfla70"
                     }
                   }'''

        expect:
        PayloadPair pair = JsonRequestParsingUtil.parseAlertPayloadBody(payload)
        PopUpReport alert = (PopUpReport) pair.popUpReport
        println(alert.time)
        println(pair.reporter.id)
    }
}
