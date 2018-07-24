package greenbookapi.domain.app

import greenbookapi.common.GreenBookConstants

import greenbookapi.util.FormatUtil
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by Riley on 7/3/2018.
 *
 * For short time alerts on checkpoints or high police presence.
 */

@Entity
@Table(name = 'alert', schema = 'nofreezepops')
class PopUpReport {

    @Id
    @GeneratedValue
    String id

    // Date it was first reported
    @CreatedDate
    @Column(name = 'first_report_date')
    String firstReportDate

    // Date it was last reported
    @LastModifiedDate
    @Column(name = 'last_report_date')
    String lastReportDate

    @Column(name = 'alert_type')
    String alertType

    @Column(name = 'city')
    String city

    @Column(name = 'state')
    String state

    //TODO: Make time from date
    @Column(name = 'reported_time')
    String time

    @Column(name = 'street_1')
    String street1Name

    @Column(name = 'street_2')
    String street2Name

    // Assigned at creation.
    // TODO: Make it possible to assign more than one reporter.
    @Column(name = 'reporter_id')
    String reporter

    // Will just use one tag for now, will have lists later
    @Column(name = 'confidence_tag')
    String tag = GreenBookConstants.UNVERIFIED

    @Column(name='amt_reported')
    int amtReported = 1

    // For Spring JPA to use.
    protected PopUpReport(){
    }

    // For testing purposes.
    PopUpReport(String date, String city, String state, String time, String alert,
                String str1n, String str2n, String repId){

        this.firstReportDate = date
        this.lastReportDate = date
        this.city = city
        this.state = state
        this.time = time
        this.alertType = alert
        this.street1Name = FormatUtil.stripSpecialCharacters(str1n)
        this.street2Name = FormatUtil.stripSpecialCharacters(str2n)
        this.reporter = repId
        tag = GreenBookConstants.UNVERIFIED
    }
}
