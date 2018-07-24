package greenbookapi.domain.app

import greenbookapi.common.GreenBookConstants
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.lang.NonNull
import org.springframework.lang.Nullable

import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Table

/**
 * Created by Riley on 7/3/2018.
 *
 * JPA object for Businesses.
 */

@Entity
@Table(name = 'business', schema = 'greenbookapi')
class Business extends Location{

    @Id
    @GeneratedValue
    String id

    // Name of the establishment
    @NonNull
    @Column(name='business_name')
    String name

    // Date it was first reported
    @NonNull
    @CreatedDate
    @Column(name='first_report_date')
    String firstReportDate

    // Date it was last reported
    @NonNull
    @LastModifiedDate
    @Column(name='last_report_date')
    String lastReportDate

    @NonNull
    @Column(name='address')
    String address

    // Necessary for all location types
    @NonNull
    @Column(name='city')
    String city

    @NonNull
    @Column(name='state')
    String state

    // How many ppl reported it?
    @NonNull
    @Column(name='amt_reported')
    int amtReported = 1

    // Always BUSINESS
    @NonNull
    @Column(name='location_type')
    String locationType

    // Attraction, Medical Facility, Educational Facility,
    // Restaurant/Bar, Gas/Convenience, Lodging, Other
    @NonNull
    @Column(name='item_type')
    String itemType

    @NonNull
    @Column(name='confidence_tag')
    String confidenceTag = GreenBookConstants.UNVERIFIED

    @NonNull
    @Column(name='offender_1')
    String offender1

    @Nullable
    @Column(name='offender_2')
    String offender2

    @Nullable
    @Column(name='offender_3')
    String offender3

    @NonNull
    @Column(name='reporter_id')
    String reporter

    protected Business(){

    }

    /* Web Users */
    Business(String name, String address, String date, String city,
             String state, String type, String repId) {
        this.name = name
        this.firstReportDate = date
        // When first creating, first and last report date are the same
        this.lastReportDate = date
        this.address = address
        this.city = city
        this.state = state
        this.locationType = GreenBookConstants.BUSINESS
        this.itemType = determineBusinessType(type)
        this.reporter = repId
    }

    static private String determineBusinessType(String type) {
        return type
    }

    protected void addReporter() {
        this.amtReported = this.amtReported+1
    }

}
