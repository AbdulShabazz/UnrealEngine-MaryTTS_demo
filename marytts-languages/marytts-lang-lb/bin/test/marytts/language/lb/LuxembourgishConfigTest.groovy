package marytts.language.lb

import marytts.config.*
import org.testng.annotations.*

class LuxembourgishConfigTest {

    LuxembourgishConfig config

    @BeforeMethod
    void setup() {
        config = new LuxembourgishConfig()
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
        assert config.properties.'locale' == 'lb'
        assert config.properties.'modules.classes.list'.tokenize().containsAll(['marytts.language.lb.LuxembourgishPreprocess', 'marytts.language.lb.EvenMoreMinimalisticPosTagger(lb)', 'marytts.language.lb.LuxembourgishPhonemiser'])
        assert config.properties.'featuremanager.classes.list'.tokenize().containsAll(['marytts.features.FeatureProcessorManager(lb)'])
        assert config.properties.'lb.allophoneset' == 'jar:/marytts/language/lb/lexicon/allophones.lb.xml'
        assert config.properties.'lb.lexicon' == 'jar:/marytts/language/lb/lexicon/lb_lexicon.fst'
        assert config.properties.'lb.lettertosound' == 'jar:/marytts/language/lb/lexicon/lb.lts'
        assert config.properties.'lb.userdict' == 'MARY_BASE/user-dictionaries/userdict-lb.txt'
        assert config.properties.'lb.pos.punct.regex' == '\\$,|\\$\\.'
    }
}
