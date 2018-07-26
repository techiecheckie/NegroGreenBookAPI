package greenbookapi.domain.app

import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder(['requestId', 'alerts'])
class AlertResponse {

    String requestId

    AlertList alerts

    AlertResponse(){
        requestId = UUID.randomUUID().toString()
    }

    AlertResponse(AlertList list){
        requestId = UUID.randomUUID().toString()
        this.alerts = list
    }

    AlertResponse(String reqId) {
        requestId = reqId
    }
}
