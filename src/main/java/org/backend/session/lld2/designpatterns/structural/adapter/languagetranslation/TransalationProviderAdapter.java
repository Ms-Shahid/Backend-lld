package org.backend.session.lld2.designpatterns.adapter.languagetranslation;

import org.backend.session.lld2.designpatterns.adapter.languagetranslation.translationrequests.TranslationRequest;

import java.util.List;

public interface TranslationProviderAdapter {

    String translate(TranslationRequest translationRequest);

    List<String> getSupportedLanguages();

}
