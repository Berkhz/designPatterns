using Adapter.src.Repositorio;

public class PessoaCsvAdapterTest
{
    public static void Testar()
    {
        string caminho = "pessoas.csv";

        IRepositorioDePessoas repositorio = new PessoaCsvAdapter(caminho);
        List<Pessoa> pessoas = repositorio.ListarPessoas();

        Console.WriteLine("Testando PessoaCsvAdapter:\n");

        foreach (var pessoa in pessoas)
        {
            Console.WriteLine($"Nome: {pessoa.Nome}, Idade: {pessoa.Idade}, Email: {pessoa.Email}");
        }
    }
}