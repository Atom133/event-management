using EventManagement.Data.Infrastructure;
using EventManagement.Domain.Entities;
using EventManagment.Service;
using EventManagment.Service.ServiceImplementation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace EventManagement.Consol
{
    public  class Program
    {
        public static void Main(string[] args)
        {

            IDatabaseFactory DBFactory = new DatabaseFactory();
            IUnitOfWork ut = new UnitOfWork(DBFactory);
            //get all users
            IEnumerable<user> users = ut.getRepository<user>().GetAll();
            //get all invitations database
            IEnumerable<invitation> invitaions = ut.getRepository<invitation>().GetAll();
            //get all events
            IEnumerable<Event> events = ut.getRepository<Event>().GetAll();

            var list = from us in users // table user
                       join invts in invitaions on us.Id equals invts.invitedBy // jointure par id user avec table invitaion  => on
                       join evts in events on invts.event_id equals evts.id// jointure par id  event avec table event  => on
                       where invts.event_id == 4 // critére de selection 
                       select new { us }; //  typede  retour 

            Console.WriteLine(list.Count());

            Console.WriteLine("Done");
            Console.ReadKey();





        }
    }
}
