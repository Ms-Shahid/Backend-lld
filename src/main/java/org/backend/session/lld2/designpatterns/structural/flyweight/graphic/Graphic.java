package org.backend.session.lld2.designpatterns.flyweight.graphic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Graphic {

    private GraphicType type; // "text" or "image"
    private Image image; // Text content or image file path
    private int x, y; // Coordinates
    private int width, height; // Dimensions
    private String color; // Font color for text or image format for images


}
