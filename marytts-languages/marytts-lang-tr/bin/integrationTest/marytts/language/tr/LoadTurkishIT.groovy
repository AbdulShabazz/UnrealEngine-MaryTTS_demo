package marytts.language.tr

import marytts.server.MaryProperties
import marytts.util.MaryRuntimeUtils

import org.testng.annotations.*

class LoadTurkishIT {

    @BeforeMethod
    void setup() {
        MaryRuntimeUtils.ensureMaryStarted()
    }

    @DataProvider
    Object[][] properties() {
        [
            ['modules.classes.list', ['marytts.modules.MinimalisticPosTagger(tr,tr.)', 'marytts.modules.CARTDurationModeller(tr,tr.duration.,marytts.features.FeatureProcessorManager(tr))', 'marytts.modules.CARTF0Modeller(tr,tr.f0.,marytts.features.FeatureProcessorManager(tr))']],
            ['featuremanager.classes.list', ['marytts.features.FeatureProcessorManager(tr)']],
            ['tr.allophoneset', 'jar:/marytts/language/tr/lexicon/allophones.tr.xml'],
            ['tr.lexicon', 'jar:/marytts/language/tr/lexicon/tr_lexicon.fst'],
            ['tr.lettertosound', 'jar:/marytts/language/tr/lexicon/tr.lts'],
            ['tr.partsofspeech.fst', 'jar:/marytts/language/tr/tagger/tr_pos.fst'],
            ['tr.partsofspeech.punctuation', ',.?!;']
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
