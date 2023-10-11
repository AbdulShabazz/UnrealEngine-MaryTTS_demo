package marytts.voice.CmuSltHsmm

import marytts.config.*

class CmuSltHsmmConfig extends VoiceConfig {

    CmuSltHsmmConfig() {
        super(CmuSltHsmmConfig.class.getResourceAsStream('cmuslthsmm.config'))
    }
}
