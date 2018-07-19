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
    Date firstReportDate

    // Date it was last reported
    @NonNull
    @LastModifiedDate
    @Column(name='last_report_date')
    Date lastReportDate

    // City or county
    // City+State+Type combo must be unique
    @NonNull
    @Column(name='city')
    String city

    @NonNull
    @Column(name='state')
    String state

    // Town/County
    @NonNull
    @Column(name='type')
    String type

    // How many ppl reported it?
    @NonNull
    @Column(name='amt_reported')
    int amtReported = 1

    @Column(name='confidence')
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

    protected Town(){

    }

    Town(Date date, String city, String state, String type){
        this.firstReportDate = date
        this.lastReportDate = date
        this.city = city
        this.state = state
        this.type = determineTownType(type)
    }

    static private String determineTownType(String type) {
        return type
    }

}