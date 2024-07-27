package org.backend.session.lld2.designpatterns.adapter.languagetranslation.translationrequests;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TranslationRequest {

    private String text;
    private String sourceLanguage;
    private String targetLanguage;
    private Double confidenceThreshold;

}
