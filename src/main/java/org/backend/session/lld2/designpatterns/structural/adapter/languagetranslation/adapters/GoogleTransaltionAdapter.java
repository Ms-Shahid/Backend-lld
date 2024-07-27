package org.backend.session.lld2.designpatterns.adapter.languagetranslation.adpaters;

import org.backend.session.lld2.designpatterns.adapter.languagetranslation.GoogleTranslateApi;
import org.backend.session.lld2.designpatterns.adapter.languagetranslation.translationrequest;
import org.backend.session.lld2.designpatterns.adapter.languagetranslation.TranslationProviderAdapter;
import org.backend.session.lld2.designpatterns.adapter.languagetranslation.translationrequests.TranslationRequest;

import java.util.List;

public class GoogleTranslationAdapter implements TranslationProviderAdapter {

    private GoogleTranslateApi googleTranslateApi = new GoogleTranslateApi(); // An instance of the adaptee class

    // The translate method converts the TranslationRequest to a GoogleTranslationRequest and calls the convert method of the GoogleTranslateApi.
    @Override
    public String translate(TranslationRequest request) {
        return googleTranslateApi.convert(to(request));
    }

    // The to method converts a TranslationRequest to a GoogleTranslationRequest.
    private GoogleTranslationRequest to(TranslationRequest request) {
        return new GoogleTranslationRequest(request.getText(), request.getSourceLanguage(), request.getTargetLanguage(), 0.8);
    }

    // The getSupportedLanguages method returns the list of languages supported by the GoogleTranslateApi.
    @Override
    public List<String> getSupportedLanguages() {
        return googleTranslateApi.getLanguages();
    }

}
