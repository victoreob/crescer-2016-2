using LojaDeItens.Dominio.ItemMagico;
using LojaDeItens.Web.Models.ItemMagico;
using LojaDeItens.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using System.Web;
using System.Web.Mvc;

namespace LojaDeItens.Web.Controllers
{
    public class ItemMagicoController : Controller
    {
        private ItemMagicoServico itemMagicoServico;
        public ItemMagicoController()
        {
            this.itemMagicoServico = ServicoDeDependencia.CriarItemMagicoServico();
        }

        public ActionResult Index()
        {
            return View();
        }

        public PartialViewResult CarregarListaComTodosOsItens(int pagina)
        {
            Thread.Sleep(1000);
            IList<ItemMagicoEntidade> todosOsItens = this.itemMagicoServico.BuscarTodos();
            IList<ItemMagicoParaListaViewModel> model = ConverterEmListagemDeItens(todosOsItens);
            return PartialView("_ListagemDeItensMagicos", model);
        }

        public PartialViewResult CarregarListaDeRaros()
        {
            IList<ItemMagicoEntidade> itensRaros = this.itemMagicoServico.BuscarPorRaridade(true);

            IList<ItemMagicoParaListaViewModel> model = ConverterEmListagemDeItens(itensRaros);

            foreach (ItemMagicoParaListaViewModel item in model)
            {
                item.PodeEditar = false;
            }

            return PartialView("_ListagemDeItensMagicos", model);
            
        }
        
        public JsonResult FazNada()
        {
            return Json(new { Mensagem = "Nada!" }, JsonRequestBehavior.AllowGet);
        }

        private IList<ItemMagicoParaListaViewModel> ConverterEmListagemDeItens(IList<ItemMagicoEntidade> itens)
        {
            IList<ItemMagicoParaListaViewModel> model = new List<ItemMagicoParaListaViewModel>();

            foreach (var item in itens)
            {
                model.Add(new ItemMagicoParaListaViewModel(item));
            }

            return model;
        }
    }
}