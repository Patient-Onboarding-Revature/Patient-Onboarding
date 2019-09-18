#!/bin/sh
sudo yum -y update
sudo yum -y install java-1.8.0-openjdk
sudo yum -y install java-1.8.0-openjdk-devel

sudo yum -y install maven

curl -fsSL https://get.docker.com/ | sh
sudo systemctl start docker
sudo systemctl enable docker

curl --silent --location http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo | sudo tee /etc/yum.repos.d/jenkins.repo
sudo rpm --import https://jenkins-ci.org/redhat/jenkins-ci.org.key
sudo yum install jenkins
sudo systemctl start jenkins
sudo systemctl enable jenkins
