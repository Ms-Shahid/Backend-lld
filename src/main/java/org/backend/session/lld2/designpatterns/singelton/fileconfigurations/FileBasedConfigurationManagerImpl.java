package org.backend.session.lld2.designpatterns.singelton.fileconfigurations;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManagerImpl fileInstance = null;

    private FileBasedConfigurationManagerImpl() {
        super();
    }

    public static FileBasedConfigurationManagerImpl getInstance() {

        if (fileInstance == null) {
            synchronized (FileBasedConfigurationManagerImpl.class) {
                if (fileInstance == null) {
                    fileInstance = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return fileInstance;
    }

    public static void restInstance() {

        if (fileInstance != null) {
            synchronized (FileBasedConfigurationManagerImpl.class) {
                if (fileInstance != null) {
                    fileInstance = null;
                }
            }
        }

    }

    @Override
    public String getConfiguration(String key) {
//        throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");
        return properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String value = properties.getProperty(key);
        if (value == null) {
            return null;
        }
        return convert(value, type);
    }

    @Override
    public void setConfiguration(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        properties.setProperty(key, String.valueOf(value));
    }

    @Override
    public void removeConfiguration(String key) {
        properties.remove(key);
    }

    @Override
    public void clear() {
        properties.clear();
    }
}
