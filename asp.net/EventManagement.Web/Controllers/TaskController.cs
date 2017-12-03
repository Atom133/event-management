using EventManagement.Domain.Entities;
using EventManagement.Web.Models;
using EventManagment.Service;
using EventManagment.Service.ServiceImplementation;
using Microsoft.AspNet.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace EventManagement.Web.Controllers
{
    public class TaskController : Controller
    {
        // GET: Task
        public ActionResult Index()
        {
            TaskService tskservice = new TaskService();
            IEnumerable<task> tasks =   tskservice.getTasks();
          
            return View(tasks);
        }

        // GET: Task/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Task/Create
        public ActionResult Create(int id_event)
        {
            TaskService tskservice = new TaskService();
            var listorg = tskservice.getOrganizersByenvent(id_event);

            if (listorg != null)
            {
                ViewBag.listeCategory = new SelectList(listorg, "Id", "firstName");
            }
            return View();
        }

        // POST: Task/Create
        [HttpPost]
        public ActionResult Create(task tsk, int id_event)
        {

            int id_user = Convert.ToInt32(User.Identity.GetUserId());
            tsk.assignBy = id_user;
            tsk.event_id = id_event;
            tsk.statutTask = "waiting";
            tsk.organizer_id = tsk.orderTo;
            if (ModelState.IsValid)
            {
                TaskService tskservice = new TaskService();
                tskservice.Add(tsk);
                tskservice.Commit();
            }
            return RedirectToAction("Index");
   
        }

        // GET: Task/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Task/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
    

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Task/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Task/Delete/5
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
