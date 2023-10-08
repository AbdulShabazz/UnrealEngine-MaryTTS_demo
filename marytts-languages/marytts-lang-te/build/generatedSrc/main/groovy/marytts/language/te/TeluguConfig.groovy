package marytts.language.te

import marytts.config.*

class TeluguConfig extends LanguageConfig {

    TeluguConfig() {
        super(TeluguConfig.class.getResourceAsStream('telugu.config'))
    }
}
