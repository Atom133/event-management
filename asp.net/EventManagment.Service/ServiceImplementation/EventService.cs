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
    public class EventService : Service<Event>
    {
        private static IDatabaseFactory DF = new DatabaseFactory();
        private static IUnitOfWork UWork = new UnitOfWork(DF);

        public EventService() : base(UWork)
        {


        }





}
}
