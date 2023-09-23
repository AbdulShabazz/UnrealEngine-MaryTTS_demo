import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFiles
import org.gradle.api.tasks.TaskAction

class GenerateComponentXmlDescriptor extends DefaultTask {

    @Input
    List<Locale> locales

    @OutputFiles
    List<File> xmlFiles

    void setLocales(String... localeStrs) {
        locales = localeStrs.collect {
            Locale.forLanguageTag(it)
        }
    }

    List<File> getXmlFiles() {
        locales.collect { locale ->
            new File(project.buildDir, "marytts-lang-$locale-$project.version-component.xml")
        }
    }

    GenerateComponentXmlDescriptor() {
        def localeStr = project.name.replaceAll(~/marytts-lang-(.+).*/) { all, localeStr ->
            localeStr
        }
        locales = [Locale.forLanguageTag(localeStr)]
    }

    @TaskAction
    void generate() {
        [locales, getXmlFiles()].transpose().each { locale, xmlFile ->
            def xmlStr = new StreamingMarkupBuilder().bind {
                'marytts-install'(xmlns: 'http://mary.dfki.de/installer') {
                    language(locale: "$locale", name: locale.toLanguageTag(), version: project.version) {
                        delegate.description("${locale.getDisplayName(Locale.US)} language component")
                        license(href: 'http://www.gnu.org/licenses/lgpl-3.0-standalone.html')
                        'package'(filename: "marytts-lang-$locale-${project.version}.zip", md5sum: 'dummy', size: 0)
                    }
                }
            }
            xmlFile.text = XmlUtil.serialize(xmlStr)
        }
    }
}
