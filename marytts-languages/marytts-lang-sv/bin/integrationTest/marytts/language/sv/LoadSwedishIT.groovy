package marytts.language.sv

import marytts.server.MaryProperties
import marytts.util.MaryRuntimeUtils

import org.testng.annotations.*

class LoadSwedishIT {

    @BeforeMethod
    void setup() {
        MaryRuntimeUtils.ensureMaryStarted()
    }

    @DataProvider
    Object[][] properties() {
        [
            ['modules.classes.list', ['marytts.modules.JPhonemiser(sv.)', 'marytts.modules.MinimalisticPosTagger(sv,sv.)']],
            ['featuremanager.classes.list', ['marytts.features.FeatureProcessorManager(sv)']],
            ['sv.allophoneset', 'jar:/marytts/language/sv/lexicon/allophones.sv.xml'],
            ['sv.lexicon', 'jar:/marytts/language/sv/lexicon/sv_lexicon.fst'],
            ['sv.lettertosound', 'jar:/marytts/language/sv/lexicon/sv.lts'],
            ['sv.userdict', 'MARY_BASE/user-dictionaries/userdict-sv.txt'],
            ['sv.partsofspeech.fst', 'jar:/marytts/language/sv/tagger/sv_pos.fst'],
            ['sv.partsofspeech.punctuation', ',.?!;']
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
