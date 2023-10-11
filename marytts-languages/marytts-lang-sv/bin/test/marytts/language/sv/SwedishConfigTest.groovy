package marytts.language.sv

import marytts.config.*
import org.testng.annotations.*

class SwedishConfigTest {

    SwedishConfig config

    @BeforeMethod
    void setup() {
        config = new SwedishConfig()
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
        assert config.properties.'locale' == 'sv'
        assert config.properties.'modules.classes.list'.tokenize().containsAll(['marytts.modules.JPhonemiser(sv.)', 'marytts.modules.MinimalisticPosTagger(sv,sv.)'])
        assert config.properties.'featuremanager.classes.list'.tokenize().containsAll(['marytts.features.FeatureProcessorManager(sv)'])
        assert config.properties.'sv.allophoneset' == 'jar:/marytts/language/sv/lexicon/allophones.sv.xml'
        assert config.properties.'sv.lexicon' == 'jar:/marytts/language/sv/lexicon/sv_lexicon.fst'
        assert config.properties.'sv.lettertosound' == 'jar:/marytts/language/sv/lexicon/sv.lts'
        assert config.properties.'sv.userdict' == 'MARY_BASE/user-dictionaries/userdict-sv.txt'
        assert config.properties.'sv.partsofspeech.fst' == 'jar:/marytts/language/sv/tagger/sv_pos.fst'
        assert config.properties.'sv.partsofspeech.punctuation' == ',.?!;'
    }
}
