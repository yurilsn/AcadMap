#!/usr/bin/env bash
 

read -p "Deseja desinstalar o docker da sua máquina ? (Y/N): " confirmacao
if [[ "Yy" == *"${confirmacao^^}"* ]] || [[ "" == *"${confirmacao^^}"* ]]; then

    sudo apt-get purge docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin docker-ce-rootless-extras

    sudo rm -rf /var/lib/docker
    sudo rm -rf /var/lib/containerd

    sudo rm /etc/apt/sources.list.d/docker.list
    sudo rm /etc/apt/keyrings/docker.asc

fi

read -p "Deseja desinstalar o apache maven da sua máquina ? (Y/N): " confirmacao

if [[ "Yy" == *"${confirmacao^^}"* ]] || [[ "" == *"${confirmacao^^}"* ]]; then

    sudo apt remove maven

    sudo apt autoremove

fi

read -p "Deseja desinstalar o sdkman da sua máquina ? (Y/N): " confirmacao

if [[ "Yy" == *"${confirmacao^^}"* ]] || [[ "" == *"${confirmacao^^}"* ]]; then

    tar zcvf ~/sdkman-backup_$(date +%F-%kh%M).tar.gz -C ~/ .sdkman
    rm -rf ~/.sdkman

    [[ -s "/home/dudette/.sdkman/bin/sdkman-init.sh" ]] && source "/home/dudette/.sdkman/bin/sdkman-init.sh"

fi