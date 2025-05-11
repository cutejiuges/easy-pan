package com.easy_pan.back.config;

import com.easy_pan.back.EasyPanHandler;
import com.easy_pan.server.EasyPanService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistration;
import org.springframework.cloud.consul.serviceregistry.ConsulServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 配置accountService后端服务的启动类
@Slf4j
@Configuration
public class EasyPanServerConfig {
    @Value("${spring.cloud.consul.discovery.port}")
    private int port;
    @Resource
    private ConsulServiceRegistry consulServiceRegistry;
    @Resource
    private ConsulRegistration consulRegistration;

    @Bean
    public TServer easyPanServer(EasyPanHandler easyPanHandler) throws Exception{
        // 启动rpc服务
        log.info("server running port is: {}", this.port);
        TServerTransport serverTransport = new TServerSocket(this.port);
        EasyPanService.Processor<EasyPanHandler> processor = new EasyPanService.Processor<>(easyPanHandler);
        TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverTransport)
                .processor(processor)
                .protocolFactory(new TBinaryProtocol.Factory(true, true, Integer.MAX_VALUE, Integer.MAX_VALUE));
        TServer server = new TThreadPoolServer(args);
        new Thread(server::serve).start();
        // 注册rpc服务
        this.consulServiceRegistry.register(this.consulRegistration);
        return server;
    }
}
