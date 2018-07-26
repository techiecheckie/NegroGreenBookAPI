package greenbookapi.domain.app


import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName('locations')
class LocationList extends ArrayList<Location>{}
