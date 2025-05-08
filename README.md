Padrão de Projeto: Adapter (C#)

Este projeto tem como objetivo demonstrar o uso do Padrão de Projeto Adapter em C#. O padrão Adapter permite que duas interfaces incompatíveis trabalhem juntas ao criar um “adaptador” que traduz a interface de uma classe em outra que o cliente espera.

👥 Integrantes
	•	Kauan Henrique Bertalha – RA: 22262074-2
	•	Matheus Toscano Rossini – RA: 22212262-2

📁 Estrutura e Classes

Entidade/Pessoa.cs

Classe que representa uma pessoa com seus atributos, como nome e idade.

Entidade/PessoaCsvAdapter.cs

Classe adaptadora que converte dados no formato CSV para objetos do tipo Pessoa, implementando a interface de repositório.

Repositorio/IRepositorioDePessoas.cs

Interface que define os métodos esperados para repositórios de pessoas, como obtenção de dados.

Testes/PessoaCsvAdapterTeste.cs

Classe de teste que valida o comportamento da adaptação de dados CSV para objetos Pessoa.

Program.cs

Classe principal que executa o exemplo, simulando o uso do adapter para ler e utilizar dados de pessoas.

🧪 Como Executar
	1.	Abra o projeto no Visual Studio ou VS Code.
	2.	Compile e execute o projeto a partir da Program.cs.
	3.	Verifique os testes na pasta Testes se desejar validar a lógica do adapter.

📝 Licença

Este projeto está licenciado sob os termos do arquivo LICENSE.
