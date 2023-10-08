package marytts.language.en

import marytts.config.*
import org.testng.annotations.*

class EnglishConfigTest {

    EnglishConfig config

    @BeforeMethod
    void setup() {
        config = new EnglishConfig()
    }

    @Test
    public void isNotMainConfig() {
        assert config.isMainConfig() == false
    }

    @Test
    public void testConfigBaseClass() {
        assert config instanceof LanguageConfig
    }

    @Test
    public void canGetProperties() {
        assert config.properties.'locale' == 'en_US en_GB'
        assert config.properties.'modules.classes.list'.tokenize().containsAll(['marytts.language.en.JTokeniser', 'marytts.language.en.Preprocess', 'marytts.modules.JPhonemiser(en_US.)', 'marytts.modules.JPhonemiser(en_GB.)', 'marytts.language.en.Prosody', 'marytts.modules.SimplePhoneme2AP(en_US)', 'marytts.language.en.PronunciationModel', 'marytts.modules.OpenNLPPosTagger(en,en.pos)'])
        assert config.properties.'featuremanager.classes.list'.tokenize().containsAll(['marytts.features.FeatureProcessorManager(en_US)', 'marytts.features.FeatureProcessorManager(en_GB)'])
        assert config.properties.'en_US.allophoneset' == 'jar:/marytts/language/en_US/lexicon/allophones.en_US.xml'
        assert config.properties.'en_US.userdict' == 'MARY_BASE/user-dictionaries/userdict-en_US.txt'
        assert config.properties.'en_US.lexicon' == 'jar:/marytts/language/en_US/lexicon/en_US_lexicon.fst'
        assert config.properties.'en_US.lettertosound' == 'jar:/marytts/language/en_US/lexicon/en_US.lts'
        assert config.properties.'en_GB.allophoneset' == 'jar:/marytts/language/en_GB/lexicon/allophones.en_GB.xml'
        assert config.properties.'en_GB.userdict' == 'MARY_BASE/user-dictionaries/userdict-en_GB.txt'
        assert config.properties.'en_GB.lexicon' == 'jar:/marytts/language/en_US/lexicon/en_US_lexicon.fst'
        assert config.properties.'en_GB.lettertosound' == 'jar:/marytts/language/en_US/lexicon/en_US.lts'
        assert config.properties.'en.pos.model' == 'jar:/marytts/language/en/tagger/en-pos-maxent-1.5.bin'
        assert config.properties.'en.pos.punct.regex' == ',|\\.|:'
        assert config.properties.'en.prosody.paragraphdeclination' == 'true'
        assert config.properties.'en.prosody.tobipredparams' == 'jar:/marytts/language/en/prosody/tobipredparams_english.xml'
        assert config.properties.'en.prosody.accentPriorities' == 'jar:/marytts/language/en/prosody/POSAccentPriorities.en.properties'
        assert config.properties.'en.prosody.syllableaccents' == 'true'
    }
}
