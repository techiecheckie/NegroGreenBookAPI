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

    // ID is either a phone number or an email.
    @Id
    @Column(name='id')
    String id

    @Column(name='hash_password')
    String hashPass

    @CreatedDate
    @Column(name='created_date')
    Date dateCreated

    //TODO: Change country code in JSONs to int.
    @Column(name='phone_country_code')
    int phoneCountryCode

    @Column(name='city')
    String city

    @Column(name='state')
    String state

    @Column(name='country')
    String country

    @Column(name='confidence')
    String tag = GreenBookConstants.UNVERIFIED

    //TODO: Make it possible to assign more than one report to a reporter.

    protected Reporter() {}

    /* For web users*/
    Reporter(String email, String hashPass, Date date) {
        this.id = email
        this.hashPass = hashPass
        this.dateCreated = date
    }

    Reporter(String email, String hashPass, Date date, String city, String state) {
        this.id = email
        this.hashPass = hashPass
        this.dateCreated = date
        this.city = city
        this.state = state
        this.country = 'US'
    }

    Reporter(String email, String hashPass, Date date, String country) {
        this.id = email
        this.hashPass = hashPass
        this.dateCreated = date
        this.country = country
    }

    /*For mobile users*/
    Reporter(String phoneNum, Date date, int pcc, String city, String state) {
        this.id = phoneNum
        this.dateCreated = date
        this.phoneCountryCode = pcc
        this.city = city
        this.state = state
        this.country = 'US'
    }

    Reporter(String phoneNum, Date date, int pcc, String country) {
        this.id = phoneNum
        this.dateCreated = date
        this.phoneCountryCode = pcc
        this.country = country
    }
}
