# thrift代码生成
依次执行以下命令，生成相关代码：
```shell
thrift --gen java -out ./src/main/java ./src/main/idl/base.thrift 
thrift --gen java -out ./src/main/java ./src/main/idl/account.thrift
thrift --gen java -out ./src/main/java ./src/main/idl/easy_pan_service.thrift 
```