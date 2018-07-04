package greenbookapi.domain

import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue

/**
 * Created by Riley on 7/3/2018.
 *
 * Main Spring JPA object.
 * Memo to me: Is there built in work for doing searching on lists or nah?
 */

@Entity
class Location {

    @Id
    @GeneratedValue
    Long id

    // Name of the establishment
    String name

    // Date it was first reported
    Date firstReportDate

    // Date it was last reported
    Date lastReportDate

    // Only necessary for Businesses/Med Facilities/Attractions location types
    // Consists of Number, Street, and apt/similar
    String address

    // Necessary for all location types
    String city
    String state
    String zipCode

    // How many ppl reported it?
    int amtReported = 0

    // To make sure one person isn't multi-reporting, store IDs
    // of ppl who have reported this
    List<String> reporters = new ArrayList<>()

    // What kind of location are you reporting?
    String primaryType

    // Necessary for locations with primary type as Business
    String secondaryType

    // Offenders or high alerts must be chosen for non-town primary types
    List<String> offenders = new ArrayList<>()
    List<String> highAlerts = new ArrayList<>()

    // Required only for primary type Town
    List<String> townAlerts = new ArrayList<>()

    // Not required
    String confidenceTag

    protected Location(){

    }

    protected Location(String name, String address, Date date, String city,
                       String state, String zipCode, String type) {
        this.name = name
        this.firstReportDate = date
        // When first creating, first and last report date are the same
        this.lastReportDate = date
        this.address = address
        this.city = city
        this.state = state
        this.zipCode = zipCode
        primaryType = determinePrimaryBusinessType(type)
    }

    private String determinePrimaryBusinessType(String type) {
        return type
    }

    private void addReporter(String reporterId) {
        reporters.add(reporterId)
    }
}
