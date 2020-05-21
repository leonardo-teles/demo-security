# Spring Boot & MVC com Spring Security

Tópicos Abordados:
   - Configurar o Spring Security junto ao Spring Boot
   - Configurar o Spring Security junto ao Spring MVC
   - Configurar um sistema de autenticação baseada em login e senha
   - Configurar um sistema de autorização baseado em lista de perfis
   - Configurar um sistema de envio de e-mail para confirmação de cadastro e recuperação de senha
   - Lidar com criptografia de senha
   - Trabalhar com Thymeleaf Extras Security
   - Configurar serviço de e-mail via SMTP

  <a href="https://www.udemy.com/certificate/UC-c99e7534-c3e4-4016-a9d8-be96c83b5c14/" rel="noopener">Certificado</a> | <a href="https://my-demo-security.herokuapp.com/">Testar</a>
  
Modo de Utilização:

   - Existem dois usuários pré-cadastrados no sistema: o usuário **'administrador'** e o usuário **'médico'** que podem acessar o sistema com as seguintes credenciais: email: **admin@clinica.com.br - senha: admin** | email: **medico@clinica.com.br - senha: medico**
   
   - O **administrador** tem as seguintes funcionalidades: CRUD de especialidades, cadastro de usuários, edição de credenciais e dados pessoais de médicos e pacientes.
   
   - O **médico** tem as funcionalidades: Inclusão de dados cadastrais, vinculação com uma ou mais especialidades, editar a senha e ver sua consultas de atendimento. Um médico pode editar uma consulta, mas não pode apagá-la. Somente o paciente pode excluir uma consulta.
   
   - Para testar a aplicação como um **paciente**, você deverá realizar seu cadastro acessar o botão no topo da página. Utilize um e-mail válido.
   
   - Você receberá um e-mail enviado por **'demo.sec.sender@gmail.com'** com o título **'Confirmação de Cadastro'** e no corpo do e-mail terá um link para confirmar a ativação de sua conta. Ative sua conta e faça login.
    
   - Ao acessar a aplicação, para poder realizar um agendamento, será necessário completar seu registro clicando no menu **'Cadastrar Dados'**. Este passo é obrigatório.    
   
   - Na funcionalidade de recuperação de senha, será enviado um e-mail com um código de verificação que deverá ser inserido no formulário de alteração de senha.
   
   - O checkbox **'Remember-me'** deixará seu usuário logado na aplicação por duas semanas.