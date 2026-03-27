# language: pt

@login
Funcionalidade: Login
  Eu como usuário do sistema
  Quero fazer login
  Para fazer uma compra no site

  @login-sucesso @run
  Cenário: Login com sucesso
    Dado que estou na tela de login
    Quando preencho login "eduardo.finotti@qazando.com" e senha "123456"
    E clico em Login
    Então vejo mensagem de login com sucesso

  @login-invalido @run
  Esquema do Cenário: Validar: <name>
    Dado que estou na tela de login
    Quando preencho login "<user>" e senha "<password>"
    E clico em Login
    Então vejo mensagem "<message>" de campo não preenchido

    Exemplos:
      | user                | password | message          | name            |
      | emailinvalido       | 123456   | E-mail inválido. | E-mail inválido |
      |                     | 123456   | E-mail inválido. | E-mail vazio    |
      | eduardo@qazando.com | 000      | Senha inválida.  | Senha inválida  |
      | eduardo@qazando.com |          | Senha inválida.  | Senha vazia     |


#
#  @email-invalido
#  Cenário: Campo e-mail inválido
#    Quando preencho login "emailinvalido" e senha "123456"
#    E clico em Login
#    Então vejo mensagem "E-mail inválido." de campo não preenchido
#
#  @email-vazio
#  Cenário: Campo e-mail vazio
#    Quando preencho login "" e senha "123456"
#    E clico em Login
#    Então vejo mensagem "E-mail inválido." de campo não preenchido
#
#
#  @senha-invalida
#  Cenário: Campo senha inválida
#    Quando preencho login "eduardo.finotti@qazando.com" e senha "000"
#    E clico em Login
#    Então vejo mensagem "Senha inválida." de campo não preenchido
#
#  @senha-vazia
#  Cenário: Campo senha vazia
#    Quando preencho login "eduardo.finotti@qazando.com" e senha ""
#    E clico em Login
#    Então vejo mensagem "Senha inválida." de campo não preenchido
