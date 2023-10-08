package marytts.language.lb

import marytts.server.MaryProperties
import marytts.util.MaryRuntimeUtils

import org.testng.annotations.*

class LoadLuxembourgishIT {

    @BeforeMethod
    void setup() {
        MaryRuntimeUtils.ensureMaryStarted()
    }

    @DataProvider
    Object[][] properties() {
        [
            ['modules.classes.list', ['marytts.language.lb.LuxembourgishPreprocess', 'marytts.language.lb.EvenMoreMinimalisticPosTagger(lb)', 'marytts.language.lb.LuxembourgishPhonemiser']],
            ['featuremanager.classes.list', ['marytts.features.FeatureProcessorManager(lb)']],
            ['lb.allophoneset', 'jar:/marytts/language/lb/lexicon/allophones.lb.xml'],
            ['lb.lexicon', 'jar:/marytts/language/lb/lexicon/lb_lexicon.fst'],
            ['lb.lettertosound', 'jar:/marytts/language/lb/lexicon/lb.lts'],
            ['lb.userdict', 'MARY_BASE/user-dictionaries/userdict-lb.txt'],
            ['lb.pos.punct.regex', '\\$,|\\$\\.']
        ]
    }

    @Test(dataProvider = 'properties')
    public void canGetProperty(name, expected) {
        def actual
        switch (name) {
            case ~/.+\.list$/:
                actual = MaryProperties.getList(name)
                assert actual.containsAll(expected)
                break
            default:
                actual = MaryProperties.getProperty(name)
                assert expected == actual
                break
        }
        if ("$expected".startsWith('jar:')) {
            assert MaryProperties.getStream(name)
        }
    }
}
