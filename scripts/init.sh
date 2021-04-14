#!/usr/bin/env bash
#updating repositories
apt-get update
#installing jdk
apt install openjdk-8-jdk -y
#installing git
apt install git -y
#installing mysql
apt install mysql-server -y
#allowing remote access to mysql
vim /etc/mysql/mysql.conf.d/mysqld.cnf
# change bind-address = 0.0.0.0

#adding privileges for remote access
mysql -u root
# execute mysql.sql script

#installing tomcat

wget https://apache-mirror.rbc.ru/pub/apache/tomcat/tomcat-8/v8.5.63/bin/apache-tomcat-8.5.63.tar.gz
tar -xf apache-tomcat-8.5.63.tar.gz
cd apache-tomcat-8.5.63/conf
## vim tomcat-users.xml and add admin roles (tomcat-users.xml)
cd  /webapps/manager/META-INF/context.xml comment Valve tag