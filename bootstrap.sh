#!/usr/bin/env bash

# Add Oracle Java Repo
sudo add-apt-repository ppa:webupd8team/java  -y

# update apt
sudo apt-get update

# install java
JAVA_VERSION=7

#accept the licenses
echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections && echo debconf shared/accepted-oracle-license-v1-1 seen true | sudo debconf-set-selections
sudo apt-get install --with-recommends software-properties-common -y
sudo apt-get install --with-recommends oracle-java$JAVA_VERSION-installer -y
sudo apt-get install oracle-java$JAVA_VERSION-set-default -y
 
JAVA_HOME=/usr/lib/jvm/java-$JAVA_VERSION-oracle

# MAVEN 3
sudo apt-get install maven -y

# Export to profile
echo "export JAVA_HOME=$JAVA_HOME" >> /etc/bash.bashrc
echo "export PATH=$KARAF_HOME/bin:$PATH" >> /etc/bash.bashrc

# Install NPM
curl -sL https://deb.nodesource.com/setup_4.x | sudo -E bash -
sudo apt-get install -y nodejs
