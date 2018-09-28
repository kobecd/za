# spring-cloud项目

#### 项目介绍
此项目根据spring-cloud微服务实战一书中的案例进行编写，内容较为基础，可根据具体业务扩展。

#### 软件架构
软件架构说明


#### 安装教程

1. xxxx
2. xxxx
3. xxxx

#### 使用说明

#问题记录 ##以下为学习时遇到的问题汇总，后边会抽出时间统一解决

##一、服务治理Eureka（待解决） ###1、高可用注册中心 在peer1中成功注册了peer2的副本，在registered-replicas中正常显示http://peer2:1112/eureka/； 但在peer2正常启动的情况下peer2的副本应该在available-replicas（可用的副本）栏中； 但现在的情况是在unavailable-replicas栏中（表示不可用的副本）；反之，peer2中的peer1的副本也是这种情况； 备注：服务提供者OS-SEARCH启动后正常在peer1和peer2注册中心都成功注册。

##二、声明式服务调用：spring cloud feign（待解决） ###1、Feign声明式实现hystrix服务降级（断路器） 可以通过ContractProxySupplyService接口的实现类ContractProxySupplyServiceFallback中的重写方法来实现断路器的服务降级功能。 但是在ContractProxySupplyController中注入属性contractProxySupplyService有错误提示（但不影响服务正常运行）， 错误提示为接口interface ContractProxySupplyService和其实现类ContractProxySupplyServiceFallback都被注入到了IOC容器中， 而@Autowired注解按类型注册，不知道需要注册哪一个bean，提示错误代码如下： @Autowired private ContractProxySupplyService contractProxySupplyService;

##三、消息总线：spring cloud bus（待完善） 整合spring cloud config以实现配置文件的自动刷新；现在手动发送 /bus/refresh 刷新接口可以正常触发消息总线 下各服务的动态刷新；后边有时间需完善通过git的webhook API实现上传配置文件时由git的webhook自动发起 /bus/refresh 请求来实现配置文件的自动刷新

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


#### 码云特技

1. 使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2. 码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3. 你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4. [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5. 码云官方提供的使用手册 [http://git.mydoc.io/](http://git.mydoc.io/)
6. 码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)