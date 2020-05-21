---
layout: Post
title: "JavaMaven学习"
date: 2020-5-15 0:44
comments: true
tags: 
	- Maven(Java Util包)
---



### 一、Maven坐标

　　**maven坐标概念：**每个构件都有自己的一个标识（唯一的），它由groupId,artifactId,version等信息组成，因此maven就可以对构件进行版本控制、管理。

　　**备注：**

　　groupId ：公司名称或者组织名称；

　　artifactId：项目名称；

　　version：当前项目的版本号。

　　上边定义maven的概念时提到了构件，**那么什么是构件呢?**

　　------在maven中任何依赖（jar包）、项目输出（通过其他工具打包的jar、war等）都可以称为构件。

　　**packing：**定义maven项目打包的方式，也可以通过定义打包成war等；当不定义packing时，maven就会使用默认值jar。

　　**classifer：**表示在相同版本下针对不同的环境或者jdk使用的jar，如果配置了这个元素，则将这个元素的名称附加到报名的后边。例如：json-0.1-jdk1.6.jar。

 

### 二、Maven仓库

　　**maven仓库定义：**在maven中会有一个统一存储所有项目的共享构建的位置，这个统一的位置，我们就称之为仓库。

　　**maven仓库的分类：**本地仓库、远程仓库。

　　其中**远程仓库有分为三种：**中央仓库、私服、其他公共仓库。

　　示意图：

![img](https://images2018.cnblogs.com/blog/1211355/201807/1211355-20180718181431365-251189813.png)

1、本地仓库：maven在本地存储构件的地方。

　　本地仓库是指存在于我们本机的仓库，在我们加入依赖时候，首先会跑到我们的本地仓库去找，如果找不到则会跑到远程仓库中去找。对于依赖的包大家可以从这个地址进行搜索：http://mvnrepository.com/。　　

　　**注意：**maven的本地仓库，在maven安装后并不创建，它是在第一次执行maven命令的时候才被创建的。

　　（1）maven本地仓库默认位置

　　无论windows还是linux环境，都是默认位置都是在用户的目录下的一个./m2/repository/仓库目录，这就是maven仓库的默认位置。

　　（2）maven本地仓库默认位置修改

　　通过修改配置文件settings.xml中的localRepository标签，就可以实现。

　　**备注：**一般修改时，可以把之前已经下载的本地构件内容复制到新的构件存储目录下，这样就可以省去重新下载构件的时间。

　　1、远程仓库

 　远程仓库是指其他服务器上的仓库，包括全球中央仓库，公司内部的私服，又或者其他公司提供的公共库。后面会专门聊聊私服，公共库的话只是一个地址，大家会引用就行了。

 

### 三、Maven生命周期

　　 Maven 有以下三个标准的生命周期：

- clean：项目清理的处理
- default(或 build)：项目部署的处理
- site：项目站点文档创建的处理

### 构建阶段由插件目标构成

一个插件目标代表一个特定的任务（比构建阶段更为精细），这有助于项目的构建和管理。这些目标可能被绑定到多个阶段或者无绑定。不绑定到任何构建阶段的目标可以在构建生命周期之外通过直接调用执行。这些目标的执行顺序取决于调用目标和构建阶段的顺序。

例如下面的命令：

`clean` 和 `pakage` 是构建阶段，`dependency:copy-dependencies` 是目标

```
mvn clean dependency:copy-dependencies package
复制代码
```

这里的 `clean` 阶段将会被首先执行，然后 `dependency:copy-dependencies` 目标会被执行，最终 `package` 阶段被执行。

------

### Clean 生命周期



![CleanLifecycle](https://user-gold-cdn.xitu.io/2018/11/3/166da042d4e79f31?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

当我们执行 mvn post-clean 命令时，Maven 调用 clean 生命周期，它包含以下阶段：



- **pre-clean**：执行一些需要在clean之前完成的工作
- **clean**：移除所有上一次构建生成的文件
- **post-clean**：执行一些需要在clean之后立刻完成的工作

`mvn clean` 中的 `clean` 就是上面的 `clean`，在一个生命周期中，运行某个阶段的时候，它之前的所有阶段都会被运行，也就是说，`mvn clean` 等同于`mvn pre-clean clean` ，如果我们运行`mvn post-clean` ，那么 `pre-clean`，`clean` 都会被运行。

### Default (Build) 生命周期



![DefaultLifecycle](https://user-gold-cdn.xitu.io/2018/11/3/166da042d5995b94?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

这是 Maven 的主要生命周期，被用于构建应用，包括下面的 23 个阶段：



| 生命周期阶段          | 描述                                                         |
| --------------------- | ------------------------------------------------------------ |
| validate              | 检查工程配置是否正确，完成构建过程的所有必要信息是否能够获取到。 |
| initialize            | 初始化构建状态，例如设置属性。                               |
| generate-sources      | 生成编译阶段需要包含的任何源码文件。                         |
| process-sources       | 处理源代码，例如，过滤任何值（filter any value）。           |
| generate-resources    | 生成工程包中需要包含的资源文件。                             |
| process-resources     | 拷贝和处理资源文件到目的目录中，为打包阶段做准备。           |
| compile               | 编译工程源码。                                               |
| process-classes       | 处理编译生成的文件，例如 Java Class 字节码的加强和优化。     |
| generate-test-sources | 生成编译阶段需要包含的任何测试源代码。                       |
| process-test-sources  | 处理测试源代码，例如，过滤任何值（filter any values)。       |
| test-compile          | 编译测试源代码到测试目的目录。                               |
| process-test-classes  | 处理测试代码文件编译后生成的文件。                           |
| test                  | 使用适当的单元测试框架（例如JUnit）运行测试。                |
| prepare-package       | 在真正打包之前，为准备打包执行任何必要的操作。               |
| package               | 获取编译后的代码，并按照可发布的格式进行打包，例如 JAR、WAR 或者 EAR 文件。 |
| pre-integration-test  | 在集成测试执行之前，执行所需的操作。例如，设置所需的环境变量。 |
| integration-test      | 处理和部署必须的工程包到集成测试能够运行的环境中。           |
| post-integration-test | 在集成测试被执行后执行必要的操作。例如，清理环境。           |
| verify                | 运行检查操作来验证工程包是有效的，并满足质量要求。           |
| install               | 安装工程包到本地仓库中，该仓库可以作为本地其他工程的依赖。   |
| deploy                | 拷贝最终的工程包到远程仓库中，以共享给其他开发人员和工程。   |

> 有一些与 Maven 生命周期相关的重要概念需要说明： 当一个阶段通过 Maven 命令调用时，例如 `mvn compile`，只有该阶段之前以及包括该阶段在内的所有阶段会被执行。 不同的 maven 目标将根据打包的类型（`JAR / WAR / EAR`），被绑定到不同的 Maven 生命周期阶段。

### Site 生命周期



![SiteLifecycle](https://user-gold-cdn.xitu.io/2018/11/3/166da042d5aa0e90?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

Maven Site 插件一般用来创建新的报告文档、部署站点等。



| 生命周期阶段 | 描述                                                       |
| ------------ | ---------------------------------------------------------- |
| pre-site     | 执行一些需要在生成站点文档之前完成的工作                   |
| site         | 生成项目的站点文档                                         |
| post-site    | 执行一些需要在生成站点文档之后完成的工作，并且为部署做准备 |
| site-deploy  | 将生成的站点文档部署到特定的服务器上                       |

这里经常用到的是site阶段和site-deploy阶段，用以生成和发布Maven站点，这可是Maven相当强大的功能。

### Maven把本地Jar打到仓库 

1、本地有自己写的项目jar包，但是需要用maven依赖对其进行引用；

2、某个jar包在远程仓库没有，导致pom.xml报错，此时可以从网上单独下载此jar包，然后打入本地仓库，即可使用。



Maven 安装 JAR 包的命令是：



mvn install:install-file -Dfile=jar包的位置 -DgroupId=上面的groupId -DartifactId=上面的artifactId -Dversion=上面的version -Dpackaging=jar