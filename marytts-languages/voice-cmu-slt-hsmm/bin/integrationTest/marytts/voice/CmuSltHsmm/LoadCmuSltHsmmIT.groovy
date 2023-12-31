package marytts.voice.CmuSltHsmm

import marytts.server.MaryProperties
import marytts.util.MaryRuntimeUtils

import org.testng.annotations.*

class LoadCmuSltHsmmIT {

    @BeforeMethod
    void setup() {
        MaryRuntimeUtils.ensureMaryStarted()
    }

    @DataProvider
    Object[][] properties() {
        [
            ['hmm.voices.list', ['cmu-slt-hsmm']],
            ['voice.cmu-slt-hsmm.gender', 'female'],
            ['voice.cmu-slt-hsmm.locale', 'en_US'],
            ['voice.cmu-slt-hsmm.domain', 'general'],
            ['voice.cmu-slt-hsmm.samplingRate', '48000'],
            ['voice.cmu-slt-hsmm.framePeriod', '240'],
            ['voice.cmu-slt-hsmm.alpha', '0.55'],
            ['voice.cmu-slt-hsmm.gamma', '0'],
            ['voice.cmu-slt-hsmm.logGain', 'true'],
            ['voice.cmu-slt-hsmm.beta', '0.1'],
            ['voice.cmu-slt-hsmm.Ftd', 'jar:/marytts/voice/CmuSltHsmm/tree-dur.inf'],
            ['voice.cmu-slt-hsmm.Ftf', 'jar:/marytts/voice/CmuSltHsmm/tree-lf0.inf'],
            ['voice.cmu-slt-hsmm.Ftm', 'jar:/marytts/voice/CmuSltHsmm/tree-mgc.inf'],
            ['voice.cmu-slt-hsmm.Fts', 'jar:/marytts/voice/CmuSltHsmm/tree-str.inf'],
            ['voice.cmu-slt-hsmm.Fmd', 'jar:/marytts/voice/CmuSltHsmm/dur.pdf'],
            ['voice.cmu-slt-hsmm.Fmf', 'jar:/marytts/voice/CmuSltHsmm/lf0.pdf'],
            ['voice.cmu-slt-hsmm.Fmm', 'jar:/marytts/voice/CmuSltHsmm/mgc.pdf'],
            ['voice.cmu-slt-hsmm.Fms', 'jar:/marytts/voice/CmuSltHsmm/str.pdf'],
            ['voice.cmu-slt-hsmm.useGV', 'true'],
            ['voice.cmu-slt-hsmm.useContextDependentGV', 'true'],
            ['voice.cmu-slt-hsmm.gvMethod', 'gradient'],
            ['voice.cmu-slt-hsmm.maxMgcGvIter', '100'],
            ['voice.cmu-slt-hsmm.maxLf0GvIter', '100'],
            ['voice.cmu-slt-hsmm.maxStrGvIter', '100'],
            ['voice.cmu-slt-hsmm.gvweightMgc', '1.0'],
            ['voice.cmu-slt-hsmm.gvweightLf0', '1.0'],
            ['voice.cmu-slt-hsmm.gvweightStr', '1.0'],
            ['voice.cmu-slt-hsmm.Fgvf', 'jar:/marytts/voice/CmuSltHsmm/gv-lf0.pdf'],
            ['voice.cmu-slt-hsmm.Fgvm', 'jar:/marytts/voice/CmuSltHsmm/gv-mgc.pdf'],
            ['voice.cmu-slt-hsmm.Fgvs', 'jar:/marytts/voice/CmuSltHsmm/gv-str.pdf'],
            ['voice.cmu-slt-hsmm.FeaFile', 'jar:/marytts/voice/CmuSltHsmm/cmu_us_arctic_slt_b0487.pfeats'],
            ['voice.cmu-slt-hsmm.trickyPhonesFile', 'jar:/marytts/voice/CmuSltHsmm/trickyPhones.txt'],
            ['voice.cmu-slt-hsmm.useMixExc', 'true'],
            ['voice.cmu-slt-hsmm.Fif', 'jar:/marytts/voice/CmuSltHsmm/mix_excitation_filters.txt'],
            ['voice.cmu-slt-hsmm.in', '5'],
            ['voice.cmu-slt-hsmm.useAcousticModels', 'true'],
            ['voice.cmu-slt-hsmm.acousticModels', 'duration F0'],
            ['voice.cmu-slt-hsmm.duration.model', 'hmm'],
            ['voice.cmu-slt-hsmm.duration.attribute', 'd'],
            ['voice.cmu-slt-hsmm.F0.model', 'hmm'],
            ['voice.cmu-slt-hsmm.F0.attribute', 'f0']
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
