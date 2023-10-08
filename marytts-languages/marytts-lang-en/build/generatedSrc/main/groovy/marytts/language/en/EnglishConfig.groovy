package marytts.language.en

import marytts.config.*

class EnglishConfig extends LanguageConfig {

    EnglishConfig() {
        super(EnglishConfig.class.getResourceAsStream('english.config'))
    }
}
