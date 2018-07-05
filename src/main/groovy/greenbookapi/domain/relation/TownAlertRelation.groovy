package greenbookapi.domain.relation

import javax.persistence.Entity
import javax.persistence.Id

/**
 * Created by Riley on 7/4/2018.
 *
 * Class to manage relations for Town Alerts to be connected to
 * specific towns.
 */

@Entity
class TownAlertRelation {

    // Will be a town ID
    @Id
    long id

    // Must be an ID for a TOWN ALERT
    String townAlertId

    protected TownAlertRelation(){

    }

    protected TownAlertRelation (long id, String townAlertId) {
        this.id = id
        this.townAlertId = townAlertId
    }
}
