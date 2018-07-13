package greenbookapi.common


/**
 * Created by Riley on 7/3/2018.
 *
 * Constants used for various object fields.
 */

class GreenBookConstants {

    /* Location Primary Type */
    //static final enum BusinessType {BUSINESS, TOWN, ATTRACTION, MEDFACILITY}

        // Any type of business.
    static final String BUSINESS = 'Business'
        // An entire town/city/municipality.
    static final String TOWN = 'Town'
        // Museums, parks, music halls, etc.
    static final String ATTRACTION = 'Attraction'
        // Medical Establishments
    static final String MEDFACILITY = 'Medical Facility'

    /* Location Secondary Types For Businesses */
        // Specific hotels, inns, hostels, etc.
    static final String LODGING = 'Lodging'
        // Anywhere whose primary focus is to serve food/drink, including bars.
    static final String FOOD = 'Food/Drink'
        // Convenience/Gas
    static final String GAS = 'Convenience/Gas'
        // A business that doesn't do any of the above.
    static final String OTHERBUSINESS = 'Other Business'

    /* Offenders -- Reasons they suck */
    static final String RACISM = 'General Racism'
    static final String ANTIBLACKNESS = 'Anti-Blackness'
    static final String HOMOPHOBIA = 'Homophobia'
    static final String TRANSPHOBIA = 'General Transphobia'
    static final String TRANSMISOGYNY = 'Transmisogyny'
    static final String MIABLEISM = 'Ableism: Mental/Neurological Disabilities'
    static final String PHYABLEISM = 'Ableism: Physical Disabilities'
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
    static final String YTSUPREMACISTS = 'High White Supremacist Presence'

    /* Town Secondary Types */
    static final String ARRESTS = 'High Instances of PoC Arrests'
    static final String NOPOC = 'Low PoC Population'
    static final String GOPVOTERS = 'High GOP Population'
    static final String SUNDOWN = 'Sundown Town'

    /* Confidence tag types */
    static final String VERIFIED = 'Verified'
    static final String UNVERIFIED = 'Unverified'
    static final String SUSPICIOUS = 'Suspicious'




}
