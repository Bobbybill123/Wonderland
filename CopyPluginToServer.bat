@echo off
ROBOCOPY %~1 %~2 %~3 /is /it /mov
ping 127.0.0.1 -n 3 > nul