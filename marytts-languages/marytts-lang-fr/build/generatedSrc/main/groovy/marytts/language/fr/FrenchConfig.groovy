package marytts.language.fr

import marytts.config.*

class FrenchConfig extends LanguageConfig {

    FrenchConfig() {
        super(FrenchConfig.class.getResourceAsStream('french.config'))
    }
}
