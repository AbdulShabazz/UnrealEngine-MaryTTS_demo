package marytts.language.tr

import marytts.config.*

class TurkishConfig extends LanguageConfig {

    TurkishConfig() {
        super(TurkishConfig.class.getResourceAsStream('turkish.config'))
    }
}
