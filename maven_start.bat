@echo off
setlocal

cd /d"D:\\JavaServlet\\JTEST"

echo Building project...

echo Cleaning project...
call mvn clean

if errorlevel 1 (
    echo Error: Maven clean failed.
    goto :end
)

echo Installing dependencies...
call mvn install

if errorlevel 1 (
    echo Error: Maven install failed.
    goto :end
)

echo Packaging application...
call mvn package

if errorlevel 1 (
    echo Error: Maven package failed.
    goto :end
)

echo Project build completed.
