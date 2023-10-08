package marytts.language.de

import marytts.config.*

class GermanConfig extends LanguageConfig {

    GermanConfig() {
        super(GermanConfig.class.getResourceAsStream('german.config'))
    }
}
