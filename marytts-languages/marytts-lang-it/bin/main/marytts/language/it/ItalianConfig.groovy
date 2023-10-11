package marytts.language.it

import marytts.config.*

class ItalianConfig extends LanguageConfig {

    ItalianConfig() {
        super(ItalianConfig.class.getResourceAsStream('italian.config'))
    }
}
