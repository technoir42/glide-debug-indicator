Glide Debug Indicator
=====================

[ ![Download](https://api.bintray.com/packages/sch/maven/glide-debug-indicator/images/download.svg) ](https://bintray.com/sch/maven/glide-debug-indicator/_latestVersion)

Displays a colored ribbon over images which indicates where the image was loaded from.

<img src=".assets/screenshot.jpg" alt="Screenshot" width="320">

## Usage

```gradle
dependencies {
    debugImplementation "com.github.technoir42:glide-debug-indicator:0.9.1"
}
```

### Kotlin

```kotlin
// Enable debug indicator for a specific request:
glide.load(url)
    .withDebugIndicator()
    .into(imageView)

// Enable debug indicator for all requests:
@GlideModule
class MyAppGlideModule : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.enableDebugIndicators()
    }
}
```

### Java

```java
// Enable debug indicator for a specific request:
glide.load(url)
    .transition(DrawableTransitionOptions.with(DebugIndicatorTransitionFactory.DEFAULT))
    .into(imageView);

// Enable debug indicators for all requests:
@GlideModule
public class MyAppGlideModule extends AppGlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        builder.setDefaultTransitionOptions(Drawable.class, DrawableTransitionOptions.with(DebugIndicatorTransitionFactory.DEFAULT));
    }
}
```

## Legend
- ![#00ff00](https://placehold.it/15/00ff00/000000?text=+) Memory Cache
- ![#0066ff](https://placehold.it/15/0066ff/000000?text=+) Disk Cache
- ![#ff0000](https://placehold.it/15/ff0000/000000?text=+) Remote
- ![#ffff00](https://placehold.it/15/ffff00/000000?text=+) Local

## License

```
Copyright 2019 Sergey Chelombitko

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
