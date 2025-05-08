using System;

class Program
{
    static void Main(string[] args)
    {
        var adapter = new PessoaCsvAdapter("pessoas.csv");
        var pessoas = adapter.ListarPessoas();

        foreach (var pessoa in pessoas)
        {
            Console.WriteLine($"Nome: {pessoa.Nome}, Idade: {pessoa.Idade}, Email: {pessoa.Email}");
        }
    }
}