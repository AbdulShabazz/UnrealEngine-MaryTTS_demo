package marytts.language.lb

import marytts.config.*

class LuxembourgishConfig extends LanguageConfig {

    LuxembourgishConfig() {
        super(LuxembourgishConfig.class.getResourceAsStream('luxembourgish.config'))
    }
}
