using EventManagement.Domain.Entities;
using EventManagement.Web.Models;
using EventManagment.Service.ServiceImplementation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace EventManagement.Web.Controllers
{
    public class PresidentController : Controller
    {

        public ActionResult AcceptOrganizer(int id)
        {
            PresidentService preservice = new PresidentService();
            preservice.AcceptOrganizer(id);
            return RedirectToAction("Index");
        }
        public ActionResult RefuseOrganizer(int id)
        {
            PresidentService preservice = new PresidentService();
            preservice.RefuseOrganizer(id);
            return RedirectToAction("Index");
        }

        // GET: President
        public ActionResult Index()
        {
            var list = new List<Domain.Entities.EventOrganizer>();
            PresidentService orgserv = new PresidentService();
            list = orgserv.getOrganizersRequest();
            ViewBag.list = list;
            return View(list);
        }

        //POST
        [HttpPost]
        public ActionResult Index(string eventName)
        {
            PresidentService orgserv = new PresidentService();
            var list = orgserv.searchEventParticipant(eventName);
            ViewBag.list = list;
            return View(list);
        }


        // GET: President/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: President/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: President/Create
        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: President/Edit/5
        public ActionResult Edit(int id)
        {
 
            return View();
        }

        // POST: President/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {



            return RedirectToAction("Index");
 
        }

        // GET: President/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: President/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
