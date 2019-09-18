#!/bin/sh
echo UPDATE OS
sudo yum -y update

echo  INSTALL JAVA AND DEVELOPER ENVIRONMENT
sudo yum -y install java-1.8.0-openjdk
sudo yum -y install java-1.8.0-openjdk-devel

echo INSTALL MAVEN  
sudo yum -y install maven

echo INSTALL DOCKER
curl -fsSL https://get.docker.com/ | sh
sudo systemctl start docker
sudo systemctl enable docker

echo INSTALL JENKINS
curl --silent --location http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo | sudo tee /etc/yum.repos.d/jenkins.repo
sudo rpm --import https://jenkins-ci.org/redhat/jenkins-ci.org.key
sudo yum -y install jenkins
sudo systemctl start jenkins
sudo systemctl enable jenkins
