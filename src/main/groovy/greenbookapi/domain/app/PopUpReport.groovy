package greenbookapi.domain.app

import greenbookapi.common.PopConstants
import greenbookapi.util.FormatUtil
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'location', schema = 'nofreezepops')
class PopUpReport {

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

    @Column(name = 'city')
    String city

    @Column(name = 'state')
    String state

    //TODO: Make time from date
    @Column(name = 'time')
    String time

    @Column(name = 'street1')
    String street1Name

    //TODO: Limit this string to its possible options
    //String street1Ending

    @Column(name = 'street2')
    String street2Name

    //String street2Ending

    // Assigned at creation.
    // TODO: Make it possible to assign more than one reporter.
    @Column(name = 'reporter_id')
    String reporterId

    // Will just use one tag for now, will have lists later
    @Column(name = 'tag')
    String tag = PopConstants.UNVERIFIED

    @Column(name='amt_reported')
    int amtReported = 0

    // For Spring JPA to use.
    protected PopUpReport(){
    }

    // For testing purposes.
    PopUpReport(long id, Date date, String city, String state, String time,
                String str1n, String str2n, String repId){

        this.id = id
        this.firstReportDate = date
        this.lastReportDate = date
        this.city = city
        this.state = state
        this.time = time
        this.street1Name = FormatUtil.stripSpecialCharacters(str1n)
        this.street2Name = FormatUtil.stripSpecialCharacters(str2n)
        this.reporterId = repId
        tag = PopConstants.UNVERIFIED
        amtReported = 1
    }
}
