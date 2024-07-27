package org.backend.session.lld2.designpatterns.adapter.languagetranslation.adpaters;

import org.backend.session.lld2.designpatterns.adapter.languagetranslation.MicrosoftTranslateApi;
import org.backend.session.lld2.designpatterns.adapter.languagetranslation.TranslationProviderAdapter;
import org.backend.session.lld2.designpatterns.adapter.languagetranslation.translationrequests.TranslationRequest;

import java.util.List;

public class MicrosoftTranslationAdapter implements TranslationProviderAdapter {

    private MicrosoftTranslateApi translateApi = new MicrosoftTranslateApi(); // An instance of the adaptee class

    // The translate method calls the translate method of the MicrosoftTranslateApi.
    @Override
    public String translate(TranslationRequest request) {
        return translateApi.translate(request.getText(), request.getSourceLanguage(), request.getTargetLanguage());
    }

    // The getSupportedLanguages method returns the list of languages supported by the MicrosoftTranslateApi.
    @Override
    public List<String> getSupportedLanguages() {
        return translateApi.getSupportedLanguages();
    }


}
