#updating repositories
apt-get update
#installing jdk
apt install openjdk-8-jdk -y
#installing git
apt install git -y
#updating repositories
apt-get update
#installing tools before fetching docker
apt-get install apt-transport-https ca-certificates curl  gnupg - y

#installing more tools before installing docker
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
#for docker
echo "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
#updaing repositories
apt-get update
#finally installing docker
apt-get install docker-ce docker-ce-cli containerd.io -y
