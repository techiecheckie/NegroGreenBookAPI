package greenbookapi.util

import greenbookapi.domain.app.PayloadPair
import spock.lang.Specification

class JsonRequestParsingUtilSpec extends Specification{


    def 'test Json Parsing Util'(){
        given:
        String payload =
                '''{
                      "request-id": "1234567890123456789",
                      "location": {
                        "name": "Very Bad Business",
                        "primary-type": "BUSINESS",
                        "address": "1313 Dead End Drive",
                        "city": "Crap City",
                        "state": "AL",
                        "secondary-type": ""
                      },
                      "reporter": {
                        "id": "9018372659",
                        "phone-country-code": "+1",
                        "city": "City Town",
                        "state": "AL",
                        "zip-code": "123456"
                      }
                }'''

        expect:
        PayloadPair pair = JsonRequestParsingUtil.parsePayloadBody(payload)
        println(pair.location.name)
        println(pair.reporter.id)
    }
}
