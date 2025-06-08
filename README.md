🌍 Sistema de Evacuação e Roteamento Seguro em Situações Críticas - Spring Boot + MongoDB + Azure DevOps
Este projeto apresenta uma aplicação web desenvolvida em Java com Spring Boot, focada em otimizar o gerenciamento de médicos e pacientes durante situações de risco. A aplicação utiliza o MongoDB Atlas para persistir os dados na nuvem, e o deployment é realizado no Azure App Service com a automação proporcionada pela pipeline de CI/CD configurada no Azure DevOps.

🚀 Tecnologias Utilizadas
Java 17: Linguagem utilizada para o desenvolvimento da aplicação.

Spring Boot 3: Framework utilizado para construção do backend.

MongoDB Atlas: Banco de dados na nuvem para armazenamento dos dados dos médicos e pacientes.

Azure App Service: Serviço de nuvem utilizado para hospedar a aplicação.

Azure DevOps: Ferramenta para integração contínua e entrega contínua (CI/CD).

Gradle: Gerenciador de builds utilizado no projeto.

Thymeleaf: Motor de templates para renderizar as páginas HTML.

✅ Passos para Implantar a Aplicação no Azure DevOps
1. Clone o Repositório:
   bash
   Copy
   git clone https://github.com/seu-usuario/sistema-evacuacao-rotas.git
2. Configuração do Azure DevOps:
   Acesse o Azure DevOps e crie um novo projeto.

Crie uma pipeline que aponte para o repositório do GitHub.

Verifique a existência do arquivo azure-pipelines.yml na raiz do repositório.

3. Conecte Sua Conta do Azure:
   No Project Settings do Azure DevOps, vá até Service Connections e crie uma nova conexão com a sua conta do Azure, nomeando-a como MinhaConexaoAzure.

4. Execução da Pipeline:
   A pipeline executará as seguintes etapas:

Criação do grupo de recursos, plano de serviço e o serviço de App Service.

Realização do build do arquivo .jar com o Gradle.

Deploy da aplicação no endereço configurado do Azure App Service.

5. Testando a Aplicação:
   Acesse a URL /medicos/novo para adicionar um novo médico.

Acesse a URL /pacientes/novo para cadastrar um novo paciente.

Verifique se os dados estão sendo corretamente armazenados nas coleções medicos e pacientes do MongoDB Atlas.

🌐 Banco de Dados no MongoDB Atlas
Banco de Dados: evacuacaoDB

Coleções Criadas:

medicos: Armazena informações dos médicos cadastrados.

pacientes: Armazena informações dos pacientes registrados.

📁 Scripts de API (REST)
A aplicação utiliza Thymeleaf para renderizar formulários HTML, portanto, não é necessário utilizar scripts JSON para interagir com a aplicação no lado do cliente.

📌 Considerações Importantes para Avaliação
O tempo de deploy pode variar entre 1 a 2 minutos na primeira execução da pipeline.

A aplicação foi validada, e as funcionalidades de cadastro, edição e exclusão de médicos e pacientes estão funcionando corretamente.

A arquitetura do sistema segue o padrão MVC, e a validação dos dados está implementada de forma eficiente.

👨‍💻 Desenvolvedores
Igor Oviedo

Thiago Carrilo

Cauã Oliveira