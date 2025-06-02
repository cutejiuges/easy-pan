package com.easy_pan.model.generate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.type.JdbcType;

import java.nio.file.Paths;


public class Generator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/easy_pan?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false" +
                "&tinyInt1isBit=true&allowPublicKeyRetrieval=true";
        FastAutoGenerator.create(url, System.getenv("DB_MYSQL_USERNAME"), System.getenv("DB_MYSQL_PASSWORD"))
                .globalConfig(builder -> builder
                        .author(System.getenv("AUTHOR"))
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/easy-pan-model/src/main/java")
                        .commentDate("yyyy-MM-dd")
                )
                .dataSourceConfig(builder -> builder.
                        typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            // 兼容旧版本转换成Integer
                            if (JdbcType.TINYINT == metaInfo.getJdbcType()) {
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder -> builder
                        .parent("com.easy_pan.model")
                        .entity("pojo.entity")
                        .service("service")
                        .serviceImpl("service.impl")
                        .mapper("mapper")
                )
                .strategyConfig(builder -> builder
                        .addTablePrefix("tb")
                        .controllerBuilder().disable()
                        .serviceBuilder()
                        .mapperBuilder()
                        .entityBuilder().enableRemoveIsPrefix().idType(IdType.AUTO).convertFileName(s -> s + "DO").disableSerialVersionUID().enableFileOverride()
                        .enableLombok()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
