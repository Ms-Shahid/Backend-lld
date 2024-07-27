package org.backend.session.lld2.designpatterns.adapter.languagetranslation;

import org.backend.session.lld2.designpatterns.adapter.languagetranslation.translationrequest;
import org.backend.session.lld2.designpatterns.adapter.languagetranslation.translationrequests.TranslationRequest;

import java.util.List;

import static org.backend.session.lld2.designpatterns.adapter.languagetranslation.ApiUtils.logGoogleGetSupportedLanguages;
import static org.backend.session.lld2.designpatterns.adapter.languagetranslation.ApiUtils.logGoogleTranslate;

public class GoogleTranslateApi {

    public String convert(GoogleTranslationRequest request) {
        // Implementation for translating text using Google Translate API
        logGoogleTranslate();
        return "Translated text";
    }

    public List<String> getLanguages() {
        // Implementation for fetching supported languages from Google Translate
        logGoogleGetSupportedLanguages();
        return List.of("hindi", "marathi", "kannada");
    }
}
