package marytts.language.it

import marytts.server.MaryProperties
import marytts.util.MaryRuntimeUtils

import org.testng.annotations.*

class LoadItalianIT {

    @BeforeMethod
    void setup() {
        MaryRuntimeUtils.ensureMaryStarted()
    }

    @DataProvider
    Object[][] properties() {
        [
            ['modules.classes.list', ['marytts.language.it.JTokeniser', 'marytts.language.it.Preprocess', 'marytts.modules.JPhonemiser(it.)', 'marytts.modules.OpenNLPPosTagger(it,it.pos)', 'marytts.language.it.Prosody', 'marytts.language.it.Postlex']],
            ['featuremanager.classes.list', ['marytts.features.FeatureProcessorManager(it)']],
            ['it.allophoneset', 'jar:/marytts/language/it/lexicon/allophones.it.xml'],
            ['it.lexicon', 'jar:/marytts/language/it/lexicon/it_lexicon.fst'],
            ['it.lettertosound', 'jar:/marytts/language/it/lexicon/it.lts'],
            ['it.removeTrailingOneFromPhones', 'false'],
            ['it.partsofspeech.fst', 'jar:/marytts/language/it/tagger/it_pos.fst'],
            ['it.partsofspeech.punctuation', ',.?!;'],
            ['it.pos.model', 'jar:/marytts/language/it/tagger/it-pos-maxent-151.g0_p0_m0.bin.model'],
            ['it.pos.deterministic_symbols_tagdict', 'jar:/marytts/language/it/tagger/deterministic_tagdict'],
            ['it.pos.deterministic_symbols_tagdict.isCaseSensitive', 'true'],
            ['it.pos.punct.regex', 'FB|FC|FF|FS'],
            ['it.prosody.tobipredparams', 'jar:/marytts/language/it/prosody/tobipredparams_italian.xml'],
            ['it.prosody.accentPriorities', 'jar:/marytts/language/it/prosody/POSAccentPriorities.it.properties'],
            ['it.prosody.paragraphdeclination', 'true'],
            ['it.prosody.syllableaccents', 'true']
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
