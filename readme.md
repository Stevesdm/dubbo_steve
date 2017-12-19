# Micro-service-dubbo使用dubbo构建微服务

## project modules

- micro-service-dubbo-build:基础构建模块
- micro-service-dubbo-api：接口
- micro-service-dubbo-saas：服务消费者
- micro-serivce-dubbo-paas：服务提供者
- micro-service-dubbo-monitor

启动dubbo monitor
    
    cd /micro-serivce-dubbo-monitor/bin
    ./start.sh
    启动端口：8000

部署dubbo admin
    cd /micro-service-dubbo-admin
    把dubbo-admin war包放入tomcat解压
    修改WEB-INF下的dubbo.properties信息
    启动tomcat



warning:
    dubbo服务如果添加事务支持，则服务不能发布，需要修改实现
