package marytts.language.en

import marytts.server.MaryProperties
import marytts.util.MaryRuntimeUtils

import org.testng.annotations.*

class LoadEnglishIT {

    @BeforeMethod
    void setup() {
        MaryRuntimeUtils.ensureMaryStarted()
    }

    @DataProvider
    Object[][] properties() {
        [
            ['modules.classes.list', ['marytts.language.en.JTokeniser', 'marytts.language.en.Preprocess', 'marytts.modules.JPhonemiser(en_US.)', 'marytts.modules.JPhonemiser(en_GB.)', 'marytts.language.en.Prosody', 'marytts.modules.SimplePhoneme2AP(en_US)', 'marytts.language.en.PronunciationModel', 'marytts.modules.OpenNLPPosTagger(en,en.pos)']],
            ['featuremanager.classes.list', ['marytts.features.FeatureProcessorManager(en_US)', 'marytts.features.FeatureProcessorManager(en_GB)']],
            ['en_US.allophoneset', 'jar:/marytts/language/en_US/lexicon/allophones.en_US.xml'],
            ['en_US.userdict', 'MARY_BASE/user-dictionaries/userdict-en_US.txt'],
            ['en_US.lexicon', 'jar:/marytts/language/en_US/lexicon/en_US_lexicon.fst'],
            ['en_US.lettertosound', 'jar:/marytts/language/en_US/lexicon/en_US.lts'],
            ['en_GB.allophoneset', 'jar:/marytts/language/en_GB/lexicon/allophones.en_GB.xml'],
            ['en_GB.userdict', 'MARY_BASE/user-dictionaries/userdict-en_GB.txt'],
            ['en_GB.lexicon', 'jar:/marytts/language/en_US/lexicon/en_US_lexicon.fst'],
            ['en_GB.lettertosound', 'jar:/marytts/language/en_US/lexicon/en_US.lts'],
            ['en.pos.model', 'jar:/marytts/language/en/tagger/en-pos-maxent-1.5.bin'],
            ['en.pos.punct.regex', ',|\\.|:'],
            ['en.prosody.paragraphdeclination', 'true'],
            ['en.prosody.tobipredparams', 'jar:/marytts/language/en/prosody/tobipredparams_english.xml'],
            ['en.prosody.accentPriorities', 'jar:/marytts/language/en/prosody/POSAccentPriorities.en.properties'],
            ['en.prosody.syllableaccents', 'true']
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
