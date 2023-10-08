package marytts.language.te

import marytts.server.MaryProperties
import marytts.util.MaryRuntimeUtils

import org.testng.annotations.*

class LoadTeluguIT {

    @BeforeMethod
    void setup() {
        MaryRuntimeUtils.ensureMaryStarted()
    }

    @DataProvider
    Object[][] properties() {
        [
            ['modules.classes.list', ['marytts.language.te.JTokeniser', 'marytts.modules.DummyTokens2Words', 'marytts.language.te.JPhonemiser(te.)', 'marytts.modules.ProsodyGeneric', 'marytts.modules.MinimalisticPosTagger(te,te)']],
            ['featuremanager.classes.list', ['marytts.features.FeatureProcessorManager(te)']],
            ['te.allophoneset', 'jar:/marytts/language/te/lexicon/allophones.te.xml'],
            ['te.userdict', 'MARY_BASE/user-dictionaries/userdict-te.txt'],
            ['te.utf8toit3map', 'jar:/marytts/language/te/lexicon/UTF8toIT3.te.list'],
            ['te.partsofspeech.fst', 'jar:/marytts/language/te/tagger/te_pos.fst']
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
