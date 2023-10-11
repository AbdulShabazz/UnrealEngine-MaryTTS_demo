package marytts.language.ru

import marytts.config.*
import org.testng.annotations.*

class RussianConfigTest {

    RussianConfig config

    @BeforeMethod
    void setup() {
        config = new RussianConfig()
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
        assert config.properties.'locale' == 'ru'
        assert config.properties.'modules.classes.list'.tokenize().containsAll(['marytts.language.ru.Tokenizer', 'marytts.modules.DummyTokens2Words', 'marytts.modules.JPhonemiser(ru.)', 'marytts.modules.ProsodyGeneric', 'marytts.modules.MinimalisticPosTagger(ru,ru)', 'marytts.modules.CARTDurationModeller(ru,ru.duration.,marytts.features.FeatureProcessorManager(ru))', 'marytts.modules.CARTF0Modeller(ru,ru.f0.,marytts.features.FeatureProcessorManager(ru))'])
        assert config.properties.'featuremanager.classes.list'.tokenize().containsAll(['marytts.features.FeatureProcessorManager(ru)'])
        assert config.properties.'ru.allophoneset' == 'jar:/marytts/language/ru/lexicon/allophones.ru.xml'
        assert config.properties.'ru.userdict' == 'MARY_BASE/user-dictionaries/userdict-ru.txt'
        assert config.properties.'ru.lexicon' == 'jar:/marytts/language/ru/lexicon/ru_lexicon.fst'
        assert config.properties.'ru.lettertosound' == 'jar:/marytts/language/ru/lexicon/ru.lts'
        assert config.properties.'ru.partsofspeech.fst' == 'jar:/marytts/language/ru/tagger/ru_pos.fst'
        assert config.properties.'ru.partsofspeech.punctuation' == ',.?!;'
    }
}
