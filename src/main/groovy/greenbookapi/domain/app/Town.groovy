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
 * Created by Riley on 7/13/2018.
 *
 * Main Spring JPA object.
 * Memo to me: Is there built in work for doing searching on lists or nah?
 */

@Entity
@Table(name = 'town', schema = 'greenbookapi')
class Town extends Location{

    @Id
    @GeneratedValue
    String id

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

    // City or county
    // City+State+Type combo must be unique
    @NonNull
    @Column(name='city')
    String city

    @NonNull
    @Column(name='state')
    String state

    // either TOWN or COUNTY
    @NonNull
    @Column(name='location_type')
    String locationType

    // One of 'High Amount of Incidents', 'Low PoC Population', 'High GOP Population',
    // 'Sundown Town', 'Other Town'
    @NonNull
    @Column(name='item_type')
    String itemType

    // How many ppl reported it?
    @NonNull
    @Column(name='amt_reported')
    int amtReported = 1

    @Column(name='confidence_tag')
    @NonNull
    String confidenceTag = GreenBookConstants.UNVERIFIED

    @NonNull
    @Column(name='offender1')
    String offender1

    @Nullable
    @Column(name='offender2')
    String offender2

    @Nullable
    @Column(name='offender3')
    String offender3

    @NonNull
    @Column(name='reporter_id')
    String reporter

    protected Town(){

    }

    Town(String date, String city, String state, String locType, String itemType, String repId){
        this.firstReportDate = date
        this.lastReportDate = date
        this.city = city
        this.state = state
        this.locationType = locType
        this.itemType = determineTownType(itemType)
        this.reporter = repId
    }

    static private String determineTownType(String type) {
        return type
    }

}