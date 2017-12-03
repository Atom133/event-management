using EventManagement.Domain.Entities;
using EventManagment.Service.ServiceImplementation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace EventManagement.Web.Controllers
{
    public class OrganizerController : Controller
    {
        // GET: Organizer
        public ActionResult Index()
        {
            OrganizerService evs = new OrganizerService();
           var list =  evs.getFuturEvent();
            List<bool> checkexislist =new List<bool>();
            foreach (var item in list)
            {
                checkexislist.Add(evs.checkpaticipation(item.id,2));
            }
            ViewBag.listCheckParicipation = checkexislist;
            return View(list);
        }

        // GET: Organizer/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Organizer/Create
        public ActionResult Create(int id_event)
        {
            return View();

        }

        // POST: Organizer/Create
        [HttpPost]
        public ActionResult Create(int id_event, EventOrganizer eventOrg)
        {
                OrganizerService orgs = new OrganizerService();
                orgs.ParticipateToAnEvent(id_event, 2, eventOrg);
                TempData["notice"] = "Participatioin to an event Send to President";
                return RedirectToAction("Index");
  
        }

        // GET: Organizer/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Organizer/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Organizer/Delete/5
        public ActionResult Delete(int id)
        {
            OrganizerService orgS = new OrganizerService();
            orgS.removeParticipation(id, 2);
            TempData["notice"] = "Participatioin to an event Successfully deleted";
            return RedirectToAction("Index");
         
        }

        // POST: Organizer/Delete/5
        [HttpPost]
        public ActionResult Delete(FormCollection collection)
        {

            return RedirectToAction("Index");
        }
    }
}
