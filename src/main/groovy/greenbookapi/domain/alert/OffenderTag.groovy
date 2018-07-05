package greenbookapi.domain.alert

import greenbookapi.domain.relation.OffenderLocationRelation

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

/**
 * Created by Riley on 7/4/2018.
 *
 * Class to manage relations for Offender tags to be attached
 * to offending businesses.
 */

@Entity
class OffenderTag {

    @Id
    String name

    protected OffenderTag() {

    }

    protected OffenderTag(String name) {
        // Do a name check here.
        this.name = name
    }

    // Move to a util static class
    private void createNewRelation(long locationId) {
        OffenderLocationRelation olr = new OffenderLocationRelation()

    }
}
