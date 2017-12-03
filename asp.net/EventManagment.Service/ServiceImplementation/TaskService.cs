using EventManagement.Data;
using EventManagement.Data.Infrastructure;
using EventManagement.Domain;
using EventManagement.Domain.Entities;
using Service.Pattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Web;

namespace EventManagment.Service.ServiceImplementation
{
    public class TaskService : Service<task>
    {
        private static IDatabaseFactory DF = new DatabaseFactory();
        private static IUnitOfWork UWork = new UnitOfWork(DF);

        public TaskService() : base(UWork)
        {


        }

        public IEnumerable<task> getTasks()
        {
            return UWork.getRepository<task>().GetMany();
        }


        //Tache Avancée join between user and event by id
        public List<user> getOrganizersByenvent(int id_event)
        {

            List<user> organizersOfEvent = new List<user>(); 
              //   var theEvent = UWork.getRepository<Event>().GetById(id_event);
             //utilisateurs des evenements Organisaterus + presidens + 
             // var users = UWork.getRepository<user>().GetMany().Where(u => u.events.Contains(theEvent));
            var participation = UWork.getRepository<EventOrganizer>().GetMany().Where(eo => eo.statutRequest == "accepted")
                .Where(eo => eo.EventId == id_event).ToList();

            if(participation!= null) { 
                    foreach (var item in participation)
                    {
                        organizersOfEvent.Add(UWork.getRepository<user>().GetById(item.organizerId));
                    }
            }

            return organizersOfEvent;

         }


       



        }
}
