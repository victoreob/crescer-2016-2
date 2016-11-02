using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Cadastro()
        {
            return View();
        }

        public ActionResult Salvar(FichaTecnicaModel model)
        {
            if (ModelState.IsValid)
                return View("FichaTecnica", model);
            else
                return View("Cadastro", model);
        }
    }
}