package org.backend.session.lld2.designpatterns.prototype.configurationObject;

public class Configuration implements Configurable<Configuration>{

    private String themeColor;
    private Boolean autoSave;
    private String language;
    private Boolean darkMode;
    private Integer fontSize;
    private String fontFamily;
    private ConfigurationType type;


    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    public Boolean getAutoSave() {
        return autoSave;
    }

    public void setAutoSave(Boolean autoSave) {
        this.autoSave = autoSave;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getDarkMode() {
        return darkMode;
    }

    public void setDarkMode(Boolean darkMode) {
        this.darkMode = darkMode;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public ConfigurationType getType() {
        return type;
    }

    public void setType(ConfigurationType type) {
        this.type = type;
    }

    public Configuration(String themeColor, Boolean autoSave, String language, Boolean darkMode, Integer fontSize, String fontFamily, ConfigurationType type) {
        this.themeColor = themeColor;
        this.autoSave = autoSave;
        this.language = language;
        this.darkMode = darkMode;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.type = type;
    }


    @Override
    public Configuration clone() {
        return new Configuration(this.themeColor, this.autoSave, this.language, this.darkMode, this.fontSize, this.fontFamily, this.type);
    }
}
