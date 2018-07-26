package greenbookapi.domain.app

import com.fasterxml.jackson.annotation.JsonPropertyOrder


@JsonPropertyOrder(['requestId', 'locations'])
class LocationResponse {

    String requestId

    LocationList locations

    LocationResponse(){
        requestId = UUID.randomUUID().toString()
    }

    LocationResponse(LocationList list){
        requestId = UUID.randomUUID().toString()
        this.locations = list
    }

    LocationResponse(String reqId) {
        requestId = reqId
    }


}
