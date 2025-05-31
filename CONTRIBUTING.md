# Guia de Contribuição

Este documento define como nossa equipe colabora com o projeto utilizando Git, GitHub e pull requests, organizando responsabilidades e processos entre os diferentes papéis do time.

## Estrutura da Equipe

- Líder de Backend: responsável pelo código e revisões do backend.
- Líder de Frontend: responsável pelo código e revisões do frontend.
- Desenvolvedores: responsáveis por implementar funcionalidades e correções.
- Time de Testes: responsável por validar funcionalidades antes de irem para produção.
- Arquiteto / Administrador do Repositório: gerencia configurações, políticas e merges principais.

## Estratégia de Branches

- main: código estável e pronto para produção.
- dev: código em fase de integração e testes.
- feature/*: branches específicas para novas funcionalidades ou correções.

Exemplos de nomes de branchs:

- feature/cadastro-usuario
- bug/fix-header-mobile
- chore/atualiza-dependencias

## Fluxo de Trabalho

### 1. Criação da Branch de Funcionalidade

- Sempre criar a branch a partir da dev.
- Qualquer desenvolvedor pode criar branches do tipo feature/*.

Comando sugerido:

```bash
git checkout dev
git pull
git checkout -b feature/nome-da-funcionalidade
```

### 2. Desenvolvimento

- Implementar a tarefa de forma clara e seguindo os padrões da equipe.
- Escrever mensagens de commit descritivas e objetivas.
- Testar a funcionalidade localmente. 

Exemplo:
```
git add .
git commit -m "feat: adiciona formulário de login com validações"
```

### 3. Envio da Branch para o GitHub
```
git push origin feature/nome-da-funcionalidade
```

### 4. Criação do Pull Request para dev
- Criar um Pull Request da branch feature/* para dev.
- Preencher o título e a descrição explicando o que foi implementado.
- Atribuir o líder técnico da área (backend ou frontend) como revisor.
- Preencha o seguinte checklist mental:
    - Código implementado e testado localmente
    - Sem informações sensíveis no repositório
    - CI passando corretamente

### 5. Revisão de Código (Feito pelos líderes de equipe)
- O líder da equipe respectiva revisa o código.
- Os líderes (e somente eles) podem realizar o merge de feature/* para dev.
    - Para features pequenas, bug fixes e outros commits simples, dar preferência para o "Squash and Merge", para manter a linha de commits limpa.
    - Em outros casos, utilizar Merge commit.

### 6. Validação (Time de Testes)
- Após o merge na branch dev, a funcionalidade será testada pelo time de testes.
- O time de testes valida comportamentos esperados e reporta bugs* se necessário.
    - *Os bugs serão reportado pelos testers abrindo issues no Github.
- A partir dos issues criados, os devs devem gerar novas branches corretivas (ex: bug/corrige-validação-login).
- Caso a equipe de teste não encontre nenhum erro, o PR para a main pode ser criado.

### 7. Merge de dev para main (Time de Arq.)
- O merge da dev para a main só pode ser realizado pela equipe de Arq.

## Regras de Proteção de Branch

- As branches main e dev são protegidas:
    - Push direto é bloqueado.
    - Pull requests são obrigatórios para qualquer alteração.
    - Revisão por pelo menos um líder técnico é obrigatória.
    - Execução dos testes automatizados (CI), quando aplicável, é obrigatória.

- Testes e Validação
    - Os desenvolvedores são responsáveis por testar localmente antes de abrir o PR.
    - O time de testes é responsável por validar funcionalidades integradas na branch dev.
    - Correções devem ser feitas antes da publicação na main.
        - ***SEM FUNCIONALIDADES QUEBRADAS NA MAIN!!!!***

- Manutenção do Repositório
    - Branches feature/* devem ser removidas após o merge.
    - A branch dev deve ser mantida sempre atualizada.
    - Caso uma branch de feature tenha sido mergeada na dev enquanto você ainda tinha commits pendentes na sua branch local, atualize sua branch de feature com a dev localmente (via merge) antes de enviá-la ao GitHub e abrir o PR.
        - ***NUNCA REALIZE ```git push --force```***

Em caso de dúvidas, consulte o líder da sua equipe ou alguem da equipe de Arq.