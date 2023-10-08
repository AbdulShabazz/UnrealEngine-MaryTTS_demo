package marytts.language.ru

import marytts.config.*

class RussianConfig extends LanguageConfig {

    RussianConfig() {
        super(RussianConfig.class.getResourceAsStream('russian.config'))
    }
}
