# Projeto de POO — Linha de Produção de Equipamentos de Telecomunicações

## 1. Identificação do Projeto

**Disciplina:** C06 – Programação Orientada a Objetos  
**Projeto:** Projeto Final – NP2  
**Professor:** Christopher Lima  
**Área:** Telecomunicações/Produção  
**Linguagem de programação:** Java

### Integrantes

- **Arthur Euflasio Brentegani de Sousa** — GET: 9863
- **Flávia Lima** — Matrícula: 217 — GEP
- **Jaime Liz Eduardo** — Matrícula: 141 — GEP

---

## 2. Descrição do Projeto

O projeto consiste no desenvolvimento de um sistema de gerenciamento de uma linha de produção de equipamentos de telecomunicações.

A aplicação tem como objetivo organizar o processo de produção, permitindo que o usuário selecione os equipamentos desejados, informe suas respectivas quantidades e registre os pedidos em arquivos de texto.

Após o registro, os pedidos são encaminhados para a linha de produção, responsável por identificar cada equipamento e direcioná-lo às etapas de processamento correspondentes.

O sistema foi desenvolvido utilizando os conceitos de Programação Orientada a Objetos, buscando representar as características e os comportamentos dos equipamentos por meio de classes, herança, interfaces e polimorfismo.

## 3. Equipamentos Produzidos

O sistema trabalha com três tipos de equipamentos de telecomunicações:

### 3.1 Antena

Representa uma antena de telecomunicações. Implementa as interfaces `Configuracao`, `Inspecao` e `Teste`, participando das etapas de configuração, inspeção e teste de funcionamento.

### 3.2 Fibra Óptica

Representa um cabo de fibra óptica utilizado em sistemas de comunicação. Implementa as interfaces `Inspecao` e `Teste`, participando das etapas de inspeção e teste de funcionamento.

### 3.3 Roteador

Representa um equipamento responsável pelo encaminhamento de dados em redes de comunicação. Implementa as interfaces `Configuracao`, `Inspecao` e `Teste`, participando das etapas de configuração, inspeção e teste de funcionamento.

---

## 4. Funcionamento do Sistema

O funcionamento da aplicação é dividido em etapas:

1. **Inicialização:** o programa apresenta um menu para interação com o usuário.
2. **Seleção dos equipamentos:** o usuário escolhe quais equipamentos deseja produzir.
3. **Definição das quantidades:** são informadas as quantidades de cada equipamento.
4. **Criação do pedido:** os equipamentos selecionados são organizados em uma lista.
5. **Registro em arquivo:** a classe `PedidoArquivo` salva as informações do pedido em um arquivo de texto.
6. **Leitura do pedido:** a linha de produção recebe o caminho do arquivo e realiza a leitura dos equipamentos solicitados.
7. **Identificação dos equipamentos:** a classe `LinhaDeProducao` identifica os códigos e instancia os objetos correspondentes.
8. **Processamento:** a classe `EsteiraProducao` verifica quais interfaces cada equipamento implementa e executa as respectivas etapas.
9. **Finalização:** o sistema conclui o processamento dos equipamentos e informa o resultado da produção.

---

## 5. Organização das Classes

### 5.1 Equipamento

A classe abstrata `Equipamento` representa a estrutura genérica dos equipamentos produzidos.

Ela possui atributos responsáveis por armazenar o nome e o identificador de cada equipamento, além de um contador estático utilizado para gerar identificadores.

Também define o método abstrato `getTipo()`, que deve ser implementado pelas classes específicas.

### 5.2 Classes específicas

As classes `Antena`, `FibraOptica` e `Roteador` herdam da classe abstrata `Equipamento`.

Cada uma representa um equipamento específico e implementa os comportamentos necessários de acordo com as interfaces utilizadas.

### 5.3 Interfaces

O projeto utiliza três interfaces para representar as etapas do processo produtivo:

- `Configuracao`: representa a etapa de configuração dos equipamentos.
- `Inspecao`: representa a etapa de inspeção.
- `Teste`: representa a etapa de teste de funcionamento.

Cada equipamento implementa somente as interfaces correspondentes às etapas das quais participa.

### 5.4 EsteiraProducao

A classe `EsteiraProducao` é responsável por executar as etapas de produção dos equipamentos.

Para identificar quais operações devem ser realizadas, utiliza o operador `instanceof`, verificando quais interfaces são implementadas pelo equipamento.

Dessa maneira, cada equipamento executa somente as etapas compatíveis com suas características.

### 5.5 LinhaDeProducao

A classe `LinhaDeProducao` controla o fluxo de produção.

Ela recebe o arquivo do pedido, realiza a leitura dos códigos dos equipamentos, instancia os objetos correspondentes e encaminha cada um para a esteira de produção.

### 5.6 ExcecaoProducao

A classe `ExcecaoProducao` representa uma exceção personalizada do sistema, utilizada para tratar situações excepcionais relacionadas ao processo de produção.

### 5.7 PedidoArquivo

A classe `PedidoArquivo` é responsável pela manipulação dos arquivos de pedidos.

Suas principais responsabilidades são:

- Criar a pasta destinada ao armazenamento dos pedidos, quando necessário.
- Salvar os equipamentos selecionados em arquivos de texto.
- Gerar nomes de arquivos com data e horário para evitar sobrescritas.
- Ler os pedidos armazenados.
- Informar erros relacionados à manipulação dos arquivos.

### 5.8 Main

A classe `Main` é responsável pela interação com o usuário e pela inicialização do sistema.

Ela apresenta o menu principal, recebe as escolhas, coleta as quantidades dos equipamentos, solicita o registro do pedido e encaminha o arquivo para a linha de produção.

---

## 6. Conceitos de Programação Orientada a Objetos

O projeto utiliza os seguintes conceitos de Programação Orientada a Objetos:

### 6.1 Encapsulamento

Os atributos da classe `Equipamento` são privados, protegendo os dados internos dos objetos. O acesso às informações ocorre por meio dos métodos disponibilizados pela classe.

### 6.2 Herança

As classes `Antena`, `FibraOptica` e `Roteador` herdam características da classe abstrata `Equipamento`, evitando a repetição de atributos e comportamentos comuns.

### 6.3 Polimorfismo

O polimorfismo permite trabalhar com diferentes tipos de equipamentos utilizando uma referência do tipo genérico `Equipamento`.

Dessa forma, diferentes objetos podem ser tratados por uma estrutura comum, mantendo seus comportamentos específicos.

### 6.4 Classes abstratas

A classe `Equipamento` é abstrata e define uma estrutura comum para os equipamentos, impedindo sua instanciação direta e exigindo que as classes específicas implementem o método abstrato `getTipo()`.

### 6.5 Interfaces

As interfaces `Configuracao`, `Inspecao` e `Teste` definem contratos de comportamento para as etapas de produção.

As classes específicas implementam as interfaces necessárias, permitindo que a esteira identifique e execute as operações correspondentes.

### 6.6 Tratamento de exceções

O projeto utiliza mecanismos de tratamento de exceções para lidar com situações inesperadas durante a execução.

São utilizados recursos como `try-catch`, `finally`, `throw` e `throws`, além de exceções personalizadas e exceções relacionadas à entrada e saída de arquivos.

---

## 7. Manipulação de Arquivos

O sistema utiliza arquivos de texto (`.txt`) para armazenar os pedidos de produção.

Cada equipamento solicitado é registrado no arquivo, permitindo que a linha de produção recupere posteriormente as informações e realize o processamento.

Os arquivos são armazenados na pasta `pedidos`, criada automaticamente quando necessário.

Essa abordagem permite manter os registros dos pedidos sem a necessidade de utilizar um banco de dados.

---

## 8. Tecnologias e Recursos Utilizados

- **Java:** linguagem utilizada no desenvolvimento da aplicação.
- **Programação Orientada a Objetos:** organização do sistema em classes e objetos.
- **Interfaces e classes abstratas:** definição de estruturas e comportamentos.
- **Manipulação de arquivos:** armazenamento e leitura dos pedidos.
- **Tratamento de exceções:** controle de erros durante a execução.
- **Git e GitHub:** versionamento e hospedagem do código-fonte.
- **UML:** representação visual da estrutura e dos relacionamentos entre as classes.

---

## 9. Como Executar o Projeto

Para executar o projeto:

1. Tenha o Java instalado e configurado no computador.
2. Baixe ou clone o repositório do GitHub.
3. Abra o projeto em uma IDE compatível com Java.
4. Verifique a organização dos pacotes e dos arquivos `.java`.
5. Localize a classe principal `Main`.
6. Execute o método `main`.
7. Utilize o menu apresentado para selecionar os equipamentos, informar as quantidades e iniciar o processo de produção.

---



---

## 11. Utilização de Inteligência Artificial

Durante o desenvolvimento do projeto, foi utilizada a ferramenta **ChatGPT, da OpenAI, modelo GPT-6**, como recurso de apoio ao aprendizado, análise e implementação do sistema.

A inteligência artificial foi utilizada para auxiliar na compreensão da estrutura do projeto original de produção de equipamentos biomédicos e na adaptação de sua lógica para o contexto de equipamentos de telecomunicações.

### 11.1 Finalidades da utilização

A IA foi utilizada para:

- Analisar e comparar a organização dos projetos de produção de equipamentos biomédicos e de telecomunicações.
- Compreender o funcionamento das classes e interfaces.
- Explicar os conceitos de herança, encapsulamento, polimorfismo e abstração.
- Auxiliar na elaboração das classes `Main` e `PedidoArquivo`.
- Orientar a utilização de arquivos de texto para registrar os pedidos.
- Analisar e explicar os conceitos de tratamento de exceções apresentados nas aulas.
- Verificar a presença de conceitos relacionados a Threads nas classes analisadas.

### 11.2 Exemplos de prompts utilizados

Durante as conversas, foram realizadas solicitações como:

**Prompt 1 — Análise dos projetos:**

"Leia e absorva o conteúdo desses arquivos. Faça a comparação do funcionamento do projeto de linha de produção de equipamentos biomédicos com o projeto de telecomunicações, explicando o funcionamento das classes e dos equipamentos."

**Prompt 2 — Explicação das classes:**

"Explique o funcionamento da classe Equipamento e das classes específicas, mostrando como elas participam do processo de produção."

**Prompt 3 — Desenvolvimento da classe principal:**

"Desenvolva a classe Main para permitir a seleção dos equipamentos, definição das quantidades, criação dos pedidos e encaminhamento para a linha de produção."

**Prompt 4 — Manipulação de arquivos:**

"Desenvolva a classe PedidoArquivo para salvar e ler os pedidos utilizando arquivos de texto."

**Prompt 5 — Tratamento de exceções:**

"Leia o conteúdo da aula sobre exceções em Java e verifique como os conceitos apresentados podem ser aplicados na classe Main, mantendo as funcionalidades do sistema."

**Prompt 6 — Análise de Threads:**

"Leia o conteúdo da aula sobre Threads e verifique se os conceitos apresentados estão presentes no código das classes Main e PedidoArquivo."

### 11.3 Avaliação da utilização

Os resultados fornecidos pela inteligência artificial foram utilizados como apoio para compreender a lógica do sistema, estudar os conceitos de Programação Orientada a Objetos e orientar a implementação das funcionalidades.

As respostas também contribuíram para identificar a responsabilidade de cada classe e compreender o fluxo de funcionamento da linha de produção.

O uso da ferramenta não substituiu a necessidade de analisar os códigos, compreender as implementações e verificar sua compatibilidade com os requisitos do projeto.

---

## 12. Considerações Finais

O desenvolvimento deste projeto permitiu aplicar conceitos de Programação Orientada a Objetos em uma situação relacionada à área de telecomunicações.

A organização em classes, a utilização de herança, interfaces, abstração e polimorfismo possibilitaram estruturar o sistema de maneira modular, separando as responsabilidades de cada parte da aplicação.

Além disso, a manipulação de arquivos e o tratamento de exceções contribuíram para o gerenciamento dos pedidos e para o controle de situações inesperadas durante o processo de produção.

O projeto também proporcionou a oportunidade de estudar e aplicar conceitos de programação por meio de uma situação prática.