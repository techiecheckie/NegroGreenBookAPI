package greenbookapi.domain.app

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import greenbookapi.common.GreenBookConstants

import greenbookapi.util.FormatUtil
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.lang.NonNull
import org.springframework.lang.Nullable

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

@JsonPropertyOrder(['id', 'lastReportDate', 'time', 'amtReported', 'alertType'])
@Entity
@Table(name = 'alert', schema = 'nofreezepops')
class PopUpReport {

    @Id
    @GeneratedValue
    String id

    // Date it was first reported
    @JsonIgnore
    @NonNull
    @CreatedDate
    @Column(name = 'first_report_date')
    String firstReportDate

    // Date it was last reported
    @NonNull
    @LastModifiedDate
    @Column(name = 'last_report_date')
    String lastReportDate

    @NonNull
    @Column(name = 'alert_type')
    String alertType

    @NonNull
    @Column(name = 'city')
    String city

    @NonNull
    @Column(name = 'state')
    String state

    @JsonProperty('reportedTime')
    @NonNull
    @Column(name = 'reported_time')
    String time

    //Update code to handle time zone.
    @JsonIgnore
    @JsonProperty('locationTimeZone')
    @Nullable
    @Column(name = 'timezone')
    String timeZone

    @NonNull
    @Column(name = 'street_1')
    String street1Name

    @NonNull
    @Column(name = 'street_2')
    String street2Name

    // Assigned at creation.
    // TODO: Make it possible to assign more than one reporter.
    @JsonIgnore
    @NonNull
    @Column(name = 'reporter_id')
    String reporter

    @JsonIgnore
    @NonNull
    @Column(name='offender_1')
    String offender1

    @JsonIgnore
    @Nullable
    @Column(name='offender_2')
    String offender2

    @JsonIgnore
    @Nullable
    @Column(name='offender_3')
    String offender3

    // Will just use one tag for now, will have lists later
    @NonNull
    @Column(name = 'confidence_tag')
    String tag = GreenBookConstants.UNVERIFIED

    @NonNull
    @Column(name='amt_reported')
    int amtReported = 1

    // For Spring JPA to use.
    protected PopUpReport(){
    }

    @JsonGetter('offenders')
    List<String> getOffenders(){
        List<String> list = new ArrayList<>()
        list.add(offender1)
        if (offender2) {
            list.add(offender2)
            if (offender3){
                list.add(offender3)
            }
        }
        list
    }

    @JsonGetter('reporter')
    Reporter getReporterForJsonFormat(){
        Reporter rep = new Reporter(reporter)
        rep
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
