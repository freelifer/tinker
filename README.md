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

| 参数 | 说明 | 默认 |
| ------ | ------- | ------- |
| repositoryId | maven仓库id | 必填 |
| url | maven仓库地址 | 必填 |
| groupId | 项目组织 | 必填 |
| artifactId | 项目名称 | module的名称 |
| version | 项目版本 | android.defaultConfig.versionName |
| cmd | maven命令 | mvn |
| ignore | 根据aar依赖生成pom.xml的忽略依赖库列表 | 空 |



## 版本发布记录

| 插件版本 | 修订日期 | 修订说明 |
| ------------ | ------------ | ------------ |
| 1.0.0 | 2021/04/30 | 初版，支持Activity替换 |
