chcp 65001

@echo off

echo 【信息】清理target

%~d0
cd %~dp0

cd ..
call mvn clean

pause