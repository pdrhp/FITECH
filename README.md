
![Logo](https://i.imgur.com/K85Fw7J.png)


# FITECH (WIP)

FITECH é um aplicativo com a premissa de ajudar o usuário em suas atividades fisicas.

Este aplicativo foi desenvolvido para fins academicos e de aprendizados.

## Referência

 - [Documentação Firebase](https://firebase.google.com/docs?hl=pt-br)
 - [API Fitness Calculator](https://rapidapi.com/malaaddincelik/api/fitness-calculator/details)


## Aprendizados

Este projeto serviu de exercicios para fixar conceitos do Kotlin e desenvolvimento android, neste projeto foi usado os seguintes conceitos e funcionalidades:

- Exibição de dados utilizando TextView e ListView.

- Captura de informações utilizando EditText, Checkbox e Spinner's.

- Exibição de mídia com ImageView e VideoView.

- Persistencia de dados utilizando SQlite para armazenar calculos e resultados anteriores do usuário.

- Integração com serviço externo utilizando a biblioteca OkHttp para realizar requisições HTTP.

- Criação de adapters para lista personalizadas

- Serviço de autenticação via email e senha utilizando o serviço Google Firebase.

- Navegação de tela utilizando intents.
## Funcionalidades

- Autenticação utilizando E-mail e Senha
- Calculadora de IMC, que possui um historico de calculos anteriores utilizando SQlite
- Lista de atividades fisicas para membros superiores, inferiores e abdominais.
- Cada item da lista possui um video e uma descrição do exercicio
- Calculadora de calorias diarias (Utilizando Requisições HTTP)



## Rodando localmente

1. Clone o projeto

```bash
git clone https://github.com/pdrhp/FITECH/
```

2. É necessario adicionar o arquivo de configuração `google-services.json` no projeto e habilitar a seção Auth no console do Firebase pela sua conta

- [Passo a passo para configurar o FirebaseAuth no projeto](https://firebase.google.com/docs/auth/android/password-auth?hl=pt-br#before_you_begin)

3. Depois é necessario criar uma conta no site [RapidAPI](https://rapidapi.com/), e se inscrever para usar a API [Fitness Calculator](https://rapidapi.com/malaaddincelik/api/fitness-calculator)

4. Copie sua API key indo no dashboard da RapidAPI ([rapidapi.com/developer/dashboard](https://rapidapi.com/developer/dashboard)), va na aba de My apps, e entre na parte de Authentication da sua aplicação.

5. Cole sua API key no arquivo `local.properties` desta maneira:
```
API_KEY = "SUA_API_KEY_AQUI"
```

6. Sincronize o projeto, e rode a aplicação no Emulador para verificar se tudo está certo.

## Demonstração

https://github.com/pdrhp/FITECH/assets/34948480/673fab1f-6bf3-4e99-afc4-f9336383d1b5

https://github.com/pdrhp/FITECH/assets/34948480/f6ffdfc2-06b8-4146-bbbe-dfe358ce80d4

https://github.com/pdrhp/FITECH/assets/34948480/466a5893-f1e8-4d5c-8afd-5732e838ef4a

https://github.com/pdrhp/FITECH/assets/34948480/cd67867d-d8b1-4c03-ba8c-3c634be812b4

https://github.com/pdrhp/FITECH/assets/34948480/8d1eb9f2-02f1-4407-8e08-6c73e1e14331

https://github.com/pdrhp/FITECH/assets/34948480/2bd388c5-a1bf-4506-a452-ce87a26ccb53












