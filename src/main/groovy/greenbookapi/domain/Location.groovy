package greenbookapi.domain

import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue

/**
 * Created by Riley on 7/3/2018.
 */

@Entity
class Location {

    @Id
    @GeneratedValue
    Long id

    Date date

    String city

    String state

    String zipCode

    // Assigned at creation.
    String reporterId

    String latitude

    String longitude

    int amtReported = 0

    protected Location(){

    }

    protected Location(Date date, String city, String state, String zipCode) {
        this.date = date
        this.city = city
        this.state = state
        this.zipCode = zipCode
    }
}
