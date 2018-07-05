package greenbookapi.domain.alert

import greenbookapi.domain.relation.OffenderLocationRelation
import greenbookapi.domain.relation.TownAlertRelation

import javax.persistence.Entity
import javax.persistence.Id

/**
 * Created by Riley on 7/4/2018.
 *
 * Class to manage relations for Town Alerts to be connected to
 * specific towns.
 */

@Entity
class TownAlert {

    @Id
    String name

    protected TownAlert() {
    }

    protected TownAlert(String name) {
        // Do a name check here.
        this.name = name
    }
}
