Funcionalidade: Validar cadastro com sucesso
Dado que acesso formulário para cadastro
E preencho campos obrigatórios com dados válidos
Quando clico em Cadastrar
Então o cadastro deverá ser realizado com sucesso
E uma tabela será exibida com os dados do usuário

Funcionalidade: Validar mensagens obrigatório
Dado que acesso formulário para cadastro
E não preencho o <campo>
Quando clico em Cadastrar
Então é exibido a <mensagem>

Exemplos:
<campo> | <mensagem>
Nome    | O campo Nome é obrigatório
E-mail  | O campo E-mail é obrigatório
Senha   | O campo Senha é obrigatório

Funcionalidade: Clicar em Cadastrar sem informar dados
Dado que acesso o formulário de cadastro
Quando clico em Cadastrar sem informar os dados
Então é exibido a <mensagem> para o <campo>

Exemplos:
<campo> | <mensagem>
Nome    | O campo Nome é obrigatório
E-mail  | O campo E-mail é obrigatório
Senha   | O campo Senha é obrigatório

Funcionalidade: Realizar exclusão de usuário
Dado que realizo o cadastro com sucesso
E visualizo a tabela dos usuários cadastrados
Quando clico em Excluir
Então o registro é excluído com sucesso
Mas os demais permanecem em exibição
