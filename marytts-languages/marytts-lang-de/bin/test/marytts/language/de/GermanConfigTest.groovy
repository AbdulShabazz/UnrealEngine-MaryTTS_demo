package marytts.language.de

import marytts.config.*
import org.testng.annotations.*

class GermanConfigTest {

    GermanConfig config

    @BeforeMethod
    void setup() {
        config = new GermanConfig()
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
        assert config.properties.'locale' == 'de'
        assert config.properties.'modules.classes.list'.tokenize().containsAll(['marytts.language.de.JTokeniser', 'marytts.language.de.Preprocess', 'marytts.modules.OpenNLPPosTagger(de,de.pos)', 'marytts.language.de.JPhonemiser', 'marytts.language.de.Prosody', 'marytts.language.de.Postlex', 'marytts.modules.SimplePhoneme2AP(de)'])
        assert config.properties.'ignore.modules.classes.list'.tokenize().containsAll(['marytts.language.de.InformationStructure'])
        assert config.properties.'featuremanager.classes.list'.tokenize().containsAll(['marytts.language.de.features.FeatureProcessorManager'])
        assert config.properties.'de.allophoneset' == 'jar:/marytts/language/de/lexicon/allophones.de.xml'
        assert config.properties.'de.pos.model' == 'jar:/marytts/language/de/tagger/de-pos-maxent-1.5.bin'
        assert config.properties.'de.pos.punct.regex' == '\\$,|\\$.|\\$\\('
        assert config.properties.'de.phonemiser.useenglish' == 'false'
        assert config.properties.'de.phonemiser.logunknown' == 'true'
        assert config.properties.'de.phonemiser.logunknown.filename' == 'MARY_BASE/log/de_unknown.txt'
        assert config.properties.'de.phonemiser.logenglish.filename' == 'MARY_BASE/log/de_english-words.txt'
        assert config.properties.'de.userdict' == 'MARY_BASE/user-dictionaries/userdict-de.txt'
        assert config.properties.'de.lexicon' == 'jar:/marytts/language/de/lexicon/de_lexicon.fst'
        assert config.properties.'de.lettertosound' == 'jar:/marytts/language/de/lexicon/de.lts'
        assert config.properties.'de.prosody.paragraphdeclination' == 'true'
        assert config.properties.'de.prosody.tobipredparams' == 'jar:/marytts/language/de/prosody/tobipredparams_german.xml'
        assert config.properties.'de.prosody.accentPriorities' == 'jar:/marytts/language/de/prosody/POSAccentPriorities.properties'
        assert config.properties.'de.prosody.syllableaccents' == 'false'
        assert config.properties.'de.wordFrequency.fst' == 'jar:/marytts/language/de/lexicon/wordFrequencies-de.fst'
        assert config.properties.'de.wordFrequency.encoding' == 'ISO-8859-1'
    }
}
