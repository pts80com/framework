# framework
Gradle
------
```
dependencies {
    ...
    compile 'com.pts80:framework:1.0.0'
}
```
How To Use
------
- 继承BaseActivity
```java
public class xxxActivity extends BaseActivity
```
- 实现其方法
```java
@Override
public int setLayoutResID() { return R.layout.activity_main;}
@Override
public void initViews() {}
@Override
public void initDatas() {}
@Override
public void initEvent() {}
```
