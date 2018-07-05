package greenbookapi.domain.relation

import javax.persistence.Entity
import javax.persistence.Id


/**
 * Created by Riley on 7/4/2018.
 *
 * Class to manage relations for Reporters and Locations to be connected.
 */

@Entity
class ReporterRelation {

    @Id
    // Will be a Reporter ID
    long id

    // Must be an ID for a LOCATION
    long locationId
}
