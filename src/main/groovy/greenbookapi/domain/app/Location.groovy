package greenbookapi.domain.app

import greenbookapi.common.GreenBookConstants
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Table

/**
 * Created by Riley on 7/3/2018.
 *
 * Main Spring JPA object.
 * Memo to me: Is there built in work for doing searching on lists or nah?
 */

@Entity
@Table(name = 'location', schema = 'greenbookapi')
class Location {

    @Id
    @GeneratedValue
    Long id

    // Name of the establishment
    @Column(name='location_name')
    String name

    // Date it was first reported
    @CreatedDate
    @Column(name='first_report_date')
    Date firstReportDate

    // Date it was last reported
    @LastModifiedDate
    @Column(name='last_report_date')
    Date lastReportDate

    // Only necessary for Businesses/Med Facilities/Attractions location types
    // Consists of Number, Street, and apt/similar
    @Column(name='address')
    String address

    // Necessary for all location types
    @Column(name='city')
    String city
    @Column(name='state')
    String state
    @Column(name='zip_code')
    String zipCode = null

    // How many ppl reported it?
    @Column(name='amt_reported')
    int amtReported = 1

    // What kind of location are you reporting?
    @Column(name='primary_type')
    String primaryType

    // Necessary for locations with primary type as Business
    @Column(name='secondary_type')
    String secondaryType

    @Column(name='confidence')
    String confidenceTag = GreenBookConstants.UNVERIFIED

    protected Location(){

    }

    Location(String name, String address, Date date, String city,
                       String state, String type) {
        this.name = name
        this.firstReportDate = date
        // When first creating, first and last report date are the same
        this.lastReportDate = date
        this.address = address
        this.city = city
        this.state = state
        primaryType = determinePrimaryBusinessType(type)
    }

    static private String determinePrimaryBusinessType(String type) {
        return type
    }
}
