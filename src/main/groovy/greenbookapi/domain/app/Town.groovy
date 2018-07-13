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
 * Created by Riley on 7/13/2018.
 *
 * Main Spring JPA object.
 * Memo to me: Is there built in work for doing searching on lists or nah?
 */

@Entity
@Table(name = 'Business', schema = 'greenbookapi')
class Town extends Location{

    @Id
    @GeneratedValue
    Long id

    // Date it was first reported
    @CreatedDate
    @Column(name='first_report_date')
    Date firstReportDate

    // Date it was last reported
    @LastModifiedDate
    @Column(name='last_report_date')
    Date lastReportDate

    // City or county
    // City+State+Type combo must be unique
    @Column(name='city')
    String city
    @Column(name='state')
    String state
    // Town/County
    @Column(name='type')
    String type

    // How many ppl reported it?
    @Column(name='amt_reported')
    int amtReported = 1

    @Column(name='confidence')
    String confidenceTag = GreenBookConstants.UNVERIFIED

    @Column(name='offender1')
    String offender1

    @Column(name='offender2')
    String offender2

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