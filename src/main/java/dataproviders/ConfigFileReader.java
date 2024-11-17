package dataproviders;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public class ConfigFileReader {

    private static final Properties TestProperties = new Properties();

    static {
        BufferedReader readerTestProperties;
        String propertiesFileName = "test.properties";
        readerTestProperties = new BufferedReader(new InputStreamReader(Objects.requireNonNull(ConfigFileReader.class.getClassLoader().getResourceAsStream(propertiesFileName))));
        try {
            TestProperties.load(readerTestProperties);
            readerTestProperties.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ConfigFileReader() {
    }

    public static String getApplicationUrl() throws Exception {
        String url = TestProperties.getProperty("url");
        if (url != null) return url;
        else
            throw new Exception("url not specified in the .properties file");
    }

    public static Duration getImplicitlyWait() throws Exception {
        String implicitlyWait = TestProperties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Duration.ofSeconds(Long.parseLong(implicitlyWait));
        else
            throw new Exception("implicitlyWait key value in environment .properties file is not matched");
    }
}
