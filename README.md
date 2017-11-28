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
