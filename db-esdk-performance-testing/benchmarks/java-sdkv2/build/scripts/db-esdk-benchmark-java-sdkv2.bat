@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  db-esdk-benchmark-java-sdkv2 startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and DB_ESDK_BENCHMARK_JAVA_SDKV2_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\db-esdk-benchmark-java-sdkv2.jar;%APP_HOME%\lib\aws-database-encryption-sdk-dynamodb-3.9.0-SNAPSHOT.jar;%APP_HOME%\lib\aws-cryptographic-material-providers-1.11.2-SNAPSHOT.jar;%APP_HOME%\lib\conversion-0.1.1.jar;%APP_HOME%\lib\DafnyRuntime-4.9.0.jar;%APP_HOME%\lib\dynamodb-enhanced-2.30.18.jar;%APP_HOME%\lib\dynamodb-2.31.48.jar;%APP_HOME%\lib\kms-2.31.48.jar;%APP_HOME%\lib\netty-nio-client-2.31.48.jar;%APP_HOME%\lib\netty-codec-http2-4.1.118.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.118.Final.jar;%APP_HOME%\lib\netty-handler-4.1.118.Final.jar;%APP_HOME%\lib\netty-codec-4.1.118.Final.jar;%APP_HOME%\lib\netty-transport-classes-epoll-4.1.118.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.118.Final.jar;%APP_HOME%\lib\netty-transport-4.1.118.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.118.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.118.Final.jar;%APP_HOME%\lib\netty-common-4.2.9.Final.jar;%APP_HOME%\lib\commons-cli-1.5.0.jar;%APP_HOME%\lib\snakeyaml-2.0.jar;%APP_HOME%\lib\jackson-databind-2.15.2.jar;%APP_HOME%\lib\aws-json-protocol-2.31.48.jar;%APP_HOME%\lib\aws-core-2.31.48.jar;%APP_HOME%\lib\auth-2.31.48.jar;%APP_HOME%\lib\regions-2.31.48.jar;%APP_HOME%\lib\protocol-core-2.31.48.jar;%APP_HOME%\lib\sdk-core-2.31.48.jar;%APP_HOME%\lib\http-auth-aws-2.31.48.jar;%APP_HOME%\lib\http-auth-2.31.48.jar;%APP_HOME%\lib\http-auth-spi-2.31.48.jar;%APP_HOME%\lib\apache-client-2.31.48.jar;%APP_HOME%\lib\http-client-spi-2.31.48.jar;%APP_HOME%\lib\json-utils-2.31.48.jar;%APP_HOME%\lib\identity-spi-2.31.48.jar;%APP_HOME%\lib\metrics-spi-2.31.48.jar;%APP_HOME%\lib\retries-2.31.48.jar;%APP_HOME%\lib\retries-spi-2.31.48.jar;%APP_HOME%\lib\profiles-2.31.48.jar;%APP_HOME%\lib\checksums-2.31.48.jar;%APP_HOME%\lib\utils-2.31.48.jar;%APP_HOME%\lib\endpoints-spi-2.31.48.jar;%APP_HOME%\lib\checksums-spi-2.31.48.jar;%APP_HOME%\lib\http-auth-aws-eventstream-2.31.48.jar;%APP_HOME%\lib\annotations-2.31.48.jar;%APP_HOME%\lib\third-party-jackson-core-2.31.48.jar;%APP_HOME%\lib\bcprov-jdk18on-1.83.jar;%APP_HOME%\lib\jackson-annotations-2.15.2.jar;%APP_HOME%\lib\jackson-core-2.15.2.jar;%APP_HOME%\lib\slf4j-api-1.7.36.jar;%APP_HOME%\lib\reactive-streams-1.0.4.jar;%APP_HOME%\lib\eventstream-1.0.1.jar;%APP_HOME%\lib\httpclient-4.5.13.jar;%APP_HOME%\lib\httpcore-4.4.16.jar;%APP_HOME%\lib\commons-codec-1.17.1.jar;%APP_HOME%\lib\commons-logging-1.2.jar


@rem Execute db-esdk-benchmark-java-sdkv2
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %DB_ESDK_BENCHMARK_JAVA_SDKV2_OPTS%  -classpath "%CLASSPATH%" com.amazon.dbesdk.benchmark.Program %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable DB_ESDK_BENCHMARK_JAVA_SDKV2_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%DB_ESDK_BENCHMARK_JAVA_SDKV2_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
