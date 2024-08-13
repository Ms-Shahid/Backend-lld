package org.backend.session.lld2.designpatterns.flyweight.graphic;

import lombok.Getter;

@Getter
public class GraphicIntrinsicState {

    private GraphicType type; // "text" or "image"
    private Image image; // Text content or image file path
    private GraphicExtrinsicState graphicExtrinsicState;
}
