package marytts.language.it

import marytts.config.*
import org.testng.annotations.*

class ItalianConfigTest {

    ItalianConfig config

    @BeforeMethod
    void setup() {
        config = new ItalianConfig()
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
        assert config.properties.'locale' == 'it'
        assert config.properties.'modules.classes.list'.tokenize().containsAll(['marytts.language.it.JTokeniser', 'marytts.language.it.Preprocess', 'marytts.modules.JPhonemiser(it.)', 'marytts.modules.OpenNLPPosTagger(it,it.pos)', 'marytts.language.it.Prosody', 'marytts.language.it.Postlex'])
        assert config.properties.'featuremanager.classes.list'.tokenize().containsAll(['marytts.features.FeatureProcessorManager(it)'])
        assert config.properties.'it.allophoneset' == 'jar:/marytts/language/it/lexicon/allophones.it.xml'
        assert config.properties.'it.lexicon' == 'jar:/marytts/language/it/lexicon/it_lexicon.fst'
        assert config.properties.'it.lettertosound' == 'jar:/marytts/language/it/lexicon/it.lts'
        assert config.properties.'it.removeTrailingOneFromPhones' == 'false'
        assert config.properties.'it.partsofspeech.fst' == 'jar:/marytts/language/it/tagger/it_pos.fst'
        assert config.properties.'it.partsofspeech.punctuation' == ',.?!;'
        assert config.properties.'it.pos.model' == 'jar:/marytts/language/it/tagger/it-pos-maxent-151.g0_p0_m0.bin.model'
        assert config.properties.'it.pos.deterministic_symbols_tagdict' == 'jar:/marytts/language/it/tagger/deterministic_tagdict'
        assert config.properties.'it.pos.deterministic_symbols_tagdict.isCaseSensitive' == 'true'
        assert config.properties.'it.pos.punct.regex' == 'FB|FC|FF|FS'
        assert config.properties.'it.prosody.tobipredparams' == 'jar:/marytts/language/it/prosody/tobipredparams_italian.xml'
        assert config.properties.'it.prosody.accentPriorities' == 'jar:/marytts/language/it/prosody/POSAccentPriorities.it.properties'
        assert config.properties.'it.prosody.paragraphdeclination' == 'true'
        assert config.properties.'it.prosody.syllableaccents' == 'true'
    }
}
