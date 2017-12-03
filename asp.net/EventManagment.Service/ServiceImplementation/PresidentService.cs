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
    public class PresidentService : Service<EventOrganizer>
    {
        private static IDatabaseFactory DF = new DatabaseFactory();
        private static IUnitOfWork UWork = new UnitOfWork(DF);

        public PresidentService() : base(UWork)
        {


        }
        public List<EventOrganizer> getOrganizersRequest()
        {
            var mylist =  UWork.getRepository<EventOrganizer>().GetMany().Where(e => e.statutRequest == "waiting").ToList();
            foreach (var item in mylist)
            {
                item.myevent = UWork.getRepository<Event>().GetById(item.EventId);
                item.organizer = UWork.getRepository<user>().GetById(item.organizerId);

            }
            return mylist;

        }





        public void AcceptOrganizer(int eventOrganizer_id) {
            var eventOrg = UWork.getRepository<EventOrganizer>().GetById(eventOrganizer_id);
            eventOrg.statutRequest = "accepted";
            this.Update(eventOrg);
            this.Commit();


        }
        public void RefuseOrganizer(int eventOrganizer_id)
        {
            var eventOrg = UWork.getRepository<EventOrganizer>().GetById(eventOrganizer_id);
            eventOrg.statutRequest = "refused";
            this.Update(eventOrg);
            this.Commit();


        }



        public List<EventOrganizer> searchEventParticipant(string eventName)
        {
            IEnumerable<EventOrganizer> participants = UWork.getRepository<EventOrganizer>().GetAll();
            IEnumerable<user> users = UWork.getRepository<user>().GetAll();
            IEnumerable<Event> events = UWork.getRepository<Event>().GetAll();
            List<EventOrganizer> listeventOrg = new List<EventOrganizer>();
            var list = from  us in users
                   join prts in participants on us.Id equals prts.organizerId
                   join evts in events on prts.EventId equals evts.id
                   where evts.name.Contains(eventName)
                   where prts.statutRequest == "waiting"
                   select new { us, prts, evts };

            foreach (var item in list)
            {
                EventOrganizer eventorg = new EventOrganizer();
                eventorg.myevent = UWork.getRepository<Event>().GetById(item.evts.id); 
                eventorg.organizer = UWork.getRepository<user>().GetById(item.us.Id);


                listeventOrg.Add(eventorg);
            }
            return listeventOrg;
        }



    }
}
