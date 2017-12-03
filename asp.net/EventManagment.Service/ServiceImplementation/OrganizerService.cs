using EventManagement.Data.Infrastructure;
using EventManagement.Domain;
using EventManagement.Domain.Entities;
using Service.Pattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace EventManagment.Service.ServiceImplementation
{
    public class OrganizerService : Service<EventOrganizer>
    {
        private static IDatabaseFactory DF = new DatabaseFactory();
        private static IUnitOfWork UWork = new UnitOfWork(DF);

        public OrganizerService() : base(UWork)
        {


        }
        public IEnumerable<Event> getFuturEvent()
        {
            return UWork.getRepository<Event>().GetMany()
                .Where(e => DateTime.Compare(e.dateEvent, DateTime.Now) > 0)
                .OrderByDescending(e=> e.dateEvent);
        }

        public void ParticipateToAnEvent(int id_event,int id_organizer, EventOrganizer eventorg)
        {
            List<EventOrganizer> listEventOrg = UWork.getRepository<EventOrganizer>().GetMany().ToList();
            var currentevent = UWork.getRepository<Event>().GetById(id_event);
            var currentOrganizer = UWork.getRepository<user>().GetById(id_organizer);
            bool exist = false;
            foreach (var item in listEventOrg)
            {
                if ((item.EventId == id_event) && (item.organizerId == id_organizer))
                 exist = true; 
            }
            if(exist == false) { 
            eventorg.organizer = currentOrganizer;
            eventorg.myevent = currentevent;
            eventorg.statutRequest = "waiting";
            this.Add(eventorg);
            UWork.Commit();
            }
        }


        public void removeParticipation(int id_event,int id_organizer)
        {
           var  particpation = UWork.getRepository<EventOrganizer>().GetMany()
                .Where(e => e.EventId == id_event)
                .Where(e => e.organizerId == id_organizer)
                .First();
            
            if (particpation != null)
            {
                this.Delete(particpation);
                this.Commit();
            }

        }


        public EventOrganizer getOrganizerOfEvent(int id_organizer)
        {
            return UWork.getRepository<EventOrganizer>().GetById(id_organizer);

        }


         public bool checkpaticipation(int id_event, int id_organizer)
         {

            
             EventOrganizer EventOrg = UWork.getRepository<EventOrganizer>()
                 .GetMany()
                 .Where(e => e.EventId == id_event)
                 .Where(e => e.organizerId == id_organizer).ToList().FirstOrDefault();

             if (EventOrg != null)
             { return true; }

             return false;


         }



    }
}
