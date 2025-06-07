🏥 Evacuação e Rotas Seguras em Situações de Risco- Spring Boot + MongoDB + Azure DevOps
Este projeto é uma aplicação web construída com Java e Spring Boot, focada no gerenciamento de médicos e pacientes. Os dados são armazenados em um banco de dados MongoDB Atlas na nuvem e a aplicação é implementada automaticamente no Azure App Service através de uma pipeline de CI/CD no Azure DevOps.

🚀 Tecnologias Empregadas
Java 17

Spring Boot 3

MongoDB Atlas (banco de dados em nuvem)

Azure App Service (deploy em nuvem)

Azure DevOps (integração contínua e entrega contínua)

Gradle (gestão de build)

Thymeleaf (renderização de templates HTML)

✅ Passos para Testar a Aplicação no Azure DevOps
1. Faça o Clone do Repositório:
bash
Copiar
git clone https://github.com/seu-usuario/sprint04-java.git
2. Configuração no Azure DevOps:
Acesse o Azure DevOps e crie um novo projeto.

Em seguida, crie uma pipeline apontando para o repositório GitHub.

Verifique se o arquivo azure-pipelines.yml está na raiz do repositório.

3. Conecte sua Conta do Azure:
No Project Settings, vá para Service Connections e crie uma conexão chamada MyAzureSubscription.

4. Execute a Pipeline:
A pipeline fará as seguintes etapas:

Criar o grupo de recursos, plano e o serviço App Service.

Realizar o build do arquivo .jar.

Fazer o deploy da aplicação no seguinte endereço:

https://

5. Testando as Funcionalidades:
Acesse /medicos/novo para cadastrar um novo médico.

Acesse /pacientes/novo para cadastrar um novo paciente.

Verifique se os dados foram corretamente salvos no MongoDB Atlas nas coleções medicos e pacientes.

🌐 Banco de Dados MongoDB Atlas
Banco: odontoprevdb

Coleções Criadas:

medicos

pacientes

📁 Scripts JSON (para APIs REST)
Como a aplicação utiliza Thymeleaf e formulários HTML, não há necessidade de scripts JSON.

📌 Observações Importantes para o Professor
O tempo de deploy pode variar entre 1 a 2 minutos na primeira execução.

O sistema foi testado, e as funcionalidades de cadastro, edição e exclusão estão funcionando corretamente.

A arquitetura segue o padrão MVC e a validação de dados está integrada.

👨‍💻 Desenvolvedores
Igor Oviedo

Thiago Carrilo

Cauã
