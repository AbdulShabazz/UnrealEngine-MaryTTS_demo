package marytts.language.de

import marytts.server.MaryProperties
import marytts.util.MaryRuntimeUtils

import org.testng.annotations.*

class LoadGermanIT {

    @BeforeMethod
    void setup() {
        MaryRuntimeUtils.ensureMaryStarted()
    }

    @DataProvider
    Object[][] properties() {
        [
            ['modules.classes.list', ['marytts.language.de.JTokeniser', 'marytts.language.de.Preprocess', 'marytts.modules.OpenNLPPosTagger(de,de.pos)', 'marytts.language.de.JPhonemiser', 'marytts.language.de.Prosody', 'marytts.language.de.Postlex', 'marytts.modules.SimplePhoneme2AP(de)']],
            ['ignore.modules.classes.list', ['marytts.language.de.InformationStructure']],
            ['featuremanager.classes.list', ['marytts.language.de.features.FeatureProcessorManager']],
            ['de.allophoneset', 'jar:/marytts/language/de/lexicon/allophones.de.xml'],
            ['de.pos.model', 'jar:/marytts/language/de/tagger/de-pos-maxent-1.5.bin'],
            ['de.pos.punct.regex', '\\$,|\\$.|\\$\\('],
            ['de.phonemiser.useenglish', 'false'],
            ['de.phonemiser.logunknown', 'true'],
            ['de.phonemiser.logunknown.filename', 'MARY_BASE/log/de_unknown.txt'],
            ['de.phonemiser.logenglish.filename', 'MARY_BASE/log/de_english-words.txt'],
            ['de.userdict', 'MARY_BASE/user-dictionaries/userdict-de.txt'],
            ['de.lexicon', 'jar:/marytts/language/de/lexicon/de_lexicon.fst'],
            ['de.lettertosound', 'jar:/marytts/language/de/lexicon/de.lts'],
            ['de.prosody.paragraphdeclination', 'true'],
            ['de.prosody.tobipredparams', 'jar:/marytts/language/de/prosody/tobipredparams_german.xml'],
            ['de.prosody.accentPriorities', 'jar:/marytts/language/de/prosody/POSAccentPriorities.properties'],
            ['de.prosody.syllableaccents', 'false'],
            ['de.wordFrequency.fst', 'jar:/marytts/language/de/lexicon/wordFrequencies-de.fst'],
            ['de.wordFrequency.encoding', 'ISO-8859-1']
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
