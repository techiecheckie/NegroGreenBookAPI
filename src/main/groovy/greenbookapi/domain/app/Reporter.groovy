package greenbookapi.domain.app

import greenbookapi.common.GreenBookConstants
import org.springframework.data.annotation.CreatedDate

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by Riley on 7/4/2018.
 *
 * Class to manage relations for Offender tags to be attached
 * to offending businesses.
 */

@Entity
@Table(name = 'reporter', schema = 'greenbookapi')
class Reporter {

    @Id
    @Column(name='id')
    String id

    @CreatedDate
    @Column(name='created_date')
    Date dateCreated

    @Column(name='phone_country_code')
    String phoneCountryCode

    @Column(name='city')
    String city

    @Column(name='state')
    String state

    @Column(name='zip_code')
    String zipCode

    @Column(name='confidence')
    String tag = GreenBookConstants.UNVERIFIED

    protected Reporter() {}

    protected Reporter(String phoneNum, Date date, String pcc, String city, String state, String zip) {
        this.id = phoneNum
        this.dateCreated = date
        this.phoneCountryCode = pcc
        this.city = city
        this.state = state
        this.zipCode = zip
    }
}
