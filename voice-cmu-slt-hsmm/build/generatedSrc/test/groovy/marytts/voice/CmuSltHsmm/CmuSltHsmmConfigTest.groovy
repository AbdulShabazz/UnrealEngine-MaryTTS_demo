package marytts.voice.CmuSltHsmm

import marytts.config.*
import org.testng.annotations.*

class CmuSltHsmmConfigTest {

    CmuSltHsmmConfig config

    @BeforeMethod
    void setup() {
        config = new CmuSltHsmmConfig()
    }

    @Test
    public void isNotMainConfig() {
        assert config.isMainConfig() == false
    }

    @Test
    public void testConfigBaseClass() {
        assert config instanceof VoiceConfig
    }

    @Test
    public void canGetProperties() {
        assert config.properties.'name' == 'cmu-slt-hsmm'
        assert config.properties.'locale' == 'en_US'
        assert config.properties.'hmm.voices.list'.tokenize().containsAll(['cmu-slt-hsmm'])
        assert config.properties.'voice.cmu-slt-hsmm.gender' == 'female'
        assert config.properties.'voice.cmu-slt-hsmm.locale' == 'en_US'
        assert config.properties.'voice.cmu-slt-hsmm.domain' == 'general'
        assert config.properties.'voice.cmu-slt-hsmm.samplingRate' == '48000'
        assert config.properties.'voice.cmu-slt-hsmm.framePeriod' == '240'
        assert config.properties.'voice.cmu-slt-hsmm.alpha' == '0.55'
        assert config.properties.'voice.cmu-slt-hsmm.gamma' == '0'
        assert config.properties.'voice.cmu-slt-hsmm.logGain' == 'true'
        assert config.properties.'voice.cmu-slt-hsmm.beta' == '0.1'
        assert config.properties.'voice.cmu-slt-hsmm.Ftd' == 'jar:/marytts/voice/CmuSltHsmm/tree-dur.inf'
        assert config.properties.'voice.cmu-slt-hsmm.Ftf' == 'jar:/marytts/voice/CmuSltHsmm/tree-lf0.inf'
        assert config.properties.'voice.cmu-slt-hsmm.Ftm' == 'jar:/marytts/voice/CmuSltHsmm/tree-mgc.inf'
        assert config.properties.'voice.cmu-slt-hsmm.Fts' == 'jar:/marytts/voice/CmuSltHsmm/tree-str.inf'
        assert config.properties.'voice.cmu-slt-hsmm.Fmd' == 'jar:/marytts/voice/CmuSltHsmm/dur.pdf'
        assert config.properties.'voice.cmu-slt-hsmm.Fmf' == 'jar:/marytts/voice/CmuSltHsmm/lf0.pdf'
        assert config.properties.'voice.cmu-slt-hsmm.Fmm' == 'jar:/marytts/voice/CmuSltHsmm/mgc.pdf'
        assert config.properties.'voice.cmu-slt-hsmm.Fms' == 'jar:/marytts/voice/CmuSltHsmm/str.pdf'
        assert config.properties.'voice.cmu-slt-hsmm.useGV' == 'true'
        assert config.properties.'voice.cmu-slt-hsmm.useContextDependentGV' == 'true'
        assert config.properties.'voice.cmu-slt-hsmm.gvMethod' == 'gradient'
        assert config.properties.'voice.cmu-slt-hsmm.maxMgcGvIter' == '100'
        assert config.properties.'voice.cmu-slt-hsmm.maxLf0GvIter' == '100'
        assert config.properties.'voice.cmu-slt-hsmm.maxStrGvIter' == '100'
        assert config.properties.'voice.cmu-slt-hsmm.gvweightMgc' == '1.0'
        assert config.properties.'voice.cmu-slt-hsmm.gvweightLf0' == '1.0'
        assert config.properties.'voice.cmu-slt-hsmm.gvweightStr' == '1.0'
        assert config.properties.'voice.cmu-slt-hsmm.Fgvf' == 'jar:/marytts/voice/CmuSltHsmm/gv-lf0.pdf'
        assert config.properties.'voice.cmu-slt-hsmm.Fgvm' == 'jar:/marytts/voice/CmuSltHsmm/gv-mgc.pdf'
        assert config.properties.'voice.cmu-slt-hsmm.Fgvs' == 'jar:/marytts/voice/CmuSltHsmm/gv-str.pdf'
        assert config.properties.'voice.cmu-slt-hsmm.FeaFile' == 'jar:/marytts/voice/CmuSltHsmm/cmu_us_arctic_slt_b0487.pfeats'
        assert config.properties.'voice.cmu-slt-hsmm.trickyPhonesFile' == 'jar:/marytts/voice/CmuSltHsmm/trickyPhones.txt'
        assert config.properties.'voice.cmu-slt-hsmm.useMixExc' == 'true'
        assert config.properties.'voice.cmu-slt-hsmm.Fif' == 'jar:/marytts/voice/CmuSltHsmm/mix_excitation_filters.txt'
        assert config.properties.'voice.cmu-slt-hsmm.in' == '5'
        assert config.properties.'voice.cmu-slt-hsmm.useAcousticModels' == 'true'
        assert config.properties.'voice.cmu-slt-hsmm.acousticModels' == 'duration F0'
        assert config.properties.'voice.cmu-slt-hsmm.duration.model' == 'hmm'
        assert config.properties.'voice.cmu-slt-hsmm.duration.attribute' == 'd'
        assert config.properties.'voice.cmu-slt-hsmm.F0.model' == 'hmm'
        assert config.properties.'voice.cmu-slt-hsmm.F0.attribute' == 'f0'
    }
}
