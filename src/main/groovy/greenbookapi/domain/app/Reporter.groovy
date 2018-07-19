package greenbookapi.domain.app

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

    protected Reporter() {}

    /* For web users*/
    Reporter(String id) {
        this.id = id
    }

}
