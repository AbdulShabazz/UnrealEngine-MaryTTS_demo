package marytts.language.ru

import marytts.server.MaryProperties
import marytts.util.MaryRuntimeUtils

import org.testng.annotations.*

class LoadRussianIT {

    @BeforeMethod
    void setup() {
        MaryRuntimeUtils.ensureMaryStarted()
    }

    @DataProvider
    Object[][] properties() {
        [
            ['modules.classes.list', ['marytts.language.ru.Tokenizer', 'marytts.modules.DummyTokens2Words', 'marytts.modules.JPhonemiser(ru.)', 'marytts.modules.ProsodyGeneric', 'marytts.modules.MinimalisticPosTagger(ru,ru)', 'marytts.modules.CARTDurationModeller(ru,ru.duration.,marytts.features.FeatureProcessorManager(ru))', 'marytts.modules.CARTF0Modeller(ru,ru.f0.,marytts.features.FeatureProcessorManager(ru))']],
            ['featuremanager.classes.list', ['marytts.features.FeatureProcessorManager(ru)']],
            ['ru.allophoneset', 'jar:/marytts/language/ru/lexicon/allophones.ru.xml'],
            ['ru.userdict', 'MARY_BASE/user-dictionaries/userdict-ru.txt'],
            ['ru.lexicon', 'jar:/marytts/language/ru/lexicon/ru_lexicon.fst'],
            ['ru.lettertosound', 'jar:/marytts/language/ru/lexicon/ru.lts'],
            ['ru.partsofspeech.fst', 'jar:/marytts/language/ru/tagger/ru_pos.fst'],
            ['ru.partsofspeech.punctuation', ',.?!;']
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
