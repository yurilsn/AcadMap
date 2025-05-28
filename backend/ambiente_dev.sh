#!/usr/bin/env bash

read -p "Clique em Y caso não possua o apache maven na sua máquina para instala-lo, caso possua clique em N (Y/N): " confirmacao


if [[ "Yy" == *"${confirmacao^^}"* ]] || [[ "" == *"${confirmacao^^}"* ]]; then

    sudo apt install maven

fi


read -p "Clique em Y caso não possua o sdkman na sua máquina para instala-lo, caso possua clique em N (Y/N): " confirmacao

if [[ "Yy" == *"${confirmacao^^}"* ]] || [[ "" == *"${confirmacao^^}"* ]]; then

    curl -s "https://get.sdkman.io" | bash

    source "$HOME/.sdkman/bin/sdkman-init.sh"

    sdk version

    sdk install java 17.0.12-oracle

fi


read -p "Clique em Y caso não possua o intellij na sua máquina para instala-lo, caso possua ou prefere usar sua própria IDE(configure por sua própria conta) clique em N (Y/N):" confirmacao

if [[ "Yy" == *"${confirmacao^^}"* ]] || [[ "" == *"${confirmacao^^}"* ]]; then

    sudo snap install intellij-idea-ultimate --classic

fi


read -p "Clique em Y caso não possua o docker na sua máquina para instala-lo, caso possua clique em N (Y/N): " confirmacao

if [[ "Yy" == *"${confirmacao^^}"* ]] || [[ "" == *"${confirmacao^^}"* ]]; then

    for pkg in docker.io docker-doc docker-compose docker-compose-v2 podman-docker containerd runc; do sudo apt-get remove $pkg; done

    sudo apt-get update
    sudo apt-get install ca-certificates curl
    sudo install -m 0755 -d /etc/apt/keyrings
    sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
    sudo chmod a+r /etc/apt/keyrings/docker.asc

    echo \
      "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
      $(. /etc/os-release && echo "${UBUNTU_CODENAME:-$VERSION_CODENAME}") stable" | \
      sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
    sudo apt-get update

    sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

    sudo groupadd docker

    echo "sudo usermod -aG docker $USER"

    sudo usermod -aG docker $USER

    echo "newgrp docker"

    newgrp docker

fi