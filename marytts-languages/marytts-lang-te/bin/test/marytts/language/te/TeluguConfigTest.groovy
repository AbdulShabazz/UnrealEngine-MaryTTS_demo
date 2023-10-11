package marytts.language.te

import marytts.config.*
import org.testng.annotations.*

class TeluguConfigTest {

    TeluguConfig config

    @BeforeMethod
    void setup() {
        config = new TeluguConfig()
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
        assert config.properties.'locale' == 'te'
        assert config.properties.'modules.classes.list'.tokenize().containsAll(['marytts.language.te.JTokeniser', 'marytts.modules.DummyTokens2Words', 'marytts.language.te.JPhonemiser(te.)', 'marytts.modules.ProsodyGeneric', 'marytts.modules.MinimalisticPosTagger(te,te)'])
        assert config.properties.'featuremanager.classes.list'.tokenize().containsAll(['marytts.features.FeatureProcessorManager(te)'])
        assert config.properties.'te.allophoneset' == 'jar:/marytts/language/te/lexicon/allophones.te.xml'
        assert config.properties.'te.userdict' == 'MARY_BASE/user-dictionaries/userdict-te.txt'
        assert config.properties.'te.utf8toit3map' == 'jar:/marytts/language/te/lexicon/UTF8toIT3.te.list'
        assert config.properties.'te.partsofspeech.fst' == 'jar:/marytts/language/te/tagger/te_pos.fst'
    }
}
