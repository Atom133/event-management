
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventManagement.Data.Infrastructure
{
    public class DatabaseFactory : Disposable, IDatabaseFactory
    {
        private event_managementContext dataContext;
        public event_managementContext DataContext
        { get { return dataContext; } }
         
        public DatabaseFactory()
        {
            dataContext = new event_managementContext();
        }
        protected override void DisposeCore()
        {
            if (DataContext != null)
                DataContext.Dispose();
        }
    }

}
