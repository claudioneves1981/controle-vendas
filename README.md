# controle-vendas

Projeto com JWT e Spring Security com banco em memoria H2 / JPA e Build via Gradle e teste de API via postman.

Tecnologias usadas

- Spring Boot
- Gradle
- Spring Security
- JWT
- H2 Database
- Postman

Acesse a pasta do projeto e execute o seguinte comando

```
./gradlew bootRun
```
o projeto irá iniciar na porta 8081

usando postman faça o login conforme exemplo usario exemplo abaixo , caso queira ver a lista de usuarios acesse o end point localhost:8081/users, a senha padrão para todos os usuarios é "123Mudar" criptografada no banco.

![image](https://user-images.githubusercontent.com/59265698/230786440-971fd7dd-fb01-44be-a312-e4f6cdf0e4bf.png)

copie o token gerado

![image](https://user-images.githubusercontent.com/59265698/230786704-83d2fe11-5bb4-4715-9497-a1522eec4622.png)

use o postman

acesse um dos endpoints colocando no header de Authorization o token copiado.

![image](https://user-images.githubusercontent.com/59265698/230786804-7a7628eb-6680-4fa1-8e23-b219c721d5e8.png)

se o usuario for autorizado vc vera a lista de usuarios basta colocar o cargo depois do endpoint escolhido, vide exemplo abaixo

```
                 endpoint   cargo
localhost:8081/directories/gerente
```

se caso não seja autorizado aparecera conforme abaixo. Forbidden

![image](https://user-images.githubusercontent.com/59265698/230787053-4835788e-c304-4a0c-8bed-38415d4c1d7d.png)

para cadastrar um novo usuario basta seguir como abaixo.

![image](https://user-images.githubusercontent.com/59265698/230790118-e0cd13c3-6fc1-4781-b158-c3de024f26c8.png)

ENDPOINTS

```

POST - localhost:8081/users 
POST - localhost:8081/login  *para gerar o token
GET - localhost:8081/users *para acessar necessita o token 
GET - localhost:8081/admin/cargo/ *para acessar necessita o token 
GET - localhost:8081/directories/cargo/ *para acessar necessita o token 
GET- localhost:8081/managers/cargo/ *para acessar necessita o token 
```

CARGOS
- DIRETORGERAL
- DIRETOR
- GERENTE
- VENDEDOR




