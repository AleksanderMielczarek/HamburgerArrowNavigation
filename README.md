[![Release](https://jitpack.io/v/AleksanderMielczarek/HamburgerArrowNavigation.svg)](https://jitpack.io/#AleksanderMielczarek/HamburgerArrowNavigation)

# HamburgerArrowNavigation

Library allows to use hamburger to arrow animation for navigation in app.

![Logo](images/example.gif)

## Usage

Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
	repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

Add the dependency

```groovy
dependencies {
    compile 'com.github.AleksanderMielczarek:HamburgerArrowNavigation:0.1.1'
}
```

## Example

```java
public class FirstActivity extends AppCompatActivity {

    private HamburgerArrowNavigator hamburgerArrowNavigator;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        //some code
      
        hamburgerArrowNavigator = HamburgerArrowNavigation.getDefault().getHamburgerArrowNavigator(this);
        hamburgerArrowNavigator.setupWithToolbar(toolbar);
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        hamburgerArrowNavigator.animateToHamburger();
    }
}

public class SecondActivity extends AppCompatActivity {

    private HamburgerArrowNavigator hamburgerArrowNavigator;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     
        //some code
     
        hamburgerArrowNavigator = HamburgerArrowNavigation.getDefault().getHamburgerArrowNavigator(this);
        hamburgerArrowNavigator.setupWithToolbar(toolbar);
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        hamburgerArrowNavigator.animateToArrow();
    }
}

HamburgerArrowNavigation hamburgerArrowNavigation = HamburgerArrowNavigation.builder()
        .animationDuration(1000)
        .delayDuration(100)
        .build();
```
 
## Changelog
 
### 0.1.1 (2016-09-12)
 
- fix issue with duration of partial animation
 
## License

    Copyright 2016 Aleksander Mielczarek

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
