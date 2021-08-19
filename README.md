# tinker

> 通过process${variantName}Manifest Task doLast 执行 针对Mapping.txt来替换AndroidManifest.xml里面四大组件的名称 


## 接入文档

#### 1. 在项目下的build.gradle添加代码

```
classpath 'freelifer.gradle.plugin:tinker:1.0.0'
```

#### 2. 在module下的build.gradle添加代码

```
// 插件名称
apply plugin: 'tinker'

```

参数说明

无



## 版本发布记录

| 插件版本 | 修订日期 | 修订说明 |
| ------------ | ------------ | ------------ |
| 1.0.0 | 2021/04/30 | 初版，支持Activity替换 |
