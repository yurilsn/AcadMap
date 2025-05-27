# Documentação do Ambiente Spring Boot

## Objetivo
Esta documentação tem como objetivo orientar a configuração do ambiente para desenvolvimento com **Spring Boot**. Ela é voltada para quem ainda não está familiarizado com a montagem do ambiente. Caso você já tenha experiência, basta verificar as ferramentas necessárias.

Serão disponibilizados scripts de instalação e desinstalação para distribuições baseadas em **Debian**. Observação: Não há suporte para outras distribuições Linux ou Windows.

---

## Ferramentas Necessárias

### Java 17
- **Descrição**: Necessário para compilar o código Java.

### Apache Maven
- **Descrição**: Ferramenta para gerenciamento de dependências e automação do build em projetos Java.
- **Observação**: Não é obrigatória se você usar o IntelliJ IDEA, pois a IDE possui ferramentas internas para build.

### Docker
- **Descrição**: Usado para gerenciamento de contêineres. No contexto desta documentação, será utilizado para instanciar um banco de dados **PostgreSQL**.
- **Caso de uso**: Ideal para desenvolvimento local com bancos de dados em container.

### IntelliJ IDEA (IDE Opcional)
- **Descrição**: Ambiente de desenvolvimento integrado (IDE) para facilitar a programação e execução local da aplicação.
- **Vantagens**: 
  - Facilita a configuração do projeto.
  - Oferece ferramentas integradas para build e execução.

---

## Como Executar o Script de Instalação

1. **Acesse o terminal do Linux**.
2. **Navegue até a pasta** onde está o arquivo `ambiente_dev.sh`.
3. **Defina permissão de execução** com o comando:
   ```bash
   chmod +x ambiente_dev.sh
