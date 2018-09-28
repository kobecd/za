package com.richway.inter;

import com.richway.config.DisableHystrixConfiguration;
import com.richway.domain.User;
import com.richway.service.HelloServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Boao on 2018/6/4.
 * 绑定要调用的服务名
     Ribbon配置：
     1、@FeignClient注解会根据该注解的name或value属性指定的服务名，自动创建一个同名的Ribbon客户端
     在feign的yml配置文件中可以使用os-search.ribbon.key=value的形式针对os-search服务进行个性化配置
     2、spring cloud feign默认实现了请求的重试机制
     3、注意：Hystrix的超时时间要大于Ribbon的超时时间，否则Hystrix命令超时后直接熔断，重试机制就没有任何意义了

     Hystrix配置：
     1、默认情况下spring cloud feign会将所有的feign客户端的方法都封装到Hystrix命令中进行服务保护
     注意：可以通过【feign.hystrix.enabled=false】来启用/关闭feign的熔断功能，此值经测试默认为false！
     2、可以通过ContractProxySupplyService接口的实现类ContractProxySupplyServiceFallback中的重写方法来实现断路器的服务降级功能
 */

@FeignClient(name ="hello-service",fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @GetMapping("/hello1")
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "hello3",method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
