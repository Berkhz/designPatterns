using Adapter.src.Repositorio;

public class PessoaCsvAdapter : IRepositorioDePessoas
{
    private readonly string _caminhoArquivo;

    public PessoaCsvAdapter(string caminhoArquivo)
    {
        _caminhoArquivo = caminhoArquivo;
    }

    public List<Pessoa> ListarPessoas()
    {
        var pessoas = new List<Pessoa>();
        var linhas = File.ReadAllLines(_caminhoArquivo);

        for (int i = 1; i < linhas.Length; i++)
        {
            var partes = linhas[i].Split(',');
            var nome = partes[0];
            var idade = int.Parse(partes[1]);
            var email = partes[2];

            pessoas.Add(new Pessoa(nome, idade, email));
        }

        return pessoas;
    }
}