package marytts.language.sv

import marytts.config.*

class SwedishConfig extends LanguageConfig {

    SwedishConfig() {
        super(SwedishConfig.class.getResourceAsStream('swedish.config'))
    }
}
