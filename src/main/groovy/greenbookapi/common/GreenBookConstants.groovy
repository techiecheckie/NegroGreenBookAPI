package greenbookapi.common


/**
 * Created by Riley on 7/3/2018.
 *
 * Constants used for various object fields.
 */

final class GreenBookConstants {
    /* Location Types */
    static final String BUSINESS = 'Business'
        // Note that Town and County are still TOWN objects.
    static final String TOWN = 'Town'
    static final String COUNTY = 'County'

    /* Alert Types for Alerts */
    static final String CHECKPOINT = 'ICE Checkpoint'
    static final String POLICENOW = 'Police Activity'


    /* Item Types for Towns */
    static final String INCIDENTS = 'High Amount of Incidents'
    static final String NOPOC = 'Low PoC Population'
    static final String GOPVOTERS = 'High GOP Population'
    static final String SUNDOWN = 'Sundown Town'
    static final String OTHERTOWN = 'Other Town'

    /* Item types for Businesses */
        // Museums, parks, music halls, etc.
    static final String ATTRACTION = 'Attraction'
    static final String MEDFACILITY = 'Medical Facility'
    static final String EDFACILITY = 'Educational Facility'
        // Specific hotels, inns, hostels, etc.
    static final String LODGING = 'Lodging'
        // Anywhere whose primary focus is to serve food/drink, including bars.
    static final String RESTAURANT = 'Restaurant/Bar'
    static final String GAS = 'Convenience/Gas'
    static final String OTHERBUSINESS = 'Other Business'

    /* Offenders -- Reasons they suck */
    static final String RACISM = 'General Racism'
    static final String ANTIBLACKNESS = 'Anti-Blackness'
    static final String HOMOPHOBIA = 'Homophobia'
    static final String TRANSPHOBIA = 'General Transphobia'
    static final String TRANSMISOGYNY = 'Transmisogyny'
    static final String MIABLEISM = 'Ableism: Mental'
    static final String PHYABLEISM = 'Ableism: Physical'
    static final String MISOSGYNY = 'General Misogyny'
    static final String MISOGYNOIR = 'Misogynoir'
    static final String FATPHOBIA = 'Fatphobia'
    static final String ISLAMOPHOBIA = 'Islamophobia'
    static final String CLASSISM = 'Classism'
    static final String AGEISM = 'Ageism'
    static final String NAZI = 'Nazi Presence'
    static final String KKK = 'KKK Presence'
    static final String POLICE = 'High Police Presence'
        // Includes alt-right fuckers
    static final String YTSUPREMACISTS = 'High white Supremacist Presence'

    /* Confidence tag types */
    static final String VERIFIED = 'Verified'
    static final String UNVERIFIED = 'Unverified'
    static final String SUSPICIOUS = 'Suspicious'

    /* Street Endings */
    static final String STR = 'str'
    static final String RD = 'rd'
    static final String CIR = 'circle'
    static final String BLVD = 'blvd'
    static final String AVE = 'ave'
    static final String PL = 'pl'
    static final String LN = 'ln'
    static final String DR = 'dr'



}
