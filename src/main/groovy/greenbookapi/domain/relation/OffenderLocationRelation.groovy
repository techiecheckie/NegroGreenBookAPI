package greenbookapi.domain.relation

import javax.persistence.Entity
import javax.persistence.Id

/**
 * Created by Riley on 7/4/2018.
 *
 * Keeps track of the many to many relationship between Offenders and Locations.
 */

@Entity
class OffenderLocationRelation {

    // Will be a business ID
    @Id
    long id

    // Must be one of the Offender IDs
    String offenderId

    protected OffenderLocationRelation(){

    }

    protected OffenderLocationRelation (long id, String offenderId) {
        this.id = id
        this.offenderId = offenderId
    }
}
