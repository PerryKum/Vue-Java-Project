chcp 65001

@echo off

echo ����Ϣ������target

%~d0
cd %~dp0

cd ..
call mvn clean

pause