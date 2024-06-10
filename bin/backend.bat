chcp 65001

@echo off

echo 【信息】启动Redis
start cmd /k redis-server
echo 【信息】Redis已在新的窗口启动，请勿关闭！
timeout /t 5 /nobreak


echo 【信息】启动后端
cd %~dp0
cd ../leadec-admin/target

set JAVA_OPTS=-Xms256m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

java -jar %JAVA_OPTS% leadec-admin.jar