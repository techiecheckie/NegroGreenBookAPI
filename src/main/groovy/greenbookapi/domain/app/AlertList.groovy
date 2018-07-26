package greenbookapi.domain.app

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName('pop_reports')
class AlertList extends ArrayList<PopUpReport>{}
