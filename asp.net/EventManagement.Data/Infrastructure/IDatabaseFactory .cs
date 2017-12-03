
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventManagement.Data.Infrastructure
{
    public interface IDatabaseFactory : IDisposable
    {
        event_managementContext DataContext { get; }
    }

}
