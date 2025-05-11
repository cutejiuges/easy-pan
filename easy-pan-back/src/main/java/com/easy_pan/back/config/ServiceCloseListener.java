package com.easy_pan.back.config;

import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistration;
import org.springframework.cloud.consul.serviceregistry.ConsulServiceRegistry;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ServiceCloseListener {
    @Resource
    private ConsulServiceRegistry consulServiceRegistry;
    @Resource
    private ConsulRegistration consulRegistration;

    @EventListener(ContextClosedEvent.class)
    public void processUnRegister(ContextClosedEvent event) {
        log.info("服务注册对象:{}-{}，已下线", this.consulServiceRegistry, this.consulRegistration);
        if (this.consulServiceRegistry != null) {
            this.consulServiceRegistry.deregister(this.consulRegistration);
        }
    }
}
