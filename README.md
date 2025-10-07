# AppContaBanco

Sistema bancário acadêmico em Java para demonstração de regras de negócio e testes unitários.

+ Regras de Negócio
  - Depósito: Valor deve ser positivo, bloqueia valores ≤ 0
  -  Saque: Valor positivo + saldo suficiente, bloqueia saldo insuficiente ou valor ≤ 0
  -  Criação de Conta: Titular obrigatório, Saldo inicial não pode ser negativo
 
+ Testes
  - mvn test
 
+ Executar
  - no bash:
    - mvn compile
    - mvn exec:java -Dexec.mainClass="org.contabancotest.com.App"
  - no intellij: maven -> lifecycle -> test
 
+ Tecnologias:
  - Java 17 • Maven • JUnit 5
+ Foco:
  -Regras de negócio + Testes unitários

![Descrição da Imagem](https://github.com/reinaldolds/AppConta_B_Test/blob/main/img/test1app.png)

![Descrição da Imagem](https://github.com/reinaldolds/AppConta_B_Test/blob/main/img/test2app.png)
)
