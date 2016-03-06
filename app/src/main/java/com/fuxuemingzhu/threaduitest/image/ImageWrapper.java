/*
 * Copyright 2015 XiNGRZ <chenxingyu92@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fuxuemingzhu.threaduitest.image;

public class ImageWrapper {

    public final String url;

    public final int width;
    public final int height;

    private ImageWrapper(Image image) {
        this.url = image.getUrl();
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public static ImageWrapper from(Image image) {
        return new ImageWrapper(image);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ImageWrapper)) {
            return false;
        }

        ImageWrapper image = (ImageWrapper) o;

        return url.equals(image.url);
    }

    @Override
    public int hashCode() {
        return 87 + url.hashCode();
    }

}
