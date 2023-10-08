package marytts.language.tr

import marytts.config.*
import org.testng.annotations.*

class TurkishConfigTest {

    TurkishConfig config

    @BeforeMethod
    void setup() {
        config = new TurkishConfig()
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
        assert config.properties.'locale' == 'tr'
        assert config.properties.'modules.classes.list'.tokenize().containsAll(['marytts.modules.MinimalisticPosTagger(tr,tr.)', 'marytts.modules.CARTDurationModeller(tr,tr.duration.,marytts.features.FeatureProcessorManager(tr))', 'marytts.modules.CARTF0Modeller(tr,tr.f0.,marytts.features.FeatureProcessorManager(tr))'])
        assert config.properties.'featuremanager.classes.list'.tokenize().containsAll(['marytts.features.FeatureProcessorManager(tr)'])
        assert config.properties.'tr.allophoneset' == 'jar:/marytts/language/tr/lexicon/allophones.tr.xml'
        assert config.properties.'tr.lexicon' == 'jar:/marytts/language/tr/lexicon/tr_lexicon.fst'
        assert config.properties.'tr.lettertosound' == 'jar:/marytts/language/tr/lexicon/tr.lts'
        assert config.properties.'tr.partsofspeech.fst' == 'jar:/marytts/language/tr/tagger/tr_pos.fst'
        assert config.properties.'tr.partsofspeech.punctuation' == ',.?!;'
    }
}
