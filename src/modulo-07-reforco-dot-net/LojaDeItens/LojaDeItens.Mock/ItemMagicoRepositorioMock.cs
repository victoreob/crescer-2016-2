using LojaDeItens.Dominio.ItemMagico;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaDeItens.Mock
{
    public class ItemMagicoRepositorioMock : IItemMagicoRepositorio
    {
        private static IList<ItemMagicoEntidade> itens = new List<ItemMagicoEntidade>()
        {
            new ItemMagicoEntidade()
            {
                Id = 1,
                Nome = "Cajado de Bola de Fogo",
                Preco = 5000.99m,
                Estoque = 4,
                DataCriacao = DateTime.Now,
                DataUltimaAtualizacao = DateTime.Now,
                Descricao = "Um cajado fodástico!",
                Raro = true
            },
            new ItemMagicoEntidade()
            {
                Id = 2,
                Nome = "Pena de Ganso",
                Preco = 2m,
                Estoque = 12312312,
                DataCriacao = DateTime.Now,
                DataUltimaAtualizacao = DateTime.Now,
                Descricao = "Gansos feroses!",
                Raro = false
            }
        };

        public void Atualizar(ItemMagicoEntidade item)
        {
            throw new NotImplementedException();
        }

        public ItemMagicoEntidade BuscarPorId(int id)
        {
            throw new NotImplementedException();
        }

        public IList<ItemMagicoEntidade> BuscarPorNome(string nome)
        {
            throw new NotImplementedException();
        }

        public IList<ItemMagicoEntidade> BuscarPorRaridade(bool raro)
        {
            return itens.Where(i => i.Raro == raro).ToList();
        }

        public IList<ItemMagicoEntidade> BuscarTodos()
        {
            return itens;
        }

        public void Criar(ItemMagicoEntidade item)
        {
            throw new NotImplementedException();
        }
    }
}
