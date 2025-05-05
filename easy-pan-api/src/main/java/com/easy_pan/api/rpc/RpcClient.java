package com.easy_pan.api.rpc;

import com.easy_pan.server.EasyPanService;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@Log4j2
public class RpcClient {
    @Resource
    private ConsulDiscoveryClient consulDiscoveryClient;
    private final Random random = new Random();

    public EasyPanService.Client getRpcClient() throws TTransportException {
        // 从consul获取实例列表
        List<ServiceInstance> instances = this.consulDiscoveryClient.getInstances("easyPanBack");
        int size = instances.size();
        log.info("length of instances: {}", size);
        ServiceInstance instance = instances.get(this.random.nextInt(size));

        // 创建客户端实例
        TTransport transport = new TSocket(instance.getHost(), instance.getPort());
        TProtocol protocol = new TBinaryProtocol(transport);
        transport.open();
        return new EasyPanService.Client(protocol);
    }
}
