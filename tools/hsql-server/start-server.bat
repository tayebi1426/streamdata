@echo on
@echo ***********************************************
SETLOCAL
@rem set JAVA_HOME=d:\apps\Java\jdk1.8
@rem set path=%path%;%JAVA_HOME%\bin;
java -Xmx256m -cp ./hsqldb.jar org.hsqldb.server.Server --database.0 file:data/db --dbname.0 streamdata --port 5005
endlocal
exit
@echo ***********************************************
