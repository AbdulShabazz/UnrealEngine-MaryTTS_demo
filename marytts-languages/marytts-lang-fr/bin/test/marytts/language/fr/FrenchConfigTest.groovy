package marytts.language.fr

import marytts.config.*
import org.testng.annotations.*

class FrenchConfigTest {

    FrenchConfig config

    @BeforeMethod
    void setup() {
        config = new FrenchConfig()
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
        assert config.properties.'locale' == 'fr'
        assert config.properties.'modules.classes.list'.tokenize().containsAll(['marytts.language.fr.Phonemiser', 'marytts.language.fr.Preprocess', 'marytts.modules.MinimalisticPosTagger(fr,fr.)'])
        assert config.properties.'featuremanager.classes.list'.tokenize().containsAll(['marytts.features.FeatureProcessorManager(fr)'])
        assert config.properties.'fr.allophoneset' == 'jar:/marytts/language/fr/lexicon/allophones.fr.xml'
        assert config.properties.'fr.lexicon' == 'jar:/marytts/language/fr/lexicon/fr_lexicon.fst'
        assert config.properties.'fr.lettertosound' == 'jar:/marytts/language/fr/lexicon/fr.lts'
        assert config.properties.'fr.partsofspeech.fst' == 'jar:/marytts/language/fr/tagger/fr_pos.fst'
        assert config.properties.'fr.partsofspeech.punctuation' == ',.?!;'
    }
}
