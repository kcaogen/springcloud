# Java 微服务实践 - Spring Cloud 系列

Spring Cloud为开发人员提供了快速构建分布式系统中一些常见模式的工具（例如配置管理，服务发现，断路器，智能路由，微代理，控制总线）。分布式系统的协调导致了样板模式, 使用Spring Cloud开发人员可以快速地支持实现这些模式的服务和应用程序。他们将在任何分布式环境中运行良好，包括开发人员自己的笔记本电脑，裸机数据中心，以及Cloud Foundry等托管平台。

## 特性

Spring Cloud专注于提供良好的开箱即用经验的典型用例和可扩展性机制覆盖。

- 分布式/版本化配置

- 服务注册和发现

- 路由

- service - to - service调用

- 负载均衡

- 断路器

- 分布式消息传递

### [SpringCloud(一):服务注册中心Eureka](https://www.kcaogen.com/blog/info/20)

Spring Cloud Eureka是Spring Cloud Netflix微服务套件中的一部分，它基于Netflix Eureka做了二次封装，主要负责完成微服务架构中的服务治理功能。Spring Cloud通过为Eureka增加了Spring Boot风格的自动化配置，我们只需通过简单引入依赖和注解配置就能让Spring Boot构建的微服务应用轻松地与Eureka服务治理体系进行整合。

### [SpringCloud(二):服务发现与消费](https://www.kcaogen.com/blog/info/21)

服务的发现和消费实际上是两个行为，这两个行为要由不同的对象来完成：服务的发现由Eureka客户端来完成，而服务的消费由Ribbon来完成。Ribbo是一个基于HTTP和TCP的客户端负载均衡器，当我们将Ribbon和Eureka一起使用时，Ribbon会从Eureka注册中心去获取服务端列表，然后进行轮询访问以到达负载均衡的作用，服务端是否在线这些问题则交由Eureka去维护。

### [SpringCloud(三):断路器Hystrix](https://www.kcaogen.com/blog/info/22)

在微服务架构中，我们将系统拆分成了很多服务单元，各单元的应用间通过服务注册与订阅的方式相互依赖。由于每个单元都在不同的进程中运行，依赖通过远程调用的方式执行，这样就有可能因为网络原因或者依赖服务自身的问题导致调用故障或延迟，而调用失败又会造成用户刷新页面并再次尝试调用，再加上其它服务调用，从而增加了服务器的负载，导致服务瘫痪，最终甚至会导致整个服务“雪崩”。

### [SpringCloud(四):Hystrix仪表板](https://www.kcaogen.com/blog/info/23)

Spring Cloud完美地整合了Hystrix的仪表板组件Hystrix Dashboard,它主要用来实时监控Hystrix的各项指标信息。通过Hystrix Dashboard反馈的实时信息，可以帮助我们快速发现系统中存在的问题，从而及时地采取应对措施。

### [SpringCloud(五):Turbine集群监控](https://www.kcaogen.com/blog/info/24)

看单个的Hystrix Dashboard的数据并没有什么多大的价值，要想看这个系统的Hystrix Dashboard数据就需要用到Hystrix Turbine。Hystrix Turbine将每个服务Hystrix Dashboard数据进行了整合。Hystrix Turbine的使用非常简单，只需要引入相应的依赖和加上注解和配置就可以了。

### [SpringCloud(六):服务消费者Feign 上](https://www.kcaogen.com/blog/info/25)

Spring Cloud Feign无参数绑定服务调用

### [SpringCloud(七):服务消费者Feign 中](https://www.kcaogen.com/blog/info/26)

Spring Cloud Feign有参数绑定服务调用

### [SpringCloud(八):服务消费者Feign 下](https://www.kcaogen.com/blog/info/27)

Hystrix提供的服务降级是服务容错的重要功能，由于Spring Cloud Feign在定义服务客户端的时候与Spring Cloud Ribbon有很大的差别，HystrixCommand定义被封装了起来，博客讲解Spring Cloud Feign的降级处理。