
###  按照不同profile启动

```
java -jar -Dspring.profiles.active=dev eureka-server.jar
// 或者
java -jar eureka-server.jar --spring.profiles.active=dev
```

### EurekaServer服务

引入EurekaServer相关依赖后，只需以下配置和代码即可启动一个EurekaServer服务。
```yaml
server:
  port: 8080

## eureka
eureka:
  client:
    fetch-registry: false
    register-with-eureka: false
    service-url:
      defaultZone: http://localhost:${server.port}/eureka/
```
```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
```

### Provider服务

引入Eureka相关依赖后，只需以下配置和代码即可启动一个Provider服务。
```yaml
server:
  port: 8090

## eureka
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8080/eureka/
      # 更改服务实例ID，默认显示格式 机器名:实例名:端口
      instance:
        instance-id: ${spring.cloud.client.ipAddress}:${server.port}-${spring.application.name}:@project.version@
```
```java
@EnableEurekaClient
@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
```

### Consumer

引入Eureka和Feign相关依赖后，只需以下配置和代码即可启动一个Consumer。
```yaml
server:
  port: 9000

## eureka
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8080/eureka/
```
```java
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class WorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorldApplication.class, args);
    }

}

// 调用hello-service服务
@FeignClient("hello-service")
public interface HelloServiceClient {

    @GetMapping("/")
    String index();

}
```

注意，eureka.client.register-with-eureka配置默认为tree，也就是说Consumer会将自己的restful服务注册到eureka上，如果不想让Consumer作为Provider服务，则需配置
```
eureka.client.register-with-eureka=false
```