package marytts.language.fr

import marytts.server.MaryProperties
import marytts.util.MaryRuntimeUtils

import org.testng.annotations.*

class LoadFrenchIT {

    @BeforeMethod
    void setup() {
        MaryRuntimeUtils.ensureMaryStarted()
    }

    @DataProvider
    Object[][] properties() {
        [
            ['modules.classes.list', ['marytts.language.fr.Phonemiser', 'marytts.language.fr.Preprocess', 'marytts.modules.MinimalisticPosTagger(fr,fr.)']],
            ['featuremanager.classes.list', ['marytts.features.FeatureProcessorManager(fr)']],
            ['fr.allophoneset', 'jar:/marytts/language/fr/lexicon/allophones.fr.xml'],
            ['fr.lexicon', 'jar:/marytts/language/fr/lexicon/fr_lexicon.fst'],
            ['fr.lettertosound', 'jar:/marytts/language/fr/lexicon/fr.lts'],
            ['fr.partsofspeech.fst', 'jar:/marytts/language/fr/tagger/fr_pos.fst'],
            ['fr.partsofspeech.punctuation', ',.?!;']
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
