import groovy.xml.StreamingMarkupBuilder;
import groovy.xml.XmlUtil;
import org.gradle.api.DefaultTask;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFiles;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class GenerateComponentXmlDescriptor extends DefaultTask {

    // Use ListProperty for Gradle's property type
    private final ListProperty<Locale> locales = getProject().getObjects().listProperty(Locale.class);

    // Use ListProperty for Gradle's property type
    private final ListProperty<File> xmlFiles = getProject().getObjects().listProperty(File.class);

    // Setter for locales
    public void setLocales(String... localeStrs) {
        locales.set(List.of(localeStrs).stream()
                .map(Locale::forLanguageTag)
                .collect(Collectors.toList()));
    }

    // Getter for xmlFiles
    public ListProperty<File> getXmlFiles() {
        return xmlFiles;
    }

    // Constructor
    public GenerateComponentXmlDescriptor() {
        String localeStr = getProject().getName().replaceAll("marytts-lang-(.+).*", "${1}");
        locales.set(List.of(Locale.forLanguageTag(localeStr)));
    }

    // Task action to generate XML
    @TaskAction
    public void generate() {
        List<List<Object>> combined = List.of(locales.get(), xmlFiles.get());
        combined.get(0).stream()
                .forEach(index -> {
                    Locale locale = (Locale) combined.get(0).get((int)index);
                    File xmlFile = (File) combined.get(1).get((int)index);

                    String xmlStr = new StreamingMarkupBuilder().bind {
                        'marytts-install'(xmlns: 'http://mary.dfki.de/installer') {
                            language(locale: "$locale", name: locale.toLanguageTag(), version: getProject().getVersion()) {
                                delegate.description("${locale.getDisplayName(Locale.US)} language component");
                                license(href: 'http://www.gnu.org/licenses/lgpl-3.0-standalone.html');
                                'package'(filename: "marytts-lang-$locale-${getProject().getVersion()}.zip", md5sum: 'dummy', size: 0);
                            }
                        }
                    };
                    xmlFile.setText(XmlUtil.serialize(xmlStr));
                });
    }
}

